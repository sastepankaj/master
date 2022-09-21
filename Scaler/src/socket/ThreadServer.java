package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadServer {
	public static void main(String[] args) {
		
		ServerSocket sock = null;
		Socket con = null;
		try {
			System.out.println("SERVER: creating server socket");
			sock = new ServerSocket(9999);
			sock.setReceiveBufferSize(1024);
			System.out.println("SERVER: listening and ready to accept");
			ExecutorService executor = Executors.newCachedThreadPool();
			while(true) {
				con = sock.accept();
				RequestProcessor handler = new RequestProcessor(con);
				executor.submit(handler);
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
