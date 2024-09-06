
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    Connection con;
    String sql;

    void fillAuthor() {
        sql = "SELECT am.author_name FROM library.author_master am;";
        try {
            ResultSet rs = execute();
            author.removeAllItems();
            while (rs.next()) {
                author.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public GUI() {
        initComponents();
        initConnection();
        fillAuthor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        author = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        book = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        price = new javax.swing.JSpinner();
        btnAddBookDetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("author");

        jLabel2.setText("title");

        jLabel3.setText("pulication date");

        date.setModel(new javax.swing.SpinnerDateModel());

        jLabel4.setText("price");

        price.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnAddBookDetails.setText("Add Book Details");
        btnAddBookDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(author, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnAddBookDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddBookDetails)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBookDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookDetailsActionPerformed
        // TODO add your handling code here:
        sql = ("SELECT author_id FROM library.author_master a WHERE author_name = '%s'").formatted(author.getSelectedItem());
        int authorId = getId();

        java.util.Date javaDate = (java.util.Date) date.getValue();
        Date sqlDate = new Date(javaDate.getTime());

        sql = "INSERT INTO `library`.`book` (`author_id`, `book_title`, `publication_date`, `price`) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setObject(1, authorId);
            pst.setObject(2, book.getText());
            pst.setObject(3, sqlDate);
            pst.setObject(4, price.getValue());
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Details inserted successfull");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAddBookDetailsActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> author;
    private javax.swing.JTextField book;
    private javax.swing.JButton btnAddBookDetails;
    private javax.swing.JSpinner date;
    private javax.swing.JSpinner price;
    // End of variables declaration//GEN-END:variables
    void initConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    ResultSet execute() {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return rs;
    }

    int getId() {
        int id = 0;
        try {
            ResultSet rs = execute();
            rs.next();
            id = rs.getInt(1);
        } catch (Exception e) {
        }
        return id;
    }
}
