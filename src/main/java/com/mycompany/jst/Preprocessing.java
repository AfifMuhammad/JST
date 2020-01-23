/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author afif
 */
public class Preprocessing {
    
    public BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    public BufferedImage Biner(BufferedImage img){ 
        long tWidth=img.getWidth(); long tHeight=img.getHeight();
        long x,y;
        int RGB,Red,Green,Blue,Gray;
        Color tWarna;
        BufferedImage resultImg=img;
        for(x=0;x<tWidth;x++)
        {
            for(y=0;y<tHeight;y++)
            {
                RGB=img.getRGB((int)x, (int)y);
                tWarna=new Color(RGB);
                Red=tWarna.getRed();
                Green=tWarna.getGreen();
                Blue=tWarna.getBlue();
                Gray=(Red+Green+Blue)/3;
                if (Gray<=128)
                {
                   Gray=0;
                }
                else
                {
                    Gray=255;
                }
                tWarna=new Color(Gray,Gray,Gray);
                resultImg.setRGB((int)x, (int)y, tWarna.getRGB());
            }
        }
        return resultImg;
    }
    
    public int[][] getPixels(BufferedImage img){
        long tWidth=img.getWidth(); 
        long tHeight=img.getHeight();
        long x,y;
        int RGB,Red,Green,Blue,Gray;
        Color tWarna; 
        int[][] pixels = new int[100][100];
        for(x=0;x<tWidth;x++)
        {
            for(y=0;y<tHeight;y++)
            {   
                RGB=img.getRGB((int)x, (int)y);
                tWarna=new Color(RGB);
                Red=tWarna.getRed();
                Green=tWarna.getGreen();
                Blue=tWarna.getBlue();
                Gray=(Red+Green+Blue)/3;
                if(Gray == 0){
                    pixels[(int)y][(int)x] = 1;
                }else if(Gray == 255){
                    pixels[(int)y][(int)x] = 0;
                }
            }
        }
        //System.out.println((Arrays.deepToString(pixels)));
        return pixels;
    }
}
