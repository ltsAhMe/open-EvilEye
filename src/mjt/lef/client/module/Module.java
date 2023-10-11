package mjt.lef.client.module;

import mjt.lef.client.Agent;
import mjt.lef.client.bind.Bind;
import mjt.lef.client.bind.BindDevice;
import mjt.lef.client.util.trait.Nameable;
import mjt.lef.client.util.trait.Toggleable;
import mjt.lef.asm.wrapper.impl.MinecraftWrapper;

public class Module implements Nameable, Toggleable {
    protected static final MinecraftWrapper mc = MinecraftWrapper.get();

    private final String name, description;
    private final Category category;

    private final Bind bind;

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;

        bind = new Bind(name, (x) -> {
            if (x.isToggled()) {
                onEnable();
            } else {
                onDisable();
            }
        }, BindDevice.KEYBOARD, -1);
        Agent.getInstance().getBinds().addBind(bind);
    }

    @Override
    public void onEnable() {
        Agent.getBus().subscribe(this);
    }

    @Override
    public void onDisable() {
        Agent.getBus().unsubscribe(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Bind getBind() {
        return bind;
    }

    @Override
    public boolean isToggled() {
        return bind.isToggled();
    }

    @Override
    public void setState(boolean state) {
        bind.setState(state);
    }
}
