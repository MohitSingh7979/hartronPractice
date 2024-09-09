
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

  private Connection con;
  String sql;

  public MainFrame() {
    initComponents();
    setCon("between_dates", "root", "root");

  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("jLabel1");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(212, 212, 212)
        .addComponent(jLabel1)
        .addContainerGap(544, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(59, 59, 59)
        .addComponent(jLabel1)
        .addContainerGap(427, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainFrame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  // End of variables declaration//GEN-END:variables

  private void setCon(String tableName, String usr, String psw) {
    try {
      String url = ("jdbc:mysql://localhost:3306/%s").formatted(tableName);
      this.con = DriverManager.getConnection(url, usr, psw);
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void fillcombo(JComboBox box) {
    try {
      box.removeAllItems();
      ResultSet rs = exe();
      while (rs.next()) {
        box.addItem(rs.getString(1));
      }
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public ResultSet exe() {
    ResultSet rs = null;
    try {
      Statement st = con.createStatement();
      rs = st.executeQuery(sql);
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  public ResultSet exe(Object[] data) {
    ResultSet rs = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      for (int i = 0; i < data.length; i++) {
        ps.setObject(i + 1, data[i]);
      }
      ps.execute();
      rs = ps.getGeneratedKeys();

    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  public void displayTable(JTable table) {
    try {
      ResultSet rs = exe();
      var model = (DefaultTableModel) table.getModel();
      model.setRowCount(0);
      int col = model.getColumnCount();
      while (rs.next()) {
        var data = new Object[col];
        for (int i = 0; i < col; i++) {
          data[i] = rs.getObject(i + 1);
        }
        model.addRow(data);
      }
    } catch (SQLException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
