package mjt.lef.client.module.combat;

import mjt.lef.client.listener.bus.Listener;
import mjt.lef.client.listener.events.input.EventAttackReach;
import mjt.lef.client.module.Category;
import mjt.lef.client.module.Module;

import static org.lwjgl.input.Keyboard.KEY_R;

public class Reach extends Module {
    public Reach() {
        super("Reach", "Reaches further than normal", Category.COMBAT);
        getBind().setKey(KEY_R);
    }

    @Listener
    public void onAttackReach(EventAttackReach event) {
        // TODO settings
        event.setReach(3.2 + (Math.random() / 100.0));
    }
}
