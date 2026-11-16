import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
// declaring the UserInterface class
public class UserInterface {
// declaring the private fields of the class
    private DealerShip dealerShip;
    private Scanner scanner = new Scanner(System.in);
    private void init() {

        DealerShipFileManager manager =
                new DealerShipFileManager();

        this.dealerShip = manager.getDealerShip();
    }

    public void display() {

        init();

        if (dealerShip == null) {
            System.out.println("Unable to load dealership.");
            return;
        }

        boolean running = true;

        while (running) {
//   displaying the main interface if the program


            System.out.println("          \n" +
                    "    ==============================================\n" +
                    "              WELCOME TO FANA'S CAR DEALERSHIP\n" +
                    "    ==============================================\n" +
                    "    \n" +
                    "                   ______\n" +
                    "              ____/|_||_\\\\`.__\n" +
                    "             (   _        _ _\\\\\n" +
                    "             =`-(_)--(_)-'\n" +
                    "    \n" +
                    "             FIND YOUR DREAM CAR TODAY!\n" +
                    "    \n" +
                    "    ==============================================\n" +
                    "                  MAIN MENU\n" +
                    "    ============================================== " );

            System.out.println("💰1 - Find vehicles by price");
            System.out.println("🚘2 - Find vehicles by make/model");
            System.out.println("🗓️3 - Find vehicles by year");
            System.out.println("🎨4 - Find vehicles by color");
            System.out.println("🛣️5 - Find vehicles by mileage");
            System.out.println("🛻6 - Find vehicles by type");
            System.out.println("📋7 - List all vehicles");
            System.out.println("➕8 - Add a vehicle");
            System.out.println("🗑️9 - Remove a vehicle");
            System.out.println("👋10 - Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
// this makes the user enter their choice
            switch (choice) {
                case "1":
                   processGetByPriceRequest();
                    break;

                case "2":
                   processGetByMakeModel();
                    break;

                case "3":
                   processBYGetByYearRangeRequest();
                    break;

                case "4":
                    processGetByColorRequest();
                    break;

                case "5":
                  processGetByMileageProcess();
                    break;

                case "6":
                   processGetByTypeRequest();
                    break;

                case "7":
                  processGetAllVehicleRequest();
                    break;

                case "8":
                    processAddVehicleRequest();
                    break;

                case "9":
                   processRemoveVehicleRequest();
                    break;

                case "10":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

public void getAllVehicles() {

        List<Vehicle> vehicles =
                dealerShip.getAllVehicles();

        displayVehicles(vehicles);
    }
// method to display the vehicles using the array of list of vehicles
    public void displayVehicles(List<Vehicle> vehicles) {
// if the vehicles are null display no vehicles found
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
// for loop to display all information about vehicle
            System.out.println(
                    vehicle.getVin() + " | " +
                            vehicle.getYear() + " | " +
                            vehicle.getMake() + " | " +
                            vehicle.getModel() + " | " +
                            vehicle.getVehicleType() + " | " +
                            vehicle.getColor() + " | " +
                            vehicle.getOdometer() + " | $" +
                            vehicle.getPrice()
            );
        }
    }
   // this method enables the user to search a vehicle by entering the price
    public void processGetByPriceRequest() {

        System.out.print("Enter minimum price ");
        BigDecimal minPrice = new BigDecimal(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        BigDecimal maxPrice = new BigDecimal(scanner.nextLine());
// this method enables to get the method in dealership class
        List<Vehicle> vehicles =
                dealerShip.getVehiclesByPrice(minPrice, maxPrice);

        displayVehicles(vehicles);

    }
// this is search by entering a make (name of the manufacturer) and model of the car
 public void processGetByMakeModel() {
     System.out.println(" please enter make or the manufacturer of the car");
     String make=scanner.nextLine().trim();
     scanner.nextLine();
     System.out.println(" please enter the model of the car");
     String model= scanner.nextLine().trim();
      List<Vehicle>  vehicles=dealerShip.getVehiclesByMakeModel(make,model);
       displayVehicles(vehicles);
    }
// this is another option of searching  a vehicle by the  range of year (the vehicle manufactured)
    public void processBYGetByYearRangeRequest() {
        System.out.println(" please enter the minimum year ");
        int minYear=Integer.parseInt(scanner.nextLine());
        int maxYear=Integer.parseInt(scanner.nextLine());
List<Vehicle> vehicles=dealerShip.getVehiclesByYear(minYear,maxYear);
displayVehicles(vehicles);
    }
// search by entering the color of te car
    public void processGetByColorRequest() {
        System.out.println(" please enter the color");
        String color=scanner.nextLine().trim();
        List<Vehicle> vehicles=dealerShip.getVehicleByColor(color);
        displayVehicles(vehicles);
    }
    // search of vehicle by using a mileage by entering  the minimum mile, and maximum mile
    public void processGetByMileageProcess() {
        System.out.println(" please enter the  minimum mileage ");
        int minMileage=Integer.parseInt(scanner.nextLine().trim());
        System.out.println("please enter the maximum mileage ");
        int maxMileage=Integer.parseInt(scanner.nextLine().trim());
        List<Vehicle> vehicles=dealerShip.getVehiclesByMileage(minMileage,maxMileage);
displayVehicles(vehicles);
    }
    // search by type enables the user to search vehicle by entering the type (truck,car)
    public void processGetByTypeRequest() {
        System.out.println("please enter the type of car you are looking for");
        String type=scanner.nextLine().trim();
        List<Vehicle> vehicles=dealerShip.getVehiclesByType(type);
        displayVehicles(vehicles);
    }
    // option to display all the vehicles
public void processGetAllVehicleRequest(){
        List<Vehicle> vehicles=dealerShip.getAllVehicles();
        displayVehicles(vehicles);

    }
    // to add a vehicle by entering all the information about car
    public void processAddVehicleRequest() {
        System.out.println("please enter the Vin");
        int vin=scanner.nextInt();
        System.out.println("please enter the Year");
        int year=scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter the Make or the name of the manufacturer");
        String make=scanner.nextLine().trim();
        System.out.println(" please enter the Model ");
String model=scanner.nextLine().trim();
        System.out.println(" please enter the Vehicle Type ");
        String type=scanner.nextLine().trim();
        System.out.println(" please enter the Color ");
        String color=scanner.nextLine().trim();
        System.out.println(" please enter the Mileage");
        scanner.nextLine().trim();
        int odometer=scanner.nextInt();
        System.out.println(" please enter the price");
        BigDecimal price=new BigDecimal(scanner.nextLine());
        Vehicle vehicle = new Vehicle(
                vin, year, make, model,
                type, color, odometer, price
        );
        dealerShip.addVehicle(vehicle);

        DealerShipFileManager manager =
                new DealerShipFileManager();

        manager.saveDealerShip(dealerShip);

        System.out.println("Vehicle added successfully!");


    }

    public void processRemoveVehicleRequest() {
        System.out.println(" please enter the vin to remove a vehicle");
        int vin=Integer.parseInt(scanner.nextLine());
        Vehicle vehicleToRemove=null;
        for (Vehicle vehicle:dealerShip .getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }
            if (vehicleToRemove != null) {

                dealerShip.removeVehicle(vehicleToRemove);

                DealerShipFileManager manager =
                        new DealerShipFileManager();

                manager.saveDealerShip(dealerShip);

                System.out.println("Vehicle removed successfully!");

            } else {

                System.out.println("Vehicle not found.");
            }

        }




    }


