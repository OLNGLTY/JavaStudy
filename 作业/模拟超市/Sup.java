public class Sup{
	private int id;//��Ʒid
	private String name;//��Ʒ��
	private int repert;//���
	//���������޲Σ�
	public Sup(){
		
	}
	//���������вΣ�
	public Sup(int id,String name,int repert){
		this.id=id;
		this.name=name;
		this.repert=repert;
	}
	//��Ʒ��Ϣ
	public void com(){
		System.out.println("-------------------------------------------");
		System.out.println("| ���: "+id+"   | ��Ʒ����"+name+"   | ���:"+repert);
	}
	//��Ʒset
	public String setName(){
		return this.name;
	}
	//��Ʒget
	public void getName(String name){
		this.name=name;
	}
	//���set
	public int setRepert(){
		return this.repert;
	}
	//���get
	public void getRepert(int repert){
		this.repert=repert;
	}
	public void getRepert(int repert,int SSnum,int k){

		this.repert=repert;
	}
}