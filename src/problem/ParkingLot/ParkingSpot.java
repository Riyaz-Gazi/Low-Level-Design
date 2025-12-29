package problem.ParkingLot;

import problem.ParkingLot.vehicleType.Vehicle;
import problem.ParkingLot.vehicleType.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public synchronized boolean park(Vehicle vehicle) {
        if (isOccupied || vehicle.getVehicleType() != vehicleType) {
            return false;
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
        return true;
    }
    public synchronized void unpark(){
        vehicle = null;
        this.isOccupied = false;
    }
}
