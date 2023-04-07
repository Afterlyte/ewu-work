package holiday_decorations;

public class Lights extends TreeDecorator {
	
	public Lights(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", lights";
	}

	@Override
	public double cost() {
		return 5.00 + holidayItem.cost();
	}

}
