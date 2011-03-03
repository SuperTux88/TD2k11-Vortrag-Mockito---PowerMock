package de.tondorf.mockingvortrag.constructor;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
	private Socket socket;

	public void connect() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 1337);
	}

	public void disconnect() throws IOException {
		socket.close();
	}

	// ...
}
