package mjt.lef.client.module.visual;

import org.lwjgl.input.Keyboard;
import mjt.lef.client.Agent;
import mjt.lef.client.listener.bus.Listener;
import mjt.lef.client.listener.events.render.EventRender2D;
import mjt.lef.client.module.Category;
import mjt.lef.client.module.Module;
import mjt.lef.client.util.render.ColorUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HUD extends Module {
    public HUD() {
        super("HUD", "Draws a HUD over the vanilla HUD", Category.VISUAL);
        getBind().setKey(Keyboard.KEY_RCONTROL);
    }

    @Listener
    public void onRender2D(EventRender2D event) {
        arraylist: {
            List<Module> modules = Agent.getInstance().getModules().get()
                    .stream()
                    .filter(Module::isToggled)
                    .sorted(Comparator.comparingInt((x) -> -mc.getFontRenderer().getStringWidth(x.getName())))
                    .collect(Collectors.toList());

            if (modules.isEmpty()) break arraylist;

            float y = 2.0f;
            for (int i = 0; i < modules.size(); ++i) {
                Module module = modules.get(i);

                mc.getFontRenderer().drawStringShadow(module.getName(),
                        event.getWidth() - 2.0f - mc.getFontRenderer().getStringWidth(module.getName()), y,
                        ColorUtils.rainbowCycle(i * 200, 3.5));
                y += mc.getFontRenderer().getHeight() + 2.0f;

            }
        }
    }
}
