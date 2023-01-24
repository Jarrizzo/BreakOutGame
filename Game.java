import java.awt.Graphics2D;

public class Game {
	
	Ball ball;
	BrickCollection BC;
	BallBat BB;
	
	public Game(GameBoard board) {
		ball = new Ball(C.BoardWidth/2 -5, C.BoardHeight-50, C.BallSize, C.BallSize);
		BB = new BallBat(350, 565, ball);
		BC = new BrickCollection(ball);
	}

	public void update(Keyboard keyboard) {

		ball.update(keyboard);
		BC.update(keyboard);
		BB.update(keyboard);
		
	}

	public void draw(Graphics2D graphics) {

		ball.draw(graphics);
		BC.draw(graphics);
		BB.draw(graphics);
	}
	
}
