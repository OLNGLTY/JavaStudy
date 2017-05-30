package com.dazhi;
import java.util.*;
public class RentCar {
	public static Car[] car= {
								new ManCar("�µ�A4",4,500),
								new ManCar("���Դ�6",4,400),
								new ConvertibleCar("Ƥ��ѩ6",4,2,450),
								new ManCar("����",20,800),
								new Truck("�ɻ���",4,400),
								new Truck("��ά��",20,1000)
							};// = new Car[100];
	private static Scanner sc = new Scanner(System.in);
	/**
	 * ��� 
	 */
	public static void Entrance(){
		System.out.println("****** ��ӭʹ���⳵ϵͳ�� *****");
		System.out.println("******  ��ȷ���⳵��   ******");
		boolean yesNo = Judge();
		if(yesNo){
			AllCarInfo();
			OptionCar();
			RentBill();
		}else{
			System.out.println("****��л���Ļݹˣ���ӭ�ٴι��٣�****");
			System.exit(0);
		}
	}
	/**
	 * yes||no
	 * @return
	 */
	public static boolean Judge(){
		System.out.print("�����루YES��Y/NO��N����");
		while(true){
			String str = sc.next();
			if(str.equals("Y")||str.equals("y")){
				return true;
			}else if(str.equals("N")||str.equals("n")){
				return false;
			}
			System.out.print("û�д�ѡ������루Y/N����");
		}
	}
	/**
	 * ���������Ϣ
	 */
	public static void AllCarInfo(){
		System.out.println("|--------------------------------------------------------------");
		System.out.println("| ���:\t| ����:\t| �ؿ������ˣ�:\t| �ػ������֣�:\t| �����Ԫ/�죩:");
		System.out.println("|--------------------------------------------------------------");
		for(int i = 0;i<car.length;i++){
			if(car[i]!=null){
				System.out.print("| "+(i+1)+"\t");
				car[i].printCarInfo();
			}
		}
		System.out.println(car.length);
	}
	/**
	 * ѡ����
	 */
	
	public static Car[] selCar = new Car[100];
	public static double money;
	public static void OptionCar(){
		System.out.println("�������⳵������");
		int carNum = Number();
		int carId = 0;
		int dayNum = 0;
		for(int i=0;i<carNum;i++){
			System.out.println("�������"+(i+1)+"������ţ�");
			while(true){
				carId = Number();
				if(carId<=car.length&&carId>0){
					break;
				}
				System.out.println("û�иó������������룺");
			}
			selCar[i] = car[carId-1];
			System.out.println("���������øó�����(���30��)��");
			while(true){
				dayNum = Number();
				if(dayNum<=30){
					break;
				}
				System.out.println("��������Ч������");
			}
			money = money+selCar[i].getRent()*(double)dayNum;
		}
	}
	/**
	 * �˵�
	 */
	public static void RentBill(){
		System.out.println("\n***** �����˵��� *****\n");
		int sumMan = 0;
		int sumTon = 0;
		System.out.println("��ѡ���˳���");
		for(int i = 0;i<selCar.length;i++){
			if(selCar[i] != null && selCar[i].getZaiHuo()==0){
				System.out.println(selCar[i].getName());
				sumMan = sumMan +selCar[i].getZaiKe();
			}
		}
		System.out.println("\n\n��ѡ�ػ�����");
		for(int i = 0;i<selCar.length;i++){
			if(selCar[i] != null && selCar[i].getZaiHuo()!=0){
				System.out.println(selCar[i].getName());
				sumTon = sumTon +selCar[i].getZaiHuo();
			}
		}
		System.out.println("\n\n���ؿͣ�"+sumMan+"��\n���ػ���"+sumTon+"��\n�⳵�ܼ۸�"+money);
	}
	/**
	 * ��������
	 */
	public static int Number(){
		String str = sc.next();
		try{
			return Integer.parseInt(str);
		}catch (Exception e) {
			System.out.println("������������");
		}
		return Number();
	}
}
