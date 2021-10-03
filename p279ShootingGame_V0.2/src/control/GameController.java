package control;

import model.Bullet;
import model.Cannon;
import model.Planet;
import model.ResultOfShoot;
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
		
		ResultOfShoot resultOfShoot;
		//bullet �߻��ϱ�
		do {
			//bullet�� target�� ������ ���ϸ� bullet �����, �ٽ� shootingBullet �ҷ���-> ���� ������ ����
			cannon.shootBullet(bullet);
			//bullet�� target�� ���߸� ������ ����
		} while ((resultOfShoot = resultOfShoot(bullet, target)) != ResultOfShoot.Success);
		
		//������ ����
		//bullet�� target�� �������, "BOOM!" ���
	}
	private static ResultOfShoot resultOfShoot(Bullet bullet, Target target) {
		//target�� ��ġ�� bullet�� ��ġ�� ������ Success ��ȯ
		if (bullet.isSameLoc(target)) {
			return ResultOfShoot.Success;
		} else {
			//target�� ��ġ�� bullet�� ��ġ�� �ٸ��� Fail ��ȯ
			return ResultOfShoot.Fail;
		}
	}
}
