import java.util.*;
public class CaiQuan{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		new CaiQuan().caiQuan();
	}
	//��ȭ
	public void caiQuan(){
		System.out.println("\n*****��ȭ��Ϸ(�˻�)*****\n");
		System.out.println("    1.ʯͷ");
		System.out.println("    2.����");
		System.out.println("    3.��\n");
		int num = 0;
		int computer = (int)(Math.random()*3+1);
		while(true){
			System.out.print("��ѡ��(���)��");
			num = num();
			if(num == 1 || num == 2 || num == 3){
				break;
			}
			System.out.print("����");
		}
		System.out.print("���ң�"+(num==1?"ʯͷ":num==2?"����":num==3?"��":"")+"\n���ԣ�"+(computer==1?"ʯͷ":computer==2?"����":computer==3?"��":"")+"\n�����");
		if(num == computer){
			System.out.println("ƽ�֣�");
		}else if(computer == 1 && num == 2 || computer == 2 && num == 3 || computer == 3 && num == 1){
			System.out.println("����Ӯ�ˣ����С����������");
		}
		else if(num == 1 && computer == 2 || num == 2 && computer == 3 || num == 3 && computer == 11){
			System.out.println("��Ӯ�ˣ���");
		}
		caiQuan();
	}
	/**
	*��������
	*/
	public int num(){
		String str = sc.next();
		try{
			return Integer.parseInt(str);
		}catch (Exception e) {
			System.out.println("������������");
		}
		return num();
	}
}