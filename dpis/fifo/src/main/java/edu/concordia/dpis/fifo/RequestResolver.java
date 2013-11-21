package edu.concordia.dpis.fifo;

import java.util.List;

public interface RequestResolver {

	String getOperationName();
	
	List<Object> getArguments();
}
