package echo01;
import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) throws IOException {
		InputStream input = System.in;
		InputStreamReader sisr = new InputStreamReader(input, "UTF-8");
		BufferedReader sbr = new BufferedReader(sisr);
		
		OutputStream output = System.out;
		OutputStreamWriter sosw = new OutputStreamWriter(output, "UTF-8");
		BufferedWriter sbw = new BufferedWriter(sosw);
		
		Socket socket = new Socket();
		
		
		System.out.println("<클라이언트 시작>");
		System.out.println("===================================");
		
		
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.0.27", 10001)); //Part where Client attempts to connect to Server
		
		System.out.println("[서버에 연결 되었습니다.]");
		
		//message-sending stream
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//message receiving stream
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//Scanner sc = new Scanner(System.in);
		
		while(true) {
			//send
			String str = sbr.readLine();
			
			if(str.equals("/q")) {
				break;
			}
			
			bw.write(str);
			bw.newLine();
			bw.flush();
			
			//receive
			String msg = br.readLine();
			sbw.write("Received: " + msg);
			sbw.newLine();
			sbw.flush();
		}
		
		sbw.write("===================================\n<클라이언트 종료>");
		sbw.newLine();
		sbw.flush();
		
		sbw.close();
		sbr.close();
		br.close();
		bw.close();
		socket.close();
	}
}
