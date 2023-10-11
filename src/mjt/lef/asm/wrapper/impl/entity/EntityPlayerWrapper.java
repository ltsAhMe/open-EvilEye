package mjt.lef.asm.wrapper.impl.entity;

import mjt.lef.asm.api.ReflectionUtils;
import mjt.lef.asm.wrapper.Wrapper;
import mapping.Mappings;

public class EntityPlayerWrapper extends Wrapper {
    private final Object entityPlayerObj;

    public EntityPlayerWrapper(Object entityPlayerObj) {
        super("net/minecraft/entity/player/EntityPlayer");
        this.entityPlayerObj = entityPlayerObj;
    }

    public double getX() {
        // FD: pk/s net/minecraft/entity/Entity/field_70165_t

        String notch = Mappings.seargeToNotchField("field_70165_t");
        Object value = ReflectionUtils.getFieldValue(getClazz(), entityPlayerObj, notch);
        return value == null ? 0.0 : (Double) value;
    }

    public double getY() {
        // FD: pk/s net/minecraft/entity/Entity/field_70165_t

        String notch = Mappings.seargeToNotchField("field_70163_u");
        Object value = ReflectionUtils.getFieldValue(getClazz(), entityPlayerObj, notch);
        return value == null ? 0.0 : (Double) value;
    }

    public double getZ() {
        // FD: pk/s net/minecraft/entity/Entity/field_70165_t

        String notch = Mappings.seargeToNotchField("field_70161_v");
        Object value = ReflectionUtils.getFieldValue(getClazz(), entityPlayerObj, notch);
        return value == null ? 0.0 : (Double) value;
    }
}
