import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Sudoku {
	private	SudokuBoard sudokuBoard;
	public	ColorImage boardImage; // para ver no PandionJ

	public Sudoku(String file, double difficulty) {
		try {
			int [][]m = new int[9][9];
			int [][]m2 = new int [9][9];
			Scanner scanner = new Scanner(new File(file));
			String fileType = SudokuAux.getFileType(file);
			switch (fileType) {
				case ".sud": // Create new game
					for (int y = 0; y < 9; y++) {
						for (int x = 0; x < 9; x++) {
							if (scanner.hasNextInt())
								m[y][x] = scanner.nextInt();
						}
					}
					sudokuBoard = new SudokuBoard(m, difficulty);
					break;
				case ".sudgame": // Continue game
					for (int y = 0; y < 9; y++) {
						for (int x = 0; x < 9; x++) {
							if (scanner.hasNextInt())
								m2[y][x] = scanner.nextInt();
						}
					} 
					for (int y = 0; y < 9; y++) {
						for (int x = 0; x < 9; x++) {
							if (scanner.hasNextInt())
								m[y][x] = scanner.nextInt();
						}
					}
					sudokuBoard = new SudokuBoard(m, 0);
					sudokuBoard.copy = m2;
					break;
			}
			boardImage = SudokuAux.DrawImage(sudokuBoard.matrix);
			scanner.close();
		}
		catch (FileNotFoundException e) {
		}
	}
	
	public void MakeMove(int y, int x, int value) {
		sudokuBoard.MakeMove(y, x, value);
		Update();
	}
	
	public void Undo() {
		sudokuBoard.Undo();
		Update();
	}
	
	public void RandomPlay() {
		sudokuBoard.RandomMove();
		Update();
	}
	
	public void Reset() {
		sudokuBoard.ResetBoard();
		Update();
	}
	
	public void SaveGame() {
		try (PrintWriter writer = new PrintWriter(new File("jogo1.sudgame"))) {
			writer.print(SudokuAux.MatrixToString(sudokuBoard.copy));
			writer.print(SudokuAux.MatrixToString(sudokuBoard.matrix));
		}
		catch (FileNotFoundException e) {
		}
	}
	
	private void Update() {
		SudokuAux.ChangeImage(boardImage, sudokuBoard.matrix);
		int []segments = sudokuBoard.WrongSegments();
		int []lines = sudokuBoard.WrongLines();
		int []columns = sudokuBoard.WrongColumns();
		int []pos = new int[2];
		for (int value : segments)
			if (value != 0) {
				pos = SudokuAux.SegmentToPosition(value);
				SudokuAux.Error(boardImage, 3, pos[0], pos[1]);
			}
		for (int value : lines)
			if (value != 0)
				SudokuAux.Error(boardImage, 2, value, 0);
		for (int value : columns)
			if (value != 0)
				SudokuAux.Error(boardImage, 1, 0, value);
	}
}