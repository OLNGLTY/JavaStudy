public class SanDeBeiShu{
	public static void main(String[] args){
		int a=0;
		System.out.print("\n100����3�ı�����������:\n");
		for(int i=0;i<101;i++){
			if(i%3==0){
				a++;
				System.out.print(i+"\t");
			}
		}
		System.out.print("\n100����3�ı�����������"+a+"��!\n\n");
	}
}