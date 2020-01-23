/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst.LVQ;

/**
 *
 * @author afif
 */
public class Node {
    private double[] x = new double[100];
    private double[] w = new double[100];
    private double[] deltaW = new double[100];
    private double error;
    private int t,c;
    double alpha =0.1;
    double perubahanAlpha=0.5;

    Node(int C) {
        this.c = C;
    }


    public double getBesar(){
        double result = 0;
        for(int i=0; i<x.length; i++){
            result += Math.pow(x[i] - w[i], 2);
        }
        return Math.sqrt(result);
    }

    private double[] kurang(double[] a, double[] b){
        double result[] = new double[a.length];
        for(int i=0; i<a.length; i++){
            result[i] = a[i] - b[i];
        }
        return result;
    }

    private double[] tambah(double[] a, double[] b){
        double result[] = new double[a.length];
        for(int i=0; i<a.length; i++){
            result[i] = a[i] + b[i];
        }
        return result;
    }

    private double[] kali(double a, double[] b){
        double result[] = new double[b.length];
        for(int i=0; i<b.length; i++){
            result[i] = a * b[i];
        }
        return result;
    }

    public void update(){
        if(t == c){
            w = tambah(w, kali(alpha, kurang(x,w)));
        }else{
            w = kurang(w, kali(alpha, kurang(x,w)));
        }
        deltaW = kali(alpha, kurang(x,w));
        error = getMaxDW();
    }

    public void reduceAlpha(){

        alpha = alpha * perubahanAlpha;
    }

    private double getMaxDW() {
        double maxValue = deltaW[0];
        for (int i = 1; i < deltaW.length; i++) {
            if (deltaW[i] > maxValue) {
                maxValue = deltaW[i];
            }
        }
        return maxValue;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public void setW(double[] w) {
        this.w = w;
    }

    public void setT(int t) {
        this.t = t;
    }

    public double getError() {
        return error;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setPerubahanAlpha(double perubahanAlpha) {
        this.perubahanAlpha = perubahanAlpha;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getPerubahanAlpha() {
        return perubahanAlpha;
    }

    public double[] getW() {
        return w;
    }
}

