import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileEncrDcry extends JFrame{

    
    FileEncrDcry(){
        
        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel();
        l1.setText("<-- CAUTION -->");

        l1.setBounds(75,30,700,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Comic Sans MS", Font.BOLD,25));	
        f.add(l1);
        
        JLabel l2 = new JLabel();
        l2.setText("Don't Forget Your Hash");
        l2.setBounds(70,70,700,40);
        l2.setForeground(Color.red);
        l2.setBackground(Color.yellow);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD,20));	
        f.add(l2);
        
        JLabel l3 = new JLabel();
        l3.setText("Else You May Loose Your Data");
        l3.setBounds(45,110,700,40);
        l3.setForeground(Color.red);
        l3.setBackground(Color.yellow);
        l3.setFont(new Font("Comic Sans MS", Font.BOLD,20));	
        f.add(l3);

        JLabel l4 = new JLabel();
        l4.setText("ENTER HASH :- ");
        l4.setBounds(50,180,150,25);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Comic Sans MS", Font.BOLD,17));	
        f.add(l4);

        JLabel l5 = new JLabel();
        l5.setBounds(80,270,250,25);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Comic Sans MS", Font.BOLD,14));	
        f.add(l5);
        
        
        //creating button for chooser
        JButton button=new JButton();
        button.setText("CHOOSE FILE");
        button.setBounds(110,230,150,40);
        button.setFont(new Font("Roboto",Font.BOLD,15));
        
        //creating hash text field
        
        JTextField textField=new JTextField(10);
        textField.setFont(new Font("Roboto",Font.BOLD,17));
        textField.setBounds(210,180,70,40);
        
        button.addActionListener(e->{
            
            String text=textField.getText();
            if(text.equals("")){
                l5.setText("FIRST ENTER A HASH VALUE");
            }else{
                l5.setText("");
                try {
                    int temp=Integer.parseInt(text);
                    operate(temp);
                } catch (Exception ee) {
                    l5.setText("ENTER A NUMERICAL VALUE");
                }
            }
        });

        f.setLayout(null);
        f.setResizable(false);
        f.add(button);
        f.add(textField);
        f.setVisible(true);

    }

    // Core logic 
    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);

        // selection of file
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);

            if (data.length <=100) {
                for (int j = 0; j < data.length; j++) {
                    // printing data to check all bits
                    // System.out.println(data[j]);

                    // Manupulating the bits of the file
                    data[j]=(byte)(data[j]^key);
                }
            } else {
                for (int j = 0; j < 100; j++) {
                    
                    // printing data to check all bits
                    // System.out.println(data[j]);       
                    
                    // Manupulating the bits of the file
                    data[j]=(byte)(data[j]^key);
                    j++;
                }
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "FILE IS READY");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    

}