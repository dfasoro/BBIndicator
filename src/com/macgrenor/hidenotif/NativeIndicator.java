package com.macgrenor.hidenotif;

import com.codename1.system.NativeInterface;

/**
 *
 * @author fabricio
 */
public interface NativeIndicator extends NativeInterface {
    public int getCount();
    public void setCount(int count);
}
