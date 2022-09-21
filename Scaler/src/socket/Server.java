package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		DataInputStream reader = null;
		DataOutputStream writer = null;
		ServerSocket sock = null;
		Socket con = null;
		
		try {
			System.out.println("SERVER: creating server socket");
			sock = new ServerSocket(9999);
			sock.setReceiveBufferSize(1024);
			System.out.println("SERVER: listening and ready to accept");
			while(true) {
				con = sock.accept();
				System.out.println("SERVER: got connection " + con.getRemoteSocketAddress().toString());
				reader = new DataInputStream(con.getInputStream());
				String temp = (String)reader.readUTF();
				System.out.println("SERVER: received message " + temp);
				con.setSendBufferSize(1024);
				writer = new DataOutputStream(con.getOutputStream());
				writer.writeUTF(temp.toUpperCase());
				writer.flush();
				System.out.println("SERVER: sent response and closing the connections");
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
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(sock!=null)
					sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
