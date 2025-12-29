package solid_principle;

interface RiderInterface {
    void bookRide();

    void payment();
}

interface DriverInterface {
    void acceptRide();

    void drive();

    void endRide();
}

class Rider implements RiderInterface {
    @Override
    public void bookRide() {

    }

    @Override
    public void payment() {

    }
}

class Driver implements DriverInterface {
    @Override
    public void acceptRide() {

    }

    @Override
    public void drive() {

    }

    @Override
    public void endRide() {

    }
}

public class ISP {
    public static void main(String[] args) {

    }
}
