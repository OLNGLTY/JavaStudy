import java.util.*;
public class CaiPiao{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		new CaiPiao().caiPiao();
	}
	public void caiPiao(){
		System.out.println("\n*****��ƱС��Ϸ*****\n");//
		System.out.println("˵���������10ע������ע�������Ϊ��λ������СΪ1��");//
		System.out.println("\n    �����ͻ�A��ע3ע���ֱ�Ϊ��12������88������66����\n\t�ұ��ڲ�Ʊ����Ϊ����01������19������20������76������88������91������36������53������78������10����\n\t��ô�ͻ�A�˴ι����Ʊ����һע����88�����������Ӧ��Ʒ��");//
		System.out.println("\n��Ʒ��");//
		System.out.println("��  һ  ע������һƿ");//
		System.out.println("�ж�����ע��������ƿ");//
		System.out.println("���嵽��ע������һ��");//
		System.out.println("�а˵���ע����������");//
		System.out.println("ʮ עȫ �У�����һ������\n");//
		int num = 0;
		while(true){
			System.out.println("������ע��(1~10)��");//
			num = num();
			if(num>0&&num<11){
				break;
			}
		}
		int[] zhu = new int[num];
		int[] piaoId = new int[10];
		int count = 0;
		System.out.println("�����루1~99��:");
		for(int i = 0;i<num;i++){
			System.out.println("��"+(i+1)+"ע��");
			zhu[i] = num();
			if(zhu[i]<1||zhu[i]>99){
				i--;
				continue;
			}
			for(int j = 0;j<i;j++){
				if(zhu[i] == zhu[j]){
					System.out.println("��ע���£�");
					i--;
					break;
				}
			}
		}
		for(int i = 0;i<piaoId.length;i++){
			piaoId[i] = (int)(Math.random()*10+1);
			for(int j = 0;j<i;j++){
				if(piaoId[i] == piaoId[j]){
					i--;
					break;
				}
			}
		}
		System.out.println("���κ���Ϊ��");
		for(int a:piaoId){
			System.out.print(a+"\t");//
			for(int j=0;j<zhu.length;j++){
				if(a==zhu[j]){
					count++;
				}
			}
		}
		System.out.println("\n\n������"+count+"ע����ý�Ʒ��"+(count==1?"����һƿ��":count>1&&count<5?"������ƿ��":count>4&&count<8?"����һ�䣡":count>7&&count<10?"�������䣡":count==10?"����һ������":""));//
	}
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