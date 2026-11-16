
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

    public void display() {

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
                    GetByPrice();
                    break;

                case "2":
                    GetByMakeModel();
                    break;

                case "3":
                    GetByYear();
                    break;

                case "4":
                    GetByColor();
                    break;

                case "5":
                   GetByMileage();
                    break;

                case "6":
                   GetByType();
                    break;

                case "7":
                  GetAllVehicle();
                    break;

                case "8":
                    AddVehicle();
                    break;

                case "9":
                   RemoveVehicle();
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

public void processGetAllVehiclesRequest() {

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
    public void GetByPrice() {
    }

 public void GetByMakeModel() {
    }

    public void GetByYear() {
    }

    public void GetByColor() {
    }

    public void GetByMileage() {
    }

    public void GetByType() {
    }
public void GetAllVehicle(){

    }

    public void AddVehicle() {
    }

    public void RemoveVehicle() {
    }
}
