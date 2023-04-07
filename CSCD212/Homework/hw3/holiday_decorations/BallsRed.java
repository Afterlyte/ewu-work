package holiday_decorations;

public class BallsRed extends TreeDecorator {
		
	public BallsRed(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", red balls";
	}

	@Override
	public double cost() {
		return 1.00 + holidayItem.cost();
	}

}
