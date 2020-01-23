/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author afif
 */
public class FeatureExtraction {
    
    public double[] zoning(int[][] pixels){
        double zona[] = new double[100];
        double total = 0;
        double hasil[] = new double[100];
        int temp= 0;
        int index = 0;
        for (int c=0; c<100; c+=10){
            for (int d=0; d<100; d+=10){
                int ii = c+10;
                for (int i=c; i<ii; i++){
                    int jj = d+10;
                    for (int j=d; j<jj; j++){
                        temp += pixels[i][j];
                    }
                }
                total += temp;
                zona[index] = temp;
                temp=0;
                index++;
            }
        }
        for(int i=0; i<hasil.length; i++){
            hasil[i] = round(zona[i]/total, 4);
        }
        return hasil;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
