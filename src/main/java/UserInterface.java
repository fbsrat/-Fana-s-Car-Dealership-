import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private DealerShip dealerShip;
    private Scanner scanner = new Scanner(System.in);
    private void init() {

        DealerShipFileManager manager =
                new DealerShipFileManager();

        this.dealerShip = manager.getDealerShip();
    }

    private void display() {

        init();

        if (dealerShip == null) {
            System.out.println("Unable to load dealership.");
            return;
        }

        boolean running = true;

        while (running) {

            System.out.println("\nCAR DEALERSHIP MENU");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

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

    public void displayVehicles(List<Vehicle> vehicles) {

        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {

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
    // Implement these methods in Phase 5
    public void processGetByPriceRequest() {

        System.out.print("Enter minimum price ");
        BigDecimal minPrice = new BigDecimal(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        BigDecimal maxPrice = new BigDecimal(scanner.nextLine());

        List<Vehicle> vehicles =
                dealerShip.getVehiclesByPrice(minPrice, maxPrice);

        displayVehicles(vehicles);

    }

 public void processGetByMakeModel() {
     System.out.println(" please enter make or the manufacturer of the car");
     String make=scanner.nextLine();
     scanner.nextLine();
     System.out.println(" please enter the model of the car");
     String model= scanner.nextLine();
      List<Vehicle>  vehicles=dealerShip.getVehiclesByMakeModel(make,model);
       displayVehicles(vehicles);
    }

    public void processBYGetByYearRangeRequest() {
        System.out.println(" please enter the minimum year ");
        int minYear=Integer.parseInt(scanner.nextLine());
        int maxYear=Integer.parseInt(scanner.nextLine());
List<Vehicle> vehicles=dealerShip.getVehiclesByYear(minYear,maxYear);
displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.println(" please enter the color");
        String color=scanner.nextLine();
        List<Vehicle> vehicles=dealerShip.getVehicleByColor(color);
    }
    public void processGetByMileageProcess() {
        System.out.println(" please enter the  minimum mileage ");
        int minMileage=Integer.parseInt(scanner.nextLine());
        System.out.println("plese enter the maximum mileage ");
        int maxMileage=Integer.parseInt(scanner.nextLine());
        List<Vehicle> vehicles=dealerShip.getVehiclesByMileage(minMileage,maxMileage);

    }

    public void processGetByTypeRequest() {
        System.out.println("please enter the type of car you are looking for");
        String type=scanner.nextLine();
        List<Vehicle> vehicles=dealerShip.getVehiclesByType(type);
    }
public void processGetAllVehicleRequest(){
        List<Vehicle> vehicles=dealerShip.getAllVehicles();
        displayVehicles(vehicles);

    }

    public void processAddVehicleRequest() {
        System.out.println("please enter the Vin");
        int vin=scanner.nextInt();
        System.out.println("please enter the Year");
        int year=scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter the Make or the name of the manufacturer");
        String make=scanner.nextLine();
        System.out.println(" please enter the Model ");
String model=scanner.nextLine();
        System.out.println(" please enter the Vehicle Type ");
        String type=scanner.nextLine();
        System.out.println(" please enter the Color ");
        String color=scanner.nextLine();
        System.out.println(" please enter the Mileage");
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
    }
}
