package model;

public class Target extends Thing {
	private int xSpeed;	//정보의 단위는 meter/sec를 쓰고, double
	private int ySpeed;	//정보의 단위는 meter/sec를 쓰고, double
	
	public Target(double xPos, double yPos) {
		super(xPos, yPos);
	}
}
