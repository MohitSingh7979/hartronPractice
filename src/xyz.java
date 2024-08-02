
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class xyz extends javax.swing.JFrame {

  Connection con;
  String sql;

  void initConnection() {
    try {
      sql = "jdbc:mysql://localhost:3306/xyz";
      con = DriverManager.getConnection(sql, "root", "root");
    } catch (SQLException ex) {
      Logger.getLogger(xyz.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  ResultSet execute() {
    ResultSet rs = null;
    try {
      Statement st = con.createStatement();
      rs = st.executeQuery(sql);
    } catch (SQLException ex) {
      Logger.getLogger(xyz.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  ResultSet execute(Object[] data) {
    ResultSet rs = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql);

      Object[] data = new Object[col];
      for (int i = 0; i <) {
        ps.execute();
      }
    } catch (SQLException ex) {
      Logger.getLogger(xyz.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  void fillCombo(JComboBox box) {
    try {
      var rs = execute();
      box.removeAllItems();
      while (rs.next()) {
        box.addItem(rs.getString(1));
      }
    } catch (SQLException ex) {
      Logger.getLogger(xyz.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  void displayTable(JTable table) {

    try {
      var rs = execute();
      var model = (DefaultTableModel) table.getModel();
      model.setRowCount(0);
      var col = model.getColumnCount();
      while (rs.next()) {
        Object[] data = new Object[col];
        for (int i = 0; i < col; i++) {
          data[i] = rs.getObject(i + 1);
        }
        model.addRow(data);
      }
    } catch (SQLException ex) {
      Logger.getLogger(xyz.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public xyz() {
    initComponents();
    initConnection();
    fillTrainer();
    displayTable1();

  }

  void fillTrainer() {
    sql = "select trainer_name from trainer_master";
    fillCombo(trainer);
  }

  void displayTable1() {
    sql = " select"
      + " d.trainer_id,"
      + " trainee_id,"
      + " trainee_name,"
      + " passed"
      + " from trainer_master m"
      + " join trainee_details d"
      + " on m.trainer_id = d.trainer_id";
    displayTable(table1);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    btnSubmit = new javax.swing.JButton();
    trainer = new javax.swing.JComboBox<>();
    trainee = new javax.swing.JTextField();
    date = new javax.swing.JSpinner();
    course3 = new javax.swing.JTextField();
    course2 = new javax.swing.JTextField();
    course1 = new javax.swing.JTextField();
    pass = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    table1 = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Trainer Id");

    jLabel2.setText("Trainee Name");

    jLabel3.setText("Enrollment Date");

    jLabel4.setText("Course 1 Score");

    jLabel5.setText("Course 2 Score");

    jLabel6.setText("Course 3 Score");

    jLabel7.setText("Passed");

    btnSubmit.setText("Submit");
    btnSubmit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSubmitActionPerformed(evt);
      }
    });

    trainer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        trainerActionPerformed(evt);
      }
    });

    trainee.setText("java");

    date.setModel(new javax.swing.SpinnerDateModel());

    course3.setText("1");

    course2.setText("12");

    course1.setText("35");

    table1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Trainer ID", "Trainee ID", "Trainee Name", "Passed"
      }
    ));
    jScrollPane1.setViewportView(table1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnSubmit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
              .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57)))
            .addGap(38, 38, 38)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(course3)
              .addComponent(course2)
              .addComponent(course1)
              .addComponent(date)
              .addComponent(trainee)
              .addComponent(trainer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(pass)))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(13, 13, 13)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(trainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(trainee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(course1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(13, 13, 13)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel5)
            .addGap(13, 13, 13)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel6)
              .addComponent(course3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(10, 10, 10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7)
              .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(course2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(7, 7, 7)
        .addComponent(btnSubmit)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
    try {
      var trainerName = trainer.getSelectedItem();
      sql = ("select"
        + " trainer_id"
        + " from trainer_master"
        + " where trainer_name = '%s'").formatted(trainerName);
      var rs = execute();
      rs.next();
      var trainerId = rs.getObject(1);

      var traineeName = trainee.getText();

      var jdt = (java.util.Date) date.getValue();
      var eDate = new Date(jdt.getTime());

      var cs1 = Double.parseDouble(course1.getText());
      var cs2 = Double.parseDouble(course2.getText());
      var cs3 = Double.parseDouble(course3.getText());

      var totalMarks = cs1 + cs2 + cs3;
      var isPassed = (totalMarks) / 100 * 3;

      sql = "insert into trainee_details ("
        + " trainer_id,"
        + " trainee_name,"
        + " enrollment_date,"
        + " course1_score,"
        + " course2_score,"
        + " course3_score,"
        + " passed"
        + ") values (?,?,?,?,?,?,?)"
        + "";
      Object[] data = {
        trainerId,
        traineeName,
        eDate,
        cs1,
        cs2,
        cs3,
        isPassed
      };
      execute(data);

      displayTable1();
    } catch (SQLException ex) {
      Logger.getLogger(xyz.class.getName()).log(Level.SEVERE, null, ex);
    }

  }//GEN-LAST:event_btnSubmitActionPerformed

  private void trainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerActionPerformed

  }//GEN-LAST:event_trainerActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new xyz().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnSubmit;
  private javax.swing.JTextField course1;
  private javax.swing.JTextField course2;
  private javax.swing.JTextField course3;
  private javax.swing.JSpinner date;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField pass;
  private javax.swing.JTable table1;
  private javax.swing.JTextField trainee;
  private javax.swing.JComboBox<String> trainer;
  // End of variables declaration//GEN-END:variables
}
