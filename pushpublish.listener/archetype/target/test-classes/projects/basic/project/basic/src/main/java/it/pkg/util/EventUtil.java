package it.pkg.util;

import archetype.it.publisher.business.PublishQueueElement;
import archetype.it.system.event.local.type.publish.PublishEvent;
import archetype.it.system.event.local.type.pushpublish.AllPushPublishEndpointsSuccessEvent;
import com.dotmarketing.util.Logger;

import java.util.List;

public class EventUtil {

    public static void logBasicEvent(final PublishEvent event, final Class clazz) {
        Logger.info(clazz, "----------------------------");
        Logger.info(clazz, "Notifying event named: " + event.getName());
        Logger.info(clazz, "Event Date: " + event.getDate());

        final List<PublishQueueElement> publishQueueElements = event.getPublishQueueElements();
        for (PublishQueueElement publishQueueElement : publishQueueElements) {
            Logger.info(clazz, "Pushed Element: " + publishQueueElement.toString());
        }

        Logger.info(clazz, "----------------------------");
    } //logBasicEvent.

    public static void logAllEndpointsSuccessEvent(final AllPushPublishEndpointsSuccessEvent event, final Class clazz) {
        Logger.info(clazz, "----------------------------");
        Logger.info(clazz, "Successfully pushed to all endpoints");
        Logger.info(clazz, "Notifying event named: " + event.getName());
        Logger.info(clazz, "Config Id: " + event.getConfig().getId());
        Logger.info(clazz, "Config endpoint: " + event.getConfig().getEndpoint());
        Logger.info(clazz, "Event Date: " + event.getDate());

        final List<PublishQueueElement> publishQueueElements = event.getPublishQueueElements();
        for (PublishQueueElement publishQueueElement : publishQueueElements) {
            Logger.info(clazz, "Pushed Element: " + publishQueueElement.toString());
        }

        Logger.info(clazz, "----------------------------");
    } //logAllEndpointsSuccessEvent.

} //EventUtil.
