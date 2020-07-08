package cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class combinationTest {

	private static combination comb = new combination();
	@Before
	public void setUp() throws Exception {
		comb.cells[0] = new cell(1,2);
		comb.cells[1] = new cell(1,3);
		comb.cells[2] = new cell(2,2);
		comb.cells[3] = new cell(2,1);
	}

	@Test
	public void testMoveRight() {
		comb.moveRight();
		assertEquals(3,comb.cells[0].getY());
		assertEquals(4,comb.cells[1].getY());
		assertEquals(3,comb.cells[2].getY());
		assertEquals(2,comb.cells[3].getY());
	}

	@Test
	public void testMoveDown() {
		comb.moveDown();
		assertEquals(2,comb.cells[0].getX());
		assertEquals(2,comb.cells[1].getX());
		assertEquals(3,comb.cells[2].getX());
		assertEquals(3,comb.cells[3].getX());
	}

	@Test
	public void testTurn() {
		int min = 0;
		int mincell = 3;
		for (int i = 0;i<4;i++)
		{
			if (min<comb.cells[i].getX())
			{
				min = comb.cells[i].getX();
				mincell = i;
			}
		}
		int n = comb.cells[mincell].getX();
		int m = comb.cells[mincell].getY();
		comb.Turn();
		assertEquals(2-m+n,comb.cells[0].getX());
		assertEquals(n-1+m,comb.cells[0].getY());
		assertEquals(3-m+n,comb.cells[1].getX());
		assertEquals(n-1+m,comb.cells[1].getY());
		assertEquals(2-m+n,comb.cells[2].getX());
		assertEquals(n-2+m,comb.cells[2].getY());
		assertEquals(1-m+n,comb.cells[3].getX());
		assertEquals(n-2+m,comb.cells[3].getY());
	}

	@Test
	public void testI() {
		comb.I();
		assertEquals(1,comb.cells[0].getX());
		assertEquals(1,comb.cells[0].getY());
		assertEquals(2,comb.cells[1].getX());
		assertEquals(1,comb.cells[1].getY());
		assertEquals(3,comb.cells[2].getX());
		assertEquals(1,comb.cells[2].getY());
		assertEquals(4,comb.cells[3].getX());
		assertEquals(1,comb.cells[3].getY());
	}

}
