#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${groupId}.security.apps.AppSecretSavedEvent;
import ${groupId}.system.event.local.model.EventSubscriber;
import ${groupId}.system.event.local.model.KeyFilterable;
import com.dotmarketing.util.Logger;

public class AppSecretEventSubscriber implements EventSubscriber<AppSecretSavedEvent>  ,  KeyFilterable {

    static final String appKey = AppKeys.APP_KEY;

    @Override
    public Comparable getKey() {
        return appKey;
    }

    @Override
    public void notify(AppSecretSavedEvent event) {
        Logger.info(this.getClass().getName(), "We got a secret event for : " + event.getKey() + " from: " + event.getUserId());
        

        
    }
}
