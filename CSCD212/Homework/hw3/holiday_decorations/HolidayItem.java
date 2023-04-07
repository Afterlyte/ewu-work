package holiday_decorations;

public abstract class HolidayItem {
	
	protected String description = "Non-customized tree";
	
	public String getDescription() {
		return this.description;
	}
	
	public abstract double cost();
}
