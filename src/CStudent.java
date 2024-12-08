import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CStudent extends javax.swing.JFrame {
    
    private String email;
    
    public CStudent() {
        this.email = email;
        initComponents();
        loadAvailableInstructor();
        loadSubjectTable();
        courseAvailable.addActionListener(e -> loadSubjectTable());
        yearLevel.addActionListener(e -> loadSubjectTable());
        courseAvailable.addActionListener(e -> loadAvailableInstructor());
    }
    private void loadAvailableInstructor() {
        DefaultTableModel model = (DefaultTableModel) availabeInstructor.getModel();
        model.setRowCount(0);

        String selectedCourse = courseAvailable.getSelectedItem().toString();
        
        if (selectedCourse != null && !selectedCourse.isEmpty()) {
            String query = "SELECT name, email, phone_number, address, assigned_course FROM f_db WHERE assigned_course = ?";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, selectedCourse);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getString("address"),
                            rs.getString("assigned_course")
                        });
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            model.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Please select a valid course.", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadSubjectTable() {
        DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
        model.setRowCount(0);

        String selectedCourse = courseAvailable.getSelectedItem().toString();
        String selectedYear = yearLevel.getSelectedItem().toString();
        
        if (selectedCourse.equals("BS in Information Technology") || 
            selectedCourse.equals("BS in Hospitality Management") || 
            selectedCourse.equals("BS in Computer Science") ||
            selectedCourse.equals("BS in Electrical Engineering")){

            String query = "SELECT subject_name, course, year_level FROM cm_db WHERE course = ? AND year_level = ?";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, selectedCourse);
                stmt.setString(2, selectedYear);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getString("subject_name"),
                            rs.getString("course"),
                            rs.getString("year_level")
                        });
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
            }
        } else {
            model.setRowCount(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sSubject = new javax.swing.JTextField();
        sDays = new javax.swing.JTextField();
        sTime = new javax.swing.JTextField();
        sRoom = new javax.swing.JTextField();
        sInstructor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        availabeInstructor = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        courseAvailable = new javax.swing.JComboBox<>();
        yearLevel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        sSubject.setForeground(new java.awt.Color(153, 153, 153));
        sSubject.setText("Subject");
        sSubject.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sSubjectFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sSubjectFocusLost(evt);
            }
        });
        sSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sSubjectActionPerformed(evt);
            }
        });

        sDays.setForeground(new java.awt.Color(153, 153, 153));
        sDays.setText("Days");
        sDays.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sDaysFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sDaysFocusLost(evt);
            }
        });

        sTime.setForeground(new java.awt.Color(153, 153, 153));
        sTime.setText("Time");
        sTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sTimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sTimeFocusLost(evt);
            }
        });

        sRoom.setForeground(new java.awt.Color(153, 153, 153));
        sRoom.setText("Room");
        sRoom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sRoomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sRoomFocusLost(evt);
            }
        });

        sInstructor.setForeground(new java.awt.Color(153, 153, 153));
        sInstructor.setText("Instructor");
        sInstructor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sInstructorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sInstructorFocusLost(evt);
            }
        });

        availabeInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Available Instructor"
            }
        ));
        jScrollPane1.setViewportView(availabeInstructor);

        addBtn.setBackground(new java.awt.Color(102, 204, 255));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        removeBtn.setBackground(new java.awt.Color(255, 0, 51));
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Subject"
            }
        ));
        jScrollPane2.setViewportView(subjectTable);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        courseAvailable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS in Information Technology", "BS in Hospitality Management", "BS in Computer Science", "BS in Electrical Engineering" }));

        yearLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2nd Year", "3rd Year", "4th Year" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(courseAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yearLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yearLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(courseAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sTime, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sDays, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sDays, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sTime, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
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

    private void sSubjectFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sSubjectFocusGained
        if (sSubject.getText().equals("Subject")){
            sSubject.setText("");
            sSubject.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_sSubjectFocusGained

    private void sSubjectFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sSubjectFocusLost
        if (sSubject.getText().equals("")){
            sSubject.setText("Subject");
            sSubject.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_sSubjectFocusLost

    private void sDaysFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sDaysFocusGained
        if (sDays.getText().equals("Days")){
            sDays.setText("");
            sDays.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_sDaysFocusGained

    private void sDaysFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sDaysFocusLost
        if (sDays.getText().equals("")){
            sDays.setText("Days");
            sDays.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_sDaysFocusLost

    private void sTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sTimeFocusGained
        if (sTime.getText().equals("Time")){
            sTime.setText("");
            sTime.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_sTimeFocusGained

    private void sTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sTimeFocusLost
        if (sTime.getText().equals("")){
            sTime.setText("Time");
            sTime.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_sTimeFocusLost

    private void sRoomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sRoomFocusGained
        if (sRoom.getText().equals("Room")){
            sRoom.setText("");
            sRoom.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_sRoomFocusGained

    private void sRoomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sRoomFocusLost
        if (sRoom.getText().equals("")){
            sRoom.setText("Room");
            sRoom.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_sRoomFocusLost

    private void sInstructorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sInstructorFocusGained
        if (sInstructor.getText().equals("Instructor")){
            sInstructor.setText("");
            sInstructor.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_sInstructorFocusGained

    private void sInstructorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sInstructorFocusLost
        if (sInstructor.getText().equals("")){
            sInstructor.setText("Instructor");
            sInstructor.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_sInstructorFocusLost

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Registrar backbtn = new Registrar(email);
        backbtn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void sSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sSubjectActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String password = "";
        
        String subject = sSubject.getText();
        String days = sDays.getText();
        String timeRange = sTime.getText();
        String room = sRoom.getText();
        String instructor = sInstructor.getText();
        String course = courseAvailable.getSelectedItem().toString();
        String yearLevel1 = yearLevel.getSelectedItem().toString();
        
        if (!timeRange.matches("\\d{1,2}:\\d{2} - \\d{1,2}:\\d{2}")){
            JOptionPane.showMessageDialog(this, "Invalid time range format. Use 'HH:mm - HH:mm'.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String[] timeParts = timeRange.split(" - ");
        String startTime = timeParts[0].trim();
        String endTime = timeParts[1].trim();
        
        startTime = formatTimeWithoutSeconds(startTime);
        endTime = formatTimeWithoutSeconds(endTime);
        
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String instructorValidationQuery = "SELECT COUNT(*) FROM f_db WHERE name = ?";
            try(PreparedStatement validateStmt = conn.prepareStatement(instructorValidationQuery)) {
                validateStmt.setString(1, instructor);
                ResultSet validateResult = validateStmt.executeQuery();
                if (validateResult.next() && validateResult.getInt(1) == 0){
                    JOptionPane.showMessageDialog(this, "Instructor not found. Please select a valid instructor.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            
            String conflictQuery = "SELECT COUNT(*) FROM cs_db WHERE instructor = ? AND days = ? AND " + "(? BETWEEN start_time AND end_time OR ? BETWEEN start_time AND end_time)";
            try (PreparedStatement conflictStmt = conn.prepareStatement(conflictQuery)) {
                conflictStmt.setString(1, instructor);
                conflictStmt.setString(2, days);
                conflictStmt.setString(3, startTime);
                conflictStmt.setString(4, endTime);
                ResultSet conflictResult = conflictStmt.executeQuery();
                if (conflictResult.next() && conflictResult.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Schedule conflict detected for this instructor. Please select a different time or instructor.", "Conflict Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            
            String query = "INSERT INTO cs_db (subject, days, start_time, end_time, room, instructor, course, year_level) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, subject);
                pstmt.setString(2, days);
                pstmt.setString(3, startTime);
                pstmt.setString(4, endTime);
                pstmt.setString(5, room);
                pstmt.setString(6, instructor);
                pstmt.setString(7, course);
                pstmt.setString(8, yearLevel1);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Added Schedule Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding schedule: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addBtnActionPerformed
    private String formatTimeWithoutSeconds(String time) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
            Date date = inputFormat.parse(time + ":00");
            return outputFormat.format(date);
        } catch (Exception e) {
            return time;
        }
    }
    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        int selectedRow = subjectTable.getSelectedRow();
        if (selectedRow != -1){
            DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
            String subjectName = model.getValueAt(selectedRow, 0).toString();
            
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove the selected subject?", "Confirm Remove", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                String deleteQuery = "DELETE FROM cm_db WHERE subject_name = ?";
                
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrjtl_db", "root", "");
                    PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
                    
                    stmt.setString(1, subjectName);
                    int rowsAffected = stmt.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Subject removed successfully.");
                        loadSubjectTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to remove the subject. It may not exist.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error removing subject: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a subject to remove.");
        }
    }//GEN-LAST:event_removeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable availabeInstructor;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> courseAvailable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextField sDays;
    private javax.swing.JTextField sInstructor;
    private javax.swing.JTextField sRoom;
    private javax.swing.JTextField sSubject;
    private javax.swing.JTextField sTime;
    private javax.swing.JTable subjectTable;
    private javax.swing.JComboBox<String> yearLevel;
    // End of variables declaration//GEN-END:variables
}
