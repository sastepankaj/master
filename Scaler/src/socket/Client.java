package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
	public static void main(String[] args) {
		for(int i=1; i<=10; ++i) {
			Socket sock = new Socket();
			SocketAddress raddr = new InetSocketAddress("127.0.0.1", 9999);
			DataOutputStream writer = null;
			DataInputStream reader = null;
			try {
				System.out.println("CLIENT: connecting to server " + raddr.toString());
				sock.connect(raddr);
				sock.setSendBufferSize(1024);
				System.out.println("CLIENT: sending data to server");
				writer = new DataOutputStream(sock.getOutputStream());
				writer.writeUTF("Hello World " + i);
				writer.flush();
				
				System.out.println("CLIENT: data sent to server. now reading response");
				reader = new DataInputStream(sock.getInputStream());
				String temp = (String)reader.readUTF();
				System.out.println("CLIENT: received response " + temp);
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(writer!=null)
						writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(reader!=null)
						reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(sock!=null)
						sock.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
