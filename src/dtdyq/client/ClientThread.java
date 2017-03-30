package dtdyq.client;

import java.io.BufferedReader;

import javax.swing.JTextArea;

/**
 * �ͻ����̣߳���ȡ���������͵���Ϣ
 * @author Admin
 *
 */
public class ClientThread extends Thread{
	BufferedReader br;
	JTextArea jta;
	public ClientThread(BufferedReader br,JTextArea jta){
		this.br=br;
		this.jta=jta;
	}
	public void run(){
		try{
			String line=null;
			while(true){
				if((line=br.readLine())!=null){
					if(jta!=null){
						jta.append(line+"\n");
					}
				}
					
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
