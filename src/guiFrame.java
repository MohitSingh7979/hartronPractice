
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class guiFrame extends javax.swing.JFrame {

    Connection con;
    String sql;

    public guiFrame() {
        initComponents();
        createConnection();

    }

    private void fillRoles() {
        sql = "SELECT role_name,role_min_marks FROM role_master";
        int nqtMarks = Integer.parseInt(nqt.getValue().toString());
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            role.removeAllItems();
            while (rs.next()) {
                int roleMarks = Integer.parseInt(rs.getString(2));
                if (nqtMarks >= roleMarks) {
                    role.addItem(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/roles_again", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        grade = new javax.swing.JSpinner();
        nqt = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        role = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CANDIDATE");

        jLabel2.setText("ID");

        jLabel3.setText("NAME");

        jLabel4.setText("GRAD DATE");

        date.setModel(new javax.swing.SpinnerDateModel());

        jLabel5.setText("GRAD GRADE");

        grade.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 10.0d, 0.1d));

        nqt.setModel(new javax.swing.SpinnerNumberModel(0, 0, 120, 1));
        nqt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nqtStateChanged(evt);
            }
        });

        jLabel6.setText("NQT MARKS");

        jLabel7.setText("APPLY FOR ROLE");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CANDIATE ID", "CANDIDATE NAME", "ROLE APPLIED", "ROLE GIVEN"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("ADD CANDIDATE DETAILS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(id)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(grade)
                                    .addComponent(nqt)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nqt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nqtStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nqtStateChanged
        fillRoles();
    }//GEN-LAST:event_nqtStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int canId = Integer.parseInt(id.getValue().toString());
            sql = "SELECT * FROM role_master where role_code = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, canId);
            if(!ps.execute()){
                JOptionPane.showMessageDialog(rootPane, " change can id");
                return;
            }
            String canName = name.getText();

            java.util.Date javaDate = (java.util.Date) date.getValue();
            Date gradDate = new Date(javaDate.getTime());

            double canGrade = Double.parseDouble(grade.getValue().toString());
            int nqtMarks = Integer.parseInt(nqt.getValue().toString());

            sql = "SELECT role_code FROM role_master where role_name = ?";
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setString(1, role.getSelectedItem().toString());
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            int roleCode = rs1.getInt(1);


            sql = "INSERT INTO `roles_again`.`candidate_details` ("
                    + "     `can_id`,"
                    + "     `can_name`, "
                    + "     `can_grad_date`, "
                    + "     `can_grad_grade`, "
                    + "     `can_nqt_marks`, "
                    + "     `can_apply_for`"
                    + ") VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement ps2 = con.prepareStatement(sql);
                        ps2.setInt(1, canId);
                        ps2.setString(2, canName);
                        ps2.setDate(3, gradDate);
                        ps2.setDouble(4, canGrade);
                        ps2.setInt(5, nqtMarks);
                        ps2.setInt(6, roleCode);
                        ps2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner date;
    private javax.swing.JSpinner grade;
    private javax.swing.JSpinner id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField name;
    private javax.swing.JSpinner nqt;
    private javax.swing.JComboBox<String> role;
    // End of variables declaration//GEN-END:variables
}
