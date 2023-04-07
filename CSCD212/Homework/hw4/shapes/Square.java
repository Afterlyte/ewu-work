package shapes;

public class Square extends Shape implements Comparable<Shape> {

	private Integer height;
	private Integer width;
	
	private Square(Integer height, Integer width) {
		this.height = height;
		this.width = width;
		this.setName("Square");
	}
	
	@Override
	public Double getArea() {
		return ((double)this.height * (double)this.width);
	}

	public static Square createSquare(Integer height, Integer width) {
		return new Square(height, width);
	}

}
