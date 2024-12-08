import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

public class SRegistration extends javax.swing.JFrame {
    
    public SRegistration() {
        initComponents();   
        addToolTip();
    }
    private void addToolTip(){
        userFname.setToolTipText("Full Name");
        userEmail.setToolTipText("Email");
        userAddress.setToolTipText("Address");
        userContactNumber.setToolTipText("Contact Number");
        userDateofBirth.setToolTipText("Date of Birth");
        userGender.setToolTipText("Gender");
        userCourse.setToolTipText("Course");
        userLevel.setToolTipText("Year level");
        sLogo.setToolTipText("MRJTL");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userFname = new javax.swing.JTextField();
        userEmail = new javax.swing.JTextField();
        userAddress = new javax.swing.JTextField();
        userContactNumber = new javax.swing.JTextField();
        userCourse = new javax.swing.JComboBox<>();
        userLevel = new javax.swing.JComboBox<>();
        userGender = new javax.swing.JComboBox<>();
        userEnroll = new javax.swing.JButton();
        userDateofBirth = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        sLogo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        userFname.setForeground(new java.awt.Color(153, 153, 153));
        userFname.setText("Full Name");
        userFname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userFnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userFnameFocusLost(evt);
            }
        });
        userFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFnameActionPerformed(evt);
            }
        });

        userEmail.setForeground(new java.awt.Color(153, 153, 153));
        userEmail.setText("Email");
        userEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userEmailFocusLost(evt);
            }
        });

        userAddress.setForeground(new java.awt.Color(153, 153, 153));
        userAddress.setText("Address");
        userAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userAddressFocusLost(evt);
            }
        });

        userContactNumber.setForeground(new java.awt.Color(153, 153, 153));
        userContactNumber.setText("Contact Number");
        userContactNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userContactNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userContactNumberFocusLost(evt);
            }
        });

        userCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS in Information Technology", "BS in Hospitality Management", "BS in Computer Science ", "BS in Electrical Engineering" }));
        userCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCourseActionPerformed(evt);
            }
        });

        userLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2nd Year", "3rd Year", "4th Year" }));

        userGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        userEnroll.setBackground(new java.awt.Color(102, 204, 255));
        userEnroll.setForeground(new java.awt.Color(255, 255, 255));
        userEnroll.setText("Enroll");
        userEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEnrollActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        sLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/MRJTL.png"))); // NOI18N
        sLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sLogoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Enrollment");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(305, 305, 305)
                .addComponent(sLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userContactNumber)
                    .addComponent(userAddress)
                    .addComponent(userEmail)
                    .addComponent(userFname, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userDateofBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(423, 423, 423))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userFname, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userDateofBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(userGender, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84)
                .addComponent(userEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        userCourse.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userFnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFnameFocusGained
        if (userFname.getText().equals("Full Name")){
            userFname.setText("");
            userFname.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_userFnameFocusGained

    private void userFnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFnameFocusLost
        if (userFname.getText().equals("")){
            userFname.setText("Full Name");
            userFname.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_userFnameFocusLost

    private void userEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userEmailFocusGained
        if (userEmail.getText().equals("Email")){
            userEmail.setText("");
            userEmail.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_userEmailFocusGained

    private void userEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userEmailFocusLost
        if (userEmail.getText().equals("")){
            userEmail.setText("Email");
            userEmail.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_userEmailFocusLost

    private void userAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userAddressFocusGained
        if (userAddress.getText().equals("Address")){
            userAddress.setText("");
            userAddress.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_userAddressFocusGained

    private void userAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userAddressFocusLost
        if (userAddress.getText().equals("")){
            userAddress.setText("Address");
            userAddress.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_userAddressFocusLost

    private void userContactNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userContactNumberFocusGained
        if (userContactNumber.getText().equals("Contact Number")){
            userContactNumber.setText("");
            userContactNumber.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_userContactNumberFocusGained

    private void userContactNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userContactNumberFocusLost
        if (userContactNumber.getText().equals("")){
            userContactNumber.setText("Contact Number");
            userContactNumber.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_userContactNumberFocusLost

    private void userFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFnameActionPerformed
       
    }//GEN-LAST:event_userFnameActionPerformed

    private void sLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sLogoActionPerformed

    }//GEN-LAST:event_sLogoActionPerformed
    
    private void userEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEnrollActionPerformed
        String name = userFname.getText();
        String email = userEmail.getText();
        String address = userAddress.getText();
        String contact = userContactNumber.getText();
        
        java.util.Date selectedDate = userDateofBirth.getDate();
        String dob = "";
        if (selectedDate != null){
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            dob = dateFormat.format(selectedDate);
        }

        String gender = userGender.getSelectedItem().toString();
        String course = userCourse.getSelectedItem().toString();
        String yearLevel = userLevel.getSelectedItem().toString();
       
        
        int randomId = 100000 + (int)(Math.random() * 900000);
        
        int courseId = 100 + (int)(Math.random() * 900);
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
            String sql = "INSERT INTO s_db (course_id, student_id, name, email, address, contact_number, date_of_birth, gender, course, year_level, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'pending')";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, courseId);
            pst.setInt(2, randomId);
            pst.setString(3, name);
            pst.setString(4, email);
            pst.setString(5, address);
            pst.setString(6, contact);
            pst.setString(7, dob);
            pst.setString(8, gender);
            pst.setString(9, course);
            pst.setString(10, yearLevel);
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0){
                JOptionPane.showMessageDialog(this, "Student enrolled successfully!");
            }
            
            pst.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_userEnrollActionPerformed

    private void userCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userCourseActionPerformed

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
            java.util.logging.Logger.getLogger(SRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton sLogo;
    private javax.swing.JTextField userAddress;
    private javax.swing.JTextField userContactNumber;
    private javax.swing.JComboBox<String> userCourse;
    private com.toedter.calendar.JDateChooser userDateofBirth;
    private javax.swing.JTextField userEmail;
    private javax.swing.JButton userEnroll;
    private javax.swing.JTextField userFname;
    private javax.swing.JComboBox<String> userGender;
    private javax.swing.JComboBox<String> userLevel;
    // End of variables declaration//GEN-END:variables
}
