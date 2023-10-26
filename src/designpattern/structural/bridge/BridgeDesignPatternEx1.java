package designpattern.structural.bridge;

interface Remote {
    public void on();
    public void off();
}

class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old remote");
    }
}

class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New remote");
    }
}
abstract class TV {
    Remote remote;

    TV(Remote remote) {
        this.remote = remote;
    }

    abstract void on();
    abstract void off();
}

class Sony extends TV {
    Remote remoteType;

    Sony(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

class Philips extends TV {
    Remote remoteType;

    Philips(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();

    }
}

public class BridgeDesignPatternEx1 {
    public static void main(String[] args) {
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
        System.out.println();
    }
}
