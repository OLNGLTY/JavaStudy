public class Triangle extends AreaPerimeter{
	private double a;//��
	private double b;//��
	private double c;//�ױ�
	private double h;//��
	public Triangle(){
	}
	public Triangle(double a,double b,double c,double h){
		this.a=a;
		this.b=b;
		this.c=c;
		this.h=h;
	}
	//���
	public double area(){
		return h*max(a,max(b,c))/2;
	}
	//�ܳ�
	public double perimeter(){
		return a+b+c;
	}
	//���ֵ
	public double max(double a,double b){
		return a > b ? a : b;
	}
}