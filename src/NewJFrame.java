
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NewJFrame extends javax.swing.JFrame {

  Connection con;
  String sql;

  public NewJFrame() {
    initComponents();
    initConnection();
    fillPatient();
    fillDoctor();
    displayTable1();
    displayTable2();
  }

  void initConnection() {
    try {
      String url = "jdbc:mysql://localhost:3306/hms";
      con = DriverManager.getConnection(url, "root", "root");

    } catch (SQLException ex) {
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  ResultSet execute() {
    ResultSet rs = null;
    try {
      Statement st = con.createStatement();
      rs = st.executeQuery(sql);
    } catch (SQLException ex) {
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  ResultSet execute(Object[] data) {
    ResultSet rs = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql,
        PreparedStatement.RETURN_GENERATED_KEYS);
      for (int i = 0; i < data.length; i++) {
        ps.setObject(i + 1, data[i]);
      }
      ps.execute();
      rs = ps.getGeneratedKeys();

    } catch (SQLException ex) {
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
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
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  void displayTable(JTable table) {
    try {
      var rs = execute();
      var mdl = (DefaultTableModel) table.getModel();
      mdl.setRowCount(0);
      var col = mdl.getColumnCount();
      while (rs.next()) {
        Object[] data = new Object[col];
        for (int i = 0; i < col; i++) {
          data[i] = rs.getObject(i + 1);
        }
        mdl.addRow(data);
      }

    } catch (SQLException ex) {
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  void fillPatient() {
    sql = " select"
      + " patient_name"
      + " from"
      + " patient_master"
      + "";
    fillCombo(patientAppoint);
    sql = " select"
      + " distinct patient_name"
      + " from"
      + " appointment a"
      + " join patient_master p"
      + " on a.patient_id = p.patient_id"
      + "";
    fillCombo(patientTreat);
  }

  void fillDoctor() {
    sql = " select"
      + " doctor_name"
      + " from"
      + " doctor_master"
      + "";
    fillCombo(doctorAppoint);
    sql = " select "
      + " distinct doctor_name"
      + " from"
      + " appointment a"
      + " join doctor_master d"
      + " on a.doctor_id = d.doctor_id"
      + "";
    fillCombo(doctorTreat);
  }

  void fillAppoint() {
    var patName = patientTreat.getSelectedItem();
    var docName = doctorTreat.getSelectedItem();

    sql = ("select appointment_id from appointment a "
      + " join doctor_master d"
      + " on a.doctor_id = d.doctor_id"
      + " join patient_master p"
      + " on a.patient_id = p.patient_id"
      + " where doctor_name = '%s' and patient_name = '%s'").formatted(docName, patName);
    fillCombo(appointIdTreat);
  }

  void displayTable1() {
    sql = " select"
      + " doctor_name,"
      + " count(*),"
      + " sum(charges)"
      + " from"
      + " doctor_master d"
      + " join treatment t"
      + " on d.doctor_id = t.doctor_id"
      + " group by doctor_name"
      + "";
    displayTable(jTable1);
  }

  void displayTable2() {
    sql = " select"
      + " patient_name,"
      + " appointment_date,"
      + " doctor_name,"
      + " b.treatment_id,"
      + " sum(total_amount)"
      + " from"
      + " patient_master p"
      + " join appointment a"
      + " on p.patient_id = a.patient_id"
      + " join doctor_master d"
      + " on a.doctor_id = d.doctor_id"
      + " join treatment t"
      + " on t.appointment_id = a.appointment_id"
      + " join billing b"
      + " on t.treatment_id = b.treatment_id"
      + " group by patient_name, appointment_date, doctor_name, b.treatment_id"
      + " ";
    displayTable(jTable2);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
    appointDate = new javax.swing.JSpinner();
    javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    doctorAppoint = new javax.swing.JComboBox<>();
    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    fee = new javax.swing.JTextField();
    javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    patientAppoint = new javax.swing.JComboBox<>();
    btnAppoint = new javax.swing.JButton();
    statusAppoint = new javax.swing.JComboBox<>();
    javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
    javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
    treatDate = new javax.swing.JSpinner();
    javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
    doctorTreat = new javax.swing.JComboBox<>();
    javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
    diagnosis = new javax.swing.JTextField();
    javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
    patientTreat = new javax.swing.JComboBox<>();
    javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
    medication = new javax.swing.JTextField();
    charges = new javax.swing.JTextField();
    javax.swing.JLabel jLabel16 = new javax.swing.JLabel();
    appointIdTreat = new javax.swing.JComboBox<>();
    javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
    statusTreat = new javax.swing.JComboBox<>();
    btnTreat = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    appointDate.setModel(new javax.swing.SpinnerDateModel());

    jLabel3.setText("Doctor");

    jLabel7.setText("Fee");

    jLabel4.setText("Appointment Date");

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Appointment");
    jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    fee.setText("200");

    jLabel2.setText("Patient");

    btnAppoint.setText("appoint");
    btnAppoint.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAppointActionPerformed(evt);
      }
    });

    statusAppoint.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Confirmed", "Cancelled" }));

    jLabel12.setText("Status");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnAppoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(statusAppoint, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(doctorAppoint, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(appointDate)
                  .addComponent(fee)
                  .addComponent(patientAppoint, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(patientAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(doctorAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(appointDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel12)
          .addComponent(statusAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnAppoint))
    );

    treatDate.setModel(new javax.swing.SpinnerDateModel());

    jLabel8.setText("Doctor");

    jLabel9.setText("Treatment Date");

    jLabel10.setText("Diagnosis");

    jLabel11.setText("Medication");

    doctorTreat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        doctorTreatActionPerformed(evt);
      }
    });

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel13.setText("Treatment");
    jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    diagnosis.setText("cancer");

    jLabel14.setText("Patient");

    patientTreat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        patientTreatActionPerformed(evt);
      }
    });

    jLabel15.setText("Charges");

    medication.setText("chemo");

    charges.setText("100");

    jLabel16.setText("Appointment ID");

    jLabel6.setText("Status");

    statusTreat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unpaid", "Paid", "Partial" }));

    btnTreat.setText("treat");
    btnTreat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnTreatActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnTreat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
              .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(patientTreat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(doctorTreat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(treatDate)
              .addComponent(diagnosis)
              .addComponent(medication)
              .addComponent(charges)
              .addComponent(appointIdTreat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(statusTreat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel13)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel14)
          .addComponent(patientTreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(doctorTreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel16)
          .addComponent(appointIdTreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9)
          .addComponent(treatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel10)
          .addComponent(diagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel11)
          .addComponent(medication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel15)
          .addComponent(charges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(statusTreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
        .addComponent(btnTreat))
    );

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Doctor Name", "Total Patients", "Total Earning"
      }
    ));
    jScrollPane1.setViewportView(jTable1);

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Patient Name", "Appointment Date", "Doctor Name", "Treatment", "Charges"
      }
    ));
    jScrollPane2.setViewportView(jTable2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(16, Short.MAX_VALUE))
      .addComponent(jScrollPane1)
      .addComponent(jScrollPane2)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnAppointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointActionPerformed
    try {
      var patientAppoint = (String) this.patientAppoint.getSelectedItem();
      var doctorAppoint = (String) this.doctorAppoint.getSelectedItem();
      sql = (" select"
        + " (select patient_id from patient_master"
        + " where patient_name = '%s' ),"
        + " (select doctor_id from doctor_master"
        + " where doctor_name = '%s' )"
        + " ").formatted(patientAppoint, doctorAppoint);

      var rs = execute();
      rs.next();
      var patientId = rs.getInt(1);
      var doctorId = rs.getInt(2);

      var jdt = (java.util.Date) appointDate.getValue();
      var aDate = new Date(jdt.getTime());

      var sdf = new SimpleDateFormat("hh:mm:ss");
      var aTime = sdf.format(jdt.getTime());

      sql = "insert into appointment ("
        + " patient_id,"
        + " doctor_id,"
        + " appointment_date,"
        + " appointment_time,"
        + " status,"
        + " fee "
        + " ) values ( ?,?,?,?,?,? )"
        + " ";

      Object[] data = {
        patientId,
        doctorId,
        aDate,
        aTime,
        statusAppoint.getSelectedItem(),
        fee.getText()
      };
      execute(data);

      displayTable1();
      displayTable2();
      fillPatient();
      fillDoctor();
      fillAppoint();
    } catch (SQLException ex) {
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

  }//GEN-LAST:event_btnAppointActionPerformed

  private void btnTreatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreatActionPerformed
    try {
      var patName = patientTreat.getSelectedItem();
      sql = ("select"
        + " patient_id"
        + " from patient_master"
        + " where patient_name = '%s'").formatted(patName);
      var rs = execute();
      rs.next();
      var patientId = rs.getInt(1);

      var docName = doctorTreat.getSelectedItem();
      sql = ("select"
        + " doctor_id"
        + " from doctor_master"
        + " where doctor_name = '%s'").formatted(docName);
      rs = execute();
      rs.next();
      var doctorId = rs.getInt(1);

      var appointId = appointIdTreat.getSelectedItem();

      var jdt = (java.util.Date) treatDate.getValue();
      var tDate = new Date(jdt.getTime());

      sql = "insert into treatment ("
        + " patient_id,"
        + " doctor_id,"
        + " appointment_id,"
        + " treatment_date,"
        + " diagnosis,"
        + " medication,"
        + " charges"
        + " ) values (?,?,?,?,?,?,?)"
        + " ";
      Object[] data = {
        patientId,
        doctorId,
        appointId,
        tDate,
        diagnosis.getText(),
        medication.getText(),
        charges.getText()
      };
      rs = execute(data);

      rs.next();
      var treatId = rs.getInt(1);
      System.out.println(treatId);
      var bDate = tDate;

      var charges = this.charges.getText();
      var payStatusBill = statusTreat.getSelectedItem();
      sql = (" select"
        + " fee + %s"
        + " from"
        + " appointment a"
        + " where appointment_id = %s").formatted(charges, appointId);
      rs = execute();
      rs.next();
      var totalAmount = rs.getObject(1);
      sql = "insert into billing("
        + " patient_id,"
        + " treatment_id,"
        + " bill_date,"
        + " total_amount,"
        + " payment_status"
        + " ) values (?,?,?,?,?)";
      Object[] billInfo = {
        patientId,
        treatId,
        bDate,
        totalAmount,
        payStatusBill,};
      execute(billInfo);

      displayTable1();
      displayTable2();
    } catch (SQLException ex) {
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_btnTreatActionPerformed

  private void patientTreatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientTreatActionPerformed

    if (patientTreat.getSelectedIndex() != -1) {
      fillAppoint();
    }
  }//GEN-LAST:event_patientTreatActionPerformed

  private void doctorTreatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorTreatActionPerformed

    if (doctorTreat.getSelectedIndex() != -1) {
      fillAppoint();
    }
  }//GEN-LAST:event_doctorTreatActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new NewJFrame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JSpinner appointDate;
  private javax.swing.JComboBox<String> appointIdTreat;
  private javax.swing.JButton btnAppoint;
  private javax.swing.JButton btnTreat;
  private javax.swing.JTextField charges;
  private javax.swing.JTextField diagnosis;
  private javax.swing.JComboBox<String> doctorAppoint;
  private javax.swing.JComboBox<String> doctorTreat;
  private javax.swing.JTextField fee;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable jTable2;
  private javax.swing.JTextField medication;
  private javax.swing.JComboBox<String> patientAppoint;
  private javax.swing.JComboBox<String> patientTreat;
  private javax.swing.JComboBox<String> statusAppoint;
  private javax.swing.JComboBox<String> statusTreat;
  private javax.swing.JSpinner treatDate;
  // End of variables declaration//GEN-END:variables
}
