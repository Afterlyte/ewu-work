package shapes;

public abstract class Shape implements Comparable<Shape>{
	
	private String name;
	
	public static Shape createPolygon(String type, Integer height, Integer width) {
		switch(type.toLowerCase()) {
		case "square":
			return Square.createSquare(height, width);
		case "triangle":
			return Triangle.createTriangle(height, width);
		case "rectangle":
			return Rectangle.createRectangle(height, width);
		default:
			System.out.println("Invalid shape type: " + type);
			return null;
		}
	}

	public static Shape createEllipse(String type, Integer radius) {
		switch(type.toLowerCase()) {
		case "circle":
			return Circle.createCircle(radius);
		default:
			System.out.println("Invalid shape type: " + type);
			return null;
		}
	}
	
	public abstract Double getArea();
	
	public String getName() {
		return this.name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(Shape o) {
		int res = this.getName().compareTo(o.getName());
		if(res == 0) {
			return this.getArea().compareTo(o.getArea());
		}
		else {
			return res;
		}
	}
}
