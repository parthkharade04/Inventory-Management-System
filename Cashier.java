package inventory_db1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Cashier extends JFrame implements ActionListener {

    JButton submit, cancel;
    JTextField tfcashierid, tfbrandname, tfmodel,tfprice,tforderid,tfserial,invoiceno;
    

    //Random ran=new Random();
    //long last6=Math.abs((ran.nextLong()%900000L)+ 1000000L);

    
    Cashier() {
        setSize(900, 700);
        setLocation(250, 40);
        setLayout(null);

        // Cash order
        JLabel heading = new JLabel("Cash Order");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        // cashier id 
        JLabel cashierid = new JLabel("Cashier Id");
        cashierid.setBounds(250, 150, 100, 30);
        cashierid.setFont(new Font("serif", Font.BOLD, 20));
        add(cashierid);

        tfcashierid = new JTextField();
        tfcashierid.setBounds(400, 150, 150, 30);
        add(tfcashierid);

        
        
        // Brand Name
        JLabel brandname = new JLabel("Brand name");
        brandname.setBounds(250, 200, 100, 30);
        brandname.setFont(new Font("serif", Font.BOLD, 20));
        add(brandname);

        tfbrandname = new JTextField();
        tfbrandname.setBounds(400, 200, 150, 30);
        add(tfbrandname);

        
        
        // Model
        JLabel model = new JLabel("Model ");
        model.setBounds(250, 250, 200, 30);
        model.setFont(new Font("serif", Font.BOLD, 20));
        add(model);

        tfmodel = new JTextField();
        tfmodel.setBounds(400, 250, 150, 30);
        add(tfmodel);

        
//      Serial number
        JLabel serial= new JLabel("Serial Number ");
        serial.setBounds(250, 300, 200, 30);
        serial.setFont(new Font("serif", Font.BOLD, 20));
        add(serial);
        
        tfserial=new JTextField();
        tfserial.setBounds(400,300,200,30 );
        tfserial.setFont(new Font("serif", Font.BOLD ,20));
        add(tfserial);
        
        
//       Price
        JLabel price= new JLabel("Price");
        price.setBounds(250, 350, 200, 30);
        price.setFont(new Font("serif", Font.BOLD, 20));
        add(price);

        tfprice = new JTextField();
        tfprice.setBounds(400, 350, 150, 30);
        add(tfprice);
        
        
 //      Orderid
        JLabel orderid= new JLabel("Order Id");
        orderid.setBounds(250, 400, 200, 30);
        orderid.setFont(new Font("serif", Font.BOLD, 20));
        add(orderid);

        tforderid = new JTextField();
        tforderid.setBounds(400, 400, 150, 30);
        add(tforderid);      
        
        
//      Invoice Number
        JLabel invoice =new JLabel("Invoice Number");
        invoice.setBounds(250, 450, 200, 30);
        invoice.setFont(new Font("serif", Font.BOLD, 20));
        add(invoice);

        invoiceno=new JTextField();
        invoiceno.setBounds(400,450,200,30 );
        //invoiceno.setFont(new Font("serif", Font.BOLD ,20));
        add(invoiceno);
        
        
        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(345, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(345, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String cashierid= tfcashierid.getText();
            String brandname= tfbrandname.getText();
            String model = tfmodel.getText();
            String serial = tfserial.getText();
            String price = tfprice.getText();
            String orderid = tforderid.getText();
            String invoice = invoiceno.getText();
           
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql:///inventorydb", "root","Parth4ndk#flamingfisher");
                Statement s = c.createStatement();

                String query = "insert into cashorder values('" + cashierid+ "','" +brandname+ "','" + model+ "','" + serial+ "','" +price+ "','" +orderid+ "','" +invoice+ "') ";

                s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Registration Successfull ");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Cashier();
    }
}