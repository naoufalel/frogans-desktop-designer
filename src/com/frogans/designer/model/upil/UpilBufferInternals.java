/**
 * UPIL Buffer Basic Type For Java - Internals
 *
 * @version		alpha0.15.1
 * @status		Alpha release
 *
 * @copyright	1999-2016 OP3FT
 *
 * @file
 */

package com.frogans.designer.model.upil;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class UpilBufferInternals {

	public static UpilBuffer build(UpilBuffer self, DataInputStream is) throws IOException {
		if (self == null) {
			self = new UpilBuffer();
		}

		int length = is.readInt();
		byte[] bytes = new byte[length];

		for (int i = 0; i < length; i++) {
			bytes[i] = is.readByte();
		}

		self.setValue(bytes);

		return self;
	}

	public static UpilBuffer buildFromByteArray(UpilBuffer self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));

		return build(self, is);
	}
}
