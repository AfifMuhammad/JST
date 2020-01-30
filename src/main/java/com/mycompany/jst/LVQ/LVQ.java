/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst.LVQ;

import com.mycompany.jst.Data;
import java.util.Arrays;

/**
 *
 * @author afif
 */
public class LVQ {
    private Node[] kelas = new Node[40];
    private double[] besar = new double[40];
    int epoch;
    double alpha;
    double lastAlpha;
    double perubahanAlpha=0.5;
    double[][] bobot = new double[40][100];
    String[] hasilUji = new String[40];

    private double[][] pola = Data.pola;
    //private double[][] dataUji = DataUji.dataUji;
//
//    public void inisialisasiBobot(){
//        for(int i=0; i<kelas.length; i++){
//            kelas[i] = new Node(i+1);
//            kelas[i].setW(BobotAkhir.bobot[i]);
//        }
//    }

    public void train(){
        epoch = 0;
        for(int i=0; i<kelas.length; i++){
            kelas[i] = new Node(i+1);
            kelas[i].setW(pola[i]);
            kelas[i].setAlpha(alpha);
            kelas[i].setPerubahanAlpha(perubahanAlpha);
        }
        lastAlpha = alpha;
        System.out.println(kelas[1].getAlpha()+", "+kelas[1].getPerubahanAlpha()+", "+epoch);

        int pemenang;

        for(int a=0; a<40; a++){
            for (Node kela : kelas) {
                kela.setX(pola[a + 40]);
            }
            for(int i=0; i<kelas.length;i++){
                besar[i] = kelas[i].getBesar();
            }

            pemenang = getPemenang();
            kelas[pemenang].setT(a+1);
            kelas[pemenang].update();
            //System.out.println(Arrays.toString(kelas[pemenang].getW()));
        }

        //Mengurangi Learning Rate
        for (Node kela : kelas) {
            kela.reduceAlpha();
        }

        while(epoch < 1000){
            for(int a=0; a<80; a++){
                for (Node kela : kelas) {
                    kela.setX(pola[a]);
                }
                for(int i=0; i<kelas.length;i++){
                    besar[i] = kelas[i].getBesar();
                }
                
                pemenang = getPemenang();
                kelas[pemenang].setT((a%40)+1);
                kelas[pemenang].update();
            }

            //Mengurangi Learning Rate
            for (Node kela : kelas) {
                kela.reduceAlpha();
                lastAlpha = kela.alpha;
            }

            epoch++;
        }
        
    }


    public String getHasil(double[] input){
        int pemenang;
        String hasil = "N/A";

        for (Node kela : kelas) {
            kela.setX(input);
        }
        for(int i=0; i<kelas.length;i++){
            besar[i] = kelas[i].getBesar();
        }

        pemenang = getPemenang();
        System.out.println(pemenang);

        if(kelas[pemenang].getBesar()>0.15){
            hasil = "Tidak Dikenali";
        }else{
            if(pemenang == 0){
                hasil = "Adam";
            }else if (pemenang == 1){
                hasil = "Ahmad";
            }else if (pemenang == 2){
                hasil = "Ais";
            }else if (pemenang == 3){
                hasil = "Arif";
            }else if (pemenang == 4){
                hasil = "Ayuk";
            }else if (pemenang == 5){
                hasil = "Bayu";
            }else if (pemenang == 6){
                hasil = "Beni";
            }else if (pemenang == 7){
                hasil = "Cici";
            }else if (pemenang == 8){
                hasil = "Dani";
            }else if (pemenang == 9){
                hasil = "Dian";
            }else if (pemenang == 10){
                hasil = "Doni";
            }else if (pemenang == 11){
                hasil = "Fahrul";
            }else if (pemenang == 12){
                hasil = "Hani";
            }else if (pemenang == 13){
                hasil = "Hanum";
            }else if (pemenang == 14){
                hasil = "Heri";
            }else if (pemenang == 15){
                hasil = "Iis";
            }else if (pemenang == 16){
                hasil = "Ila";
            }else if (pemenang == 17){
                hasil = "Irfan";
            }else if (pemenang == 18){
                hasil = "Maman";
            }else if (pemenang == 19){
                hasil = "Mar";
            }else if (pemenang == 20){
                hasil = "Maya";
            }else if (pemenang == 21){
                hasil = "Muftia";
            }else if (pemenang == 22){
                hasil = "Nafi";
            }else if (pemenang == 23){
                hasil = "Nisa";
            }else if (pemenang == 24){
                hasil = "Oki";
            }else if (pemenang == 25){
                hasil = "Ozi";
            }else if (pemenang == 26){
                hasil = "Ratih";
            }else if (pemenang == 27){
                hasil = "Rian";
            }else if (pemenang == 28){
                hasil = "Riko";
            }else if (pemenang == 29){
                hasil = "Rio";
            }else if (pemenang == 30){
                hasil = "Rotul";
            }else if (pemenang == 31){
                hasil = "Sopyan";
            }else if (pemenang == 32){
                hasil = "Susi";
            }else if (pemenang == 33){
                hasil = "Tami";
            }else if (pemenang == 34){
                hasil = "Tyas";
            }else if (pemenang == 35){
                hasil = "Wina";
            }else if (pemenang == 36){
                hasil = "Yani";
            }else if (pemenang == 37){
                hasil = "Yuni";
            }else if (pemenang == 38){
                hasil = "Zila";
            }else if (pemenang == 39){
                hasil = "Ziya";
            }
        }


        return hasil;
    }

//    public String[] uji(){
//        for(int i=0; i<dataUji.length; i++){
//            int pemenang;
//            String hasil = "N/A";
//
//            for (Node kela : kelas) {
//                kela.setX(dataUji[i]);
//            }
//            for(int j=0; j<kelas.length;j++){
//                besar[j] = kelas[j].getBesar();
//            }
//
//            pemenang = getPemenang();
//            hasilUji[i] = String.valueOf(pemenang)+" = "+kelas[pemenang].getBesar();
//        }
//        return hasilUji;
//    }

    private int getPemenang() {
        double minValue = besar[0];
        int kelas = 0;
        for (int i = 1; i < besar.length; i++) {
            if (besar[i] < minValue) {
                minValue = besar[i];
                kelas = i;
            }
        }
        return kelas;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setPerubahanAlpha(double perubahanAlpha) {
        this.perubahanAlpha = perubahanAlpha;
    }

    public double getPerubahanAlpha() {
        return perubahanAlpha;
    }

    public double[][] getBobot(){
        for(int i=0; i<kelas.length; i++){
            bobot[i] = kelas[i].getW();
        }
        return bobot;
    }
}
