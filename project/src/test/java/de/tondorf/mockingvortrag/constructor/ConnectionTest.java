package de.tondorf.mockingvortrag.constructor;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.net.Socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(Connection.class)
@RunWith(PowerMockRunner.class)
public class ConnectionTest {

	@Test
	public void testConnectAndDisconnect() throws Exception {
		final Socket socket = mock(Socket.class);

		whenNew(Socket.class).withArguments(anyString(), anyInt()).thenReturn(
				socket);

		final Connection connection = new Connection();
		connection.connect();
		connection.disconnect();

		verifyNew(Socket.class).withArguments("localhost", 1337);
		verify(socket).close();
	}
}
