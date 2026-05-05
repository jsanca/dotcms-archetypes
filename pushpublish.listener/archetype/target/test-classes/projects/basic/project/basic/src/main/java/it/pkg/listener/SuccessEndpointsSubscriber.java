package it.pkg.listener;


import it.pkg.util.EventUtil;
import archetype.it.system.event.local.model.EventSubscriber;
import archetype.it.system.event.local.type.pushpublish.AllPushPublishEndpointsSuccessEvent;

public class SuccessEndpointsSubscriber implements EventSubscriber<AllPushPublishEndpointsSuccessEvent> {

    public void notify(AllPushPublishEndpointsSuccessEvent event) {
        EventUtil.logAllEndpointsSuccessEvent(event, this.getClass());
    }

} //SuccessEndpointsSubscriber.