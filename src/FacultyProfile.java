import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FacultyProfile extends javax.swing.JFrame {
    
    private String email;
    
    public FacultyProfile(String email) {
        this.email = email;
        initComponents();
        loadFacultyDetails(email);
        addToolTip();
    }
    private void addToolTip(){
        messageF.setToolTipText("Message");
        logoutBtn.setToolTipText("Log out");
    }
    private void loadFacultyDetails(String email){
        try {
            String url = "jdbc:mysql://localhost:3306/mrjtl_db";
            String user = "root";
            String password = "";
            
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String facultyQuery = "SELECT * FROM f_db WHERE email = ?";
            PreparedStatement facultyStmt = conn.prepareStatement(facultyQuery);
            facultyStmt.setString(1, email);
            
            ResultSet facultyRs = facultyStmt.executeQuery();
            
            if (facultyRs.next()){
                employeeId.setText(String.valueOf(facultyRs.getInt("employee_id")));
                instructorName.setText(facultyRs.getString("name"));
                fEmail.setText(facultyRs.getString("email"));
                contactNumber.setText(facultyRs.getString("phone_number"));
                fAddress.setText(facultyRs.getString("address"));
                assignedCourse.setText(facultyRs.getString("assigned_course"));
            } else {
                System.out.println("No faculty found with email: " + email);
            }
            
            DefaultTableModel model = (javax.swing.table.DefaultTableModel) facultySchedule.getModel();
            model.setRowCount(0);
            
            String scheduleQuery = "SELECT subject, days, TIME_FORMAT(start_time, '%H:%i') AS start_time, TIME_FORMAT(end_time, '%H:%i') AS end_time, room FROM cs_db WHERE instructor = ?";
            PreparedStatement scheduleStmt = conn.prepareStatement(scheduleQuery);
            scheduleStmt.setString(1, facultyRs.getString("name")); 
            
            ResultSet scheduleRs = scheduleStmt.executeQuery();
            
            
            while (scheduleRs.next()) {
                model.addRow(new Object[]{
                    scheduleRs.getString("subject"),
                    scheduleRs.getString("days"),
                    scheduleRs.getString("start_time"),
                    scheduleRs.getString("end_time"),
                    scheduleRs.getString("room")
                });
            }
             
            facultyRs.close();
            facultyStmt.close();
            scheduleRs.close();
            scheduleStmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        employeeId = new javax.swing.JLabel();
        instructorName = new javax.swing.JLabel();
        fEmail = new javax.swing.JLabel();
        contactNumber = new javax.swing.JLabel();
        fAddress = new javax.swing.JLabel();
        assignedCourse = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        facultySchedule = new javax.swing.JTable();
        messageF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        employeeId.setBackground(new java.awt.Color(255, 255, 255));
        employeeId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        employeeId.setForeground(new java.awt.Color(255, 255, 255));
        employeeId.setText("Employee Id");

        instructorName.setBackground(new java.awt.Color(255, 255, 255));
        instructorName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorName.setForeground(new java.awt.Color(255, 255, 255));
        instructorName.setText("Instructor Name");

        fEmail.setBackground(new java.awt.Color(255, 255, 255));
        fEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fEmail.setForeground(new java.awt.Color(255, 255, 255));
        fEmail.setText("Email");

        contactNumber.setBackground(new java.awt.Color(255, 255, 255));
        contactNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contactNumber.setForeground(new java.awt.Color(255, 255, 255));
        contactNumber.setText("Contact Number");

        fAddress.setBackground(new java.awt.Color(255, 255, 255));
        fAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fAddress.setForeground(new java.awt.Color(255, 255, 255));
        fAddress.setText("Address");

        assignedCourse.setBackground(new java.awt.Color(255, 255, 255));
        assignedCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        assignedCourse.setForeground(new java.awt.Color(255, 255, 255));
        assignedCourse.setText("Assigned Course");

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logout.jpg"))); // NOI18N
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(instructorName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assignedCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(employeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instructorName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assignedCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        facultySchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Subject", "Days", "Start Time", "End Time", "Room"
            }
        ));
        jScrollPane2.setViewportView(facultySchedule);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );

        messageF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/message icon.jpg"))); // NOI18N
        messageF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(messageF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to log out?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            String currentRole = "Faculty"; 

            Logo logout = new Logo(currentRole);
            logout.setVisible(true);

            this.dispose(); 
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void messageFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageFActionPerformed
        String currentEmail = this.email    ; 
        if (currentEmail != null && !currentEmail.trim().isEmpty()) {
            facultyMessage messageForm = new facultyMessage(currentEmail);
            messageForm.setVisible(true);
            this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Error: Unable to retrieve faculty email.");
    }
    }//GEN-LAST:event_messageFActionPerformed

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
            java.util.logging.Logger.getLogger(FacultyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacultyProfile("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assignedCourse;
    private javax.swing.JLabel contactNumber;
    private javax.swing.JLabel employeeId;
    private javax.swing.JLabel fAddress;
    private javax.swing.JLabel fEmail;
    private javax.swing.JTable facultySchedule;
    private javax.swing.JLabel instructorName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton messageF;
    // End of variables declaration//GEN-END:variables
}
