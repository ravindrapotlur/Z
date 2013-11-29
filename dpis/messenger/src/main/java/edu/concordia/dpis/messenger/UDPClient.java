package edu.concordia.dpis.messenger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

import edu.concordia.dpis.commons.Message;
import edu.concordia.dpis.commons.UDPMessage;

public class UDPClient implements Imessenger{

	// private static Logger log = Logger.getLogger(UDPClient.class.getName());

	public Message send(Message msg) {
		String response = null;
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			byte[] m = msg.getActualMessage().getBytes();
			InetAddress aHost = InetAddress.getByName(msg.getToAddress()
					.getHost());
			DatagramPacket request = new DatagramPacket(m, m.length, aHost, msg
					.getToAddress().getPort());
			aSocket.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			response = new String(Arrays.copyOfRange(reply.getData(), 0,
					reply.getLength()));

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null) {
				aSocket.close();
			}
		}
		final Message retMessage = new UDPMessage(response, msg.getToAddress()
				.getHost(), msg.getToAddress().getPort());
		return retMessage;
	}
}
