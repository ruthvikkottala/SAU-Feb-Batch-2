package auaop;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Rectangle {
	    /** The width of this rectangle. */
	    private int width;

	    /** The height of this rectangle. */
	    private int height;

	    /** The points of this rectangle. */
	    private List<Point> origin;


	   
	    public int getWidth() {
	    	return width;
		}



		public void setWidth(int width)  throws Exception {
			
			if(width <= 0) {
			    	throw new Exception("Invalid! width");
			}else {
				this.width = width;
			}

		}



		public int getHeight() {
			return height;
		}



		public void setHeight(int height)  throws Exception{
			
			if(height <= 0) {
		    	throw new Exception("Invalid! height");
			}else {
				this.height = height;
			}
			   
		}



		public List<Point> getOrigin() {
			return origin;
		}



		public void setOrigin(List<Point> origin) {
			this.origin = origin;
		}

	
}
