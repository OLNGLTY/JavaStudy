package Test0427;

public class DanLi02 {
	//����ʽ����
	private static DanLi02 dl;
	private DanLi02(){}
	public static DanLi02 getDanLi(){
		if(dl==null){
			dl = new DanLi02();
		}
		return dl;
	}

}
