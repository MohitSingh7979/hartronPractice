
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

  Connection con;
  String sql;

  void initConn() {
    try {
      sql = "jdbc:mysql://localhost:3306/abc";
      con = DriverManager.getConnection(sql, "root", "root");
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  ResultSet exe() {
    ResultSet rs = null;
    try {
      Statement st = con.createStatement();
      rs = st.executeQuery(sql);
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  ResultSet exe(Object[] data) {
    ResultSet rs = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      for (int i = 0; i < data.length; i++) {
        ps.setObject(i + 1, data[i]);
      }
      ps.execute();
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  void fillCombo(JComboBox box) {
    try {
      var rs = exe();
      box.removeAllItems();
      while (rs.next()) {
        box.addItem(rs.getString(1));
      }
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  void displayTable(JTable table) {
    try {
      var rs = exe();

      var model = (DefaultTableModel) table.getModel();
      model.setRowCount(0);
      var col = model.getColumnCount();

      Object[] data = new Object[col];
      for (int i = 0; i < col; i++) {
        data[i] = rs.getObject(i + 1);
        model.addRow(data);
      }
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public MainFrame() {
    initComponents();
    initConn();
    fillBlock();
    fillSchool();
    displayTable1();
  }

  void fillBlock() {
    sql = "select block_name from block_master";
    fillCombo(block);
  }

  void fillSchool() {
    sql = "select school_name from school_master";
    fillCombo(school);
  }

  void displayTable1() {
    sql = "select"
      + " b.block_name,"
      + " sum(school_id)"
      + " from block_master"
      + " join school_master s"
      + " on b.block_id = s.block_id"
      + " group by b.block_name";

    displayTable(table1);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    block = new javax.swing.JComboBox<>();
    school = new javax.swing.JComboBox<>();
    power = new javax.swing.JCheckBox();
    water = new javax.swing.JCheckBox();
    btnAdd = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    table1 = new javax.swing.JTable();
    javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
    withoutPower = new javax.swing.JLabel();
    withoutWater = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Block");

    jLabel2.setText("School");

    jLabel3.setText("Powrer Supply");

    jLabel4.setText("Water Supply");

    power.setText("Y / N");

    water.setText("Y / N");

    btnAdd.setText("Add");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAddActionPerformed(evt);
      }
    });

    table1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "BLOCK NAME", "TOTAL SCHOOL IN BLOCK"
      }
    ));
    jScrollPane1.setViewportView(table1);

    jLabel5.setText("Total no of school without power supply");

    jLabel6.setText("Total no of school without water supply");

    withoutPower.setText("      ");

    withoutWater.setText("    ");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(withoutWater))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                      .addGap(80, 80, 80)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(school, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(block, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                      .addGap(18, 18, 18)
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(power, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(water, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(withoutPower)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(block, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(school, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(power))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(water))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(btnAdd)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(withoutPower))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(withoutWater))
        .addContainerGap(21, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    try {
      var blkName = block.getSelectedItem();
      sql = ("select"
        + " block_id from block_master"
        + " where block_name = '%s'").formatted(blkName);

      var schlName = school.getSelectedItem();
      var rs = exe();
      rs.next();
      var blkId = rs.getObject(1);

      sql = ("select"
        + " school_id from school_master"
        + " where school_name = '%s'").formatted(schlName);
      rs = exe();
      rs.next();
      var schlId = rs.getObject(1);

      sql = "insert into utility_details ("
        + " block_id,"
        + " school_id,"
        + " power_supply,"
        + " water_supply"
        + " ) values (?,?,?,?)";
      Object[] data = {
        blkId,
        schlId,
        power.isSelected(),
        water.isSelected(),};
      exe(data);

//      sql = "";
//      rs = exe();
//      rs.next();
//      withoutPower.setText(rs.getString(1));
//
//       sql = "";
//      rs = exe();
//      rs.next();
//      withoutWater.setText(rs.getString(1));
      displayTable1();
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnAddActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainFrame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> block;
  private javax.swing.JButton btnAdd;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JCheckBox power;
  private javax.swing.JComboBox<String> school;
  private javax.swing.JTable table1;
  private javax.swing.JCheckBox water;
  private javax.swing.JLabel withoutPower;
  private javax.swing.JLabel withoutWater;
  // End of variables declaration//GEN-END:variables
}
