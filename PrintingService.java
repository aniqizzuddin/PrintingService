public class PrintingService
{
   private int quantity;
   private String size;

   public PrintingService () // Default constructor
   {
      quantity = 0;
      size = "";
   } 


   public PrintingService (int x, String y) // Normal constructor
   {
      quantity = x;
      size = y;
   }


   public void setPrintingService (int x, String y) // Mutator
   {
      quantity = x;
      size = y;
   }

   public int getquantity () // Accessor
   {
      return quantity;
   }

   public String getsize ()
   {
      return size;
   }


   public String toString ()
   {
      return "Quantity : " + quantity + "\nSize : " + size;
   }



}