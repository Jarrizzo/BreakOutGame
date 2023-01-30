import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Game {
	
	GameState gamestate;
	Ball ball;
	BrickCollection BC;
	BallBat BB;
	TopWall topWall;
	Life life;
	ScoreBoard scoreBoard;
	
	public Game(GameBoard board) {

		GameStart();
	
	}
	

	public void update(Keyboard keyboard) {
		
		
		if(keyboard.isKeyDown(Key.Space)) {
			gamestate = GameState.PLAY;
		}	
		if(life.getLifes() == 0) {
			gamestate = GameState.LOST;
		}	
		if(gamestate == GameState.PLAY) {
			ball.update(keyboard);
			BC.update(keyboard);
			BB.update(keyboard);
		}
		if(ball.getY() >= C.BoardHeight) {
			GameReStart();
		}
		if(gamestate == GameState.LOST && keyboard.isKeyDown(Key.Enter)) {
			GameStart();
		}
		
	}

	public void draw(Graphics2D graphics) {

		if(gamestate == GameState.LOST) {
			graphics.setColor(Color.RED);
			graphics.setFont(new Font("Coslolas",Font.PLAIN, 100));
			graphics.drawString("Game Over",140 ,350);
			graphics.setFont(new Font("Coslolas",Font.PLAIN, 40));
			graphics.drawString("Your Score: " + scoreBoard.getScore(),265 ,400);
			graphics.setFont(new Font("Coslolas",Font.PLAIN, 10));
			graphics.drawString("(Press Enter to Play again)",330 ,420);
		}
		
		ball.draw(graphics);
		BC.draw(graphics);
		BB.draw(graphics);
		topWall.draw(graphics);
		life.draw(graphics);
		scoreBoard.draw(graphics);
		
	}
	
	private void GameStart() {
	
		gamestate = GameState.START;
		topWall = new TopWall(0, 0, 0, 0);
		ball = new Ball(C.BoardWidth/2 -5, C.BoardHeight-50, C.BallSize, C.BallSize);
		BB = new BallBat(350, 565, ball);
		scoreBoard = new ScoreBoard(0, 0, 0, 0);
		BC = new BrickCollection(ball,scoreBoard);
		life = new Life(0, 0, 0, 0);
		
	}
	public void GameReStart() {
		
		gamestate = GameState.PAUSE;
		BB.setX(C.BatStartX);
		ball.setX(C.BallStartX);
		ball.setY(C.BallStartY);
		life.setLifes(life.getLifes()-1);
	}
	
}
