/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksurveyor;

/**
 *
 * @author Sebastian
 */
public class ClientSurvey extends javax.swing.JFrame {

    ChatClient surveyClient = new ChatClient("", 7777, this);
    
    /**
     * Creates new form ClientSurvey
     */
    public ClientSurvey() {
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

        txtTitle = new javax.swing.JLabel();
        pnlQuestionDetail = new javax.swing.JPanel();
        lblTopic = new javax.swing.JLabel();
        lblQN = new javax.swing.JLabel();
        lblQuestionNum = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblE = new javax.swing.JLabel();
        txtQTopic = new javax.swing.JTextField();
        txtQAnswerA = new javax.swing.JTextField();
        txtQAnswerB = new javax.swing.JTextField();
        txtQAnswerC = new javax.swing.JTextField();
        txtQAnswerD = new javax.swing.JTextField();
        txtQAnswerE = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtQQuestion = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblYourAnswer = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnConnect = new javax.swing.JButton();
        cmbAnswer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTitle.setBackground(new java.awt.Color(255, 153, 0));
        txtTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(0, 0, 0));
        txtTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitle.setText("Survey Questions");
        txtTitle.setName("txtTitle"); // NOI18N
        txtTitle.setOpaque(true);

        pnlQuestionDetail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlQuestionDetail.setName("pnlQuestionDetail"); // NOI18N

        lblTopic.setText("Topic:");
        lblTopic.setName("lblTopic"); // NOI18N

        lblQN.setText("QN:");
        lblQN.setName("lblQN"); // NOI18N

        lblQuestionNum.setText("Question Number");
        lblQuestionNum.setName("lblQuestionNum"); // NOI18N

        lblA.setText("A:");
        lblA.setName("lblA"); // NOI18N

        lblB.setText("B:");
        lblB.setName("lblB"); // NOI18N

        lblC.setText("C:");
        lblC.setName("lblC"); // NOI18N

        lblD.setText("D:");
        lblD.setName("lblD"); // NOI18N

        lblE.setText("E:");
        lblE.setName("lblE"); // NOI18N

        txtQTopic.setName("txtQTopic"); // NOI18N

        txtQAnswerA.setName("txtQAnswerA"); // NOI18N

        txtQAnswerB.setName("txtQAnswerB"); // NOI18N

        txtQAnswerC.setName("txtQAnswerC"); // NOI18N

        txtQAnswerD.setName("txtQAnswerD"); // NOI18N

        txtQAnswerE.setName("txtQAnswerE"); // NOI18N

        txtQQuestion.setColumns(20);
        txtQQuestion.setRows(5);
        txtQQuestion.setName("txtQQuestion"); // NOI18N
        jScrollPane4.setViewportView(txtQQuestion);

        javax.swing.GroupLayout pnlQuestionDetailLayout = new javax.swing.GroupLayout(pnlQuestionDetail);
        pnlQuestionDetail.setLayout(pnlQuestionDetailLayout);
        pnlQuestionDetailLayout.setHorizontalGroup(
            pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestionDetailLayout.createSequentialGroup()
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQuestionDetailLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblB)
                            .addComponent(lblA)
                            .addComponent(lblC)
                            .addComponent(lblD)
                            .addComponent(lblE)
                            .addComponent(lblQN)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuestionDetailLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblQuestionNum)
                            .addComponent(lblTopic))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQTopic)
                    .addComponent(txtQAnswerC)
                    .addComponent(txtQAnswerD)
                    .addComponent(txtQAnswerE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addComponent(txtQAnswerA)
                    .addComponent(txtQAnswerB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlQuestionDetailLayout.setVerticalGroup(
            pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestionDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTopic)
                    .addComponent(txtQTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQuestionDetailLayout.createSequentialGroup()
                        .addComponent(lblQN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblQuestionNum)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblA)
                    .addComponent(txtQAnswerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblB)
                    .addComponent(txtQAnswerB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblC)
                    .addComponent(txtQAnswerC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblD)
                    .addComponent(txtQAnswerD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlQuestionDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblE)
                    .addComponent(txtQAnswerE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblYourAnswer.setText("Your Answer:");
        lblYourAnswer.setToolTipText("");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        cmbAnswer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Answer", "A", "B", "C", "D", "E" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblYourAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConnect)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYourAnswer)
                    .addComponent(btnSubmit)
                    .addComponent(btnExit)
                    .addComponent(btnConnect)
                    .addComponent(cmbAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(pnlQuestionDetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlQuestionDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        surveyClient.connect("localhost", 7777);
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        compileMessage();
    }//GEN-LAST:event_btnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(ClientSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientSurvey().setVisible(true);
            }
        });
    }

    //Method used to compile and send message to be sent
    private void compileMessage()
    {
        int answer;
        String message = "SENTA; ";
        
        //Get Answer value from drop down combo box
        answer = cmbAnswer.getSelectedIndex();
        
        //Get message string from fields on screen
        message += lblQuestionNum.getText() + "; ";
        message += answer + "; ";
      
        
        surveyClient.send(message);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubmit;
    public javax.swing.JComboBox<String> cmbAnswer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel lblA;
    public javax.swing.JLabel lblB;
    public javax.swing.JLabel lblC;
    public javax.swing.JLabel lblD;
    public javax.swing.JLabel lblE;
    public javax.swing.JLabel lblQN;
    public javax.swing.JLabel lblQuestionNum;
    public javax.swing.JLabel lblTopic;
    private javax.swing.JLabel lblYourAnswer;
    private javax.swing.JPanel pnlQuestionDetail;
    public javax.swing.JTextField txtQAnswerA;
    public javax.swing.JTextField txtQAnswerB;
    public javax.swing.JTextField txtQAnswerC;
    public javax.swing.JTextField txtQAnswerD;
    public javax.swing.JTextField txtQAnswerE;
    public javax.swing.JTextArea txtQQuestion;
    public javax.swing.JTextField txtQTopic;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
