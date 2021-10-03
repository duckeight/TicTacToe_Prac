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
		return this.xPos == other.xPos;
	}
	
	//xPos += initSpeed * cos(발사각도 rad) * sec
	//yPos += initSpeed * sin(발사각도 rad) * sec - 9.8 * sec / 2 - > thing에 메소드 생성
	public void move(int initSpeed, double radianDegree, int sec) {
		Planet planet = Planet.getTheInstance();
		double xMove = initSpeed * Math.cos(radianDegree) * sec;
		double yMove = initSpeed * Math.sin(radianDegree) * sec - planet.getGravity() * sec / 2;
		do {
			this.xPos += xMove;
			this.yPos += yMove;
			sec += 1;
		} while (this.yPos != planet.getSurface());
	}
}
