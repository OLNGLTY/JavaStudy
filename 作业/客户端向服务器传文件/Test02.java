package zuoye0502_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Test02 {

	public static void main(String[] args) {
		try {
			System.out.println("�����������ɹ�");
			ServerSocket ss = new ServerSocket(9292);//��������˵�Socket����
			while(true){
				File f = new File("t1.txt");
				if(!f.exists()){
					f.createNewFile();
				}
				System.out.println("���ڼ����˿�");
				Socket s = ss.accept();//��ȡ�ͻ��˶���
				long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
				InputStream inputStream = s.getInputStream();
				OutputStream os = new FileOutputStream(f);
				byte[] bytes = new byte[1024];
				int len = 0;
//				StringBuffer sb = new StringBuffer();
				while((len = inputStream.read(bytes))!=-1){
					os.write(bytes,0,len);
//					sb.append(new String(bytes,0,len));
				}
//				System.out.println("������:���Ǹ�ʲô��");
//				System.out.println("�ͻ��ˣ�"+sb.toString());
				inputStream.close();
				os.close();

				
				long endTime=System.currentTimeMillis(); //��ȡ����ʱ��

				System.out.println("�ļ�����ʱ�䣺 "+(endTime-startTime)+"ms");
				String ip = s.getInetAddress().getHostAddress();
				System.out.println("���������ʵ�ַ��"+ip);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
