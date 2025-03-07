/**
 * Copyright (c) 2003-2017 The Apereo Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://opensource.org/licenses/ecl2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sakaiproject.messaging.api;

import java.util.List;

public interface MessagingService {

    public void listen(String topic, MessageListener listener);
    public void send(String topic, BullhornAlert ba);

    /**
     * @param userId The user to retrieve alerts for
     * @return the list of current alerts for the specified user
     */
    public List<BullhornAlert> getAlerts(String userId);

    /**
     * Register a handler for broadcast messages. The most recently registered handler that
     * handles a given event will receive it exclusively.
     *
     * @param handler a broadcast message handler; may handle multiple events
     */
    void registerHandler(BullhornHandler handler);

    /**
     * Unregister a handler for broadcast messages from all of the events it handles. If a given event is
     * handled by a different handler, it will not be unregistered.
     *
     * @param handler the broadcast message handler to unregister from events
     */
    void unregisterHandler(BullhornHandler handler);

    /**
     * @param userId The user to clear the alert for
     * @param alertId The alert to clear
     * @return boolean to indicate success
     */
    public boolean clearAlert(String userId, long alertId);

    /**
     * @param userId The user to clear the alerts for
     * @return boolean to indicate success
     */
    public boolean clearAllAlerts(String userId);

}
