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
		
		//reset버튼 생성
		JButton reset = new JButton("reset");
		reset.setBackground(Color.YELLOW);
		reset.setForeground(Color.RED);
		
		//Panel 생성
		//Panel은 (0, 3, 2, 2) GridLayout
		JPanel panel = new JPanel(new GridLayout(0, 3, 2, 2));
		
		//Button 3 x 3 개 index 0에서 9까지 만들어 panel에 담음
		buttons = new MyButton[9];
		//각 칸에 숫자와 공백 caption 생성
		for (int i = 0; i < 9; i++) {
			if(i < 8) {	//숫자는 1에서 8까지
				buttons[i] = new MyButton("" + (i + 1));
			} else {	//마지막일 때는 공백 하나생성
				buttons[i] = new MyButton(" ");
			}
			//각 button을 눌렀을 때, 옆에 빈칸이 있으면 누른 버튼과 빈칸의 자리를 바꾼다
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}

		//Panel은 panel에 center로 담기
		this.add(panel, BorderLayout.CENTER);
		//reset버튼 frame에 borderlayout의 south로 담기
		this.add(reset, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	//frame에서 이벤트 처리하기!
	/**
	 * 숫자가 적힌 칸을 클릭하면 그 주변에 존재하는 빈칸과 자리를 바꿔준다
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton justClickedButton = (MyButton) e.getSource();
		//클릭한 칸이 공백이면 아무것도 안 하고 그냥 return
		if (justClickedButton.getText().equals(" ")) {
			return;
		}
		//만약 이벤트로 받은 칸 주변에 빈칸이 있으면, 이웃한 칸이 빈칸인지 찾고 빈칸이면 서로 바꿔준다
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
		//이걸 좀 더 간단하게 할 방법??
	}

	public static void main(String[] args) {
		new Puzzle();
	}
}

class MyButton extends JButton {
	//이 클래스 내부에서만 쓸 것이기 때문에 private; static?
	private static int count = 0;
	//처음에 만들 때 다 private로
	protected int index;
	protected MyButton(String caption){
		//button caption을 처리하면서도 버튼 내부적으로 id를 기억시켜 놓음
		//나중에 buttons[number].index로 불러올 수 있음
//		super(s);
		this.setText(caption);
		index = count++;
	}
}
