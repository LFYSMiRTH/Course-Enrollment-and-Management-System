import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

        
public class Profile extends javax.swing.JFrame {
    
    private final String loggedInEmail;
    private final boolean isEnrolled;
    private JLabel lblCourseValue;
    private JLabel lblYearLevelValue;
    private String currentStudent = "";
    
            
    public Profile(String email, boolean isEnrolled) {
        initComponents();
        this.loggedInEmail = email;
        this.isEnrolled = isEnrolled;
        
        lblCourseValue = new JLabel();
        lblYearLevelValue = new JLabel();
        
        setUser(loggedInEmail);
        
        studentLogin(loggedInEmail);
        
        studentScheduleTable();
        fetchProfileData();
        
        addToolTips();
        
    }
    
    private void addToolTips() {
        withdrawalBtn.setToolTipText("Withdraw");
        sProfile.setToolTipText("Profile");
        logoutBtn.setToolTipText("Logout");
        messagesBtn.setToolTipText("Message");
    }
    
    private void fetchProfileData() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM s_db WHERE email = ?")) {

           stmt.setString(1, loggedInEmail);
           ResultSet rs = stmt.executeQuery();

           if (rs.next()) {
               String status = rs.getString("status");

               if ("enrolled".equalsIgnoreCase(status)) {
                   lblCourseValue.setText(rs.getString("course"));
                   lblYearLevelValue.setText(rs.getString("year_level"));
                   studentScheduleTable();
               } else {
                   lblCourseValue.setText("Not enrolled");
                   lblYearLevelValue.setText("N/A");
                   scheduleTable.setVisible(false);
               }
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Error retrieving profile data: " + ex.getMessage());
       }
    }

    public void setUser(String userName){
       
        if (userName != null && !userName.isEmpty()) {
            String nameToDisplay = userName;

            if (userName.contains("@")) {
                nameToDisplay = userName.split("@")[0]; 
            }

            
            String[] words = nameToDisplay.toLowerCase().split(" ");
            StringBuilder capitalizedUser = new StringBuilder();
            
            for (String word : words){
                if (!word.isEmpty()){
                    capitalizedUser.append(Character.toUpperCase(word.charAt(0)))
                                   .append(word.substring(1))
                                   .append(" ");
                }
            }
            
            sUser.setText(capitalizedUser.toString().trim());
        }
    }
    
    private void studentScheduleTable(){      
        if (lblCourseValue == null || lblYearLevelValue == null || 
            lblCourseValue.getText().isEmpty() || lblYearLevelValue.getText().isEmpty()) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
        model.setRowCount(0);
        
        String course = lblCourseValue.getText();
        String yearLevel = lblYearLevelValue.getText();
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement("SELECT subject, days, TIME_FORMAT(start_time, '%H:%i') AS start_time, TIME_FORMAT(end_time, '%H:%i') AS end_time, room, instructor FROM cs_db WHERE course = ? AND year_level = ?")){

                stmt.setString(1, course); 
                stmt.setString(2, yearLevel);  

                ResultSet rs = stmt.executeQuery();

                int rowIndex = 0;
                while (rs.next()){
                    model.addRow(new Object[]{
                        rs.getString("subject"),
                        rs.getString("days"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getString("room"),
                        rs.getString("instructor")
                    });


                    switch (rowIndex) {
                        case 0:
                            stOne.setText(rs.getString("subject"));
                            break;
                        case 1:
                            stTwo.setText(rs.getString("subject"));
                            break;
                        case 2:
                            stThree.setText(rs.getString("subject"));
                            break;
                        case 3:
                            stFour.setText(rs.getString("subject"));
                            break;
                        case 4:
                            stFive.setText(rs.getString("subject"));
                            break;
                        default:
                            break;
                    }
                    rowIndex++;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        sUser = new javax.swing.JLabel();
        sProfile = new javax.swing.JButton();
        withdrawalBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messagesBtn = new javax.swing.JButton();
        subjectOne = new javax.swing.JButton();
        stTwo = new javax.swing.JLabel();
        stOne = new javax.swing.JLabel();
        stThree = new javax.swing.JLabel();
        stFive = new javax.swing.JLabel();
        stFour = new javax.swing.JLabel();
        subjectOne1 = new javax.swing.JButton();
        subjectOne2 = new javax.swing.JButton();
        subjectOne3 = new javax.swing.JButton();
        subjectOne4 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Subject", "Days", "Start Time", "End Time", "Room", "Instructor"
            }
        ));
        jScrollPane1.setViewportView(scheduleTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        sUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sUser.setForeground(new java.awt.Color(255, 255, 255));
        sUser.setText("UserName");

        sProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Profile.jpg"))); // NOI18N
        sProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sProfileActionPerformed(evt);
            }
        });

        withdrawalBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/withdraw.jpg"))); // NOI18N
        withdrawalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawalBtnActionPerformed(evt);
            }
        });

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logout.jpg"))); // NOI18N
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome");

        messagesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/message icon.jpg"))); // NOI18N
        messagesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messagesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sUser, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messagesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(withdrawalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(withdrawalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(messagesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sUser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        subjectOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/subject 1.jpg"))); // NOI18N
        subjectOne.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        subjectOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectOneActionPerformed(evt);
            }
        });

        stTwo.setBackground(new java.awt.Color(255, 255, 255));
        stTwo.setText("Subject Title");

        stOne.setBackground(new java.awt.Color(255, 255, 255));
        stOne.setText("Subject Title");

        stThree.setBackground(new java.awt.Color(255, 255, 255));
        stThree.setText("Subject Title");

        stFive.setBackground(new java.awt.Color(255, 255, 255));
        stFive.setText("Subject Title");

        stFour.setBackground(new java.awt.Color(255, 255, 255));
        stFour.setText("Subject Title");

        subjectOne1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/subject 1.jpg"))); // NOI18N
        subjectOne1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        subjectOne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectOne1ActionPerformed(evt);
            }
        });

        subjectOne2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/subject 1.jpg"))); // NOI18N
        subjectOne2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        subjectOne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectOne2ActionPerformed(evt);
            }
        });

        subjectOne3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/subject 1.jpg"))); // NOI18N
        subjectOne3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        subjectOne3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectOne3ActionPerformed(evt);
            }
        });

        subjectOne4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/subject 1.jpg"))); // NOI18N
        subjectOne4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        subjectOne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectOne4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectOne4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(subjectOne3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(subjectOne2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(subjectOne1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(subjectOne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(stOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stThree, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stFour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stFive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(subjectOne, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(subjectOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(subjectOne2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(subjectOne3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(subjectOne4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(stOne, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(stTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(stThree, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(stFour, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(stFive, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );

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

    private void sProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sProfileActionPerformed
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(10, 2, 10, 10)); 
        
        JLabel lblStudentId = new JLabel("Student ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblAddress = new JLabel("Address:");
        JLabel lblContact = new JLabel("Contact Number:");
        JLabel lblDOB = new JLabel("Date of Birth:");
        JLabel lblGender = new JLabel("Gender:");
        JLabel lblCourse = new JLabel("Course:");
        JLabel lblYearLevel = new JLabel("Year Level:");
        JLabel lblStatus = new JLabel("Status:");
        
        JLabel lblStudentIdValue = new JLabel();
        JLabel lblNameValue = new JLabel();
        JLabel lblEmailValue = new JLabel();
        JLabel lblAddressValue = new JLabel();
        JLabel lblContactValue = new JLabel();
        JLabel lblDOBValue = new JLabel();
        JLabel lblGenderValue = new JLabel();
        lblCourseValue = new JLabel();
        lblYearLevelValue = new JLabel();
        JLabel lblStatusValue = new JLabel();
        
        profilePanel.add(lblStudentId);
        profilePanel.add(lblStudentIdValue);
        profilePanel.add(lblName);
        profilePanel.add(lblNameValue);
        profilePanel.add(lblEmail);
        profilePanel.add(lblEmailValue);
        profilePanel.add(lblAddress);
        profilePanel.add(lblAddressValue);
        profilePanel.add(lblContact);
        profilePanel.add(lblContactValue);
        profilePanel.add(lblDOB);
        profilePanel.add(lblDOBValue);
        profilePanel.add(lblGender);
        profilePanel.add(lblGenderValue);
        profilePanel.add(lblCourse);
        profilePanel.add(lblCourseValue);
        profilePanel.add(lblYearLevel);
        profilePanel.add(lblYearLevelValue);
        profilePanel.add(lblStatus);
        profilePanel.add(lblStatusValue);
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM s_db where email = ?")){
            
            stmt.setString(1, loggedInEmail);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                lblStudentIdValue.setText(String.valueOf(rs.getInt("student_id")));
                lblNameValue.setText(rs.getString("name"));
                lblEmailValue.setText(rs.getString("email"));
                lblAddressValue.setText(rs.getString("address"));
                lblContactValue.setText(rs.getString("contact_number"));
                lblDOBValue.setText(rs.getString("date_of_birth"));
                lblGenderValue.setText(rs.getString("gender"));
                lblCourseValue.setText(rs.getString("course"));
                lblYearLevelValue.setText(rs.getString("year_level"));
                lblStatusValue.setText(rs.getString("status"));
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error retrieving student profile: " + ex.getMessage());
        }
        
        JOptionPane.showConfirmDialog(null, profilePanel, "Student Profile", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_sProfileActionPerformed
    
    private void withdrawalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawalBtnActionPerformed
        String studentEmail = loggedInEmail;

        if (studentEmail == null || studentEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No student logged in.");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "")) {
            String query = "SELECT name, course FROM s_db WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, studentEmail);

            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Student not found.");
                return;
            }

            String name = rs.getString("name");
            String course = rs.getString("course");
            Timestamp requestedDate = new Timestamp(System.currentTimeMillis());

            JTextField reasonField = new JTextField(20);
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            panel.add(new JLabel("Name:"), gbc);
            panel.add(new JLabel(name), gbc);
            gbc.gridy = 1; panel.add(new JLabel("Course:"), gbc);
            panel.add(new JLabel(course), gbc);
            gbc.gridy = 2; panel.add(new JLabel("Reason for Withdrawal:"), gbc);
            panel.add(reasonField, gbc);
            gbc.gridy = 3; panel.add(new JLabel("Requested Date:"), gbc);
            panel.add(new JLabel(requestedDate.toString()), gbc);

            int result = JOptionPane.showConfirmDialog(this, panel, "Withdrawal Request",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String reason = reasonField.getText().trim();
                if (reason.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please provide a reason for withdrawal.");
                    return;
                }

                try (Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "")) {
                    String insertQuery = "INSERT INTO w_db (email, name, course, reason, requested_date) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStmt = conn2.prepareStatement(insertQuery);
                    insertStmt.setString(1, studentEmail);
                    insertStmt.setString(2, name);
                    insertStmt.setString(3, course);
                    insertStmt.setString(4, reason);
                    insertStmt.setTimestamp(5, requestedDate);

                    if (insertStmt.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(this, "Withdrawal request sent to admin.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error sending withdrawal request.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.");
        }
    }//GEN-LAST:event_withdrawalBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to log out?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            String currentRole = "Student"; 

            Logo logout = new Logo(currentRole);
            logout.setVisible(true);

            this.dispose(); 
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void messagesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messagesBtnActionPerformed
        studentMessage open = new studentMessage(loggedInEmail);
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_messagesBtnActionPerformed
    private Connection connectDatabase(){
        try {
            String url = "jdbc:mysql://localhost:3306/mrjtl_db"; 
            String user = "root"; 
            String password = ""; 
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private void studentLogin(String studentEmail) {
        currentStudent = studentEmail;

        try (Connection conn = connectDatabase()) {
            if (conn != null) {
                String query = "SELECT subject_1_progress, subject_2_progress, subject_3_progress, subject_4_progress, subject_5_progress FROM p_db WHERE student_email = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, currentStudent);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    jProgressBar1.setValue(rs.getInt("subject_1_progress"));
                    jProgressBar2.setValue(rs.getInt("subject_2_progress"));
                    jProgressBar3.setValue(rs.getInt("subject_3_progress"));
                    jProgressBar4.setValue(rs.getInt("subject_4_progress"));
                    jProgressBar5.setValue(rs.getInt("subject_5_progress"));
                } else {
                    String insertQuery = "INSERT INTO p_db (student_email, subject_1_progress, subject_2_progress, subject_3_progress, subject_4_progress, subject_5_progress) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                    insertStmt.setString(1, currentStudent);
                    insertStmt.setInt(2, 0); 
                    insertStmt.setInt(3, 0);
                    insertStmt.setInt(4, 0);
                    insertStmt.setInt(5, 0);
                    insertStmt.setInt(6, 0);
                    insertStmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void updateStudentProgress(String subjectColumn, int newProgress) {
        try (Connection conn = connectDatabase()) {
            if (conn != null) {
                String updateQuery = "UPDATE p_db SET " + subjectColumn + " = ? WHERE student_email = ?";
                PreparedStatement stmt = conn.prepareStatement(updateQuery);
                stmt.setInt(1, newProgress);
                stmt.setString(2, currentStudent);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void subjectOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectOneActionPerformed
       if (currentStudent.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "No student is currently logged in. Please log in first.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String subjectTitle = stOne.getText();
        
        if (subjectTitle.isEmpty() || subjectTitle.equalsIgnoreCase("Subject Title")) {
            JOptionPane.showMessageDialog(null,
                "You have no subjects assigned.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return; 
        }

        try (Connection conn = connectDatabase()) {
            if (conn != null) {
                String query = "SELECT subject_1_progress FROM p_db WHERE student_email = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, currentStudent);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int currentProgress = rs.getInt("subject_1_progress");
                    int newProgress = Math.min(currentProgress + 5, 100);

                    if (newProgress > currentProgress) {
                        updateStudentProgress("subject_1_progress", newProgress);
                        jProgressBar1.setValue(newProgress);

                        if (newProgress % 5 == 0) {
                            String encodedSubjectTitle = URLEncoder.encode(subjectTitle, StandardCharsets.UTF_8.toString());
                            String searchURL = "https://www.google.com/search?q=" + encodedSubjectTitle;
                            Desktop.getDesktop().browse(new URI(searchURL));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_subjectOneActionPerformed

    private void subjectOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectOne1ActionPerformed
        if (currentStudent.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "No student is currently logged in. Please log in first.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String subjectTitle = stTwo.getText();
        
        if (subjectTitle.isEmpty() || subjectTitle.equalsIgnoreCase("Subject Title")) {
            JOptionPane.showMessageDialog(null,
                "You have no subjects assigned.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return; 
        }


        try (Connection conn = connectDatabase()) {
            if (conn != null) {
                String query = "SELECT subject_2_progress FROM p_db WHERE student_email = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, currentStudent);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int currentProgress = rs.getInt("subject_2_progress");
                    int newProgress = Math.min(currentProgress + 5, 100);

                    if (newProgress > currentProgress) {
                        updateStudentProgress("subject_2_progress", newProgress);
                        jProgressBar2.setValue(newProgress);

                        if (newProgress % 5 == 0) {
                            String encodedSubjectTitle = URLEncoder.encode(subjectTitle, StandardCharsets.UTF_8.toString());
                            String searchURL = "https://www.google.com/search?q=" + encodedSubjectTitle;
                            Desktop.getDesktop().browse(new URI(searchURL));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_subjectOne1ActionPerformed

    private void subjectOne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectOne2ActionPerformed
        if (currentStudent.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "No student is currently logged in. Please log in first.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String subjectTitle = stThree.getText();
        
        if (subjectTitle.isEmpty() || subjectTitle.equalsIgnoreCase("Subject Title")) {
            JOptionPane.showMessageDialog(null,
                "You have no subjects assigned.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return; 
        }


        try (Connection conn = connectDatabase()) {
            if (conn != null) {
                String query = "SELECT subject_3_progress FROM p_db WHERE student_email = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, currentStudent);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int currentProgress = rs.getInt("subject_3_progress");
                    int newProgress = Math.min(currentProgress + 5, 100);

                    if (newProgress > currentProgress) {
                        updateStudentProgress("subject_3_progress", newProgress);
                        jProgressBar3.setValue(newProgress);

                        if (newProgress % 5 == 0) {
                            String encodedSubjectTitle = URLEncoder.encode(subjectTitle, StandardCharsets.UTF_8.toString());
                            String searchURL = "https://www.google.com/search?q=" + encodedSubjectTitle;
                            Desktop.getDesktop().browse(new URI(searchURL));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_subjectOne2ActionPerformed

    private void subjectOne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectOne3ActionPerformed
        if (currentStudent.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "No student is currently logged in. Please log in first.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String subjectTitle = stFour.getText();
        
        if (subjectTitle.isEmpty() || subjectTitle.equalsIgnoreCase("Subject Title")) {
            JOptionPane.showMessageDialog(null,
                "You have no subjects assigned.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return; 
        }


        try (Connection conn = connectDatabase()) {
            if (conn != null) {
                String query = "SELECT subject_4_progress FROM p_db WHERE student_email = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, currentStudent);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int currentProgress = rs.getInt("subject_4_progress");
                    int newProgress = Math.min(currentProgress + 5, 100);

                    if (newProgress > currentProgress) {
                        updateStudentProgress("subject_4_progress", newProgress);
                        jProgressBar4.setValue(newProgress);

                        if (newProgress % 5 == 0) {
                            String encodedSubjectTitle = URLEncoder.encode(subjectTitle, StandardCharsets.UTF_8.toString());
                            String searchURL = "https://www.google.com/search?q=" + encodedSubjectTitle;
                            Desktop.getDesktop().browse(new URI(searchURL));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_subjectOne3ActionPerformed

    private void subjectOne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectOne4ActionPerformed
        if (currentStudent.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "No student is currently logged in. Please log in first.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String subjectTitle = stFive.getText();
        
        if (subjectTitle.isEmpty() || subjectTitle.equalsIgnoreCase("Subject Title")) {
            JOptionPane.showMessageDialog(null,
                "You have no subjects assigned.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            return; 
        }


        try (Connection conn = connectDatabase()) {
            if (conn != null) {
                String query = "SELECT subject_5_progress FROM p_db WHERE student_email = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, currentStudent);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int currentProgress = rs.getInt("subject_5_progress");
                    int newProgress = Math.min(currentProgress + 5, 100);

                    if (newProgress > currentProgress) {
                        updateStudentProgress("subject_5_progress", newProgress);
                        jProgressBar5.setValue(newProgress);

                        if (newProgress % 5 == 0) {
                            String encodedSubjectTitle = URLEncoder.encode(subjectTitle, StandardCharsets.UTF_8.toString());
                            String searchURL = "https://www.google.com/search?q=" + encodedSubjectTitle;
                            Desktop.getDesktop().browse(new URI(searchURL));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_subjectOne4ActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile("", false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton messagesBtn;
    private javax.swing.JButton sProfile;
    private javax.swing.JLabel sUser;
    private javax.swing.JTable scheduleTable;
    private javax.swing.JLabel stFive;
    private javax.swing.JLabel stFour;
    private javax.swing.JLabel stOne;
    private javax.swing.JLabel stThree;
    private javax.swing.JLabel stTwo;
    private javax.swing.JButton subjectOne;
    private javax.swing.JButton subjectOne1;
    private javax.swing.JButton subjectOne2;
    private javax.swing.JButton subjectOne3;
    private javax.swing.JButton subjectOne4;
    private javax.swing.JButton withdrawalBtn;
    // End of variables declaration//GEN-END:variables
}
