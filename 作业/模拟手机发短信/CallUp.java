import java.util.Scanner;
public class CallUp{
	static Scanner sc = new Scanner(System.in);
	public static Person[] person = new Person[100];
	public static Phone[] phone = new Phone[100];
	public static SIM[] sim = new SIM[100];
	public static Person person2 = new Person();
	public static Phone phone2 = new Phone();
	public static SIM sim2 = new SIM();
	public static void main(String[] args){
		init();
		ssm();
	}
	//��ʼ��ֵ
	static void init(){
		sim[0] = new SIM("��ͨ","18669925665");
		phone[0] = new Phone("����note","��","С���ֻ�",sim[0]);
		person[0] = new Person("���캣",'��',17,phone[0]);
		sim[1] = new SIM("�ƶ�","17853941237");
		phone[1] = new Phone("С��5","��","С���ֻ�",sim[1]);
		person[1] = new Person("���ຣ",'Ů',15,phone[1]);
	}
	//������
	static void ssm(){
		System.out.println("\n----------------- �����ţ�-----------------\n");
		System.out.println("-------- ��ǰĬ�Ͽ��ţ�18669925665 --------");
		System.out.println("\n");
		System.out.print("�ռ��ˣ�");
		String str = sc.next();
		System.out.print("���ݣ�");
		String str2 = sc.next();
		for(int i=0;i<sim2.inbox.length;i++){}
	}

	//�˵�
	static void menu(){
		System.out.println("----------------------------");
		System.out.println("��ѡ��");
		System.out.println("1.ѡ���ֻ�");
		System.out.println("2.����ֻ�");
		System.out.println("3.�����ֻ���");
	}
}