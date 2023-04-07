package holiday_decorations;

public class BallsBlue extends TreeDecorator {
		
	public BallsBlue(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", blue balls";
	}

	@Override
	public double cost() {
		return 2.00 + holidayItem.cost();
	}

}
