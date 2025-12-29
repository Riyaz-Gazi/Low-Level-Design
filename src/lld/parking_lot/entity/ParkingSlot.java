package lld.parking_lot.entity;

import lld.parking_lot.entity.enums.VehicleType;

import java.util.UUID;

public class ParkingSlot {
    private UUID id;
    private int floor;
    private VehicleType slotType;
    private boolean isOccupied;

    // constructors
    public ParkingSlot(int floor, VehicleType slotType) {
        this.id = UUID.randomUUID();
        this.floor = floor;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public void setSlotType(VehicleType slotType) {
        this.slotType = slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    // ToString

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                ", floor=" + floor +
                ", slotType=" + slotType +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
