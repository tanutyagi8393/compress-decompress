/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author dushyant
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.io.File;
import javax.swing.JOptionPane;
//awt k components os specific the
/** 
 *
 * @author dushyant
 */
public class View extends JFrame implements ActionListener{
    
    JButton compressbutton;   //declaring the buttons
    JButton decompressbutton;
    
    View(){ //view ka constructor call hoga to jframe ka bhi apne aap call hoga
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressbutton=new JButton("choose file to compress");
        compressbutton.addActionListener(this);
        compressbutton.setBounds(20,100,200,30); 
        decompressbutton=new JButton("choose file to decompress");
        decompressbutton.addActionListener(this);
        decompressbutton.setBounds(250,100,200,30); 
        
        this.add(compressbutton);
        this.add(decompressbutton);
        
        this.setSize(500,300);
        this.getContentPane().setBackground(Color.darkGray);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressbutton){
            JFileChooser fileChooser=new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compress.compressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource() == decompressbutton){
            JFileChooser fileChooser=new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompress.decompressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
    }
public static void main(String[] args) {
    View view=new View();
    view.setVisible(true);
}
}