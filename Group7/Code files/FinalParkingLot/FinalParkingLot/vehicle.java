package FinalParkingLot;
import java.time.Duration;
import java.time.Instant;
public abstract class vehicle {
      protected int size; // Size of the vehicle (number of wheels)
    protected int token; // Unique token for the vehicle
    protected int numberPlate = 0; // Vehicle's number plate
    protected static int increment = 0; // Static counter to generate unique tokens
    protected boolean electric; // Indicates if the vehicle is electric
    private boolean paid; // Indicates if the parking fee is paid
    private floors parkingFloors; // Reference to the parking floor where the vehicle is parked
    protected boolean ifcharged = false; // Indicates if the vehicle was charged
    private Building statusfloor; // Reference to the building where the vehicle is parked

    vehicle() {
        increment++;
        token = increment;
    }
    private Instant entryTime; // Entry time
    private Instant exitTime;  // Exit time

    // Calculate time elapsed in minutes
    protected int getTimeElapsedMinutes() {
        Duration duration = Duration.between(entryTime, exitTime);
        return (int)duration.getSeconds();
    }
    // Getter for the payment status
    public boolean paid_status() {
        return this.paid;
    }

    // Method to set the payment status based on a government ID
    protected void setPaidStatus(int govtId, boolean b) {
        if (govtId == 123) {
            this.paid = b;
        }
    }

    // Method to set the token for the vehicle based on a government ID
    protected void setToken(int govtId, int token) {
        if (govtId == 123) {
            this.token = token;
        }
    }

    // Method to set the start time for the vehicle based on a government ID
    protected void setStartTime(int govtId) {
        if (govtId == 123) {
            entryTime = Instant.now();
        }
    }

    // Method to calculate and return the elapsed time
    // Method to set the end time for the vehicle based on a government ID
    protected void setEndTime(int govtId) {
        if (govtId == 123) {
            exitTime = Instant.now();
        }
    }

    // Method to set the parking floor for the vehicle
    void setParkingFloor(floors floor) {
        this.parkingFloors = floor;
    }

    // Method to set the building where the vehicle is parked
    void setbuilding(Building floor) {
        this.statusfloor = floor;
    }

    // Method to handle charging for electric vehicles
    void charging_by_cost() {
        if (this.electric == true) {
            System.out.println("\n------------------You HAVE CHOSEN TO CHARGE YOUR VEHICLE--------------------\n********Please pay price to charge: 100 rupees*********\n");
            ifcharged = true;
        } else {
            System.out.println("Sorry, your car is not electric");
        }
    }

    // Method to print the status of parking floors
    void printstatus() {
        System.out.println("ground");
        System.out.println("-------------" + "electricSpace " + this.statusfloor.ground.electricCurrentCap + "-------------");
        System.out.println("-------------" + "normalSpace " + this.statusfloor.ground.fossilCurrentCap + "-------------");
        System.out.println("First");
        System.out.println("-------------" + "electricSpace " + this.statusfloor.first.electricCurrentCap + "-------------");
        System.out.println("-------------" + "normalSpace " + this.statusfloor.first.fossilCurrentCap + "-------------");
        System.out.println("Second");
        System.out.println("-------------" + "electricSpace " + this.statusfloor.second.electricCurrentCap + "-------------");
        System.out.println("-------------" + "normalSpace " + this.statusfloor.second.fossilCurrentCap + "-------------");
        System.out.println("Third");
        System.out.println("-------------" + "electricSpace " + this.statusfloor.third.electricCurrentCap + "-------------");
        System.out.println("-------------" + "normalSpace " + this.statusfloor.third.fossilCurrentCap + "-------------");
    }

    // Method for the vehicle to pay at the payment portal
    public void payatportal() {
        if (parkingFloors != null) {
            this.parkingFloors.paymentPortal(this);
        } else {
            System.out.println("Error: Vehicle is not parked anywhere in the parking lot!!");
        }
    }

    // Method for the vehicle to exit the parking
    public void exit() {
        System.out.println("YOU HAVE CHOSEN TO PAY AT EXIT");
        this.parkingFloors.exit.recieveVehicle(this);
    }
}
