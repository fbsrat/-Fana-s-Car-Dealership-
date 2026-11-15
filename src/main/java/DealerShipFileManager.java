
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class DealerShipFileManager {

    public DealerShip getDealerShip() {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("C:\\pluralsight\\workbook4\\Car Dealershp\\inventory.csv"))) {

            // Read the dealership information
            String line = reader.readLine();

            if (line == null) {
                System.out.println("The file is empty.");
                return null;
            }

            String[] dealershipInfo = line.split("\\|");

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
        // Leave empty for Phase 2
    }
}