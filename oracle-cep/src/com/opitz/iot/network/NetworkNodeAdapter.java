package com.opitz.iot.network;


import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import java.util.HashMap;
 

/**
 * User: Pascal
 * Date: 09.04.14
 * Time: 13:22
 * 
 * This Bean is responsible for performing the network discovery in our EPN. It is started on launch and then performs periodic polling of our network. 
 */
public class NetworkNodeAdapter implements RunnableBean, StreamSource {

        private static final int SLEEP_MILLIS = 10000;
        private boolean suspended;
        private StreamSender eventSender;
        private DiscoveryService discoveryService = new DiscoveryService(150);

        public NetworkNodeAdapter() {
            super();
            
        }

    public void run() {
    	System.out.println("networknodeadapter started");
        suspended = false;
        while (!isSuspended()) { // Generate messages forever...

            discoveryService.pingAllAddressesInRange(); // maybe later with parameter for different pingTimeout
            HashMap<String, NetworkNode> nodes = discoveryService.getAllDevicesFromArpCache();
            System.out.println("### We found " + nodes.values().size() +" nodes ###");
            for(NetworkNode node : nodes.values()){
                generateDeviceMessage(node);
            }

            try {
                synchronized (this) {
                    wait(SLEEP_MILLIS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateDeviceMessage(NetworkNode node) {
        eventSender.sendInsertEvent(node);

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.bea.wlevs.ede.api.StreamSource#setEventSender(com.bea.wlevs.ede.api
     * .StreamSender)
     */
    public void setEventSender(StreamSender sender) {
        eventSender = sender;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.bea.wlevs.ede.api.SuspendableBean#suspend()
     */
    public synchronized void suspend() {
        suspended = true;
    }

    private synchronized boolean isSuspended() {
        return suspended;
    }
}
