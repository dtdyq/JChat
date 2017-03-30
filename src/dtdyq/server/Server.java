package dtdyq.server;

import java.io.File;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import dtdyq.dao.DTDMap;

public class Server {
	//��������˿ںţ�
	private static final int PORT=30000;
	public static DTDMap<String,PrintStream> clients=new DTDMap<>();
	//��¼�����¼��
	public static File chatLog=new File("file/chat.txt");
	public void init(){
		ServerSocket server = null;
		try{
			server=new ServerSocket(PORT);
			//�����˿ںţ��������ӣ�
			while(true){
				Socket cl=server.accept();
				new ServerThread(cl).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				server.close();
			}catch(Exception e){
				System.out.println("server close error...");
			}
		}
	}
	public static void main(String[] args){
		new Server().init();
	}

}
