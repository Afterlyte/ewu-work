package holiday_decorations;

public class BalsamFir extends HolidayItem {
			
	public BalsamFir() {
		this.description = "Balsam Fir decorated with";
	}
	
	@Override
	public double cost() {
		return 25.00;
	}
}
