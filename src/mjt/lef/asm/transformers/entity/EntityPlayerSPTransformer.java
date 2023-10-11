package mjt.lef.asm.transformers.entity;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import mjt.lef.client.Agent;
import mjt.lef.client.listener.bus.EventBus;
import mjt.lef.client.listener.events.player.EventUpdate;
import mjt.lef.asm.api.annotation.Inject;
import mjt.lef.asm.wrapper.Wrapper;

import static org.objectweb.asm.Opcodes.*;

public class EntityPlayerSPTransformer extends Wrapper {
    public EntityPlayerSPTransformer() {
        super("net/minecraft/client/entity/EntityPlayerSP");
    }

    // func_70071_h_,onUpdate,2,Called to update the entity's position/logic.
    @Inject(method = "func_70071_h_")
    public void onUpdate(MethodNode methodNode) {
        InsnList list = new InsnList();

        list.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(Agent.class), "getBus", "()Lmjt/lef/client/listener/bus/EventBus;", false));
        list.add(new TypeInsnNode(NEW, Type.getInternalName(EventUpdate.class)));
        list.add(new InsnNode(DUP));
        list.add(new MethodInsnNode(INVOKESPECIAL, Type.getInternalName(EventUpdate.class), "<init>", "()V", false));
        list.add(new MethodInsnNode(INVOKEVIRTUAL, Type.getInternalName(EventBus.class), "dispatch", "(Ljava/lang/Object;)Z", false));
        list.add(new InsnNode(POP));

        methodNode.instructions.insert(list);
    }
}
