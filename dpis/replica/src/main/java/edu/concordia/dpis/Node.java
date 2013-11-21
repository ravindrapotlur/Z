package edu.concordia.dpis;

import edu.concordia.dpis.commons.Address;

public interface Node {

	Address getAddress();

	String getLeaderName();

	void newLeader(String name);

	MessageType election(String name);

}
