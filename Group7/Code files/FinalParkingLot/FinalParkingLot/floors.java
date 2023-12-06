package FinalParkingLot;

public class floors extends Payments {
    private static int nextSpot = 1;
    private static char nextSpotchar = 'a';
    int floorNumber;
    final int totalCapacity = 1000;
    final int electricCapacity = 100;
    final int fossilCapacity = 900;
    public int fossilCurrentCap = 900;
    static int vehicleNum = 0;
    public int electricCurrentCap = 100;
    int vehicleInfo[] = new int[1000];

    // Method to handle payment at the payment portal
    protected void paymentPortal(vehicle obj) {
        obj.setEndTime(123);
        System.out.printf("Your duration of stay was: %d hrs\n",obj.getTimeElapsedMinutes());
        vehicleInfo[vehicleNum] = 0;
        Payment(obj, obj.getTimeElapsedMinutes());
        obj.setPaidStatus(123, true);
        if (obj.electric) {
            electricCurrentCap+=obj.size;
        } else {
            fossilCurrentCap+=obj.size;
        }
    }

    // Inner class representing the entry point for vehicles
    protected class entryPoint {
        void recieveVehicle(vehicle obj, String floor) {
            System.out.println("Welcome to Group 7's Parking Plaza @lowest prices in town!!\n");
            obj.setStartTime(123);
            obj.setToken(123, vehicleNum);
            obj.setPaidStatus(123, false);
            vehicleInfo[vehicleNum] = obj.numberPlate;
            if (obj.electric) {
                System.out.printf("Kindly park your electric %s wheeler between %d and ", obj.size, electricCapacity-electricCurrentCap);
                electricCurrentCap -= obj.size;
                System.out.printf("%dth position!!\n\n\n", electricCapacity - electricCurrentCap);
            } else {
                System.out.printf("Kindly park your %s wheeler between %d and ", obj.size, fossilCapacity-fossilCurrentCap);
                fossilCurrentCap -= obj.size;
                System.out.printf("%dth position!!\n\n\n", fossilCapacity - fossilCurrentCap);
            }
            obj.printstatus();
        }
    }

    entryPoint entry = this.new entryPoint();

    // Inner class representing the exit point for vehicles
    class exitPoint extends Payments {
        void recieveVehicle(vehicle obj) {
            System.out.println("We hope you enjoyed your experience with us!!");
            obj.setEndTime(123);
            System.out.printf("Your duration of stay was: %d hrs \n",obj.getTimeElapsedMinutes());
            vehicleInfo[vehicleNum] = 0;
            Payment(obj, obj.getTimeElapsedMinutes());
            obj.setPaidStatus(123, true);
            if (obj.electric) {
                electricCurrentCap+=obj.size;
            } else {
                fossilCurrentCap+=obj.size;
            }
        }
    }

    exitPoint exit = this.new exitPoint();
    // Method to check floor capacity and provide parking information
    public String Capacityboard(vehicle obj) {
        String info = new String();
        if (fossilCurrentCap - obj.size >= 0 && !obj.electric) {
            if (nextSpotchar > 'z') {
                nextSpot++;
                nextSpotchar = 'a';
            }
            info = String.format("Next vehicle, please move to :  area %d%c please!!\n", nextSpot, nextSpotchar);
        } else if (electricCurrentCap - obj.size >= 0 && obj.electric) {
            info = String.format("Next vehicle, please move to : electric area %d%c  please!!\n", nextSpot, nextSpotchar);
        }
        if (fossilCurrentCap - obj.size < 0 && !obj.electric) {
            info = "Floor Full!! No more Fossil Driven vehicles can be accommodated!!";
            nextSpot = 1;
            nextSpotchar = 'a';
        }
        if (electricCurrentCap - obj.size < 0 && obj.electric) {
            info = "Floor Full!! No more Electric Driven vehicles can be accommodated!!";
            nextSpot = 1;
            nextSpotchar = 'a';
        }
        return info;
    }
}