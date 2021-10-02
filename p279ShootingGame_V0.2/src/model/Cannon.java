package model;

public class Cannon extends Thing {

	//�߻� ������ ��ȿ ����
	private static final int MIN_DEGREE = 10, MAX_DEGREE = 70;
	
	private int initSpeed;	//�߻� �ӵ� ������ ������ meter/sec�� ����, int
	
	private int shootingDegree; //�߻� ���� ������ ������ degree�� ����, int

	//���� �Ӽ�
	private Bullet bullet = null;
	
	public Cannon(int intSpeed, double xPos, double yPos) {
		super(xPos, yPos);
		this.initSpeed = initSpeed;
	}

	public void load(Bullet bullet) {
		//���� �����ϸ� ��ź�� ��ġ�� ���� ��ġ�� �ȴ�
		bullet.copyLoc(this);
		this.bullet = bullet;
	}
}
