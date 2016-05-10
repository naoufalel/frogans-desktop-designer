/**
 * UPIL Buffer Basic Type For Java
 *
 * @version		alpha0.15.1
 * @status		Alpha release
 *
 * @copyright	1999-2016 OP3FT
 *
 * @file
 */

package frogans.upil;
import java.util.Arrays;

public class UpilBuffer {

	private byte[] value;

	public UpilBuffer() {
		value = new byte[0];
	}

	public UpilBuffer(byte[] bytes) {
		this.value = bytes;
	}

	public byte[] getValue() {
		return this.value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}

	public void clear() {
		Arrays.fill(this.value, (byte)0);
	}

	public String toString() {
		return "[" + this.value.length + " byte(s)]";
	}

}
