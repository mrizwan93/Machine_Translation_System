/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.regex.*;
import java.sql.*;
/*
	<applet code="Test1.class" width=500 height=500>
	</applet>
*/

public class Test1 extends Applet implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextArea a,b;
	String os;//orignal String
	int i,si[];//si aaray for int code of database
	public void init()
	{
		 a=new TextArea("",15,50);
		add(a);
		Button t=new Button("Translate");
		add(t);
		 b=new TextArea("",15,50);
		add(b);
		t.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		os=a.getText();
		Pattern pat=Pattern.compile("[ .]");
		String ms[]=pat.split(os),v;			//Get whole String from Text area in tokens form
		
		Pattern pat1=Pattern.compile("[ ]");
		String ms1[]=pat1.split(os);			//for string aaray 
		
		int hcode[]={100,102,220,110,111},ecode[]=new int[20],j,p=0;//p for check entry & hcode=Hindi lang.code  ecode=English lang. code
		ResultSet rs;
		b.setText("");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","student");
			Statement stmt=con.createStatement();
			for(i=0;i<=ms.length;i++)
			{		
				v="'"+ms[i]+"'";
				p=0;
				if(p==0)
				{
					rs=stmt.executeQuery("select hnoun from noun where enoun="+v);
					while(rs.next())
					{
						ms1[i]=(rs.getString(1));
						p++;
						ecode[i]=100;
					}
				}	
				
				if(p==0)
				{
					rs=stmt.executeQuery("select hhv from hv where ehv="+v);
					while(rs.next())
					{
						ms1[i]=(rs.getString(1));
						p++;
						ecode[i]=111;
					}
				}
				
				if(p==0)
				{
					rs=stmt.executeQuery("select hneg from neg where eneg="+v);
					while(rs.next())
					{
						ms1[i]=(rs.getString(1));
						p++;
						ecode[i]=220;
					}
				}
				
				if(p==0)
				{
					rs=stmt.executeQuery("select hverb from verb where everb="+v);
					while(rs.next())
					{
						ms1[i]=(rs.getString(1));
						p++;
						ecode[i]=110;
					}
				}
				
				if(p==0)
				{
					rs=stmt.executeQuery("select hpre from pre where epre="+v);
					while(rs.next())
					{
						ms1[i]=(rs.getString(1));
						p++;
						ecode[i]=140;
					}
				}
				if(p==0)
				{
					rs=stmt.executeQuery("select hpro from pro where epro="+v);
					while(rs.next())
					{
						ms1[i]=(rs.getString(1));
						p++;
						ecode[i]=102;
					}
				}
				
				if(p==0)
				{
					rs=stmt.executeQuery("select hart from art where eart="+v);
					while(rs.next())
					{
						ms1[i]=(rs.getString(1));
						p++;
						ecode[i]=123;
					}
				}
			}	

			con.close();

		
		}catch(Exception e){ System.out.println(e);}

		for(i=0;i<5;i++)
		{
			for(j=0;j<ms.length;j++)
			{
				if(hcode[i]==ecode[j])
				{		
					b.append(ms1[j]+" "); //print to hindi code wise
				}
			}
		}
		
	}


}
