public class Phone{
	private String name;//�ֻ�����
	private String color;//��ɫ
	private String brand;//Ʒ��
	SIM sim;//��
	public Phone(){
	
	}
	public Phone(String name,String color,String brand,SIM sim){
		this.name=name;
		this.color=color;
		this.brand=brand;
		this.sim=sim;
	}
	//�ֻ�����
	public String setName(){
		return this.name;
	}
	public void getName(String name){
		this.name=name;
	}
	//��ɫ
	public String setColor(){
		return this.color;
	}
	public void getColor(String color){
		this.color=color;
	}
	//Ʒ��
	public String setBrand(){
		return this.brand;
	}
	public void getBrand(String brand){
		this.brand=brand;
	}
}