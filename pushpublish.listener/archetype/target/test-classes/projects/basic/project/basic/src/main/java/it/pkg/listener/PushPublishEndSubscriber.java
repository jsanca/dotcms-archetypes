package it.pkg.listener;


import it.pkg.util.EventUtil;
import archetype.it.system.event.local.model.Subscriber;
import archetype.it.system.event.local.type.pushpublish.PushPublishEndEvent;

public class PushPublishEndSubscriber {

    @Subscriber
    public void notify(PushPublishEndEvent event) {
        EventUtil.logBasicEvent(event, this.getClass());
    }

} //PushPublishEndSubscriber.
