
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class MainFrame extends javax.swing.JFrame {

  private Connection con;
  String sql;

  public MainFrame() {
    initComponents();
    setCon(con);
    fillVehType();

  }

  void fillVehType() {
    sql = "SELECT vehicle_type_name FROM xyz2.vehicle_master;";
    comboBox(sql, vehicleType);

  }

  void comboBox(String sql, JComboBox box) {
    box.removeAllItems();
    try {
      ResultSet rs = exe(sql);
      while (rs.next()) {
        box.addItem(rs.getString(1));
      }
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public ResultSet exe(String sql1) {
    ResultSet rs = null;
    Statement st;
    try {
      st = con.createStatement();
      rs = st.executeQuery(sql1);
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  void setTaxField() {
    double p = Double.parseDouble(price.getText());
    boolean con = p > 3000000;
    String c = "";
    double t = p - (con ? p * 18 / 100 : p * 12 / 100);
    c += t;

    tax.setText(c);

  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    vehicleType = new javax.swing.JComboBox<>();
    vehicleName = new javax.swing.JTextField();
    date = new javax.swing.JSpinner();
    price = new javax.swing.JTextField();
    tax = new javax.swing.JTextField();
    javax.swing.JButton jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Vehicle Type");

    jLabel2.setText("Vehicle Name");

    jLabel3.setText("Manufaturing Date");

    jLabel4.setText("Price");

    jLabel5.setText("Tax");

    vehicleType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    vehicleName.setText("v1");

    date.setModel(new javax.swing.SpinnerDateModel());

    price.setText("3000000");

    tax.setEditable(false);

    jButton1.setText("Purchase");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Vehicle Type ID", "Vehicle ID", "Vehicle Name", "Manufaturing Date", "Vehicle Type Name", "Price"
      }
    ));
    jScrollPane1.setViewportView(jTable1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(vehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(vehicleName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(51, 51, 51)
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(86, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(vehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(vehicleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
      // TODO add your handling code here:

      var vehType = vehicleType.getSelectedItem();
      var vehName = vehicleName.getText();

      sql = "SELECT vehicle_type_id FROM xyz2.vehicle_master where vehicle_type_name = '" + vehType + "' ;";
      var rs = exe(sql);
      rs.next();
      var vehId = rs.getObject(1);

      var jdt = (java.util.Date) date.getValue();
      var mdt = new Date(jdt.getTime());

      setTaxField();

      sql = ""
        + " insert into vehicle_details ("
        + " vehicle_type_id,"
        + " vehicle_name,"
        + " manufacturing_date,"
        + " price,"
        + " tax"
        + " ) values (?,?,?,?,?)";

      Object[] data = {
        vehId,
        vehName,
        mdt,
        price.getText(),
        tax.getText()
      };

      exe(sql, data);
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

  }//GEN-LAST:event_jButton1ActionPerformed

  public void exe(String sql, Object[] data) {
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      for (int i = 0; i < data.length; i++) {
        ps.setObject(i + 1, data[i]);
      }
      ps.execute();
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainFrame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JSpinner date;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JTextField price;
  private javax.swing.JTextField tax;
  private javax.swing.JTextField vehicleName;
  private javax.swing.JComboBox<String> vehicleType;
  // End of variables declaration//GEN-END:variables

  public void setCon(Connection con) {
    try {
      String url;
      this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz2", "root", "root");
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
