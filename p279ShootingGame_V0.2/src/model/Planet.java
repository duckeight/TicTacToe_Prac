package model;

/**
 * �༺�� �̱����Դϴ�
 * �ʿ��� ������ �ҷ��� Ȱ���Ͻʽÿ�
 * @author dudwn
 *
 */
public class Planet {
	private static Planet theInstance = new Planet(); 
	
	private double gravity = 9.8d; 	//������ ������ meter/sec�� ���� double
	
	private double surface = 0.0d;	//��ǥ���� ���� ���߿� �������� �� ���� ���̰�, ������ ����
	
	private Cannon cannon = null;
	private Bullet bullet = null;
	private Target target = null;
	
	private Planet() {
	}
	
	public static Planet getTheInstance() {
		return theInstance;
	}

	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
