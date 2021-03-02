package auaop;
import java.util.ArrayList;
import java.util.List;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

public class Main {
	public static void main(String[] args) throws Exception {
		 ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		 
		 Rectangle rectangle = ctx.getBean(Rectangle.class);
		 List<Point> points = new ArrayList<Point>();
		 points.add(new Point(0,0));
		 points.add(new Point(0,6));
		 points.add(new Point(4,0));
		 points.add(new Point(4,6));
		 rectangle.setOrigin(points);
		 rectangle.setHeight(6);
		 rectangle.setWidth(4);
		 System.out.println("Rectangle height set to - "+rectangle.getHeight());
		 
		 try {
			 rectangle.setWidth(0);
		 }catch(Exception ex) {
			 
		 }
		 
		
		
		 ctx.close();
	}
}
