package Test01;
public class Car {
	private int id;//���
	private String name;//����
	private int zaiKe;//�ؿ������ˣ�
	private int zaiHuo;//�ػ������֣�
	private double rent;//���Ԫ/�죩
	//���췽��
	public Car(){
		
	}
	public Car(int id,String name,int zaiKe,int zaiHuo,double rent){
		this.id=id;
		this.name=name;
		this.zaiKe=zaiKe;
		this.zaiHuo=zaiHuo;
		this.rent=rent;
	}
	/**
	 * ���������Ϣ
	 */
	public void printCarInfo(){
		String str = "�����ػ�";
		System.out.printf("| %s\t| %s\t| %s\t\t| %s\t\t| %s\t\t\n",id,name,zaiKe,zaiHuo==0?str:zaiHuo,rent);
	}
	//getter and setter
	/**
	 * ���
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
