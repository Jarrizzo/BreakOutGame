import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class BrickCollection {
	Ball ball;
	ScoreBoard score;

	ArrayList <Brick> BC = new ArrayList<>();

	
	public BrickCollection (Ball ball,ScoreBoard score) {
		this.ball = ball;
		this.score = score;
		BrickCreation();
	}
	
	
	public void update (Keyboard keyboard) {
		checkCollision();

		}
		
	
	public void draw(Graphics graphics) {
		
		for(Brick b: BC) {
			graphics.setColor(b.color);
			graphics.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
		
	}
	
	private void BrickCreation() {
		
		for(int i = 0; i < C.NumberOfBricks; i++) {
			int x =15 + i % 14 * 55;
			int y = 100 + i / 14 * 25;
			
			if(i < 28)
			BC.add( new Brick(x, y, C.BrickWidth, C.BrickHeight, Color.RED));
			if( i >=28 && i < 56)
			BC.add( new Brick(x, y,C.BrickWidth,  C.BrickHeight, Color.WHITE));
			if( i >= 56)
			BC.add( new Brick(x, y, C.BrickWidth,  C.BrickHeight, Color.BLUE));
		}	
		
	}
	private void checkCollision() {
		
		for(Brick B: BC) {
			Rectangle ballbox = new Rectangle(ball.getX(),ball.getY(),ball.getWidth(),ball.getHeight());
			Rectangle brickbox = new Rectangle(B.getX(),B.getY(),B.getWidth(),B.getHeight());
			
			if(brickbox.intersects(ballbox)) {
				ball.setYSpeed(-(ball.getYSpeed())); 
				if(B.color == Color.BLUE) {
					score.setScore(score.getScore()+10);
					B.color = Color.WHITE;
				}	
				else if(B.color == Color.WHITE) {
					score.setScore(score.getScore()+20);
					B.color = Color.RED; 
				}	
				else if(B.color == Color.RED ) {
					score.setScore(score.getScore()+30);
					BC.remove(B);
					break;
				}
			}	
		}
	}
}
