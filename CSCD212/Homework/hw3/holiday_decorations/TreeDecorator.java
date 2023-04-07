package holiday_decorations;

public abstract class TreeDecorator extends HolidayItem {
	
	protected HolidayItem holidayItem;
	
	protected TreeDecorator(HolidayItem holidayItem) {
		this.holidayItem = holidayItem;
	}
}
