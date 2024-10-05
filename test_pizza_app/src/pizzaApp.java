
import java.awt.Color;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerModel;
import javax.swing.table.DefaultTableModel;

public class pizzaApp extends javax.swing.JFrame {

    Connection con;
    PreparedStatement ps;
    String sql;

    public pizzaApp() {
        initComponents();
        initConnection();
        fillPizzaName();
        sync();
        showReport1();
        showReport2();
    }

    private void showReport2() {
        sql = "SELECT"
                + "     name,"
                + "     sum(timestampdiff(minute, ordered_at, delivered_at)<=34) as ontime,"
                + "     sum(timestampdiff(minute, ordered_at, delivered_at)>34) as offtime"
                + " FROM order_details od  join pizza_master pm on pizza_id=pm.id group by name";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) report2.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] data = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
//                    rs.getObject(4),
                    0
                };
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pizzaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sync() {
        try {
            if (pizza.getSelectedItem() != null) {

                int quan = (int) quantity.getValue();

                String[] pizzaItem = pizza.getSelectedItem().toString().split("-");
                int pizzaId = Integer.parseInt(pizzaItem[0]);

                sql = "SELECT price*? as total,price,cost FROM pizza_master pm where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, quan);
                ps.setInt(2, pizzaId);
                ResultSet rs = ps.executeQuery();
                rs.next();
                double total = rs.getDouble(1);
                double price = rs.getDouble(2);
                double costVal = rs.getDouble(3);

                double delCharge = total < 499.0 ? 40 : 0;
                double customerCost = total + delCharge;

                double savVal = quan * (price - costVal);

                charges.setValue(delCharge);
                cusTotal.setValue(customerCost);
                saving.setValue(savVal);

            }
        } catch (SQLException ex) {
            Logger.getLogger(pizzaApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showReport1() {
        sql = "SELECT"
                + "     name,"
                + "     quantity,"
                + "     cost,"
                + "     saving "
                + " FROM order_details od  join pizza_master pm on pizza_id=pm.id where timestampdiff(minute, ordered_at, delivered_at)<=34";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) report1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] data = new Object[]{
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),};
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pizzaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillPizzaName() {
        boolean isVeg = veg.isSelected();
        sql = "SELECT * FROM pizza_master pm where is_veg = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, isVeg);
            ResultSet rs = ps.executeQuery();
            pizza.removeAllItems();
            while (rs.next()) {
                pizza.addItem(("%s-%s").formatted(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pizzaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_pizza_app", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(pizzaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        orderPizzaBtn = new javax.swing.JButton();
        id = new javax.swing.JSpinner();
        pizza = new javax.swing.JComboBox<>();
        quantity = new javax.swing.JSpinner();
        orderedAt = new javax.swing.JSpinner();
        deliveredAt = new javax.swing.JSpinner();
        cusTotal = new javax.swing.JSpinner();
        saving = new javax.swing.JSpinner();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        report1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        report2 = new javax.swing.JTable();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        veg = new javax.swing.JCheckBox();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        charges = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("PIZZA");

        jLabel3.setText("QUANTITY");

        jLabel4.setText("ORDERED AT");

        jLabel5.setText("DELIVERED AT");

        jLabel6.setText("CUSTOMER TOTAL");

        jLabel7.setText("SAVING");

        orderPizzaBtn.setText("ORDER PIZZA");
        orderPizzaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderPizzaBtnActionPerformed(evt);
            }
        });

        id.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                idStateChanged(evt);
            }
        });

        pizza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pizza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pizzaItemStateChanged(evt);
            }
        });
        pizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaActionPerformed(evt);
            }
        });

        quantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        quantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantityStateChanged(evt);
            }
        });

        orderedAt.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1727774919854L), null, null, java.util.Calendar.MINUTE));

        deliveredAt.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1727774933266L), null, null, java.util.Calendar.MINUTE));

        report1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PIZZA NAME", "QUANTITY", "COST", "SAVING"
            }
        ));
        jScrollPane1.setViewportView(report1);

        report2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PIZZA NAME", "LATE ORDERS", "ON TIME ORDERS", "CUSTOMER SAVING"
            }
        ));
        jScrollPane2.setViewportView(report2);

        jLabel8.setText("VEG");

        veg.setText("Yes");
        veg.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vegStateChanged(evt);
            }
        });

        jLabel9.setText("DELIVERY CHARGES");

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
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pizza, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(veg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderedAt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deliveredAt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saving, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(orderPizzaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(charges, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cusTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(veg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pizza, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderedAt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deliveredAt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(charges, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cusTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saving, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(orderPizzaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vegStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vegStateChanged
        fillPizzaName();
        sync();

    }//GEN-LAST:event_vegStateChanged

    private void orderPizzaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderPizzaBtnActionPerformed
        try {
            int orderId = (int) id.getValue();
            sql = "SELECT * FROM order_details od where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id.setBackground(Color.red);
                return;
            }

            String[] pizzaItem = pizza.getSelectedItem().toString().split("-");
            int pizzaId = Integer.parseInt(pizzaItem[0]);

            sql = "INSERT INTO `test_pizza_app`.`order_details` ("
                    + "     `id`, "
                    + "     `pizza_id`, "
                    + "     `quantity`, "
                    + "     `ordered_at`, "
                    + "     `delivered_at`, "
                    + "     `delivery_charges`, "
                    + "     `customer_total`, "
                    + "     `saving`"
                    + " ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, pizzaId);
            ps.setObject(3, quantity.getValue());
            ps.setObject(4, orderedAt.getValue());
            ps.setObject(5, deliveredAt.getValue());
            ps.setObject(6, charges.getValue());
            ps.setObject(7, cusTotal.getValue());
            ps.setObject(8, saving.getValue());
            ps.executeUpdate();
            showReport1();

        } catch (SQLException ex) {
            Logger.getLogger(pizzaApp.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_orderPizzaBtnActionPerformed

    private void pizzaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pizzaItemStateChanged
        sync();
    }//GEN-LAST:event_pizzaItemStateChanged

    private void pizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pizzaActionPerformed
        sync();
    }//GEN-LAST:event_pizzaActionPerformed

    private void quantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantityStateChanged
        sync();

    }//GEN-LAST:event_quantityStateChanged

    private void idStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_idStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_idStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pizzaApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner charges;
    private javax.swing.JSpinner cusTotal;
    private javax.swing.JSpinner deliveredAt;
    private javax.swing.JSpinner id;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orderPizzaBtn;
    private javax.swing.JSpinner orderedAt;
    private javax.swing.JComboBox<String> pizza;
    private javax.swing.JSpinner quantity;
    private javax.swing.JTable report1;
    private javax.swing.JTable report2;
    private javax.swing.JSpinner saving;
    private javax.swing.JCheckBox veg;
    // End of variables declaration//GEN-END:variables
}
