package mjt.lef.client.module.combat;

import mjt.lef.client.listener.bus.Listener;
import mjt.lef.client.listener.events.player.EventUpdate;
import mjt.lef.client.module.Category;
import mjt.lef.client.module.Module;

public class NoClickDelay extends Module {
    public NoClickDelay() {
        super("No Click Delay", "Stops left click delay", Category.COMBAT);
        setState(true);
    }

    @Listener
    public void onUpdate(EventUpdate event) {
        mc.setLeftClickCounter(0);
    }
}
