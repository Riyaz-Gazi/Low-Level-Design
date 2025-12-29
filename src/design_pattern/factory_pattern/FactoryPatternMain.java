package design_pattern.factory_pattern;

interface Logistics {
    void send();
}

class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by road logic");
    }
}

class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by air logic");
    }
}

class Train implements Logistics {

    @Override
    public void send() {
        System.out.println("Sending by train logic");
    }
}

class LogisticsFactory{
    public static Logistics getLogistics(String mode){
        if(mode.equals("road")){
            return new Road();
        }
        return new Air();
    }
}

class LogisticService {
    public void send(String mode) {
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

public class FactoryPatternMain {
    public static void main(String[] args) {
        LogisticService logisticService = new LogisticService();
        logisticService.send("air");
    }
}
