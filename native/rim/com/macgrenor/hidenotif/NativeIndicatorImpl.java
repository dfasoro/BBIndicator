package com.macgrenor.hidenotif;
import net.rim.blackberry.api.messagelist.ApplicationIcon;
import net.rim.blackberry.api.messagelist.ApplicationIndicator;
import net.rim.blackberry.api.messagelist.ApplicationIndicatorRegistry;
import net.rim.device.api.ui.UiApplication;

public class NativeIndicatorImpl {
    public int getCount() {
        ApplicationIndicatorRegistry indicatorRegistry = ApplicationIndicatorRegistry.getInstance();
        ApplicationIndicator indicator = indicatorRegistry.getApplicationIndicator();
        if( indicator == null ) return 0;

        return indicator.getValue();
    }
    
    public void setCount(final int param) {
        UiApplication.getApplication().invokeLater(new Runnable() {
            public void run() {
                ApplicationIndicatorRegistry indicatorRegistry = ApplicationIndicatorRegistry.getInstance();
                ApplicationIndicator indicator = indicatorRegistry.getApplicationIndicator();
                if( indicator == null ) {
                    ApplicationIcon icon = new ApplicationIcon(net.rim.device.api.system.EncodedImage.getEncodedImageResource("push_small_size_icon.png"));
                    indicator = indicatorRegistry.register( icon, false, true );
                } 

                indicator.setValue( param );
                if( param > 0 ) {
                    indicator.setVisible( true );
                } else {
                    indicator.setVisible( false );
                }
            }
        });
    }

    public boolean isSupported() {
        return true;
    }

}
