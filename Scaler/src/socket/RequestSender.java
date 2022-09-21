package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class RequestSender implements Runnable {
	private int taskNumber;
	public RequestSender(int number) {
		this.taskNumber = number;
	}
	@Override
	public void run() {
		Socket sock = new Socket();
		SocketAddress raddr = new InetSocketAddress("127.0.0.1", 9999);
		DataOutputStream dos = null;
		DataInputStream dis = null;
		final String CLIENT = "CLIENT " + Thread.currentThread().getName();
		try {
			System.out.println(CLIENT + ": connecting to server " + raddr.toString());
			sock.connect(raddr);
			sock.setSendBufferSize(1024);
			System.out.println(CLIENT + ": sending data to server");
			dos = new DataOutputStream(sock.getOutputStream());
			dos.writeUTF("Hello World " + taskNumber);
			dos.flush();
			
			System.out.println(CLIENT + ": data sent to server. now reading response");
			dis = new DataInputStream(sock.getInputStream());
			String temp = (String)dis.readUTF();
			System.out.println(CLIENT + ": received response " + temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(dos!=null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(dis!=null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(sock!=null) {
					sock.close();
					System.out.println(CLIENT + ": socket closed");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
