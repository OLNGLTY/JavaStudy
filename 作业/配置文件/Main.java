import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//��ȡ�ļ�
		File f = new File("a.properties");
		//��������ھʹ���
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�˵�
		menu(f);
	}
	//�˵�
	public static void menu(File f){
		System.out.println("-------��ѡ��-------");
		System.out.println("   1.��¼");
		System.out.println("   2.ע��");
		int num = sc.nextInt();
		if(num==1){//��¼
			System.out.println("-------��¼-------");
			enter(f);
		}else if(num==2){//ע��
			System.out.println("-------ע��-------");
			login(f);
		}
	}
	//��¼
	public static void enter(File f){
		//
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);//����������Դ�.properties�����ļ���Ӧ���ļ��������У����������б�Properties�����
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�����û���&����
		System.out.print("�û�����");
		String username = sc.next();
		System.out.print("�ܡ��룺");
		String password = sc.next();
		//����һ���������������ж��û���(Ҳ����prop��key)�Ƿ����
		Iterator<String> it=prop.stringPropertyNames().iterator();
		//boolean b �������b=true�����������b=false
		boolean b = false;
		while(it.hasNext()){
			if(it.next().equals(username)){
				b = true;
				break;
			}
		}
		if(b){//������ڸ��û�����ô�жϸ��û��������Ƿ�������ȡ
			if(prop.getProperty(username).equals(password)){
				System.out.println("��¼�ɹ���");
				menu(f);
			}else{
				System.out.println("�������");
				menu(f);
			}
		}else if(!b){//��������ڸ��û�����ʾû�д��û�
			System.out.println("û�д��û���");
			menu(f);
		}
	}
	//ע��
	public static void login(File f){
		FileInputStream fis = null;
		FileWriter fw = null;
		try{
			if(!f.exists()){
				f.createNewFile();
			}
			fis = new FileInputStream(f);
			String s = "";
			byte[] bytes = new byte[1024];
			int a = 0;
			while((a=fis.read(bytes))!=-1){
				s += new String(bytes,0,a)+"\r";
			}

			//ע��
			String username = null;
			String password = null;
			System.out.print("username=");//�û���
			username = sc.next();
			System.out.print("password=");//����
			password = sc.next();
			
			fw = new FileWriter(f);
			fw.write(s+username+"="+password);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���
			try {
				if(fis!=null){
					fis.close();
				}
				if(fw!=null){
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("ע��ɹ���");
			menu(f);
		}
	}

}
