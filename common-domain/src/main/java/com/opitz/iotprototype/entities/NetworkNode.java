package com.opitz.iotprototype.entities;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * User: Pascal Date: 06.03.14 Time: 15:17
 */
@Entity
public class NetworkNode implements Serializable {




	/* UNCOMMENT ONCE COMPLETED

	public NetworkNode(String macAddress, String dnsName, String ipAddress) {
		this.macAddress = macAddress;
		this.dnsName = dnsName;
		this.lastKnownIPAddress = ipAddress;
		this.lastSeen = new Date();
	}

	public NetworkNode() {
	}

	@Override
	*//**
	 * equals disregards the last seen timestamp but compares the rest. last seen is only updated every 30 minutes via the cron job.
	 *//*
	public boolean equals(Object o) {
		NetworkNode anotherNode;
		if (o == null) {
			return false;
		} else {
			anotherNode = (NetworkNode) o;
		}

		boolean mac = anotherNode.macAddress == this.macAddress;
		boolean ip = anotherNode.lastKnownIPAddress == this.lastKnownIPAddress;
		boolean dns = anotherNode.dnsName == this.dnsName;

		if (anotherNode.macAddress == this.macAddress
				&& anotherNode.dnsName == this.dnsName
				&& anotherNode.lastKnownIPAddress == this.lastKnownIPAddress) {
			return true;
		} else {
			return false;
		}
	}
*/

}
