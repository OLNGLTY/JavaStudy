package zuoye0508_2;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Test01{
	JFrame win1 = null;//����
	JMenuBar bar = null;//�˵���
	JMenu jMenu = null;//�˵�
	JMenuItem item1 = null;//�˵���
	JMenuItem item2 = null;//�˵���
	JMenuItem item3 = null;//�˵���
	JTextArea jTextArea = null;//�ı��༭

	File f1 = null;//�ļ�1
	public Test01(){
		//����
		win1 = new JFrame("�ͻ���");
		win1.setTitle("�ͻ���");
		win1.setLayout(new BorderLayout());
		//�˵�
		bar = new JMenuBar();
		bar.setBackground(new Color(255, 255, 255));
		jMenu = new JMenu("�ļ�");
		item1 = new JMenuItem("�½�");
		item2 = new JMenuItem("��");
		item3 = new JMenuItem("����");
		win1.setJMenuBar(bar);
		bar.add(jMenu);
		jMenu.add(item1);
		jMenu.add(item2);
		jMenu.add(item3);
		
		//�ı��༭
		jTextArea = new JTextArea();
		jTextArea.setBounds(0, 0, 500, 450);
		win1.add(jTextArea);
		
		//��ӹ���
		/**
		 * �½�
		 */
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = JOptionPane.showInputDialog("�������ļ�����"); 
				if(s.equals("")||s.equals(null)){
					s="�½��ı��ĵ�";
				}
				f1 = new File(s+".txt");
				if(!f1.exists()){
					try {
						f1.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				//����ı��༭��
				jTextArea.setText("");
				
			
			}
		};
		item1.addActionListener(al);
		/**
		 * ��
		 */
		ActionListener al2 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//ͨ��·�����ļ�
					while(true){
						String s = JOptionPane.showInputDialog("�������ļ�·����"); 
						f1 = new File(s);
						if(f1.exists()){
							if(f1.isFile()){
								break;
							}else{
								s = "����һ���ļ���" + s;
							}
						}else{
							s = "û�д��ļ���"+s;
						}
					}
					
					FileInputStream fr = new FileInputStream(f1);
					byte[] bytes = new byte[1024];
					int len = 0;
					StringBuffer sb = new StringBuffer();
					while((len = fr.read(bytes))!=-1){
						sb.append(new String(bytes,0,len));
					}
					jTextArea.setText(sb.toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		item2.addActionListener(al2);
		
		/**
		 * ����
		 */
		ActionListener al3 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����
				try {
					FileWriter fw = new FileWriter(f1);
					fw.write(jTextArea.getText());
					fw.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		item3.addActionListener(al3);
		
		
		win1.setBounds(0, 0, 500, 450);
		win1.setVisible(true);

	}

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		new Test01();
	}
}
