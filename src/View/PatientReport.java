/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controll.DeletedPatient;
import Controll.Navigator;
import Controll.PatientQueueController;
import Controll.PrescriptionStore;
import Controll.PatientHistory;
import javax.swing.JOptionPane;

/**
 *
 * @author upash
 */
public class PatientReport extends javax.swing.JPanel {
 private final String patientId;
private final javax.swing.undo.UndoManager undo = new javax.swing.undo.UndoManager();

    public PatientReport(String patientId) {
        this.patientId = patientId;
        initComponents();
        setReadOnly();
        
        loadDeletedPatients();
    }

    public PatientReport() {
        this.patientId = "";
        initComponents();
        setReadOnly();
        loadDeletedPatients();
    }

    private void setReadOnly() {
        
        DeletePatient.setEditable(false);
    }

                
    private void loadDeletedPatients() {
        String text = DeletedPatient.getInstance().getAllAsText();
        DeletePatient.setText(text.isEmpty() ? "No deleted patients." : text);
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag) {
            
            loadDeletedPatients();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DeletePatient = new javax.swing.JTextArea();
        lblDeletedPatient = new javax.swing.JLabel();
        Undo = new javax.swing.JButton();

        setBackground(new java.awt.Color(219, 245, 244));
        setEnabled(false);
        setFocusable(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel2.setText("Patient Report");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        DeletePatient.setColumns(20);
        DeletePatient.setRows(5);
        jScrollPane2.setViewportView(DeletePatient);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 480, 430));

        lblDeletedPatient.setBackground(new java.awt.Color(219, 245, 244));
        lblDeletedPatient.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        lblDeletedPatient.setText("Deleted patient");
        add(lblDeletedPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        add(Undo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        // TODO add your handling code here:
      boolean ok = PatientQueueController.getInstance().undoLastDeletedPatient();
    if (!ok) {
        JOptionPane.showMessageDialog(this, "Nothing to undo!");
        return;
    }
    loadDeletedPatients();
    JOptionPane.showMessageDialog(this, "Undo successful! Patient restored.");
    }//GEN-LAST:event_UndoActionPerformed
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DeletePatient;
    private javax.swing.JButton Undo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDeletedPatient;
    // End of variables declaration//GEN-END:variables
}
