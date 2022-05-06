package echo01;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.219.172", 10001));
		
		System.out.println("<서버시작>");
		System.out.println("===============================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		Socket socket = serverSocket.accept();
		System.out.println("[클라이언트가 연결 되었습니다.]");
		
		//message receiving stream
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//message sending stream
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		while(true) {
			//receive
			String msg = br.readLine();
			
			if(msg == null) {
				break;
			}
			
			System.out.println("Received: " + msg);
			
			//send
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		
		System.out.println("===================================");
		System.out.println("<서버종료>");
		
		serverSocket.close();
		socket.close();
	}
}
