import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AManagement extends javax.swing.JFrame {
    
    public AManagement() {
        initComponents();
        loadRegistrarTable();
        loadStudentTable();
        loadFacultyTable();
    }
    private void loadRegistrarTable(){
        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String password = "";
        
        String sql = "SELECT username FROM sign_up WHERE role = 'Registrar' AND status = 'pending'";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            DefaultTableModel model = (DefaultTableModel) registrarTable.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                String username = rs.getString("username");
                model.addRow(new Object[]{username});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading registrar table: " + ex.getMessage());
        }
    }
    
    private void loadStudentTable(){
        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String password = "";
        
        String sql = "SELECT username FROM sign_up WHERE role = 'Student' AND status = 'pending'";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                String username = rs.getString("username");
                model.addRow(new Object[]{username});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading registrar table: " + ex.getMessage());
        }
    }
    
    private void loadFacultyTable(){
        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String password = "";
        
        String sql = "SELECT username FROM sign_up WHERE role = 'Faculty' AND status = 'pending'";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            DefaultTableModel model = (DefaultTableModel) facultyTable.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                String username = rs.getString("username");
                model.addRow(new Object[]{username});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading registrar table: " + ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        facultyTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        registrarTable = new javax.swing.JTable();
        acceptBtn = new javax.swing.JButton();
        refuseBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        sLogo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Student"
            }
        ));
        jScrollPane1.setViewportView(studentTable);

        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Faculty"
            }
        ));
        jScrollPane2.setViewportView(facultyTable);

        registrarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Registrar"
            }
        ));
        jScrollPane3.setViewportView(registrarTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        acceptBtn.setBackground(new java.awt.Color(51, 204, 255));
        acceptBtn.setForeground(new java.awt.Color(255, 255, 255));
        acceptBtn.setText("Accept");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        refuseBtn.setBackground(new java.awt.Color(255, 0, 51));
        refuseBtn.setForeground(new java.awt.Color(255, 255, 255));
        refuseBtn.setText("Refuse");
        refuseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refuseBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        sLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/MRJTL.png"))); // NOI18N
        sLogo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sLogo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(refuseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refuseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Admin back = new Admin();
        back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        int selectedRowRegistrar = registrarTable.getSelectedRow();
        int selectedRowStudent = studentTable.getSelectedRow();
        int selectedRowFaculty = facultyTable.getSelectedRow();
        
        if (selectedRowRegistrar != -1) {
            updateRegistrarStatus("accepted");
        } else if (selectedRowStudent != -1) {
            updateStudentStatus("enrolled");
        } else if (selectedRowFaculty != -1){
            updateFacultyStatus("accepted");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a valid entry to accept.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void refuseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refuseBtnActionPerformed
        int selectedRowRegistrar = registrarTable.getSelectedRow();
        int selectedRowStudent = studentTable.getSelectedRow();
        int selectedRowFaculty = facultyTable.getSelectedRow();

        if (selectedRowRegistrar != -1) {
            updateRegistrarStatus("refused");
        } else if (selectedRowStudent != -1) {
            updateStudentStatus("refused");
        } else if (selectedRowFaculty != -1) {
            updateFacultyStatus("refused");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a valid entry to refuse.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_refuseBtnActionPerformed

    private void sLogo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sLogo1ActionPerformed

    }//GEN-LAST:event_sLogo1ActionPerformed
    private void updateRegistrarStatus(String newStatus){
        int selectedRow = registrarTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a registrar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String username = (String) registrarTable.getValueAt(selectedRow, 0);

        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String password = "";

        String sql = "UPDATE sign_up SET status = ? WHERE username = ? AND role = 'Registrar'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setString(2, username);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Registrar account " + newStatus + " successfully.");
                loadRegistrarTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update status. Please try again.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating status: " + ex.getMessage());
        }
    }
    
    private void updateStudentStatus(String newStatus){
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String username = (String) studentTable.getValueAt(selectedRow, 0);

        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String password = "";

        String sql = "UPDATE sign_up SET status = ? WHERE username = ? AND role = 'Student'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setString(2, username);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Student account accepted successfully.");
                loadStudentTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update status. Please try again.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating status: " + ex.getMessage());
        }
    }
    
    private void updateFacultyStatus(String newStatus){
        int selectedRow = facultyTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Faculty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String username = (String) facultyTable.getValueAt(selectedRow, 0);

        String url = "jdbc:mysql://localhost:3306/mrjtl_db";
        String user = "root";
        String password = "";

        String sql = "UPDATE sign_up SET status = ? WHERE username = ? AND role = 'Faculty'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setString(2, username);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Faculty account " + newStatus + " successfully.");
                loadFacultyTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update status. Please try again.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating status: " + ex.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(AManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTable facultyTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton refuseBtn;
    private javax.swing.JTable registrarTable;
    private javax.swing.JButton sLogo1;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
