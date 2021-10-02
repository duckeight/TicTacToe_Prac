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
}
