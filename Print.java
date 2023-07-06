public class Print extends PrintingService
{
   private String printPack;
   private double price;
   
   public Print()
   {
      super();
      printPack = "";
   }
   
   //normal constructor
   public Print(int x, String y, String pPack)
   {
      super(x,y);
      printPack=pPack;
   }
   
   //accesor
   String getPrintPack()
   {
      return printPack;
   }
   double getPrice()
   {
      return price;
   }
   
   //mutator
   public void setPrintPack(String printPack)
   {
      this.printPack=printPack;
   }
   
   //method
   double printChoice()
   {
      if (printPack.equals("a") || printPack.equals("A"))
      {
         price = 1.0 * super.getquantity();
      }
         
      else if (printPack.equals("b") || printPack.equals("B"))
      {
         price = 1.2 * super.getquantity();
      }
         
      else if (printPack.equals("c") || printPack.equals("C"))
      {
         price = 1.2 * super.getquantity();
      }
         
      else if (printPack.equals("d") || printPack.equals("D"))
      {
         price = 1.50 * super.getquantity();
      }
         
      return price;
   }
   
   public double membership(double prices)
   {
      return prices = (prices / 2);
   }
   
   //toString
   public String toString()
   {
      return super.toString() + "\nTotal price: RM" + printChoice(); 
   }
}