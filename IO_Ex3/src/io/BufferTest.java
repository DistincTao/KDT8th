package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferTest {

	public static void main(String[] args) throws IOException {
		
		// 입출력 스트림 생성
		String originalFile1 = BufferTest.class.getResource("aurora-1.jpg").getPath();
		String originalFile2 = BufferTest.class.getResource("aurora-2.jpg").getPath();

		String copyFile1 = "D:\\Lectures\\java\\copyAurora-1.jpg";
		String copyFile2 = "D:\\Lectures\\java\\copyAurora-2.jpg";
		
		FileInputStream fis1 = new FileInputStream(originalFile1);
		FileOutputStream fos1 = new FileOutputStream(copyFile1);
		
		FileInputStream fis2 = new FileInputStream(originalFile2);
		FileOutputStream fos2 = new FileOutputStream(copyFile2);
		
		// 버퍼를 이용할 경우 -> 2번
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		// 버퍼를 이용하지 않는 경우 -> 1번
		long noBufferTime = copyFile(fis1, fos1);
		System.out.println("no Buffer : " + noBufferTime +"ns");
		long bufferTime = copyFile(bis, bos);
		System.out.println("   Buffer : " + bufferTime +"ns");
		
		bis.close();
		bos.close();
		fis2.close();
		fos2.close();

	}

	static long copyFile(InputStream is, OutputStream os) throws IOException {
		long startTime = System.nanoTime();
		while (true) {
			int data = is.read();
			if (data == -1 ) break;	
			os.write(data);

		}
		os.flush();
		long endTime = System.nanoTime();
		
		is.close();
		os.close();
		return endTime - startTime;

	}

}
