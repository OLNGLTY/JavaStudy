package com.zhao;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuRunnable implements Runnable{
	private Socket socket;
	private String fangID;
	private Map<Socket, String> map;
	private HashMap<String, String> fang;
//	private Pieces pieces;
	public FuWuRunnable(Socket socket,String fangID,Map map,HashMap fang){
		this.socket = socket;
		this.fangID = fangID;
		this.map = map;
		this.fang = fang;
	}
	public void run() {
		while(true){
			ObjectInputStream inputStream = null;
			try {
				//���տͻ��˷��������Ӷ���
				inputStream = new ObjectInputStream(socket.getInputStream());
				Object o = inputStream.readObject();
				System.out.println("���������յ�");
				Set<Socket> setMap = map.keySet();
				for(Socket sm:setMap){
					if(map.get(sm).equals(fangID)){
						ObjectOutputStream objectOutputStream = new ObjectOutputStream(sm.getOutputStream());
						objectOutputStream.writeObject(o);
						objectOutputStream.flush();
					}
					
				}
			} catch (Exception e) {
				map.remove(socket);
				Set<String> setFang = fang.keySet();
				for(String s:setFang){
					if(s.equals(fangID)){
						if(fang.get(s).equals("2")){
							fang.replace(s, "2", "1");
						}else{
							fang.remove(s);
						}
					}
				}
				fang.remove(map.get(socket));
				System.out.println("һ���ͻ����ѹرգ�");
				break;
			}
		}
	}
}
