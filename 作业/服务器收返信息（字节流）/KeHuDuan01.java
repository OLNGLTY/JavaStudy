package zuoye0502_6;

import java.io.FileWriter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class KeHuDuan01 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Socket socket = null;
		try {
			while(true){socket = new Socket("192.168.199.119",20000);
				//�������������Ϣ
				System.out.println("----- �������������Ϣ -----");
				System.out.print("��������Ϣ:");
				String s = sc.next();
				OutputStream os = socket.getOutputStream();
				os.write(s.getBytes());
				os.flush();
				socket.shutdownOutput();
			
				//���ܷ�����������Ϣ
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[1024];
				int len = 0;
				StringBuffer sb = new StringBuffer();
				while((len = is.read(bytes))!=-1){
					sb.append(new String(bytes,0,len));
				}
				System.out.println("������������Ϣ=="+sb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//�رտͻ���
			if(socket!=null){
				if(socket.isClosed()){
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}
			}
		}

	}

}
