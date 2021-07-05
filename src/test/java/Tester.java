

import static org.junit.Assert.*;

import Business.ShelfManager.ShelfManager;

import Business.Package.Package;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

public class Tester {

	ShelfManager shelfManager;

	public Tester() {

		shelfManager = new ShelfManager();

	}

	@Test
	public void teste1() {
		//test ob Regalboden an x Position der Regalstütze einrastet
		shelfManager.addShelfSupport(400);
		shelfManager.addShelfSupport(400);

		shelfManager.getShelf().getShelfSupports().get(1).setPositionX(100);

		shelfManager.addShelfFloor(100);

		shelfManager.getShelf().getShelfFloors().get(0).setPositionX(50);

		shelfManager.getShelf().getShelfFloors().get(0).setPositionY(200);//??

		shelfManager.checkShelfSupports(shelfManager.getShelf().getShelfFloors().get(0),620 );


		//shelfManager.getShelf().getShelfFloors().get(0).getPositionX();

		assertEquals(shelfManager.getShelf().getShelfFloors().get(0).getPositionX(), shelfManager.getShelf().getShelfSupports().get(0).getPositionX());

	}

	@Test
	public void teste2() {
		//test ob Regalboden an y Position der Regalstütze einrastet
		shelfManager.addShelfSupport(400);
		shelfManager.addShelfSupport(400);

		shelfManager.getShelf().getShelfSupports().get(1).setPositionX(100);

		shelfManager.addShelfFloor(100);

		shelfManager.getShelf().getShelfFloors().get(0).setPositionX(50);

		shelfManager.getShelf().getShelfFloors().get(0).setPositionY(220);//??

		shelfManager.checkShelfSupports(shelfManager.getShelf().getShelfFloors().get(0),620 );


		//shelfManager.getShelf().getShelfFloors().get(0).getPositionY();

		assertEquals(shelfManager.getShelf().getShelfFloors().get(0).getPositionY(), 620 -  shelfManager.getShelf().getShelfSupports().get(0).getLength() );

	}







}
