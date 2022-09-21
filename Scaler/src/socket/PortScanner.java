package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class PortScanner {
	public static void main(String[] args) {
		System.out.println("************** OPEN PORT SCANNER **************");
		Scanner scan = new Scanner(System.in);
		System.out.println("Port range start: ");
		int start = scan.nextInt();
		System.out.println("Port range end: ");
		int end = scan.nextInt();
		
		for(int i=start; i<=end; i++) {
			Socket sock = new Socket();
			SocketAddress raddr = new InetSocketAddress("127.0.0.1", i);
			final String CLIENT = "CLIENT " + Thread.currentThread().getName();
			try {
				sock.connect(raddr);
				System.out.println("Port " + i + " is OPEN");
			}
			catch(Exception e) {
				//e.printStackTrace();
			}
			finally {
				if(sock!=null) {
					try {
						sock.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		scan.close();
	}
}
