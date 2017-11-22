import java.io.*;
import java.net.*;

public class UDPC
{
	public static void main(String args[])
	{
		DatagramSocket skt;
		try
		{
			skt = new DatagramSocket();
			String msg = "UDP";
			byte[] b = msg.getBytes();
			InetAddress host = InetAddress.getByName("127.0.0.1");
			int serverskt = 6788;
			DatagramPacket request = new DatagramPacket(b,b.length,host,serverskt);
			skt.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer,buffer.length);
			skt.receive(reply);
			System.out.println("Client Receieve" + new String(reply.getData()));
			skt.close();
		}
		catch(Exception ex){
		}
	}
}
