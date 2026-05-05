#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.listener;


import ${package}.util.EventUtil;
import ${groupId}.system.event.local.model.Subscriber;
import ${groupId}.system.event.local.type.pushpublish.PushPublishStartEvent;

public class PushPublishStartSubscriber {

    @Subscriber
    public void notify(PushPublishStartEvent event) {
        EventUtil.logBasicEvent(event, this.getClass());
    }

} //PushPublishStartSubscriber.
