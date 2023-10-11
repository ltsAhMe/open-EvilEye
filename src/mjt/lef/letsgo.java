package mjt.lef;

import mjt.lef.client.Agent;
import mjt.lef.asm.api.Transformers;
import mapping.Mappings;
import mapping.MinecraftVersion;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

public class letsgo {

    public static void agentmain(String args, Instrumentation is) {
        try {
            // TODO: autodetect somehow? prolly via game args
            Mappings.readMappings(MinecraftVersion.VER_1_8_8);
            System.out.println("Read mappings successfully");
        } catch (Exception e) {
            System.out.println("Read mappings fuck");
            return;
        }

        try {
            Transformers.init(is);
        } catch (IOException e) {
            System.out.println("Failed to init mixins");
            e.printStackTrace();
        }

        // init client
        Agent.init();
    }
}
