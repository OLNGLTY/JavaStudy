
import java.util.Comparator;

public class MyComparator implements Comparator<Object>{
	public int compare(Object o1, Object o2) {  
        // ��compare�����У������Զ������x����ָ������x����һ�������������ж�������  
        //if(o1 instanceof Fruit && o2 instanceof Fruit)  
        Student f1 = (Student) o1;  
        Student f2 = (Student) o2;  
        if(f1.getScore()<f2.getScore()){
        	return 1;
        }
        if(f1.getScore() == f2.getScore()){
        	if(f1.getAge() < f2.getAge()){
        		return 1;
        	}
        	if(f1.getAge() == f2.getAge()){
        		return 0;
        	}
        	return -1;
        }
        return -1; 
    }
}
