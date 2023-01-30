import java.awt.*;

public class Life extends Sprite{
	private int Life = C.NumberOfLifes;
	Game game;
	GameState gameState;

	public Life(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void update(Keyboard keyboard) {
		
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		graphics.setColor(Color.CYAN);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 25));
		graphics.drawString("Lifes : " + Life,680 ,55);
		
	}
	
	public int getLifes() {
		return Life;
	}
	public void setLifes(int Life) {
		this.Life = Life;
	}


}
