package zuoye0424;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * java ��
 * 
 *
 */

public class Test02 {
	public static Scanner sc = new Scanner(System.in);
										//ֱ���׳����쳣
	public static void main(String[] args) throws Exception{
		//�ڴ������-�ֽ�
		String s = "ABCDE";
		byte[] bytes = s.getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int a = 0;
		//��ȡ�������е����ݵ������
		while((a=bais.read())!=-1){
			baos.write(Character.toUpperCase((char) a));
		}
		String str = baos.toString();
		bais.close();
		baos.close();
		System.out.println(str);
		
		
		//��ӡ��
		PrintStream out = new PrintStream(new FileOutputStream(new File("test.txt")));
		out.print(3 + " + " + 2 + " = ");  
		out.println(2 + 3);  
		out.println("Hello itcast!");  
		//�����������ӡ��test.txt�ı�
		out.close();
		
		//��ʽ�����printf();
		String s1   = "��";  
		int age = 17;  
		float pi = 3.14F;  
		char c = 'U';  
		//%s����ַ�����%d���������%f���С����%c����ַ�
		System.out.printf("���֣� %s, ���䣺 %d, PI= %f, �ַ��� %c",s1,age,pi,c); 
		System.out.printf("���֣� %s, ���䣺 %s, PI= %s, �ַ��� %s", s1,age,pi,c);
		
		//������
		BufferedReader br = new BufferedReader(new FileReader("test2.txt"));  
		BufferedWriter bw = new BufferedWriter(new FileWriter("AA.txt")  );
		 
		String line = null;  
		while((line = br.readLine()) != null){//��һ��  
			bw.write(line);//дһ��
			bw.flush();
			bw.newLine();//д��һ�оͻ���  
		}  
		bw.close();  
		br.close();
	}

}
