#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.listener;


import ${package}.util.EventUtil;
import ${groupId}.system.event.local.model.EventSubscriber;
import ${groupId}.system.event.local.type.publish.AddedToQueueEvent;

public class AddToQueueSubscriber implements EventSubscriber<AddedToQueueEvent> {


    public void notify(AddedToQueueEvent event) {
        EventUtil.logBasicEvent(event, this.getClass());
    }

} //AddToQueueSubscriber.