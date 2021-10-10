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
		this.setTitle("퍼즐 게임");
		
		//3 x 3 모양의 칸으로 나뉜 패널을 만들어서 버튼을 넣어줄 것
		JPanel panel = new JPanel(new GridLayout(0, 3, 2, 2));
		buttons = new Mybutton[ROOT][ROOT];
		JButton reset = new JButton("reset");
		reset.setForeground(Color.RED);
		reset.setBackground(Color.YELLOW);
		
		//3 x 3 개의 버튼을 생성하여 눌렀을 때 이벤트를 받는 리스너를 생성하고, 패널에 담아준다
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

	//9개의 버튼에 1부터 8까지, 그리고 공백을 적는 메소드
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
			
			//버튼을 누르면 주변에 빈칸(공백 캡션을 가진 칸)이 있는지 확인하고, 있으면 그 칸과 자리를 바꾼다
			//동, 서, 남, 북 각 방향에 대해 해당 칸이 array 범위 내에 있는지 확인, 없으면 반복문 탈출
			for (Direction direc : Direction.values()) {
				int provingRId = btn.rid + direc.getRowDelta();
				int provingCId = btn.cid + direc.getColDelta();
				//해당 칸이 범위 밖에 있다면 반복문 탈출, 다음 direc 살펴봄
				if (!isInBounds(provingRId)) {
					continue;
				}
				if (!isInBounds(provingCId)) {
					continue;
				}
				//탐색한 칸이 공백이라면 클릭한 칸과 자리를 바꿔준다
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