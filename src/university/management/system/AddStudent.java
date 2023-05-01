
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {
    
    JTextField tfname ,tffname,tffaddress,tffphone,tffemail,tffx,tffxii,tffaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong()%9000L)+1000L);
    
    
    
    AddStudent(){
        
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
       
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
         JLabel lblname = new JLabel("Name:");
       lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name:");
       lblfname.setBounds(400,150,150,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel lblrollno = new JLabel("Roll No:");
       lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
         labelrollno = new JLabel("1533"+first4);
       labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);
        
          JLabel lbldob = new JLabel("Date of Birth:");
       lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
         JLabel lbladdress = new JLabel("Address:");
       lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tffaddress= new JTextField();
        tffaddress.setBounds(200,250,150,30);
        add(tffaddress);
        
        
         JLabel lblphone = new JLabel("Phone No:");
       lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tffphone= new JTextField();
        tffphone.setBounds(600,250,150,30);
        add(tffphone);
        
        
         JLabel lblemail = new JLabel("Email:");
       lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tffemail= new JTextField();
        tffemail.setBounds(200,300,150,30);
        add(tffemail);
        
        
         JLabel lblx = new JLabel("Class X%:");
       lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        tffx= new JTextField();
        tffx.setBounds(600,300,150,30);
        add(tffx);
        
        
         JLabel lblxii = new JLabel("Class XII%:");
       lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        tffxii= new JTextField();
        tffxii.setBounds(200,350,150,30);
        add(tffxii);
        
         JLabel lblaadhar = new JLabel("Aadhar No:");
       lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        tffaadhar= new JTextField();
        tffaadhar.setBounds(600,350,150,30);
        add(tffaadhar);
        
          JLabel lblcourse = new JLabel("Course:");
       lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String course[]={"<SELECT>","BCA","BTECH","MCA","BBA","MBA","MTECH","BSC","MSC"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
         JLabel lblbranch = new JLabel("Branch:");
       lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        String branch[]={"<SELECT>","CSE","ECE","IT","CIVIL","ELECTRICAL","AEROSPACE","AIML"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.white);
        add(cbbranch);
        
        
         submit= new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
     
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);
        
         cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== submit){
    String name = tfname.getText();
    String fname = tffname.getText();
    String rollno = labelrollno.getText();
    String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
    String address = tffaddress.getText();
    String phone = tffphone.getText();
    String email = tffemail.getText();
    String x = tffx.getText();
    String xii = tffxii.getText();
    String aadhar = tffaadhar.getText();
    String course = (String)cbcourse.getSelectedItem();
    String branch = (String)cbbranch.getSelectedItem();
    
    try{
    String query = "insert into student values ('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
    
    Conn con = new Conn();
    con.s.executeUpdate(query);
    
    JOptionPane.showMessageDialog(null, "Student Details updated Successfully ");
    setVisible(false);
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    
    }
    else{
    setVisible(false);
    }
    
    }
    public static void main(String[] args){
        new AddStudent();
    }
}
