package tool;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import JFrame.Panel1;
import cells.cell;
import cells.combination;

public class LogicTest {

	private static combination comb = new combination(); 
	private static Panel1 p = new Panel1();
	private static Logic logic = new Logic();
	@Before
	public void setUp() throws Exception {
		comb.cells[0] = new cell(1,2);
		comb.cells[1] = new cell(1,3);
		comb.cells[2] = new cell(2,2);
		comb.cells[3] = new cell(2,1);
		p.initmap();
	}

	@Test
	public void testMoveornot() {
		p.pane[3][2] = 2;
		assertEquals(0,logic.Moveornot(p, comb, 2, 1));
	}

	@Test
	public void testTurnornot() {
		for (int i = 1 ; i<6;i++)
		{
			p.pane[3][i] = 2;
		}
		assertEquals(0,logic.Turnornot(p, comb));
	}

	@Test
	public void testGameover() {
		for (int i = 1;i<7;i++)
		{
			p.pane[1][i] = 2;
		}
		assertEquals(1,logic.Gameover(p, comb));
	}

	@Test
	public void testCleanornot() {
		for (int i = 1; i<10;i++)
		{
			p.pane[5][i] = 2;
		}
		assertEquals(1,logic.cleanornot(p, 5));
	}

}
