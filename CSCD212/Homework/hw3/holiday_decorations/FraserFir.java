package holiday_decorations;

public class FraserFir extends HolidayItem {
	
	public FraserFir() {
		this.description = "Fraser Fir decorated with";
	}
	
	@Override
	public double cost() {
		return 35.00;
	}
}
