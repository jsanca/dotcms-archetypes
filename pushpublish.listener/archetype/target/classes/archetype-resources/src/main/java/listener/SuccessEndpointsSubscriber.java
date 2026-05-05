#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.listener;


import ${package}.util.EventUtil;
import ${groupId}.system.event.local.model.EventSubscriber;
import ${groupId}.system.event.local.type.pushpublish.AllPushPublishEndpointsSuccessEvent;

public class SuccessEndpointsSubscriber implements EventSubscriber<AllPushPublishEndpointsSuccessEvent> {

    public void notify(AllPushPublishEndpointsSuccessEvent event) {
        EventUtil.logAllEndpointsSuccessEvent(event, this.getClass());
    }

} //SuccessEndpointsSubscriber.