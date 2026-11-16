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
                    getByPrice();
                    break;

                case "2":
                    getByMakeModel();
                    break;

                case "3":
                    getByYear();
                    break;

                case "4":
                    getByColor();
                    break;

                case "5":
                   getByMileage();
                    break;

                case "6":
                   getByType();
                    break;

                case "7":
                  getAllVehicle();
                    break;

                case "8":
                    addVehicle();
                    break;

                case "9":
                   removeVehicle();
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
    public void getByPrice() {

        System.out.print("Enter minimum price ");
        BigDecimal minPrice = new BigDecimal(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        BigDecimal maxPrice = new BigDecimal(scanner.nextLine());

        List<Vehicle> vehicles =
                dealerShip.getVehiclesByPrice(minPrice, maxPrice);

        displayVehicles(vehicles);

    }

 public void getByMakeModel() {
     System.out.println(" please enter make or the manufacturer of the car");
     String make=scanner.nextLine();
     scanner.nextLine();
     System.out.println(" please enter the model of the car");
     String model= scanner.nextLine();
      List<Vehicle>  vehicles=dealerShip.getVehiclesByMakeModel(make,model);
       displayVehicles(vehicles);
    }

    public void getByYear() {
        System.out.println(" please enter the minimum year ");
        int minYear=Integer.parseInt(scanner.nextLine());
        int maxYear=Integer.parseInt(scanner.nextLine());
List<Vehicle> vehicles=dealerShip.getVehiclesByYear(minYear,maxYear);
displayVehicles(vehicles);
    }

    public void getByColor() {
        System.out.println(" please enter the color");
        String color=scanner.nextLine();
        List<Vehicle> vehicles=dealerShip.getVehicleByColor(color);
    }

    public void getByMileage() {
    }

    public void getByType() {
    }
public void getAllVehicle(){

    }

    public void addVehicle() {
    }

    public void removeVehicle() {
    }
}
