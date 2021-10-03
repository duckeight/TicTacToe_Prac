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
	
	public boolean isSameLoc(Thing other) {
	 return isSameXPos(other) && isSameYPos(other);
	}
	
	public boolean isSameXPos(Thing other) {
		return this.xPos == other.xPos;
	}
	
	public boolean isSameYPos(Thing other) {
		return this.yPos == other.yPos;
	}
	
	public void move(double xMove, double yMove, int sec) {
		this.xPos += xMove;
		this.yPos += yMove;
	}
}
