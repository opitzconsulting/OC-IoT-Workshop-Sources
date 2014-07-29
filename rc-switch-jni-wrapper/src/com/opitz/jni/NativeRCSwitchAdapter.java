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
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // TODO load the native libraries here. set workingNativeCode to true if successful
        } catch (UnsatisfiedLinkError e) {
            System.out.println("## " + e.getMessage() + " ##");
        }

    }

    //TODO add the method stubs for the native interfaces

}
