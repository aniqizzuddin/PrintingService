import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

import javax.swing.*;


public class PrintingServiceApp
{
   public static void main (String [] arg) throws IOException
   {  
      PrintingService[] a = new PrintingService[10];
      String name = JOptionPane.showInputDialog("****** WELCOME TO SIGMA PRINTING SERVICE ******" +"\n"+ "\nPlease enter your name");
      String noTel = JOptionPane.showInputDialog("\nPlease enter your number telephone");
      double price = 0;
      Customer cust1 = new Customer(name,noTel,"",0);
      System.out.println(cust1);
   
      
      
      String ch = JOptionPane.showInputDialog("Enter 1 to photostat \nEnter 2 to print ");
      int choose = Integer.parseInt(ch);
      String size = "";
     
      if(choose == 1) 
      {
         String s =JOptionPane.showInputDialog("Package A = Black and White (B&W) + A4 Size \nPackage B = Black and White (B&W) + A3 Size \nPackage C = Colour + A4 Size \nPackage D = Colour + A3 Size \n\nEnter your package :");
         if(s.equalsIgnoreCase("a")|| s.equalsIgnoreCase("c"))
         {
            size = "A4";
           
         }
         else if(s.equalsIgnoreCase("b")|| s.equalsIgnoreCase("d")) 
         {
            size = "A3";
         }
         String qtt = JOptionPane.showInputDialog("How many sheets of paper do you need?");
         int quant = Integer.parseInt(qtt);
         Photostat photo1 = new Photostat(quant,size,s);
         a[1] = new Photostat(quant,size,s);
         price = photo1.photoChoice();
         cust1.setprice(price);
        
         System.out.println(photo1);
        
      }
      else if(choose == 2) 
      {
         String s =JOptionPane.showInputDialog("Package A = Black and White (B&W) + A4 Size \nPackage B = Black and White (B&W) + A3 Size \nPackage C = Colour + A4 Size \nPackage D = Colour + A3 Size \n\nEnter your package :");
         if(s.equalsIgnoreCase("a")|| s.equalsIgnoreCase("c"))
         {
            size = "A4";
         }
         else if(s.equalsIgnoreCase("b")|| s.equalsIgnoreCase("d")) 
         {
            size = "A3";
         }
         String qtt = JOptionPane.showInputDialog("How many sheets of paper do you need?");
         int quant = Integer.parseInt(qtt);
         Print print1 = new Print(quant,size,s);
         a[2] = new Print(quant,size,s);
         price = print1.printChoice();
         cust1.setprice(price);    	  
        
      
         System.out.println(print1);  
      }
      
      String mem = JOptionPane.showInputDialog("Do you have membership?");
      String id = null; 
      int tryy = 0;
   
      for(int i=0; i<a.length; i++){
         if(a[i] instanceof Print){
            Print b = (Print) a[i];// guna yang baru kita belajar
           
            if(mem.equalsIgnoreCase("Yes"))
            {
               DecimalFormat df = new DecimalFormat("0.00");
               do {
                  mem = JOptionPane.showInputDialog("Please enter your membership ID");
               
                  FileReader reader = new FileReader("memID.txt");
                  BufferedReader in = new BufferedReader(reader);
               
                  while((id = in.readLine()) != null) 
                  {
                     if(mem.equals(id))
                     {
                        tryy = 1;
                        System.out.println("Price after dscount RM "+ df.format(b.membership(price)));
                        System.out.println(cust1.receipt(b.membership(price)));
                     }
                  
                  }in.close();
               
                  if(tryy == 0)
                  {
                     mem = JOptionPane.showInputDialog("NOT VALID! Do you want to try again \n (YES or NO)");
                     
                  }
               }while(mem.equals("yes"));
              
            	  
            }
            if(mem.equalsIgnoreCase("No"))
            {
               mem = JOptionPane.showInputDialog("Do you want to join our membership?");
               if(mem.equalsIgnoreCase("Yes"))
               {
                  mem = JOptionPane.showInputDialog("Please enter your email");
                  mem = JOptionPane.showInputDialog("Please enter your number telephone");
               	   
                  FileReader reader = new FileReader("memID.txt");
                  BufferedReader in = new BufferedReader(reader);
               	   
                  FileWriter writer = new FileWriter("memID2.txt");
                  PrintWriter out = new PrintWriter(writer);
               	   
                  while((id = in.readLine()) != null)
                  {
                     out.println(id);
                  }
                  out.println(mem);
                  in.close();
                  out.close();
               	   
                  FileReader reader2 = new FileReader("memID2.txt");
                  BufferedReader in2 = new BufferedReader(reader2);
               	   
                  FileWriter writer2 = new FileWriter("memID.txt");
                  PrintWriter out2 = new PrintWriter(writer2);
               	   
                  while((id = in2.readLine()) != null)
                  {
                     out2.println(id);
                  }
                  in2.close();
                  out2.close();
                  System.out.println(cust1.receipt(b.membership(price)));
               }
               else if(mem.equalsIgnoreCase("No"))
               {
                  mem = JOptionPane.showInputDialog("Are you sure?");
                  if(mem.equalsIgnoreCase("Yes"))
                  {
                     System.out.println(cust1.receipt(0));
                  }
                  else if(mem.equalsIgnoreCase("No"))
                  {
                     mem = JOptionPane.showInputDialog("Please enter your email");
                     mem = JOptionPane.showInputDialog("Please enter your number telephone");
                     System.out.println(cust1.receipt(b.membership(price)));
                  }
               }
            	   
            	  
            }
         }else if(a[i] instanceof Photostat){
            Photostat c = (Photostat) a[i];// guna yang baru kita belajar
            if(mem.equalsIgnoreCase("Yes"))
            {
               DecimalFormat df = new DecimalFormat("0.00");
               do {
                  mem = JOptionPane.showInputDialog("Please enter your membership ID");
               
                  FileReader reader = new FileReader("memID.txt");
                  BufferedReader in = new BufferedReader(reader);
                  while((id = in.readLine()) != null) 
                  {
                     if(mem.equals(id))
                     {
                        tryy = 1;
                        System.out.println("Price after dscount RM "+ df.format(c.membership(price)));
                        System.out.println(cust1.receipt(c.membership(price)));
                     }
                  }in.close();
                  if(tryy == 0)
                  {
                     mem = JOptionPane.showInputDialog("NOT VALID! Do you want to try again \n (YES or NO)");
                     
                  }
               }while(mem.equals("yes"));
            }
            if(mem.equalsIgnoreCase("No"))
            {
               mem = JOptionPane.showInputDialog("Do you want to join our membership?");
               if(mem.equalsIgnoreCase("Yes"))
               {
                  mem = JOptionPane.showInputDialog("Please enter your email");
                  mem = JOptionPane.showInputDialog("Please enter your number telephone");
                  FileReader reader = new FileReader("memID.txt");
                  BufferedReader in = new BufferedReader(reader);
               	   
                  FileWriter writer = new FileWriter("memID2.txt");
                  PrintWriter out = new PrintWriter(writer);
               	   
                  while((id = in.readLine()) != null)
                  {
                     out.println(id);
                  }
                  out.println(mem);
                  in.close();
                  out.close();
               	   
                  FileReader reader2 = new FileReader("memID2.txt");
                  BufferedReader in2 = new BufferedReader(reader2);
               	   
                  FileWriter writer2 = new FileWriter("memID.txt");
                  PrintWriter out2 = new PrintWriter(writer2);
               	   
                  while((id = in2.readLine()) != null)
                  {
                     out2.println(id);
                  }
                  in2.close();
                  out2.close();
                  System.out.println(cust1.receipt(c.membership(price)));
               }
               else if(mem.equalsIgnoreCase("No"))
               {
                  mem = JOptionPane.showInputDialog("Are you sure?");
                  if(mem.equalsIgnoreCase("Yes"))
                  {
                     System.out.println(cust1.receipt(0));
                  }
                  else if(mem.equalsIgnoreCase("No"))
                  {
                     mem = JOptionPane.showInputDialog("Please enter your email");
                     mem = JOptionPane.showInputDialog("Please enter your number telephone");
                     System.out.println(cust1.receipt(c.membership(price)));
                  	   
                  }
               }
            	
            }
         
         
         }
      }
   }
}