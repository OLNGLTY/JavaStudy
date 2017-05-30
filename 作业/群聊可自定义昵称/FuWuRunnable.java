package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuRunnable implements Runnable{
	private Socket socket;
	Map<Socket,String> map;
	public FuWuRunnable(Socket socket,Map<Socket,String> map){
		this.socket = socket;
		this.map = map;
	}
	@Override
	public void run() {
		while(true){
			BufferedReader bufferedReader = null;
			try {
				//���տͻ�����Ϣ
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bufferedReader.readLine();
				System.out.println(map.get(socket)+":"+s);
				
				//���ظ��������ӵĿͻ�����Ϣ
				Set<Socket> setMap = map.keySet();
				for(Socket socket1:setMap){
					PrintWriter printWriter = new PrintWriter(socket1.getOutputStream());
					printWriter.write(map.get(socket)+":"+s+"\n");
					printWriter.flush();
				}
				
				
			} catch (IOException e) {
				//���������߿ͻ��˷���������Ϣ
				Set<Socket> setMap = map.keySet();
				for(Socket socket1:setMap){
					PrintWriter printWriter = null;
					try {
						printWriter = new PrintWriter(socket1.getOutputStream());
						printWriter.write("ϵͳ��ʾ��"+map.get(socket)+"�˳�Ⱥ�ģ�\n");
						printWriter.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println(map.get(socket)+"��������Ͽ���");
				map.remove(socket);
				break;
			}
		}
			
	}

}
