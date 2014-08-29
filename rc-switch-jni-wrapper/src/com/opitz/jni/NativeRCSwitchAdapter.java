package com.opitz.jni;

import java.lang.reflect.Field;

/**
 * OPITZ CONSULTING Deutschland GmbH
 *
 * @author Brokmeier, Pascal
 * @version 29.07.14
 */
public class NativeRCSwitchAdapter {

    private static final NativeRCSwitchAdapter instance = new NativeRCSwitchAdapter();
    private static boolean workingNativeCode = false;

    public static NativeRCSwitchAdapter getInstance() {
        return instance;
    }

    public static boolean isWorking() {
        return workingNativeCode;
    }

    //so no one gets the idea of creating an instance on their own. only one instance intended
    private NativeRCSwitchAdapter() {
    }

    static {
        try {
            System.setProperty("java.library.path", "/usr/local/lib");
            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Loading Native Libraries:: Path: " + System.getProperty("java.library.path"));
            //loading a library, there are two ways. but it only gets loaded once so doesnt matter if done twice here
            System.loadLibrary("RCSwitchAdapter");
            System.load("/usr/local/lib/libRCSwitchAdapter.so");
            System.out.println("Loading Native Libraries:: loading librarys worked");
            workingNativeCode = true;
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }

    }

    public native void switchOn(String group, String unit);

    public native void switchOff(String group, String unit);
}
