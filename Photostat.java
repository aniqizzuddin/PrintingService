public class Photostat extends PrintingService
{

   private String photoPack;
   double price;


   public Photostat(int x, String y,String photoPack) //normal constructor
   {
      super(x,y);
      this.photoPack = photoPack;
   }

   public void setphotoPack(int x , String y, String photoPack) //mutator
   {
      this.photoPack = photoPack;
   }

   String  getphotoPack() 
   {
      return photoPack;
   }

   double photoChoice()
   {
      double price =0.0 ;
      if (photoPack.equals("a") || photoPack.equals("A"))
      {
         price = 0.50 * super.getquantity();
      }
         
      else if (photoPack.equals("b") || photoPack.equals("B"))
      {
         price = 0.80 * super.getquantity();
      }
         
      else if (photoPack.equals("c") || photoPack.equals("C"))
      {
         price = 0.80 * super.getquantity();
      }
         
      else if (photoPack.equals("d") || photoPack.equals("D"))
      {
         price = 1.20 * super.getquantity();
      }
      
      return price;
   }
   public double membership(double prices)
   {
      return prices = (prices / 2);
   }
   
   public String toString()
   {
      return super.toString() + "\nTotal price : RM" + photoChoice();
   }
}