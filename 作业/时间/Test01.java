import java.text.*;
import java.util.*;

public class Test01 {
	public static void main(String[] args){
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		SimpleDateFormat sdf2 = new SimpleDateFormat("Hʱm��s��");
		System.out.println(sdf2.format(date.getTime()));
		//��ʽ��
		//Date date2 = getDate(strDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��M��d�� 00ʱ00��00��");
		//ʱ��ת�����ַ���
		String strDate = sdf.format(date);
		System.out.println("��ǰ����Ϊ��"+strDate);
		String strDate2 = "12ʱ10��30��";
		try {
			//�ַ���ת����ʱ��
			Date date2 = sdf2.parse(strDate2);
			System.out.println(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		System.out.println("������"+year);
		int a = Integer.parseInt("21");
		System.out.println(a);
	}
}


