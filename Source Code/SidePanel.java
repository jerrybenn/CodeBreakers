import java.awt.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.JButton;

/**
 * The {@code SidePanel} class is responsible for displaying various information
 * on the game such as the next piece, the score and current level, and controls.
 * @author Kanak Negi
 *
 */



public class SidePanel extends JPanel {
	
	/**
	 * Serial Version UID.
	 */

	private static final long serialVersionUID = 2181495598854992747L;

	/**
	 * The dimensions of each tile on the next piece preview.
	 */
	private static final int TILE_SIZE = BoardPanel.TILE_SIZE >> 1;
	
	/**
	 * The width of the shading on each tile on the next piece preview.
	 */
	private static final int SHADE_WIDTH = BoardPanel.SHADE_WIDTH >> 1;
	
	/**
	 * The number of rows and columns in the preview window. Set to
	 * 5 because we can show any piece with some sort of padding.
	 */
	private static final int TILE_COUNT = 5;
	
	/**
	 * The center x of the next piece preview box.
	 */
	private static final int SQUARE_CENTER_X = 130;
	
	/**
	 * The center y of the next piece preview box.
	 */
	private static final int SQUARE_CENTER_Y = 65;
	
	/**
	 * The size of the next piece preview box.
	 */
	private static final int SQUARE_SIZE = (TILE_SIZE * TILE_COUNT >> 1);
	
	/**
	 * The number of pixels used on a small insets (generally used for categories).
	 */
	private static final int SMALL_INSET = 20;
	
	/**
	 * The number of pixels used on a large insets.
	 */
	private static final int LARGE_INSET = 40;
	
	/**
	 * The y coordinate of the stats category.
	 */
	private static final int STATS_INSET = 175;
	
	/**
	 * The y coordinate of the controls category.
	 */
	private static final int CONTROLS_INSET = 300;
	
	/**
	 * The number of pixels to offset between each string.
	 */
	private static final int TEXT_STRIDE = 25;
	
	/**
	 * The small font.
	 */
	private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 11);
	
	/**
	 * The large font.
	 */
	private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 13);
	
	/**
	 * The color to draw the text and preview box in.
	 */

	/**
	 * The Extra large font.
	 */
	private static final Font EXTRA_LARGE_FONT = new Font("Tahoma", Font.BOLD, 20);
	private static final Color DRAW_COLOR = new Color(128, 192, 128);



	/**
	 * The Tetris instance.
	 */
	private Tetris tetris;
	private Random rand = new Random();



	/**
	 * Creates a new SidePanel and sets it's display properties.
	 * @param tetris The Tetris instance to use.
	 */
	public SidePanel(Tetris tetris) {
		this.tetris = tetris;
		
		setPreferredSize(new Dimension(300, BoardPanel.PANEL_HEIGHT));
		setBackground(Color.BLACK);


	}
	int val = rand.nextInt(3);
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);



		
		//Set the color for drawing.
		g.setColor(DRAW_COLOR);
		
		/*
		 * This variable stores the current y coordinate of the string.
		 * This way we can re-order, add, or remove new strings if necessary
		 * without needing to change the other strings.
		 */
		int offset;
		
		/*
		 * Draw the "Stats" category.
		 */
		g.setFont(LARGE_FONT);
		g.drawString("Stats", SMALL_INSET, offset = STATS_INSET);
		g.setFont(SMALL_FONT);
		g.drawString("Level: " + tetris.getLevel(), LARGE_INSET, offset += TEXT_STRIDE);
		g.drawString("Score: " + tetris.getScore(), LARGE_INSET, offset += TEXT_STRIDE);
		
		/*
		 * Draw the "Controls" category.
		 */
		g.setFont(LARGE_FONT);
		g.drawString("Controls", SMALL_INSET, offset = CONTROLS_INSET);
		g.setFont(SMALL_FONT);
		g.drawString("Up Arrow - Rotate", LARGE_INSET, offset += TEXT_STRIDE);
		g.drawString("Left Arrow - Move Left", LARGE_INSET, offset += TEXT_STRIDE);
		g.drawString("Right Arrow - Move Right", LARGE_INSET, offset += TEXT_STRIDE);
		g.drawString("P - Pause Game", LARGE_INSET, offset += TEXT_STRIDE);
		
		/*
		 * Draw the next piece preview box.
		 */
		g.setFont(LARGE_FONT);
		g.drawString("Next Piece:", SMALL_INSET, 70);
		g.drawRect(SQUARE_CENTER_X - SQUARE_SIZE, SQUARE_CENTER_Y - SQUARE_SIZE, SQUARE_SIZE * 2, SQUARE_SIZE * 2);

		//g.setColor(Color.BLUE);
		//g.fillRect(LARGE_INSET,380,80,25);
		//g.drawRect(SMALL_INSET,400,5,10);

		/*
		 Draw word of the day
		 */
		g.setColor(DRAW_COLOR);
		g.setFont(EXTRA_LARGE_FONT);
		g.drawString("Word Of The Day",SMALL_INSET,440);

		/*
		code for printing letters on screen
		 */

		if (val == 0) {
			g.setFont(LARGE_FONT);
			if (tetris.getLevel() == 1) {
				g.drawString("S", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 2) {
				g.drawString("S M", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 3) {
				g.drawString("S M A", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 4) {
				g.drawString("S M A S", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 5) {
				g.drawString("S M A S H", SMALL_INSET + 5, 460);
				try {
					ProjectComm comm = new ProjectComm("codebreakers");
					comm.sendCommand("Smash");
				} catch (java.io.IOException ioe) {
					System.out.println(ioe);
				}
			}
		};
		 if (val == 1) {
			g.setFont(LARGE_FONT);
			if (tetris.getLevel() == 1) {
				g.drawString("C", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 2) {
				g.drawString("C O", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 3) {
				g.drawString("C O D", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 4) {
				g.drawString("C O D E", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 5) {
				g.drawString("C O D E R", SMALL_INSET + 5, 460);
				try {
					ProjectComm comm = new ProjectComm("codebreakers");
					comm.sendCommand("Smash");
				} catch (java.io.IOException ioe) {
					System.out.println(ioe);
				}
			}
		};
		if (val == 2) {
			g.setFont(LARGE_FONT);
			if (tetris.getLevel() == 1) {
				g.drawString("H", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 2) {
				g.drawString("H A", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 3) {
				g.drawString("H A P", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 4) {
				g.drawString("H A P P", SMALL_INSET + 5, 460);
			}
			;
			if (tetris.getLevel() == 5) {
				g.drawString("H A P P Y", SMALL_INSET + 5, 460);
				try {
					ProjectComm comm = new ProjectComm("codebreakers");
					comm.sendCommand("Smash");
				} catch (java.io.IOException ioe) {
					System.out.println(ioe);
				}
			}
		};

		/*
		 * Draw a preview of the next piece that will be spawned. The code is pretty much
		 * identical to the drawing code on the board, just smaller and centered, rather
		 * than constrained to a grid.
		 */


		TileType type = tetris.getNextPieceType();
		if(!tetris.isGameOver() && type != null) {
			/*
			 * Get the size properties of the current piece.
			 */
			int cols = type.getCols();
			int rows = type.getRows();
			int dimension = type.getDimension();
		
			/*
			 * Calculate the top left corner (origin) of the piece.
			 */
			int startX = (SQUARE_CENTER_X - (cols * TILE_SIZE / 2));
			int startY = (SQUARE_CENTER_Y - (rows * TILE_SIZE / 2));
		
			/*
			 * Get the insets for the preview. The default
			 * rotation is used for the preview, so we just use 0.
			 */
			int top = type.getTopInset(0);
			int left = type.getLeftInset(0);
		
			/*
			 * Loop through the piece and draw it's tiles onto the preview.
			 */
			for(int row = 0; row < dimension; row++) {
				for(int col = 0; col < dimension; col++) {
					if(type.isTile(col, row, 0)) {
						drawTile(type, startX + ((col - left) * TILE_SIZE), startY + ((row - top) * TILE_SIZE), g);
					}
				}
			}
		}
	}
	
	/**
	 * Draws a tile onto the preview window.
	 * @param type The type of tile to draw.
	 * @param x The x coordinate of the tile.
	 * @param y The y coordinate of the tile.
	 * @param g The graphics object.
	 */
	private void drawTile(TileType type, int x, int y, Graphics g) {
		/*
		 * Fill the entire tile with the base color.
		 */
		g.setColor(type.getBaseColor());
		g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
		
		/*
		 * Fill the bottom and right edges of the tile with the dark shading color.
		 */
		g.setColor(type.getDarkColor());
		g.fillRect(x, y + TILE_SIZE - SHADE_WIDTH, TILE_SIZE, SHADE_WIDTH);
		g.fillRect(x + TILE_SIZE - SHADE_WIDTH, y, SHADE_WIDTH, TILE_SIZE);
		
		/*
		 * Fill the top and left edges with the light shading. We draw a single line
		 * for each row or column rather than a rectangle so that we can draw a nice
		 * looking diagonal where the light and dark shading meet.
		 */
		g.setColor(type.getLightColor());
		for(int i = 0; i < SHADE_WIDTH; i++) {
			g.drawLine(x, y + i, x + TILE_SIZE - i - 1, y + i);
			g.drawLine(x + i, y, x + i, y + TILE_SIZE - i - 1);
		}
	}

}