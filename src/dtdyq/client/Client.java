package dtdyq.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

/**
 * �ͻ��ˣ����ںͷ������������ӣ����ı����ȡ�ı�����������������
 * @author Admin
 *
 */
public class Client {
	Socket socket;
	PrintStream ps;
	BufferedReader br;
	JTextArea jta;
	public Client(JTextArea jta){
		this.jta=jta;
		try {
			socket=new Socket("127.0.0.1", 30000);
			ps=new PrintStream(socket.getOutputStream());
			br=new BufferedReader(
					new InputStreamReader(socket.getInputStream(),"utf-8"));
			new ClientThread(br,jta).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendMessage(String str){
		ps.println(str);
	}
}









