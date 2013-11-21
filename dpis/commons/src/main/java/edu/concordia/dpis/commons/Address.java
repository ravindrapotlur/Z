package edu.concordia.dpis.commons;

public class Address {

	private String id;

	private String host;

	private int port;

	public Address(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
