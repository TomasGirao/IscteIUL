public class SudokuAux{
	/****	Matrix	****/
	public static boolean CheckMatrix(int [][]matrix) {
		for (int v = 0; v < 9; v++)
			if (!CheckLine(matrix, v) || !CheckColumn(matrix, v) || !CheckSegment(matrix, v))
				return false;
		return true;
	}
	
	public static boolean CheckLine(int [][]matrix, int line) {
		for (int v = 0; v < 8; v++)
			for (int v2 = v+1; v2 < 9; v2++)
				if (matrix[line][v2] != 0 && (matrix[line][v2] == matrix[line][v]))
					return false;
		return true;
	}
	
	public static boolean CheckColumn(int [][]matrix, int column) {
		for (int v = 0; v < 8; v++)
			for (int v2 = v+1; v2 < 9; v2++)
				if (matrix[v2][column] != 0 && (matrix[v2][column] == matrix[v][column]))
					return false;
		return true;
	}

	public static boolean CheckSegment(int[][] matrix, int segment) {
		int []pos = SegmentToPosition(segment);
		int yStart = pos[0];
		int xStart = pos[1];
		for (int y = yStart; y < yStart+3; y++)
			for (int x = xStart; x < xStart+3; x++)
				if (matrix[y][x] != 0)
					for (int y2 = yStart; y2 < yStart+3; y2++)
						for (int x2 = xStart; x2 < xStart+3; x2++)
							if ((y != y2 || x != x2) && matrix[y][x] == matrix[y2][x2])
								return false;
		return true;
	}
	
	public static int [][]MatrixAddZeros(int [][]matrix, double percentage) {
		int nZeros = (int)(81*percentage);
		int [][]newMatrix = matrix;
		while (nZeros > 0)
			for (int y = 0; y < 9; y++)
				for (int x = 0; x < 9; x++)
					if (Math.random() < 0.05 && matrix[y][x] != 0 && nZeros > 0) {
						newMatrix[y][x] = 0;
						nZeros--;
					}
		return newMatrix;
	}
	
	public static int []SegmentToPosition(int segments) {
		int []pos = {(int)((segments-1)/3)*3, (segments-1)%3*3};
		return pos;
	}
	
	public static String MatrixToString(int [][]matrix) {
		String str = new String();
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				str += matrix[y][x];
				str += ' ';
			}
			str += '\n';
		}
		return str;
	}
	
	public static int [][]StringToMatrix(String string) {
		int y = 0;
		int x = 0;
		int [][]matrix = new int[9][9];
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '\n') {
				x = 0;
				y++;
			}
			matrix[y][x] = (int)string.charAt(i);
		}
		return matrix;
	}
	
	/****	File Manager	****/
	public static String getFileType(String file) {
		String fileType = new String();
		for (int i = file.lastIndexOf('.'); i < file.length(); i++)
			fileType += file.charAt(i);
		return fileType;
	}
	
	/****	Graphic	****/
	public static ColorImage DrawImage(int [][]matrix) {
		int size = Param.SQUARE_SIZE*9+1;
		ColorImage Image = new ColorImage(size, size);
		for (int pixel = 0; pixel < size; pixel++)	// Background
			DrawLine(Image, 0, pixel, size, Param.SQUARE_BACKCOLOR);
		for (int pixel = 0; pixel < size; pixel++)
			if (pixel % Param.SQUARE_SIZE == 0) {	// Grid
				DrawLine(Image, 0, pixel, size, Param.GRID_COLOR);
				DrawColumn(Image, pixel, 0, size, Param.GRID_COLOR);
			}
		for (int pixel = 0; pixel < size; pixel++)
			if (pixel % (Param.SQUARE_SIZE*3) == 0) {	// Segment
				DrawLine(Image, 0, pixel, size, Param.SEGMENT_GRID_COLOR);
				DrawColumn(Image, pixel, 0, size, Param.SEGMENT_GRID_COLOR);
			}
		for (int y = 0; y < 9; y++)	{
			for (int x = 0; x < 9; x++) {
				if (matrix[y][x] != 0)
					Image.drawCenteredText(x*Param.SQUARE_SIZE+Param.SQUARE_SIZE/2, y*Param.SQUARE_SIZE+Param.SQUARE_SIZE/2, String.valueOf(matrix[y][x]), Param.LETTER_SIZE, Param.TEXTCOLOR);
			}
		}
		return Image;
	}
	
	private static void DrawLine(ColorImage Image, int x, int y, int size, Color color) {
		for (int x2 = x; x2 < x+size; x2++)
			Image.setColor(x2, y, color);
	}
	
	private static void DrawColumn(ColorImage Image, int x, int y, int size, Color color) {
		for (int y2 = y; y2 < y+size; y2++)
			Image.setColor(x, y2, color);
	}
	
	public static void ChangeImage(ColorImage Image, int [][]matrix) {
		int size = Image.getWidth();
		for (int pixel = 0; pixel < size; pixel++) {
			DrawLine(Image, 0, pixel, size, Param.SQUARE_BACKCOLOR);
			DrawColumn(Image, pixel, 0, size, Param.SQUARE_BACKCOLOR);
		}
		for (int pixel = 0; pixel < size; pixel++)
			if (pixel % Param.SQUARE_SIZE == 0) {
				DrawLine(Image, 0, pixel, size, Param.GRID_COLOR);
				DrawColumn(Image, pixel, 0, size, Param.GRID_COLOR);
			}
		for (int pixel = 0; pixel < size; pixel++)
			if (pixel % (Param.SQUARE_SIZE*3) == 0) {
				DrawLine(Image, 0, pixel, size, Param.SEGMENT_GRID_COLOR);
				DrawColumn(Image, pixel, 0, size, Param.SEGMENT_GRID_COLOR);
			}
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (matrix[y][x] != 0)
					Image.drawCenteredText(x*Param.SQUARE_SIZE+Param.SQUARE_SIZE/2, y*Param.SQUARE_SIZE+Param.SQUARE_SIZE/2, String.valueOf(matrix[y][x]), Param.LETTER_SIZE, Param.TEXTCOLOR);
			}
		}
	}
	
	public static void Error(ColorImage Image, int type, int y, int x) {
		switch(type) {
			case 1: // Column
				DrawLine(Image, (x-1)*Param.SQUARE_SIZE, y, Param.SQUARE_SIZE, Param.OUTLINE_COLOR);
				DrawLine(Image, (x-1)*Param.SQUARE_SIZE, y+Param.SQUARE_SIZE*9, Param.SQUARE_SIZE, Param.OUTLINE_COLOR);
				DrawColumn(Image, (x-1)*Param.SQUARE_SIZE, y, Param.SQUARE_SIZE*9, Param.OUTLINE_COLOR);
				DrawColumn(Image, x*Param.SQUARE_SIZE, y, Param.SQUARE_SIZE*9, Param.OUTLINE_COLOR);
				break;
			case 2: // Line
				DrawLine(Image, x, (y-1)*Param.SQUARE_SIZE, Param.SQUARE_SIZE*9, Param.OUTLINE_COLOR);
				DrawLine(Image, x, y*Param.SQUARE_SIZE, Param.SQUARE_SIZE*9, Param.OUTLINE_COLOR);
				DrawColumn(Image, x, (y-1)*Param.SQUARE_SIZE, Param.SQUARE_SIZE, Param.OUTLINE_COLOR);
				DrawColumn(Image, x+Param.SQUARE_SIZE*9, (y-1)*Param.SQUARE_SIZE, Param.SQUARE_SIZE, Param.OUTLINE_COLOR);
				break;
			case 3: // Square
				DrawLine(Image, x*Param.SQUARE_SIZE, y*Param.SQUARE_SIZE, Param.SQUARE_SIZE*3, Param.OUTLINE_COLOR);
				DrawLine(Image, x*Param.SQUARE_SIZE, y*Param.SQUARE_SIZE+Param.SQUARE_SIZE*3, Param.SQUARE_SIZE*3, Param.OUTLINE_COLOR);
				DrawColumn(Image, x*Param.SQUARE_SIZE, y*Param.SQUARE_SIZE, Param.SQUARE_SIZE*3, Param.OUTLINE_COLOR);
				DrawColumn(Image, x*Param.SQUARE_SIZE+Param.SQUARE_SIZE*3, y*Param.SQUARE_SIZE, Param.SQUARE_SIZE*3, Param.OUTLINE_COLOR);
				break;
		}
	}
}