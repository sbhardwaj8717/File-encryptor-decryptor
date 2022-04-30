/**
 * This is the first frame of this project
 * 
 * Run this file first
 */

import java.awt.*;
import java.awt.event.ActionEvent;					
import java.awt.event.ActionListener;	

import javax.swing.*;


public class HomeFrame extends JFrame implements ActionListener{
    
    JButton b = new JButton();
    HomeFrame(){
        JFrame f = new JFrame();
        f.setTitle("File Encrypter");
        f.setSize(800,600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(false);
        
        JLabel l1 = new JLabel();
        l1.setText("This Is A File Encryption/Decryption Software.");

        l1.setBounds(100,50,700,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD,25));	
        f.add(l1);
        JLabel l2 = new JLabel();
        l2.setText("You Can Do Encryption Of Any File Using This Software");
        l2.setFont(new Font("Comic Sans MS", Font.BOLD,18));
        l2.setBounds(130,100,700,40);
        l2.setForeground(Color.YELLOW);
        f.add(l2);
        
        JLabel l3 = new JLabel();
        l3.setText("<---- STEPS TO USE ---->");
        l3.setFont(new Font("Comic Sans MS", Font.BOLD,17));
        l3.setBounds(270,150,700,40);
        l3.setForeground(Color.YELLOW);
        f.add(l3);
        
        JLabel l4 = new JLabel();
        l4.setText("1. Click on \"Continue\" button");
        l4.setFont(new Font("Comic Sans MS", Font.BOLD,16));
        l4.setBounds(240,190,700,40);
        l4.setForeground(Color.green);
        f.add(l4);

        
        JLabel l5 = new JLabel();
        l5.setText("2. Enter a number to genrate the HASH CODE");
        l5.setFont(new Font("Comic Sans MS", Font.BOLD,16));
        l5.setBounds(240,230,700,40);
        l5.setForeground(Color.green);
        f.add(l5);

        
        JLabel l6 = new JLabel();
        l6.setText("3. Click on \"Select File\" button");
        l6.setFont(new Font("Comic Sans MS", Font.BOLD,16));
        l6.setBounds(240,270,700,40);
        l6.setForeground(Color.green);
        f.add(l6);

        
        JLabel l7 = new JLabel();
        l7.setText("4. Select the file to Encrypt/Dcrypt");
        l7.setFont(new Font("Comic Sans MS", Font.BOLD,16));
        l7.setBounds(240,310,700,40);
        l7.setForeground(Color.green);
        f.add(l7);

        JLabel l8 = new JLabel();
        l8.setText("5. Click on \"Process File\"");
        l8.setFont(new Font("Comic Sans MS", Font.BOLD,16));
        l8.setBounds(240,350,700,40);
        l8.setForeground(Color.green);
        f.add(l8);
        JLabel l9 = new JLabel();
        l9.setText("6. DONE...");
        l9.setFont(new Font("Comic Sans MS", Font.BOLD,16));
        l9.setBounds(240,390,700,40);
        l9.setForeground(Color.green);
        f.add(l9);

        b.setText("Continue");
        b.setBounds(300,450,120,40);
        b.addActionListener(this);
        f.add(b);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void actionPerformed( ActionEvent ae) {
        if (ae.getSource() == b) {
            this.setVisible(false);
            new FileEncrDcry();
        }
	}

    public static void main(String[] args) {
        new HomeFrame();
    }
}
