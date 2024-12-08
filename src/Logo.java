import java.awt.Color;
import java.sql.*;
import javax.swing.*;

public class Logo extends javax.swing.JFrame {
    
    
    public Logo(String role) {
        initComponents();
        userRole.setText(role);
        
        getContentPane().setBackground(java.awt.Color.WHITE);
        modeBtn.setIcon(new ImageIcon(getClass().getResource("/Pictures/Sun.jpg")));
        modeBtn.setForeground(java.awt.Color.BLACK);
        isDarkMode = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLogin = new javax.swing.JButton();
        signUp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userEmail = new javax.swing.JTextField();
        passWord = new javax.swing.JPasswordField();
        showPass = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        userRole = new javax.swing.JLabel();
        modeBtn = new javax.swing.JToggleButton();
        sLogo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userLogin.setBackground(new java.awt.Color(102, 204, 255));
        userLogin.setForeground(new java.awt.Color(255, 255, 255));
        userLogin.setText("Login");
        userLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLoginActionPerformed(evt);
            }
        });

        signUp.setBackground(new java.awt.Color(102, 204, 255));
        signUp.setForeground(new java.awt.Color(255, 255, 255));
        signUp.setText("Sign Up");
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        jLabel2.setText("I don't have an account.");

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
        userEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailActionPerformed(evt);
            }
        });

        passWord.setForeground(new java.awt.Color(153, 153, 153));
        passWord.setText("Password");
        passWord.setEchoChar('\u0000');
        passWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passWordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passWordFocusLost(evt);
            }
        });
        passWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passWordActionPerformed(evt);
            }
        });

        showPass.setText("Show Password");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });

        userRole.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        userRole.setText("User");

        modeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeBtnActionPerformed(evt);
            }
        });

        sLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/MRJTL.png"))); // NOI18N
        sLogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sLogo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(showPass))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(userRole, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(sLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(userRole, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showPass)
                        .addGap(42, 42, 42)
                        .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
        if (passWord.getEchoChar() == '*'){
            passWord.setEchoChar((char) 0);
        } else {
            passWord.setEchoChar('*');
        }
    }//GEN-LAST:event_showPassActionPerformed

    private void passWordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passWordFocusLost
        if (passWord.getText().equals("")){
            passWord.setText("Password");
            passWord.setEchoChar((char) 0);
            passWord.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_passWordFocusLost

    private void passWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passWordFocusGained
        if (passWord.getText().equals("Password")){
            passWord.setText(null);
            passWord.setEchoChar('*');
            passWord.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_passWordFocusGained

    private void userEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmailActionPerformed

    private void userEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userEmailFocusLost
        if (userEmail.getText().equals("")){
            userEmail.setText("Email");
            userEmail.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_userEmailFocusLost

    private void userEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userEmailFocusGained
        if (userEmail.getText().equals("Email")){
            userEmail.setText("");
            userEmail.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_userEmailFocusGained

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        SignUp signup = new SignUp(userRole.getText());
        signup.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signUpActionPerformed

    private void userLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLoginActionPerformed
        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String dbPassword = "";

        String email = userEmail.getText();
        String passwordInput = passWord.getText();

        if (email.isEmpty() || email.equals("Email")) {
            JOptionPane.showMessageDialog(new JFrame(), "Email is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (passwordInput.isEmpty() || passwordInput.equals("Password")) {
            JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "SELECT password, status, role FROM sign_up WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                String userStatus = rs.getString("status");
                String userRole = rs.getString("role");

                if (!passwordInput.equals(storedPassword)) {
                    JOptionPane.showMessageDialog(this, "Incorrect password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if ("Registrar".equalsIgnoreCase(userRole) && !"accepted".equalsIgnoreCase(userStatus)) {
                    JOptionPane.showMessageDialog(this, "Your account has not been accepted by the admin.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if ("Faculty".equalsIgnoreCase(userRole) && !"accepted".equalsIgnoreCase(userStatus)) {
                    JOptionPane.showMessageDialog(this, "Your account has not been accepted by the admin.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(this, "Login successful!");
                
                if ("student".equalsIgnoreCase(userRole)) {
                    boolean isEnrolled = "enrolled".equalsIgnoreCase(userStatus);
                    Profile userProfile = new Profile(email, isEnrolled);
                    userProfile.setVisible(true);
                } else if ("registrar".equalsIgnoreCase(userRole)) {
                    Registrar userProfile = new Registrar(email);
                    userProfile.setVisible(true);
                } else if ("faculty".equalsIgnoreCase(userRole)) {
                    FacultyProfile userProfile = new FacultyProfile(email);
                    userProfile.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Unknown role. Unable to proceed.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No account found with this email.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_userLoginActionPerformed

    private void passWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passWordActionPerformed
        
    }//GEN-LAST:event_passWordActionPerformed
    private boolean isDarkMode = false;
    
    private void modeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeBtnActionPerformed
        if (!isDarkMode) {
            getContentPane().setBackground(java.awt.Color.DARK_GRAY);
            modeBtn.setIcon(new ImageIcon(getClass().getResource("/Pictures/Moon.jpg")));
            modeBtn.setForeground(java.awt.Color.WHITE);
            
            userEmail.setBackground(java.awt.Color.DARK_GRAY);
            userEmail.setForeground(java.awt.Color.WHITE);
            passWord.setBackground(java.awt.Color.DARK_GRAY);
            passWord.setForeground(java.awt.Color.WHITE);
            showPass.setForeground(java.awt.Color.WHITE);
            jLabel2.setForeground(java.awt.Color.WHITE);
            userRole.setForeground(java.awt.Color.WHITE);
            
            isDarkMode = true;
        } else {
            getContentPane().setBackground(java.awt.Color.WHITE);
            modeBtn.setIcon(new ImageIcon(getClass().getResource("/Pictures/Sun.jpg")));
            modeBtn.setForeground(java.awt.Color.BLACK);
            
            userEmail.setBackground(java.awt.Color.WHITE);
            userEmail.setForeground(new java.awt.Color(153, 153, 153));
            passWord.setBackground(java.awt.Color.WHITE);
            passWord.setForeground(new java.awt.Color(153, 153, 153));
            showPass.setForeground(java.awt.Color.BLACK);
            jLabel2.setForeground(java.awt.Color.BLACK);
            userRole.setForeground(java.awt.Color.BLACK);
            
            isDarkMode = false;
        }
        
        repaint();
    }//GEN-LAST:event_modeBtnActionPerformed

    private void sLogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sLogo1ActionPerformed

    }//GEN-LAST:event_sLogo1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        String[] roles = {"Student", "Registrar", "Faculty", "Admin"};
        String selectedRole = (String) JOptionPane.showInputDialog(
                null,
                "Select your role",
                "Role Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                roles,
                roles[0]
        );

        if (selectedRole != null) {
            if (selectedRole.equals("Admin")) {
                String adminPassword = JOptionPane.showInputDialog("Enter admin password:");

                if (adminPassword != null && adminPassword.equals("Pogisikenjie")) {
                    Admin adminForm = new Admin();
                    adminForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect admin password.");
                    System.exit(0);
                }
            } else {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Logo logo = new Logo(selectedRole);
                        logo.setVisible(true);
                    }
                });
            }
        } else {
            JOptionPane.showMessageDialog(null, "No role selected.");
            System.exit(0);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton modeBtn;
    private javax.swing.JPasswordField passWord;
    private javax.swing.JButton sLogo1;
    private javax.swing.JCheckBox showPass;
    private javax.swing.JButton signUp;
    private javax.swing.JTextField userEmail;
    private javax.swing.JButton userLogin;
    private javax.swing.JLabel userRole;
    // End of variables declaration//GEN-END:variables
}
