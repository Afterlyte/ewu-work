package shapes;

public class Circle extends Shape implements Comparable<Shape> {
	
	private Integer radius;
	
	private Circle(Integer radius) {
		this.setName("Circle");
		this.radius = radius;
	}
	
	@Override
	public Double getArea() {
		return this.radius * this.radius * Math.PI;
	}

	public static Shape createCircle(Integer radius) {
		return new Circle(radius);
	}

}
