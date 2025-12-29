package problem.ParkingLot.fee;

import problem.ParkingLot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
