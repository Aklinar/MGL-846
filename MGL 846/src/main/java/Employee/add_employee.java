package main.java.Employee;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;



public class add_employee implements ActionListener {

	JFrame frame;
    JLabel box,title,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JButton b1,b2;

    //need to make it public
    public add_employee(){
        frame = new JFrame("Add Employee");
        frame.setBackground(Color.white);
        frame.setLayout(null);

        box = new JLabel();
        box.setBounds(0,0,900,700);
        box.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./main/java/icon/add.jpg"));
        box.setIcon(img);

        title = new JLabel("New Employee Details");
        title.setBounds(320,30,500,50);
        title.setFont(new Font("serif",Font.ITALIC,25));
        title.setForeground(Color.black);
        box.add(title);
        frame.add(box);

 
        label1 = new JLabel("Name");
        label1.setBounds(50,150,100,30);
        label1.setFont(new Font("serif",Font.BOLD,20));
        box.add(label1);

        t1=new JTextField();
        t1.setFont(new Font("serif",Font.BOLD,15));
        t1.setBounds(200,150,150,30);
        box.add(t1);

        label2 = new JLabel("Father's Name");
        label2.setBounds(400,150,200,30);
        label2.setFont(new Font("serif",Font.BOLD,20));
        box.add(label2);

        t2=new JTextField();
        t2.setFont(new Font("serif",Font.BOLD,15));
        t2.setBounds(600,150,150,30);
        box.add(t2);

        label3 = new JLabel("Age");
        label3.setBounds(50,200,100,30);
        label3.setFont(new Font("serif",Font.BOLD,20));
        box.add(label3);

        t3=new JTextField();
        t3.setFont(new Font("serif",Font.BOLD,15));
        t3.setBounds(200,200,150,30);
        box.add(t3);

        label4 = new JLabel("Date Of Birth");  
        label4.setBounds(400,200,200,30);
        label4.setFont(new Font("serif",Font.BOLD,20));
        box.add(label4);

        t4=new JTextField();
        t4.setFont(new Font("serif",Font.BOLD,15));
        t4.setBounds(600,200,150,30);
        box.add(t4);

        label5 = new JLabel("Address");
        label5.setBounds(50,250,100,30);
        label5.setFont(new Font("serif",Font.BOLD,20));
        box.add(label5);

        t5=new JTextField();
        t5.setFont(new Font("serif",Font.BOLD,15));
        t5.setBounds(200,250,150,30);
        box.add(t5);

        label6 = new JLabel("Phone");
        label6.setBounds(400,250,100,30);
        label6.setFont(new Font("serif",Font.BOLD,20));
        box.add(label6);

        t6=new JTextField();
        t6.setFont(new Font("serif",Font.BOLD,15));
        t6.setBounds(600,250,150,30);
        box.add(t6);

        label7 = new JLabel("Email Id");
        label7.setBounds(50,300,100,30);
        label7.setFont(new Font("serif",Font.BOLD,20));
        box.add(label7);

        t7=new JTextField();
        t7.setFont(new Font("serif",Font.BOLD,15));
        t7.setBounds(200,300,150,30);
        box.add(t7);

        label8 = new JLabel("Education");
        label8.setBounds(400,300,100,30);
        label8.setFont(new Font("serif",Font.BOLD,20));    
        box.add(label8);

        t8=new JTextField();
        t8.setFont(new Font("serif",Font.BOLD,15));
        t8.setBounds(600,300,150,30);
        box.add(t8);

        label9 = new JLabel("Job Post");
        label9.setBounds(50,350,100,30);
        label9.setFont(new Font("serif",Font.BOLD,20));
        box.add(label9);

        t9=new JTextField();
        t9.setFont(new Font("serif",Font.BOLD,15));
        t9.setBounds(200,350,150,30);
        box.add(t9);


        label10 = new JLabel("Aadhar No");
        label10.setBounds(400,350,100,30);
        label10.setFont(new Font("serif",Font.BOLD,20));
        box.add(label10);

        t10=new JTextField();
        t10.setFont(new Font("serif",Font.BOLD,15));
        t10.setBounds(600,350,150,30);
        box.add(t10);

        label11 = new JLabel("Employee Id");
        label11.setBounds(50,400,150,30);
        label11.setFont(new Font("serif",Font.BOLD,20));
        box.add(label11);

        t11=new JTextField();   
        t11.setFont(new Font("serif",Font.BOLD,15));
        t11.setBounds(200,400,150,30);
        box.add(t11);

        

        label12 = new JLabel();
        label12.setBounds(200,450,250,200);
        box.add(label12);

        label13 = new JLabel("");
        label13.setBounds(600,450,250,200);
        box.add(label13);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,550,150,40);
        box.add(b1);

        b2=new JButton("Cancel");   
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(450,550,150,40);
        box.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        //testing purpose
        /*
        frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(200,20);*/
    }


	
    
    @Override
	public void actionPerformed(ActionEvent ae) {

		String a  = t1.getText();
        String bb = t2.getText();
        String c  = t3.getText();
        String d  = t4.getText();
        String e  = t5.getText();
        String ff = t6.getText();
        String g  = t7.getText();
        String h  = t8.getText();
        String i  = t9.getText();
        String j  = t10.getText();
        String k  = t11.getText();
        if(ae.getSource() == b1){
            try{
                conn cc = new conn();
                String q = "insert into employee values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"')";
                cc.st.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                frame.setVisible(false); // close current frame.
                new details_page().display(); // open details page
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b2){
            frame.setVisible(false);
            new details_page().display();
        }else if(ae.getSource() == b2){
            frame.setVisible(false);
            new details_page().display();
        }
	}
    
    public void actionPerformed(ActionEvent ae, boolean debugMode) {

		String a  = t1.getText();
        String bb = t2.getText();
        String c  = t3.getText();
        String d  = t4.getText();
        String e  = t5.getText();
        String ff = t6.getText();
        String g  = t7.getText();
        String h  = t8.getText();
        String i  = t9.getText();
        String j  = t10.getText();
        String k  = t11.getText();
        if(ae.getSource() == b1){
            try{
                conn cc = new conn();
                String q = "insert into employee values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"')";
                cc.st.executeUpdate(q);
                //debug mode for unit testing
                //JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                frame.setVisible(false); // close current frame.
                new details_page(); // open details page
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b2){
            frame.setVisible(false);
            new details_page();
        }else if(ae.getSource() == b2){
            frame.setVisible(false);
            new details_page();
        }
	}
	
    
    public void display()
    {
        frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(200,20);
    }
	

	public static void main(String[] args) {
		new add_employee().display();
	}
	 
	//Added for testing purpose
	public JTextField getT1() {
		return t1;
	}




	public void setT1(JTextField t1) {
		this.t1 = t1;
	}




	public JTextField getT2() {
		return t2;
	}




	public void setT2(JTextField t2) {
		this.t2 = t2;
	}




	public JTextField getT3() {
		return t3;
	}




	public void setT3(JTextField t3) {
		this.t3 = t3;
	}




	public JTextField getT4() {
		return t4;
	}




	public void setT4(JTextField t4) {
		this.t4 = t4;
	}




	public JTextField getT5() {
		return t5;
	}




	public void setT5(JTextField t5) {
		this.t5 = t5;
	}




	public JTextField getT6() {
		return t6;
	}




	public void setT6(JTextField t6) {
		this.t6 = t6;
	}




	public JTextField getT7() {
		return t7;
	}




	public void setT7(JTextField t7) {
		this.t7 = t7;
	}




	public JTextField getT8() {
		return t8;
	}




	public void setT8(JTextField t8) {
		this.t8 = t8;
	}




	public JTextField getT9() {
		return t9;
	}




	public void setT9(JTextField t9) {
		this.t9 = t9;
	}




	public JTextField getT10() {
		return t10;
	}




	public void setT10(JTextField t10) {
		this.t10 = t10;
	}




	public JTextField getT11() {
		return t11;
	}




	public void setT11(JTextField t11) {
		this.t11 = t11;
	}




	public JButton getB1() {
		return b1;
	}




	public void setB1(JButton b1) {
		this.b1 = b1;
	}




	public JButton getB2() {
		return b2;
	}




	public void setB2(JButton b2) {
		this.b2 = b2;
	}
	
	
}
