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
	private MyButton[] buttons;
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
		//�� ĭ�� ���ڿ� ���� caption ����
		for (int i = 0; i < 9; i++) {
			if(i < 8) {	//���ڴ� 1���� 8����
				buttons[i] = new MyButton("" + (i + 1));
			} else {	//�������� ���� ���� �ϳ�����
				buttons[i] = new MyButton(" ");
			}
			//�� button�� ������ ��, ���� ��ĭ�� ������ ���� ��ư�� ��ĭ�� �ڸ��� �ٲ۴�
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}

		//Panel�� panel�� center�� ���
		this.add(panel, BorderLayout.CENTER);
		//reset��ư frame�� borderlayout�� south�� ���
		this.add(reset, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	//frame���� �̺�Ʈ ó���ϱ�!
	/**
	 * ���ڰ� ���� ĭ�� Ŭ���ϸ� �� �ֺ��� �����ϴ� ��ĭ�� �ڸ��� �ٲ��ش�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton justClickedButton = (MyButton) e.getSource();
		//Ŭ���� ĭ�� �����̸� �ƹ��͵� �� �ϰ� �׳� return
		if (justClickedButton.getText().equals(" ")) {
			return;
		}
		//���� �̺�Ʈ�� ���� ĭ �ֺ��� ��ĭ�� ������, �̿��� ĭ�� ��ĭ���� ã�� ��ĭ�̸� ���� �ٲ��ش�
		//index�� ù��° col(0, 3, 6)�̸� +1 ĭ �˻�
		if (justClickedButton.index % 3 == 0) {
			exchange(buttons[justClickedButton.index + 1], justClickedButton);
		} else if (justClickedButton.index % 3 == 1) {
			//index�� �ι�° col(1, 4, 7)�̸� -1, +1 ĭ �˻�
			exchange(buttons[justClickedButton.index - 1], justClickedButton);
			exchange(buttons[justClickedButton.index + 1], justClickedButton);
		} else if (justClickedButton.index % 3 == 2) {
			//index�� ����° col(2, 5, 8)�̸� -1 ĭ �˻�
			exchange(buttons[justClickedButton.index - 1], justClickedButton);
		}
		
		if (justClickedButton.index > 3) {
			//index�� ù��° row(0, 1, 2)�̸� +3 ĭ �˻�
			exchange(buttons[justClickedButton.index + 3], justClickedButton);
		} else if (justClickedButton.index > 2 && justClickedButton.index < 6) {
			//index�� �ι�° row(3, 4, 5)�̸� -3, +3 ĭ �˻�
			exchange(buttons[justClickedButton.index - 3], justClickedButton);
			exchange(buttons[justClickedButton.index + 3], justClickedButton);
		} else if (justClickedButton.index > 5) {
			//index�� ����° row(6, 7, 8)�̸� -3 ĭ �˻�
			exchange(buttons[justClickedButton.index - 3], justClickedButton);
		}
			//��ĭ�̸� ���� �ٲ��ش�
			
		//�̰� �� �� �����ϰ� �� ���??
	}

	protected void exchange(MyButton button, MyButton justClickedButton) {
		if (button.equals(" ")) {
			button.setText(justClickedButton.getText());
			justClickedButton.setText(" ");
		}
	}

	public static void main(String[] args) {
		new Puzzle();
	}
}

class MyButton extends JButton {
	//�� Ŭ���� ���ο����� �� ���̱� ������ private; static?
	private static int count = 0;
	//ó���� ���� �� �� private��
	protected int index;
	protected MyButton(String caption){
		//button caption�� ó���ϸ鼭�� ��ư ���������� id�� ������ ����
		//���߿� buttons[number].index�� �ҷ��� �� ����
//		super(s);
		this.setText(caption);
		index = count++;
	}
}
