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
	
		//25km 앞에 있도록 게임을 만들 것
		Target target = new Target(25000, 0);
		planet.setTarget(target);
		
		ResultOfShoot resultOfShoot;
		//bullet 발사하기
		do {
			cannon.shootBullet(bullet);
		} while (resultOfShoot != ResultOfShoot.Success);
		
		//bullet이 target을 맞추지 못하면 bullet 재생성, 다시 shootingBullet 불러옴-> 맞출 때까지 지속
		//bullet이 target을 맞추면 게임이 종료
		
		//shooting의 결과 결정
		
	}
	private static ResultOfShoot resultOfShoot(Bullet bullet, Target target) {
		//target의 위치와 bullet의 위치가 같으면 Success 반환
		if (bullet.finalLocation() == target.finalLocation()) {
			return ResultOfShoot.Success;
		} else {
			//target의 위치와 bullet의 위치가 다르면 Fail 반환
			return ResultOfShoot.Fail;
		}
	}
}
