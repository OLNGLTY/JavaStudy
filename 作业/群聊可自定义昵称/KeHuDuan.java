package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class KeHuDuan {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			System.out.println("�������ǳƣ�");
			String name = sc.nextLine();
			System.out.println("----- �ͻ���("+name+") -----");
			Socket socket = new Socket("192.168.199.119",20000);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write(name+"\n");
			printWriter.flush();
			
			//��
			new Thread(new InRunnable(socket)).start();
			//��
			new Thread(new OutRunnable(socket)).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
