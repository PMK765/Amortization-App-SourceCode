/*
Peter Kemper
0497171
2/15/17
Assignment 16: This program uses the JTextFields and buttons to make an amortization schedule.
 */
package howmuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class HowMuch extends JFrame implements ActionListener
{
    Container content = this.getContentPane();
    
    //West Side
    JPanel left = new JPanel();
    JLabel amt = new JLabel("Amount Of Purchase");
    JLabel interest = new JLabel("Interest Rate [like 7.5]");
    JLabel years = new JLabel("Years To Pay");
    JLabel monthly = new JLabel("Monthly Payment");
    JLabel total = new JLabel("Total Purchase Cost");
    JButton calc = new JButton("Calculate");
    
    //East Side
    JPanel right = new JPanel();
    JTextField amt2 = new JTextField(15);
    JTextField interest2 = new JTextField(15);
    JTextField years2 = new JTextField(15);
    JLabel lblPayment = new JLabel("");
    JLabel lblTotCost = new JLabel("");
    
    HowMuch()
    {
        this.setVisible(true);
        this.setSize(350,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cool Amortization App");
        
        //West Side
        left.setLayout(new GridLayout(6,1,  5,5));
        left.add(amt);
        left.add(interest);
        left.add(years);
        left.add(monthly);
        left.add(total);
        left.add(calc);
        content.add(left, BorderLayout.WEST);
        calc.addActionListener(this);
        
        //East Side
        right.setLayout(new GridLayout(6,1,  5,5));
        right.add(amt2);
        right.add(interest2);
        right.add(years2);
        right.add(lblPayment);
        right.add(lblTotCost);
        content.add(right, BorderLayout.EAST); 
        
        //Button
        //left.add(calc);
        
        
    }
    
    
    //@Override
    public void actionPerformed(ActionEvent ae) 
    {
        String amnt = amt2.getText();
        String Int = interest2.getText();
        String year = years2.getText();
        //System.out.println(amnt+"  "+Int+"  "+year);
        
        Double amntd = new Double(amnt);
        Double Intd = new Double(Int);
        Double yeard = new Double(year);
        //System.out.println(amntd+"  "+Intd+"  "+yeard);
        
        double a = amntd.doubleValue();
        double i = Intd.doubleValue();
        double y = yeard.doubleValue();
        
        double monthlyInt = (i/1200);
        i = monthlyInt;
        
        double payment = ((a*i) / (1 - (Math.pow(1/(1+i), y * 12))));
        NumberFormat formed = NumberFormat.getCurrencyInstance();
        String monthly = formed.format(payment);
        payment = ((payment*12)*y);
        String total = formed.format(payment);
        
        lblPayment.setText(monthly);
        lblTotCost.setText(total);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static void main(String[] args) 
    {
        HowMuch Table = new HowMuch();
    }

    
}
