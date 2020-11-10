import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"Customer Name","Date Time","Deposit","Withdraw","Balance"};
    String y[][] = new String[20][5];
    int i=0, j=0;int c=0;
    
    MiniStatement(){
    	super("Mini Statement");
    	String pinn = JOptionPane.showInputDialog("Enter PIN");
        setSize(1200,500);
        setLocation(180,100);
        
        try{
            conn c1  = new conn();
            
            	String s1 = "select * from bank where pin="+pinn;
            	ResultSet rs  = c1.s.executeQuery(s1);
            	while(rs.next()){
            		if (rs.getString("pin")==null)
            			y[i][j++]="null";
            		else
            			y[i][j++]=rs.getString("pin");
            		if (rs.getString("date")==null)
            			y[i][j++]="null";
            		else
            			y[i][j++]=rs.getString("date")+" "+rs.getString("time");
                
            		if (rs.getString("deposit")==null)
            			y[i][j++]="null";
            		else
            			y[i][j++]=rs.getString("deposit");
                
            		if (rs.getString("withdraw")==null)
            			y[i][j++]="null";
            		else
            			y[i][j++]=rs.getString("withdraw");
               
            		if (rs.getString("balance")==null)
            			y[i][j++]="null";
            		else
            			y[i][j++]=rs.getString("balance");
                
                
                i++;
                j=0;
                
            	}
            
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
    
}