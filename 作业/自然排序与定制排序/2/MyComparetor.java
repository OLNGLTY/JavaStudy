package com01;

/**
 * ��������
 *    ��һ�����Զ���һ�������������ʵ��Comparator�ӿ�
 *    �ڶ�������дcompare()������return ��������0;
 */
import java.util.Comparator;

public class MyComparetor implements Comparator{
	public int compare(Object o1,Object o2){
		if(o1 instanceof Student && o2 instanceof Student){
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			return s2.getId()-s1.getId();
		}
		return 0;
	}
}
