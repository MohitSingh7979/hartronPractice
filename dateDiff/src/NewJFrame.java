
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
//        setDateLimit(dateFrom, 1, 1);
//        setDateLimit(dateTo, 1, 1);

    }

    private void setDateLimit(JSpinner spin, int st, int end) {
        SpinnerDateModel sdm = (SpinnerDateModel) spin.getModel();

        Date now = new Date();
        now.setYear(now.getYear() - st);
        sdm.setStart(now);

        now = new Date();
        now.setYear(now.getYear() + end);
        sdm.setEnd(now);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        dateFrom = new javax.swing.JSpinner();
        dateTo = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("name");

        jLabel2.setText("OLD DATE");

        jLabel3.setText("NEW DATE");

        btnAdd.setText("Add");

        dateFrom.setModel(new javax.swing.SpinnerDateModel());
        dateFrom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dateFromStateChanged(evt);
            }
        });

        dateTo.setModel(new javax.swing.SpinnerDateModel());
        dateTo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dateToStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(dateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(dateTo, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateFrom, dateTo, jLabel3, name});

        jLabel1.getAccessibleContext().setAccessibleName("");
        jLabel2.getAccessibleContext().setAccessibleName("");
        jLabel3.getAccessibleContext().setAccessibleName("");
        name.getAccessibleContext().setAccessibleName("");
        btnAdd.getAccessibleContext().setAccessibleName("");
        dateFrom.getAccessibleContext().setAccessibleName("");
        dateTo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateToStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dateToStateChanged
//        chronoDate();
        datePassedOrNot();

    }//GEN-LAST:event_dateToStateChanged

    private void dateFromStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dateFromStateChanged
//        chronoDate();
        datePassedOrNot();

    }//GEN-LAST:event_dateFromStateChanged

    private void datePassedOrNot() {

        Calendar oldDate = Calendar.getInstance();
        Date javaFromDate = (java.util.Date) dateFrom.getValue();
        oldDate.setTime(javaFromDate);

        Calendar newDate = Calendar.getInstance();
        Date javaToDate = (java.util.Date) dateTo.getValue();
        newDate.setTime(javaToDate);
        System.out.println(oldDate.get(Calendar.LONG_FORMAT));
//        if (oldYear>newYear) {
//            System.out.println("Passed");
//        }else{
//            System.out.println("Not Passed");
//        }
    }

    private void chronoDate() {
        Date fromDate = (Date) dateFrom.getValue();
        LocalDate fromLocalDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Date toDate = (Date) dateTo.getValue();
        LocalDate toLocalDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long yrDiff = ChronoUnit.YEARS.between(fromLocalDate, toLocalDate);
        System.out.println(yrDiff);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JSpinner dateFrom;
    private javax.swing.JSpinner dateTo;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
