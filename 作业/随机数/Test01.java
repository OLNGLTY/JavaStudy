package zuoye0508_1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Test01 extends JFrame{
	static boolean flag = true;
	int a=0;
	public Test01(){
		this.setLayout(null);
		//����
		this.setTitle("�����");
		//�����
		JLabel jLabel = new JLabel();
		jLabel.setText("��ȡ�����");
		jLabel.setBounds(40,30,100,20);
		this.add(jLabel);
		
		//�������
		JTextArea textArea = new JTextArea();
		textArea.setText("");
		textArea.setBounds(40,60,100,20);
		this.add(textArea);
		
		//�û�����
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("�û����룺");
		jLabel2.setBounds(40, 90, 100, 20);
		this.add(jLabel2);
		//�û������
		JTextArea textArea2 = new JTextArea();
		textArea2.setText("");
		textArea2.setBounds(40, 120, 100, 20);
		this.add(textArea2);
		
		//��ť
		JButton jButton = new JButton();
		jButton.setText("��ʼ");
		jButton.setBounds(40, 150, 70, 20);
		jButton.setBackground(new Color(255,255,0));
		
		/**
		 * ���̻߳�ȡ�����
		 */
		
		//�����ʼ
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Runnable() {
					public void run() {
						synchronized (jButton) {
							while(flag){
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								textArea.setText((int)(Math.random()*3+1)+"");
							}
						}
					}
				});
				t.start();
				//��ȡ��ťvalueֵ
				String value = jButton.getText();
				//����
				if(value.equals("��ʼ")){
					flag = true;
					jButton.setText("����");
				}else if(value.equals("����")){
					flag = false;
					jButton.setText("��ʼ");
					synchronized (jButton) {
						//�ж��Ƿ����û������һ��
						if(textArea.getText().equals(textArea2.getText())){
							System.out.println("��ϲ��¶��ˣ�");
						}else{
							System.out.println("��Ǹ���´��ˣ�");
						}
					}
					
				}
				
				
			}
		};
		jButton.addActionListener(al);
		//��ӵ�������
		this.add(jButton);
		

		this.setBounds(20, 20, 350, 300);
		this.setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new Test01();
	}

}

