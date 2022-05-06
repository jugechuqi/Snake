import java.awt.Graphics;

import Logic.Game;
import Show.ShowScreen;

class Main{
	public static void main(String[] args) {
		
		ShowScreen screen=new ShowScreen();
		Game game=new Game();
		game.setScreen(screen);
		screen.init(game);
		screen.start();
	}
}