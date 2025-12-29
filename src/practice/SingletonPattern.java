package practice;

class EagerSingleton{
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}

class LazySingleton{
    private static LazySingleton instance;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

class LazySingletonSynchronization{
    private static LazySingletonSynchronization instance;

    private LazySingletonSynchronization(){

    }

    public static  synchronized LazySingletonSynchronization getInstance(){
        if(instance == null){
            instance = new LazySingletonSynchronization();
        }
        return instance;
    }
}

class Singleton{
    private static volatile Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


class SingleTon{

    private SingleTon(){

    }
    private static class Holder{
        private static final SingleTon instance = new SingleTon();
    }

    public static SingleTon getInstance(){
        return Holder.instance;
    }

}


public class SingletonPattern {
    public static void main(String[] args) {
        // Method - 1
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

        // Method - 2
        LazySingleton instance3 = LazySingleton.getInstance();
        LazySingleton instance4 = LazySingleton.getInstance();
        System.out.println(instance3.hashCode() == instance4.hashCode());
    }
}
