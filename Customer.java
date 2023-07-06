import java.text.DecimalFormat;

public class Customer
{
   private String custName;
   private String custNoTel;
   private double price;

   public Customer () // Default constructor
   {
      custName = "";
      custNoTel = "";
      price = 0;
   }


   public Customer(String a, String b, String c, double p) // Normal constructor
   {
      custName = a;
      custNoTel = b;
      price = p;
   } 


   public void setCustomer(String a, String b, String c, double p) // Setter
   {
      custName = a;
      custNoTel = b;
      price = p;
   } 


   public String getcustName ()                // Accessor
   {
      return custName;
   }

   public String getcustNoTel ()
   {
      return custNoTel;
   }
   
   public double setprice(double p)
   {
      return price = p;
   } 
   
   
   public String receipt(double disc)
   {
      DecimalFormat df = new DecimalFormat("0.00");
   
      
      return 
         "\n------------------------------------\n"+
         "       CUSTOMER RECEIPT       \n"+
         "------------------------------------"+
         "\nName                 : "+custName+
         "\nNo. phone            : "+custNoTel+
         "\nSubotal              : RM"+df.format(price)+
         "\nDiscount             : RM"+df.format(disc)+ 
         "\nTotal                : RM"+df.format(price-disc)+
         "\n\n------------------------------------\n"+
         " ******Thank you!!!******  \n"+
         "------------------------------------";	   
   }


   public String toString()                                                                                 // toString
   {
      return "Name : " + custName + "\nNo. Telephone : " + custNoTel;
   }

}