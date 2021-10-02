package model;

public class Bullet extends Thing {
	private double xSpeed;	//정보의 단위는 meter/sec를 쓰고, double
	private double ySpeed;	//정보의 단위는 meter/sec를 쓰고, double
	
	public Bullet() {
		super(0, 0);
	}
}
