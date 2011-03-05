package de.tondorf.kaffeemaschine;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileInputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest({FileInputStream.class, FileSample.class})
@RunWith(PowerMockRunner.class)
public class FileSampleTest {
	
	FileInputStream fileInputStreamMock;
	FileSample fileSample;
	@Before
	public void setup() throws Exception {
		fileSample = new FileSample();
		fileInputStreamMock = mock(FileInputStream.class);
		PowerMockito.whenNew(FileInputStream.class).withArguments(anyString()).thenReturn(fileInputStreamMock);
		when(fileInputStreamMock.read()).thenThrow(new EmptyException());
	}
	
	@Test(expected = EmptyException.class)
	public void expectExceptionWhenReadingFile() throws Exception {
		fileSample.simReadFail();
	}
	
	@Test(expected = EmptyException.class)
	public void testMock(){
		PrintStream printStreamMock = mock(PrintStream.class);
		System.setOut(printStreamMock);
		System.out.println("hi");
		verify(printStreamMock, times(1)).println("hi");
		doThrow(new EmptyException()).when(printStreamMock).println("huhu");
		System.out.println("huhu");
	}
}
