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

public class Puzzle extends JFrame implements ActionListener {
	protected static final int ROOT = 4;
	protected static final String EMPTY_CELL_CAPTION = "*";
	
	public MyButton[][] buttons;
	
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
		JPanel panel = new JPanel(new GridLayout(0, ROOT, 2, 2));
		
		//Button 3 x 3 �� index 0���� 9���� ����� panel�� ����
		buttons = new MyButton[ROOT][ROOT];
		//���ڴ� 1���� 8����, ���� �ϳ�����
		for (int row = 0; row < ROOT; row++) {
			for (int col = 0; col < ROOT; col++) {
				if (row == ROOT - 1 && col == ROOT - 1) {
					buttons[row][col] = new MyButton(EMPTY_CELL_CAPTION);
				} else {
					buttons[row][col] = new MyButton("" + (row * ROOT + col + 1));
				}
				panel.add(buttons[row][col]);
				buttons[row][col].addActionListener(this);
			}
		}
	
		
		//Panel�� panel�� center�� ���
		this.add(panel, BorderLayout.CENTER);
		//reset��ư frame�� borderlayout�� south�� ���
		this.add(reset, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton justClickedButton = (MyButton) e.getSource();
		if (justClickedButton.getText() == " ") {
			return;
		}
		// sysout ��� popup ������� ������ ���� ��� ���
		// JOptionPane.showMessageDialog(null, justClickedButton.toString());
		for (Direction dir : Direction.values()) {
			//Ŭ���� ĭ �ֺ� 4���� ĭ ã��
			int provingRId = justClickedButton.rid + dir.getRowDelta();
			int provingCId = justClickedButton.cid + dir.getColDelta();
			if (!isSafeArrayIndex(provingRId)) {
				continue;
			}
			if (!isSafeArrayIndex(provingCId)) {
				continue;
			}
			if (buttons[provingRId][provingCId].getText().equals(EMPTY_CELL_CAPTION)) {
				buttons[provingRId][provingCId].setText(justClickedButton.getText());
				justClickedButton.setText(EMPTY_CELL_CAPTION);
			}
		}
	}

	/**
	 * ArrayOutOfBound ���ܰ� �߻����� �ʵ��� �˻� ��� ����
	 * @param provingRId
	 * @return
	 */
	protected boolean isSafeArrayIndex(int provingRId) {
		return provingRId >= 0 && provingRId < ROOT;
	}

	public static void main(String[] args) {
		new Puzzle();
	}

}

class MyButton extends JButton {
	static int count = 0; //static?
	
	int rid, cid;
	
	public MyButton(String s){
		super(s);
		int c = count++;
		rid = c / Puzzle.ROOT;
		cid = c % Puzzle.ROOT;
	}
	
	@Override
	public String toString() {
		return "MyButton [rid=" + rid + ", cid=" + cid + "]";
	}
}
