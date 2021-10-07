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
		if (justClickedButton.index == 0) {
			//1 3
			if (buttons[1].getText().equals(" ")) {
				buttons[1].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[3].getText().equals(" ")) {
				buttons[3].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 1) {
			//0 2 4
			if (buttons[0].getText().equals(" ")) {
				buttons[0].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[2].getText().equals(" ")) {
				buttons[2].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 2) {
			// 1 5
			if (buttons[1].getText().equals(" ")) {
				buttons[1].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[5].getText().equals(" ")) {
				buttons[5].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 3) {
			// 0 4 6
			if (buttons[0].getText().equals(" ")) {
				buttons[0].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[6].getText().equals(" ")) {
				buttons[6].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 4) {
			// 1 3 5 7
			if (buttons[1].getText().equals(" ")) {
				buttons[1].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[3].getText().equals(" ")) {
				buttons[3].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[5].getText().equals(" ")) {
				buttons[5].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[7].getText().equals(" ")) {
				buttons[7].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 5) {
			// 2 4 8
			if (buttons[2].getText().equals(" ")) {
				buttons[2].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[8].getText().equals(" ")) {
				buttons[8].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 6) {
			// 3 7
			if (buttons[3].getText().equals(" ")) {
				buttons[3].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[7].getText().equals(" ")) {
				buttons[7].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 7) {
			// 4 6 8
			if (buttons[4].getText().equals(" ")) {
				buttons[4].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[6].getText().equals(" ")) {
				buttons[6].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[8].getText().equals(" ")) {
				buttons[8].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} else if (justClickedButton.index == 8) {
			// 5 7
			if (buttons[5].getText().equals(" ")) {
				buttons[5].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			} else if (buttons[7].getText().equals(" ")) {
				buttons[7].setText(justClickedButton.getText());
				justClickedButton.setText(" ");
			}
		} 
		//�̰� �� �� �����ϰ� �� ���??
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
