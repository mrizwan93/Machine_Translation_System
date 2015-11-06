
package machinetranslation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Action extends AboutHelp{
    
    String[] engTokens; 
    String hinTokens[];
    
    int hinCodeSeq[]={100,102,140,220,110,111};
    int[] engCodeSeq;
    int j,i,tokenFound; // s= returns 1 to parse()
    String token,returnSentence;
    
   
    
    Connection conn=null;
    Statement stmt = null;
    ResultSet rs = null;
   
   
    Action(){
        engTokens=new String[20];
        hinTokens=new String[20];
        returnSentence="";
        engCodeSeq=new int[20];
        
        
        
    }
    
   
    
    /*
    public int parse(String ){
        iSentence=sentence;
        
        s=1;
        System.out.println("sentence parsed ");
        
        
        for (int i=0;i<tempEngTokens.length;i++){            
        
        engTokens[i]=tempEngTokens[i];
        
        //System.out.println("engTokens["+i+"]="+engTokens[i]);
     }  
        return s;
    }*/
    
    
    public String dataBase(String sentence){
        
        
        
        try {
    
      conn = DriverManager.getConnection("jdbc:mysql://localhost/machineTrans?",
                                   "root","mysql");
      System.out.println("Drivers loaded... ");
    

  
    } catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
    }
        
        try {
            stmt = conn.createStatement();
            System.out.println("statement object created...");
                        
            engTokens= sentence.split("\\s+");
            for ( i=0;i<engTokens.length;i++){  
            engTokens[i]=engTokens[i].replaceAll("[^\\w]", "");
            }
            
            
            for(i=0;i<engTokens.length;i++){
                
                //System.out.println("engToken["+i+"]="+engTokens[i]);
                token="'"+engTokens[i]+"'";
                //System.out.println("Token["+i+"]="+token);
                tokenFound=0;
		if(tokenFound==0)
		{
                    rs=stmt.executeQuery("SELECT meaning FROM noun WHERE word="+token);
                    while(rs.next())
                    {
			//System.out.println("NOUN TABLE");
                        hinTokens[i]=(rs.getString("meaning"));
			tokenFound=1;
			engCodeSeq[i]=100;
                       /// System.out.println("token= "+hinTokens[i]);
                    }
		}	
				
                if(tokenFound==0)
		{
                    rs=stmt.executeQuery("SELECT meaning FROM helpingVerb WHERE word="+token);
                    while(rs.next())
                    {
                        hinTokens[i]=(rs.getString("meaning"));
			tokenFound=1;
			engCodeSeq[i]=111;
                        //System.out.println("token= "+hinTokens[i]);
                    }
		}
		
                if(tokenFound==0)
		{
                    rs=stmt.executeQuery("SELECT meaning FROM negation WHERE word="+token);
                    while(rs.next())
                    {
			hinTokens[i]=(rs.getString("meaning"));
			tokenFound=1;
			engCodeSeq[i]=220;
                        
                        //System.out.println("token= "+hinTokens[i]);
                    }
		}	
				
                if(tokenFound==0)
		{
                    rs=stmt.executeQuery("SELECT meaning FROM verb WHERE word="+token);
                    while(rs.next())
                    {
                        hinTokens[i]=(rs.getString("meaning"));
			tokenFound=1;
			engCodeSeq[i]=110;
                        
                        //System.out.println("token= "+hinTokens[i]);
                    }
		}
		
                if(tokenFound==0)
		{
                    rs=stmt.executeQuery("SELECT meaning FROM preposition WHERE word="+token);
                    while(rs.next())
                    {
                        hinTokens[i]=(rs.getString("meaning"));
			tokenFound=1;
			engCodeSeq[i]=140;
                        
                        //System.out.println("token= "+hinTokens[i]);
                    }
		}
		
                if(tokenFound==0)
		{
                    rs=stmt.executeQuery("SELECT meaning FROM pronoun WHERE word="+token);
                    while(rs.next())
                    {
			hinTokens[i]=(rs.getString("meaning"));
			tokenFound=1;
			engCodeSeq[i]=102;
                        
                       //System.out.println("token= "+hinTokens[i]);
                    }
		}	
				
                if(tokenFound==0)
		{
                    rs=stmt.executeQuery("SELECT meaning FROM artical WHERE word="+token);
                    while(rs.next())
                    {
                        hinTokens[i]=(rs.getString("meaning"));
			tokenFound=1;
			engCodeSeq[i]=123;
                        
                         //System.out.println("token= "+hinTokens[i]);
                    }
		}
            

      //for loop ends here
            }
               
            for(i=0;i<6;i++)
		{
			for(j=0;j<engTokens.length;j++)
			{
                            
				if(hinCodeSeq[i]==engCodeSeq[j])
				{		
                                    System.out.println("hintokens = "+hinTokens[j]);
                                    returnSentence=returnSentence+" "+hinTokens[j];
                                    //textArea2.append(hinTokens[j]+" "); //print to hindi code wise
				}
			}
		}
    
        }
    catch (SQLException ex){
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}
        
finally {
    

    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException sqlEx) { } // ignore

        rs = null;
    }

    if (stmt != null) {
        try {
            stmt.close();
        } catch (SQLException sqlEx) { } // ignore

        stmt = null;
    }
}
        
return returnSentence;        
}            
        
 
      
     
    
    
}

    
    