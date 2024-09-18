
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;// comment
import java.util.Vector;// comment
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class gui extends javax.swing.JFrame {

    Connection connection;
    boolean runProgram;

    void showReport() {
        try {
            String sql = "SELECT"
                    + " student_name,"
                    + " student_s1_marks,"
                    + " student_s2_marks,"
                    + " student_s3_marks"
                    + " FROM students_details";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) report1.getModel();
            dtm.setRowCount(0);
            int col = dtm.getColumnCount();
            while (rs.next()) {
                int s1m = rs.getInt(2);
                int s2m = rs.getInt(3);
                int s3m = rs.getInt(4);

                String status = (s1m + s2m + s3m) / 3 > 30 ? "Passed" : "Failed";

//                Object[] rowData = new Object[col];
//                rowData[0] = s1m;
//                rowData[1] = s2m;
//                rowData[2] = s3m;
//                rowData[3] = rs.getString(4);
//                rowData[4] = status;
//                dtm.addRow(rowData);
//                ArrayList<Object> rowData = new ArrayList<>();
//                rowData.add(s1m);
//                rowData.add(s2m);
//                rowData.add(s3m);
//                rowData.add(rs.getString(4));
//                rowData.add(status);
//                dtm.addRow(rowData.toArray());
                Object[] rowData = new Object[]{
                    rs.getString(1),
                    s1m,
                    s2m,
                    s3m,
                    status
                };
                dtm.addRow(rowData);

//                Vector<Object> rowData = new Vector<>();
//                rowData.add(s1m);
//                rowData.add(s2m);
//                rowData.add(s3m);
//                rowData.add(rs.getString(4));
//                rowData.add(status);
//                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public gui() {
        initComponents();
        initConn();
        showReport();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel heading = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        s1 = new javax.swing.JSpinner();
        s2 = new javax.swing.JSpinner();
        s3 = new javax.swing.JSpinner();
        statusOut = new javax.swing.JTextField();
        addStudentDetailsBtn = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        report1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        heading.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Student Details");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Student Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Subject 1 Mark");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Subject 3 Mark");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Subject 2 Mark");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Status");

        s1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                s1StateChanged(evt);
            }
        });

        s2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                s2StateChanged(evt);
            }
        });

        s3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                s3StateChanged(evt);
            }
        });

        statusOut.setEditable(false);

        addStudentDetailsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addStudentDetailsBtn.setText("Add Student");
        addStudentDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentDetailsBtnActionPerformed(evt);
            }
        });

        report1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Subject Name", "Marks in s1", "Marks in s2", "Marks in s3", "Status"
            }
        ));
        jScrollPane1.setViewportView(report1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(statusOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(addStudentDetailsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusOut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addComponent(addStudentDetailsBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentDetailsBtnActionPerformed
        if (runProgram) {
            try {
                // TODO add your handling code here:
                String sql = "INSERT INTO `students`.`students_details` (`student_name`, `student_s1_marks`, `student_s2_marks`, `student_s3_marks`) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setObject(1, name.getText());
                ps.setObject(2, s1.getValue());
                ps.setObject(3, s2.getValue());
                ps.setObject(4, s3.getValue());

                ps.executeUpdate();
                showReport();
            } catch (SQLException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addStudentDetailsBtnActionPerformed

    private void s1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_s1StateChanged
        // TODO add your handling code here:
        var submarks = s1.getValue();
        var marks = Integer.parseInt(submarks.toString());

        if (marks > 100 || marks < 0) {
            JOptionPane.showMessageDialog(rootPane, marks < 0 ? " enter marks above 0" : " enter marks below 100");
            s1.setValue(0);
            runProgram = false;
        } else {
            runProgram = true;
        }
    }//GEN-LAST:event_s1StateChanged

    private void s2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_s2StateChanged
        // TODO add your handling code here:
        var submarks = s2.getValue();
        var marks = Integer.parseInt(submarks.toString());
        runProgram = (marks >= 0 && marks <= 100);
        if (!runProgram) {
            JOptionPane.showMessageDialog(rootPane, marks < 0 ? " enter marks above 0" : " enter marks below 100");
            s2.setValue(0);
        }
    }//GEN-LAST:event_s2StateChanged

    private void s3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_s3StateChanged
        // TODO add your handling code here:
        var submarks = s3.getValue();
        var marks = Integer.parseInt(submarks.toString());
        runProgram = (marks >= 0 && marks <= 100);
        if (runProgram) {
            return;
        }
        JOptionPane.showMessageDialog(rootPane, marks < 0 ? " enter marks above 0" : " enter marks below 100");
        s3.setValue(0);

    }//GEN-LAST:event_s3StateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentDetailsBtn;
    private javax.swing.JTextField name;
    private javax.swing.JTable report1;
    private javax.swing.JSpinner s1;
    private javax.swing.JSpinner s2;
    private javax.swing.JSpinner s3;
    private javax.swing.JTextField statusOut;
    // End of variables declaration//GEN-END:variables

    void initConn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
