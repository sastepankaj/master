package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RequestProcessor implements Runnable {
	private Socket con;
	public RequestProcessor(Socket conn) {
		this.con = conn;
	}
	@Override
	public void run() {
		DataInputStream dis = null;
		DataOutputStream dos = null;
		final String SERVER = "SERVER " + Thread.currentThread().getName();
		try {
			System.out.println(SERVER + ": got connection " + con.getRemoteSocketAddress().toString());
			dis = new DataInputStream(con.getInputStream());
			String temp = (String)dis.readUTF();
			System.out.println(SERVER + ": received message " + temp);
			con.setSendBufferSize(1024);
			dos = new DataOutputStream(con.getOutputStream());
			dos.writeUTF(temp.toUpperCase());
			dos.flush();
			System.out.println(SERVER + ": sent response and closing the connections");
		}
		catch(Exception exc) {
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
		}
	}
}
