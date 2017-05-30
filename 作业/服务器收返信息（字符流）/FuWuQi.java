package zuoye0503_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FuWuQi {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			System.out.println("----- ���������� -----");
			serverSocket = new ServerSocket(20000);
			//��ȡ�ͻ���
			System.out.println("���ڶ�ȡ�ͻ���...");
			socket = serverSocket.accept();
			//��ȡ�ͻ���ip
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println("��ȡ�ɹ�"+ip);
			while(true){
				
				//BufferedReader   ������    //���ؿͻ��˴�������Ϣ
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bufferedReader.readLine();
				System.out.println("�ͻ��˴�������Ϣ=="+s);
				
				//��ͻ��˷�����Ϣ
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(s+"\n");
				printWriter.flush();
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�
			if(serverSocket!=null){
				if(serverSocket.isClosed()){
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
