package lld.parking_lot.entity;

import lld.parking_lot.entity.enums.VehicleType;

import java.util.UUID;

public class Vehicle {
    private UUID id;
    private String licensePlate;
    private VehicleType vehicleType;

    // constructor
    public Vehicle(VehicleType vehicleType, String licensePlate) {
        this.id = UUID.randomUUID();
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    // getters & setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    // ToString
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
