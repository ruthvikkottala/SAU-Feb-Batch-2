package auaop;

public class Point {
	
	    public int x = 0;
	    public int y = 0;

	
	    @Override
		public String toString() {
			return "(x=" + x + ", y=" + y + ")";
		}


		public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    
	}
}
