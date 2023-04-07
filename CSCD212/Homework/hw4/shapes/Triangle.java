package shapes;

public class Triangle extends Shape implements Comparable<Shape> {
	
	private Integer height;
	private Integer width;
	
	private Triangle(Integer height, Integer width) {
		this.height = height;
		this.width = width;
		this.setName("Triangle");
	}
	
	@Override
	public Double getArea() {
		return ((double)this.height * (double)this.width / 2);
	}

	public static Triangle createTriangle(Integer height, Integer width) {
		return new Triangle(height, width);
	}

}
