/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networksurveyor;

import java.util.ArrayList;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sebas
 */
public class SurveyManager extends javax.swing.JFrame {

    //Global Variables
    NetworkSurveyor ns = new NetworkSurveyor();
    MyModel globalTableModel = new MyModel();
    
    
    //<editor-fold defaultstate="collapsed" desc="System Generated Code -- INCLUDING MAIN()">
    
    /**
     * Creates new form SurveyManager
     */
    public SurveyManager() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuestionSelector = new javax.swing.JTable();
        txtTableTitle = new javax.swing.JLabel();
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
        btnSendQuestion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblSortBy = new javax.swing.JLabel();
        btnSortQN = new javax.swing.JButton();
        btnSortTopic = new javax.swing.JButton();
        btnSortQuestion = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblLinkedList = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtLinkedList = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        lblBinaryTree = new javax.swing.JLabel();
        btnDisplayBinaryTree = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtBinaryTree = new javax.swing.JTextArea();
        txtTitle = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblPreOrder = new javax.swing.JLabel();
        btnDisplayPreOrder = new javax.swing.JButton();
        btnSavePreOrder = new javax.swing.JButton();
        lblInOrder = new javax.swing.JLabel();
        btnDisplayInOrder = new javax.swing.JButton();
        btnSaveInOrder = new javax.swing.JButton();
        lblPostOrder = new javax.swing.JLabel();
        btnDisplayPostOrder = new javax.swing.JButton();
        btnSavePostOrder = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        tblQuestionSelector.setModel(setTableModel());
        tblQuestionSelector.setName("tblQuestionSelector"); // NOI18N
        tblQuestionSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuestionSelectorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuestionSelector);

        txtTableTitle.setText("Survey Questions");
        txtTableTitle.setName("lblSurveyQuestions"); // NOI18N

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

        btnSendQuestion.setText("Send");
        btnSendQuestion.setName("btnSendQuestion"); // NOI18N

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
                    .addComponent(btnSendQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendQuestion)
                .addContainerGap())
        );

        lblSortBy.setText("Sort By:");
        lblSortBy.setName("lblSortBy"); // NOI18N

        btnSortQN.setText("QN#");
        btnSortQN.setName("btnSortQN#"); // NOI18N
        btnSortQN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortQNActionPerformed(evt);
            }
        });

        btnSortTopic.setText("Topic");
        btnSortTopic.setName("btnSortTopic"); // NOI18N
        btnSortTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortTopicActionPerformed(evt);
            }
        });

        btnSortQuestion.setText("Question");
        btnSortQuestion.setName("btnSortQuestion"); // NOI18N
        btnSortQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortQuestionActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setName("btnExit"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSortBy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSortQN, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSortTopic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSortQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSortBy)
                    .addComponent(btnSortQN)
                    .addComponent(btnSortTopic)
                    .addComponent(btnSortQuestion)
                    .addComponent(btnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblLinkedList.setText("Linked List:");
        lblLinkedList.setName("lblLinkedList"); // NOI18N

        txtLinkedList.setColumns(20);
        txtLinkedList.setRows(5);
        txtLinkedList.setName("txtLinkedList"); // NOI18N
        jScrollPane5.setViewportView(txtLinkedList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblLinkedList)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblLinkedList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblBinaryTree.setText("Binary Tree:");
        lblBinaryTree.setName("lblBinaryTree"); // NOI18N

        btnDisplayBinaryTree.setText("Display");
        btnDisplayBinaryTree.setName("btnDisplayBinaryTree"); // NOI18N

        txtBinaryTree.setColumns(20);
        txtBinaryTree.setRows(5);
        txtBinaryTree.setName("txtBinaryTree"); // NOI18N
        jScrollPane6.setViewportView(txtBinaryTree);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblBinaryTree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDisplayBinaryTree)
                .addContainerGap())
            .addComponent(jScrollPane6)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDisplayBinaryTree)
                    .addComponent(lblBinaryTree, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtTitle.setBackground(new java.awt.Color(255, 153, 0));
        txtTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(0, 0, 0));
        txtTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitle.setText("Survey By Network");
        txtTitle.setName("txtTitle"); // NOI18N
        txtTitle.setOpaque(true);

        lblPreOrder.setText("Pre-Order");
        lblPreOrder.setName("lblPre-Order"); // NOI18N

        btnDisplayPreOrder.setText("Display");
        btnDisplayPreOrder.setName("btnDisplayPre-Order"); // NOI18N

        btnSavePreOrder.setText("Save");
        btnSavePreOrder.setName("btnSavePre-Order"); // NOI18N

        lblInOrder.setText("In-Order");
        lblInOrder.setName("lblIn-Order"); // NOI18N

        btnDisplayInOrder.setText("Display");
        btnDisplayInOrder.setName("btnDisplayIn-Order"); // NOI18N

        btnSaveInOrder.setText("Save");
        btnSaveInOrder.setName("btnSaveIn-Order"); // NOI18N

        lblPostOrder.setText("Post-Order");
        lblPostOrder.setName("lblPost-Order"); // NOI18N

        btnDisplayPostOrder.setText("Display");
        btnDisplayPostOrder.setName("btnDisplayPost-Order"); // NOI18N

        btnSavePostOrder.setText("Save");
        btnSavePostOrder.setName("btnSavePost-Order"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnDisplayPreOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSavePreOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262)
                .addComponent(btnDisplayInOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveInOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(btnDisplayPostOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSavePostOrder)
                .addGap(80, 80, 80))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblPreOrder)
                .addGap(372, 372, 372)
                .addComponent(lblInOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPostOrder)
                .addGap(127, 127, 127))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreOrder)
                    .addComponent(lblInOrder)
                    .addComponent(lblPostOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisplayPreOrder)
                    .addComponent(btnSavePreOrder)
                    .addComponent(btnDisplayInOrder)
                    .addComponent(btnSaveInOrder)
                    .addComponent(btnDisplayPostOrder)
                    .addComponent(btnSavePostOrder))
                .addGap(0, 39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlQuestionDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(txtTableTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTableTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlQuestionDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblQuestionSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuestionSelectorMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblQuestionSelector.getSelectedRow();
        DisplayQuestion(selectedRow);
    }//GEN-LAST:event_tblQuestionSelectorMouseClicked

    private void btnSortQNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortQNActionPerformed
        bubbleSortQN();
    }//GEN-LAST:event_btnSortQNActionPerformed

    private void btnSortTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortTopicActionPerformed
        selctionSortTopic();
    }//GEN-LAST:event_btnSortTopicActionPerformed

    private void btnSortQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortQuestionActionPerformed
        insertionSortQuestion();
    }//GEN-LAST:event_btnSortQuestionActionPerformed

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
            java.util.logging.Logger.getLogger(SurveyManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SurveyManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SurveyManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SurveyManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SurveyManager().setVisible(true);
            }
        });
        
    }
    
    //</editor-fold>
    
    //Method called when setting up table
    //Returns JTable Model for table
    public MyModel setTableModel()
    {
        globalTableModel = ns.getTableModel();
        return globalTableModel;
    }
    
    //Method called when line in table is selected
    //Responsible for assinging question values to right pane
    public void DisplayQuestion(int row)
    {
        //Bring over questionList array from NetworkSurveyor
        ArrayList<Question> questionList = ns.getQuestionListFromMemory();
        //Assign currentQuestion to selected question
        Question currentQuestion = questionList.get(row);
        //Assign txt fields to display question fields
        txtQQuestion.setText(currentQuestion.question);
        txtQTopic.setText(currentQuestion.topic);
        lblQuestionNum.setText(currentQuestion.number);
        txtQAnswerA.setText(currentQuestion.answerA);
        txtQAnswerB.setText(currentQuestion.answerB);
        txtQAnswerC.setText(currentQuestion.answerC);
        txtQAnswerD.setText(currentQuestion.answerD);
        txtQAnswerE.setText(currentQuestion.answerE);
    }
    
    //Run when QN# button is pressed
    //Used to sort question data by question number element
    public void bubbleSortQN()
    {
        //Bring over questionList array from NetworkSurveyor
        ArrayList<Question> questionList = ns.getQuestionListFromMemory();
        
        //Begin Sorting
        for(int j=0; j<questionList.size(); j++)
        {
            for (int i = j+1; i < questionList.size(); i++) 
            {
                int comparisonResult = Integer.compare(Integer.parseInt(questionList.get(i).getNumber()), Integer.parseInt(questionList.get(j).getNumber()));
                if(comparisonResult>0)
                {
                    Question tempQuestion = new Question();
                    tempQuestion = questionList.get(i);
                    questionList.set(i, questionList.get(j));
                    questionList.set(j, tempQuestion);
                }
            }
        }
        //Tell table model that the data has changed
        globalTableModel.fireTableDataChanged();
    }

    //Run when Topic button is pressed
    //Used to sort question data by topic element
    public void selctionSortTopic()
    {
        ArrayList<Question> masterList = ns.getQuestionListFromMemory();
        int n = masterList.size();
        
        for(int i = 0; i < n - 1; i++)
        {
     
            // Find the minimum element in unsorted array
            int min_index = i;
            String minStr = masterList.get(i).getTopic();

            for(int j = i + 1; j < n; j++)
            {

                /*compareTo() will return a -ve value,
                if string1 (arr[j]) is smaller than string2 (minStr)*/
                // If arr[j] is smaller than minStr

                if(masterList.get(j).getTopic().compareTo(minStr) < 0)
                {
                    // Make arr[j] as minStr and update min_idx
                    minStr = masterList.get(j).getTopic();
                    min_index = j;
                }
            }

            // Swapping the minimum element
            // found with the first element.
            if(min_index != i)
            {
                Question temp = masterList.get(min_index);
                masterList.set(min_index, masterList.get(i));
                //arr[min_index] = arr[i];
                masterList.set(i, temp);
                //arr[i] = temp;
            }
        }
        globalTableModel.fireTableDataChanged();
    }       
    
    //Run when Question button is pressed
    //Used to sort question data by question element
    public void insertionSortQuestion()
    {
        ArrayList<Question> masterList = ns.getQuestionListFromMemory();
        
        Boolean sortingRequired = false;
        
        for (int i = 0; i < masterList.size() - 1; i++) 
        {
            Question baseQuestion = masterList.get(i+1);
            
            for (int j = i; j >= 0; j--) 
            {
                Question comparisonQuestion = masterList.get(j);
                
                if (baseQuestion.getQuestion().compareToIgnoreCase(comparisonQuestion.getQuestion()) < 0)
                {
                    sortingRequired = true;
                }
            }
            
            if (sortingRequired) 
            {
                int indexOfBaseQuestion = masterList.indexOf(baseQuestion);
                int sortedIndex = 0;
                
                for (int z = indexOfBaseQuestion; z >= 0; z--) 
                {
                    Question comparisonQuestion = masterList.get(z);
                    
                    if (baseQuestion.getQuestion().compareToIgnoreCase(comparisonQuestion.getQuestion()) < 0) 
                    {
                        sortedIndex = masterList.indexOf(comparisonQuestion);
                        Question temp = masterList.get(sortedIndex);
                        masterList.set(sortedIndex, baseQuestion);
                        masterList.set(indexOfBaseQuestion, temp);
                        indexOfBaseQuestion --;
                        baseQuestion = masterList.get(indexOfBaseQuestion);
                    }
                }
            }
            sortingRequired = false;
        }
        globalTableModel.fireTableDataChanged();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDisplayBinaryTree;
    public javax.swing.JButton btnDisplayInOrder;
    public javax.swing.JButton btnDisplayPostOrder;
    public javax.swing.JButton btnDisplayPreOrder;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnSaveInOrder;
    public javax.swing.JButton btnSavePostOrder;
    public javax.swing.JButton btnSavePreOrder;
    public javax.swing.JButton btnSendQuestion;
    public javax.swing.JButton btnSortQN;
    public javax.swing.JButton btnSortQuestion;
    public javax.swing.JButton btnSortTopic;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel lblA;
    public javax.swing.JLabel lblB;
    public javax.swing.JLabel lblBinaryTree;
    public javax.swing.JLabel lblC;
    public javax.swing.JLabel lblD;
    public javax.swing.JLabel lblE;
    public javax.swing.JLabel lblInOrder;
    public javax.swing.JLabel lblLinkedList;
    public javax.swing.JLabel lblPostOrder;
    public javax.swing.JLabel lblPreOrder;
    public javax.swing.JLabel lblQN;
    public javax.swing.JLabel lblQuestionNum;
    public javax.swing.JLabel lblSortBy;
    public javax.swing.JLabel lblTopic;
    private javax.swing.JPanel pnlQuestionDetail;
    public javax.swing.JTable tblQuestionSelector;
    public javax.swing.JTextArea txtBinaryTree;
    public javax.swing.JTextArea txtLinkedList;
    public javax.swing.JTextField txtQAnswerA;
    public javax.swing.JTextField txtQAnswerB;
    public javax.swing.JTextField txtQAnswerC;
    public javax.swing.JTextField txtQAnswerD;
    public javax.swing.JTextField txtQAnswerE;
    public javax.swing.JTextArea txtQQuestion;
    public javax.swing.JTextField txtQTopic;
    public javax.swing.JLabel txtTableTitle;
    public javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
  

}
