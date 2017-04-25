package ch.gmtech.ste.checker;

import org.apache.commons.lang3.StringUtils;

public class NotEmptyRule implements Rule {

	@Override
	public boolean applyOn(String what) {
		return !StringUtils.isBlank(what);
	}

	@Override
	public String message() {
		return "can't be empty";
	}
}

