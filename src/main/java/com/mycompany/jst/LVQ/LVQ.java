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
public class LVQ {
    private Node[] kelas = new Node[40];
    private double[] besar = new double[40];
    int epoch;
    double alpha;
    double lastAlpha;
    double perubahanAlpha;
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
        }

        //Mengurangi Learning Rate
        for (Node kela : kelas) {
            kela.reduceAlpha();
        }

        while(lastAlpha >= 4.0E-32){
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
                hasil = "Hotel";
            }else if (pemenang == 1){
                hasil = "Bandara";
            }else if (pemenang == 2){
                hasil = "Disabilitas";
            }else if (pemenang == 3){
                hasil = "Stadion";
            }else if (pemenang == 4){
                hasil = "Keberangkatan Pesawat";
            }else if (pemenang == 5){
                hasil = "Pengawasan Kamera";
            }else if (pemenang == 6){
                hasil = "Pom Bensin";
            }else if (pemenang == 7){
                hasil = "Restoran";
            }else if (pemenang == 8){
                hasil = "Toliet Pria";
            }else if (pemenang == 9){
                hasil = "Toilet Wanita";
            }else if (pemenang == 10){
                hasil = "Salon";
            }else if (pemenang == 11){
                hasil = "Pasar";
            }else if (pemenang == 12){
                hasil = "Museum";
            }else if (pemenang == 13){
                hasil = "Kemah";
            }else if (pemenang == 14){
                hasil = "Kafe";
            }else if (pemenang == 15){
                hasil = "Eskalator";
            }else if (pemenang == 16){
                hasil = "Bus";
            }else if (pemenang == 17){
                hasil = "Tunggu";
            }else if (pemenang == 18){
                hasil = "Loket/Resepsionis";
            }else if (pemenang == 19){
                hasil = "Penukaran Uang";
            }else if (pemenang == 20){
                hasil = "Parkir Sepeda";
            }else if (pemenang == 21){
                hasil = "Informasi";
            }else if (pemenang == 22){
                hasil = "Petunjuk Arah";
            }else if (pemenang == 23){
                hasil = "ATM";
            }else if (pemenang == 24){
                hasil = "Ruang Rapat";
            }else if (pemenang == 25){
                hasil = "Penitipan Barang";
            }else if (pemenang == 26){
                hasil = "Daur Ulang";
            }else if (pemenang == 27){
                hasil = "Telepon";
            }else if (pemenang == 28){
                hasil = "Taksi";
            }else if (pemenang == 29){
                hasil = "Pos Surat";
            }else if (pemenang == 30){
                hasil = "Parkir Mobil";
            }else if (pemenang == 31){
                hasil = "Pemeriksaan Barang";
            }else if (pemenang == 32){
                hasil = "Area Merokok";
            }else if (pemenang == 33){
                hasil = "Toilet Unisex";
            }else if (pemenang == 34){
                hasil = "Kafetaria/Bar";
            }else if (pemenang == 35){
                hasil = "Helikopter";
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
