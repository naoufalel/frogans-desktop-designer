/**
 * UPIL Boolean Basic Type For Java
 *
 * @version		alpha0.15.1
 * @status		Alpha release
 *
 * @copyright	1999-2016 OP3FT
 *
 * @file
 */

package com.frogans.designer.model.upil;

public class UpilBoolean {

	private boolean value;

	public UpilBoolean() {
	}

	public UpilBoolean(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}

}
