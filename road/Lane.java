package road; /**
 * Created by eepperly16 on 10/24/15.
 */
import vehicle.Vehicle;
import java.util.LinkedList;
import java.util.Iterator;
public class Lane {
    private LinkedList<Vehicle> vehicles;
    private Lane nextLane;
    private double endOfLane;
    private Lane rightLane;
    private Lane leftLane;
    private double speedLimit;

    public Lane(Lane rightLane, Lane leftLane, Lane nextLane, double speedLimit, double endOfLane) {
        this.rightLane = rightLane;
        this.leftLane = leftLane;
        this.nextLane = nextLane;
        this.speedLimit = speedLimit;
        this.endOfLane = endOfLane;
        vehicles = new LinkedList<>();
    }

    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    public void setNextLane(Lane nextLane) {
        this.nextLane = nextLane;
    }
    public double getSpeedLimit() {
        return speedLimit;
    }

    public void advance(){
        for (int i=0;i<vehicles.size()-1;i++){
            vehicles.get(i).advance(vehicles.get(i+1));
        }
        if (nextLane!=null) {
            if (vehicles.size()>0) {
                vehicles.getLast().advance(nextLane.getFirstVehicle());
            }
        }
        else{
            if (vehicles.size()>0) {
                vehicles.getLast().advance(null);
            }
        }
    }

    public double getEndOfLane() {
        return endOfLane;
    }

    public LinkedList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void advanceCarsToNextLane(){
        if (vehicles.size()!=0 && vehicles.getLast().getX()>endOfLane){
            vehicles.getLast().setLane(nextLane);
            nextLane.addFirstVehicle(vehicles.getLast());
            vehicles.removeLast();
            advanceCarsToNextLane();
        }
    }
    public String toString(){
        String str = "";
        Iterator<Vehicle> itr = vehicles.iterator();
        while (itr.hasNext()){
            str += itr.next()+"\n";
        }
        return str+"\n\n";
    }

    public Vehicle getFirstVehicle(){
        if (vehicles.size()>0) {
            return vehicles.getFirst();
        }
        else{
            return null;
        }
    }
    public void addFirstVehicle(Vehicle vehicle){
        vehicles.addFirst(vehicle);
    }
    public double getReallyEndOfLane(){
        if (nextLane==null){
            return endOfLane;
        }
        else{
            return nextLane.getReallyEndOfLane();
        }
    }

    public Lane getRightLane() {
        return rightLane;
    }

    public Lane getLeftLane() {
        return leftLane;
    }

    public Lane getNextLane() {
        return nextLane;
    }
}
