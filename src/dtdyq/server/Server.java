package dtdyq.server;

import java.io.File;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import dtdyq.dao.DTDMap;

public class Server {
	//定义监听端口号：
	private static final int PORT=30000;
	public static DTDMap<String,PrintStream> clients=new DTDMap<>();
	//记录聊天记录：
	public static File chatLog=new File("file/chat.txt");
	public void init(){
		ServerSocket server = null;
		try{
			server=new ServerSocket(PORT);
			//监听端口号，建立连接：
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
