package it.pkg.listener;


import it.pkg.util.EventUtil;
import archetype.it.system.event.local.model.Subscriber;
import archetype.it.system.event.local.type.pushpublish.PushPublishStartEvent;

public class PushPublishStartSubscriber {

    @Subscriber
    public void notify(PushPublishStartEvent event) {
        EventUtil.logBasicEvent(event, this.getClass());
    }

} //PushPublishStartSubscriber.
