import FinalParkingLot.*;
import java.util.ArrayList;
import java.util.Scanner;


public class final_parkinglot {
    public static void main(String[] args) {
        System.out.println("***Welcome to Krishna ParkingLot***");
        ArrayList<userVehicle> arr = new ArrayList<userVehicle>();
        Scanner sc = new Scanner(System.in);
        Building Parking =new Building();
        int choice;
        int done=2;
        while(done!=1)
        {   
            System.out.println("Which way do you want to go:\n1)enter vehicles into the lot\n2)exit the entered vehicles");
            choice=sc.nextInt();
            int out=1;
            switch(choice)
            {
                case 1:
                while(out==1)
                {
                    System.out.println("\n\n*****There is a lift at the right corner and a ramp at the left corner near entry to move up*****");
                    System.out.println("*Costumer info system is near the lift which can be used to do payment.*");
                    System.out.println("*There is a lift at the right corner and a ramp at the left corner near exit to move down*\n\n");
                    System.out.println("Enter the type of vehicle(#wheels)");
                    int size=sc.nextInt();
                    System.out.println("Enter the type of vehicle(electric or not)\n1)Yes\n2)No");
                    boolean b=false;
                    int ele=sc.nextInt();
                    if(ele==1)
                    {
                        b=true;
                    }
                    System.out.println("Enter the numberPlate of vehicle");
                    int numberplate=sc.nextInt();
                    userVehicle obj=new userVehicle(b,size, numberplate);
                    if(Parking.Capacityboard(obj))
                    {
                        arr.add(obj);
                    }
                    else
                    {
                        continue;
                    }
                    System.out.println("Do you wish to add more vehicles??\n1)Yes\n2)No");
                    out=sc.nextInt();
                }
                break;
                case 2:
                while(arr.size()!=0 && out==1)
                {
                    int i=0;
                    out=1;
                    int choose;
                    System.out.printf("Exiting vehicle : %d\n",arr.size());
                    System.out.println("Do you wish to pay at exit or at payment portal?? Enter 1 if you wish to pay at portal!!\n");
                    choose=sc.nextInt();
                    if(choose==1)
                    {
                        arr.get(i).payatportal();
                    }
                    else
                    {
                        arr.get(i).exit();
                    }
                    arr.remove(i);
                    System.out.println("Do you wish to exit more vehicles??\n1)Yes\n2)No");
                    out=sc.nextInt();
                }
            }
            System.out.println("Are you done for today??\n1)Yes\n2)No 3) I want to exit the entered Vehicles");
            done=sc.nextInt();
        }
    
    }
}

