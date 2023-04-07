package holiday_decorations;

public class BallsSilver extends TreeDecorator {
		
	public BallsSilver(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", silver balls";
	}

	@Override
	public double cost() {
		return 3.00 + holidayItem.cost();
	}

}
