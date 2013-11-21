package edu.concordia.dpis.fifo;

import edu.concordia.dpis.commons.Message;

public interface Publisher {
	
	boolean unicast(Message message);
	
	boolean multicast(Message message);
	
}
