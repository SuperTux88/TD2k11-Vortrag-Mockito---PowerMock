package de.tondorf.kaffeemaschine;

import java.io.File;
import java.io.FileInputStream;

public class FileSample {
	public void simReadFail() throws Exception {
		FileInputStream fileInputStream = new FileInputStream(".");
		fileInputStream.read();
	}
}
