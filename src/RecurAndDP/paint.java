package RecurAndDP;

public class paint {
	enum Color {
		Black, White, Red, Bule, Yellow
	}

	public boolean paintFill(Color[][] screen, int x, int y, Color nc) {
		if (screen[y][x] == nc)
			return false;
		return paintFill(screen, x, y, screen[y][x], nc);
	}

	public boolean paintFill(Color[][] screen, int x, int y, Color oc, Color nc) {
		if(x < 0||x > screen[0].length||y < 0||y>screen.length)
			return false;
		if(screen[y][x] == oc){
			screen[y][x] = nc;
			paintFill(screen, x, y, oc, nc);
			paintFill(screen, x-1, y, oc, nc);
			paintFill(screen, x+1, y, oc, nc);
			paintFill(screen, x, y-1, oc, nc);
			paintFill(screen, x, y+1, oc, nc);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
