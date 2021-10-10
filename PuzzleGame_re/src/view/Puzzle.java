package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Puzzle extends JFrame {
	private static final int ROOT = 3;
	protected Mybutton[][] buttons;
	
	public Puzzle() {
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("���� ����");
		
		//3 x 3 ����� ĭ���� ���� �г��� ���� ��ư�� �־��� ��
		JPanel panel = new JPanel(new GridLayout(0, 3, 2, 2));
		buttons = new Mybutton[ROOT][ROOT];
		JButton reset = new JButton("reset");
		reset.setForeground(Color.RED);
		reset.setBackground(Color.YELLOW);
		
		//3 x 3 ���� ��ư�� �����Ͽ� ������ �� �̺�Ʈ�� �޴� �����ʸ� �����ϰ�, �гο� ����ش�
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				buttons[row][col] = new Mybutton(row, col);
				buttons[row][col].addActionListener(new numberInButton());
				panel.add(buttons[row][col]);
			}
		}

		setCaption(buttons);
		reset.addActionListener(new resetPuzzle());
		
		this.add(panel, BorderLayout.CENTER);
		this.add(reset, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	//9���� ��ư�� 1���� 8����, �׸��� ������ ���� �޼ҵ�
	public void setCaption(Mybutton[][] buttons) {
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				if (row == ROOT - 1 && col == ROOT - 1) {
					buttons[row][col].setText(" ");
				} else {
					buttons[row][col].setText("" + (row * ROOT + col + 1));
				}
			}
		}
	}

	protected boolean isInBounds(int proving) {
		return proving >= 0 && proving < ROOT;
	}
	
	class numberInButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Mybutton btn = (Mybutton) e.getSource();
			if (btn.getText() == " ") {
				return;
			}
			
			//��ư�� ������ �ֺ��� ��ĭ(���� ĸ���� ���� ĭ)�� �ִ��� Ȯ���ϰ�, ������ �� ĭ�� �ڸ��� �ٲ۴�
			//��, ��, ��, �� �� ���⿡ ���� �ش� ĭ�� array ���� ���� �ִ��� Ȯ��, ������ �ݺ��� Ż��
			for (Direction direc : Direction.values()) {
				int provingRId = btn.rid + direc.getRowDelta();
				int provingCId = btn.cid + direc.getColDelta();
				//�ش� ĭ�� ���� �ۿ� �ִٸ� �ݺ��� Ż��, ���� direc ���캽
				if (!isInBounds(provingRId)) {
					continue;
				}
				if (!isInBounds(provingCId)) {
					continue;
				}
				//Ž���� ĭ�� �����̶�� Ŭ���� ĭ�� �ڸ��� �ٲ��ش�
				if (buttons[provingRId][provingCId].getText() == " ") {
					buttons[provingRId][provingCId].setText(btn.getText());
					btn.setText(" ");
				}
				
			}
		}
	}
	
	class resetPuzzle implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clickedButton = (JButton) e.getSource();
			if(clickedButton.getText() == "reset") {
				setCaption(buttons);
			}
		}
	}
	
	public static void main(String[] args) {
		new Puzzle();
	}
}

class Mybutton extends JButton {
	protected int rid, cid;
	
	public Mybutton(int row, int col) {
		this.rid = row;
		this.cid = col;
	}
}