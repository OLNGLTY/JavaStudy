import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PassWord{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str;
		Pattern p1 = Pattern.compile("\\d+");
		Pattern p2 = Pattern.compile("[A-Za-z]+");
		Pattern p3 = Pattern.compile("[.~!@#$%^&*-+]+");
		while(true){
			System.out.println("������6-16λ����(�����ַ�������.~!@#$%^&*-+)��");
			str = sc.next();
			if(str.matches("[a-zA-Z0-9.~!@#$%^&*-+]{6,16}")){
				break;
			}
		}
		Matcher m1 = p1.matcher(str);
		Matcher m2 = p2.matcher(str);
		Matcher m3 = p3.matcher(str);
		System.out.print("����ǿ�ȣ�");
		if(m1.find()&&m2.find()&&m3.find()){
			System.out.println("ǿ");
		}else if(m1.find()&&m2.find()||m1.find()&&m3.find()||m3.find()&&m2.find()){
			System.out.println("��");
		}else{
			System.out.println("��");
		}
		
	}
}