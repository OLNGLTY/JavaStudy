package zuoye0502_6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FuWuQi {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			//����������
			System.out.println("----- ���������� -----");
			serverSocket = new ServerSocket(20000);
			while(true){
				System.out.println("���ڻ�ȡ�ͻ���...");
				socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("�ɹ���ȡ�ͻ���"+ip);
				
				//��ȡ�ͻ��˷�������Ϣ
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[1024];
				int len=0;
				StringBuffer sb = new StringBuffer();
				while((len=is.read(bytes))!=-1){
					sb.append(new String(bytes,0,len));
				}
				System.out.println("�ɹ����յ��ͻ��˷�������Ϣ=="+sb);
				
				//���ظ��ͻ��˵���Ϣ
				OutputStream os = socket.getOutputStream();
				os.write((sb.toString()).getBytes());
				os.flush();
				socket.shutdownOutput();
				
				//�жϷ������Ƿ�ֹͣ
//				System.out.println(socket.isClosed());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			/**
			 * �ر�
			 */
//			if(serverSocket.isClosed()){
//				try {
//					serverSocket.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}	
//			}
			
		}
	}

}
