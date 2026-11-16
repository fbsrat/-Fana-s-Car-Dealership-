import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DealerShip {
  private String name;
  private String address;
  private String Phone;
  private ArrayList<Vehicle> inventory;
public DealerShip(String name,String address,String phone){
    this.name=name;
    this.address=address;
    this.Phone=phone;
    this.inventory=new ArrayList<>();
}
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return Phone;
    }
    public List<Vehicle> getVehiclesByPrice(BigDecimal minPrice, BigDecimal  maxPrice){
        List<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getPrice().compareTo(minPrice) >= 0 &&
                    vehicle.getPrice().compareTo(maxPrice) <= 0) {

                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;

    }
    public List<Vehicle> getVehiclesByMakeModel( String make, String model){
 List<Vehicle> matchingVehicles=new ArrayList<>();
for (Vehicle vehicle: inventory){

  if( vehicle. getMake().equalsIgnoreCase(make) &&
          vehicle.getModel().equalsIgnoreCase(model) ) {
      matchingVehicles.add(vehicle);
  }
}
return matchingVehicles;
    }
    public List<Vehicle> getVehiclesByYear( int minYear, int maxYear){
    List<Vehicle> matchingVehicles=new ArrayList<>();
    for(Vehicle vehicle: inventory){

     if(vehicle.getYear() >=minYear && vehicle.getYear()<=maxYear){
        matchingVehicles.add(vehicle);
     }

    }
return matchingVehicles;
    }
public List<Vehicle>getVehicleByColor(String color){
    List<Vehicle> matchingVehicle=new ArrayList<>();
    for (Vehicle vehicle : inventory){
        if(vehicle.getColor().equalsIgnoreCase(color)){
            matchingVehicle.add(vehicle);
        }
    }
    return matchingVehicle;
}
    public List<Vehicle> getVehiclesByMileage( int minMileage, int maxMileage){
    List<Vehicle> matchingVehicles=new ArrayList<>();
    for( Vehicle vehicle:inventory){
        if(vehicle.getOdometer()>=minMileage &&vehicle.getOdometer()<=maxMileage){
            matchingVehicles.add(vehicle);
        }
    }
    return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByType(String type){
    List<Vehicle> matchingVehicles=new ArrayList<>();
    for (Vehicle vehicle : inventory){
        if(vehicle.getVehicleType().equalsIgnoreCase(type)){
            matchingVehicles.add(vehicle);
        }
    }

return matchingVehicles;
    }
    public List<Vehicle> getAllVehicles(){
    return inventory;

    }
    public  void addVehicle(Vehicle vehicle){
    inventory.add(vehicle);

    }


    public void removeVehicle(Vehicle vehicle){
inventory.remove(vehicle);
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}















