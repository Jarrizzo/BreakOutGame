import java.awt.Color;
import java.awt.Graphics2D;

public class BallBat extends Sprite {

	public BallBat(int x, int y) {
		super(x, y, C.BatWidth, C.BatHeight);
	}

	@Override
	public void update(Keyboard keyboard) {
		
		move(keyboard);
				
	}

	@Override
	public void draw(Graphics2D graphics) {

		graphics.setColor(Color.green);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

	private void move(Keyboard keyboard) {
		
		if(keyboard.isKeyDown(Key.Right))
			setX(getX()+C.BATSPEED);
		if(keyboard.isKeyDown(Key.Left))
			setX(getX()-C.BATSPEED);
		if(getX() <= 0)
			setX(0);
		if(getX() >= 700)
			setX(700);	
		
	}
	
}
