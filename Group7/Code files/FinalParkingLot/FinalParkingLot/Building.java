package FinalParkingLot;

public class Building extends justtoshowpolymorphism{
    floors ground = new floors();
    floors first = new floors();
    floors second = new floors();
    floors third = new floors();

    // Method to find a free floor based on vehicle type (electric or fossil)
    public String freeFloor(String type,vehicle obj) {
        if (type.equals("fossil")) {
            if (ground.fossilCurrentCap-obj.size >= 0) {
                return "ground";
            } else if (first.fossilCurrentCap-obj.size >= 0) {
                return "first";
            } else if (second.fossilCurrentCap-obj.size >= 0) {
                return "second";
            } else if (third.fossilCurrentCap-obj.size >= 0) {
                return "third";
            }
            return "null";
        } else {
            if (ground.electricCurrentCap-obj.size >= 0) {
                return "ground";
            } else if (first.electricCurrentCap-obj.size >= 0) {
                return "first";
            } else if (second.electricCurrentCap-obj.size >= 0) {
                return "second";
            } else if (third.electricCurrentCap-obj.size >= 0) {
                return "third";
            }
            return "null";
        }
    }

    // Method to display the capacity board at The GROUND BASE of the building
    public boolean Capacityboard(vehicle obj) {
        String temp = new String();
        obj.setbuilding(this);
        if (obj.electric == true) {
            temp = freeFloor("electric",obj);
            if(temp.equals("null"))
            {
                System.out.printf("Your vehicle cannot be parked!!\n");
                return false;
            }
            System.out.printf("All electric vehicles, please move to: %s floor please!!\n.....ZOOM.... %s floor reached!!\n", temp, temp);
        }
        if (obj.electric == false) {
            temp = freeFloor("fossil",obj);
            if(temp.equals("null"))
            {
                System.out.printf("Your vehicle cannot be parked!!\n");
                return false;
            }
            System.out.printf("All Fossil-driven vehicles, please move to: %s floor please!!.....ZOOM.... %s floor reached!!\n", temp, temp);
        }
        System.out.printf("Welcome!! Vehicle token number is %d\n", obj.token);
        sendToFloor(obj, temp);
        return true;
    }

    // Method to send the vehicle to a specific floor
    public void sendToFloor(vehicle obj, String floor) {
        if (floor.equals("ground")) {
            obj.setParkingFloor(ground);
            ground.entry.recieveVehicle(obj, floor);
        } else if (floor.equals("first")) {
            obj.setParkingFloor(first);
            first.entry.recieveVehicle(obj, floor);
        } else if (floor.equals("second")) {
            obj.setParkingFloor(second);
            second.entry.recieveVehicle(obj, floor);
        } else if (floor.equals("third")) {
            obj.setParkingFloor(third);
            third.entry.recieveVehicle(obj, floor);
        } else {
            System.out.println("The parking lot is full at capacity!! Sorry for the inconvenience!!");
        }
    }
}
