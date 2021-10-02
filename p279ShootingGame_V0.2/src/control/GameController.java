package control;

import model.Bullet;
import model.Cannon;
import model.Planet;
import model.Target;

public class GameController {

	public static void main(String[] args) {
		Planet planet = Planet.getTheInstance();
		
		Cannon cannon = new Cannon(1000, 0, 0);
		planet.setCannon(cannon);
		
		Bullet bullet = new Bullet();
		planet.setBullet(bullet);
		cannon.load(bullet);
	
		//25km �տ� �ֵ��� ������ ���� ��
		Target target = new Target(25000, 0);
		planet.setTarget(target);
	}
}
