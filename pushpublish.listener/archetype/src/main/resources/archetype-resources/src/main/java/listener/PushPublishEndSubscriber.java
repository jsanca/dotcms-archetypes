#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.listener;


import ${package}.util.EventUtil;
import ${groupId}.system.event.local.model.Subscriber;
import ${groupId}.system.event.local.type.pushpublish.PushPublishEndEvent;

public class PushPublishEndSubscriber {

    @Subscriber
    public void notify(PushPublishEndEvent event) {
        EventUtil.logBasicEvent(event, this.getClass());
    }

} //PushPublishEndSubscriber.
