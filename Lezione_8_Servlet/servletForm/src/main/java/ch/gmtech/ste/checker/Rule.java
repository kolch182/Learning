package ch.gmtech.ste.checker;

public interface Rule {
	boolean applyOn(String what);
	String message();
}
