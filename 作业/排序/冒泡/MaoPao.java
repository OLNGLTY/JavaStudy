import java.util.Scanner;
public class MaoPao{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] a=new int[10];
		System.out.println("������10�����������Ϊdesc����");
		for(int i=0;i<a.length;i++){
			System.out.println("��"+(i+1)+"����");
			a[i]=sc.nextInt();
		}
		int b;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]<a[j+1]){
					b=a[j];
					a[j]=a[j+1];
					a[j+1]=b;
				}
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
	}
}