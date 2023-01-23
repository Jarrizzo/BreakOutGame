import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BrickCollection {

	ArrayList <Brick> BC = new ArrayList<>();

	
	public BrickCollection () {
		
		BrickCreation();
	
	}
	
	
	public void update (Keyboard keyboard) {
		

			
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
	
	
}
