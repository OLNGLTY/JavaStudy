package com.dazhi;
abstract class Car {
	private String name;//����
	private int zaiKe;//�ؿ������ˣ�
	private int zaiHuo;//�ػ������֣�
	private double rent;//���Ԫ/�죩
	//���췽��
	public Car(){
		
	}
	public Car(String name,int zaiKe,int zaiHuo,double rent){
		this.name=name;
		this.zaiKe=zaiKe;
		this.zaiHuo=zaiHuo;
		this.rent=rent;
	}
	/**
	 * ���������Ϣ
	 */
	public void printCarInfo(){
		System.out.printf("| %s\t| %s\t\t| %s\t\t| %s\t\t\n",name,zaiKe==0?" ":zaiKe,zaiHuo==0?"�����ػ�":zaiHuo,rent);
	}
	/**
	 * ���������Ϣ���ַ�����
	 */
//	public String toString(){
//		System.out.println(zaiKe==0?" ":zaiKe);
//		return ""+this.name+"\t"+zaiKe==0?"":zaiKe+"\t";
//	}
	//getter and setter
	/**
	 * ����
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * �ؿ������ˣ�
	 * @return
	 */
	public int getZaiKe() {
		return zaiKe;
	}
	public void setZaiKe(int getzaiKe) {
		this.zaiKe = getzaiKe;
	}
	/**
	 * �ػ������֣�
	 * @return
	 */
	public int getZaiHuo() {
		return zaiHuo;
	}
	public void setZaiHuo(int zaiHuo) {
		this.zaiHuo = zaiHuo;
	}
	/**
	 * ���Ԫ/�죩
	 * @return
	 */
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	

}
