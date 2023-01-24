import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class BrickCollection {
	Ball ball;

	ArrayList <Brick> BC = new ArrayList<>();

	
	public BrickCollection (Ball ball) {
		this.ball = ball;
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
			int y = 10 + i / 14 * 25;
			
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
				ball.setYSpeed(-(ball.getYSpeed()));					BC.remove(B);
				break;
			}	
		}
	}
}
