package edu.concordia.dpis;

import java.net.DatagramPacket;

import edu.concordia.dpis.fifo.RequestResolver;

public interface RequestHandler extends RequestResolver {

	Object doOperation(DatagramPacket request);

}
