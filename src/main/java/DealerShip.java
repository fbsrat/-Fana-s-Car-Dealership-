import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DealerShip {
  private String name;
  private String address;
  private String Phone;
  private ArrayList<Vehicle> inventory;
public DealerShip(String name,String adress,String phone){
    this.name=name;
    this.address=adress;
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
    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal  max){
    return null;

    }
    public List<Vehicle> getVehiclesByMakeModel( String make, String model){
    return null;

    }
    public List<Vehicle> getVehiclesByYear( int year){
return null;
    }

    public List<Vehicle> getVehiclesByMileage( int minMileage, int maxMileage){
    return null;
    }

    public List<Vehicle> getVehiclesByType(String type){
return null;
    }
    public List<Vehicle> getAllVehicles(){
    return inventory;

    }
    public  void addVehicle(Vehicle vehicle){
    inventory.add(vehicle);

    }


    public void removeVehicle(){

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















