import java.util.*;
public class ZuoYe1{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] a = new int[5];
		System.out.println("������5��������");
		for(int i=0;i<a.length;i++){
			String str = sc.next();
			int num;
			try{
				//�ַ���ת��Ϊ����
				num = Integer.parseInt(str);
			}catch(Exception e){
				System.out.println(str+"��������������������!");
				--i;
			}
			//a[i]=num;
		}
		/*for(int i:a){
			System.out.print(i+"\t");
		}*/
	}
}