import java.util.Scanner;
public class XuanZe{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] a=new int[10];
		System.out.println("������10�����������Ϊasc����");
		//����10����
		for(int i=0;i<a.length;i++){
			System.out.println("��"+(i+1)+"����");
			a[i]=sc.nextInt();
		}
		//����ѭ����������Сֵmin=a[i]
		for(int i=0;i<a.length;i++){
			int min,b=i,c;
			min=a[i];
			for(int j=i+1;j<a.length;j++){
				if(a[j]<min){
					min=a[j];
					b=j;
				}
			}
			c=a[i];
			a[i]=a[b];
			a[b]=c;
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}
}