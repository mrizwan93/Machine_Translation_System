
package machinetranslation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutHelp implements ActionListener{
    
    JFrame aboutFrame,helpFrame;
    JButton helpClose,aboutClose;
    JLabel aboutLabel,helpLabel;
    JPanel buttonPan1,buttonPan2;
    
    String s1,s2;
    
    
    
    
    AboutHelp(){
        
        s1="<html>\n"+"<body>\n"
                +"<p>To use this application:<br>"
                +"<ul>\n"
                + "<li>Enter English Sentence in First Text Area.</li>"
                +"<li>Press Translate Button.</li>"
                +"<li>Hindi Sentence will be displyed at Second Text Area.</li>"
                + "</ul>\n"
                + "</p>\n"
                + "</body>\n"
                + "</html>";
        
        s2="<html>\n"+"<body>\n"
                +"<p><center>This project on <br> <font color="+"green"+" size="+3+">Machine Translation System using Quantum Neural Network "
                + "for Simple Sentences</font><br> submitted for partial fulfilment of the requirements for the degree of\n "
                +" <br><I> <font color="+"blue"+" size="+3+">Bachelor of Engineering in Computer</font></I>\n"
                +"<br>to<br><b><font color="+"red"+" size="+3+">North Maharashtra University,Jalgaon</b>"
                +"<br><br>Submitted By:<center>"
                +"<center><b>"
                + "Mohammad Rizwan<br>"
                +"Ajay Nikam<br>"
                +"Modassar Haidar<br>"
                +"Dipak Patil<center>"
                + "</b>\n"
                +"<center>Under the Guiedance of<center>\n"
                +"<b><font color="+"purple"+" size="+3+">Mr. Chittaranjan Mangale</b>"
                + "</p>\n"
                + "</body>\n"
                + "</html>";
        aboutFrame=new JFrame("About");
        helpFrame=new JFrame("Help");
        buttonPan1 =new JPanel();
        buttonPan2 =new JPanel();
        helpClose=new JButton("Close");
        aboutClose=new JButton("Close");
        buttonPan1.add(helpClose);
        buttonPan2.add(aboutClose);
        
        aboutLabel=new JLabel(s2);
        helpLabel =new JLabel(s1);
        aboutFrame.add(aboutLabel);
        //aboutFrame.add(aboutClose,BorderLayout.PAGE_END);
        helpFrame.add(helpLabel);
        //helpFrame.add(helpClose, BorderLayout.PAGE_END);
        aboutFrame.add(buttonPan2, BorderLayout.SOUTH);
        helpFrame.add(buttonPan1, BorderLayout.SOUTH);
        helpClose.setPreferredSize(new Dimension(100,30));
        aboutClose.setPreferredSize(new Dimension(100,30));
        helpClose.addActionListener(this);
        aboutClose.addActionListener(this);
        
    }
    
    public void showHelp(){
        
        
        helpFrame.setSize(380, 200);
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setVisible(true);
    }
    
    public void showAbout(){
        aboutFrame.setSize(500, 350);
        aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutFrame.setLocationRelativeTo(null);
        aboutFrame.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ev) {
                
            if(ev.getSource()==helpClose)
            {
                helpFrame.setVisible(false);
            }
            if(ev.getSource()==aboutClose)
            {
                aboutFrame.setVisible(false);
            }
            
    }
}

