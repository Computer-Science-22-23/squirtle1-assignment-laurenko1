public class SquirtleRunner {

	/**
	 * Runner for a PokeBoard PokemonCode demo
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		// Create the board 
		Board board = new SquirtleBoard();
				
		// Create the gui and use the board's info to run the game.
		Gui gui = new Gui(board, board.getRows(), board.getColumns(), board.getTitle());
		gui.setTextWindow(board.getInitialText());
		gui.displayGame();
	}
	
}