package ch.gmtech.ste.preservewholeobject;


public class TempRange {
	private final int _min;
	private final int _max;

	TempRange (int min, int max) {
		_min = min;
		_max = max;
	}

	int getLow() {
		return _min;
	}

	int getHigh() {
		return _max;
	}

	boolean includes (TempRange arg) {
		return arg.getLow() >= this.getLow() && arg.getHigh() <=
				this.getHigh();
	}

}
