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
