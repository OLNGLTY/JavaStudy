package com01;

import java.util.*;



public class StuFunction {
	public static Scanner sc = new Scanner(System.in);
	public static MyComparetor mc = new MyComparetor();
	public static TreeSet<Student> alStu = new TreeSet<Student>(mc);
	//�˵�
	public void menu(){
		
	};
	//ע��
	public void enter(){
		alStu.add(new Student(1,"zhao",17));
		alStu.add(new Student(2,"qing",16));
		alStu.add(new Student(3,"hai",18));
		alStu.add(new Student(4,"qing",14));
		alStu.add(new Student(5,"hai",13));
		System.out.print("ѧ�ţ�");
		int sId = Number();
		System.out.print("������");
		String sName = sc.next();
		System.out.print("���䣺");
		int sAge = Number();
		alStu.add(new Student(sId,sName,sAge));
	}
	//��ӡѧ����Ϣ
	public void printStu(){
		System.out.println("ѧ�ţ�\t������\t���䣺\t");
		Iterator<Student> i = alStu.iterator();
		while(i.hasNext()){
			Student s = (Student)i.next();
			String str = s.toString();
			System.out.println(str);
		}
	}
	public static int Number(){
		String str = sc.next();
		try{
			return Integer.parseInt(str);
		}catch (Exception e) {
			System.out.println("������������");
		}
		return Number();
	}
}
