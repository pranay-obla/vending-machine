import java.util.Scanner;

public class Administrator
{
    //instance variable
    //class variables
    static String userid="";
    static String password="";    
    //local variables
    public int savings=0;
    int choice=0;
    int np=0;
    
    //object creation
    VendingMachine vm=new VendingMachine();
    static Scanner sc=new Scanner(System.in);
    
    public boolean login()
    {
        boolean admin=false;
        
        //input
        System.out.println("enter your admin usename");
        userid=sc.nextLine();
        
        //check username and password
        if(userid.equals("dp"))
        {
            System.out.println("enter admin password");
            password=sc.nextLine();
            
            if(!password.equals("admin"))
            {
                System.out.println("incorrect password");
                admin=false;
            }
            else if(password.equals("admin"))
            {
                admin=true;
            }            
        }
        else 
        {
            System.out.println("wrong user id enter correct id");
            admin=false;
        }
        
        return admin;
    }
    
    public int display()
    {
        int choice=0;
        
        //input
        //exception handling
        try
        {
            System.out.println("1.Show cash balance");
            System.out.println("2.show inventory");
            System.out.println("3.change price");
            System.out.println("4.change product");
            System.out.println("5.change quantity");
            System.out.println("6.continue as guest");
            String y1=sc.nextLine();
            
            if(Integer.parseInt(y1)>-Math.pow(2,31) && Integer.parseInt(y1)<(Math.pow(2,31)-1))
            {
                choice=Integer.parseInt(y1);
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("you didnt enter an integer");
            System.out.println("Error details: "+e.getMessage());
        }
        
        return choice;
    }
    
    public void showBalance()
    {
        savings=vm.sum;
        System.out.println("Total savings : "+savings);
    }
    
    public void showInventory()
    {
        System.out.println("product : "+vm.product[0]+"\n"+"quantity left : "+vm.quantity[0]); 
        System.out.println("product : "+vm.product[1]+"\n"+"quantity left : "+vm.quantity[1]); 
        System.out.println("product : "+vm.product[2]+"\n"+"quantity left : "+vm.quantity[2]); 
        System.out.println("product : "+vm.product[3]+"\n"+"quantity left : "+vm.quantity[3]); 
        System.out.println("product : "+vm.product[4]+"\n"+"quantity left : "+vm.quantity[4]); 
        System.out.println("product : "+vm.product[5]+"\n"+"quantity left : "+vm.quantity[5]);
    }
    
    public void changePrice()
    {
        //input
        //exception handling
        try
        {
            System.out.println("enter the product id of the product of which you want to change the price");
            String y2=sc.nextLine();
            
            System.out.println("enter the new price");
            String y3=sc.nextLine();
            
            if(Integer.parseInt(y2)>-Math.pow(2,31) && Integer.parseInt(y2)<(Math.pow(2,31)-1))
            {
                choice=Integer.parseInt(y2);
            }
            
            if(Integer.parseInt(y3)>-Math.pow(2,31) && Integer.parseInt(y3)<(Math.pow(2,31)-1))
            {
                np=Integer.parseInt(y3);
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("you didnt enter an integer");
            System.out.println("Error details: "+e.getMessage());
        }
        
        switch(choice)
        {
            case 1:
            vm.price[0]=np;
            break;
            
            case 2:
            vm.price[1]=np;
            break;
            
            case 3:
            vm.price[2]=np;
            break;
            
            case 4:
            vm.price[3]=np;
            break;
            
            case 5:
            vm.price[4]=np;
            break;
            
            case 6:
            vm.price[5]=np;
            break;
            
            default:
            System.out.println("enter a valid id");
        }
        
        if((choice>=1 && choice<=6) && (np>-Math.pow(2,31) && np<(Math.pow(2,31)-1)))
        {
            System.out.println("you have successfully changed the price of "+vm.product[choice-1]);
        }
    }
    
    public void changeProduct()
    {
        int cp=0;
        int npr=0;
        int cq=0;
        
        //input
        System.out.println("enter name of new product");
        String np=sc.next();
        //exception handling
        try
        {
            System.out.println("enter quantity of new product");
            String y8=sc.next();
            
            System.out.println("enter product id of the product to be replaced");
            String y6=sc.next();
            
            System.out.println("enter price of new product");
            String y7=sc.next();
            
            if(Integer.parseInt(y6)>-Math.pow(2,31) && Integer.parseInt(y6)<(Math.pow(2,31)-1))
            {
                cp=Integer.parseInt(y6);
            }
            
            if(Integer.parseInt(y7)>-Math.pow(2,31) && Integer.parseInt(y7)<(Math.pow(2,31)-1))
            {
                npr=Integer.parseInt(y7);
            }        
            if(Integer.parseInt(y8)>-Math.pow(2,31) && Integer.parseInt(y8)<(Math.pow(2,31)-1))
            {
                cq=Integer.parseInt(y8);
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("you didnt enter an integer");
            System.out.println("Error details: "+e.getMessage());
        }
        
        switch(cp)
        {
            case 1:
            vm.product[0]=np;
            vm.price[0]=npr;
            vm.quantity[0]=cq;
            break;
            
            case 2:
            vm.product[1]=np;
            vm.price[1]=npr;
            vm.quantity[1]=cq;
            break;
            
            case 3:
            vm.product[2]=np;
            vm.price[2]=npr;
            vm.quantity[2]=cq;
            break;
            
            case 4:
            vm.product[3]=np;
            vm.price[3]=npr;
            vm.quantity[3]=cq;
            break;
            
            case 5:
            vm.product[4]=np;
            vm.price[4]=npr;
            vm.quantity[4]=cq;
            break;
            
            case 6:
            vm.product[5]=np;
            vm.price[5]=npr;
            vm.quantity[5]=cq;
            break;
        }
        
        System.out.println("you have successfully changed a product");
    }
    
    public void changeQuantity()
    {
        int cq=0;
        int nq=0;
        
        //input
        //exception handling
        try
        {
            System.out.println("enter the productid of the product of which you want to change the quantity");
            String y4=sc.nextLine();
        
            System.out.println("enter the new quantity ");
            String y5=sc.nextLine();
        
            if(Integer.parseInt(y4)>-Math.pow(2,31) && Integer.parseInt(y4)<(Math.pow(2,31)-1))
            {
                cq=Integer.parseInt(y4);
            }
        
            if(Integer.parseInt(y5)>-Math.pow(2,31) && Integer.parseInt(y5)<(Math.pow(2,31)-1))
            {
                nq=Integer.parseInt(y5);
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("you didnt enter an integer");
            System.out.println("Error details: "+e.getMessage());
        }
        
        switch(cq)
        {
            case 1:
            vm.quantity[0]=nq;
            break;
        
            case 2:
            vm.quantity[1]=nq;
            break;
        
            case 3:
            vm.quantity[2]=nq;
            break;
        
            case 4:
            vm.quantity[3]=nq;
            break;
        
            case 5:
            vm.quantity[4]=nq;
            break;
        
            case 6:
            vm.quantity[5]=nq;
            break;
        
            default:
            System.out.println("enter a valid id");
        }
    }    
}
