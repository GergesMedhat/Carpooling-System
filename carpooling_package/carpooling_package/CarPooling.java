/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpooling_package;
import java.util.Scanner;
/**
 *
 * @author pm
 */
/**public class including classes*/
public class CarPooling {
   
     public static void main(String[] args) {
               
        CarPooling cp= new CarPooling();
        passenger[] p=new passenger[20];
        p[0]=cp.new supscriper(25 ,"subscriper" ,9,"Shoubra","Maadi",844);
        p[1]=cp.new supscriper(30 ,"subscriper" ,20,"NewCairo","October",150);
        p[2]=cp.new non("nonsubscriper" ,"Ramsis","Elgiza");
 
           car[] cars=new car [3];
         cars[0]=cp.new car(726,4,"Shoubra","Maadi",3,"Ahmed");
         cars[1]=cp.new car(155,3,"NewCairo","October",4,"Mohammed");
         cars[2]=cp.new car(485,5,"Ramsis","Elgiza",3,"Magdy");
        ticket t=cp.new ticket();
    
        Scanner category=new Scanner(System.in);
        Scanner start=new Scanner(System.in);
        Scanner des=new Scanner(System.in);
        passenger passenger=cp.new passenger();
        p[3]=passenger;
        imp m =new imp();
        supscriper sup=cp.new supscriper();
        non no=cp.new non();   
       
       System.out.println("Enter Your location and route");
        passenger.startroute =start.next();
       passenger.destination =des.next();
       
       if( (passenger.startroute.equals(cars[0].startroute)) & passenger.destination.equals(cars[0].destination))
       {
           System.out.println("Car 1 is Available");
           t.c.code=cars[0].code;
           t.c.name=cars[0].name;
       }
      else if( (passenger.startroute.equals(cars[1].startroute)) & (passenger.destination.equals(cars[1].destination)) )
       {
           System.out.println("Car 2 is Available");
           t.c.code=cars[1].code;
           t.c.name=cars[1].name;
       }
      else if( (passenger.startroute.equals(cars[2].startroute)) & (passenger.destination.equals(cars[2].destination)) )
       {
           System.out.println("Car 3 is Available");
           t.c.code=cars[2].code;
           t.c.name=cars[2].name;
       }
      else{
          System.out.println("No Car Available");
           return ; 
      }
       
   
       System.out.println("supscriper or nonsupscriper");
       passenger.category=category.next();
     
       if (passenger.category.equals("supscriper")||passenger.category.equals("Supscriper"))
       {
           Scanner ID =new Scanner(System.in);
           System.out.println("Enter your ID");
           int k=ID.nextInt();
            for (int i=0;i<p.length;i++) {
                if (p[i].id == k) {
                    System.out.println("you are supscriper!");
                    float price = sup.price();
                    System.out.println("your ticket's price =" + price);
                   break;
                } else {
                    System.out.println("your not supscriper");
                    return ;
                }
            }
      
         
           
       }
       else if (passenger.category.equals("nonsupscriper")||passenger.category.equals("Nonsupscriper"))
       {
          float price=no.price();
       System.out.println("your ticket's price =" + price);
       }
       else {
           System.out.println("wrong input");
            return;
       }
      Scanner choice=new Scanner(System.in);
      System.out.println("1 for new search");
      System.out.println("2 for Reserve a ticket");
      System.out.println("3 for supscripe");
      System.out.println("4 for Complaint or Review");
      System.out.println("5 for non supscription");
      System.out.println("6 for Display passengers information");
      System.out.println("7 for Display cars information");
        int x=choice.nextInt();
        switch(x)
        {
            case 1:
                m.search(cars); 
                break;
            case 2: 
                if(passenger.category.equals("supscriper")||passenger.category.equals("Supscriper")){
                m.Reserve_ticket(passenger,t);
                no.nonsupscripe(passenger);}
                else if (passenger.category.equals("nonsupscriper")||passenger.category.equals("Nonsupscriper"))
                  m.Reserve_ticket(passenger, t);
                break;
            case 3:
                if (passenger.category.equals("nonsupscriper")||passenger.category.equals("Nonsupscriper")){
                sup.supscripe(passenger);
                }
               try{ if(passenger.category.equals("supscriper"))throw new MakeException("you already supscriper!");
               }catch(MakeException e){System.out.println("Error:" + " "  +e.getMessage());}
                break;
            case 4:
                m.Review(passenger);
                break;
            case 5:
                if(passenger.category.equals("supscriper")||passenger.category.equals("Supscriper")){
                 no.nonsup(passenger);
                System.out.println("you are non supscriper now");}
                else if (passenger.category.equals("nonsupscriper")||passenger.category.equals("Nonsupscriper"))
                 System.out.println("you already non supscriper");
                break;
            case 6:
                if (passenger.category.equals("supscriper")||passenger.category.equals("Supscriper")){
                for(int i = 0 ;i<3 ; i++)
                {
                    System.out.println("passenger" + " "+ (i+1)+ "start route is" + " "+p[i].startroute + " "+"destination is" + " "+ p[i].destination + " "+ "category is" + " "+p[i].category + " "+ "Age =" + " "+p[i].Age);
                }
              
                }
                else if(passenger.category.equals("nonsupscriper")||passenger.category.equals("Nonsupsriper"))
                 {
                  for(int i=0;i<4;i++)
                  {
                    System.out.println("passenger" + " "+ (i+1)+ "start route is" + " "+p[i].startroute + " "+"destination is" + " "+ p[i].destination + " "+ "category is" + " "+p[i].category + " "+ "Age =" + " "+p[i].Age);
                  }
                  
                 }
                break;
            case 7:
                m.DisplayCars(cars);
                break;
            default: 
               
                System.out.println("wrong input");
        }
     }
     
    /** class represent cars */
     protected class car 
     { 
     /** code of car */
         protected int code; 
         /** number of trips of car */
         protected int numberoftrips; 
         /** start route for car */
         protected final String startroute; 
         /** finish route for car */
         protected final String destination; 
         /** capacity of car */
         protected int capacity; 
         /** driver name */
         protected String name; 

         car()
        {
startroute="";
destination="";

        }
       /**
        * 
        * @param code represent code of car
        * @param n represent number of trips
        * @param s represent start route for car
        * @param d represent end route for car
        * @param cap represent capacity of car
        * @param name represent driver name
        */
       car(int code , int n ,final String s, final String d , int cap , String name) 
        {
        this.code=code;
        numberoftrips=n;
        startroute=s;
        destination=d;
        capacity=cap;
        this.name=name;
        
        }
      
    
        
     }
     /**class represent a ticket */
     protected class ticket 
    { /**
     * 
     */
     CarPooling cp= new CarPooling();
     /** price of ticket */
     protected float price=50; 
    car c=cp.new car();
    /**
     * 
     */
     ticket()
     {
      
     }
     /**
      * 
      * @param code code of ticket
      * @param price price of ticker
      */
      ticket( int code , float price) 
     {
       c.code=code;
       this.price=price;
     }
    
    }
  
     /**parent  class represent passengers which supscriper or nonsupscriper  */
    protected  class passenger 
    {
        /** id for supscriper **/
      protected  int id;
     CarPooling cp= new CarPooling();
     /** start route for passenger */
    protected String startroute; 
    /** end route for passenger */
    protected String destination; 
    /** age of passenger */
    protected int Age; 
    /** category of passenger */
    protected String category; 
    /** number of trips for passenger */
    protected int number_of_trips; 
    /** review from passenger */
    protected String review; 
    protected boolean supscriper;
    ticket t=cp.new ticket();
    /**
     * 
     */ 
     passenger()
     {
   
     }
     /**
      * 
      * @param Age age of passenger 
      * @param categ category of passenger
      * @param num number of trips of passenger
      * @param s start route 
      * @param d end route
      */
     passenger(String categ ,String s,String d )
     {
       
   
     category=categ;
     
     startroute=s;
     destination=d;
  
     }
    /**
     * 
     * @return r
     */
         float price() 
     {
      return t.price;
     }
     }
     
    /** inheritance  , child class represent supscriper passengers */
    private class supscriper extends passenger 
    { 
        
        supscriper()
        {
            this.supscriper=true;
        }
        supscriper(int Age ,String categ , int num,String s,String d,int id)
        {
        super(categ,s,d);
        this.Age=Age;
        this.number_of_trips=num;
        this.id=id;
        this.supscriper=true;
        }
        supscriper(int Age , String categ,int num) //overloading
        {
        this.Age=Age;
        this.number_of_trips=num;
        this.supscriper=true;
        }
   /**
    * 
    * @param p 
    */
     public final void supscripe(passenger p)  //final method
    {
       Scanner c=new Scanner(System.in);
       Scanner a=new Scanner(System.in);
       Scanner n=new Scanner(System.in);
     System.out.println("enter number of trips");
     p.number_of_trips=n.nextInt();
     System.out.println("enter your age");
     p.Age=a.nextInt();
     
    if ( (p.Age >= 25) & (p.number_of_trips >= 20) )
    {   
        t.price=(t.price * p.number_of_trips) / 2 ; //caluclated data member
        System.out.println("Your supscription price =" + " " + t.price);
        System.out.println("do you want to supscripe?" + "press y to confirm or n for canceld");
        String x=c.next();
        if((x.equals("y"))||(x.equals("Y"))){
    p=new supscriper(p.Age,"supscriper",p.number_of_trips);
    
    System.out.println("you are supscriper now");
    
        }
       else if((x.equals("n"))||(x.equals("N")))
                System.out.println("your order is canceled");
       else{
           System.out.println("wrong choice");
           return ;
       }
    }
    else 
    {
    System.out.println("Age must >= 25 and number of trips >=20");
    }
    }
     /**overriding , method to discount 50% for supscriper
          * @return r*/
    @Override
             
     float price() 
     {
       t.price=t.price/2;
      return t.price;
     }
    }
    /**inheritance , child class represent nonsupscriper passengers */
    private class non extends passenger 
    {
        non()
        {
        this.supscriper=false;
        }
        non(String categ ,String s,String d)
        {
        super(categ,s,d);
        this.supscriper=false;
        }
   /** @param p for convert supscriper to nonsupscriper when number of trips is ended */
    public final void nonsupscripe(passenger p)  //final method
    {
         p.number_of_trips--;
          while(p.number_of_trips==0)
          p.category="nonsupscriper";       
         p.supscriper=false;
     
    }
   /** method to convert supscriper to nonsupscriper when user wanted
          * @param p  to convert supscriper to nonsupscriper when user wanted*/
     public final void nonsup(passenger p) //final method
    {
    p.category="nonsupscriper";
    p.supscriper=false;
    }
     /** overriding
          * @return r */
    @Override
     float price() 
      {
      return t.price;
      }
    
    }
    /**interface have 4 abstract method */
    private interface pass 
    {
        /**abstract method to search for car*/
        /**
         * 
         * @param c 
         */
    abstract public void search(car []c); 
    /** @param p represent passenger*/
    abstract public void Review(passenger p); 
    /** *  @param p for passenger
          * @param t to get ticket*/
    abstract public void Reserve_ticket(passenger p , ticket t); 
    /**
     * 
     * @param c 
     * method display cars information
     */
    abstract public void DisplayCars(car []c);
    }
    /**static class implements interface */
    private static class imp implements pass  
    {
        /**overriding */
      
        
        /**method to search 
          * @param c*/
      
    @Override
    public final void search(car []c) //final method
    {
    Scanner start =new Scanner(System.in);
    Scanner finish =new Scanner(System.in);
    System.out.println("Enter your start location then your destination");
    String s = start.next();
    String f = finish.next();
    for(int i=0 ; i < 3 ; i++)
    {
    if( (s.equals(c[i].startroute)) & (f.equals(c[i].destination)) )
        System.out.println("Car" +" "+ (i+1) +" "+ "in the same route");
    else
        System.out.println("car" +" "+ (i+1)+" "+ "is not avilable");
    }
      
    }
    /**overriding , method user can write review */
    @Override
    /**
     * @param p */
    public  final void Review(passenger p) 
    {
        
    Scanner r = new Scanner(System.in);
    Scanner a = new Scanner(System.in);
    System.out.println("Whis is your complaint?");
    String s=r.next();
    try{
           if(s.equals(""))
           throw new MakeException("this message is empty");    
       }catch(MakeException e){System.out.println("Error" + e.getMessage());}
    s+=r.nextLine();
     
    System.out.println("Your complaint is" +" "+ s + " " + "press y for confirm or n for cancel");
    String x=a.next();
     
    if((x.equals("y"))||(x.equals("Y"))){
     p.review=s;
        System.out.println("Your complaint is sent");
    }
    else if((x.equals("n"))||(x.equals("N")))
        System.out.println("Your complaint is canceled");
    else{
        System.out.println("Wrong input");
        return;}
    }
    /**overriding , method to reserve a ticket when get a car*/
     @Override 
     /**
      @param p represent passenger 
      @param t represent ticket */
    public  void Reserve_ticket(passenger p ,ticket t) 
    {
     Scanner x=new Scanner(System.in);
    System.out.println("Do you want reserve a ticket?" + " 'yes' for reserve or 'no' for canceled");
    String s=x.next();
    if(s.equals("yes")||s.equals("Yes"))
    {
      if(p.category.equals("supscriper")||p.category.equals("Supscriper")){
      p.number_of_trips--;
     System.out.println(" * you reserved a ticket *");
     t.price=t.price/2;
     System.out.println("Your ticket price = " + " "+ t.price);
     System.out.println("Your ticket code is " + " " +t.c.code);
     System.out.println("Driver name is" + " " + t.c.name);
    }
    
      else if(p.category.equals("nonsupscriper")||p.category.equals("Nonsupscriper"))
      {
        t.price = p.price();
        System.out.println(" * You reserved a ticket * ");
        System.out.println("Your ticket price =" + t.price); 
        System.out.println("Your ticket code is " + " "+ t.c.code);
        System.out.println("Driver name is" + " " + t.c.name);
      }
    }
    else if (s.equals("no")||s.equals("No"))
        System.out.println("order is canceled");
    else{
        System.out.println("Wrong input");
       return ;
    }
    }
    @Override
    /** method display cars information */
    
    public void DisplayCars(car []c)
    {
    for(int i=0;i<c.length;i++)
    {
    System.out.println("car " +(i+1)+":  " +"code:  " +c[i].code +"  " +"number of trips:  " +c[i].numberoftrips +"  " +"start route:  " +c[i].startroute+"  "+"destination:  " +c[i].destination +"  "+"capacity =  "+c[i].capacity+"  "+"driver name  "+c[i].name);
    }
    }
    }
    /**user defined exception that takes the error as a string and display */
    
    private static class MakeException extends Exception{ 
    /**
     * 
     * @param message 
     */
        public MakeException(String message)
        {
        super(message);
        }
    }
}
