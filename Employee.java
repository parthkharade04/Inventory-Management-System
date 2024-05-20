package inventory_db1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Employee extends JFrame implements ActionListener {

    JButton submit, cancel;
    JTextField tfemployeeid, tffirstname, tflastname,tfaddress,tfcontact,tfposition;
    
    Employee(){
    
        setSize(900, 700);
        setLocation(250, 40);
        setLayout(null);
        
        
        // Employee Registration
        JLabel heading = new JLabel("Employee Registration ");
        heading.setBounds(270, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        
        // Customer id
        JLabel employeeid = new JLabel("Customer Id");
        employeeid.setBounds(250, 150, 120, 30);
        employeeid.setFont(new Font("serif", Font.BOLD, 20));
        add(employeeid);

        tfemployeeid = new JTextField();
        tfemployeeid.setBounds(400, 150, 150, 30);
        add(tfemployeeid);
        
        
        // First name
        JLabel firstname = new JLabel("First Name");
        firstname.setBounds(250, 200, 100, 30);
        firstname.setFont(new Font("serif", Font.BOLD, 20));
        add(firstname);

        tffirstname = new JTextField();
        tffirstname.setBounds(400, 200, 150, 30);
        add(tffirstname);

                
        // Last Name
        JLabel lastname = new JLabel("Last Name ");
        lastname.setBounds(250, 250, 200, 30);
        lastname.setFont(new Font("serif", Font.BOLD, 20));
        add(lastname);

        tflastname = new JTextField();
        tflastname.setBounds(400, 250, 150, 30);
        add(tflastname);
        
        
        //      Address
        JLabel address= new JLabel("Address ");
        address.setBounds(250, 300, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        tfaddress = new JTextField();
        tfaddress.setBounds(400, 300, 150, 30);
        add(tfaddress);
        
        
//        Contact Number
        JLabel contact= new JLabel("Contact Number");
        contact.setBounds(250, 350, 200, 30);
        contact.setFont(new Font("serif", Font.BOLD, 20));
        add(contact);

        tfcontact = new JTextField();
        tfcontact.setBounds(400, 350, 150, 30);
        add(tfcontact);
        

//      Position
        JLabel position= new JLabel("Position");
        position.setBounds(250, 400, 200, 30);
        position.setFont(new Font("serif", Font.BOLD, 20));
        add(position);

        tfposition = new JTextField();
        tfposition.setBounds(400, 400, 150, 30);
        add(tfposition);
        
            
        // Submit Button
        submit = new JButton("Add Employee");
        submit.setBounds(345, 470, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(345, 520, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        
            if (ae.getSource() == submit) {
            String employeeid = tfemployeeid.getText();
            String firstname= tffirstname.getText();
            String lastname = tflastname.getText();
            String address = tfaddress.getText();
            String contact = tfcontact.getText();
            String position=tfposition.getText();
            
           
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql:///inventorydb", "root",
                        "Parth4ndk#flamingfisher");
                Statement s = c.createStatement();

                String query = "insert into employees values('" + employeeid+ "','" +firstname+ "','" + lastname+ "','" + address+ "','" +contact+ "','"+position+"') ";

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
    
    public static void main(String[]args){
    new Employee();
    }
}