public class LoL{
	String name;
	String dingWei;
	String faBuShiJian;
	LoLJiNeng[] jiNeng = new LoLJiNeng[4];
	public void yingXiong(){
		System.out.println("Ӣ�ۣ�"+name+"\nλ�ã�"+dingWei+"\n�������ڣ�"+faBuShiJian+"\n����˵����");
		for(int i=0;i<jiNeng.length;i++){
			jiNeng[i].jiNeng();
		}
	}
}