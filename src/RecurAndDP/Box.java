package RecurAndDP;

public class Box {
	int height;
	int width;
	int depth;
	
	public boolean isSmaller(Box b){
		if(this.height < b.height && this.width < b.width && this.depth < b.depth)
			return true;
		return false;
	}
}
