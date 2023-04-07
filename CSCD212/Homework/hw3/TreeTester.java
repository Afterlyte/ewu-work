import java.text.DecimalFormat;
import holiday_decorations.*;

public class TreeTester {
	
	public static void main(String[] args) {
		DecimalFormat price = new DecimalFormat("$#.00");
		HolidayItem mytree = new BlueSpruce(); //HolidayItem is super type for Decorator scenario
		mytree = new Ruffles(mytree);
		System.out.println(mytree.getDescription() + " costs " + price.format(mytree.cost()));
		mytree = new BallsBlue(mytree);
		System.out.println(mytree.getDescription() + " costs " + price.format(mytree.cost()));
		mytree = Star.getInstance(mytree);
		System.out.println(mytree.getDescription() + " costs " + price.format(mytree.cost()));
		mytree = new Lights(mytree);
		System.out.println(mytree.getDescription() + " costs " + price.format(mytree.cost()));
		mytree = Star.getInstance(mytree);
		System.out.println(mytree.getDescription() + " costs " + price.format(mytree.cost()));
		HolidayItem mytree2 = new FraserFir();
		mytree2 = new Ruffles(mytree2);
		System.out.println(mytree2.getDescription() + " costs " + price.format(mytree2.cost()));
		mytree2 = new BallsBlue(mytree2);
		System.out.println(mytree2.getDescription() + " costs " + price.format(mytree2.cost()));
		mytree2 = Star.getInstance(mytree2);
		System.out.println(mytree2.getDescription() + " costs " + price.format(mytree2.cost()));
		mytree2 = new Ribbons(mytree2);
		System.out.println(mytree2.getDescription() + " costs " + price.format(mytree2.cost()));
		mytree2 = Star.getInstance(mytree2);
		System.out.println(mytree2.getDescription() + " costs " + price.format(mytree2.cost()));
	}

}
