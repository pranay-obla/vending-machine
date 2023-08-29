import java.util.Scanner;

public class VendingMachine
{
    //instance variables
    //local variables
    public static String product[]={"oreo","kitkat","Lays","Fivestar","diarymilk","cheetos"};
    public static int productid =0;
    public static int choice=0;
    //class variables
    public static int  price[]={20,25,20,15,40,30};
    public static int quantity[]={3,3,3,3,3,3};
    public static int balance=0;
    public static int paid=0;
    static int sum=0;
    
    //object creation
    static Administrator adm=new Administrator();
    //static int productid=0;
    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args)
    {
        System.out.println("\t"+"\t"+"\t"+"    ------Welcome to DP's Vending machine--------"+"\n\n");
        vend();
    }
    
    public static void vend()
    {
        //object creation
        VendingMachine ob=new VendingMachine();
        
        int a;
        int price;
        int balance;
        int vmq=0;
        
        while(true)
        {
            a =ob.chooseProduct();
           
            if((a>7 ||a<0)&& a!=123)
            {
                System.out.println("enter a valid productid");
                continue;                    
            }
            else if(a==0)
            {
                continue;
            }
            else if(a==7)
            {
               // productid =7;
               exit();
               break;                 
            }
            else if(a==123)
            {
                ob.admin();
                return;
            }
            
            if(quantity[a -1] <=0)
            {
                ob.soldOut();
                continue;
            }
            
            price=ob.pay(a);
            balance=ob.paid();
            
            if(balance<0)
            {
                ob.notSufficientAmount(paid);
                continue;
            }
            
            ob.quantityDecrease(a);
            ob.display(a);
            ob.cashRegister(a);
        }
    }
    
    public int chooseProduct()
    {
        //input
        //exception handling
        while(true)
        {
        try
        {
            String x="";
            System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"choose your product");
            System.out.println("\t"+"\t"+"\t"+"    ---------------------------------------------");
            System.out.println("\t"+"\t"+"\t"+"\t"+product[0]+"\t"+"\t"+product[1]+"\t"+"\t"+product[2]);
            System.out.println("\t"+"\t"+"\t"+"\t"+" 01"+"\t"+"\t"+" 02"+"\t"+"\t"+" 03");
            System.out.println("\t"+"\t"+"\t"+"    ---------------------------------------------");
            System.out.println("\t"+"\t"+"\t"+"\t"+product[3]+"\t"+product[4]+"\t"+product[5]);
            System.out.println("\t"+"\t"+"\t"+"\t"+" 04"+"\t"+"\t"+" 05"+"\t"+"\t"+" 06");
            System.out.println("\t"+"\t"+"\t"+"    ---------------------------------------------");
            System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"exit");
            System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+" 07");
            System.out.println("\t"+"\t"+"\t"+"    --------For ADMIN functions press '123'------");
            x=sc.nextLine();
            if(Integer.parseInt(x)>-Math.pow(2,31) && Integer.parseInt(x)<(Math.pow(2,31)-1))
            {
                productid=Integer.parseInt(x);
            }
            else
            {
                System.out.println("enter a valid productid");
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("enter valid product id");    
            continue;
        }        
        return productid;
    }
    }
    
    public int pay(int id)
    {
        id=productid;
    
        if(id==1)
        {
            System.out.println("price "+price[0]);
        }
        if(id==2)
        {
            System.out.println("price "+price[1]);
        }
        if(id==3)
        {
            System.out.println("price "+price[2]);
        }
        if(id==4)
        {
            System.out.println("price "+price[3]);
        }
        if(id==5)
        {
           System.out.println("price "+price[4]);
        }
        if(id==6)
        {
            System.out.println("price "+price[5]);
        }
    
        return price[id-1];
    }
    
    public int paid()
    {
        int idpaid=productid;
        
        //input
        //exception handling
        try
        {        
            System.out.println("enter price paid");
            String x1=sc.nextLine();
            if(Integer.parseInt(x1)>-Math.pow(2,31) && Integer.parseInt(x1)<(Math.pow(2,31)-1))
            {
                paid=Integer.parseInt(x1);
            }
            else
            {
                System.out.println("Enter valid input");
                paid();
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("you didn’t enter an integer input");
            System.out.println("Error details: "+e.getMessage());
            paid();
        }
        
        if(productid==1)
        {
            if(paid>price[0] || paid==price[0])
            {
                balance=paid-price[0];
                System.out.println("balance = "+balance);
            }
            else
            {
                balance=paid-price[0];
        
                while(balance!=0)
                {
                    System.out.println("amount due "+Math.abs(balance));
          
                    //input
                    //exception handling
                    try
                    {
                        System.out.println("enter 0 for cancel");
                        String x2=sc.nextLine();
                    
                        if(Integer.parseInt(x2)>-Math.pow(2,31) && Integer.parseInt(x2)<(Math.pow(2,31)-1))
                        {
                            choice=Integer.parseInt(x2);
                        }
                        else
                        {
                            System.out.println("enter valid input");
                            continue;
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("you didnt enter integer input");
                        System.out.println("Error details: "+e.getMessage());
                        continue;
                    }
                    
                    if(choice==0)
                    {
                        balance=-1;
                        quantity[0]=quantity[0]+1;
                        break;
                    }
                    else
                    {
                        balance=balance+choice;
                    
                        if(balance>0)
                        {
                            System.out.println("you have recieved "+balance);
                            break;
                        }
                    }
                }
            }
        }
        if(productid==2)
        {
            if(paid>price[1] || paid==price[1])
            {
                balance=paid-price[1];
                System.out.println("balance = "+balance);
            }
            else
            {
                balance=paid-price[1];
                
                while(balance!=0)
                {
                    System.out.println("amount due "+Math.abs(balance));
                 
                    //input
                    //exception handling
                    try
                    {
                        System.out.println("enter 0 for cancel");
                        String x3=sc.nextLine();
                 
                        if(Integer.parseInt(x3)>-Math.pow(2,31) && Integer.parseInt(x3)<(Math.pow(2,31)-1))
                        {
                            choice=Integer.parseInt(x3);
                        }
                        else
                        {
                            System.out.println("enter valid input");    
                            continue;
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("you didnt enter integer input");
                        System.out.println("Error details: "+e.getMessage());
                        continue;
                    }
                
                    if(choice==0)
                    {
                        balance=-1;
                        quantity[1]=quantity[1]+1;
                        break;
                    }
                    else
                    {
                        balance=balance+choice;
                 
                        if(balance>0)
                        {
                            System.out.println("you have recieved "+balance);
                            break;
                        }
                    }
                }
            }
        }
        if(productid==3)
        {
            if(paid>price[2]|| paid==price[2])
            {
                balance=paid-price[2];
                System.out.println("balance = "+balance);
            }
            else
            {
                balance=paid-price[2];
                
                while(balance!=0)
                {
                    System.out.println("amount due "+Math.abs(balance));
                
                    //input
                    //exception handling
                    try
                    {
                        System.out.println("enter 0 for cancel");
                        String x4=sc.nextLine();
              
                        if(Integer.parseInt(x4)>-Math.pow(2,31) && Integer.parseInt(x4)<(Math.pow(2,31)-1))
                        {
                            choice=Integer.parseInt(x4);
                        }
              
                        else
                        {
                            System.out.println("enter valid input");                            
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("you didnt enter integer input");
                        System.out.println("Error details: "+e.getMessage());
                    }
              
                    if(choice==0)
                    {
                        balance=-1;
                        quantity[2]=quantity[2]+1;
                        break;
                    }
                    else
                    {
                        balance=balance+choice;
              
                        if(balance>0)
                        {
                            System.out.println("you have recieved "+balance);
                            break;
                        }
                    }
                }
            }
        }
        if(productid==4)
        {
            if(paid>price[3] || paid==price[3])
            {
                balance=paid-price[3];
                System.out.println("balance = "+balance);
            }
            else
            {
                balance=paid-price[3];
        
                while(balance!=0)
                {
                    System.out.println("amount due "+Math.abs(balance));
        
                    //input
                    //exception handling
                    try
                    {
                        System.out.println("enter 0 for cancel");
                        String x5=sc.nextLine();
                    
                        if(Integer.parseInt(x5)>-Math.pow(2,31) && Integer.parseInt(x5)<(Math.pow(2,31)-1))
                        {
                            choice=Integer.parseInt(x5);
                        }
                        else
                        {
                            System.out.println("enter valid input");                            
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("you didnt enter integer input");
                        System.out.println("Error details: "+e.getMessage());
                    }
                    
                    if(choice==0)
                    {
                        balance=-1;
                        quantity[3]=quantity[3]+1;
                        break;
                    }
                    else
                    {
                        balance=balance+choice;
                       
                        if(balance>0)
                        {
                            System.out.println("you have recieved "+balance);
                            break;
                        }
                    }
                }
            }
        }
        if(productid==5)
        {
            if(paid>price[4] || paid==price[4])
            {
                balance=paid-price[4];
                System.out.println("balance = "+balance);
            }
            else
            {
                balance=paid-price[4];
                
                while(balance!=0)
                {
                    System.out.println("amount due "+Math.abs(balance));
                
                    //input
                    //exception handling
                    try
                    {
                        System.out.println("enter 0 for cancel");
                        String x6=sc.nextLine();
                
                        if(Integer.parseInt(x6)>-Math.pow(2,31) && Integer.parseInt(x6)<(Math.pow(2,31)-1))
                        {
                            choice=Integer.parseInt(x6);
                        }
                        else
                        {
                            System.out.println("enter valid input");                            
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("you didnt enter integer input");
                        System.out.println("Error details: "+e.getMessage());
                    }
                    
                    if(choice==0)
                    {
                        balance=-1;
                        quantity[4]=quantity[4]+1;
                        break;
                    }
                    else
                    {
                        balance=balance+choice;
                    
                        if(balance>0)
                        {
                            System.out.println("you have recieved "+balance);
                            break;
                        }
                    }
                }
            }
        }
        if(productid==6)
        {
            if(paid>price[5] || paid==price[5])
            {
                balance=paid-price[5];
                System.out.println("balance = "+balance);
            }
            else
            {
                balance=paid-price[5];
                
                while(balance!=0)
                {
                    System.out.println("amount due "+Math.abs(balance));
                
                    //input
                    //exception handling
                    try
                    {
                        System.out.println("enter 0 for cancel");
                        String x7=sc.nextLine();
                
                        if(Integer.parseInt(x7)>-Math.pow(2,31) && Integer.parseInt(x7)<(Math.pow(2,31)-1))
                        {
                            choice=Integer.parseInt(x7);
                        }
                        else
                        {
                            System.out.println("enter valid input");                            
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("you didnt enter integer input");
                        System.out.println("Error details: "+e.getMessage());
                    }
                
                    if(choice==0)
                    {
                        balance=-1;
                        quantity[5]=quantity[5]+1;
                        break;
                    }
                    else
                    {
                        balance=balance+choice;
                
                        if(balance>0)
                        {
                            System.out.println("you have received "+balance);
                            break;
                        }
                    }
                }
            }
        }            
        return balance;
    }
    
    public void notSufficientAmount(int p)
    {
        p=paid;
        
        System.out.println("returning your  money...");
        System.out.println("you have recieved rupees "+paid);
        System.out.println("Thank you for visiting (^_^)");
    }
    public int quantityDecrease(int id)
    {
        id=productid;
        int pl=0;
        
        if(productid==1)
        {            
            if(quantity[0]<=0)
            {
                pl=-1;
                return pl;
            }
         
            quantity[0]=quantity[0]-1;
        }
        if(productid==2)
        {           
            if(quantity[1]<=0)
            {
                pl=-1;
                return pl;
            }
         
            quantity[1]=quantity[1]-1;
        }
        if(productid==3)
        {            
            if(quantity[2]<=0)
            {
                pl=-1;
                return pl;
            }
         
            quantity[2]=quantity[2]-1;
        }
        if(productid==4)
        {           
            if(quantity[3]<=0)
            {
                pl=-1;
                return pl;
            }
         
            quantity[3]=quantity[3]-1;
        }
        if(productid==5)
        {            
            if(quantity[4]<=0)
            {
                pl=-1;
                return pl;
            }
         
            quantity[4]=quantity[4]-1;
        }
        if(productid==6)
        {            
            if(quantity[5]<=0)
            {
                pl=-1;
                return pl;
            }
         
            quantity[5]=quantity[5]-1;
        }
        return pl;
    }
    
    public void soldOut()
    {
        System.out.println("the product you have selected is sold out,please select another product");
    }
    
    public void display(int id)
    {
        id=productid;
        System.out.println(product[productid-1] +" dispensed");
        System.out.println("Thank you for visiting (^_^)");
    }
    
    public static void exit()
    {
        System.out.println("Thank you for visiting our Vending Machine");
        System.out.println("This is a project done by"+"\n" +"DEVESH K RAMIYA "+"\n"+"PRANAY ANANDBABU OBLA"+"\n"+"NEERAJ T REDDY");
    }
    
    public static int cashRegister(int id)
    {
        sum=sum+price[id-1];
        return sum;
    }
    
    public static void admin()
    {
        boolean a=adm.login();
        
        if(a==true)
        {        
            labelouter:while(true)
            {
            int choice=adm.display();
            String c="";
        
            switch(choice)
            {
                case 1:
                adm.showBalance();
                System.out.println("do you want to continue (y or n)");
                c=sc.nextLine();
                if(c.equals("y"))
                {
                    continue labelouter;
                }
                else if(!c.equalsIgnoreCase("y")&& !c.equalsIgnoreCase("n"))
                {
                    System.out.println("invalid choice!!!,enter y or n");
                    char d=sc.nextLine().charAt(0);
                    if(d=='y')
                    {
                        continue labelouter;
                    }
                    else
                    {
                        exit();
                        break labelouter;
                    }
                }
           
                exit();
                break labelouter;
           
                case 2:
                adm.showInventory();
                System.out.println("do you want to continue (y or n)");
                c=sc.nextLine();
           
                if(c.equalsIgnoreCase("y"))
                {
                    continue labelouter;
                }
                else if(!c.equalsIgnoreCase("y")&& !c.equalsIgnoreCase("n"))
                {
                    System.out.println("invalid choice!!!,enter y or n");
                    char d=sc.nextLine().charAt(0);
                    if(d=='y')
                    {
                    continue labelouter;
                    }
                    else
                    {
                        exit();
                        break labelouter;
                    }
                }
           
                exit();
                break labelouter;
           
                case 3:     
                adm.changePrice();
                System.out.println("do you want to continue (y or n)");
                c=sc.nextLine();
         
                if(c.equals("y"))
                {
                    continue labelouter;
                }
                else if(!c.equalsIgnoreCase("y")&& !c.equalsIgnoreCase("n"))
                {
                    System.out.println("invalid choice!!!,enter y or n");
                    char d=sc.nextLine().charAt(0);
                    if(d=='y')
                    {
                        continue labelouter;
                    }
                    else
                    {
                        exit();
                        break labelouter;
                    }
                }
     
                exit();
                break labelouter;
                
                case 4:
                adm.changeProduct();
                System.out.println("do you want to continue (y or n)");
                c=sc.nextLine();
                
                if(c.equals("y"))
                {
                    continue labelouter;
                }
                else if(!c.equalsIgnoreCase("y")&& !c.equalsIgnoreCase("n"))
                {
                    System.out.println("invalid choice!!!,enter y or n");
                    char d=sc.nextLine().charAt(0);
                    if(d=='y')
                    {
                        continue labelouter;
                    }
                    else
                    {
                        exit();
                        break labelouter;
                    }
                }
               
                exit();
                break labelouter;
               
                case 5:
                adm.changeQuantity();
                System.out.println("do you want to continue (y or n)");
                c=sc.nextLine();
         
                if(c.equals("y"))
                {
                    continue labelouter;
                }
                else if(!c.equalsIgnoreCase("y")&& !c.equalsIgnoreCase("n"))
                {
                    System.out.println("invalid choice!!!,enter y or n");
                    char d=sc.nextLine().charAt(0);
                    if(d=='y')
                    {
                        continue labelouter;
                    }
                    else
                    {
                        exit();
                        break labelouter;
                    }
                }
       
                exit();
                break labelouter;
       
                case 6:
                vend();
                break labelouter;
            }                       
            }            
        }        
        else
        {
            System.out.println("ERROR!!!! for entering userid and password again press 'y'");
            System.out.println("For returning to vending machine press 'n'");
            char ch=sc.nextLine().charAt(0);
      
            if(ch=='y')
            {
                admin();
            }
            else if(ch=='n')
            {
                ;
            }
            else
            {
                System.out.println("enter valid choice !!,continuing as guest");
                ;
            }
        }
    }
}
