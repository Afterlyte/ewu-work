package holiday_decorations;

public class Ruffles extends TreeDecorator {
	
	public Ruffles(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", ruffles";
	}

	@Override
	public double cost() {
		return holidayItem.cost() + 1.00;
	}

}
