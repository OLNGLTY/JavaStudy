import java.util.Scanner;
public class ZuoYe{
	public static void main(String[] args){
		ShouJi sj = new ShouJi();
		sj.xinxi();
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		Student[] students = new Student[10];
		Student student1 = new Student("���캣",17,'��');
		students[0]=student1;
		Student student2 = new Student();
		students[1]=student2;
		student2.name="���캣";
		student2.age=19;
		student2.sex='Ů';
		System.out.println(Student.num);
		for(int i=0;i<2;i++){
			students[i].chi();
			students[i].wan();
			students[i].yundong();
		}
		
	}
}