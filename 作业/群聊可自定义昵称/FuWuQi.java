package zuoye0504_1;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuQi {

	public static void main(String[] args) {
		System.out.println("------ ���������� (Ⱥ��) ------");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(20000);
			socket = null;
			Map<Socket,String> map = new HashMap<Socket,String>();
			int num = 0;
			while(true){
				//�����˿�
				socket = serverSocket.accept();
				//��ȡ�ͻ�������
				String name = "";
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				name = bufferedReader.readLine();
				//����ͻ�������Ϊ�գ�ϵͳĬ�ϸ���һ��
				if(name==null||name.equals("")){
					num++;
					name = "�ͻ���"+num;
				}
				//����ͻ���
				map.put(socket,name);
				System.out.println(map.get(socket)+"�����ӵ���������");
				Set<Socket> setMap = map.keySet();
				for(Socket socket1:setMap){
					PrintWriter printWriter = null;
					try {
						printWriter = new PrintWriter(socket1.getOutputStream());
						printWriter.write("ϵͳ��ʾ��"+map.get(socket)+"����Ⱥ�ģ�\n");
						printWriter.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//���ͻ��˷����Ƿ����ӳɹ�
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write("���ӳɹ�����ʼ����ɣ�"+"\n");
				printWriter.flush();
				//�գ��ؿͻ�����Ϣ
				new Thread(new FuWuRunnable(socket,map)).start();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//�رշ�����
			if(serverSocket!=null){
				if(!serverSocket.isClosed()){
					try {
						serverSocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
