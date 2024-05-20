package inventory_db1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Products extends JFrame implements ActionListener {

    JButton submit, cancel;
    JTextField tfcustomerid, tffirstname, tflastname,tfaddress,tfcontact,tfbrandid,tfcustomer,tfemployeid;

    Products() {
        setSize(900, 700);
        setLocation(250, 40);
        setLayout(null);

        // Registration
        JLabel heading = new JLabel("Product Info");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        // Product ID
        JLabel customerid = new JLabel("Product Id");
        customerid.setBounds(250, 150, 100, 30);
        customerid.setFont(new Font("serif", Font.BOLD, 20));
        add(customerid);

        tfcustomerid = new JTextField();
        tfcustomerid.setBounds(400, 150, 150, 30);
        add(tfcustomerid);

        
        
        // Date recieved Name
        JLabel firstname = new JLabel("Date Recivied");
        firstname.setBounds(250, 200, 100, 30);
        firstname.setFont(new Font("serif", Font.BOLD, 20));
        add(firstname);

        tffirstname = new JTextField();
        tffirstname.setBounds(400, 200, 150, 30);
        add(tffirstname);

        
        
        // Avalability
        JLabel lastname = new JLabel("Avalability");
        lastname.setBounds(250, 250, 200, 30);
        lastname.setFont(new Font("serif", Font.BOLD, 20));
        add(lastname);

        tflastname = new JTextField();
        tflastname.setBounds(400, 250, 150, 30);
        add(tflastname);

        
//      Contact no
        JLabel address= new JLabel("Date sold");
        address.setBounds(250, 300, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        tfaddress = new JTextField();
        tfaddress.setBounds(400, 300, 150, 30);
        add(tfaddress);
        
        
//        contanct
        JLabel contact= new JLabel("Customer ID");
        contact.setBounds(250, 350, 200, 30);
        contact.setFont(new Font("serif", Font.BOLD, 20));
        add(contact);

        tfcontact = new JTextField();
        tfcontact.setBounds(400, 350, 150, 30);
        add(tfcontact);
        
        //        Brand ID
        JLabel brandid= new JLabel("Brand ID");
        brandid.setBounds(250, 400, 200, 30);
        brandid.setFont(new Font("serif", Font.BOLD, 20));
        add(brandid);

        tfbrandid = new JTextField();
        tfbrandid.setBounds(400, 400, 150, 30);
        add(tfbrandid);
        
        //        customer ID
        JLabel customer= new JLabel("Model");
        customer.setBounds(250, 450, 200, 30);
        customer.setFont(new Font("serif", Font.BOLD, 20));
        add(customer);

        tfcustomer = new JTextField();
        tfcustomer.setBounds(400, 450, 150, 30);
        add(tfcustomer);
       
        
            
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
            String customerid = tfcustomerid.getText();
            String firstname= tffirstname.getText();
            String lastname = tflastname.getText();
            String address = tfaddress.getText();
            String contact = tfcontact.getText();
            String brandid=tfbrandid.getText();
            String customer=tfcustomer.getText();
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql:///inventorydb", "root",
                        "Parth4ndk#flamingfisher");
                Statement s = c.createStatement();

                String query = "insert into products values('" + customerid+ "','" +firstname+ "','" + lastname+ "','" + address+ "','" +contact+ "','"+brandid+"','"+customer+"') ";

                s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Data aaded Successfull ");
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
        new Products();
    }
}
