package it.pkg.listener;


import it.pkg.util.EventUtil;
import archetype.it.system.event.local.model.EventSubscriber;
import archetype.it.system.event.local.type.publish.AddedToQueueEvent;

public class AddToQueueSubscriber implements EventSubscriber<AddedToQueueEvent> {


    public void notify(AddedToQueueEvent event) {
        EventUtil.logBasicEvent(event, this.getClass());
    }

} //AddToQueueSubscriber.