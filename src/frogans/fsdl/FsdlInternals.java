/**
 * FSDL (Frogans Slide Description Language) Library - Internals
 *
 * @version		alpha0.15.1
 * @status		Alpha release
 *
 * @copyright	1999-2016 OP3FT
 *
 * This software library is the reference implementation of the Frogans
 * Slide Description Language (FSDL) technical specification version 3.0.
 *
 * This software library, which includes sources and binaries, is provided
 * free of charge for use in independent software developed by third
 * parties. Its use is subject to the Frogans Technology User Policy
 * which is published on the official Web site of the Frogans technology
 * at the following permanent URL:
 * https://www.frogans.org/en/resources/ftup/access.html
 *
 * This version of the FSDL Software Library is embedded in version
 * alpha0.15.1 of Frogans Player for Developers, which is accessible at
 * the following permanent URL:
 * https://get.frogans/en/main.html
 *
 * Note: The FSDL Software Library (alpha) is a preliminary version
 * provided on an "as is" basis. The OP3FT cannot guarantee that the
 * rendering performed by this alpha version will be compatible down to the
 * last pixel with the rendering performed by the release version of the
 * FSDL Software Library. The API of the FSDL Software Library is also
 * subject to change.
 *
 * This software library and the FSDL technical specification are
 * accessible at the following permanent URL:
 * https://www.frogans.org/en/resources/fsdl/access.html
 *
 * @file
 */

package frogans.fsdl;

import frogans.upil.UpilBufferInternals;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FsdlInternals {

	public static Fsdl.Configuration buildConfigurationFromByteArray(Fsdl.Configuration self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildConfiguration(self, is);
	}

	public static Fsdl.Configuration buildConfiguration(Fsdl.Configuration self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.Configuration();
		self.stringEncoding = is.readInt();
		self.imageFormat = is.readInt();
		self.maskFormat = is.readInt();
		self.fontsFileDirectory = UpilBufferInternals.build(null, is);
		return self;
	}

	public static Fsdl.XmlErrorInfo buildXmlErrorInfoFromByteArray(Fsdl.XmlErrorInfo self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildXmlErrorInfo(self, is);
	}

	public static Fsdl.XmlErrorInfo buildXmlErrorInfo(Fsdl.XmlErrorInfo self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.XmlErrorInfo();
		self.message = UpilBufferInternals.build(null, is);
		return self;
	}

	public static Fsdl.ValidationErrorInfo buildValidationErrorInfoFromByteArray(Fsdl.ValidationErrorInfo self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildValidationErrorInfo(self, is);
	}

	public static Fsdl.ValidationErrorInfo buildValidationErrorInfo(Fsdl.ValidationErrorInfo self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.ValidationErrorInfo();
		self.message = UpilBufferInternals.build(null, is);
		return self;
	}

	public static Fsdl.FileInfo buildFileInfoFromByteArray(Fsdl.FileInfo self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildFileInfo(self, is);
	}

	public static Fsdl.FileInfo buildFileInfo(Fsdl.FileInfo self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.FileInfo();
		self.name = UpilBufferInternals.build(null, is);
		self.nature = is.readInt();
		self.cache = is.readBoolean();
		return self;
	}

	public static Fsdl.Image buildImageFromByteArray(Fsdl.Image self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildImage(self, is);
	}

	public static Fsdl.Image buildImage(Fsdl.Image self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.Image();
		self.width = is.readInt();
		self.height = is.readInt();
		self.content = UpilBufferInternals.build(null, is);
		return self;
	}

	public static Fsdl.Rollover buildRolloverFromByteArray(Fsdl.Rollover self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildRollover(self, is);
	}

	public static Fsdl.Rollover buildRollover(Fsdl.Rollover self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.Rollover();
		self.image = buildImage(null, is);
		self.x = is.readInt();
		self.y = is.readInt();
		return self;
	}

	public static Fsdl.Rollovers buildRolloversFromByteArray(Fsdl.Rollovers self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildRollovers(self, is);
	}

	public static Fsdl.Rollovers buildRollovers(Fsdl.Rollovers self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.Rollovers();
		int itemCount = is.readInt();
		self.items = new Fsdl.Rollover[itemCount];
		for (int i = 0; i < itemCount; i++) {
			self.items[i] = buildRollover(null, is);
		}
		return self;
	}

	public static Fsdl.Composition buildCompositionFromByteArray(Fsdl.Composition self, byte[] data) throws IOException {
		DataInputStream is = new DataInputStream(new ByteArrayInputStream(data));
		return buildComposition(self, is);
	}

	public static Fsdl.Composition buildComposition(Fsdl.Composition self, DataInputStream is) throws IOException {
		if (self == null)
			self = new Fsdl.Composition();
		self.backgroundImage = buildImage(null, is);
		self.rollovers = buildRollovers(null, is);
		return self;
	}

}
