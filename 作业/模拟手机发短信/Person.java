public class Person{
	private String name;//����
	private char sex;//�Ա�
	private int age;//����
	Phone phone;//�ֻ�
	//������
	public Person(){
	
	}
	public Person(String name,char sex,int age,Phone phone){
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.phone=phone;
	}
	public void com(){
		phone.sim.SIMcom();
	}
	//����
	public String setName(){
		return this.name;
	}
	public void getName(String name){
		this.name=name;
	}
	//�Ա�
	public char setSex(){
		return this.sex;
	}
	public void getSex(char sex){
		this.sex=sex;
	}
	//����
	public int setAge(){
		return this.age;
	}
	public void gerAge(int age){
		this.age=age;
	}
}