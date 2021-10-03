package model;

public class Thing {
	// ��ġ ������ ������ meter�� ����, ��ȿ���ڴ� ��꿡�� Ȱ���ϴ� Math���� �ַ� �����ϴ� double�� ����
	private double xPos; // ���� ��ġ
	private double yPos; // ���� ��ġ

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
	
	//xPos += initSpeed * cos(�߻簢�� rad) * sec
	//yPos += initSpeed * sin(�߻簢�� rad) * sec - 9.8 * sec / 2 - > thing�� �޼ҵ� ����
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
