package mjt.lef.client;

import mjt.lef.client.bind.BindManager;
import mjt.lef.client.listener.bus.EventBus;
import mjt.lef.client.module.ModuleManager;

public class Agent {

    private static Agent singleton;

    private static final EventBus bus = new EventBus();

    private final BindManager binds;
    private final ModuleManager modules;

    private Agent() {
        singleton = this;

     System.out.println("Loading Agent");
        binds = new BindManager();
        modules = new ModuleManager();

        bus.subscribe(binds);
    }

    public BindManager getBinds() {
        return binds;
    }

    public ModuleManager getModules() {
        return modules;
    }

    public static void init() {
        if (singleton == null) new Agent();
    }

    public static EventBus getBus() {
        return bus;
    }

    public static Agent getInstance() {
        return singleton;
    }
}
