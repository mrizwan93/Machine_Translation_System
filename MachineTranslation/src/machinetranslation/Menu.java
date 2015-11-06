
package machinetranslation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends Action implements ActionListener{
    JLabel lab1;
    JLabel lab2;
    JTextArea textArea1;
    JTextArea textArea2;
    JButton buttonTrans;
    JButton buttonClr;
    JFrame frame1;
    JPanel buttonPanel1;
    JPanel buttonPanel2;
    JPanel buttonPanel3;
    JMenuBar mbar;
    
    JMenu fileMenu;
    JMenu editMenu;
    JMenu aboutMenu;
    JMenu helpMenu ;
        
    JMenuItem newMenuItem ;
    //JMenuItem saveMenuItem ;
    JMenuItem closeMenuItem;
        
    JMenuItem copyMenuItem ;
    JMenuItem pasteMenuItem ;
    JMenuItem cutMenuItem ;
    JMenuItem selectAllMenuItem;
    JMenuItem aboutMenuItem;
    JMenuItem helpMenuItem;
    
    String engText,hinText; 
    Action a;
    
    
        Menu(){
        lab1 = new JLabel ("Enter Sentence (English)   :");
        lab2 = new JLabel ("Translated Sentence (Hindi):");
        textArea1 = new JTextArea(5,20);
        textArea2 = new JTextArea(5,20);
        buttonTrans = new JButton("Translate");
        buttonClr = new JButton("Clear");
        frame1 = new JFrame("Machine Translation System");
        
        buttonPanel1=new JPanel();
        buttonPanel2=new JPanel();
        buttonPanel3=new JPanel();
        mbar = new JMenuBar();
         mbar.add( Box.createHorizontalGlue() );
         fileMenu = new JMenu("File");
         editMenu = new JMenu("Edit");
         aboutMenu = new JMenu("About");
         helpMenu = new JMenu("Help");
        
        newMenuItem = new JMenuItem("New",KeyEvent.VK_N);
        
        //saveMenuItem = new JMenuItem("Save",KeyEvent.VK_S);
        closeMenuItem = new JMenuItem("Close",KeyEvent.VK_Q);
        
        selectAllMenuItem =new JMenuItem("Select All",KeyEvent.VK_A);
        copyMenuItem = new JMenuItem("Copy",KeyEvent.VK_C);
        pasteMenuItem = new JMenuItem("Paste",KeyEvent.VK_V);
        cutMenuItem = new JMenuItem("Cut",KeyEvent.VK_X);
        
        aboutMenuItem=new JMenuItem("About us");
        helpMenuItem=new JMenuItem("How to use Application?");
        
        
        fileMenu.add(newMenuItem);
        
        //fileMenu.add(saveMenuItem);
        fileMenu.add(closeMenuItem);
        
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);        
        editMenu.add(selectAllMenuItem);
        
        helpMenu.add(helpMenuItem);
        aboutMenu.add(aboutMenuItem);
                  
        mbar.add(aboutMenu);
        mbar.add(helpMenu);
        mbar.add(editMenu);
        mbar.add(fileMenu);
        //GridLayout gridlay = new GridLayout(3, 2, 5, 10);
        //FlowLayout flowlay = new FlowLayout();
        
        frame1.setSize(500, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        //frame1.setLayout(new GridLayout(3,2,5,5));
           
                
        mbar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        frame1.setJMenuBar(mbar);
        buttonPanel1.add(lab1);
        buttonPanel1.add(textArea1);
        buttonPanel2.add(buttonTrans);
        buttonPanel2.add(buttonClr);
        buttonPanel3.add(lab2);
        buttonPanel3.add(textArea2);
        frame1.add(buttonPanel1,BorderLayout.NORTH);
        frame1.add(buttonPanel3,BorderLayout.CENTER);
        frame1.add(buttonPanel2,BorderLayout.PAGE_END);
        
        buttonTrans.setPreferredSize(new Dimension(100,30));
        buttonClr.setPreferredSize(new Dimension(100,30));
        frame1.setVisible(true);
        buttonTrans.addActionListener(this); 
        buttonClr.addActionListener(this);
        
        newMenuItem.addActionListener(this) ;
        //saveMenuItem.addActionListener(this) ;
        closeMenuItem.addActionListener(this);
        
        copyMenuItem.addActionListener(this); 
        pasteMenuItem.addActionListener(this); 
        cutMenuItem.addActionListener(this);  
        selectAllMenuItem.addActionListener(this); 
        
        aboutMenuItem.addActionListener(this);
        helpMenuItem.addActionListener(this);
        
        
        
                
    }
    
        
      public void actionPerformed(ActionEvent e) {
                
            if(e.getSource()==buttonTrans)
            {
                //call fuction which will parse sentence
               engText = textArea1.getText();                       
                                             
               
               System.out.println("returned from parse, going to database ");
               
               a= new Action();
               hinText = a.dataBase(engText);
               textArea2.setText(hinText);
               
                   
               }
            
            if(e.getSource()==buttonClr)
            {
                //clears the text area fields
               
               textArea1.setText("");
               textArea2.setText("");
                   
               }
            
            if(e.getSource()==copyMenuItem)
            {
                //textArea1.copy();
                textArea2.copy();                   
            }
            if(e.getSource()==pasteMenuItem)
            {
                textArea1.paste();
                //textArea2.paste();                   
            }
            if(e.getSource()==selectAllMenuItem)
            {
                textArea1.selectAll();
                textArea2.selectAll();                   
            }
            if(e.getSource()==closeMenuItem)
            {
                System.exit(0);                   
            }
            if(e.getSource()==newMenuItem)
            {
                frame1.setVisible(false);
                new Menu();
            }
            
             if(e.getSource()==aboutMenuItem)
            {
                //a.showAboutFrame();
            AboutHelp ab=new AboutHelp();
            ab.showAbout();
   
                               
            }
            
             if(e.getSource()==helpMenuItem)
            {
                
                AboutHelp ah=new AboutHelp();
                
                ah.showHelp();
    
            } 
             
             
            
             
             
            
            }
    }
   
    
   
