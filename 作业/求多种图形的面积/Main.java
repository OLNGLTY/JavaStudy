import java.util.Scanner;
public class Main{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//������
		//Triangle tri = new Triangle();
		menu();
	}
	//�˵�
	static void menu(){
		System.out.println("-----------------------------");
		System.out.println("��ѡ����״��");
		System.out.println("1.������");
		System.out.println("2.Բ��");
		int num = sc.nextInt();
		switch(num){
			case 1:
				exportTriangle();
				break;
			case 2:
				exportCircle();
				break;
			default:
				System.out.println("û�д�ѡ�");
				menu();
		}

	} 
	//����߳����ߣ����������ܳ�----������
	static void exportTriangle(){
		System.out.println("�����룺");
		System.out.print("��1��");
		double a=sc.nextDouble();
		System.out.print("��2��");
		double b=sc.nextDouble();
		System.out.print("��3��");
		double c=sc.nextDouble();
		System.out.print("�ߣ�");
		double h=sc.nextDouble();
		if(a+b<=c||a+c<=b||b+c<=a&&a>0&&b>0&&c>0&&h>0){
			System.out.println("���ܹ��������Σ�");
			exportTriangle();
		}else{
			Triangle tri = new Triangle(a,b,c,h);
			System.out.println("�����������"+tri.area());
			System.out.println("�������ܳ���"+tri.perimeter());
		}
	}
	//����뾶�����������ܳ�----Բ
	static void exportCircle(){
		System.out.println("������������");
		System.out.print("�뾶��");
		double r=sc.nextDouble();
		if(r>0){
			System.out.println("���ܹ���Բ�Σ�");
			exportCircle();
		}
		Circle cir = new Circle(r);
		System.out.println("Բ�������"+cir.area());
		System.out.println("Բ���ܳ���"+cir.perimeter());
	}
}