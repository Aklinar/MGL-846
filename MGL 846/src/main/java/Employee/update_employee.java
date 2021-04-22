package main.java.Employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class update_employee  implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3; 
    String id_emp;

   public update_employee(String idaa){
        
        f=new JFrame("update Employee details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_emp=idaa;    
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("./main/java/icon/update.jpg"));
        id15.setIcon(img);

        id8 = new JLabel("Update Employee Detail:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("Name:");  
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Father's Name:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id3= new JLabel("Address:");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        id15.add(t3);

        id4= new JLabel("Mobile No:");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        id15.add(t4);

        id5= new JLabel("Email Id:");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);

        id6= new JLabel("Education:");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);

        id7= new JLabel("Job Post:");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        id15.add(t7);

        id9= new JLabel("Aadhar No:");
        id9.setBounds(400,250,100,30);  
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);

        id10= new JLabel("Employee Id:");
        id10.setBounds(50,300,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);
        f.setVisible(false);
        t9=new JTextField();
        t9.setBounds(200,300,150,30);
        id15.add(t9);

        b=new JButton("update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);

        showData(idaa);
    }

    int i=0;
    String age,dat;

    void showData(String id){
        try{
            conn con = new conn();
            String str = "select * from employee where emp_id = '"+id+"'";
            ResultSet rs = con.st.executeQuery(str); // whole row stored in rs

            if(rs.next()){
                f.setVisible(true);
                i=1;

                // put data from database to text field.
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));
                t6.setText(rs.getString(8));
                t7.setText(rs.getString(9));
                t8.setText(rs.getString(10));
                t9.setText(rs.getString(11));

                age=rs.getString(3);
                dat=rs.getString(4);
            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"Id not found");
            
            new search_employee();
        }catch(Exception ex){}
        //testing purpose
        /*
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);*/
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                String str = "update employee set name='"+t1.getText()+"',fname='"+t2.getText()+"',age='"+age+"',dob='"+dat+"',address='"+t3.getText()+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',education='"+t6.getText()+"',post='"+t7.getText()+"',aadhar='"+t8.getText()+"',emp_id='"+t9.getText()+"' where emp_id='"+id_emp+"'";
                con.st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new search_employee().display();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            details_page d=new details_page();
            d.display();
        }
    }


    public void actionPerformed(ActionEvent ae, boolean debugMode){
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                String str = "update employee set name='"+t1.getText()+"',fname='"+t2.getText()+"',age='"+age+"',dob='"+dat+"',address='"+t3.getText()+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',education='"+t6.getText()+"',post='"+t7.getText()+"',aadhar='"+t8.getText()+"',emp_id='"+t9.getText()+"' where emp_id='"+id_emp+"'";
                con.st.executeUpdate(str);
                //debug mode for unit testing
                //JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new search_employee();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            details_page d=new details_page();
        }
    }
    
    public void display()
    {
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }
    
    public static void main(String[] arg){
        new update_employee("").display();
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




	public JButton getB() {
		return b;
	}




	public void setB(JButton b) {
		this.b = b;
	}




	public JButton getB2() {
		return b2;
	}




	public void setB2(JButton b2) {
		this.b2 = b2;
	}
	
	
}