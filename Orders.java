package inventory_db1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Orders extends JFrame implements ActionListener {

    JButton submit, cancel;
    JTextField tforderid, tfdateorder, tfinvoicenumber, tfordernumber, tftotalprice, tfbrandid, tfcustomerid, tfemployeeid;

    Orders() {

        setSize(900, 700);
        setLocation(250, 40);
        setLayout(null);

        //Product
        JLabel heading = new JLabel("Orders ");
        heading.setBounds(350, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

//      Orderid
        JLabel orderid = new JLabel("Order Id");
        orderid.setBounds(250, 100, 120, 30);
        orderid.setFont(new Font("serif", Font.BOLD, 20));
        add(orderid);

        tforderid = new JTextField();
        tforderid.setBounds(400, 100, 150, 30);
        add(tforderid);

        // Date Received
        JLabel dateorder = new JLabel("Date Order");
        dateorder.setBounds(250, 150, 100, 30);
        dateorder.setFont(new Font("serif", Font.BOLD, 20));
        add(dateorder);

        tfdateorder = new JTextField();
        tfdateorder.setBounds(400, 150, 150, 30);
        add(tfdateorder);

        //     Invoice Number
        JLabel invoicenumber = new JLabel("Invoice Number");
        invoicenumber.setBounds(250, 200, 200, 30);
        invoicenumber.setFont(new Font("serif", Font.BOLD, 20));
        add(invoicenumber);

        tfinvoicenumber = new JTextField();
        tfinvoicenumber.setBounds(400, 200, 150, 30);
        add(tfinvoicenumber);

        // Order Number
        JLabel ordernumber = new JLabel("Date Sold");
        ordernumber.setBounds(250, 250, 200, 30);
        ordernumber.setFont(new Font("serif", Font.BOLD, 20));
        add(ordernumber);

        tfordernumber = new JTextField();
        tfordernumber.setBounds(400, 250, 150, 30);
        add(tfordernumber);

        //Total Price
        JLabel totalprice = new JLabel("Total Price");
        totalprice.setBounds(250, 300, 200, 30);
        totalprice.setFont(new Font("serif", Font.BOLD, 20));
        add(totalprice);

        tftotalprice = new JTextField();
        tftotalprice.setBounds(400, 300, 150, 30);
        add(tftotalprice);

        //Brand id
        JLabel brandid = new JLabel("Brand id");
        brandid.setBounds(250, 350, 200, 30);
        brandid.setFont(new Font("serif", Font.BOLD, 20));
        add(brandid);

        tfbrandid = new JTextField();
        tfbrandid.setBounds(400, 350, 150, 30);
        add(tfbrandid);

        // Customerid
        JLabel customerid = new JLabel("Customer Id");
        customerid.setBounds(250, 400, 200, 30);
        customerid.setFont(new Font("serif", Font.BOLD, 20));
        add(customerid);

        tfcustomerid = new JTextField();
        tfcustomerid.setBounds(400, 400, 150, 30);
        add(tfcustomerid);

        // Employee id
        JLabel employeeid = new JLabel("Employee Id");
        employeeid.setBounds(250, 450, 200, 30);
        employeeid.setFont(new Font("serif", Font.BOLD, 20));
        add(employeeid);

        tfemployeeid = new JTextField();
        tfemployeeid.setBounds(400, 450, 150, 30);
        add(tfemployeeid);

        // Submit Button
        submit = new JButton("Add Product");
        submit.setBounds(345, 530, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(345, 580, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String orderid = tforderid.getText();
            String dateorder = tfdateorder.getText();
            String invoicenumber = tfinvoicenumber.getText();
            String ordernumber = tfordernumber.getText();
            String totalprice = tftotalprice.getText();

            String brandid = tfbrandid.getText();
            String customerid = tfcustomerid.getText();
            String employeeid = tfemployeeid.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql:///inventorydb", "root",
                        "Parth4ndk#flamingfisher");
                Statement s = c.createStatement();
                String query = "insert into orders values('" + orderid + "','" + dateorder + "',''" + invoicenumber + "','" + ordernumber + "','" + totalprice + "','" + brandid + "','" + customerid + "','" + employeeid + "') ";

                s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Registration Successfull ");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new Orders();
    }
}
