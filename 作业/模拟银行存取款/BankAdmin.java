import java.util.Scanner;
public class BankAdmin{
	//�˻���Ϣ
	public static Bank[] bank = new Bank[100];
	static Scanner sc = new Scanner(System.in);
	static String adminCode = "admin";
	//��ʼ������
	static void bankB(){
		bank[0] = new Bank("���캣",12345678,"123456",10000);
		bank[1] = new Bank("���ຣ",110,"654321",20000);
	}
	//�˵�
	static void menu(){
		System.out.println("-------------------------------------------");
		System.out.println("��ѡ�������");
		System.out.println("    1.��¼");
		System.out.println("    2.����Ա");
		System.out.println("    3.�˳�");
		System.out.print("\n���룺");
		int num = sc.nextInt();
		switch(num){
			case 1://��¼
				logger();
				break;
			case 2://����Ա
				manager();
				break;
			case 3://�˳�
				System.exit(0);
				break;
			default:
				System.out.print("û�д�ѡ�");
		}
		menu();
	}
	//��¼
	static void logger(){
		System.out.println("-------------------------------------------");
		System.out.print("���ţ�");
		int num = sc.nextInt();
		System.out.print("���룺");
		String str = sc.next();
		boolean cardNo=true;
		boolean code=true;
		for(int i=0;i<bank.length;i++){
			if(bank[i]!=null){
				cardNo = (bank[i].setCardNo()==num);
				if(cardNo){
					code = (bank[i].setCode().equals(str));
					if(code){
						System.out.println("��½�ɹ���");
						menuLogger(i);
					}else{
						System.out.println("����������������룺");
						logger();
					}
				}
			}
		}
		System.out.println("û�д˿���Ϣ��");
		logger();
	}
	//��¼�˵�
	static void menuLogger(int k){
		System.out.println("-------------------------------------------");
		System.out.println("��ѡ��");
		System.out.println("1.�鿴�˻���Ϣ");
		System.out.println("2.��Ǯ");
		System.out.println("3.ȡǮ");
		System.out.println("4.ת��");
		System.out.println("5.�޸�����");
		System.out.println("6.�˳���¼");
		System.out.print("\n���룺");
		int num = sc.nextInt();
		switch(num){
			case 1://�鿴�˻���Ϣ
				meinAccount(k);
				break;
			case 2://��Ǯ
				System.out.println("-------------------------------------------");
				System.out.print("���");
				moneySaveTake(k,1);
				break;
			case 3://ȡǮ
				System.out.println("-------------------------------------------");
				System.out.print("ȡ��");
				moneySaveTake(k,0);
				break;
			case 4://ת��
				transferAccounts(k);
				break;
			case 5://�޸�����
				changeCode(k,1);
				break;
			case 6://�˳���¼
				menu();
				break;
			default:

		}
	}
	//�鿴�˻���Ϣ
	static void meinAccount(int k){
		bank[k].com();
		hint();
		menuLogger(k);
	}
	//��Ǯ&ȡǮ
	static void moneySaveTake(int k,int m){
		System.out.print("��");
		int num = sc.nextInt();
		if(m==1){
			bank[k].getMoney(bank[k].setMoney()+num);
		}else if(m==0){
			bank[k].getMoney(bank[k].setMoney()-num);
		}
		System.out.println("�����ɹ����Ƿ������\n1.��\n2.��������ֵ�����ϼ��˵�");
		int num2 = sc.nextInt();
		if(num2==1){
			moneySaveTake(k,m);
		}else{
			menuLogger(k);
		}
	}
	//ת��
	static void transferAccounts(int k){
		System.out.println("-------------------------------------------");
		System.out.print("������ת���˻����ţ�");
		int cardNo = sc.nextInt();
		System.out.print("ת���");
		int money = sc.nextInt();
		if(cardNo==bank[k].setCardNo()){
			System.out.println("�벻Ҫ���뵱ǰ���ţ�");
			transferAccounts(k);
		}
		for(int i=0;i<bank.length;i++){
			if(bank[i]!=null&&bank[i].setCardNo()==cardNo){
				bank[i].getMoney(bank[i].setMoney()+money);
				bank[k].getMoney(bank[k].setMoney()-money);
				System.out.println("-------------------------------------------");
				System.out.println("�����ɹ����Ƿ������\n1.��\n2.��������ֵ�����ϼ��˵�");
				int num2 = sc.nextInt();
				if(num2==1){
					transferAccounts(k);
				}else{
					menuLogger(k);
				}
				break;
			}
		}
		System.out.println("û�д˿�����Ϣ��");
		transferAccounts(k);
	}
	//����Ա
	static void manager(){
		System.out.println("-------------------------------------------");
		System.out.print("���������Ա���룺");
		String str = sc.next();
		if(adminCode.equals(str)){
			menuManager();
		}else{
			System.out.println("�������");
			manager();
		}
		
		
	}
	//����Ա�˵�
	static void menuManager(){
		System.out.println("-------------------------------------------");
		System.out.println("��ѡ��");
		System.out.println("1.�鿴���������˻�");
		System.out.println("2.�޸Ĺ���Ա����");
		System.out.println("3.�˳�����Ա");
		System.out.print("\n���룺");
		int num = sc.nextInt();
		switch(num){
			case 1://�鿴���������˻�
				allAccount();
				hint();
				menuManager();
				break;
			case 2://�޸Ĺ���Ա����
				changeCode(0,0);
				break;
			case 3://�˳�����Ա
				menu();
				break;
			default:
				System.out.println("û�д�ѡ��");
				menuManager();
		}
	}
	//�����˻���Ϣ
	static void allAccount(){
		for (int i = 0;i<bank.length;i++){
			if(bank[i]!=null){
				bank[i].com();
			}
		}
	}
	//�޸����� 
	static void changeCode(int k,int m){
		System.out.println("-------------------------------------------");
		System.out.print("��ǰ���룺");
		String str1 = sc.next();
		System.out.print("�µ����룺");
		String str2 = sc.next();
		System.out.print("ȷ�����룺");
		String str3 = sc.next();
		boolean bStr1=true;
		boolean bStr2=true;
		if(m==1){
			bStr1 = (str1.equals(bank[k].setCode()));
		}else if(m==0){
			bStr1 = (str1.equals(adminCode));
		}
		bStr2 = (str2.equals(str3));
		if(bStr1){
			if(bStr2){
				if(m==1){
					/**
					���󣡣���
					
					*/
					bank[k].getCode(str2);
				}else if(m==0){
					adminCode = str2;
				}
			}
			else{
				System.out.println("��������ȷ�����벻һ�£����������룡");
				changeCode(k,m);
			}
		}else{
			System.out.println("��ǰ�����������������!");
			changeCode(k,m);
		}
		System.out.println("�޸ĳɹ�!");
		hint();
		if(m==1){
			menuLogger(k);
		}else{
			menuManager();
		}
	}
	//�����ϼ��˵���ʾ
	static void hint(){
		System.out.println("-------------------------------------------");
		System.out.println("����ֵ�����ϼ��˵���");
		String str = sc.next();
	}
}