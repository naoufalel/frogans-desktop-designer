/**
 * FSDL (Frogans Slide Description Language) Library
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

#ifndef _fsdl_h
#define _fsdl_h

#include "upil-types.h"

#ifdef __cplusplus
extern "C" {
#endif

#define FSDL_LIBRARY_VERSION "alpha0.15.1"

/**
 * Undefined failure code
 * Undefined failure code of a function.
 */
#define FSDL_FAILURE_CODE_UNDEFINED		100

/**
 * Function succeeded failure code
 * Code returned when function succeeded.
 */
#define FSDL_FAILURE_CODE_HAS_SUCCEEDED		200

/**
 * Range size of internal failure codes
 * Size of the range of internal failure codes available for each
 * function.
 */
#define FSDL_FAILURE_CODE_INTERNAL_RANGE_SIZE		100

/**
 * Library section
 * This section covers library initialization and finalization.
 *
 * @name Library section
 * @{
 */

/* Beginning of section: Library section */

/**
 * Initialize library
 *
 * Initializes the FSDL library.
 *
 * @param		in_version	Version; Version of the library.
 *							Must be the following string of ASCII characters
 *							(without a null-terminating character): 'alpha0.15.1'.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_library_initialize (upil_buffer in_version);

/**
 * Finalize library
 *
 * Finalizes the FSDL library.
 *
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_library_finalize (void);

/**
 * Get library version
 *
 * Gets the library version.
 *
 * @param [out]	out_library_version		Library version; Version of the library.
 *										Is the following string of ASCII characters
 *										(without a null-terminating character): 'alpha0.15.1'.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_library_get_version (upil_buffer *out_library_version);

/**
 * @name Library States
 * State of the library.
 * @anchor FSDL_LIBRARY_STATE_
 */

/**
 * Undefined
 * The state of the library is undefined.
 */
#define FSDL_LIBRARY_STATE_UNDEFINED					1010000

/**
 * Not initialized
 * The library is not initialized.
 */
#define FSDL_LIBRARY_STATE_NOT_INITIALIZED				1010001

/**
 * Initialization has failed
 * The initialization of the library has failed.
 */
#define FSDL_LIBRARY_STATE_INITIALIZATION_HAS_FAILED	1010002

/**
 * Initialized
 * The library is initialized.
 */
#define FSDL_LIBRARY_STATE_INITIALIZED					1010003

/**
 * Finalization has failed
 * The finalization of the library has failed.
 */
#define FSDL_LIBRARY_STATE_FINALIZATION_HAS_FAILED		1010004

/**
 * Finalized
 * The library is finalized.
 */
#define FSDL_LIBRARY_STATE_FINALIZED					1010005


/**
 * @name Library initialization errors
 * Library initialization errors returned by the fsdl_library_get_state() function.
 * @anchor FSDL_LIBRARY_INITIALIZATION_ERROR_
 */

/**
 * Undefined
 * Library initialization error is undefined.
 */
#define FSDL_LIBRARY_INITIALIZATION_ERROR_UNDEFINED					1020000

/**
 * No error
 * No library initialization error occurred.
 */
#define FSDL_LIBRARY_INITIALIZATION_ERROR_NO_ERROR					1020001

/**
 * Invalid library version
 * Version of the library is invalid.
 */
#define FSDL_LIBRARY_INITIALIZATION_ERROR_INVALID_LIBRARY_VERSION	1020002

/**
 * Internal range begin
 * Start of the internal range of library initialization errors.
 */
#define FSDL_LIBRARY_INITIALIZATION_ERROR_INTERNAL_RANGE_BEGIN		1021000


/**
 * @name Library finalization errors
 * Library finalization errors returned by the fsdl_library_get_state() function.
 * @anchor FSDL_LIBRARY_FINALIZATION_ERROR_
 */

/**
 * Undefined
 * Library finalization error is undefined.
 */
#define FSDL_LIBRARY_FINALIZATION_ERROR_UNDEFINED				1030000

/**
 * No error
 * No library finalization error occurred.
 */
#define FSDL_LIBRARY_FINALIZATION_ERROR_NO_ERROR				1030001

/**
 * Internal range begin
 * Start of the internal range of library finalization errors.
 */
#define FSDL_LIBRARY_FINALIZATION_ERROR_INTERNAL_RANGE_BEGIN	1031000


/**
 * Get library state
 *
 * Gets the library state.
 *
 * @param [out]	out_library_state			Library state; State of the library. See @ref FSDL_LIBRARY_STATE_....
 * @param [out]	out_initialization_error	Initialization error; Library initialization error. Applicable only if the library initialization has failed.
 * @param [out]	out_finalization_error		Finalization error; Library finalization error. Applicable only if the library finalization has failed.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_library_get_state (upil_integer32 *out_library_state,
														   upil_integer32 *out_initialization_error,
														   upil_integer32 *out_finalization_error);

/** @} */
/* End of section: Library section */

/**
 * Frogans slide handle section
 * This section covers the management of the handle of a Frogans
 * slide.
 *
 * @name Frogans slide handle section
 * @{
 */

/* Beginning of section: Frogans slide handle section */

/**
 * Undefined Frogans slide handle
 * Frogans slide handle is not defined.
 */
#define FSDL_SLIDE_HANDLE_UNDEFINED		100

/**
 * Maximum Frogans slide handle count
 * Maximum number of Frogans slide handles that can be created.
 */
#define FSDL_SLIDE_HANDLE_COUNT_MAX		1024

/**
 * @name String character encoding
 * String character encoding.
 * @anchor FSDL_STRING_ENCODING_
 */

/**
 * UTF-8
 * UTF-8 character encoding without BOM (byte order mark).
 */
#define FSDL_STRING_ENCODING_UTF8			2010001

/**
 * UTF-8 BOM
 * UTF-8 character encoding with BOM (byte order mark).
 */
#define FSDL_STRING_ENCODING_UTF8_BOM		2010002

/**
 * UTF-16E
 * UTF-16LE character encoding without BOM (byte order mark).
 */
#define FSDL_STRING_ENCODING_UTF16LE		2010003

/**
 * UTF-16E BOM
 * UTF-16LE character encoding with BOM (byte order mark).
 */
#define FSDL_STRING_ENCODING_UTF16LE_BOM	2010004

/**
 * UTF-16BE
 * UTF-16BE character encoding without BOM (byte order mark).
 */
#define FSDL_STRING_ENCODING_UTF16BE		2010005

/**
 * UTF-16BE BOM
 * UTF-16BE character encoding with BOM (byte order mark).
 */
#define FSDL_STRING_ENCODING_UTF16BE_BOM	2010006


/**
 * @name Image formats
 * Image formats.
 * @anchor FSDL_IMAGE_FORMAT_
 */

/**
 * Planes RGBA
 * The image content is made up of four component planes, in the
 * following order: red, green, blue, and alpha. The red component
 * plane contains the 8-bit red component of each pixel in the image,
 * ordered from the top-left to the bottom-right of the image. The
 * green, blue, and alpha component planes have the same structure.
 */
#define FSDL_IMAGE_FORMAT_PLANES_RGBA		2020001

/**
 * Pixels RGBA
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * red, green, blue, and alpha. Image pixels are ordered from the
 * top-left to the bottom-right of the image.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_RGBA		2020002

/**
 * Pixels ARGB
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * alpha, red, green, and blue. Image pixels are ordered from the
 * top-left to the bottom-right of the image.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_ARGB		2020003

/**
 * Pixels BGRA
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * blue, green, red, and alpha. Image pixels are ordered from the
 * top-left to the bottom-right of the image.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_BGRA		2020004

/**
 * Pixels ABGR
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * alpha, blue, green, and red. Image pixels are ordered from the
 * top-left to the bottom-right of the image.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_ABGR		2020005

/**
 * Pixels RGBA pre
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * red, green, blue, and alpha. Image pixels are ordered from the
 * top-left to the bottom-right of the image. The red, green, and
 * blue components are premultiplied by the alpha component.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_RGBA_PRE	2020006

/**
 * Pixels ARGB pre
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * alpha, red, green, and blue. Image pixels are ordered from the
 * top-left to the bottom-right of the image. The red, green, and
 * blue components are premultiplied by the alpha component.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_ARGB_PRE	2020007

/**
 * Pixels BGRA pre
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * blue, green, red, and alpha. Image pixels are ordered from the
 * top-left to the bottom-right of the image. The red, green, and
 * blue components are premultiplied by the alpha component.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_BGRA_PRE	2020008

/**
 * Pixels ABGR pre
 * The image content is made up of image pixels, where each pixel
 * is represented by four 8-bit components in the following order:
 * alpha, blue, green, and red. Image pixels are ordered from the
 * top-left to the bottom-right of the image. The red, green, and
 * blue components are premultiplied by the alpha component.
 */
#define FSDL_IMAGE_FORMAT_PIXELS_ABGR_PRE	2020009

/**
 * Encoded PNG
 * Image content is encoded using the PNG format
 * [https://www.w3.org/TR/PNG/]. The PNG image type is Truecolour
 * with alpha using a bit depth of 8. The PNG image contains the
 * following chunks: IDRH, IDAT, and IEND.
 */
#define FSDL_IMAGE_FORMAT_ENCODED_PNG		2020010


/**
 * @name Mask format
 * Mask formats.
 * @anchor FSDL_MASK_FORMAT_
 */

/**
 * Plane M
 * Image content is composed of the M (1-bit) plane.
 * This format is not available yet.
 */
#define FSDL_MASK_FORMAT_PLANE_M		2030001

/**
 * Encoded PNG
 * Mask content is encoded in PNG portable network graphics
 * format.
 */
#define FSDL_MASK_FORMAT_ENCODED_PNG	2030002


/**
 * Configuration
 * Frogans slide handle configuration.
 */
typedef struct
{
	/**
	 * String encoding
	 * The character encoding used for strings; see @ref FSDL_STRING_ENCODING_....
	 */
	upil_integer32 string_encoding;

	/**
	 * Image format
	 * The format used for images; see @ref FSDL_IMAGE_FORMAT_....
	 */
	upil_integer32 image_format;

	/**
	 * Mask format
	 * The format used for masks; see @ref FSDL_MASK_FORMAT_....
	 */
	upil_integer32 mask_format;

	/**
	 * Fonts file directory
	 * Directory that contains the FSDL fonts file
	 * ("fsdl-fonts.dat").
	 */
	upil_buffer fonts_file_directory;

} fsdl_configuration_record_t;

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_slide_handle_create() function.
 * @anchor FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_NULL_ARGUMENT					204001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_NOT_INITIALIZED				204002

/**
 * Invalid string encoding
 * Character encoding is invalid.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_INVALID_STRING_ENCODING		204003

/**
 * Invalid image format
 * Image format is invalid.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_INVALID_IMAGE_FORMAT			204004

/**
 * Invalid mask format
 * This failure code indicates that the mask format is invalid.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_INVALID_MASK_FORMAT			204005

/**
 * Invalid fonts file directory
 * This failure code indicates that FSDL fonts file directory is
 * invalid.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_INVALID_FONTS_FILE_DIRECTORY	204006

/**
 * Fonts file not found
 * This failure code indicates that the FSDL fonts file is not
 * found.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_FONTS_FILE_NOT_FOUND			204007

/**
 * Too many Frogans slides
 * This failure code indicates that there are too many created
 * Frogans slide handles; See FSDL_SLIDE_HANDLE_COUNT_MAX.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_TOO_MANY_SLIDES				204008

/**
 * Internal range begin
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_INTERNAL_RANGE_BEGIN			205000


/**
 * Create Frogans slide handle
 *
 * Creates a Frogans slide handle.
 *
 * @param		in_configuration	Configuration; Frogans slide handle configuration.
 * @param [out]	out_slide_handle	Frogans slide handle; The created Frogans slide handle.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_SLIDE_HANDLE_CREATE_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_slide_handle_create (fsdl_configuration_record_t *in_configuration,
															 upil_integer32 *out_slide_handle,
															 upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_slide_handle_destroy() function.
 * @anchor FSDL_FAILURE_CODE_SLIDE_HANDLE_DESTROY_
 */

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_DESTROY_NOT_INITIALIZED			2051001

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_DESTROY_NOT_RECOGNIZED_HANDLE	2051002

/**
 * Internal range begin
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_DESTROY_INTERNAL_RANGE_BEGIN		2052000


/**
 * Destroy Frogans slide handle
 *
 * Destroys a Frogans slide handle.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_SLIDE_HANDLE_DESTROY_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_slide_handle_destroy (upil_integer32 in_slide_handle,
															  upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_slide_handle_clear() function.
 * @anchor FSDL_FAILURE_CODE_SLIDE_HANDLE_CLEAR_
 */

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CLEAR_NOT_INITIALIZED		2061001

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CLEAR_NOT_RECOGNIZED_HANDLE	2061002

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_CLEAR_INTERNAL_RANGE_BEGIN	2062000


/**
 * Clear Frogans slide handle
 *
 * Clears a Frogans slide handle.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_SLIDE_HANDLE_CLEAR_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_slide_handle_clear (upil_integer32 in_slide_handle,
															upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_slide_handle_is() function.
 * @anchor FSDL_FAILURE_CODE_SLIDE_HANDLE_IS_
 */

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_IS_NOT_INITIALIZED			2071001

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_IS_NOT_RECOGNIZED_HANDLE		2071002

/**
 * Internal range begin
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_SLIDE_HANDLE_IS_INTERNAL_RANGE_BEGIN		2072000


/**
 * Is Frogans slide handle
 *
 * Indicates whether the handle is a Frogans slide handle.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_SLIDE_HANDLE_IS_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the handle is a Frogans slide handle,
 * UPIL_FALSE if the function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_slide_handle_is (upil_integer32 in_slide_handle,
														 upil_integer32 *out_failure_code);

/** @} */
/* End of section: Frogans slide handle section */

/**
 * Parsing section
 * This section covers the parsing of the FSDL document of a Frogans
 * slide.
 *
 * @name Parsing section
 * @{
 */

/* Beginning of section: Parsing section */

/**
 * @name Document encoding
 * Character encoding of FSDL documents.
 * @anchor FSDL_DOCUMENT_ENCODING_
 */

/**
 * UTF-8
 * UTF-8 character encoding with optional BOM (byte order mark).
 */
#define FSDL_DOCUMENT_ENCODING_UTF8		3010001

/**
 * UTF-16
 * UTF-16 character encoding with optional BOM (byte order mark).
 */
#define FSDL_DOCUMENT_ENCODING_UTF16	3010002


/**
 * @name FSDL version of document
 * FSDL specification version of the document.
 * @anchor FSDL_DOCUMENT_FSDL_VERSION_
 */

/**
 * FSDL 3.0
 * FSDL specification version 3.0.
 */
#define FSDL_DOCUMENT_FSDL_VERSION_FSDL_3_0		3020001


/**
 * Maximum document size
 * Maximum size (in bytes) of an FSDL document.
 */
#define FSDL_DOCUMENT_BYTE_COUNT_MAX		65536

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_perform() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_PERFORM_
 */

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_NOT_INITIALIZED					3031001

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_NOT_RECOGNIZED_HANDLE			3031002

/**
 * Invalid document encoding
 * Document character encoding is invalid.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_INVALID_DOCUMENT_ENCODING		3031003

/**
 * Invalid FSDL version of document
 * FSDL version of the document is invalid.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_INVALID_DOCUMENT_FSDL_VERSION	3031004

/**
 * Document is empty
 * Document is empty.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_DOCUMENT_IS_EMPTY				3031005

/**
 * Document long
 * Document size, in bytes, exceeds FSDL_DOCUMENT_BYTE_COUNT_MAX.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_DOCUMENT_LONG					3031006

/**
 * Document already parsed
 * Document has already been parsed successfully.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_DOCUMENT_ALREADY_PARSED			3031007

/**
 * Document encoding not UTF-8
 * Document character encoding is not UTF-8.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_DOCUMENT_ENCODING_NOT_UTF8		3031008

/**
 * Document encoding not UTF-16
 * Document character encoding is not UTF-16.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_DOCUMENT_ENCODING_NOT_UTF16		3031009

/**
 * XML error
 * An XML error occurred when parsing the document.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_XML_ERROR						3031010

/**
 * Validation error
 * Document is not a valid FSDL document.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_VALIDATION_ERROR				3031011

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_PERFORM_INTERNAL_RANGE_BEGIN			3032000


/**
 * Perform parse
 *
 * Performs the parsing of an FSDL document.
 *
 * @param		in_slide_handle				Frogans slide handle; Frogans slide handle.
 * @param		in_document_encoding		Document encoding; Document character encoding; see @ref FSDL_DOCUMENT_ENCODING_....
 * @param		in_document_fsdl_version	Document FSDL version; FSDL version of the document; see @ref FSDL_DOCUMENT_FSDL_VERSION_....
 * @param		in_document_content			Document content; Content of the document to parse.
 * @param [out]	out_failure_code			Failure code; Failure code of the function.
 *											If the function fails, the value equals one of the values
 *											defined in @ref FSDL_FAILURE_CODE_PARSE_PERFORM_....
 *											Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_perform (upil_integer32 in_slide_handle,
													   upil_integer32 in_document_encoding,
													   upil_integer32 in_document_fsdl_version,
													   upil_buffer in_document_content,
													   upil_integer32 *out_failure_code);

/**
 * XML error info
 * XML error information.
 */
typedef struct
{
	/**
	 * Message
	 * XML error message.
	 */
	upil_buffer message;

} fsdl_xml_error_info_record_t;

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_xml_error_info() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_
 */

/**
 * Null argiment
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_NULL_ARGUMENT			3041001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_NOT_INITIALIZED			3041002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_NOT_RECOGNIZED_HANDLE	3041003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_NOT_PARSED				3041004

/**
 * Parse succeeded
 * FSDL document was parsed successfully.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_PARSE_SUCCEEDED			3041005

/**
 * No XML error
 * No XML error occurred.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_NO_XML_ERROR				3041006

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_INTERNAL_RANGE_BEGIN		3042000


/**
 * Get XML error info
 *
 * Gets information about the XML error.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param [out]	out_xml_error_info	XML error info; XML error information.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_PARSE_GET_XML_ERROR_INFO_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_xml_error_info (upil_integer32 in_slide_handle,
																  fsdl_xml_error_info_record_t *out_xml_error_info,
																  upil_integer32 *out_failure_code);

/**
 * Validation error info
 * Validation error information.
 */
typedef struct
{
	/**
	 * Message
	 * Validation error message.
	 */
	upil_buffer message;

} fsdl_validation_error_info_record_t;

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_validation_error_info() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_NULL_ARGUMENT				3051001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_NOT_INITIALIZED			3051002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_NOT_RECOGNIZED_HANDLE		3051003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_NOT_PARSED				3051004

/**
 * Parse succeeded
 * FSDL document was parsed successfully.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_PARSE_SUCCEEDED			3051005

/**
 * No validation error
 * No validation error occurred.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_NO_VALIDATION_ERROR		3051006

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_INTERNAL_RANGE_BEGIN		3052000


/**
 * Get validation error info
 *
 * Gets information about the validation error.
 *
 * @param		in_slide_handle				Frogans slide handle; Frogans slide handle.
 * @param [out]	out_validation_error_info	Validation error info; Information about the validation error.
 * @param [out]	out_failure_code			Failure code; Failure code of the function.
 *											If the function fails, the value equals one of the values
 *											defined in @ref FSDL_FAILURE_CODE_PARSE_GET_VALIDATION_ERROR_INFO_....
 *											Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_validation_error_info (upil_integer32 in_slide_handle,
																		 fsdl_validation_error_info_record_t *out_validation_error_info,
																		 upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_auxiliary_file_count() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_NULL_ARGUMENT			3061001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_NOT_INITIALIZED		3061002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_NOT_RECOGNIZED_HANDLE	3061003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_NOT_PARSED				3061004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_PARSE_FAILED			3061005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_REDIRECT				3061006

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_INTERNAL_RANGE_BEGIN	3062000


/**
 * Get auxiliary file count
 *
 * Gets the count of auxiliary files.
 *
 * @param		in_slide_handle				Frogans slide handle; Frogans slide handle.
 * @param [out]	out_auxiliary_file_count	Auxiliary file count; Count of auxiliary files.
 * @param [out]	out_failure_code			Failure code; Failure code of the function.
 *											If the function fails, the value equals one of the values
 *											defined in @ref FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_COUNT_....
 *											Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_auxiliary_file_count (upil_integer32 in_slide_handle,
																		upil_integer32 *out_auxiliary_file_count,
																		upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_auxiliary_file_identifier() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_NULL_ARGUMENT				3071001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_NOT_INITIALIZED			3071002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_NOT_RECOGNIZED_HANDLE		3071003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_NOT_PARSED				3071004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_PARSE_FAILED				3071005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_REDIRECT					3071006

/**
 * Invalid index
 * File index is invalid.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_INVALID_INDEX				3071007

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_INTERNAL_RANGE_BEGIN		3072000


/**
 * Get auxiliary file identifier
 *
 * Gets the identifier of an auxiliary file.
 *
 * @param		in_slide_handle			Frogans slide handle; Frogans slide handle.
 * @param		in_index				Index; Index of the auxiliary file, starting at index 0.
 * @param [out]	out_file_identifier		File identifier; Identifier of the auxiliairy file.
 * @param [out]	out_failure_code		Failure code; Failure code of the function.
 *										If the function fails, the value equals one of the values
 *										defined in @ref FSDL_FAILURE_CODE_PARSE_GET_AUXILIARY_FILE_IDENTIFIER_....
 *										Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_auxiliary_file_identifier (upil_integer32 in_slide_handle,
																			 upil_integer32 in_index,
																			 upil_buffer *out_file_identifier,
																			 upil_integer32 *out_failure_code);

/**
 * @name File nature
 * Nature of the file.
 * @anchor FSDL_FILE_NATURE_
 */

/**
 * Undefined
 * The nature of the file is undefined.
 */
#define FSDL_FILE_NATURE_UNDEFINED	3080000

/**
 * Static
 * Indicates that the file is a static file in the Frogans site
 * root directory.
 */
#define FSDL_FILE_NATURE_STATIC		3080001

/**
 * Dynamic
 * Indicates that the file is a dynamic file in the Frogans site
 * root directory.
 */
#define FSDL_FILE_NATURE_DYNAMIC	3080002

/**
 * Embedded
 * Indicates that the file is not a file in the Frogans
 * site root directory but is embedded in the FSDL document.
 * Files of that type cannot be retrieved by the
 * fsdl_parse_get_auxiliary_file_identifier() function.
 */
#define FSDL_FILE_NATURE_EMBEDDED	3080003


/**
 * File info
 * Information about the file.
 */
typedef struct
{
	/**
	 * Name
	 * The name of the file.
	 */
	upil_buffer name;

	/**
	 * Nature
	 * Nature of the file.
	 */
	upil_integer32 nature;

	/**
	 * Cache
	 * Whether the file is added to the auxiliary file cache.
	 */
	upil_boolean cache;

} fsdl_file_info_record_t;

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_file_info() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_NULL_ARGUMENT				3091001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_NOT_INITIALIZED			3091002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_NOT_RECOGNIZED_HANDLE		3091003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_NOT_PARSED				3091004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_PARSE_FAILED				3091005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_REDIRECT					3091006

/**
 * Invalid identifier
 * File identifier is invalid.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_INVALID_IDENTIFIER		3091007

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_INTERNAL_RANGE_BEGIN		3092000


/**
 * Get file info
 *
 * Gets information about a file.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param		in_file_identifier	File identifier; Identifier of the file.
 * @param [out]	out_file_info		File info; Information about the file.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_PARSE_GET_FILE_INFO_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_file_info (upil_integer32 in_slide_handle,
															 upil_buffer in_file_identifier,
															 fsdl_file_info_record_t *out_file_info,
															 upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_resource_count() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_NULL_ARGUMENT			3101001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_NOT_INITIALIZED			3101002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_NOT_RECOGNIZED_HANDLE	3101003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_NOT_PARSED				3101004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_PARSE_FAILED				3101005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_REDIRECT					3101006

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_INTERNAL_RANGE_BEGIN		3102000


/**
 * Get resource count
 *
 * Gets the count of prepared resources defined in the FSDL
 * document.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param [out]	out_resource_count	Resource count; Count of prepared resources.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_COUNT_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_resource_count (upil_integer32 in_slide_handle,
																  upil_integer32 *out_resource_count,
																  upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_resource_identifier() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_NULL_ARGUMENT			3111001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_NOT_INITIALIZED			3111002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_NOT_RECOGNIZED_HANDLE	3111003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_NOT_PARSED				3111004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_PARSE_FAILED			3111005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_REDIRECT				3111006

/**
 * Invalid index
 * Index of the prepared resource is invalid.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_INVALID_INDEX			3111007

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_INTERNAL_RANGE_BEGIN	3112000


/**
 * Get resource identifier
 *
 * Gets the identifier of a prepared resource.
 *
 * @param		in_slide_handle				Frogans slide handle; Frogans slide handle.
 * @param		in_index					Index; Index of the prepared resource, starting at index 0.
 * @param [out]	out_resource_identifier		Resource identifier; Identifier of the prepared resource.
 * @param [out]	out_failure_code			Failure code; Failure code of the function.
 *											If the function fails, the value equals one of the values
 *											defined in @ref FSDL_FAILURE_CODE_PARSE_GET_RESOURCE_IDENTIFIER_....
 *											Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_resource_identifier (upil_integer32 in_slide_handle,
																	   upil_integer32 in_index,
																	   upil_buffer *out_resource_identifier,
																	   upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_layer_count() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_NULL_ARGUMENT			3121001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_NOT_INITIALIZED			3121002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_NOT_RECOGNIZED_HANDLE	3121003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_NOT_PARSED				3121004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_PARSE_FAILED			3121005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_REDIRECT				3121006

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_INTERNAL_RANGE_BEGIN	3122000


/**
 * Get layer count
 *
 * Gets the count of layer elements defined in the FSDL document.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param [out]	out_layer_count		Layer count; Count of layers.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_PARSE_GET_LAYER_COUNT_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_layer_count (upil_integer32 in_slide_handle,
															   upil_integer32 *out_layer_count,
															   upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_layer_identifier() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_NULL_ARGUMENT			3131001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_NOT_INITIALIZED		3131002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_NOT_RECOGNIZED_HANDLE	3131003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_NOT_PARSED				3131004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_PARSE_FAILED			3131005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_REDIRECT				3131006

/**
 * Invalid index
 * Index of the layer is invalid.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_INVALID_INDEX			3131007

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_INTERNAL_RANGE_BEGIN	3132000


/**
 * Get layer identifier
 *
 * Gets the identifier of the layer.
 *
 * @param		in_slide_handle			Frogans slide handle; Frogans slide handle.
 * @param		in_index				Index; Index of the layer, starting at index 0.
 * @param [out]	out_layer_identifier	Layer identifier; Identifier of the layer.
 * @param [out]	out_failure_code		Failure code; Failure code of the function.
 *										If the function fails, the value equals one of the values
 *										defined in @ref FSDL_FAILURE_CODE_PARSE_GET_LAYER_IDENTIFIER_....
 *										Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_layer_identifier (upil_integer32 in_slide_handle,
																	upil_integer32 in_index,
																	upil_buffer *out_layer_identifier,
																	upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_button_count() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_NULL_ARGUMENT			3141001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_NOT_INITIALIZED		3141002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_NOT_RECOGNIZED_HANDLE	3141003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_NOT_PARSED				3141004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_PARSE_FAILED			3141005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_REDIRECT				3141006

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_INTERNAL_RANGE_BEGIN	3142000


/**
 * Get button count
 *
 * Gets the count of buttons defined in the FSDL document.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param [out]	out_button_count	Button count; Count of buttons.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_PARSE_GET_BUTTON_COUNT_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_button_count (upil_integer32 in_slide_handle,
																upil_integer32 *out_button_count,
																upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_parse_get_button_identifier() function.
 * @anchor FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_NULL_ARGUMENT				3151001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_NOT_INITIALIZED			3151002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_NOT_RECOGNIZED_HANDLE		3151003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_NOT_PARSED				3151004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_PARSE_FAILED				3151005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_REDIRECT					3151006

/**
 * Invalid index
 * Index of the button is invalid.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_INVALID_INDEX				3151007

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_INTERNAL_RANGE_BEGIN		3152000


/**
 * Get button identifier
 *
 * Gets the identifier of a button.
 *
 * @param		in_slide_handle			Frogans slide handle; Frogans slide handle.
 * @param		in_index				Index; Index of the button, starting at index 0.
 * @param [out]	out_button_identifier	Button identifier; Identifier of the button.
 * @param [out]	out_failure_code		Failure code; Failure code of the function.
 *										If the function fails, the value equals one of the values
 *										defined in @ref FSDL_FAILURE_CODE_PARSE_GET_BUTTON_IDENTIFIER_....
 *										Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_parse_get_button_identifier (upil_integer32 in_slide_handle,
																	 upil_integer32 in_index,
																	 upil_buffer *out_button_identifier,
																	 upil_integer32 *out_failure_code);

/** @} */
/* End of section: Parsing section */

/**
 * Auxiliary file holding section
 * This section covers the holding of the auxiliary files of a
 * Frogans slide.
 *
 * @name Auxiliary file holding section
 * @{
 */

/* Beginning of section: Auxiliary file holding section */

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_hold_auxiliary_file_content() function.
 * @anchor FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_
 */

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_NOT_INITIALIZED			4011001

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_NOT_RECOGNIZED_HANDLE		4011002

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_NOT_PARSED				4011003

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_PARSE_FAILED				4011004

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_REDIRECT					4011005

/**
 * Invalid identifier
 * File identifier is invalid.
 */
#define FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_INVALID_IDENTIFIER		4011006

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_INTERNAL_RANGE_BEGIN		4012000


/**
 * Hold auxiliary file content
 *
 * Holds the content of an auxiliary file.
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param		in_file_identifier	File identifier; Identifier of the auxiliairy file.
 * @param		in_content			Content; Content of the auxiliary file.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_HOLD_AUXILIARY_FILE_CONTENT_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_hold_auxiliary_file_content (upil_integer32 in_slide_handle,
																	 upil_buffer in_file_identifier,
																	 upil_buffer in_content,
																	 upil_integer32 *out_failure_code);

/** @} */
/* End of section: Auxiliary file holding section */

/**
 * Rendering section
 * This section covers the rendering of a Frogans slide.
 *
 * @name Rendering section
 * @{
 */

/* Beginning of section: Rendering section */

/**
 * @name Rendering mode
 * Mode for rendering the Frogans slide.
 * @anchor FSDL_RENDER_MODE_
 */

/**
 * Rendering canvas
 * Mode used to render the rendering canvas, without access
 * to individual prepared resources and layers.
 */
#define FSDL_RENDER_MODE_RENDERING_CANVAS					5010001

/**
 * Rendering canvas and layers
 * Mode used to render the rendering canvas, with access
 * to individual prepared resources and layers.
 */
#define FSDL_RENDER_MODE_RENDERING_CANVAS_AND_LAYERS		5010002

/**
 * Rendering canvas and layers without constraints
 * Mode used to render the rendering canvas, with access
 * to individual prepared resources and layers, without applying
 * FSDL rendering constraints (not available yet).
 */
#define FSDL_RENDER_MODE_RENDERING_CANVAS_AND_LAYERS_NO_RC	5010003


/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_render_perform() function.
 * @anchor FSDL_FAILURE_CODE_RENDER_PERFORM_
 */

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_NOT_INITIALIZED			5021001

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_NOT_RECOGNIZED_HANDLE		5021002

/**
 * Invalid rendering mode
 * Rendering mode is not valid.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_INVALID_RENDER_MODE		5021002

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_NOT_PARSED					5021003

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_PARSE_FAILED				5021004

/**
 * Frogans slide byte size too large
 * The size, in bytes, of the Frogans slide (the FSDL document
 * size plus the total size of all loaded auxiliary files) is
 * too large.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_SLIDE_BYTE_SIZE_TOO_LARGE	5021005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_REDIRECT					5021006

/**
 * Rendering error
 * Rendering constraint error.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_RENDERING_ERROR			5021007

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_RENDER_PERFORM_INTERNAL_RANGE_BEGIN		5022000


/**
 * Perform render
 *
 * Performs the rendering of an FSDL document, according to
 * @ref FSDL_RENDER_MODE_....
 *
 * @param		in_slide_handle		Frogans slide handle; Frogans slide handle.
 * @param		in_render_mode		Rendering mode; Rendering mode.
 * @param [out]	out_failure_code	Failure code; Failure code of the function.
 *									If the function fails, the value equals one of the values
 *									defined in @ref FSDL_FAILURE_CODE_RENDER_PERFORM_....
 *									Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_render_perform (upil_integer32 in_slide_handle,
														upil_integer32 in_render_mode,
														upil_integer32 *out_failure_code);

/**
 * Image
 * Rendered image.
 */
typedef struct
{
	/**
	 * Width
	 * Width of the image, in pixels.
	 */
	upil_integer32 width;

	/**
	 * Height
	 * Height of the image, in pixels.
	 */
	upil_integer32 height;

	/**
	 * Content
	 * Content of the image in the format defined in
	 * @ref FSDL_IMAGE_FORMAT_... in the Frogans slide handle configuration.
	 */
	upil_buffer content;

} fsdl_image_record_t;

/**
 * Rollover
 * A rendered rollover associated with a button.
 */
typedef struct
{
	/**
	 * Image
	 * Image of the rollover.
	 */
	fsdl_image_record_t image;

	/**
	 * X coordinate
	 * X coordinate, in pixels, of the rollover from the top/left
	 * corner of the Frogans slide.
	 */
	upil_integer32 x;

	/**
	 * Y coordinate
	 * Y coordinate, in pixels, of the rollover from the top/left
	 * corner of the Frogans slide.
	 */
	upil_integer32 y;

} fsdl_rollover_record_t;

/**
 * Rollovers
 * Rendered rollovers associated with buttons.
 */
typedef struct
{
	upil_integer32 count;
	fsdl_rollover_record_t *items;

} fsdl_rollovers_collection_t;

/**
 * Maximum rollover count
 * Maximum number of rollovers in a Frogans slide.
 */
#define FSDL_ROLLOVER_COUNT_MAX		32

/**
 * Composition
 * Images, masks, and rollovers associated with the lead or
 * vignette representation of the Frogans slide, or with a view
 * of the Frogans slide.
 */
typedef struct
{
	/**
	 * Background image
	 * Image of the background.
	 */
	fsdl_image_record_t background_image;

	/**
	 * Rollovers
	 * Rollovers associated with buttons.
	 */
	fsdl_rollovers_collection_t rollovers;

} fsdl_composition_record_t;

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_render_get_rendering_canvas() function.
 * @anchor FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_NULL_ARGUMENT				5031001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_NOT_INITIALIZED			5031002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_NOT_RECOGNIZED_HANDLE		5031003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_NOT_PARSED				5031004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_PARSE_FAILED				5031005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_REDIRECT					5031006

/**
 * Not rendered
 * FSDL document is not rendered.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_NOT_RENDERED				5031007

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_INTERNAL_RANGE_BEGIN		5032000


/**
 * Get rendering canvas
 *
 * Gets the lead and vignette representations of the Frogans slide.
 *
 * @param		in_slide_handle					Frogans slide handle; Frogans slide handle.
 * @param [out]	out_lead_representation			Lead representation; Lead representation of the Frogans slide.
 * @param [out]	out_vignette_representation		Vignette representation; Vignette representation of the Frogans slide.
 * @param [out]	out_failure_code				Failure code; Failure code of the function.
 *												If the function fails, the value equals one of the values
 *												defined in @ref FSDL_FAILURE_CODE_RENDER_GET_RENDERING_CANVAS_....
 *												Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_render_get_rendering_canvas (upil_integer32 in_slide_handle,
																	 fsdl_composition_record_t *out_lead_representation,
																	 fsdl_composition_record_t *out_vignette_representation,
																	 upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_render_get_prepared_resource() function.
 * @anchor FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_NULL_ARGUMENT			5041001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_NOT_INITIALIZED			5041002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_NOT_RECOGNIZED_HANDLE	5041003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_NOT_PARSED				5041004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_PARSE_FAILED				5041005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_REDIRECT					5041006

/**
 * Not rendered
 * FSDL document is not rendered.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_NOT_RENDERED				5041007

/**
 * Invalid rendering mode
 * Rendering mode is not valid.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_INVALID_RENDER_MODE		5041008

/**
 * Invalid identifier
 * Identifier of the prepared resource is not valid.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_INVALID_IDENTIFIER		5041009

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_INTERNAL_RANGE_BEGIN		5042000


/**
 * Get prepared resource
 *
 * Gets the rendered image corresponding to a prepared resource.
 *
 * @param		in_slide_handle			Frogans slide handle; Frogans slide handle.
 * @param		in_resource_identifier	Resource identifier; Identifier of the prepared resource.
 * @param [out]	out_resource			Resource; Rendered image of the prepared resource.
 * @param [out]	out_failure_code		Failure code; Failure code of the function.
 *										If the function fails, the value equals one of the values
 *										defined in @ref FSDL_FAILURE_CODE_RENDER_GET_PREPARED_RESOURCE_....
 *										Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_render_get_prepared_resource (upil_integer32 in_slide_handle,
																	  upil_buffer in_resource_identifier,
																	  fsdl_image_record_t *out_resource,
																	  upil_integer32 *out_failure_code);

/**
 * @name Failure codes
 * Failure codes returned by the
 * fsdl_render_get_layer() function.
 * @anchor FSDL_FAILURE_CODE_RENDER_GET_LAYER_
 */

/**
 * Null argument
 * One of the arguments is null.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_NULL_ARGUMENT			5051001

/**
 * Not initialized
 * Library is not initialized.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_NOT_INITIALIZED			5051002

/**
 * Handle not recognized
 * Frogans slide handle is not recognized.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_NOT_RECOGNIZED_HANDLE	5051003

/**
 * Not parsed
 * FSDL document has not been parsed yet.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_NOT_PARSED				5051004

/**
 * Parse failed
 * Parsing of FSDL document failed.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_PARSE_FAILED				5051005

/**
 * Redirect
 * FSDL document is a FSDL redirection document, it cannot be
 * rendered.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_REDIRECT					5051006

/**
 * Not rendered
 * FSDL document is not rendered.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_NOT_RENDERED				5051007

/**
 * Invalid rendering mode
 * Rendering mode is not valid.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_INVALID_RENDER_MODE		5051008

/**
 * Invalid identifier
 * Identifier of the prepared resource is not valid.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_INVALID_IDENTIFIER		5051009

/**
 * Begin internal range
 * Start of the internal range of failure codes.
 */
#define FSDL_FAILURE_CODE_RENDER_GET_LAYER_INTERNAL_RANGE_BEGIN		5052000


/**
 * Get layer
 *
 * Gets the rendered image corresponding to a layer.
 *
 * @param		in_slide_handle			Frogans slide handle; Frogans slide handle.
 * @param		in_layer_identifier		Layer identifier; Identifier of the layer.
 * @param [out]	out_x					X coordinate; X coordinate, in pixels, of the rendered image of the layer
 *										from the top/left corner of the rendering canvas.
 * @param [out]	out_y					Y coordinate; Y coordinate, in pixels, of the rendered image of the layer
 *										from the top/left corner of the rendering canvas.
 * @param [out]	out_layer				Layer; Image of the layer.
 * @param [out]	out_failure_code		Failure code; Failure code of the function.
 *										If the function fails, the value equals one of the values
 *										defined in @ref FSDL_FAILURE_CODE_RENDER_GET_LAYER_....
 *										Otherwise, the value equals FSDL_FAILURE_CODE_HAS_SUCCEEDED.
 * @return Returns UPIL_TRUE if the function succeeds, UPIL_FALSE if the
 * function fails.
 */
UPIL_LIBAPI upil_boolean UPIL_CALL fsdl_render_get_layer (upil_integer32 in_slide_handle,
														  upil_buffer in_layer_identifier,
														  upil_integer32 *out_x,
														  upil_integer32 *out_y,
														  fsdl_image_record_t *out_layer,
														  upil_integer32 *out_failure_code);

/** @} */
/* End of section: Rendering section */


#ifdef __cplusplus
}
#endif

#endif	/* _fsdl_h */

