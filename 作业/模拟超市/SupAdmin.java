import java.util.Scanner;
public class SupAdmin{
	//��Ʒ��Ϣ
	public static Sup[] sup = new Sup[100];
	static Scanner sc = new Scanner(System.in);
	//�����¼ܺ���Ʒ���µĿ�λ
	//static int[] nullValue = new int[100];
	//static int n = 0;
	//�˵�
	static void menu(){
		System.out.println("-------------------------------------------");
		System.out.println("��ѡ�������");
		System.out.println("    1.�ϼ�����Ʒ");
		System.out.println("    2.����");
		System.out.println("    3.����");
		System.out.println("    4.���");
		System.out.println("    5.�¼�");
		System.out.println("    6.�˳�");
		System.out.print("\n���룺");
		int num = sc.nextInt();
		switch(num){
			case 1://�ϼ�����Ʒ
				shangJia();
				break;
			case 2://����
				supStock();
				break;
			case 3://����
				supMarket();
				break;
			case 4://���
				supRepert();
				break;
			case 5://�¼�
				xiaJia();
				break;
			case 6://�˳�
				System.exit(0);
				break;
			default:
				System.out.print("û�д�ѡ�");
		}
		menu();
	}
	//�ϼ���Ʒ
	static int i = 0;
	static void shangJia(){
		System.out.println("-------------------------------------------");
		System.out.println("���������ϼܵģ�");
		//������Ʒ��
		System.out.print("��Ʒ����");
		String supName = sc.next();
		//��������
		System.out.print("�������");
		int supRepert = sc.nextInt();
		//new��ַ
		//���ϼܵ���Ʒ��������
		for(int i=0;i<sup.length;i++){
			if(sup[i]==null){
				Sup sup2 = new Sup(i+1,supName,supRepert);
				sup[i]=sup2;
				break;
			}
		}
		//sup[i++]=sup2;
		//sup[i].com();
		System.out.println("�ɹ����1����¼��\n");
		//�Ƿ��������
		if(textPanDuan()){
			shangJia();
		}
	}
	//�鿴���
	static void supRepert(){
		//ѡ��������Ʒ�ı�����
		textSelGoods(1);
		//�Ƿ��������
		if(textPanDuan()){
			supRepert();
		}
	}
	//��������
	static int SSNum(int k){
		if(k==2){
			System.out.print("����������");
		}else if(k==3){
			System.out.print("����������");
		}else{
			return 0;
		}
		return sc.nextInt();
	}
	//k=1; --->�鿴���
	//k=2; --->����
	//k=3; --->����
	//k=4; --->�¼�
	//s; ----->��Ʒ��ַ
	static boolean kuCun = true;
	static boolean kuCun2 = true;
	static void SSS(int s,int k,int SSnum){
		switch(k){
			case 1://�鿴���
				sup[s].com();
				break;
			case 2://����
				sup[s].getRepert(sup[s].setRepert()+SSnum);
				break;
			case 3://����
				kuCun = (sup[s].setRepert()-SSnum<0);
				kuCun2 = (sup[s].setRepert()==0);
				if(kuCun){
					System.out.println("��Ʒ"+sup[s].setName()+"û���㹻��棡");
				}else if(kuCun2){
					System.out.println("��Ʒ"+sup[s].setName()+"���Ϊ0�뼰ʱ������");
				}else{
					sup[s].getRepert(sup[s].setRepert()-SSnum);
				}
				break;
			case 4://�¼�
				sup[s]=null;
				break;
		}
	}
	//����
	static int count;
	static void count(int count,int k){
		System.out.println("-------------------------------------------");
		if(count==0){
			System.out.println("û����Ʒ���Ѿ��¼ܣ���");
		}else if(k==1){
			System.out.println("�����ɹ���");
			System.out.println("��"+count+"����¼��");
		}else if(kuCun&&k==3||kuCun2&&k==3){
			System.out.println("��0����¼��Ӱ�죡");
		}else{
			System.out.println("�����ɹ���");
			System.out.println("��"+count+"����¼��Ӱ�죡");
		}
		System.out.println("\n");
	}
	//���1
	static void repert1(int k){
		count=0;
		int SSnum2=SSNum(k);
		for(int s=0;s<sup.length;s++){
			if(sup[s]!=null){
				count++;
				SSS(s,k,SSnum2);
			}
		}
		count(count,k);
	}
	//���2
	static void repert2(int k){
		System.out.println("-------------------------------------------");
		System.out.println("��������Ʒ���ƣ�");
		System.out.print("\n���룺");
		String supName = sc.next();
		int SSnum2=SSNum(k);
		boolean bSup=true;
		count=0;
		for(int s=0;s<sup.length;s++){
			if(sup[s]!=null){
				bSup = (sup[s].setName().equals(supName));
				if(bSup){
					count++;
					SSS(s,k,SSnum2);
				}
			}
		}
		count(count,k);
	}
	//����
	static void supStock(){
		System.out.println("������");
		//ѡ��������Ʒ�ı�����
		textSelGoods(2);
		//�Ƿ��������
		if(textPanDuan()){
			supStock();
		}
	}
	//����
	static void supMarket(){
		System.out.println("���ۡ�");
		//ѡ��������Ʒ�ı�����
		textSelGoods(3);
		//�Ƿ��������
		if(textPanDuan()){
			supMarket();
		}
	}
	//�¼�
	static void xiaJia(){
		System.out.println("�¼ܡ�");
		//ѡ��������Ʒ�ı�����
		textSelGoods(4);
		//�Ƿ��������
		if(textPanDuan()){
			xiaJia();
		}
	}
	//���ѡ��������Ʒ�ı�
	static void textSelGoods(int k){
		System.out.println("-------------------------------------------");
		System.out.println("��ѡ��������Ʒ��");
		System.out.println("    1.������Ʒ");
		System.out.println("    2.ָ����Ʒ");
		System.out.println("    3.��������������ϼ��˵�");
		System.out.print("\n���룺");
		int num = sc.nextInt();
		System.out.print("\n\n");
		if(num==1){
			repert1(k);
		}else if(num==2){
			repert2(k);
		}else{
			menu();
		}
	}
	//����Ƿ���������ı�������ֵtrue��
	static boolean textPanDuan(){
		System.out.println("-------------------------------------------");
		System.out.println("�Ƿ����������");
		System.out.println("    1.��");
		System.out.println("    2.��(�����ϼ��˵�)");
		System.out.println("    3.��������������ϼ��˵�");
		System.out.print("\n���룺");
		//�Ƿ�����ϼ���Ʒ
		int num = sc.nextInt();
		System.out.print("\n\n");
		if(num==1){
			return true;//����
		}else{
			menu();//�����ϼ��˵�
			return false;
		}
	}
}