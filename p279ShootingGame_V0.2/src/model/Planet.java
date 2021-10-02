package model;

/**
 * 행성은 싱글톤입니다
 * 필요할 때마다 불러서 활용하십시오
 * @author dudwn
 *
 */
public class Planet {
	private static Planet theInstance = new Planet(); 
	
	private double gravity = 9.8d; 	//정보의 단위는 meter/sec를 쓰고 double
	
	private double surface = 0.0d;	//지표면의 고도는 나중에 울퉁불퉁 산 넣을 것이고, 지금은 평지
	
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
