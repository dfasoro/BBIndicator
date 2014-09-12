/*
 * Copyright comment here
 */
package com.macgrenor.hidenotif;

import com.codename1.system.NativeLookup;

/**
 * This is a demo class to help you get started building a library
 *
 * @author Oladipo Fasoro
 */
public class Indicator {
    private static NativeIndicator peer;
    private static boolean tested = false;
    
    public static void setCount(int count) {
        if (!tested) {
            tested = true;
            peer = (NativeIndicator)NativeLookup.create(NativeIndicator.class);
            if (peer != null && !peer.isSupported()) peer = null;
        }
        if (peer == null) return;
        peer.setCount(count);
    }
    
    public static int getCount() {
        if (!tested) {
            tested = true;
            peer = (NativeIndicator)NativeLookup.create(NativeIndicator.class);
        }
        if (peer == null) return 0;
        return peer.getCount();
    }
}
