
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

public class guiFrame extends javax.swing.JFrame {

    Connection con;
    String sql;

    public guiFrame() {
        initComponents();
        initConnection();
        showReport();

// doj 5
// now 10
// doj -  now >= 1 ? 12.5 : 0
//        java.util.Date doj = (java.util.Date) date.getValue();
//        Date now= new Date();
//        if(now.compareTo(doj)>=1){
//            System.out.println("1 year completed");
//        }
// doj 5
// now 10
// dop doj+1yr
// dop<= now  ? 12.5 : 0
        java.util.Date doj = (java.util.Date) date.getValue();
        Date dop = doj;
        dop.setYear(doj.getYear() + 1);

        Date now = new Date();

        if (now.compareTo(dop) <= 1) {
            System.out.println("1 year completed");
        }

//        java.util.Date javaDate = (java.util.Date) date.getValue();
////        Date sqlDate = new Date(javaDate.getTime());
//
//        Date newDate= javaDate;
//        newDate.setYear(javaDate.getYear()+3);
//
//        Date now = new Date();
//
//        if(newDate.compareTo(now)){
//        }
//        Date now = new Date();
//        SpinnerDateModel sdm = (SpinnerDateModel) date.getModel();
//        now.setYear(now.getYear()-2);
//        sdm.setStart(now);
//
//        now = new Date();
//        now.setYear(now.getYear()+2);
//        sdm.setEnd(now);
    }

    private void showReport() {
        sql = "SELECT "
                + "     can_id,"
                + "     can_name,"
                + "     role_name,"
                + "     can_nqt_marks"
                + " FROM candidate_details cd join  role_master rm on cd.can_apply_for = rm.role_code";
        try {
            PreparedStatement ps1 = con.prepareStatement(sql);
            ResultSet rs1 = ps1.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) report.getModel();
            dtm.setRowCount(0);

            while (rs1.next()) {
                int nqtMarksSql = Integer.parseInt(rs1.getString(4));
                Vector roleNames = new Vector();

                sql = "SELECT role_name,role_min_marks FROM role_master";
                PreparedStatement ps2 = con.prepareStatement(sql);
                ResultSet rs2 = ps2.executeQuery();

                while (rs2.next()) {
                    int minMax = Integer.parseInt(rs2.getString(2));
                    if (nqtMarksSql >= minMax) {
                        roleNames.add(rs2.getString(1));
                    }
                }

                Object[] rowDate = new Object[]{
                    rs1.getString(1),
                    rs1.getString(2),
                    rs1.getString(3),
                    roleNames
                };
                dtm.addRow(rowDate);
            }

        } catch (SQLException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void fillRoles() {
        sql = "SELECT role_name, role_min_marks FROM role_master";
        int nqtMarks = Integer.parseInt(nqt.getValue().toString());

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            role.removeAllItems();
            while (rs.next()) {
                int roleMarks = Integer.parseInt(rs.getString(2));
                if (roleMarks <= nqtMarks) {
                    role.addItem(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roles", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id = new javax.swing.JSpinner();
        name = new javax.swing.JTextField();
        date = new javax.swing.JSpinner();
        grade = new javax.swing.JSpinner();
        nqt = new javax.swing.JSpinner();
        role = new javax.swing.JComboBox<>();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        report = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CANDIDATE");

        jLabel2.setText("ID");

        jLabel3.setText("NAME");

        jLabel4.setText("GRAD DATE");

        jLabel5.setText("GRAD GRADE");

        jLabel6.setText("NQT MARKS");

        jLabel7.setText("ROLE");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("ADD DETAILS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        date.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1727245208485L), null, null, java.util.Calendar.MONTH));
        date.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dateStateChanged(evt);
            }
        });

        grade.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(0.100000024f)));

        nqt.setModel(new javax.swing.SpinnerNumberModel(0, 0, 120, 1));
        nqt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nqtStateChanged(evt);
            }
        });

        report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CANDIDATE ID", "CANDIDATE NAME", "ROLE APPLIED", "ROLE GIVEN"
            }
        ));
        report.setEnabled(false);
        jScrollPane1.setViewportView(report);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nqt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nqt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            if (role.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "cannot take admission");
                return;
            }

            int cId = Integer.parseInt(id.getValue().toString());

//            sql = "SELECT can_id FROM candidate_details";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int canId = Integer.parseInt(rs.getString(1));
//                if (cId == canId) {
//                    JOptionPane.showMessageDialog(rootPane, "id already exits");
//                }
//            }

            sql = "select can_id from candidate_details where can_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(rootPane, "id already exits");
                return;
            }

            String cName = name.getText();

            java.util.Date javaDate = (java.util.Date) date.getValue();
            Date sqlDate = new Date(javaDate.getTime());

            double gGrade = Double.parseDouble(grade.getValue().toString());

            int nqtMarks = Integer.parseInt(nqt.getValue().toString());

            String roleSel = role.getSelectedItem().toString();

            sql = "SELECT role_code FROM role_master where role_name = ?";
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setString(1, roleSel);
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            int roleId = rs1.getInt(1);

            sql = "INSERT INTO `roles`.`candidate_details` ("
                    + "     `can_id`,"
                    + "     `can_name`,"
                    + "     `can_grad_date`,"
                    + "     `can_grad_grade`,"
                    + "     `can_nqt_marks`,"
                    + "     `can_apply_for`"
                    + ") VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps2 = con.prepareStatement(sql);
            ps2.setInt(1, cId);
            ps2.setString(2, cName);
            ps2.setObject(3, sqlDate);
            ps2.setDouble(4, gGrade);
            ps2.setInt(5, nqtMarks);
            ps2.setInt(6, roleId);

            ps2.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "insertion done");

            showReport();
        } catch (SQLException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void nqtStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nqtStateChanged
        // TODO add your handling code here:
        fillRoles();
    }//GEN-LAST:event_nqtStateChanged

    private void dateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dateStateChanged
        // TODO add your handling code here:

// doj 5
// now 10
// now - doj >= 1 ? 12.5 : 0
        java.util.Date doj = (java.util.Date) date.getValue();
        Date now = new Date();
        System.out.println(now.compareTo(doj));
    }//GEN-LAST:event_dateStateChanged

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
    private javax.swing.JTextField name;
    private javax.swing.JSpinner nqt;
    private javax.swing.JTable report;
    private javax.swing.JComboBox<String> role;
    // End of variables declaration//GEN-END:variables
}
