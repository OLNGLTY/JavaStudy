package com.zhao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FuWuQi {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		Map<Socket,String> map = new HashMap<Socket,String>();
		try {
			serverSocket = new ServerSocket(20000);
			while(true){
				//�����˿�
				socket = serverSocket.accept();
				String name = "";
				int a = 1;
				//�����ǳ�
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				name = bufferedReader.readLine();
				//�ж��û��Ƿ����
				Set<Socket> setSocket = map.keySet();
				for(Socket sn:setSocket){
					if(name.equals(map.get(sn))){
						a = 0;
						break;
					}
				}
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(a);
				printWriter.flush();
				//��������ھͱ�����û���Ϣ
				if(a!=0){
					map.put(socket, name);
				}else if(a==0){
					continue;
				}
				for(Socket sn:setSocket){
					PrintWriter printWriter2 = new PrintWriter(sn.getOutputStream());
					printWriter2.write("ϵͳ��ʾ��"+map.get(socket)+"�����ߣ�\n");
					printWriter2.flush();
				}
				System.out.println(map.get(socket)+"�����ӵ���������");
				
				
				//���տͻ�����Ϣ�뷵�ظ��ͻ�����Ϣ
				new Thread(new FuWuQiRunnable(socket,map)).start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
