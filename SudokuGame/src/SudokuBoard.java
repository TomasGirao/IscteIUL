class SudokuBoard {
	private int count;
	public int [][]matrix;
	public int [][]copy;
	private int []coord = new int[81];
	
	public SudokuBoard(int [][]matrix, double difficulty) {
		if (difficulty < 0 || difficulty >= 1)
			throw new IllegalArgumentException("Values out of bounds");
		count = -1;
		this.matrix = SudokuAux.MatrixAddZeros(matrix, difficulty);
		copy = new int[9][9];
		for (int y = 0; y < 9; y++)
			for (int x = 0; x < 9; x++)
				copy[y][x] = this.matrix[y][x];
	}
	
	public int GetNumber(int y, int x) {
		if ((y < 0 || y > 8) && (x < 0 || x > 8))
			throw new IllegalArgumentException("Values out of bounds");
		return matrix[y][x];
	}

	public void MakeMove(int y, int x, int nb) {
		if ((y < 1 || y > 9) || (x < 1 || x > 9) || (nb < 1 || nb > 9))
			throw new IllegalArgumentException("Values out of bounds");
		if (matrix[y-1][x-1] == 0) {
			matrix[y-1][x-1] = nb;
			count++;
			coord[count] = (y-1)*10+(x-1);
		}
	}
	
	public void RandomMove() {
		int y = (int)(Math.random()*9);
		int x = (int)(Math.random()*9);
		int col = (int)((x-1)/3)+1;
		int lin = (int)((y-1)/3);
		int segment = lin * 3 + col;
		int nb = (int)(Math.random()*9) + 1;
		if (GetNumber(y, x) == 0) {
			matrix[y][x] = nb;
			count++;
			coord[count] = y*10+x;
			if (!SudokuAux.CheckSegment(matrix, segment)) {
				coord[count] = 0;
				count--;
				matrix[y][x] = 0;
				RandomMove();
			}
		}
		else
			RandomMove();
	}

	public void ResetBoard() {
		matrix = copy;
		count = 0;
	}
	
	public int []WrongSegments() {
		int []seg = new int[9];
		int i = 0;
		for (int v = 0; v < 9; v++) {
			if (!SudokuAux.CheckSegment(matrix, v+1))
				seg[i++] = v+1;
		}
		return seg;
	}
	
	public int []WrongLines() {
		int []line = new int [9];
		int i = 0;
		for (int v = 0; v < 9; v++)
			if (!SudokuAux.CheckLine(matrix, v))
				line[i++] = v+1;
		return line;
	}
	
	public int []WrongColumns() {
		int []colu = new int [9];
		int i = 0;
		for (int v = 0; v < 9; v++)
			if (!SudokuAux.CheckColumn(matrix, v))
				colu[i++] = v+1;
		return colu;
	}
	
	public boolean SudokuFull() {
		for (int y = 0; y < 9; y++)
			for (int x = 0; x < 9 ; x++)
				if (GetNumber(y, x) == 0)
					return false;
		if (SudokuAux.CheckMatrix(matrix))
			return true;
		return false;
	}
	
	public void Undo() {
		if (count >= 0) {
			int y = coord[count]/10;
			int x = coord[count]%10;
			matrix[y][x] = 0;
			coord[count] = 0;
			count--;
		}
	}
}