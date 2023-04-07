import java.util.ArrayList;
import java.util.Collections;

import shapes.*;

public class ShapesTester {

	public static void main(String[] args) {
		
		ArrayList<Shape> array = new ArrayList<Shape>();
		
		array.add(ShapeFactory.createShape("triangle", 5, 5));
		array.add(ShapeFactory.createShape("triangle", 3, 4));
		array.add(ShapeFactory.createShape("triangle", 7, 9));
		array.add(ShapeFactory.createShape("square", 5, 5));
		array.add(ShapeFactory.createShape("square", 7, 7));
		array.add(ShapeFactory.createShape("square", 6, 6));
		array.add(ShapeFactory.createShape("rectangle", 4, 8));
		array.add(ShapeFactory.createShape("rectangle", 9, 5));
		array.add(ShapeFactory.createShape("rectangle", 3, 2));
		array.add(ShapeFactory.createShape("circle", 5));
		array.add(ShapeFactory.createShape("circle", 4));
		array.add(ShapeFactory.createShape("circle", 3));
		
		System.out.println("\nUNSORTED\n");
		
		for(Shape e:array) {
			System.out.println(e.getName() + " area: " + e.getArea());
		}
		
		Collections.sort(array);
		
		System.out.println("\nSORTED\n");
		
		for(Shape e: array) {
			System.out.println(e.getName() + " area: " + e.getArea());
		}
	}
}
