package com.zhao;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuQiRunnable implements Runnable{
	Socket socket;
	Map<Socket,String> map = null;
	public FuWuQiRunnable(Socket socket,Map<Socket,String> map){
		this.socket = socket;
		this.map = map;
	}
	
	public void run() {
		BufferedReader bufferedReader;
		
		while(true){
			try {
				//���տͻ��˷�������Ϣ
				String message = "";
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				message = bufferedReader.readLine();
				//�����ݿ��������
				SQL sql = new SQL();
				sql.insert(map.get(socket), message);
				//���ظ����пͻ�����Ϣ
				Set<Socket> setSocket = map.keySet();
				for(Socket sn:setSocket){
					PrintWriter printWriter = new PrintWriter(sn.getOutputStream());
					printWriter.write(map.get(socket)+"��"+message+"\n");
					printWriter.flush();
				}
			} catch (Exception e) {
				Set<Socket> setSocket = map.keySet();
				for(Socket sn:setSocket){
					PrintWriter printWriter;
					try {
						printWriter = new PrintWriter(sn.getOutputStream());
						printWriter.write("ϵͳ��ʾ��"+map.get(socket)+"�����ߣ�\n");
						printWriter.flush();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				System.out.println(map.get(socket)+"���˳���������");
				map.remove(socket);
				return;
			}
		}
	}
}
