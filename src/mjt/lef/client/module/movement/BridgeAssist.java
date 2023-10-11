package mjt.lef.client.module.movement;

import mjt.lef.client.listener.bus.Listener;
import mjt.lef.client.listener.events.player.EventUpdate;
import mjt.lef.client.module.Category;
import mjt.lef.client.module.Module;
import mjt.lef.asm.wrapper.impl.HitResultWrapper.Type;

import static org.lwjgl.input.Keyboard.KEY_N;

public class BridgeAssist extends Module {
    private boolean sneakOverride;

    public BridgeAssist() {
        super("Bridge Assist", "Assists you at bridging", Category.MOVEMENT);

        getBind().setKey(KEY_N);
    }

    @Override
    public void onDisable() {
        super.onDisable();

        if (sneakOverride) {
            mc.getGameSettings().getKey("key.sneak").setPressed(false);
        }

        sneakOverride = false;
    }

    @Listener
    public void onUpdate(EventUpdate event) {
        if (mc.getHitResult().getType() == Type.BLOCK) {
            sneakOverride = mc.getWorld().isAir(mc.getPlayer().getPos().add(0, -1, 0));
            mc.getGameSettings().getKey("key.sneak").setPressed(sneakOverride);

            mc.rightClickMouse();
        } else {
            if (sneakOverride) {
                sneakOverride = false;
                mc.getGameSettings().getKey("key.sneak").setPressed(false);
            }
        }
    }
}
