package mjt.lef.client.module.combat;

import org.lwjgl.input.Mouse;
import mjt.lef.client.bind.BindDevice;
import mjt.lef.client.listener.bus.Listener;
import mjt.lef.client.listener.events.input.EventMouseInput;
import mjt.lef.client.listener.events.player.EventUpdate;
import mjt.lef.client.module.Category;
import mjt.lef.client.module.Module;
import mjt.lef.client.util.time.Timer;

import static mjt.lef.client.util.math.MathUtils.random;

public class AutoClicker extends Module {
    private final Timer timer = new Timer();
    private final Timer cps = new Timer();

    private int clicks;

    public AutoClicker() {
        super("Auto Clicker", "Automatically clicks for you", Category.COMBAT);
        getBind().setKey(4);
        getBind().setDevice(BindDevice.MOUSE);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        clicks = 0;
    }

    @Listener
    public void onUpdate(EventUpdate event) {
        if (mc.getCurrentScreen() != null) return;

        if (timer.hasPassed(1000L / random(8, 14)) && Mouse.isButtonDown(0) && !Mouse.isButtonDown(1)) {

            if (cps.hasPassed(1000L, true)) {
                clicks = 0;
            }

            if (clicks > 20) return;

            mc.clickMouse();
            timer.resetTime();
        }
    }

    @Listener
    public void onMouseInput(EventMouseInput event) {
        if (event.getButton() == 0) ++clicks;
    }
}
