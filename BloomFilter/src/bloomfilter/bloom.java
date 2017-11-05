package bloomfilter;    


import java.util.BitSet;
    import java.util.Random;
import java.util.Scanner;

    public class bloom {

    private static void Switch(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        private final BitSet bs;

        final int [] hashSeeds;

        final int capacity;

        public bloom(int slots, int hashFunctions) {
            bs = new BitSet(slots);
            Random r = new Random(System.currentTimeMillis());
            hashSeeds = new int[hashFunctions];
            for (int i=0; i<hashFunctions; ++i) {
                hashSeeds[i] = r.nextInt();
            }
            capacity = slots;
        }

        public void add(int value) {
            byte [] b = new byte[] {
                    (byte)(value >>> 24),
                    (byte)(value >>> 16),
                    (byte)(value >>> 8),
                    (byte)value};
            for (int i=0; i<hashSeeds.length; ++i) {
                int h = MurmurHash.hash32(b, 4, hashSeeds[i]);
                bs.set(Math.abs(h)%capacity, true);
            }
        }

        public void clear() {
            bs.clear();
        }

        public boolean mightContain(int value) {
            byte [] b = new byte[] {
                    (byte)(value >>> 24),
                    (byte)(value >>> 16),
                    (byte)(value >>> 8),
                    (byte)value};
            for (int i=0; i<hashSeeds.length; ++i) {
                int h = MurmurHash.hash32(b, 4, hashSeeds[i]);

                if(!bs.get(Math.abs(h)%capacity)) {
                    return false;


            }
            }
            return true;
        
        }
        
        void layout()
        {
            System.out.println("The layout of seats are:");                                        
            for(int j=1;j<=50;j++)
            {   
              if(j==1)
              {
                  System.out.print("A:\t");
              }
              if(j>=1 && j<10)
               {
                 System.out.print(j+"\t");
               }
              else if(j==10)
              {
                System.out.print(j);   
                System.out.println();
              }
              else if(j>=11 && j<20)
              {
                if(j==11)
              {
                System.out.print("B:\t");
              }
                                                            
                System.out.print(j+"\t");
              }
                                                        
               else if(j==20)
              {
                                                            
               System.out.print(j+"\t");
               System.out.println();
              }
                else if(j>=21 && j<30)
                {
                  if(j==21)
                {
                   System.out.print("C:\t");
                }
                                                            
                   System.out.print(j+"\t");
                }
                else if(j==30)
               {
                System.out.print(j+"\t");
                System.out.println();
               }
               else if(j>=31 && j<40)
               {
                if(j==31)
                {
                 System.out.print("D:\t");
                }
                System.out.print(j+"\t");
                }
                else if(j==40)
                {
                System.out.print(j+"\t");
                System.out.println();
                }
                else 
                {
                 if(j==41)
                {
                 System.out.print("E:\t");
                }
                 System.out.print(j+"\t");
                }
                }
                System.out.println();
         }
        
        


        public static void main(String args[]) {
            bloom bf = new bloom(1000, 10);
            System.out.println("Total 50 Seats are available in the movie theatre for movie Fast and Furious 7");
            System.out.println("The Price for tickets are:");
            System.out.println("A,B - 80 rs");
            System.out.println("C,D - 120 rs");
            System.out.println("E - 200 rs");
            System.out.println();
            System.out.println("Layout of seats");
            bf.layout();
            System.out.println();
            
            int i;
            i=0;
            while(i<2)
            {
                
                System.out.println("Enter Your Choice:");
                System.out.println("1 for booking tickets of new customer");
                System.out.println("2 for Ending Booking of tickets");
                Scanner s =new Scanner(System.in);
                i=s.nextInt();
                switch(i)
                        {
                          case 1:
                                    int n=0;
                                    while(n<3)
                                    {
                                        System.out.println("Enter your choice for current customer");
                                        System.out.println("1 for Recommending Seats");
                                        System.out.println("2 for booking seats and transaction");
                                        System.out.println("3 for ending session of current customer");
                                        Scanner ss=new Scanner(System.in);
                                        n=ss.nextInt();
                                        switch(n)
                                        {
                                            case 1:
                                                    int f=0;
                                                    
                                                    System.out.println();
                                                    System.out.println("Seats available are:");
                                                    for(int j=1;j<=50;j++)
                                                    {   
                                                        
                                                        if(j==1)
                                                        {
                                                            System.out.print("A:\t");
                                                        }
                                                        if(j>=1 && j<10)
                                                        {
                                                        if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print(" -"+"\t");
                                                        }
                                                        else if(j==10)
                                                        {
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else
                                                            System.out.print("-"+"\t");
                                                        
                                                        System.out.println();
                                                        }
                                                        else if(j>=11 && j<20)
                                                        {
                                                            if(j==11)
                                                        {
                                                            System.out.print("B:\t");
                                                        }
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print("-"+"\t");
                                                        }
                                                        else if(j==20)
                                                        {
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print("-"+"\t");
                                                        
                                                        System.out.println();
                                                        }
                                                        else if(j>=21 && j<30)
                                                        {
                                                            if(j==21)
                                                        {
                                                            System.out.print("C:\t");
                                                        }
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print("-"+"\t");
                                                        }
                                                        else if(j==30)
                                                        {
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print("-"+"\t");
                                                        
                                                        System.out.println();
                                                        }
                                                        else if(j>=31 && j<40)
                                                        {
                                                            if(j==31)
                                                        {
                                                            System.out.print("D:\t");
                                                        }
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print("-"+"\t");
                                                        }
                                                        else if(j==40)
                                                        {
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print("-"+"\t");
                                                        
                                                        System.out.println();
                                                        }
                                                        else 
                                                        {
                                                            if(j==41)
                                                        {
                                                            System.out.print("E:\t");
                                                        }
                                                            if(!bf.mightContain(j))
                                                        {
                                                            f=1;
                                                            System.out.print(j+"\t");
                                                        }
                                                        else 
                                                            System.out.print("-"+"\t");
                                                        }
                                                    }
                                                    System.out.println();
                                                    if (f==0)
                                                    {
                                                        System.out.println("No seats available - Theatre full");
                                                    }
                                                    break;
                                            case 2:
                                                    
                                                    {
                                                    int k;
                                                    k=0;
                                                    int sum=0;
                                                    while(k<3)
                                                    {
                                                        
                                                        System.out.println("Enter your choice");
                                                        System.out.println("1 for booking a seat");
                                                        System.out.println("2 for total amount and checkout of current customer");
                                                         
                                                        k=ss.nextInt();
                                                        switch(k)
                                                        {
                                                            case 1: 
                                                                    
                                                                    int l;
                                                                    
                                                                    System.out.println("Enter the seat number to book");
                                                                    l=s.nextInt();
                                                                    if(l>0 && l<=50)
                                                                    {
                                                                    if(bf.mightContain(l))
                                                                    {
                                                                        System.out.println("Seat not available");
                                                                        break;
                                                                    }
                                                                    else
                                                                    {
                                                                        bf.add(l);
                                                                        if(l<=20)
                                                                        {
                                                                            sum=sum+80;
                                                                        }
                                                                        else if(l<=40)
                                                                        {
                                                                            sum=sum+120;
                                                                        }
                                                                        else 
                                                                            sum=sum+200;
                                                                    }
                                                                    
                                                                    }
                                                                    else 
                                                                        System.out.println("Invalid input");
                                                                    break;
                                                            case 2: 
                                                                    System.out.println("Total amount to pay is "+sum+" Rs");
                                                                    k=5;
                                                                    break;
                                                        }
                                                             
                                                                    
                                                        
                                                        }
                                                    
                                                    }
                                                    
                                                    }
                                        }
                                    }
                        }
            }
             
           


        }
    
