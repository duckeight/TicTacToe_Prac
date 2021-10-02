package model;

public class Thing {
	// 위치 정보의 단위는 meter를 쓰고, 유효숫자는 계산에서 활용하니 Math에서 주로 지원하는 double로 정함
	private double xPos; // 수평 위치
	private double yPos; // 수평 위치

	public Thing(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void copyLoc(Thing other) {
		this.xPos = other.xPos;
		this.yPos = other.yPos;
	}
}
