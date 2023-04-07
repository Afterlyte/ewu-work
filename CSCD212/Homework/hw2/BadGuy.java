import java.util.Observable;
import java.util.Observer;

public class BadGuy implements Observer {
	
	private Observable subject;
	private String name;
	private int hobbits;
	private int elves;
	private int dwarves;
	private int men;
	
	public BadGuy(Observable subject, String name) {
		this.name = name;
		this.subject = subject;
		subject.addObserver(this);
	}

	@Override
	public void update(Observable subject, Object arg1) {
		if(subject instanceof EyeOfSauron) {
			EyeOfSauron eye = (EyeOfSauron) subject;
			this.hobbits = eye.getHobbits();
			this.elves = eye.getElves();
			this.dwarves = eye.getDwarves();
			this.men = eye.getMen();
			report();
		}
	}

	private void report() {
		System.out.printf("%s received update:\t%d hobbits, %d elves, %d dwarves and %d men.\n", this.name, this.hobbits, this.elves, this.dwarves, this.men);
	}

	public void defeated() {
		this.subject.deleteObserver(this);
	}

}
