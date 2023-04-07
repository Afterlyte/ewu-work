package holiday_decorations;

public class Ribbons extends TreeDecorator {
		
	public Ribbons(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", ribbons";
	}

	@Override
	public double cost() {
		return 2.00 + holidayItem.cost();
	}

}
