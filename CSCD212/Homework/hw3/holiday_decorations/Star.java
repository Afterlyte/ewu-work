package holiday_decorations;

public class Star extends TreeDecorator {
	
	private Star(HolidayItem holidayItem) {
		super(holidayItem);
	}
	
	public static HolidayItem getInstance(HolidayItem holidayItem) {
		if(holidayItem.getDescription().contains("star")) {
			System.out.println("Tree already has a star!");
			return holidayItem;
		}
		else {
			return new Star(holidayItem);
		}
	}
	
	@Override
	public String getDescription() {
		return holidayItem.getDescription() + ", star";
	}

	@Override
	public double cost() {
		return holidayItem.cost() + 4.00;
	}

}
