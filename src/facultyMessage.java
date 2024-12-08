import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;

public class facultyMessage extends javax.swing.JFrame {
    
    private String email;
    private String course;
    
    public facultyMessage(String email) {
        if (email == null || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Faculty email is required.");
            throw new IllegalArgumentException("Email is required to load faculty message form.");
        }
        this.email = email;
        initComponents();
        fetchFacultyCourse();
        loadStudentName();
    }
    private void fetchFacultyCourse(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
            String sql = "SELECT assigned_course FROM f_db WHERE email = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);    
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                course = rs.getString("assigned_course");
            } else {
                JOptionPane.showMessageDialog(this, "No course found for the given faculty email.");
            }
            
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching faculty course: " + e.getMessage());
        }
    }
    private void loadStudentName(){
        try {
            if (course == null || course.isEmpty()){
                JOptionPane.showMessageDialog(this, "No course is associated with this faculty.");
                return;
            }
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
            String sql = "SELECT email FROM s_db WHERE course = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, course);   
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) nameStudent.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                String email1 = rs.getString("email");
                
                model.addRow(new Object[]{email1}); 
            }
            
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching students: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nameStudent = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        replyNotif = new javax.swing.JButton();
        sendTo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nameStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Email"
            }
        ));
        jScrollPane1.setViewportView(nameStudent);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        replyNotif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/notification.jpg"))); // NOI18N
        replyNotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replyNotifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(replyNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(replyNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        sendTo.setForeground(new java.awt.Color(153, 153, 153));
        sendTo.setText("Send To:");
        sendTo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sendToFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sendToFocusLost(evt);
            }
        });
        sendTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToActionPerformed(evt);
            }
        });

        messageText.setColumns(20);
        messageText.setRows(5);
        jScrollPane2.setViewportView(messageText);

        sendBtn.setBackground(new java.awt.Color(102, 204, 255));
        sendBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sendTo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(sendBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sendTo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FacultyProfile back = new FacultyProfile(email);
        back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sendToFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sendToFocusGained
        if (sendTo.getText().equals("Send To:")){
            sendTo.setText("");
            sendTo.setForeground(new Color(0,0,0));
        }       
    }//GEN-LAST:event_sendToFocusGained

    private void sendToFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sendToFocusLost
        if (sendTo.getText().equals("")){
            sendTo.setText("Send To:");
            sendTo.setForeground(new Color(153,153,153));
        } 
    }//GEN-LAST:event_sendToFocusLost

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        String recipient = sendTo.getText().trim();
        String message = messageText.getText().trim();

        if (recipient.isEmpty() || recipient.equals("Send To:")) {
            JOptionPane.showMessageDialog(this, "Please specify a recipient.");
            return;
        }

        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Message text cannot be empty.");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
            String validateSql = "SELECT * FROM s_db WHERE student_id = ? OR email = ?";
            PreparedStatement validatePst = conn.prepareStatement(validateSql);
            validatePst.setString(1, recipient);
            validatePst.setString(2, recipient);
            ResultSet rs = validatePst.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Recipient not found in the database.");
                rs.close();
                validatePst.close();
                conn.close();
                return;
            }
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            
            String saveMessageSql = "INSERT INTO m_db (sender_email, recipient, message_text, course, timestamp, read_status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement messagePst = conn.prepareStatement(saveMessageSql);
            messagePst.setString(1, email); 
            messagePst.setString(2, recipient); 
            messagePst.setString(3, message); 
            messagePst.setString(4, course); 
            messagePst.setTimestamp(5, timestamp);
            messagePst.setInt(6, 0);
            

            int rowsInserted = messagePst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Message sent successfully!");
                messageText.setText(""); 
                sendTo.setText("Send To:"); 
                sendTo.setForeground(new Color(153, 153, 153));
            } else {
                JOptionPane.showMessageDialog(this, "Failed to send the message.");
            }

            rs.close();
            validatePst.close();
            messagePst.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error while sending message: " + ex.getMessage());
        }
    }//GEN-LAST:event_sendBtnActionPerformed

    private void sendToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendToActionPerformed

    private void replyNotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replyNotifActionPerformed
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");

            String sql = "SELECT sender_email, message_text FROM m_db WHERE recipient = ? ORDER BY message_id DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            StringBuilder notifications = new StringBuilder();

            while (rs.next()) {
                String sender = rs.getString("sender_email");
                String message = rs.getString("message_text");
                notifications.append("From: ").append(sender).append("\n")
                             .append("Message: ").append(message).append("\n\n");
            }

            if (notifications.length() > 0) {
                JOptionPane.showMessageDialog(this, notifications.toString(), "New Replies", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No new replies.");
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving notifications.");
        }
    }//GEN-LAST:event_replyNotifActionPerformed

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
            java.util.logging.Logger.getLogger(facultyMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facultyMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facultyMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facultyMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facultyMessage("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageText;
    private javax.swing.JTable nameStudent;
    private javax.swing.JButton replyNotif;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField sendTo;
    // End of variables declaration//GEN-END:variables
}
