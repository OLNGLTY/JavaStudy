import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//��������
		LoL yx1 = new LoL();
		LoL[] lols = new LoL[2];
		LoLJiNeng lolJN_Q = new LoLJiNeng();
		LoLJiNeng lolJN_W = new LoLJiNeng();
		LoLJiNeng lolJN_E = new LoLJiNeng();
		LoLJiNeng lolJN_R = new LoLJiNeng();
		yx1.name="��������";
		yx1.dingWei="����";
		yx1.faBuShiJian="2005-10-02";
		//����Q
		lolJN_Q.name="���ֵ�רע��Q��";
		lolJN_Q.shangHai=200;
		lolJN_Q.CD=10;
		lolJN_Q.haoLan=60;
		lolJN_Q.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx1.jiNeng[0]=lolJN_Q;
		//����W
		lolJN_W.name="���ֵ�רע��W��";
		lolJN_W.shangHai=200;
		lolJN_W.CD=10;
		lolJN_W.haoLan=60;
		lolJN_W.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx1.jiNeng[1]=lolJN_W;
		//����E
		lolJN_E.name="���ֵ�רע��W��";
		lolJN_E.shangHai=200;
		lolJN_E.CD=10;
		lolJN_E.haoLan=60;
		lolJN_E.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx1.jiNeng[2]=lolJN_E;
		//����Q
		lolJN_R.name="���ֵ�רע��R��";
		lolJN_R.shangHai=200;
		lolJN_R.CD=10;
		lolJN_R.haoLan=60;
		lolJN_R.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx1.jiNeng[3]=lolJN_R;
		//����yx1�ĵ�ַ�����飻
		lols[0]=yx1;
		lols[0].yingXiong();
		
		System.out.println("\n\n------------------------------------------------------\n\n");

		//��������֮��
		LoL yx2 = new LoL();
		yx2.name="��������֮��";
		yx2.dingWei="սʿ";
		yx2.faBuShiJian="2015-10-02";
		//����Q
		lolJN_Q.name="���ֵ�רע��Q��";
		lolJN_Q.shangHai=200;
		lolJN_Q.CD=10;
		lolJN_Q.haoLan=60;
		lolJN_Q.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx2.jiNeng[0]=lolJN_Q;
		//����W
		lolJN_W.name="���ֵ�רע��W��";
		lolJN_W.shangHai=200;
		lolJN_W.CD=10;
		lolJN_W.haoLan=60;
		lolJN_W.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx2.jiNeng[1]=lolJN_W;
		//����E
		lolJN_E.name="���ֵ�רע��W��";
		lolJN_E.shangHai=200;
		lolJN_E.CD=10;
		lolJN_E.haoLan=60;
		lolJN_E.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx2.jiNeng[2]=lolJN_E;
		//����Q
		lolJN_R.name="���ֵ�רע��R��";
		lolJN_R.shangHai=200;
		lolJN_R.CD=10;
		lolJN_R.haoLan=60;
		lolJN_R.shuoMing="��ù����ٶȣ��չ���ɶ��������˺������ҡ�����������";
		yx2.jiNeng[3]=lolJN_R;
		//����yx1�ĵ�ַ�����飻
		lols[1]=yx2;
		lols[1].yingXiong();
	}
}