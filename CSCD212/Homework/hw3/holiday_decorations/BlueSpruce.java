package holiday_decorations;

public class BlueSpruce extends HolidayItem {
	
	public BlueSpruce() {
		this.description = "Blue Spruce decorated with";
	}
	
	@Override
	public double cost() {
		return 50.00;
	}
}
