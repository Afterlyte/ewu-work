package holiday_decorations;

public class DouglasFir extends HolidayItem {
	
	public DouglasFir() {
		this.description = "Douglas Fir decorated with";
	}
	
	@Override
	public double cost() {
		return 30.00;
	}
}
