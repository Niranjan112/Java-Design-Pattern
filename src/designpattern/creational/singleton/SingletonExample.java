package designpattern.creational.singleton;

/**
 * Eager intialization:
 * Here we are creating object at the time instance declaration only. Hence, it is known as Eager intialization.
 * */
class SingletonEagar {
    private static SingletonEagar instance = new SingletonEagar();

    private SingletonEagar(){}

    public static SingletonEagar getInstance() {
        return instance;
    }
}

/**
 * Lazy Initialization:
 * Here the object is getting created when getInstance() is called by the main class.
 * */
class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

/**
 * Thread safe method initialization:
 * Here we declared getInstance method synchronized so that no two thread can access it at same time.
 * Hence, achieving thread safety here.
 * */
class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){}

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if(instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

/**
 * Thread safe block initialization:
 * Here we declared creation of object block part as synchronized so that no two thread can create object at same time.
 * In above class, we made whole method synchronized which is not actually required and we need to protect object creation block.
 * Because there's no need to make whole method synchronized in some cases.
 * Hence, achieving thread safety here.
 * */
class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized(){}

    public static SingletonSynchronized getInstance() {
        if(instance == null) {
            synchronized (SingletonSynchronized.class) {
                if(instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        SingletonSynchronized instance = SingletonSynchronized.getInstance();

        System.out.println(instance);

        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();

        System.out.println(instance1);
    }
}
