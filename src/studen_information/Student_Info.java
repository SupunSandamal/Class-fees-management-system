package studen_information;

import java.sql.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.sun.jdi.event.StepEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.nio.channels.Selector;
import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;

public class Student_Info extends javax.swing.JFrame {

    int StudentNumber;
    String StudentName;
    String Address;
    int ContactNumber;
    String Year;
    String Subject;
    java.util.Date PaymentDate;
    java.util.Date DateOfRegistration;
   
    
    public Student_Info() {
        initComponents();
        Connect();
        StudentNo();
        }
    
    
    Connection con;
    PreparedStatement select;
    int c;
    
    
    private void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studen_information", "root", "");
            
            select = con.prepareStatement("SELECT * FROM `student_info`");
            
            ResultSet rs = select.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel) jTable2.getModel();
            for (int i = df.getRowCount() - 1; i >= 0; i--) {
                df.removeRow(i);
            }
            //df.setRowCount(0);
            
            while (rs.next()) {
                Vector v = new Vector();
                
                for (int a = 1; a <= c; a++) {
                    v.add(rs.getString("StudentNumber"));
                    v.add(rs.getString("StudentName"));
                    v.add(rs.getString("Address"));
                    v.add(rs.getString("ContactNumber"));
                    v.add(rs.getString("Year"));
                    v.add(rs.getString("subject"));
                    v.add(rs.getString("PaymentDate"));
                    v.add(rs.getString("DateOfRegistation"));
                    
                    }
                df.addRow(v);
            }
            
        }
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void StudentNo(){
      
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select MAX(StudentNumber) as lastnumber from student_info");
        rs.next();
        
        int num = Integer.parseInt(rs.getString("lastnumber"));
        
        jTextField1.setText(String.valueOf(num + 1));
        
        
    }   catch (SQLException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 1, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Registration");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 5, -1, -1));

        jLabel2.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student_Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 119, 194, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 126, 265, -1));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 166, 230, -1));

        jLabel3.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student_Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 169, 169, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 176, 265, -1));

        jLabel4.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 219, 91, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 226, 265, -1));

        jLabel5.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact_Number");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 271, -1, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 278, 265, -1));

        jLabel6.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Year");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 322, 91, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 329, 265, -1));

        jLabel7.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Subject");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 371, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Information & Communication Technology", "Science For Technology", "Enginearing Technology" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 378, -1, -1));

        jLabel9.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Date_Of_Registration");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 412, -1, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 419, 265, -1));

        jLabel8.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Date_Of_Payment");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 453, -1, -1));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 460, 265, -1));

        jButton2.setBackground(new java.awt.Color(102, 255, 255));
        jButton2.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 266, 230, 38));

        jButton3.setBackground(new java.awt.Color(102, 255, 255));
        jButton3.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 369, 230, 32));

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setFont(new java.awt.Font("Imprint MT Shadow", 1, 18)); // NOI18N
        jButton4.setText("Back ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 452, 120, 30));

        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "Student Name", "Address", "Contact Number", "Year", "Subject", "Date Of Registation"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 507, 810, 160));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 890, 680));

        jLabel10.setIcon(new javax.swing.ImageIcon("E:\\Supun program\\Student Information\\Studen_Information\\pexels-photo.jpg")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jDateChooser1.setToolTipText("");
            jDateChooser2.setToolTipText("");
            
            StudentNo();
            

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        Searching_Form search_form =new Searching_Form();
        search_form.show();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection con;
        PreparedStatement Update;

        try {

            StudentNumber = Integer.parseInt(jTextField1.getText());
            StudentName = jTextField2.getText();
            Address = jTextField3.getText();
            ContactNumber = Integer.parseInt(jTextField4.getText());
            Year = jComboBox1.getSelectedItem().toString();
            Subject =  jComboBox2.getSelectedItem().toString();
            //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            //DateOfRegistration = jDateChooser1.getDate();
            PaymentDate = jDateChooser2.getDate();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studen_information", "root", "");

            Update = con.prepareStatement("UPDATE student_info set `StudentName`=?, `Address`=?, `ContactNumber`=?, `Year`=?, `Subject`=? , PaymentDate=? where `StudentNumber`=?");
            

            Update.setString(1, StudentName);
            Update.setString(2, Address);
            Update.setInt(3, ContactNumber);

            Update.setString(4, Year);
            Update.setString(5, Subject);
            //Update.setDate(6, DateOfRegistration);
            Update.setDate(6, new java.sql.Date(PaymentDate.getTime()));
            Update.setInt(7, StudentNumber);
            
            Update.executeUpdate();
            
            
            
            JOptionPane.showMessageDialog(null, "Updated");
            
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connect();
        StudentNo();
     
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        StudentNumber = Integer.parseInt(jTextField1.getText());
        StudentName = jTextField2.getText();
        Address = jTextField3.getText();
        ContactNumber = Integer.parseInt(jTextField4.getText());
        Year = (String) jComboBox1.getSelectedItem();
        Subject = (String) jComboBox2.getSelectedItem();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        //DateOfRegistration = dateFormat.format(jDateChooser1.getDate());
        DateOfRegistration = jDateChooser1.getDate();
        PaymentDate = jDateChooser2.getDate();

        Connection con;
        PreparedStatement insert;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studen_information", "root", "");

            insert = con.prepareStatement("INSERT INTO student_info set `StudentNumber`=?,`StudentName`=?, `Address`=?, `ContactNumber`=?, `Year`=?, `Subject`=?, `DateOfRegistation`=?, PaymentDate=?");

            insert.setString(2, StudentName);
            insert.setString(3, Address);
            insert.setInt(4, ContactNumber);
            insert.setString(5, Year);
            insert.setString(6, Subject);
            insert.setDate(7, new java.sql.Date(DateOfRegistration.getTime()));
            insert.setDate(8, new java.sql.Date(PaymentDate.getTime()));
            insert.setInt(1, StudentNumber);

            insert.executeUpdate();
             //StudentNo();
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);

        }
        catch (SQLException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connect();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
     DefaultTableModel df=(DefaultTableModel) jTable2.getModel();
        int select=jTable2.getSelectedRow();
        
            jTextField1.setText(df.getValueAt(select, 0).toString());
            jTextField2.setText(df.getValueAt(select, 1).toString());
            jTextField3.setText(df.getValueAt(select, 2).toString());
            jTextField4.setText(df.getValueAt(select, 3).toString());
            jComboBox1.setSelectedItem(df.getValueAt(select, 4).toString());
            jComboBox2.setSelectedItem(df.getValueAt(select, 5).toString());
            
            try {
                String dateOFRegis = df.getValueAt(select, 6).toString();
                System.out.println(dateOFRegis);
                java.util.Date t1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateOFRegis);
                jDateChooser1.setDate(t1);
                
//                String dateOFPay = df.getValueAt(select, 6).toString();
//                java.util.Date t2 = new SimpleDateFormat("dd-MM-yyyy").parse(dateOFPay);
//                jDateChooser2.setDate(t2);
            } catch (ParseException ex) {
                Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
            }  
            
            
    }//GEN-LAST:event_jTable2MouseClicked
    
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
            
            
        }catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Info().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

  
}
