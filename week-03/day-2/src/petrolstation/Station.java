package petrolstation;

public class Station {
    /*
    Station
gasAmount
refill(car) -> decreases the gasAmount by the capacity of the car and increases the cars gasAmount
     */
    int gasAmount;

    Station(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public void refill(Car car) {
        int gasNeeded = car.capacity - car.gasAmount;
        car.gasAmount += gasNeeded;
        gasAmount -= gasNeeded;
    }
}
