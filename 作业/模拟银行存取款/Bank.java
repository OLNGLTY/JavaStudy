public class Bank{
	private String name;//�˻���
	private int cardNo;//����
	private String code;//����
	private int money;//���
	//���������޲Σ�
	public Bank(){
		
	}
	//���������вΣ�
	public Bank(String name,int cardNo,String code,int money){
		this.name=name;
		this.cardNo=cardNo;
		this.code=code;
		this.money=money;
	}
	//�˻���Ϣ
	public void com(){
		System.out.println("-------------------------------------------");
		System.out.println("| �˻���: "+name+"\n| ���ţ�"+cardNo+"\n| ���룺"+code+"\n| ��"+money+"��");
	}
	//�˻���set
	public String setName(){
		return this.name;
	}
	//�˻���get
	public void getName(String name){
		this.name=name;
	}
	//����set
	public int setCardNo(){
		return this.cardNo;
	}
	//����get
	public void getCardNo(int cardNo){
		this.cardNo=cardNo;
	}
	//����set
	public String setCode(){
		return this.code;
	}
	//����get
	public void getCode(String code){
		this.code=code;
	}
	//���set
	public int setMoney(){
		return this.money;
	}
	//���get
	public void getMoney(int money){
		this.money=money;
	}
	/*
	public void getMoney(int money,int SSnum,int k){

		this.money=money;
	}
	*/
}