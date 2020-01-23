package com.mycompany.jst;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afif
 */
public class ClassGambar {
    // Variabel Global
    public ImageIcon SourceIcon; 
    public Image SourceImage;
    public ImageIcon ScaleIcon; 
    public Image ScaleImage;
    public ImageIcon ScaleResultIcon;
    public String URLImage;
    public boolean ScaledFlag=false; 
    public BufferedImage SourceBuffer; 
    public long sWidth;
    public long sHeight;
    public double[] hasilEkstraksi;

    //konstruktor
    ClassGambar(String Url, long width, long height){
        URLImage=Url;
        if(width<=0 ||height <=0)
        {
            ScaledFlag=false;
        }
        else
        {
            ScaledFlag=true;
            sWidth=width;
            sHeight=height;
        }
    }

    public ClassGambar() {

    }


    public ImageIcon GetIcon(){
        if(!URLImage.equals(""))
        {
            SourceIcon = new ImageIcon(URLImage); 
            SourceImage = SourceIcon.getImage();
            try{
                SourceBuffer=ImageIO.read(new File(URLImage));
            }
            catch(IOException x){
                JOptionPane.showMessageDialog(null, x.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
            }
            if(ScaledFlag)
                {
                ScaleImage=SourceImage.getScaledInstance((int)sWidth, (int)sHeight,
                Image.SCALE_DEFAULT);
                ScaleIcon=new ImageIcon(ScaleImage); 
                return ScaleIcon;
                }
            else
            {
                return SourceIcon;
            }
        }
        else
        {
            return null;
        }
    }



    public void Proses(){ 
        
        //pra pemrosesan
        Preprocessing p = new Preprocessing();
            
            //resize gambar
            SourceBuffer = p.resize(SourceBuffer, 100, 100);

            //deteksi tepi
            CannyEdgeDetector detector = new CannyEdgeDetector();
            detector.setLowThreshold(0.5f);
            detector.setHighThreshold(1f);
            detector.setSourceImage(SourceBuffer);
            detector.process();
            BufferedImage edges = detector.getEdgesImage();
            SourceBuffer = edges;
        
            //hasil pra pemrosesan
            Image Result =(Image) SourceBuffer;
            Image ScaleResult =Result.getScaledInstance((int)sWidth, (int)sHeight, Image.SCALE_DEFAULT);
            ScaleResultIcon=new ImageIcon(ScaleResult);

        //ekstraksi fitur
        FeatureExtraction fe = new FeatureExtraction();
        double[] ekstraksi = fe.zoning(p.getPixels(SourceBuffer));
        hasilEkstraksi = ekstraksi;
        System.out.println(Arrays.toString(ekstraksi));
    }

}
