/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst.Backpro;

import com.mycompany.jst.Data;
import java.util.Arrays;

/**
 *
 * @author afif
 */
public class Backprop {
    //------ input
  // Jumlah data
  int jumlah_data=80;
  // Unit Input 2
  int unit_input=100;
  // Unit Hidden 2
  int unit_hidden=2;
  // Unit Output 1
  int unit_output=1;
  
  //data latih
  double x[][]=Data.pola;
  //target
  double t[]={0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1,0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1};
 
  final double alfa=0.001;
  final double stopping=0.15;
  
  //------ hidden
  //Unit input pada Hidden (z_in)
   double z_in[]=new double[unit_hidden];
  //Input pada Hidden (z)
   double z[]=new double[z_in.length];
 
  //Bias pada unit Hidden (bH)
   double v0[]={2.002019248951987, -4.832009126771318};
  //Delta Bias pada unit Hidden (bHx)  --- untuk perbaikan bias Hidden
   double v0x[]=new double[v0.length];
  //Bobot antara Input-HIdden (v)
   double v[][]={{-1.4820055811127408, 1.9614641709211271}, {-7.1440122439698435, 9.165846087513897}, {-0.3596610076566986, 0.25925152066513835}, {7.085796798460627, -7.903809016413258}, {-12.405433333758332, 14.811660666831994}, {-19.445793568415382, 24.29176614149134}, {6.082674158908839, -6.095132165488402}, {-6.888182904279705, 8.822379260609463}, {-1.323207465809655, 1.4388491239822552}, {-0.3073217905290347, 1.5829271077440585}, {-9.076451382342174, 11.76979461735432}, {-19.880507709602153, 23.036762510847595}, {2.1072550625026323, -3.538750984285962}, {12.777052540584625, -13.22628144769825}, {-8.679329058386939, 9.023882566531958}, {11.757377293046234, -10.95775658797807}, {7.670343590780869, -4.360096044265367}, {-47.95990880379997, 58.75814597980357}, {18.615758461936565, -19.665460704879173}, {-2.5741204448404575, 4.912744138269451}, {-3.133181696614224, 3.797234910433261}, {-26.704727453907108, 32.13508816339539}, {2.783834974678832, -4.802901542283732}, {15.851108488291011, -20.452047802778214}, {-5.842501240499701, 4.408190848758363}, {2.3513164194369414, -2.934704879033442}, {-22.845868807735606, 30.89103883296055}, {6.720270789035873, -3.548345033240713}, {-16.772148809839614, 20.090015359744626}, {3.7037162554804635, -2.974123683547822}, {10.732927056079802, -12.402628177670278}, {-9.706358438185724, 9.760681376201738}, {3.431544789961232, -4.060780305656814}, {-33.23565192650848, 34.381483465580594}, {-0.77129707993257, 1.7393676083626715}, {-11.897445830547785, 14.940410593149627}, {2.7593848813738724, 1.514050156177479}, {-23.163962980445813, 31.100103022309483}, {16.228256553437642, -15.401360821017176}, {-3.5445671622691624, 4.5746877150665215}, {10.078703539625824, -10.633920469665094}, {-6.070260656390965, 7.562725683733512}, {-16.448835891733392, 17.454050358918355}, {5.417381735104618, -9.126452679830654}, {-4.60386868434068, 6.38719542005343}, {-60.14038740258611, 71.64185133520871}, {3.9284612472557594, 1.3196474415277808}, {27.595029040292445, -28.140945612736836}, {7.591470772123699, -4.6672109008185805}, {-2.3257672193152814, 3.6097039191968467}, {-8.763892781878708, 10.770371676298579}, {11.924402291912003, -11.926057197244342}, {-16.061355244948093, 17.232044631830362}, {10.128965546643249, -9.954204529888695}, {-24.797357778836062, 27.595849143052448}, {4.335971527731378, -8.619115874822732}, {-16.5570549256297, 19.447831941527404}, {9.767529156995344, -8.903252267254008}, {-3.3375534412530197, 5.5173877544549565}, {14.007914251881289, -15.886253419342276}, {-12.79096139983813, 15.048266743629625}, {-6.189483417242032, 8.426949623906241}, {-19.0834398649135, 23.981115887599746}, {-4.8094703526084865, 8.333825546856035}, {-7.378053985283932, 6.579396867601343}, {13.740326020158633, -19.57703320301188}, {0.9903802702588169, 4.45098947834081}, {-34.26675825847615, 41.17080916064225}, {-2.5533466361486195, 6.542161629810411}, {2.5779640650724764, -2.0894730127267205}, {19.398578049125373, -21.573037910470617}, {-27.535924215281547, 33.47000268597717}, {14.939221829508359, -15.73488818812225}, {-28.30382545404484, 33.49293670614982}, {-4.805027373014561, 3.587226163563181}, {-25.964905015090462, 29.51900506435118}, {-25.128138892330373, 30.170795241314295}, {0.9601516199268333, 0.7377058837413951}, {-20.610322707562958, 26.467307420315937}, {-1.9785011270239834, 3.472928364156319}, {0.7105654444342842, 0.29712528093981805}, {55.7825075725229, -62.263134696309905}, {11.926809410602432, -13.59674486923753}, {10.966748225368576, -11.023503145525625}, {19.590534101068815, -19.57076272920814}, {22.275736359149057, -23.982450661851697}, {-11.977598341634987, 16.544310042172224}, {13.487179859966334, -14.392776928504253}, {-27.84100078421612, 33.190381744911704}, {-3.434326123057072, 4.719716959768215}, {-2.9204206872683423, 3.80584934462498}, {0.39478415134790235, -0.23257232594821137}, {-4.3956853548677755, 6.276315304456283}, {-4.389726038653414, 6.26262048774908}, {-4.972815058272359, 7.062525845143781}, {12.05122845144773, -13.494724301554077}, {-2.8866899378409046, 3.975427550305787}, {4.95028428273811, -5.036786944424436}, {5.537511503407102, -5.1768627890767585}, {-0.8674956784593574, 1.133670416781277}};
  //Delta Bobot antara Input-HIdden (vx) --- untuk perbaikan  bobot Input-Hidden
   double vx[][]=new double[v.length][v[0].length];
 
  //Kesalahan pada setelah Hidden (Err_z)
   double Err_in[]=new double[unit_hidden];
  //Kesalahan pada Hidden (Err_z)
   double Err_z[]=new double[unit_hidden];
 
  //------ output
  //Unit Output pada Output (y_in)
   double y_in[]=new double[unit_output];
  //Output pada Output (y)
   double y[]=new double[y_in.length];
 
  //Bias pada unit Output (bO)
   double w0[]={6.898605181511006};
  //Delta Bias pada unit Output (bOx)  ---- untuk perbaikan bias pada Output
   double w0x[]=new double[w0.length];
  //Bobot antara Hidden-Output <img class="wp-smiley emoji" draggable="false" alt="(w)" src="https://s0.wp.com/wp-content/mu-plugins/wpcom-smileys/wordpress.svg" style="height: 1em; max-height: 1em;" width="16" height="16">
   double w[][]={{76.42539240704671}, {-87.91726029764953}};
  //Delta Bobot antara Hidden-Output (wx) --- untuk perbaikan bobot Hidden-Output
   double wx[][]=new double[w.length][w[0].length];
 
  //Kesalahan pada Ouput (Err_y)
   double Err_y[]=new double[unit_output];
 
  //------------- aha
  //Minimum Error Kuadrat ERR
   double ERR;
   
   //konstruktor
   public Backprop(){
   }
   
   //penentuan berhenti atau lanjut
  double cekStop(){
    double akumY=0;
    //~ itung z_in dan z
    for(int h=0; h<jumlah_data; h++){
     for(int j=0; j<unit_hidden; j++){
      //itung sigma xi vij
      double jum_xv=0;
      for(int i=0; i<unit_input; i++){
         double cc=x[h][i]*v[i][j];
         jum_xv=jum_xv+cc;
         //System.out.println(x[h][j]);
      }
      z_in[j]=v0[j]+jum_xv;
      //itung z
      z[j]=1/(1+(double)Math.exp(-z_in[j]));
      //System.out.println(" dan z= "+z[j]);
     }
 
     //~ itung y_in dan y     (output)
      double cxc=0;
      for(int k=0; k<unit_output; k++){
        double jum_zw=0;
        for(int j=0; j<unit_hidden; j++){
          double cc=z[j]*w[j][k];
          jum_zw=jum_zw+cc;
        }
        y_in[k]=w0[k]+jum_zw;
        y[k]=1/(1+(double)Math.exp(-y_in[k]));
        akumY = akumY + Math.pow((t[h]-y[k]),2);
        //System.out.println(t[h]+"-"+y[k]+"="+(t[k]-y[k]));
      }
    }
    double E = 0.5 * akumY;
    //System.out.println(E);
    return E;
  }
  
  public void learn(){
    do{
      //~ itung z_in dan z
      for(int h=0; h<jumlah_data; h++){
        for(int j=0; j<unit_hidden; j++){
          //itung sigma xi vij
          double jum_xv=0;
          for(int i=0; i<unit_input; i++){
            double cc=x[h][i]*v[i][j];
            jum_xv=jum_xv+cc;
          }
          z_in[j]=v0[j]+jum_xv;
          //itung z
          z[j]=1/(1+(double)Math.exp(-z_in[j]));
        }
 
        //~ itung y_in dan y     (output)
        double cxc=0;
        for(int k=0; k<unit_output; k++){
          double jum_zw=0;
          for(int j=0; j<unit_hidden; j++){
            double cc=z[j]*w[j][k];
            jum_zw=jum_zw+cc;
          }
          y_in[k]=w0[k]+jum_zw;
          y[k]=1/(1+(double)Math.exp(-y_in[k]));
          //System.out.println(y[k]);
        }
        //System.out.println(y[0]);
 
        //ngitung error output dan delta bias dan delta bobot
        for(int k=0; k<unit_output; k++){
          //error otput
          Err_y[k]=(t[h]-y[k])*y[k]*(1-y[k]);
          //System.out.println(Err_y[k]);
 
          double  cc=0;
          for(int j=0; j<unit_hidden; j++){
            //delta bobot hO
            wx[j][k]=alfa*Err_y[k]*z[j];
            //delta bias hO
            w0x[k]=alfa*Err_y[k];
            //System.out.println("delta wx = "+wx[j][k]);
          }
          //System.out.println("delta w0 = "+w0x[k]);
        }
 
        //ngitung error hiden dan delta bias dan delta bobot
        for(int j=0; j<unit_hidden; j++){
          double cc=0;
          for(int k=0; k<unit_output; k++){
            cc = cc + (Err_y[k]*w[j][k]);
          }
          // eror sebelum output / setelah hidden
          Err_in[j]=cc;
          //System.out.println(Err_in[j]);
 
          // eror hidden               (t[h]-y[k])*y[k]*(1-y[k]);
          Err_z[j]=Err_in[j]*(z[j])*(1-z[j]);
          //System.out.println(Err_z[j]);
 
          for(int i=0; i<unit_input; i++){
            //delta bobot iH
            vx[i][j]=alfa*Err_z[j]*x[h][i];
            //System.out.println("delta vx = "+vx[i][j]);
          }
          //delta bias  hidden
          v0x[j]=alfa*Err_z[j];
          //System.out.println("delta v0 = "+v0x[j]);
          //System.out.println(alfa+" "+Err_z[j]+" "+v0x[j]);
        }
 
        //update bobot dan bias
        //update bobot bias outpuut
        for(int j=0; j<unit_hidden; j++){
          for(int k=0; k<unit_output; k++){
            w[j][k]=w[j][k]+wx[j][k];
            //w0[k]=w0[k]+w0x[k];
            //System.out.println("w = "+w[j][k]);
          }
        }
        for(int k=0; k<unit_output; k++){
          //w[j][k]=w[j][k]+wx[j][k];
          w0[k]=w0[k]+w0x[k];
          //System.out.println("w0 = "+w0[k]);
        }
 
        //update bobot bias hidden
        for(int i=0; i<unit_input; i++){
          for(int j=0; j<unit_hidden; j++){
            v[i][j]=v[i][j]+vx[i][j];
            //v0[j]=v0[j]+v0x[j];
            //System.out.println("v = "+v[i][j]);
          }
        }
 
        for(int j=0; j<unit_hidden; j++){
          //v[i][j]=v[i][j]+vx[i][j];
          v0[j]=v0[j]+v0x[j];
          //System.out.println("v0 = "+v0[j]);
        }
      }
      System.out.println(" => "+cekStop());
    }while(cekStop()>stopping);
 
 
    /// bagian ini untuk ngeprint doang...
    /// jadi dihapus gpp
 
    System.out.println("w = "+Arrays.deepToString(w));
    System.out.println("v = "+Arrays.deepToString(v));
    System.out.println("w0 = "+Arrays.toString(w0));
    System.out.println("v0 = "+Arrays.toString(v0));
  }
  
  public String test(double inputan[])
  {
      String x="";
    //pada hidden
    for(int j=0; j<unit_hidden; j++)
    {
      double cc=0;
      for(int i=0; i<inputan.length; i++){
        cc= cc + (inputan[i]*v[i][j]);
      }
      z_in[j] = v0[j] +cc;
      z[j] = 1/(1+(double)Math.exp(-z_in[j]));
    }
 
    //pada ouotpr
    for(int k=0; k<unit_output; k++){
      double cc = 0;
      for(int j=0; j<unit_hidden; j++){
        cc = cc + z[j]*w[j][k];
      }
      y_in[k] = w0[k]+cc;
 
      double y = 1/(1+(double)Math.exp(-y_in[k]));
 
//      if(y>0.5)
//       y=1;
//      else
//       y=0;
      System.out.println("Output "+y);
      
      double h = y;
        if(h<0.025){
            x = "Adam";
        }else if (h<0.05){
            x = "Ahmad";
        }else if (h<0.075){
            x = "Ais";
        }else if (h<0.1){
            x = "Arif";
        }else if (h<0.125){
            x = "Ayuk";
        }else if (h<0.15){
            x = "Bayu";
        }else if (h<0.175){
            x = "Beni";
        }else if (h<0.2){
            x = "Cici";
        }else if (h<0.225){
            x = "Dani";
        }else if (h<0.25){
            x = "Doni";
        }else if (h<0.275){
            x = "Fahrul";
        }else if (h<0.3){
            x = "Hani";
        }else if (h<0.325){
            x = "Hanum";
        }else if (h<0.35){
            x = "Heri";
        }else if (h<0.375){
            x = "Iis";
        }else if (h<0.4){
            x = "Ila";
        }else if (h<0.425){
            x = "Irfan";
        }else if (h<0.45){
            x = "Maman";
        }else if (h<0.475){
            x = "Mar";
        }else if (h<0.5){
            x = "Maya";
        }else if (h<0.525){
            x = "Muftia";
        }else if (h<0.55){
            x = "Nafi";
        }else if (h<0.575){
            x = "Nisa";
        }else if (h<0.6){
            x = "Oki";
        }else if (h<0.625){
            x = "Ozi";
        }else if (h<0.65){
            x = "Ratih";
        }else if (h<0.675){
            x = "Rian";
        }else if (h<0.7){
            x = "Riko";
        }else if (h<0.725){
            x = "Rio";
        }else if (h<0.75){
            x = "Rotul";
        }else if (h<0.775){
            x = "Sopyan";
        }else if (h<0.8){
            x = "Susi";
        }else if (h<0.825){
            x = "Tami";
        }else if (h<0.85){
            x = "Tyas";
        }else if (h<0.875){
            x = "Wina";
        }else if (h<0.9){
            x = "Zila";
        }else if (h<0.925){
            x = "Yani";
        }else if (h<0.95){
            x = "Yuni";
        }else if (h<0.975){
            x = "Zila";
        }else if (h<1){
            x = "Ziya";
        }
    }
    return x;
  }
}
