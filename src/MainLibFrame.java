
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class MainLibFrame extends javax.swing.JFrame {

  Connection con;

  String sql;

  public MainLibFrame() {
    initComponents();
    setCon(con);
    fillBook();
    fillMember();
    fillStaff();
    fillBorrowId();

  }

  public void fillBorrowId() {
    sql = "SELECT borrowing_id FROM library_manages.fine";
    fillCombo(borrow);
  }

  public void fillStaff() {
    sql = "SELECT staff_name FROM library_manages.staff_member";
    fillCombo(staff);
  }

  public void fillMember() {
    sql = "SELECT member_name FROM library_manages.member_master;";
    fillCombo(member);
  }

  public void fillBook() {
    sql = "SELECT title FROM book_master";
    fillCombo(book);
  }

  public void fillCombo(JComboBox<String> box) {
    try {
      var rs = exe();
      box.removeAllItems();
      while (rs.next()) {
        box.addItem(rs.getString(1));
      }
    } catch (SQLException ex) {
      Logger.getLogger(MainLibFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public ResultSet exe() {
    ResultSet rs = null;
    try {
      Statement st = con.createStatement();
      rs = st.executeQuery(sql);
    } catch (SQLException ex) {
      Logger.getLogger(MainLibFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  public ResultSet exe(Object[] obj) {
    ResultSet rs = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      while (rs.next()) {
        for (int i = 0; i < obj.length; i++) {
          obj[i] = rs.getObject(i + 1);
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(MainLibFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    btnBorrow = new javax.swing.JButton();
    book = new javax.swing.JComboBox<>();
    member = new javax.swing.JComboBox<>();
    staff = new javax.swing.JComboBox<>();
    date = new javax.swing.JSpinner();
    javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
    btnReturn = new javax.swing.JButton();
    borrow = new javax.swing.JComboBox<>();
    returnDate = new javax.swing.JSpinner();
    amount = new javax.swing.JTextField();
    statusPayment = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    table1 = new javax.swing.JTable();
    jScrollPane2 = new javax.swing.JScrollPane();
    table2 = new javax.swing.JTable();
    dueDate = new javax.swing.JSpinner();
    javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    btnFine = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    fine = new javax.swing.JComboBox<>();
    jLabel7 = new javax.swing.JLabel();
    fineAmount = new javax.swing.JComboBox<>();
    jLabel12 = new javax.swing.JLabel();
    paying = new javax.swing.JSpinner();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Book");

    jLabel2.setText("Member");

    jLabel3.setText("Staff");

    jLabel4.setText("Borrowing Date");

    btnBorrow.setText("Borrow");
    btnBorrow.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBorrowActionPerformed(evt);
      }
    });

    book.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    member.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    staff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    date.setModel(new javax.swing.SpinnerDateModel());

    jLabel8.setText("Borrowing Id");

    jLabel9.setText("Return Date");

    jLabel10.setText("Fine Amount");

    jLabel11.setText("Payment Status");

    btnReturn.setText("Return");
    btnReturn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnReturnActionPerformed(evt);
      }
    });

    borrow.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    returnDate.setModel(new javax.swing.SpinnerDateModel());

    amount.setText("100");
    amount.setEnabled(false);

    statusPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unpaid", "Paid", "Partially Paid" }));

    table1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Book Title", "Total Borrowed Copies", "Total Fines Collection"
      }
    ));
    jScrollPane1.setViewportView(table1);

    table2.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Member Name", "Borrowing Date", "Book Title", "Return Date", "Fine Amount"
      }
    ));
    jScrollPane2.setViewportView(table2);

    dueDate.setModel(new javax.swing.SpinnerDateModel());

    jLabel5.setText("Due Date");

    btnFine.setText("Fine");
    btnFine.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnFineActionPerformed(evt);
      }
    });

    jLabel6.setText("Fine ID");

    fine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    jLabel7.setText("Fees to be Paid");

    fineAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    jLabel12.setText("Paying");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staff, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(member, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                      .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(borrow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(statusPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(54, 54, 54)
                        .addComponent(paying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(81, 81, 81))))))
          .addGroup(layout.createSequentialGroup()
            .addGap(46, 46, 46)
            .addComponent(btnBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel6)
        .addGap(28, 28, 28)
        .addComponent(fine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(35, 35, 35)
        .addComponent(jLabel7)
        .addGap(34, 34, 34)
        .addComponent(fineAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnFine))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(staff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5)
              .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel8)
              .addComponent(borrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9))
              .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11))
              .addGroup(layout.createSequentialGroup()
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnReturn)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnBorrow)
        .addGap(33, 33, 33)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnFine)
          .addComponent(jLabel6)
          .addComponent(fine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7)
          .addComponent(fineAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel12)
          .addComponent(paying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(92, 92, 92)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowActionPerformed

    var bookId = findFromSQL("book_id", "book_master", "book_name", book);
    var memberId = findFromSQL("member_id", "member_master", "member_name", member);

    var borrowingDate = getDate(date);
    var dDate = getDate(dueDate);

    sql = ("SELECT book_id FROM library_manages.book_master where title = '%s';").formatted();

    Object[] data = {
      bookId,
      memberId,
      borrowingDate,
      dDate, //      returnDate,
    //      status
    };
  }//GEN-LAST:event_btnBorrowActionPerformed

  private void btnFineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFineActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnFineActionPerformed

  private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnReturnActionPerformed

  public int findFromSQL(String select, String from, String where, JComboBox equalToComboBox) {
    int id = 0;
    try {
      var item = equalToComboBox.getSelectedItem();
      sql = ("SELECT '%s' FROM '%s' where '%s' = '%s';").formatted(select, from, where, item);
      var rs = exe();
      rs.next();
      id = rs.getInt(1);
    } catch (SQLException ex) {
      Logger.getLogger(MainLibFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    return id;
  }

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainLibFrame().setVisible(true);

      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField amount;
  private javax.swing.JComboBox<String> book;
  private javax.swing.JComboBox<String> borrow;
  private javax.swing.JButton btnBorrow;
  private javax.swing.JButton btnFine;
  private javax.swing.JButton btnReturn;
  private javax.swing.JSpinner date;
  private javax.swing.JSpinner dueDate;
  private javax.swing.JComboBox<String> fine;
  private javax.swing.JComboBox<String> fineAmount;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JComboBox<String> member;
  private javax.swing.JSpinner paying;
  private javax.swing.JSpinner returnDate;
  private javax.swing.JComboBox<String> staff;
  private javax.swing.JComboBox<String> statusPayment;
  private javax.swing.JTable table1;
  private javax.swing.JTable table2;
  // End of variables declaration//GEN-END:variables

  public void setCon(Connection con) {
    try {
      String url = "jdbc:mysql://localhost:3306/library_manages";
      String usr = "root";
      String psw = "root";
      con = DriverManager.getConnection(url, usr, psw);
    } catch (SQLException ex) {
      Logger.getLogger(MainLibFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Date getDate(javax.swing.JSpinner date) {
    var jdt = (java.util.Date) date.getValue();
    return new java.sql.Date(jdt.getTime());
  }
}
