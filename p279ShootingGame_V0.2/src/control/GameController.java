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
	

		//25km 앞에 있도록 게임을 만들 것
		Target target = new Target(25000, 0);
		planet.setTarget(target);
		
		ResultOfShoot resultOfShoot;
		//bullet 발사하기
		do {
			Bullet bullet = new Bullet();
			planet.setBullet(bullet);
			cannon.load(bullet);
			//bullet을 쏴 y값이 0일 때까지 움직임
			cannon.shootBullet(bullet);
			resultOfShoot = resultOfShoot(bullet, target);
			//bullet이 target을 맞추지 못하면 bullet 재생성, 다시 shootingBullet 불러옴-> 맞출 때까지 지속
			//? : bullet이 target보다 앞에 떨어졌는지 뒤에 떨어졌는지 알려주는 법 고민
			//bullet이 target을 맞추면 게임이 종료
		} while (resultOfShoot != ResultOfShoot.Success);
		
		//게임이 끝남
		//bullet과 target이 사라지고, "BOOM!" 출력
	}
	private static ResultOfShoot resultOfShoot(Bullet bullet, Target target) {
		//target의 위치와 bullet의 위치가 같으면 Success 반환
		if (bullet.isSameLoc(target)) {
			return ResultOfShoot.Success;
		} else {
			//target의 위치와 bullet의 위치가 다르면 Fail 반환
			return ResultOfShoot.Fail;
		}
	}
}
