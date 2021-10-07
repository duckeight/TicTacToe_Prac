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
		
		//reset버튼 생성
		JButton reset = new JButton("reset");
		reset.setBackground(Color.YELLOW);
		reset.setForeground(Color.RED);
		
		//Panel 생성
		//Panel은 (0, 3, 2, 2) GridLayout
		JPanel panel = new JPanel(new GridLayout(0, ROOT, 2, 2));
		
		//Button 3 x 3 개 index 0에서 9까지 만들어 panel에 담음
		buttons = new MyButton[ROOT][ROOT];
		//숫자는 1에서 8까지, 공백 하나생성
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
	
		
		//Panel은 panel에 center로 담기
		this.add(panel, BorderLayout.CENTER);
		//reset버튼 frame에 borderlayout의 south로 담기
		this.add(reset, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton justClickedButton = (MyButton) e.getSource();
		if (justClickedButton.getText() == " ") {
			return;
		}
		// sysout 대신 popup 방식으로 디버깅용 정보 출력 방법
		// JOptionPane.showMessageDialog(null, justClickedButton.toString());
		for (Direction dir : Direction.values()) {
			//클릭한 칸 주변 4곳의 칸 찾기
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
	 * ArrayOutOfBound 예외가 발생하지 않도록 검사 기능 수행
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
