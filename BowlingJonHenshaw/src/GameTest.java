import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	private Game game;
	
	@Before
	public void setUp(){
		game = new Game();
	}

	@Test
	public void scoreIsPerfect() {
		game.rolls("X-X-X-X-X-X-X-X-X-X-XX");
		assertThat(game.score(), is(300));
	}
	
	@Test
	public void scoreIsZero() {
		game.rolls("00-00-00-00-00-00-00-00-00-00");
		assertThat(game.score(), is(0));
	}
	
	@Test
	public void scoreIsNinety() {
		game.rolls("45-54-36-27-09-63-81-18-90-72");
		assertThat(game.score(), is(90));
	}
	
	
	@Test
	public void scoreIsOneFifty(){
		game.rolls("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/-5");
		assertThat(game.score(), is(150));
	}
	
	@Test
	public void scoreIsNinetySix() {
		game.rolls("45-54-36-27-09-63-81-18-90-7/-5");
		assertThat(game.score(), is(96));
	}
	
	

}
