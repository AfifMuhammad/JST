/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst;

import com.mycompany.jst.Backpro.BP;
import com.mycompany.jst.Backpro.Data;
import com.mycompany.jst.LVQ.LVQ;
import java.util.Arrays;
import javax.swing.JFileChooser;

/**
 *
 * @author afif
 */
public class Tampilan extends javax.swing.JFrame {

    /**
     * Creates new form Tampilan
     */
    public ClassGambar gambar;
    public Tampilan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPilih = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPreprocessing = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btn_lvq = new javax.swing.JButton();
        tf_hasil = new javax.swing.JTextField();
        bt_backpro = new javax.swing.JButton();
        tf_backpro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_alpha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_hiddenLayer = new javax.swing.JTextField();
        bt_train = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPilih.setText("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnPreprocessing.setText("PraProses");
        btnPreprocessing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreprocessingActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btn_lvq.setText("LVQ");
        btn_lvq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lvqActionPerformed(evt);
            }
        });

        bt_backpro.setText("Backprop");
        bt_backpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backproActionPerformed(evt);
            }
        });

        jLabel3.setText("Laju Pembelajaran");

        jLabel4.setText("Layer Tersembunyi");

        bt_train.setText("Train");
        bt_train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_trainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPilih)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPreprocessing)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_alpha))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_lvq)
                                .addGap(28, 28, 28)
                                .addComponent(tf_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_hiddenLayer, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 79, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bt_train, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_backpro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_backpro)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnPilih)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnPreprocessing))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tf_hiddenLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(bt_train)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_lvq)
                    .addComponent(tf_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_backpro)
                    .addComponent(tf_backpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // TODO add your handling code here:
        JFileChooser TDialog= new JFileChooser();
        if(TDialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            gambar = new ClassGambar(TDialog.getSelectedFile().getAbsolutePath(),100,100);
            jLabel1.setIcon(gambar.GetIcon());
        }
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnPreprocessingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreprocessingActionPerformed
        // TODO add your handling code here:
        gambar.Proses();
        jLabel2.setIcon(gambar.ScaleResultIcon);
        jTextArea1.setText(Arrays.toString(gambar.hasilEkstraksi));
    }//GEN-LAST:event_btnPreprocessingActionPerformed

    private void btn_lvqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lvqActionPerformed
        // TODO add your handling code here:
        double[] uji = gambar.hasilEkstraksi;
        LVQ l = new LVQ();
        l.setAlpha(Double.valueOf(tf_alpha.getText()));
        l.train();
        tf_hasil.setText(l.getHasil(uji));
    }//GEN-LAST:event_btn_lvqActionPerformed

    BP bp = new BP();
    
    private void bt_backproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backproActionPerformed
        // TODO add your handling code here:
//        b.setAlfa(Double.valueOf(tf_alpha.getText()));
//        b.setUnit_hidden(Integer.valueOf(tf_hiddenLayer.getText()));
//        b.init_static();
//        b.learn_static();
//        b.test(gambar.hasilEkstraksi);
//        tf_backpro.setText(b.kesimpulan());
        double x[][]=Data.pola;
        //inisialisasi target
        double t[]={0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1,0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1};
        //inisialisasi bias pada unit hidden
        double v0[]={2.0772945479910354, -4.770426249247557};
        //inisialisasi bobot pada input-hidden
        double v[][]={{-1.4985254656271656, 2.0087090680137454}, {-6.831902011751655, 8.805569471133092}, {-0.5975820824143312, 0.5873814771685602}, {6.962767130221249, -7.73623314166061}, {-12.089975875150932, 14.446894791223412}, {-18.67518485129543, 23.368600608905602}, {6.5080145420008275, -6.591352117798022}, {-6.849384585511635, 8.799846645395995}, {-1.321695415119929, 1.458588850709938}, {-0.5245479129757256, 1.8733516304209237}, {-8.52196966904375, 11.114233126746559}, {-20.795916179304633, 24.225161439330325}, {2.3715183755972724, -3.6596782085648316}, {14.026514655968665, -14.81787255599874}, {-9.177703255731798, 9.61608148706218}, {11.94516234226993, -11.22205270538607}, {7.0478149532487855, -3.570770950655385}, {-47.97360089614217, 58.68490596788083}, {16.999430699221605, -17.753225462906826}, {-2.636365269710489, 4.997502139470529}, {-2.587771914849085, 3.1524447076426556}, {-26.749558831795646, 32.29717756437318}, {2.8349196131463392, -4.863975690754226}, {14.910488559785644, -19.44784145080739}, {-3.6589177626199323, 1.7701952889496664}, {2.879394589307862, -3.5217772959890477}, {-22.409534451763076, 30.08279812813787}, {5.325613352246675, -2.037353928393712}, {-16.502744242956428, 19.731471040395387}, {4.0716507279270235, -3.419990358882203}, {10.161706938994076, -11.677439805063939}, {-9.9084662599093, 10.03604636767873}, {4.265638476959265, -4.907547808156314}, {-34.190372182687454, 35.80074879523025}, {-2.594004030785214, 4.236800239814353}, {-11.704113159577473, 14.822365061030633}, {4.419170212472234, -0.8162689441996993}, {-23.084845318563218, 30.844876523482906}, {18.036699593627155, -17.655523695350833}, {-3.1882633303112304, 4.158588033311101}, {9.23379005379326, -9.581417584895876}, {-5.3617338242578265, 6.672147863273167}, {-17.26680688796799, 18.671343597768427}, {6.041501976138603, -9.717832025360996}, {-2.555081870174243, 3.9256700073894204}, {-60.49820015369709, 71.92485663152462}, {3.9083047271100404, 1.0402615349930526}, {28.890000530065933, -29.8002289706816}, {6.4188988942693115, -3.369986429201563}, {-2.2944383849505874, 3.591371521028173}, {-9.091750726322877, 11.183523477659984}, {11.675825811378786, -11.706953729113568}, {-15.85746288488799, 17.177003221999655}, {9.635301428167567, -9.412117002280569}, {-23.061653910092065, 25.686136567270218}, {3.299222533609489, -7.25903721584671}, {-14.868442110599196, 17.28505451711413}, {8.051199178569256, -6.888076475453107}, {-3.187683839726826, 5.170763579589914}, {13.756723098751252, -15.560446860512386}, {-13.266840010336994, 15.642098722626171}, {-5.544864670508584, 7.515735585618831}, {-20.12773301330416, 25.14717080919872}, {-5.721426287207751, 9.382130466598962}, {-6.967407583991692, 6.144015394535472}, {14.587883522528946, -20.604029167353147}, {0.5739888730636369, 4.833997957580226}, {-33.34651072462911, 39.95881529661457}, {-2.2727052184992895, 6.193032468258802}, {2.282718583068204, -1.7135788277457877}, {19.774395470678478, -22.042952447831155}, {-28.976533761557196, 35.13775217758325}, {18.004713946893503, -19.305876461487383}, {-28.66688630301197, 33.87245376586168}, {-4.364076480722381, 3.346253702976006}, {-27.93861230025699, 32.04510115907662}, {-23.359822229119384, 27.97527363502659}, {-0.6790648065565897, 2.659970043253875}, {-21.676055020560582, 27.702810045230965}, {-2.0427204382675277, 3.5724200254613816}, {0.8718049065544318, 0.11432369856465596}, {54.898519748605864, -61.25235531280535}, {11.380575824795448, -12.889200770254716}, {12.10291775160088, -12.433982788294433}, {18.02233348821539, -17.796231379595177}, {22.56990715535836, -24.368831805776775}, {-9.062937943224673, 12.95831129268499}, {10.995739066468438, -11.394163320885081}, {-28.568142801183765, 34.089113825412575}, {-3.560281689116736, 4.8971169548592375}, {-3.0156654537731216, 3.952486738719713}, {0.3962792951700148, -0.2133610405915263}, {-4.423853098802169, 6.327691147556669}, {-4.281680354013693, 6.146115020964306}, {-4.936316077317363, 7.0326484840459855}, {11.428511891789329, -12.707123430004216}, {-3.0126455039005684, 4.15282754540474}, {4.8699035935816495, -4.915962600389234}, {5.346364908551285, -4.917883030111385}, {-1.070216407310727, 1.4063921332813765}};
        //inisialisasi bias pada unit output
        double w0[]={6.9151653203030685};
        //inisialisasi bobot pada hidden-output
        double w[][]={{76.30989997602792}, {-87.80504046539147}};
        double[] test = gambar.hasilEkstraksi;
        
        
        bp.test(test,v0,v,w0,w,t);
        tf_backpro.setText(bp.getHasil());
    }//GEN-LAST:event_bt_backproActionPerformed

    private void bt_trainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_trainActionPerformed
        // TODO add your handling code here:
        //inisialisasi data mentah
        double x[][]=Data.pola;
        //inisialisasi target
        double t[]={0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1,0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1};
        //inisialisasi bias pada unit hidden
        double v0[]={0.318946,0.12234};
        //inisialisasi bobot pada input-hidden
        double v[][]=new double[100][2];
        for (int i=0; i<100; i++){
            v[i][0] = Math.random();
            v[i][1] = Math.random();
        }
        //inisialisasi bias pada unit output
        double w0[]={0.41180};
        //inisialisasi bobot pada hidden-output
        double w[][]={{0.33960},{0.43333}};

        //proses learning
        bp.learn(x,v0,v,w0,w,t);
    }//GEN-LAST:event_bt_trainActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampilan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_backpro;
    private javax.swing.JButton bt_train;
    private javax.swing.JButton btnPilih;
    private javax.swing.JButton btnPreprocessing;
    private javax.swing.JButton btn_lvq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField tf_alpha;
    private javax.swing.JTextField tf_backpro;
    private javax.swing.JTextField tf_hasil;
    private javax.swing.JTextField tf_hiddenLayer;
    // End of variables declaration//GEN-END:variables
}
