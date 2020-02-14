/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst.Backpro;

import com.mycompany.jst.Data;
import com.mycompany.jst.Tampilan;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author afif
 */
public class Backpropagation implements Runnable{

    public Backpropagation() {
    }
    
    double alpha;
    double teta;
    boolean stop = false;
    double[][] x = Data.pola;
    int jml_hidden=13;
    int jml_output = 6;
    double z_net[] = new double[jml_hidden];
    double y_net[] = new double[jml_output];
    double z[] = new double[jml_hidden];
    double y[] = new double[jml_output];
    double bias_z[] = new double[jml_hidden];
    double bias_y[] = new double[jml_output];
    double[][] v = new double[x[0].length][z.length];
    double[][] w = new double[z.length][y.length];
    double target[][]={
      {-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,1},
      {-1,-1,-1,-1,1,-1},
      {-1,-1,-1,-1,1,1},
      {-1,-1,-1,1,-1,-1},
      {-1,-1,-1,1,-1,1},
      {-1,-1,-1,1,1,-1},
      {-1,-1,-1,1,1,1},
      {-1,-1,1,-1,-1,-1},
      {-1,-1,1,-1,-1,1},
      {-1,-1,1,-1,1,-1},
      {-1,-1,1,-1,1,1},
      {-1,-1,1,1,-1,-1},
      {-1,-1,1,1,-1,1},
      {-1,-1,1,1,1,-1},
      {-1,-1,1,1,1,1},
      {-1,1,-1,-1,-1,-1},
      {-1,1,-1,-1,-1,1},
      {-1,1,-1,-1,1,-1},
      {-1,1,-1,-1,1,1},
      {-1,1,-1,1,-1,-1},
      {-1,1,-1,1,-1,1},
      {-1,1,-1,1,1,-1},
      {-1,1,-1,1,1,1},
      {-1,1,1,-1,-1,-1},
      {-1,1,1,-1,-1,1},
      {-1,1,1,-1,1,-1},
      {-1,1,1,-1,1,1},
      {-1,1,1,1,-1,-1},
      {-1,1,1,1,-1,1},
      {-1,1,1,1,1,-1},
      {-1,1,1,1,1,1},
      {1,-1,-1,-1,-1,-1},
      {1,-1,-1,-1,-1,1},
      {1,-1,-1,-1,1,-1},
      {1,-1,-1,-1,1,1},
      {1,-1,-1,1,-1,-1},
      {1,-1,-1,1,-1,1},
      {1,-1,-1,1,1,-1},
      {1,-1,-1,1,1,1},
      {-1,-1,-1,-1,-1,-1},
      {-1,-1,-1,-1,-1,1},
      {-1,-1,-1,-1,1,-1},
      {-1,-1,-1,-1,1,1},
      {-1,-1,-1,1,-1,-1},
      {-1,-1,-1,1,-1,1},
      {-1,-1,-1,1,1,-1},
      {-1,-1,-1,1,1,1},
      {-1,-1,1,-1,-1,-1},
      {-1,-1,1,-1,-1,1},
      {-1,-1,1,-1,1,-1},
      {-1,-1,1,-1,1,1},
      {-1,-1,1,1,-1,-1},
      {-1,-1,1,1,-1,1},
      {-1,-1,1,1,1,-1},
      {-1,-1,1,1,1,1},
      {-1,1,-1,-1,-1,-1},
      {-1,1,-1,-1,-1,1},
      {-1,1,-1,-1,1,-1},
      {-1,1,-1,-1,1,1},
      {-1,1,-1,1,-1,-1},
      {-1,1,-1,1,-1,1},
      {-1,1,-1,1,1,-1},
      {-1,1,-1,1,1,1},
      {-1,1,1,-1,-1,-1},
      {-1,1,1,-1,-1,1},
      {-1,1,1,-1,1,-1},
      {-1,1,1,-1,1,1},
      {-1,1,1,1,-1,-1},
      {-1,1,1,1,-1,1},
      {-1,1,1,1,1,-1},
      {-1,1,1,1,1,1},
      {1,-1,-1,-1,-1,-1},
      {1,-1,-1,-1,-1,1},
      {1,-1,-1,-1,1,-1},
      {1,-1,-1,-1,1,1},
      {1,-1,-1,1,-1,-1},
      {1,-1,-1,1,-1,1},
      {1,-1,-1,1,1,-1},
      {1,-1,-1,1,1,1},
  };
    
    private double sigmoid_biner(double x) {
        return (1.0 / (1.0 + Math.exp(-x)));
    }

    private double sigmoid_bipolar(double x) {
        return (2 * sigmoid_biner(x)) - 1;
    }

    private double turunan_sigmoid_bipolar(double x) {
        return 0.5 * (1 + sigmoid_bipolar(x)) * (1 - sigmoid_bipolar(x));
    }
    
    public void train(){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
         
        //inisialisasi bobot layer input-hidden
        for (byte j = 0; j < z.length; j++) {
            for (byte i = 0; i < x[0].length; i++) {
                v[i][j] = Math.random();
            }
        }

        //inisialisasi bias ke layer hidden
        for (byte j = 0; j < z.length; j++) {
            bias_z[j] = Math.random();
        }

        //inisialisasi bobot layer hidden-output
        for (byte j = 0; j < y.length; j++) {
            for (byte i = 0; i < z.length; i++) {
                w[i][j] = Math.random();
            }
        }

        //inisialisasi bias ke layer output
        for (byte j = 0; j < y.length; j++) {
            bias_y[j] = Math.random();
        }

        double err = 0;
        double mse = 0;
        int epoch = 1;
        boolean ada_error = false;
        do {
            System.out.println("=====Epoch -> " + epoch);

            mse = 0;
            ada_error = false;
            for (byte k = 0; k < x.length; k++) {
                //feed-forward layer input-hidden
                for (byte j = 0; j < z.length; j++) {
                    z_net[j] = 0;
                    for (byte i = 0; i < x[k].length; i++) {
                        z_net[j] += (x[k][i] * v[i][j]);
                    }
                    z_net[j] += bias_z[j];
                    z[j] = sigmoid_bipolar(z_net[j]);
                }

                //feed-forward layer hidden-output
                for (byte j = 0; j < y.length; j++) {
                    y_net[j] = 0;
                    for (byte i = 0; i < z.length; i++) {
                        y_net[j] += (z[i] * w[i][j]);
                    }
                    y_net[j] += bias_y[j];
                    y[j] = sigmoid_bipolar(y_net[j]);
                }

                //hitung error output
                //hitung koreksi bobot hidden-output
                err = 0;
                double[] delta = new double[y.length];
                for (byte j = 0; j < y.length; j++) {
                    double e = target[k][j] - y[j];
                    //System.out.println("error node ke-"+(j+1)+"=" + e);
                    err += Math.pow(e, 2);
                    //err += Math.abs(e);
                    delta[j] = e * turunan_sigmoid_bipolar(y_net[j]);
                    //System.out.println("delta="+delta[j]);
                }

                //err /= jml_output;
                err *= 0.5;
                //if (err>teta) ada_error=true;
                mse += (err * err);
                //mse += err;
                //System.out.println("Error pola ke-" + (k + 1) + " -> " + err);
                //tf_error.setText(String.valueOf(err));
                //if (err > teta) {
                //stop = false;
                //}

                //update bobot layer hidden-output
                for (byte j = 0; j < y.length; j++) {
                    for (byte i = 0; i < z.length; i++) {
                        w[i][j] += (alpha * delta[j] * z[i]);
                        //System.out.println("w["+i+"]["+j+"]="+w[i][j]);
                    }
                    bias_y[j] += (alpha * delta[j]);
                    //System.out.println("bias_y["+j+"]="+bias_y[j]);
                }

                //hitung koreksi bobot input-hidden
                double[] delta2 = new double[z.length];
                for (byte j = 0; j < z.length; j++) {
                    double error_hidden = 0;
                    for (byte i = 0; i < y.length; i++) {
                        error_hidden += (delta[i] * w[j][i]);
                    }
                    delta2[j] = error_hidden * turunan_sigmoid_bipolar(z_net[j]);
                    //System.out.println("delta2="+delta2[j]);
                }

                //update bobot layer input-hidden
                for (byte j = 0; j < z.length; j++) {
                    for (byte i = 0; i < x[k].length; i++) {
                        v[i][j] += (alpha * delta2[j] * x[k][i]);
                        //System.out.println("v["+i+"]["+j+"]="+v[i][j]);
                    }
                    bias_z[j] += (alpha * delta2[j]);
                    //System.out.println("bias_z["+j+"]="+bias_z[j]);
                }
            }
            mse /= x.length;
            System.out.println("MSE=" + mse);

            epoch++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tampilan.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (mse > teta && !stop);

    }

    public void setJml_hidden(int jml_hidden) {
        this.jml_hidden = jml_hidden;
    }

    public void setAlfa(double alpha) {
        this.alpha = alpha;
    }

    public void setTeta(double teta) {
        this.teta = teta;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
    
}
