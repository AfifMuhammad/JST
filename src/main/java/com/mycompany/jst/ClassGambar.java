package com.mycompany.jst;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public Image ResultImage; 
public Image ScaleResultImage;
public ImageIcon ScaleResultIcon;
public String URLImage;
public boolean ScaledFlag=false; 
public BufferedImage SourceBuffer; 
public BufferedImage ResultBuffer; 
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
        SourceBuffer = resize(SourceBuffer, 100, 100);
    }
    catch(IOException x){
        JOptionPane.showMessageDialog(null, x.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
    }
    
    System.out.println(SourceIcon.getIconWidth());
    if(ScaledFlag)
        {
        ScaleImage=SourceImage.getScaledInstance((int)sWidth, (int)sHeight,
        Image.SCALE_DEFAULT);
        ScaleIcon=new ImageIcon(ScaleImage); 
        System.out.println(ScaleIcon.getIconHeight()+", "+ScaleIcon.getIconWidth());
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

public void gaussian(){
    ResultBuffer=deepCopy(SourceBuffer);
  //  long tWidth=ResultBuffer.getWidth();
    //long tHeight=ResultBuffer.getHeight();
    double factor =1.0;
    double bias=0.0;
    
    float[] identityKernel ={
    1, 2, 1,
    2, 4, 2,
    1, 2, 1};
    
        BufferedImageOp op=new ConvolveOp(new Kernel(3,3,identityKernel));
        BufferedImage filteredImage=new BufferedImage(SourceBuffer.getWidth(),SourceBuffer.getHeight(),SourceBuffer.getType());
        op.filter(SourceBuffer, filteredImage);
        
        ResultImage=filteredImage;
        ScaleResultImage=ResultImage.getScaledInstance((int)sWidth , (int)sHeight , 
            Image.SCALE_DEFAULT);
        ScaleResultIcon=new ImageIcon(ScaleResultImage);
}
   
//fungsi Grayscale
public void Grayscale(){ 
    ResultBuffer=deepCopy(SourceBuffer);
    long tWidth=ResultBuffer.getWidth(); 
    long tHeight=ResultBuffer.getHeight();
    long x,y;
    int RGB,Red,Green,Blue,Gray;
    Color tWarna; 
    for(x=0;x<tWidth;x++)
    {
        for(y=0;y<tHeight;y++)
        {   
            RGB=ResultBuffer.getRGB((int)x, (int)y);
            tWarna=new Color(RGB);
            Red=tWarna.getRed();
            Green=tWarna.getGreen();
            Blue=tWarna.getBlue();
            Gray=(Red+Green+Blue)/3;
            tWarna=new Color(Gray,Gray,Gray);
            ResultBuffer.setRGB((int)x, (int)y, tWarna.getRGB());
        }
    }
    ResultImage=(Image) ResultBuffer;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
    Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
}

public void Biner(){ 
    ResultBuffer=deepCopy(SourceBuffer);
    long tWidth=ResultBuffer.getWidth(); long tHeight=ResultBuffer.getHeight();
    long x,y;
    int RGB,Red,Green,Blue,Gray;
    Color tWarna; 
    for(x=0;x<tWidth;x++)
    {
        for(y=0;y<tHeight;y++)
        {
            RGB=ResultBuffer.getRGB((int)x, (int)y);
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
            ResultBuffer.setRGB((int)x, (int)y, tWarna.getRGB());
        }
    }
    ResultImage=(Image) ResultBuffer;
    ScaleResultImage=ResultImage.getScaledInstance((int)sWidth, (int)sHeight,
    Image.SCALE_DEFAULT);
    ScaleResultIcon=new ImageIcon(ScaleResultImage);
} 

public int[][] getPixels(){
    long tWidth=ResultBuffer.getWidth(); 
    long tHeight=ResultBuffer.getHeight();
    long x,y;
    int RGB,Red,Green,Blue,Gray;
    Color tWarna; 
    int[][] pixels = new int[100][100];
    for(x=0;x<tWidth;x++)
    {
        for(y=0;y<tHeight;y++)
        {   
            RGB=ResultBuffer.getRGB((int)x, (int)y);
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

public ImageIcon Proses(){ 
    Biner();
    double[] ekstraksi = zoning(getPixels());
    hasilEkstraksi = ekstraksi;
    System.out.println(Arrays.toString(ekstraksi));
    return ScaleResultIcon;
}

static BufferedImage deepCopy(BufferedImage bi){ 
    ColorModel cm=bi.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied(); 
    WritableRaster raster = bi.copyData(null);
    return new BufferedImage(cm,raster,isAlphaPremultiplied,null);
}

private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
}

// File representing the folder that you select using a FileChooser
    static final File dir = new File("/home/afif/Pictures/brg/");

    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp", "JPG", "jpg"
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public void loadData(int R, int G, int B) {
        int[] rgb = new int[3]; 
        if (dir.isDirectory()) { // make sure it's a directory
            int index=0;
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(f);
                    img = resize(img,120,120);
                    // you probably want something more involved here
                    // to display in your UI
                } catch (final IOException e) {
                    // handle errors here
                }
                
            }
            
        }
        System.out.println("image: ");
    }

}
