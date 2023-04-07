package shapes;

public class ShapeFactory {
	
	public static Shape createShape(String type, Integer height, Integer width) {
		return Shape.createPolygon(type, height, width);
	}
	public static Shape createShape(String type, Integer radius) {
		return Shape.createEllipse(type, radius);
	}
}
