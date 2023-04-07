package shapes;

public class Rectangle extends Shape implements Comparable<Shape> {

	private Integer height;
	private Integer width;
	
	private Rectangle(Integer height, Integer width) {
		this.height = height;
		this.width = width;
		this.setName("Rectangle");
	}
	
	@Override
	public Double getArea() {
		return ((double)this.height * (double)this.width);
	}

	public static Rectangle createRectangle(Integer height, Integer width) {
		return new Rectangle(height, width);
	}
}
