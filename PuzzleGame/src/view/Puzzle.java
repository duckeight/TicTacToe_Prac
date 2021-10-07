package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Puzzle extends JFrame implements ActionListener {
	public MyButton[] buttons;
	public JButton reset;
	public Puzzle() {
		super("puzzle");
		this.setSize(300, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//reset��ư ����
		JButton reset = new JButton("reset");
		reset.setBackground(Color.YELLOW);
		reset.setForeground(Color.RED);
		
		//Panel ����
		//Panel�� (0, 3, 2, 2) GridLayout
		JPanel panel = new JPanel(new GridLayout(0, 3, 2, 2));
		
		//Button 3 x 3 �� index 0���� 9���� ����� panel�� ����
		buttons = new MyButton[9];
		//���ڴ� 1���� 8����, ���� �ϳ�����
		for (int i = 0; i < 9; i++) {
			if(i < 8) {
				buttons[i] = new MyButton("" + (i + 1));
			} else {
				buttons[i] = new MyButton(" ");
			}
		}
		
		//�� button�� ������ ��, ���� ��ĭ�� ������ ���� ��ư�� ��ĭ�� �ڸ��� �ٲ۴�
		for (int i = 0; i < 9; i++) {
			buttons[i].addActionListener(this);
		}

		//panel�� buttons ���
		for (MyButton btn : buttons) {
			panel.add(btn);
		}
		//Panel�� panel�� center�� ���
		this.add(panel, BorderLayout.CENTER);
		//reset��ư frame�� borderlayout�� south�� ���
		this.add(reset, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String numInPuzzle = e.getActionCommand();
		//���� �̺�Ʈ�� ���� String�� 1�̸�, 1 ���� boards[1]�� boards[3]�� �������� �Ǵ�
		//�´ٸ� 1�� �ش� ĭ�� �ٲ�
		//�ƴϸ� �׳� return
		//�̰� �� �� �����ϰ� �� ���??
	}

	public static void main(String[] args) {
		new Puzzle();
	}

}

class MyButton extends JButton {
	static int count = 0; //static?
	int index;
	public MyButton(String s){
		super(s);
		index = count++;
	}
}
