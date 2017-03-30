package dtdyq.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Date;

import dtdyq.dao.DTDProtocol;
//服务器接收进程：
public class ServerThread extends Thread {
	private Socket socket;
	private PrintStream ps;
	private BufferedReader br;
	String user;
	
	private BufferedWriter log;
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	public void run(){
		try{
			br=new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			ps=new PrintStream(socket.getOutputStream());
			
			log=new BufferedWriter(new FileWriter(Server.chatLog,true));
			String line=null;
			while((line=br.readLine())!=null){
				//用户登陆：
				if(line.startsWith(DTDProtocol.USER_LOGIN)){
					String name=line.substring(3);
					if(Server.clients.contains(name)){
						System.out.println("login error");
					}
					else{
						user=line.substring(3);
						Server.clients.put(user, ps);
						Date str=new Date(System.currentTimeMillis());
						log.write(user+" login success!  "+(str.toString())+"\n");
						log.flush();
					}
				}
				//用户发送私有消息：
				else if(line.startsWith(DTDProtocol.USER_PRI)){
					String message=line.substring(2);
					String use=message.split("/")[0];
					String text=message.split("/")[1];
					PrintStream temp=Server.clients.getPs(use);
					Server.clients.getPs(user).println("to "+use+":::"+text);
					temp.println(user+"'s private message:::"+text);
					log.write(user+" to "+use+"'s private message:::"+text+
							"  "+new Date(System.currentTimeMillis())+"\n");
					log.flush();
					
				}
				//群发消息;
				else{
					log.write(user+"'s public message-->"+line+"  "
							+new Date(System.currentTimeMillis())+"\n");
					log.flush();
					for(String temp:Server.clients.keySet()){
						Server.clients.getPs(temp).println(user+"-->"+line);
					}
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			try{
				if(br!=null){
					br.close();
				}
				if(socket!=null){
					socket.close();
				}
				if(ps!=null){
					ps.close();
				}
			}catch(IOException es){
				es.printStackTrace();
			}
		}
	}
	
}






