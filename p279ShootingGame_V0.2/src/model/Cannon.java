package model;

import java.util.Scanner;

public class Cannon extends Thing {

	//�߻� ������ ��ȿ ����
	private static final int MIN_DEGREE = 10, MAX_DEGREE = 70;
	
	private static Scanner in = new Scanner(System.in);
	
	private int initSpeed;	//�߻� �ӵ� ������ ������ meter/sec�� ����, int
	
	private int shootingDegree; //�߻� ���� ������ ������ degree�� ����, int

	//���� �Ӽ�
	private Bullet bullet = null;
	
	public Cannon(int initSpeed, double xPos, double yPos) {
		super(xPos, yPos);
		this.initSpeed = initSpeed;
	}

	public void load(Bullet bullet) {
		//���� �����ϸ� ��ź�� ��ġ�� ���� ��ġ�� �ȴ�
		bullet.copyLoc(this);
		this.bullet = bullet;
	}

	public void shootBullet(Bullet bullet) {
		//�߻� ���� �Է� ����
		this.shootingDegree = in.nextInt();
		double radianDegree = Math.toRadians(shootingDegree);
		//bullet�� �߻�� -> xPos�� yPos ��ȭ
		int sec = 0;
		//�ʱ� �ӵ��� ���� �ʴ� x�� y�� �̵�
		Planet planet = Planet.getTheInstance(); 
		double xMove = planet.calcXMoveInPlanet(initSpeed, radianDegree, sec);
		double yMove = planet.calcYMoveInPlanet(initSpeed, radianDegree, sec);
		//cannon�� y���� ���� ������ �����δ�
		do {
			bullet.move(xMove, yMove, sec++);
		} while (bullet.isSameYPos(this));
	}
}
