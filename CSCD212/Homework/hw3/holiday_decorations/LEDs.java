package holiday_decorations;

public class LEDs extends TreeDecorator {
		
	public LEDs(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", LEDs";
	}

	@Override
	public double cost() {
		return 10.00 + holidayItem.cost();
	}

}
