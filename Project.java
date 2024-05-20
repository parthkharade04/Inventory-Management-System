package inventory_db1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {

        setSize(900, 500);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/C_image_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        add(image);

        JMenuBar mb = new JMenuBar();

//  CUSTOMER 
        JMenu Customer = new JMenu("Customer");
        Customer.setForeground(Color.red);
        Customer.addActionListener(this);
        mb.add(Customer);
        
        JMenuItem Customer1=new JMenuItem("Customer");
        Customer1.setBackground(Color.WHITE);
        Customer1.addActionListener(this);
        Customer.add(Customer1);

//    EMPLOYEE
        JMenu Employee = new JMenu("Employee");
        Employee.setForeground(Color.BLACK);
        Employee.addActionListener(this);
        mb.add(Employee);
        
        JMenuItem Employee1=new JMenuItem("Employee");
        Employee1.setBackground(Color.WHITE);
        Employee1.addActionListener(this);
        Employee.add(Employee1);
       
//   SUPPLIER
        JMenu Supplier = new JMenu("Supplier");
        Supplier.setForeground(Color.BLUE);
        Supplier.addActionListener(this);
        mb.add(Supplier);
        
        JMenuItem Supplier1=new JMenuItem("Supplier");
        Supplier1.setBackground(Color.WHITE);
        Supplier1.addActionListener(this);
        Supplier.add(Supplier1);        

//   PRODUCTS
        JMenu Products = new JMenu("Products");
        Products.setForeground(Color.red);
        Products.addActionListener(this);
        mb.add(Products);
        
        JMenuItem Product1=new JMenuItem("Products");
        Product1.setBackground(Color.WHITE);
        Product1.addActionListener(this);
        Products.add(Product1);         

        
//   ORDERS
        JMenu Orders = new JMenu("Orders");
        Orders.setForeground(Color.BLACK);
        Orders.addActionListener(this);
        mb.add(Orders);

        JMenuItem Orders1=new JMenuItem("Orders");
        Orders1.setBackground(Color.WHITE);
        Orders1.addActionListener(this);
        Orders.add(Orders1);         

// CASHIER   
        JMenu Cashier = new JMenu("Cashier");
        Cashier.setForeground(Color.BLUE);
        Cashier.addActionListener(this);
        mb.add(Cashier);

        JMenuItem Cashier1=new JMenuItem("Cashier");
        Cashier1.setBackground(Color.WHITE);
        Cashier1.addActionListener(this);
        Cashier.add(Cashier1);               
        
        
        
 //   Exit
    JMenu exit=new JMenu("Exit");
    exit.setForeground(Color.BLUE);
    exit.addActionListener( this);
    mb.add(exit );
    
    JMenuItem ex=new JMenuItem("Exit ");
    ex.setBackground(Color.WHITE);
    ex.addActionListener( this);
    exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (!msg.equals("Exit")) 
        {
            if (msg.equals("Cashier")) {
                new Cashier();
            } else if (msg.equals("Customer")) {
                new Customer();
            } else if (msg.equals("Employee")) {
                new Employee();
            } else if (msg.equals("Orders")) {
                new Orders();
            } else if (msg.equals("Products")) {
                new Products();
            } else if (msg.equals("Supplier")) {
                new Supplier();
            }
        }

    }

    public static void main(String[] args) {
        new Project();
    }
}
