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
		
		//reset버튼 생성
		JButton reset = new JButton("reset");
		reset.setBackground(Color.YELLOW);
		reset.setForeground(Color.RED);
		
		//Panel 생성
		//Panel은 (0, 3, 2, 2) GridLayout
		JPanel panel = new JPanel(new GridLayout(0, 3, 2, 2));
		
		//Button 3 x 3 개 index 0에서 9까지 만들어 panel에 담음
		buttons = new MyButton[9];
		//숫자는 1에서 8까지, 공백 하나생성
		for (int i = 0; i < 9; i++) {
			if(i < 8) {
				buttons[i] = new MyButton("" + (i + 1));
			} else {
				buttons[i] = new MyButton(" ");
			}
		}
		
		//각 button을 눌렀을 때, 옆에 빈칸이 있으면 누른 버튼과 빈칸의 자리를 바꾼다
		for (int i = 0; i < 9; i++) {
			buttons[i].addActionListener(this);
		}

		//panel에 buttons 담기
		for (MyButton btn : buttons) {
			panel.add(btn);
		}
		//Panel은 panel에 center로 담기
		this.add(panel, BorderLayout.CENTER);
		//reset버튼 frame에 borderlayout의 south로 담기
		this.add(reset, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String numInPuzzle = e.getActionCommand();
		//만약 이벤트로 받은 String이 1이면, 1 옆의 boards[1]과 boards[3]이 공백인지 판단
		//맞다면 1과 해당 칸을 바꿈
		//아니면 그냥 return
		//이걸 좀 더 간단하게 할 방법??
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
