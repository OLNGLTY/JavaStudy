package Test01;
import java.util.*;
public class RentCar {
	public static Car[] car = new Car[100];
	private static Scanner sc = new Scanner(System.in);
	/**
	 *��ʼ��������Ϣ 
	 */
	public static void carInfo(){
		car[0] = new Car(1,"�µ�A4",4,0,500);
		car[1] = new Car(2,"���Դ�6",4,0,400);
		car[2] = new Car(3,"Ƥ��ѩ6",4,2,450);
		car[3] = new Car(4,"����",20,0,800);
		car[4] = new Car(5,"�ɻ���",2,4,400);
		car[5] = new Car(6,"��ά��",2,20,1000);
	}
	/**
	 * ��� 
	 */
	public static void Entrance(){
		carInfo();
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
	 * ������г�����Ϣ
	 */
	public static void AllCarInfo(){
		System.out.println("|--------------------------------------------------------------");
		System.out.println("| ���:\t| ����:\t| �ؿ������ˣ�:\t| �ػ������֣�:\t| �����Ԫ/�죩:");
		System.out.println("|--------------------------------------------------------------");
		for(Car c:car){
			if(c!=null){
				c.printCarInfo();
			}
		}
	}
	/**
	 * ѡ����
	 */
	public static int[] carId = new int[100];
	public static void OptionCar(){
		System.out.println("�������⳵������");
		int num = Number();
		for(int i=0;i<num;i++){
			System.out.println("�������"+(i+1)+"������ţ�");
			carId[i] = Number();
		}
	}
	/**
	 * �˵�
	 */
	public static void RentBill(){
		System.out.println("\n***** �����˵��� *****\n");
		double money = 0d;
		int num = 0;
		int num2 = 0;
		System.out.println("��ѡ���˳���");
		for(int i = 0;i<car.length;i++){
			for(int j = 0;j<carId.length;j++){
				if(car[i] != null&&car[i].getId()==carId[j]&&car[i].getZaiHuo()==0){
					System.out.println(car[i].getName());
					money = money + car[i].getRent();
					num = num + car[i].getZaiKe();
				}
			}
		}
		System.out.println("\n\n��ѡ�ػ�����");
		for(int i = 0;i<car.length;i++){
			for(int j = 0;j<carId.length;j++){
				if(car[i] != null&&car[i].getId()==carId[j]&&car[i].getZaiHuo()!=0){
					System.out.println(car[i].getName());
					money = money + car[i].getRent();
					num2 = num2 +car[i].getZaiHuo();
				}
			}
		}
		System.out.println("���ؿͣ�"+num+"��\n���ػ���"+num2+"��\n�⳵�ܼ۸�"+money);
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
