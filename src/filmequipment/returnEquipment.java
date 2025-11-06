package filmequipment;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import javax.swing.RowFilter;

import javax.swing.table.TableRowSorter;



public final class returnEquipment extends javax.swing.JFrame {

   
    public returnEquipment() {
        initComponents();
        Connect();
        displayRentals();
        ReturnedEquip();
       
 
    
    }
    Connection con; 
    PreparedStatement pst;
    ResultSet rs; 
    
    public final void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void displayRentals() {
   
        try {
            Connect();
            
            
            String sql = "SELECT rentalID, equipmentID, client, rentDate, dueDate, total FROM rent WHERE status = 'In Rent'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            
            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            model.setRowCount(0);
            
           
            while (rs.next()) {
                String rentalID = rs.getString("rentalID");
                String equipmentID = rs.getString("equipmentID");
                String client = rs.getString("client");
                Date rentDate = rs.getDate("rentDate");
                Date dueDate = rs.getDate("dueDate");
                double total = rs.getDouble("total");
                
                model.addRow(new Object[]{rentalID, equipmentID, client, rentDate, dueDate, total});
            }
        } catch (SQLException ex) {
            Logger.getLogger(returnEquipment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ReturnedEquip() {
    
        try {
            Connect();
            
            String sql = "SELECT * FROM returnequip";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
           
            DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
            model.setRowCount(0);
            
            while (rs.next()) {
                String rentalID = rs.getString("rentalID");
                String equipmentID = rs.getString("equipmentID");
                String client = rs.getString("client");
                Date rentDate = rs.getDate("rentDate");
                Date dueDate = rs.getDate("dueDate");
                Date returnDate = rs.getDate("returnDate");
                long elapsedDays = rs.getLong("elapsedDays");
                String condition = rs.getString("equipCondition");
                double charge = rs.getDouble("charge");
                
                model.addRow(new Object[]{rentalID, equipmentID, client, rentDate, dueDate, returnDate, elapsedDays, condition, charge});
            }
        } catch (SQLException ex) {
            Logger.getLogger(returnEquipment.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

  

  
    

  
    
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        txtrentid = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRID = new javax.swing.JTextField();
        txtclient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtrent = new javax.swing.JTextField();
        txtdue = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtelapsed = new javax.swing.JTextField();
        txtcharge = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cmbcon = new javax.swing.JComboBox<>();
        txtEID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpayment = new javax.swing.JTextField();
        txtchange = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        s2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        s1 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtrentid.setBackground(new java.awt.Color(255, 255, 255));
        txtrentid.setForeground(new java.awt.Color(0, 102, 51));

        jLabel1.setText("Rental ID");

        jLabel2.setText("Equip. ID");

        jLabel3.setText("Client");

        txtRID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRIDActionPerformed(evt);
            }
        });

        txtclient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclientActionPerformed(evt);
            }
        });

        jLabel6.setText("Due Date");

        jLabel7.setText("Return Date");

        jLabel11.setText("Rent Date");

        jLabel16.setText("Elapsed");

        jLabel17.setText("Condition");

        jLabel18.setText("Charge");

        txtelapsed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelapsedActionPerformed(evt);
            }
        });

        txtcharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchargeActionPerformed(evt);
            }
        });

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        jDateChooser2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooser2KeyPressed(evt);
            }
        });

        jButton3.setText("GENERATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("COMPUTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cmbcon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Damaged", "Good" }));
        cmbcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbconActionPerformed(evt);
            }
        });
        cmbcon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbconKeyReleased(evt);
            }
        });

        txtEID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtrentidLayout = new javax.swing.GroupLayout(txtrentid);
        txtrentid.setLayout(txtrentidLayout);
        txtrentidLayout.setHorizontalGroup(
            txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtrentidLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtrentidLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtclient, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(txtrentidLayout.createSequentialGroup()
                        .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtrentidLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtRID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtrentidLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdue, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(txtrent))))
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtrentidLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtrentidLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5))
                            .addComponent(jLabel16)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtrentidLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtrentidLayout.createSequentialGroup()
                        .addComponent(cmbcon, 0, 94, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(txtrentidLayout.createSequentialGroup()
                        .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcharge, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtelapsed, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        txtrentidLayout.setVerticalGroup(
            txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtrentidLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(txtrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtelapsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtrentidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Payment");

        jLabel10.setText("Change");

        txtpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaymentActionPerformed(evt);
            }
        });
        txtpayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpaymentKeyReleased(evt);
            }
        });

        jButton1.setText("RETURN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        jLabel21.setText("Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtchange, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtpayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Return ID", "Equip. ID", "Client", "Rent Date", "Due Date", "Return Date", "Elapsed", "Condition", "Charge"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Returned Equipment");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Search");

        s2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19)
                    .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Rented Equipment");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Rental ID", "Equip. ID", "Client", "Rent Date", "Due Date", "Total Fee"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Search");

        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });
        s1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(153, 153, 255));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Return Equipment");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("X");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(16, 16, 16))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel20))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtrentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtchargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchargeActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable5.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();

       
        String rentalID = model.getValueAt(selectedRow, 0).toString();
        String equipmentID = model.getValueAt(selectedRow, 1).toString();
        String client = model.getValueAt(selectedRow, 2).toString();
        java.util.Date rentDate = (java.util.Date) model.getValueAt(selectedRow, 3);
        java.util.Date dueDate = (java.util.Date) model.getValueAt(selectedRow, 4);
        
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String rent = SimpleDateFormat.format(rentDate);
        String due = SimpleDateFormat.format(dueDate);

       
        txtRID.setText(rentalID);
        txtEID.setText(equipmentID); 
        txtclient.setText(client); 
        txtrent.setText(rent);
        txtdue.setText(due);
        
    }//GEN-LAST:event_jTable5MouseClicked
     
    private void cmbconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbconActionPerformed

    private void txtelapsedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelapsedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelapsedActionPerformed

    private void cmbconKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbconKeyReleased
    String cond = cmbcon.getSelectedItem().toString();
    
    
    if ("Damaged".equals(cond)){
        String chargeText = txtcharge.getText();
        double charge = Double.parseDouble(chargeText);
       txtcharge.setText(String.format("%.2f", charge + 50));
        
    }
    }//GEN-LAST:event_cmbconKeyReleased

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jDateChooser2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser2KeyPressed
        
       
    }//GEN-LAST:event_jDateChooser2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String dueDateText = txtdue.getText().trim();

    
    if (dueDateText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Due Date cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date dueDate;

    try {
        dueDate = sdf.parse(dueDateText);
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Invalid Due Date format. Please use yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }


    Date returnDate = jDateChooser2.getDate();
    if (returnDate == null) {
        JOptionPane.showMessageDialog(this, "Return Date cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

   
    long elapsedTime = returnDate.getTime() - dueDate.getTime();
    long elapsedDays = TimeUnit.MILLISECONDS.toDays(elapsedTime);

    if (elapsedDays < 0) {
        JOptionPane.showMessageDialog(this, "Return Date cannot be earlier than Due Date.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    double dailyRate = 50.0;
    double charge = elapsedDays * dailyRate;

   
    txtelapsed.setText(String.valueOf(elapsedDays));
    txtcharge.setText(String.format("%.2f", charge));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String cond = cmbcon.getSelectedItem().toString();  
        String eid = txtEID.getText();
        double totalAmount = Double.parseDouble(txtcharge.getText());
            
            
            if ("Damaged".equals(cond)) {
        
            try {
                pst = con.prepareStatement("SELECT * FROM managequipment WHERE equipId =?");
                pst.setString(1, eid);
                rs = pst.executeQuery();
             
               if(rs.next()) {
                     double total = Double.parseDouble(rs.getString("fee"));
                     double total8 = Double.parseDouble(txtcharge.getText());
                    
          
                    double Charge = total8 + (total * 0.10);
                    String total2 = String.format("%.2f", Charge);
                    txttotal.setText(total2); 
                
               }    
            } catch (SQLException ex) {
                Logger.getLogger(returnEquipment.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
                  
            } else {
                String total2 = String.format("%.2f", totalAmount);
                txttotal.setText(total2);
            }
            
         
            

           
           

       
           

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtpaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaymentKeyReleased
        try {
      
        double totalAmount = Double.parseDouble(txttotal.getText());

      
        String payText = txtpayment.getText();
        double payAmount = 0.0;

      
        if (!payText.isEmpty()) {
            try {
                payAmount = Double.parseDouble(payText);  
            } catch (NumberFormatException e) {
    
                JOptionPane.showMessageDialog(this, "Invalid payment entered.");
                return;
            }
        }

       
        double changeAmount = payAmount - totalAmount;

     
        txtchange.setText(String.format("%.2f", changeAmount)); 

    } catch (NumberFormatException ex) {
        
        JOptionPane.showMessageDialog(this, "Invalid total amount entered.");
    }
    }//GEN-LAST:event_txtpaymentKeyReleased

    private void txtpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaymentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
   
    Connect();
    if (con == null) {
        JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

 
    String rentalID = txtRID.getText().trim();
    if (rentalID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Rental ID cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String equipId = txtEID.getText().trim();
    String client = txtclient.getText().trim();
    if (equipId.isEmpty() || client.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter valid Equipment ID and Client!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String rentDate = txtrent.getText().trim();
    String dueDate = txtdue.getText().trim();
    Date returnDate = jDateChooser2.getDate();

  
    if (returnDate == null) {
        JOptionPane.showMessageDialog(this, "Return Date cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

  
    if (rentDate.isEmpty() || dueDate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Rent Date and Due Date cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }


    String elapsedDays = txtelapsed.getText().trim();
    if (elapsedDays.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Elapsed Days cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String chargeText = txtcharge.getText().trim();
    double charge;

    try {
        charge = Double.parseDouble(chargeText);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid charge value!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String equipCondi;
    String status;

    if ("Damaged".equals(cmbcon.getSelectedItem().toString())) {
        equipCondi = "Damaged";
        status = "In Repair";
    } else {
        equipCondi = "Good";
        status = "Available";
    }

    // Step 3: Update the equipment status
    String sqlUpdateEquip = "UPDATE managequipment SET equipCondition = ?, status = ? WHERE equipId = ?";
    try (PreparedStatement pstUpdateEquip = con.prepareStatement(sqlUpdateEquip)) {
        pstUpdateEquip.setString(1, equipCondi);
        pstUpdateEquip.setString(2, status);
        pstUpdateEquip.setString(3, equipId);

        int equipmentUpdateResult = pstUpdateEquip.executeUpdate();

      
        String sqlUpdateRental = "UPDATE rent SET status = ? WHERE rentalID = ?";
        try (PreparedStatement pstUpdateRental = con.prepareStatement(sqlUpdateRental)) {
            pstUpdateRental.setString(1, "Returned");
            pstUpdateRental.setString(2, rentalID);

            int rentalUpdateResult = pstUpdateRental.executeUpdate();

     
            String sqlInsertReturn = "INSERT INTO returnequip (rentalID, equipmentID, client, rentDate, dueDate, returnDate, elapsedDays, equipCondition, charge) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstInsert = con.prepareStatement(sqlInsertReturn)) {
                pstInsert.setString(1, rentalID);
                pstInsert.setString(2, equipId);
                pstInsert.setString(3, client);
                 pstInsert.setString(4, rentDate);
                pstInsert.setString(5, dueDate);
                
                pstInsert.setDate(6, new java.sql.Date(returnDate.getTime()));
                pstInsert.setInt(7, Integer.parseInt(elapsedDays));
                pstInsert.setString(8, equipCondi);
                pstInsert.setDouble(9, charge);

                int insertResult = pstInsert.executeUpdate();

              
                if (equipmentUpdateResult > 0 && rentalUpdateResult > 0 && insertResult > 0) {
                    JOptionPane.showMessageDialog(this, "Equipment successfully returned!");

          
                    txtRID.setText("");
                    txtEID.setText("");
                    txtclient.setText("");
                    txtrent.setText("");
                    txtdue.setText("");
                    txtelapsed.setText("");
                    cmbcon.setSelectedIndex(0);
                    txtcharge.setText("");
                    txtchange.setText("");
                    jDateChooser2.setDate(null);

                  
                    displayRentals();
                    ReturnedEquip();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to return equipment.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} catch (HeadlessException ex) {
    JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtclientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientActionPerformed

    private void txtRIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRIDActionPerformed

    private void txtEIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEIDActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1ActionPerformed

    private void s1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s1KeyPressed
       DefaultTableModel obj =(DefaultTableModel) jTable5.getModel();
       TableRowSorter<DefaultTableModel> obj1=new TableRowSorter<>(obj);
       jTable5.setRowSorter(obj1);
       obj1.setRowFilter(RowFilter.regexFilter(s1.getText()));
    }//GEN-LAST:event_s1KeyPressed

    private void s2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s2KeyPressed
        // TODO add your handling code here:
       DefaultTableModel obj =(DefaultTableModel) jTable6.getModel();
       TableRowSorter<DefaultTableModel> obj1=new TableRowSorter<>(obj);
       jTable6.setRowSorter(obj1);
       obj1.setRowFilter(RowFilter.regexFilter(s2.getText()));
    }//GEN-LAST:event_s2KeyPressed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Menu().setVisible(true);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        this.setVisible(false);
        new Menu().setVisible(true);
    }//GEN-LAST:event_jPanel14MouseClicked
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new returnEquipment().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField s1;
    private javax.swing.JTextField s2;
    private javax.swing.JTextField txtEID;
    private javax.swing.JTextField txtRID;
    private javax.swing.JTextField txtchange;
    private javax.swing.JTextField txtcharge;
    private javax.swing.JTextField txtclient;
    private javax.swing.JTextField txtdue;
    private javax.swing.JTextField txtelapsed;
    private javax.swing.JTextField txtpayment;
    private javax.swing.JTextField txtrent;
    private javax.swing.JPanel txtrentid;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
