package problem.ParkingLot;

import problem.ParkingLot.vehicleType.Vehicle;

import java.util.Date;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTimestamp;
    private long exitTimestamp;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, long entryTimestamp) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTimestamp = new Date().getTime();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }

    public long getExitTimestamp() {
        return exitTimestamp;
    }

    public void setExitTimestamp(long exitTimestamp) {
        this.exitTimestamp = new Date().getTime();
    }
}
