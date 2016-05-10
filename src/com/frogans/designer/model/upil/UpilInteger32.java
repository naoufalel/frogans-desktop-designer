/**
 * UPIL Interer32 Basic Type For Java
 *
 * @version		alpha0.15.1
 * @status		Alpha release
 *
 * @copyright	1999-2016 OP3FT
 *
 * @file
 */

package com.frogans.designer.model.upil;

public class UpilInteger32 {

	private int value;

	public UpilInteger32() {
	}

	public UpilInteger32(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}

}
