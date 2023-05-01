
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;
    JButton search , add , print ,update,cancel;
    
    TeacherDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID:");
        heading.setBounds(20,20,150,20);
        add(heading);
    
        cempid = new Choice();
        cempid.setBounds(180,20,150,20);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
            cempid.add(rs.getString("empid"));
            
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
          table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
       add= new JButton("Add");
       add.setBounds(220,70,80,20);
       add.addActionListener(this);
        add(add);
        
      update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        
       cancel = new JButton("Cancel");
       cancel.setBounds(420,70,80,20);
       cancel.addActionListener(this);
        add(cancel);
        
        
     setSize(900,700);
     setLocation(300,100);
     setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    try{
    if(ae.getSource()==search){
    String query = "select * from teacher where empid = '"+cempid.getSelectedItem()+"'";
    
    try{
    Conn c = new Conn();
    ResultSet rs = c.s.executeQuery(query);
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }
    else if(ae.getSource()==print){
        table.print();
    }
    else if(ae.getSource()== add){
       setVisible(false);
       new AddTeacher();
    }
    else if(ae.getSource()== update){
    setVisible(false);
    //new UpdateTeacher();
    }
    else  {
        setVisible(false);
        
        
    }}
    catch(Exception e){
    e.printStackTrace();
    }
    
    
    }
    
    
    public static void main(String[] args){
        
        new TeacherDetails();
    }
    
}
