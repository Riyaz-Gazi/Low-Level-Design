package design_pattern.singleton_pattern;

// Thread Safe Eager Loading
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

// Lazy Loading Not Thread Safe
class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

// Lazy Loading Thread Safe

class LazySingletonSynchronization {
    private static LazySingletonSynchronization instance;

    private LazySingletonSynchronization() {

    }

    public static synchronized LazySingletonSynchronization getInstance() {
        if (instance == null) {
            instance = new LazySingletonSynchronization();
        }
        return instance;
    }
}

// Double check locking
class Singleton {
    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

// Bill Pugh Singleton

class BillPughSingleton {
    private static BillPughSingleton instance;

    private BillPughSingleton() {

    }

    private static class Holder {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Holder.instance;
    }

}


public class SingletonPatternMain {
    public static void main(String[] args) {
        // Method - 1
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

