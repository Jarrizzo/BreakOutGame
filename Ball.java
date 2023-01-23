import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Sprite{
	
	int ySpeed = -5;
	int xSpeed = -3;
	BallBat ballbat = new BallBat(0, 0);

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(Keyboard keyboard) {
		
		WallCollision();
		move();
		checkBatCollision(ballbat);
		
	}
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	
	private void move() {
		
		setY(getY() + ySpeed);
		setX(getX() + xSpeed);
		
	}
	
	public void setYDirection (int ySpeed) {
		
		ySpeed = 1;
	}
	public void setXDirection (int xSpeed) {
		
		xSpeed = 1;
	}
	
	private void WallCollision () {
		
		if (getY( ) <= 0 || getY() >= 600-C.BallSize ) {
			
			ySpeed = -ySpeed;
		}
		if (getX( ) <= 0 || getX() >= 800-C.BallSize ) {
			
			xSpeed = -xSpeed;
		}
	}
	private void checkBatCollision (BallBat BB) {
		
		Rectangle batBox = new Rectangle(BB.getX(),BB.getY(), BB.getWidth(), BB.getHeight());
		Rectangle ballBox = new Rectangle(getX(),getY(),getWidth(),getHeight());
		
		if(batBox.intersects(ballBox))
			ySpeed = -ySpeed;
		
	}
	
	

		
	

}
