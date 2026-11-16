
import java.io.*;
import java.math.BigDecimal;

public class DealerShipFileManager {

    public DealerShip getDealerShip() {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("inventory.csv"))) {

            // Read the dealership information
            String line = reader.readLine();

            if (line == null) {
                System.out.println("The file is empty.");
                return null;
            }

            String[] dealershipInfo = line.split("\\|");
// creating dealership objects
            DealerShip dealerShip = new DealerShip(
                    dealershipInfo[0],
                    dealershipInfo[1],
                    dealershipInfo[2]
            );

            // Read all vehicles using a while loop
            while ((line = reader.readLine()) != null) {

                String[] vehicleInfo = line.split("\\|");

                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(vehicleInfo[0]),
                        Integer.parseInt(vehicleInfo[1]),
                        vehicleInfo[2],
                        vehicleInfo[3],
                        vehicleInfo[4],
                        vehicleInfo[5],
                        Integer.parseInt(vehicleInfo[6]),
                        new BigDecimal(vehicleInfo[7])
                );

                dealerShip.addVehicle(vehicle);
            }

            return dealerShip;

        } catch (IOException e) {
            System.out.println("Error reading file: "
                    + e.getMessage());
            return null;

        } catch (NumberFormatException |
                 ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid inventory data: "
                    + e.getMessage());
            return null;
        }
    }

    public void saveDealerShip(DealerShip dealerShip) {
        try {
            // writing and savinga vehicle
            BufferedWriter writer = new BufferedWriter(new FileWriter("" +
                    "inventory.csv"));
            writer.write(
                    dealerShip.getName() + "|" +
                            dealerShip.getAddress() + "|" +
                            dealerShip.getPhone()
            );
            writer.newLine();
            for (Vehicle vehicle : dealerShip.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice() + "|"
                );
                writer.newLine();

            }
        } catch (IOException e) {
            System.out.println(" error while saving the file " + e.getMessage());
        }
    }
}





















