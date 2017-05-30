package com.zhao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class KeHuDuan {
	static Socket socket = null;
	
	JFrame frame = null;//�������촰��
	JLabel jLabel_1 = null;//��ǩ1
	JTextArea jTextArea_1 = null;//��Ϣ���տ�
	JLabel jLabel_2 = null;//��ǩ2
	JButton button_1 = null;//��ʷ��¼
	JTextArea jTextArea_2 = null;//��Ϣ�༭��
	JButton button_2 = null;//�رմ���
	JButton button_3 = null;//���Ͱ�ť
	JButton button_4 = null;//����
	SQL sql = new SQL();
	public KeHuDuan(){
		window1();
	}
	public static void main(String[] args) {
		new KeHuDuan();
	}
	/**
	 * ���ӷ���������
	 */
	public void window1(){
		JFrame frame2 = new JFrame("���ӵ�Ⱥ��");
		frame2.setLayout(null);
		JLabel jLabel = new JLabel("�������ǳƣ�");
		jLabel.setFont(new Font("΢���ź�", 0, 20));
		JTextField field = new JTextField();
		JButton f2button_1 = new JButton("ȡ��");
		JButton f2button_2 = new JButton("����");
		jLabel.setBounds(60, 20, 200, 30);
		field.setBounds(60, 65, 200, 30);
		f2button_1.setBounds(60,110,80,25);
		f2button_2.setBounds(180,110,80,25);
		frame2.add(jLabel);
		frame2.add(field);
		frame2.add(f2button_1);
		frame2.add(f2button_2);
		frame2.setBounds(0,0,340,230);
		frame2.setVisible(true);
		//ȡ��(�˳�����)
		f2button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//�������
		f2button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//���ӷ�����
					socket = new Socket("192.168.199.120", 20000);
					int a = 0;
					if(field.getText().equals(null)||field.getText().equals("")){
						JOptionPane.showMessageDialog(null, "�سƲ���Ϊ�գ�", "��ʾ",0);
						return;
					}
					//������������ǳ�
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(field.getText()+"\n");
					printWriter.flush();
					//���շ�����������Ϣ
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					a = bufferedReader.read();
					if(a!=0){
						JOptionPane.showMessageDialog(null, "���ӳɹ���", "��ʾ",1);
					}else{
						JOptionPane.showMessageDialog(null, "�Ѵ��ڴ��سƣ�", "��ʾ",0);
						return;
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				window2();
				frame2.dispose(); 
			}
		});
		
		
	}
	
	/**
	 * ���촰��
	 */
	public void window2(){
		frame = new JFrame("Ⱥ��");
		frame.setLayout(null);
		//��ǩ1
		jLabel_1 = new JLabel("��Ϣ����");
		jLabel_1.setBounds(10, 10, 200, 25);
		frame.add(jLabel_1);
		//��Ϣ���մ���
		jTextArea_1 = new JTextArea();
		JScrollPane bar = new JScrollPane(jTextArea_1);
		bar.setBounds(10, 45, 430, 500);
		frame.add(bar);
		sql.select(jTextArea_1);
		//���ܷ�������Ϣ
		new Thread(new Runnable() {
			public void run() {
				//���շ�������������Ϣ
				while(true){
					try {
						String message = "";
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						message = bufferedReader.readLine();
						jTextArea_1.setText(jTextArea_1.getText()+"\n"+message);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}).start();
		
		//��ǩ2
		jLabel_2 = new JLabel("�༭��Ϣ");
		jLabel_2.setBounds(10, 555, 200, 25);
		frame.add(jLabel_2);
		//����
		button_4 = new JButton("����");
		button_4.setBounds(250, 555, 90, 25);
		frame.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextArea_1.setText("");
			}
		});
		//��Ϣ��¼
		button_1 = new JButton("��Ϣ��¼");
		button_1.setBounds(350, 555, 90, 25);
		frame.add(button_1);
		//����鿴��Ϣ��¼
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f3 = new JFrame("��Ϣ��¼");
				JTextArea area  = new JTextArea();
				JScrollPane pane = new JScrollPane(area);
				f3.add(pane);
				f3.setBounds(0, 0, 500, 500);
				f3.setVisible(true);
				//��ѯ
				sql.select(area);
			}
		});
		//�༭��Ϣ��
		jTextArea_2 = new JTextArea();
		jTextArea_2.setBounds(10,590,430,110);
		frame.add(jTextArea_2);
		//�ر����촰/�����ͻ���
		button_2 = new JButton("�ر�");
		button_2.setBounds(250, 710, 90, 25);
		frame.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//������Ϣ��ť
		button_3 = new JButton("����");
		button_3.setBounds(350, 710, 90, 25);
		frame.add(button_3);
		//������Ͱ�ť�������������Ϣ
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = jTextArea_2.getText();
				try {
					if(message.equals("")||message.equals(null)){
						return;
					}
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(jTextArea_2.getText()+"\n");
					printWriter.flush();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				jTextArea_2.setText("");
			}
		});
		
		
		frame.setBounds(0, 0, 470, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
