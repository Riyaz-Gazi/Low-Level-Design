package problem.ParkingLot;
import problem.ParkingLot.fee.FeeStrategy;
import problem.ParkingLot.fee.FlatRateFeeStrategy;
import problem.ParkingLot.vehicleType.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors;
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        floors = new ArrayList<>();
        feeStrategy = new FlatRateFeeStrategy();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy (FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle.getVehicleType());
            if (spotOpt.isPresent()) {
                ParkingSpot spot = spotOpt.get();
                if (spot.park(vehicle)) {
                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(ticketId, vehicle, spot,new Date().getTime());
                    activeTickets.put(ticketId, ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No available spot for " + vehicle.getVehicleType());
    }

    public synchronized double unparkVehicle(String ticketId) throws Exception {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new Exception("Invalid ticket");

        ParkingSpot spot = ticket.getParkingSpot();
        spot.unpark();

        ticket.setExitTimestamp(new Date().getTime());
        return feeStrategy.calculateFee(ticket);
    }

    public List<ParkingFloor> getParkingFloors() {
        return floors;
    }
}
