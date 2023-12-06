package FinalParkingLot;

import java.util.Scanner;

public class Payments {
     // Static method to check the payment PIN
     private static boolean checkpin(int pin) {
        if (pin == 123) {
            System.out.println("Payment Successful! Thank you for using mvnls Parking Plaza!! Looking forward to seeing you again!!\n");
        } else {
            System.out.println("Payment Unsuccessful. Please try again!!\n");
            return false;
        }
        return true;
    }
    // Static method to process payment for a vehicle
    public static void Payment(vehicle obj, int time) {
        System.out.printf("Welcome!! Vehicle token number is %d\n", obj.token);
        int additionalCost = 0;
        if (obj.ifcharged == true) {
            additionalCost = 100;
        }
        int cost=additionalCost,i=2;
        while(i!=0 && time>0)
        {
            if(i==2)
            {
                cost+=20;
                time--;i--;
            }
            else
            {
                cost+=10;
                time--;i--;
            }
        }
        if(time>0)
        {
            cost+=time*5;
        }
        System.out.printf("Your cost is %d\n",cost);
        // switch (time) {
        //     case 1:
        //         System.out.printf("Your cost is : %d\n", 20 + additionalCost);
        //         break;
        //     case 2:
        //         System.out.printf("Your cost is : %d\n", 30 + additionalCost);
        //         break;
        //     case 3:
        //         System.out.printf("Your cost is : %d\n", 40 + additionalCost);
        //         break;
        //     default:
        //         System.out.printf("Your cost is : %d\n", (40 + (time - 3) * 5) + additionalCost);
        //         break;
        // }
        System.out.println("Please choose a payment method:\n1) UPI 2) Google Pay 3) Phone Pay 4) Paytm 5) Cash");
        int choice; // PIN is 123
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.printf("Welcome to the payment portal for method %d:\nPlease enter your PIN (PIN is 123)\n", choice);
                break;
            case 5:
                System.out.println("Welcome to the Security Desk:\nKindly submit the cash with suitable change :)\n1) Enter PIN");
                break;
        }
        while (!Payments.checkpin(sc.nextInt())) ;
    }
}
