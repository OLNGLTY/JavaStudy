public class Student{
	String name;//������
	int age;//��������
	int shiSu��
	String shiZhongDian;
	//������
	public Student(){
	
	}
	//������
	public Student(String name,int age,char sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	//���ҽ���
	public void shuchu(){
		System.out.println("�ҽ�"+name+"���Ա�"+sex+",����"+age+"�꣡");
	}
	//״̬
	public void chi(){
		System.out.println(name+"�ڳԷ���");
	}
	public void wan(){
		System.out.println(name+"������Ϸ��");
	}
	public void yundong(){
		System.out.println(name+"���˶���");
	}
}