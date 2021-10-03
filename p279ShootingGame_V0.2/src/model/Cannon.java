package model;

import java.util.Scanner;

public class Cannon extends Thing {

	//발사 각도의 유효 범위
	private static final int MIN_DEGREE = 10, MAX_DEGREE = 70;
	
	private static Scanner in = new Scanner(System.in);
	
	private int initSpeed;	//발사 속도 정보의 단위는 meter/sec를 쓰고, int
	
	private int shootingDegree; //발사 각도 정보의 단위는 degree를 쓰고, int

	//관계 속성
	private Bullet bullet = null;
	
	public Cannon(int intSpeed, double xPos, double yPos) {
		super(xPos, yPos);
		this.initSpeed = initSpeed;
	}

	public void load(Bullet bullet) {
		//포에 장전하면 포탄의 위치는 포의 위치가 된다
		bullet.copyLoc(this);
		this.bullet = bullet;
	}

	public void shootBullet(Bullet bullet) {
		//발사 각도 입력 받음
		this.shootingDegree = in.nextInt();
		double radianDegree = Math.toRadians(shootingDegree);
		//bullet이 발사됨 -> xPos와 yPos 변화
		int sec = 0;
		bullet.move(initSpeed, radianDegree, sec++);	//yPos가 0이 될때까지 sec++ 해준다
	}
}
