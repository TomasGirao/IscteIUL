class GameAux {
	private static final Color GRIDCOLOR = new Color (19,41,76);
	private static final Color TEXTCOLOR = new Color (19,41,76);
	private static final Color BACKCOLOR = new Color (255,255,255);
	private static final int RES = 300;
	
	public static boolean CheckWin(int [][]matrix, int nb) {
		for (int a = 0; a < 3; a++) {
			if (CheckLine(matrix, a, nb) || CheckColumn(matrix, a, nb))
					return true;
		}
		if (CheckDiagonal(matrix, nb))
			return true;
		return false;
	}
	
	public static boolean Full(int [][]matrix) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (matrix[y][x] == 0)
					return false;
			}
		}
		return true;
	}
	
	private static boolean CheckLine(int [][]matrix, int line, int nb) {
		int c = 0;
		for (int x = 0; x < 3; x++)
			if (matrix[line][x] == nb)
				c++;
		if (c >= 3)
			return true;
		return false;
	}
	
	private static boolean CheckColumn(int [][]matrix, int column, int nb) {
		int c = 0;
		for (int y = 0; y < 3; y++)
			if (matrix[y][column] == nb)
				c++;
		if (c >= 3)
			return true;
		return false;
	}
	
	private static boolean CheckDiagonal(int [][]matrix, int nb) {
		int c = 0;
		for (int a = 0, b = 2; a < 3 && b >= 0; a++, b--)
			if (matrix[a][a] == nb || matrix[b][a] == nb)
				c++;
		if (c >= 3)
			return true;
		return false;
	}

	/****    Graphic    ****/
	public static ColorImage DrawImage(int [][]matrix) {
		ColorImage IMAGE = new ColorImage(RES, RES);
		for (int pixel = 0; pixel < RES; pixel++)
			DrawLine(IMAGE, pixel, BACKCOLOR);
		for (int pixel = 0; pixel < RES; pixel++) {
			if (pixel % (RES/3) == 0) {
				DrawLine(IMAGE, pixel, GRIDCOLOR);
				DrawColumn(IMAGE, pixel, GRIDCOLOR);
			}	
		}
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (matrix[y][x] == 1)
					IMAGE.drawCenteredText(x*RES/3+RES/6, y*RES/3+RES/6, "X", RES/3, TEXTCOLOR);
				else if (matrix[y][x] == 2)
					IMAGE.drawCenteredText(x*RES/3+RES/6, y*RES/3+RES/6, "O", RES/3, TEXTCOLOR);
			}
		}
		return IMAGE;
	}
	
	public static void ChangeImage(ColorImage img, int [][]matrix) {
		for (int pixel = 0; pixel < RES; pixel++)
			DrawLine(img, pixel, BACKCOLOR);
		for (int pixel = 0; pixel < RES; pixel++) {
			if (pixel % (RES/3) == 0) {
				DrawLine(img, pixel, GRIDCOLOR);
				DrawColumn(img, pixel, GRIDCOLOR);
			}	
		}
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (matrix[y][x] == 1)
					img.drawCenteredText(x*RES/3+RES/6, y*RES/3+RES/6, "X", RES/3, TEXTCOLOR);
				else if (matrix[y][x] == 2)
					img.drawCenteredText(x*RES/3+RES/6, y*RES/3+RES/6, "O", RES/3, TEXTCOLOR);
			}
		}
	}
	
	private static void DrawLine(ColorImage img, int line, Color color) {
		for (int x = 0; x < RES; x++)
			img.setColor(x, line, color);
	}
	
	private static void DrawColumn(ColorImage img, int column, Color color) {
		for (int y = 0; y < RES; y++)
			img.setColor(column, y, color);
	}
}