class Game {
	private int [][]MATRIX = new int[3][3];
	private int ROUND = 0;
	public	ColorImage IMAGE;

	Game() {
		IMAGE = GameAux.DrawImage(MATRIX);
	}
	
	void MakeMove(int y, int x) {
		if (MATRIX[y-1][x-1] == 0 && !GameOver()) {
			MATRIX[y-1][x-1] = Player();
			Update();
		}
	}
	
	void Reset() {
		MATRIX = new int[3][3];
		System.out.println("\n\n\n\n\nNEW GAME");
		Update();
	}
	
	private int Player() {
		if (ROUND % 2 == 0)
			return 1;
		return 2;
	}
	
	private void Update() {
		GameAux.ChangeImage(IMAGE, MATRIX);
		ROUND++;
		GameOver();
				
	}
	
	private boolean GameOver() {
		if (GameAux.Full(MATRIX) && !GameAux.CheckWin(MATRIX, 1) && !GameAux.CheckWin(MATRIX, 2)) {
			System.out.println("\n\n\n\n\nDRAW   -   PRESS RESET TO START NEW GAME");
			return true;
		}
		if (GameAux.CheckWin(MATRIX, 1)) {
			System.out.println("\n\n\n\n\n'X' WINS   -   PRESS RESET TO START NEW GAME");
			return true;
		}
		else if (GameAux.CheckWin(MATRIX, 2)) {
			System.out.println("\n\n\n\n\n'O' WINS   -   PRESS RESET TO START NEW GAME");
			return true;
		}
		return false;
	}
}