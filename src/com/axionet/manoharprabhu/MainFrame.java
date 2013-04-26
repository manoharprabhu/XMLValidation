/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axionet.manoharprabhu;

import java.awt.Frame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.*;
import org.apache.xmlbeans.impl.tool.StreamInstanceValidator;
/**
 *
 * @author
 * javadeveloper
 */
public class MainFrame extends javax.swing.JFrame {
    
    public class Worker extends SwingWorker<String, String>{

        @Override
        protected String doInBackground() throws Exception {
            if(inputXML.getText().isEmpty()) {
            JOptionPane.showMessageDialog(f, "Please select an XML file for validation", "Select XML",JOptionPane.ERROR_MESSAGE);
        }
        else  if(inputXSD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(f, "Please select an XSD file for performing validation", "Select XSD",JOptionPane.ERROR_MESSAGE);
        } 
        else {
            
             if(!inputXML.getText().subSequence(inputXML.getText().length()-3, inputXML.getText().length()).toString().toLowerCase().equals("xml")) {
                 JOptionPane.showMessageDialog(f, "Only XML files allowed for validation", "Select XML",JOptionPane.ERROR_MESSAGE);
                 return null;
             }
             if(!inputXSD.getText().subSequence(inputXSD.getText().length()-3, inputXSD.getText().length()).toString().toLowerCase().equals("xsd")) {
                 JOptionPane.showMessageDialog(f, "Please provide a valid XSD file", "Select XSD",JOptionPane.ERROR_MESSAGE); 
                 return null;
             }
             
            
              
            ArrayList<String> ar = new ArrayList<>();
            ar.add(inputXSD.getText().toString());
            ar.add(inputXML.getText().toString());
            //switch to enable network downloads for dependant XSDs
            ar.add("-dl");
            
            //Set printstream to print all the system.out to the text box on GUI
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);
           
         publish(String.valueOf("start progress"));
         //Validate XML using XMLBeans
            StreamInstanceValidator.main(ar.toArray(new String[ar.size()]));
         publish(String.valueOf("end progress"));   
            outputText.setText(baos.toString());
     
            }
            return null;
        }
        
        @Override
        protected void process(List<String> item) {
            if(item.get(0).equals("start progress")) {
        progressBar.setIndeterminate(true);
            }
            else {
                 progressBar.setIndeterminate(false);
                 progressBar.setValue(100);
            }
    }
        
    }

    /**
     * Creates
     * new
     * form
     * MainFrame
     */
    public MainFrame() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputXML = new javax.swing.JTextField();
        chooseXML = new javax.swing.JButton();
        XMLLabel = new javax.swing.JLabel();
        XSLLabel = new javax.swing.JLabel();
        inputXSD = new javax.swing.JTextField();
        chooseXSD = new javax.swing.JButton();
        validateXML = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputText = new javax.swing.JTextArea();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputXML.setEditable(false);
        inputXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputXMLMouseClicked(evt);
            }
        });

        chooseXML.setText("Choose");
        chooseXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseXMLActionPerformed(evt);
            }
        });

        XMLLabel.setText("XML file :");

        XSLLabel.setText("XSD File:");

        inputXSD.setEditable(false);
        inputXSD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputXSDMouseClicked(evt);
            }
        });

        chooseXSD.setText("Choose");
        chooseXSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseXSDActionPerformed(evt);
            }
        });

        validateXML.setText("Start validation");
        validateXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateXMLActionPerformed(evt);
            }
        });

        outputText.setEditable(false);
        outputText.setColumns(20);
        outputText.setLineWrap(true);
        outputText.setRows(5);
        outputText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(outputText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(XMLLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(XSLLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputXML, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chooseXML))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(validateXML, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(inputXSD, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chooseXSD)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(XMLLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputXML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseXML))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseXSD)
                    .addComponent(inputXSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XSLLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(validateXML)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pickXMLFile() {
         final JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(this);
        
        if (ret == JFileChooser.APPROVE_OPTION) {
           
   inputXML.setText(fc.getSelectedFile().getAbsolutePath());
     
        }
    }
    
      private void pickXSDFile() {
         final JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(this);
        
        if (ret == JFileChooser.APPROVE_OPTION) {
           
   inputXSD.setText(fc.getSelectedFile().getAbsolutePath());
     
        }
    }
      
    private void chooseXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseXMLActionPerformed
      this.pickXMLFile();
    }//GEN-LAST:event_chooseXMLActionPerformed

    private void inputXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputXMLMouseClicked
        this.pickXMLFile();
    }//GEN-LAST:event_inputXMLMouseClicked

    private void inputXSDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputXSDMouseClicked
       this.pickXSDFile(); 
    }//GEN-LAST:event_inputXSDMouseClicked

    private void chooseXSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseXSDActionPerformed
        this.pickXSDFile(); 
    }//GEN-LAST:event_chooseXSDActionPerformed

    
    
    private void validateXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateXMLActionPerformed

        new Worker().execute();
    }//GEN-LAST:event_validateXMLActionPerformed
 
    
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
    private static Frame f;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel XMLLabel;
    private javax.swing.JLabel XSLLabel;
    private javax.swing.JButton chooseXML;
    private javax.swing.JButton chooseXSD;
    private javax.swing.JTextField inputXML;
    private javax.swing.JTextField inputXSD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputText;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton validateXML;
    // End of variables declaration//GEN-END:variables
}
