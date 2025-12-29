package solid_principle;

class Notification{
    public void sendNotification(){
        System.out.println("Email Send");
    }
}

class TextNotification extends Notification{
    @Override
    public void sendNotification(){
        System.out.println("Text Send");
    }
}

class WappNotification extends Notification{
    @Override
    public void sendNotification(){
        System.out.println("Wapp Send");
    }
}

public class LSP {
    public static void main(String[] args) {
        Notification notification = new TextNotification();
        notification.sendNotification();
    }
}
