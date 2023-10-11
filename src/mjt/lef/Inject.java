package mjt.lef;

import com.sun.tools.attach.*;
import gg.evileye.launcher.Main;
import mapping.MinecraftVersion;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Inject {
   private static String pid = "";
        private static final List<String> MINECRAFT_START = new ArrayList<>();

        private static VirtualMachine vm;
        private static boolean attached;

        static {
            MINECRAFT_START.add("net.minecraft.client.main.Main");
            MINECRAFT_START.add("net.minecraft.launchwrapper.Launch");
        }

        public static void getInject(String[]args) throws IOException {

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (vm != null) {
                    try {
                        vm.detach();
                        info("detached successfully");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                attached = false;
                vm = null;
            }, "VM"));

            File agentJarFile;
            if (args.length != 0 && args[0].equals("--dev")) {
                dbug("develop mode");
                agentJarFile = new File("out/artifacts/EvilEye_clone_jar/EvilEye-clone.jar");
            } else {
                agentJarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile());
            }

            try {
                Class.forName("com.sun.tools.attach.VirtualMachine");
                dbug("tools.jar found");
            } catch (Exception ignored) {
                dbug("tools.jar not found, adding dynamically");
                try {

                    // thanks linus
                    Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                    addURL.setAccessible(true);

                    String sep = System.getProperty("file.separator");
                    addURL.invoke(ClassLoader.getSystemClassLoader(),
                            new URL("file:///" + System.getenv("JAVA_HOME") + sep + "lib" + sep + "tools.jar"));

                    dbug("added tools.jar");
                } catch (Exception e) {
                    e.printStackTrace();

                    fail("could not add tools.jar to class loader. exiting now");
                    return;
                }
            }

          Scanner sc = new Scanner(System.in);
            while (!attached) {
                List<VirtualMachineDescriptor> desc = VirtualMachine.list();

                List<String> valid = new ArrayList<>();
                desc.forEach((x) -> {
                    String name = x.displayName();
                    if (name == null || (name = name.trim()).isEmpty()) return;

                    if (name.equals(Main.class.getName())) return;

                    valid.add(x.id());

                    String format = "PID %s%s%s -> %s";
                    for (String c : MINECRAFT_START) {
                        if (x.displayName().startsWith(c)) {
                            pid = x.id();
                        }
                    }

                    info(String.format(format, ConsoleColors.GREEN, x.id(), ConsoleColors.RESET, name.split(" ")[0]));
                });


                System.out.println();
                dbug("selected PID " + pid);

                try {
                    System.out.println( MinecraftVersion.VER_1_8_8.getSrg());
                    System.out.println( MinecraftVersion.VER_1_8_8.getFields());
                    System.out.println( MinecraftVersion.VER_1_8_8.getMethods());
                    vm = VirtualMachine.attach(pid);
                    dbug(agentJarFile.getAbsolutePath());
                    vm.loadAgent(agentJarFile.getAbsolutePath());
                    attached = true;
                    info("attach to " + pid);


                } catch (Exception e) {
                    fail("failed to attach");
                    e.printStackTrace();
                    return;
                }

            }

            if (attached) {
                info("Type anything to exit");
                               sc.nextLine();
            }
        }

        public static void dbug (String s){
            System.out.printf("%sdbug%s: %s\n", ConsoleColors.YELLOW, ConsoleColors.RESET, s);
        }

        public static void info (String s){
            System.out.printf("%sinfo%s: %s\n", ConsoleColors.CYAN, ConsoleColors.RESET, s);
        }

        public static void fail (String s){
            System.out.printf("%sfail%s: %s\n", ConsoleColors.RED, ConsoleColors.RESET, s);
        }

        public static void agent (String s){
            System.out.printf("%sagent%s: %s\n", ConsoleColors.PURPLE, ConsoleColors.RESET, s);
        }

        public static boolean isOn () {return attached && vm != null;}

    }

