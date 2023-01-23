import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Sprite{

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(Keyboard keyboard) {
		
		//move();
		//WallCollision();
		
	}
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	
	private void move() {
		
		setY(getY() - 2);
		setX(getX() + 2);
		
	}
	private void WallCollision () {
		
		if (getY( ) <= 0 || getY() >= 600 ) {
			
			setY(-(getY() - 2));
		}
		if (getX( ) <= 0 || getX() >= 800 ) {
			
			setX(-(getX()+ 2));
		}
		
		
	}

}
