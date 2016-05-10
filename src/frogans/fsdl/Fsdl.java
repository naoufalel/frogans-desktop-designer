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

package frogans.fsdl;

import frogans.upil.UpilBuffer;
import frogans.upil.UpilInteger32;

public class Fsdl {
	/**
	 * Undefined failure code
	 * <p>
	 * Undefined failure code of a function.
	 */
	public static final int FAILURE_CODE_UNDEFINED = 100;
	/**
	 * Function succeeded failure code
	 * <p>
	 * Code returned when function succeeded.
	 */
	public static final int FAILURE_CODE_HAS_SUCCEEDED = 200;
	/**
	 * Range size of internal failure codes
	 * <p>
	 * Size of the range of internal failure codes available for each
	 * function.
	 */
	public static final int FAILURE_CODE_INTERNAL_RANGE_SIZE = 100;
	/**
	 * Undefined Frogans slide handle
	 * <p>
	 * Frogans slide handle is not defined.
	 */
	public static final int SLIDE_HANDLE_UNDEFINED = 100;

	/**
	 * Library section
	 * <p>
	 * This section covers library initialization and finalization.
	 *
	 * @name Library section
	 * @{
	 */

	/* Beginning of section: Library section */
	/**
	 * Maximum Frogans slide handle count
	 * <p>
	 * Maximum number of Frogans slide handles that can be created.
	 */
	public static final int SLIDE_HANDLE_COUNT_MAX = 1024;
	/**
	 * Maximum document size
	 * <p>
	 * Maximum size (in bytes) of an FSDL document.
	 */
	public static final int DOCUMENT_BYTE_COUNT_MAX = 65536;
	/**
	 * Maximum rollover count
	 * <p>
	 * Maximum number of rollovers in a Frogans slide.
	 */
	public static final int ROLLOVER_COUNT_MAX = 32;

	static {
		System.loadLibrary("fsdl-alpha0.15.1");
		System.loadLibrary ("fsdl4java-alpha0.15.1");

	}

	/**
	 * Get library version
	 * <p>
	 * Gets the library version.
	 *
	 * @param outLibraryVersion		Library version<p> Version of the library.
	 *								Is the following string of ASCII characters
	 *								(without a null-terminating character): 'alpha0.15.1'.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean libraryGetVersion (UpilBuffer outLibraryVersion) {
		return fsdl_library_get_version (outLibraryVersion);
	}

	private static native boolean fsdl_library_get_version(UpilBuffer outLibraryVersion);

	/**
	 * Get library state
	 * <p>
	 * Gets the library state.
	 *
	 * @param outLibraryState        Library state<p> State of the library. See LibraryState.
	 * @param outInitializationError Initialization error<p> Library initialization error. Applicable only if the library initialization has failed.
	 * @param outFinalizationError   Finalization error<p> Library finalization error. Applicable only if the library finalization has failed.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean libraryGetState(UpilInteger32 outLibraryState,
										  UpilInteger32 outInitializationError,
										  UpilInteger32 outFinalizationError) {
		return fsdl_library_get_state(outLibraryState, outInitializationError, outFinalizationError);
	}

	/** @} */
	/* End of section: Library section */

	/**
	 * Frogans slide handle section
	 * <p>
	 * This section covers the management of the handle of a Frogans
	 * slide.
	 *
	 * @name Frogans slide handle section
	 * @{
	 */

	/* Beginning of section: Frogans slide handle section */
	private static native boolean fsdl_library_get_state(UpilInteger32 outLibraryState,
														 UpilInteger32 outInitializationError,
														 UpilInteger32 outFinalizationError);

	/**
	 * Create Frogans slide handle
	 * <p>
	 * Creates a Frogans slide handle.
	 *
	 * @param inConfiguration Configuration<p> Frogans slide handle configuration.
	 * @param outSlideHandle  Frogans slide handle<p> The created Frogans slide handle.
	 * @param outFailureCode  Failure code<p> Failure code of the function.
	 *                        If the function fails, the value equals one of the values
	 *                        defined in FailureCodeSlideHandleCreate.
	 *                        Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean slideHandleCreate(Configuration inConfiguration,
											UpilInteger32 outSlideHandle,
											UpilInteger32 outFailureCode) {
		return fsdl_slide_handle_create(inConfiguration, outSlideHandle, outFailureCode);
	}

	private static native boolean fsdl_slide_handle_create(Configuration inConfiguration,
														   UpilInteger32 outSlideHandle,
														   UpilInteger32 outFailureCode);

	/**
	 * Destroy Frogans slide handle
	 * <p>
	 * Destroys a Frogans slide handle.
	 *
	 * @param inSlideHandle  Frogans slide handle<p> Frogans slide handle.
	 * @param outFailureCode Failure code<p> Failure code of the function.
	 *                       If the function fails, the value equals one of the values
	 *                       defined in FailureCodeSlideHandleDestroy.
	 *                       Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean slideHandleDestroy(int inSlideHandle,
											 UpilInteger32 outFailureCode) {
		return fsdl_slide_handle_destroy(inSlideHandle, outFailureCode);
	}

	private static native boolean fsdl_slide_handle_destroy(int inSlideHandle,
															UpilInteger32 outFailureCode);

	/**
	 * Clear Frogans slide handle
	 * <p>
	 * Clears a Frogans slide handle.
	 *
	 * @param inSlideHandle  Frogans slide handle<p> Frogans slide handle.
	 * @param outFailureCode Failure code<p> Failure code of the function.
	 *                       If the function fails, the value equals one of the values
	 *                       defined in FailureCodeSlideHandleClear.
	 *                       Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean slideHandleClear(int inSlideHandle,
										   UpilInteger32 outFailureCode) {
		return fsdl_slide_handle_clear(inSlideHandle, outFailureCode);
	}

	private static native boolean fsdl_slide_handle_clear(int inSlideHandle,
														  UpilInteger32 outFailureCode);

	/**
	 * Is Frogans slide handle
	 * <p>
	 * Indicates whether the handle is a Frogans slide handle.
	 *
	 * @param inSlideHandle  Frogans slide handle<p> Frogans slide handle.
	 * @param outFailureCode Failure code<p> Failure code of the function.
	 *                       If the function fails, the value equals one of the values
	 *                       defined in FailureCodeSlideHandleIs.
	 *                       Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the handle is a Frogans slide handle,
	 * false if the function fails.
	 */
	public static boolean slideHandleIs(int inSlideHandle,
										UpilInteger32 outFailureCode) {
		return fsdl_slide_handle_is(inSlideHandle, outFailureCode);
	}

	private static native boolean fsdl_slide_handle_is(int inSlideHandle,
													   UpilInteger32 outFailureCode);

	/**
	 * Perform parse
	 * <p>
	 * Performs the parsing of an FSDL document.
	 *
	 * @param inSlideHandle         Frogans slide handle<p> Frogans slide handle.
	 * @param inDocumentEncoding    Document encoding<p> Document character encoding; see DocumentEncoding.
	 * @param inDocumentFsdlVersion Document FSDL version<p> FSDL version of the document; see DocumentFsdlVersion.
	 * @param inDocumentContent     Document content<p> Content of the document to parse.
	 * @param outFailureCode        Failure code<p> Failure code of the function.
	 *                              If the function fails, the value equals one of the values
	 *                              defined in FailureCodeParsePerform.
	 *                              Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parsePerform(int inSlideHandle,
									   int inDocumentEncoding,
									   int inDocumentFsdlVersion,
									   UpilBuffer inDocumentContent,
									   UpilInteger32 outFailureCode) {
		return fsdl_parse_perform(inSlideHandle, inDocumentEncoding, inDocumentFsdlVersion, inDocumentContent, outFailureCode);
	}

	private static native boolean fsdl_parse_perform(int inSlideHandle,
													 int inDocumentEncoding,
													 int inDocumentFsdlVersion,
													 UpilBuffer inDocumentContent,
													 UpilInteger32 outFailureCode);

	/**
	 * Get XML error info
	 * <p>
	 * Gets information about the XML error.
	 *
	 * @param inSlideHandle   Frogans slide handle<p> Frogans slide handle.
	 * @param outXmlErrorInfo XML error info<p> XML error information.
	 * @param outFailureCode  Failure code<p> Failure code of the function.
	 *                        If the function fails, the value equals one of the values
	 *                        defined in FailureCodeParseGetXmlErrorInfo.
	 *                        Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetXmlErrorInfo(int inSlideHandle,
											   XmlErrorInfo outXmlErrorInfo,
											   UpilInteger32 outFailureCode) {
		return fsdl_parse_get_xml_error_info(inSlideHandle, outXmlErrorInfo, outFailureCode);
	}

	private static native boolean fsdl_parse_get_xml_error_info(int inSlideHandle,
																XmlErrorInfo outXmlErrorInfo,
																UpilInteger32 outFailureCode);

	/**
	 * Get validation error info
	 * <p>
	 * Gets information about the validation error.
	 *
	 * @param inSlideHandle          Frogans slide handle<p> Frogans slide handle.
	 * @param outValidationErrorInfo Validation error info<p> Information about the validation error.
	 * @param outFailureCode         Failure code<p> Failure code of the function.
	 *                               If the function fails, the value equals one of the values
	 *                               defined in FailureCodeParseGetValidationErrorInfo.
	 *                               Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetValidationErrorInfo(int inSlideHandle,
													  ValidationErrorInfo outValidationErrorInfo,
													  UpilInteger32 outFailureCode) {
		return fsdl_parse_get_validation_error_info(inSlideHandle, outValidationErrorInfo, outFailureCode);
	}

	private static native boolean fsdl_parse_get_validation_error_info(int inSlideHandle,
																	   ValidationErrorInfo outValidationErrorInfo,
																	   UpilInteger32 outFailureCode);

	/**
	 * Get auxiliary file count
	 * <p>
	 * Gets the count of auxiliary files.
	 *
	 * @param inSlideHandle         Frogans slide handle<p> Frogans slide handle.
	 * @param outAuxiliaryFileCount Auxiliary file count<p> Count of auxiliary files.
	 * @param outFailureCode        Failure code<p> Failure code of the function.
	 *                              If the function fails, the value equals one of the values
	 *                              defined in FailureCodeParseGetAuxiliaryFileCount.
	 *                              Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetAuxiliaryFileCount(int inSlideHandle,
													 UpilInteger32 outAuxiliaryFileCount,
													 UpilInteger32 outFailureCode) {
		return fsdl_parse_get_auxiliary_file_count(inSlideHandle, outAuxiliaryFileCount, outFailureCode);
	}

	private static native boolean fsdl_parse_get_auxiliary_file_count(int inSlideHandle,
																	  UpilInteger32 outAuxiliaryFileCount,
																	  UpilInteger32 outFailureCode);

	/**
	 * Get auxiliary file identifier
	 * <p>
	 * Gets the identifier of an auxiliary file.
	 *
	 * @param inSlideHandle     Frogans slide handle<p> Frogans slide handle.
	 * @param inIndex           Index<p> Index of the auxiliary file, starting at index 0.
	 * @param outFileIdentifier File identifier<p> Identifier of the auxiliairy file.
	 * @param outFailureCode    Failure code<p> Failure code of the function.
	 *                          If the function fails, the value equals one of the values
	 *                          defined in FailureCodeParseGetAuxiliaryFileIdentifier.
	 *                          Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetAuxiliaryFileIdentifier(int inSlideHandle,
														  int inIndex,
														  UpilBuffer outFileIdentifier,
														  UpilInteger32 outFailureCode) {
		return fsdl_parse_get_auxiliary_file_identifier(inSlideHandle, inIndex, outFileIdentifier, outFailureCode);
	}

	/** @} */
	/* End of section: Frogans slide handle section */

	/**
	 * Parsing section
	 * <p>
	 * This section covers the parsing of the FSDL document of a Frogans
	 * slide.
	 *
	 * @name Parsing section
	 * @{
	 */

	/* Beginning of section: Parsing section */
	private static native boolean fsdl_parse_get_auxiliary_file_identifier(int inSlideHandle,
																		   int inIndex,
																		   UpilBuffer outFileIdentifier,
																		   UpilInteger32 outFailureCode);

	/**
	 * Get file info
	 * <p>
	 * Gets information about a file.
	 *
	 * @param inSlideHandle    Frogans slide handle<p> Frogans slide handle.
	 * @param inFileIdentifier File identifier<p> Identifier of the file.
	 * @param outFileInfo      File info<p> Information about the file.
	 * @param outFailureCode   Failure code<p> Failure code of the function.
	 *                         If the function fails, the value equals one of the values
	 *                         defined in FailureCodeParseGetFileInfo.
	 *                         Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetFileInfo(int inSlideHandle,
										   UpilBuffer inFileIdentifier,
										   FileInfo outFileInfo,
										   UpilInteger32 outFailureCode) {
		return fsdl_parse_get_file_info(inSlideHandle, inFileIdentifier, outFileInfo, outFailureCode);
	}

	private static native boolean fsdl_parse_get_file_info(int inSlideHandle,
														   UpilBuffer inFileIdentifier,
														   FileInfo outFileInfo,
														   UpilInteger32 outFailureCode);

	/**
	 * Get resource count
	 * <p>
	 * Gets the count of prepared resources defined in the FSDL
	 * document.
	 *
	 * @param inSlideHandle    Frogans slide handle<p> Frogans slide handle.
	 * @param outResourceCount Resource count<p> Count of prepared resources.
	 * @param outFailureCode   Failure code<p> Failure code of the function.
	 *                         If the function fails, the value equals one of the values
	 *                         defined in FailureCodeParseGetResourceCount.
	 *                         Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetResourceCount(int inSlideHandle,
												UpilInteger32 outResourceCount,
												UpilInteger32 outFailureCode) {
		return fsdl_parse_get_resource_count(inSlideHandle, outResourceCount, outFailureCode);
	}

	private static native boolean fsdl_parse_get_resource_count(int inSlideHandle,
																UpilInteger32 outResourceCount,
																UpilInteger32 outFailureCode);

	/**
	 * Get resource identifier
	 * <p>
	 * Gets the identifier of a prepared resource.
	 *
	 * @param inSlideHandle         Frogans slide handle<p> Frogans slide handle.
	 * @param inIndex               Index<p> Index of the prepared resource, starting at index 0.
	 * @param outResourceIdentifier Resource identifier<p> Identifier of the prepared resource.
	 * @param outFailureCode        Failure code<p> Failure code of the function.
	 *                              If the function fails, the value equals one of the values
	 *                              defined in FailureCodeParseGetResourceIdentifier.
	 *                              Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetResourceIdentifier(int inSlideHandle,
													 int inIndex,
													 UpilBuffer outResourceIdentifier,
													 UpilInteger32 outFailureCode) {
		return fsdl_parse_get_resource_identifier(inSlideHandle, inIndex, outResourceIdentifier, outFailureCode);
	}

	private static native boolean fsdl_parse_get_resource_identifier(int inSlideHandle,
																	 int inIndex,
																	 UpilBuffer outResourceIdentifier,
																	 UpilInteger32 outFailureCode);

	/**
	 * Get layer count
	 * <p>
	 * Gets the count of layer elements defined in the FSDL document.
	 *
	 * @param inSlideHandle  Frogans slide handle<p> Frogans slide handle.
	 * @param outLayerCount  Layer count<p> Count of layers.
	 * @param outFailureCode Failure code<p> Failure code of the function.
	 *                       If the function fails, the value equals one of the values
	 *                       defined in FailureCodeParseGetLayerCount.
	 *                       Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetLayerCount(int inSlideHandle,
											 UpilInteger32 outLayerCount,
											 UpilInteger32 outFailureCode) {
		return fsdl_parse_get_layer_count(inSlideHandle, outLayerCount, outFailureCode);
	}

	private static native boolean fsdl_parse_get_layer_count(int inSlideHandle,
															 UpilInteger32 outLayerCount,
															 UpilInteger32 outFailureCode);

	/**
	 * Get layer identifier
	 * <p>
	 * Gets the identifier of the layer.
	 *
	 * @param inSlideHandle      Frogans slide handle<p> Frogans slide handle.
	 * @param inIndex            Index<p> Index of the layer, starting at index 0.
	 * @param outLayerIdentifier Layer identifier<p> Identifier of the layer.
	 * @param outFailureCode     Failure code<p> Failure code of the function.
	 *                           If the function fails, the value equals one of the values
	 *                           defined in FailureCodeParseGetLayerIdentifier.
	 *                           Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetLayerIdentifier(int inSlideHandle,
												  int inIndex,
												  UpilBuffer outLayerIdentifier,
												  UpilInteger32 outFailureCode) {
		return fsdl_parse_get_layer_identifier(inSlideHandle, inIndex, outLayerIdentifier, outFailureCode);
	}

	private static native boolean fsdl_parse_get_layer_identifier(int inSlideHandle,
																  int inIndex,
																  UpilBuffer outLayerIdentifier,
																  UpilInteger32 outFailureCode);

	/**
	 * Get button count
	 * <p>
	 * Gets the count of buttons defined in the FSDL document.
	 *
	 * @param inSlideHandle  Frogans slide handle<p> Frogans slide handle.
	 * @param outButtonCount Button count<p> Count of buttons.
	 * @param outFailureCode Failure code<p> Failure code of the function.
	 *                       If the function fails, the value equals one of the values
	 *                       defined in FailureCodeParseGetButtonCount.
	 *                       Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetButtonCount(int inSlideHandle,
											  UpilInteger32 outButtonCount,
											  UpilInteger32 outFailureCode) {
		return fsdl_parse_get_button_count(inSlideHandle, outButtonCount, outFailureCode);
	}

	private static native boolean fsdl_parse_get_button_count(int inSlideHandle,
															  UpilInteger32 outButtonCount,
															  UpilInteger32 outFailureCode);

	/**
	 * Get button identifier
	 * <p>
	 * Gets the identifier of a button.
	 *
	 * @param inSlideHandle       Frogans slide handle<p> Frogans slide handle.
	 * @param inIndex             Index<p> Index of the button, starting at index 0.
	 * @param outButtonIdentifier Button identifier<p> Identifier of the button.
	 * @param outFailureCode      Failure code<p> Failure code of the function.
	 *                            If the function fails, the value equals one of the values
	 *                            defined in FailureCodeParseGetButtonIdentifier.
	 *                            Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean parseGetButtonIdentifier(int inSlideHandle,
												   int inIndex,
												   UpilBuffer outButtonIdentifier,
												   UpilInteger32 outFailureCode) {
		return fsdl_parse_get_button_identifier(inSlideHandle, inIndex, outButtonIdentifier, outFailureCode);
	}

	private static native boolean fsdl_parse_get_button_identifier(int inSlideHandle,
																   int inIndex,
																   UpilBuffer outButtonIdentifier,
																   UpilInteger32 outFailureCode);

	/**
	 * Hold auxiliary file content
	 * <p>
	 * Holds the content of an auxiliary file.
	 *
	 * @param inSlideHandle    Frogans slide handle<p> Frogans slide handle.
	 * @param inFileIdentifier File identifier<p> Identifier of the auxiliairy file.
	 * @param inContent        Content<p> Content of the auxiliary file.
	 * @param outFailureCode   Failure code<p> Failure code of the function.
	 *                         If the function fails, the value equals one of the values
	 *                         defined in FailureCodeHoldAuxiliaryFileContent.
	 *                         Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean holdAuxiliaryFileContent(int inSlideHandle,
												   UpilBuffer inFileIdentifier,
												   UpilBuffer inContent,
												   UpilInteger32 outFailureCode) {
		return fsdl_hold_auxiliary_file_content(inSlideHandle, inFileIdentifier, inContent, outFailureCode);
	}

	private static native boolean fsdl_hold_auxiliary_file_content(int inSlideHandle,
																   UpilBuffer inFileIdentifier,
																   UpilBuffer inContent,
																   UpilInteger32 outFailureCode);

	/**
	 * Perform render
	 * <p>
	 * Performs the rendering of an FSDL document, according to
	 * RenderMode.
	 *
	 * @param inSlideHandle  Frogans slide handle<p> Frogans slide handle.
	 * @param inRenderMode   Rendering mode<p> Rendering mode.
	 * @param outFailureCode Failure code<p> Failure code of the function.
	 *                       If the function fails, the value equals one of the values
	 *                       defined in FailureCodeRenderPerform.
	 *                       Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean renderPerform(int inSlideHandle,
										int inRenderMode,
										UpilInteger32 outFailureCode) {
		return fsdl_render_perform(inSlideHandle, inRenderMode, outFailureCode);
	}

	private static native boolean fsdl_render_perform(int inSlideHandle,
													  int inRenderMode,
													  UpilInteger32 outFailureCode);

	/**
	 * Get rendering canvas
	 * <p>
	 * Gets the lead and vignette representations of the Frogans slide.
	 *
	 * @param inSlideHandle             Frogans slide handle<p> Frogans slide handle.
	 * @param outLeadRepresentation     Lead representation<p> Lead representation of the Frogans slide.
	 * @param outVignetteRepresentation Vignette representation<p> Vignette representation of the Frogans slide.
	 * @param outFailureCode            Failure code<p> Failure code of the function.
	 *                                  If the function fails, the value equals one of the values
	 *                                  defined in FailureCodeRenderGetRenderingCanvas.
	 *                                  Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean renderGetRenderingCanvas(int inSlideHandle,
												   Composition outLeadRepresentation,
												   Composition outVignetteRepresentation,
												   UpilInteger32 outFailureCode) {
		return fsdl_render_get_rendering_canvas(inSlideHandle, outLeadRepresentation, outVignetteRepresentation, outFailureCode);
	}

	private static native boolean fsdl_render_get_rendering_canvas(int inSlideHandle,
																   Composition outLeadRepresentation,
																   Composition outVignetteRepresentation,
																   UpilInteger32 outFailureCode);

	/**
	 * Get prepared resource
	 * <p>
	 * Gets the rendered image corresponding to a prepared resource.
	 *
	 * @param inSlideHandle        Frogans slide handle<p> Frogans slide handle.
	 * @param inResourceIdentifier Resource identifier<p> Identifier of the prepared resource.
	 * @param outResource          Resource<p> Rendered image of the prepared resource.
	 * @param outFailureCode       Failure code<p> Failure code of the function.
	 *                             If the function fails, the value equals one of the values
	 *                             defined in FailureCodeRenderGetPreparedResource.
	 *                             Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean renderGetPreparedResource(int inSlideHandle,
													UpilBuffer inResourceIdentifier,
													Image outResource,
													UpilInteger32 outFailureCode) {
		return fsdl_render_get_prepared_resource(inSlideHandle, inResourceIdentifier, outResource, outFailureCode);
	}

	private static native boolean fsdl_render_get_prepared_resource(int inSlideHandle,
																	UpilBuffer inResourceIdentifier,
																	Image outResource,
																	UpilInteger32 outFailureCode);

	/**
	 * Get layer
	 * <p>
	 * Gets the rendered image corresponding to a layer.
	 *
	 * @param inSlideHandle     Frogans slide handle<p> Frogans slide handle.
	 * @param inLayerIdentifier Layer identifier<p> Identifier of the layer.
	 * @param outX              X coordinate<p> X coordinate, in pixels, of the rendered image of the layer
	 *                          from the top/left corner of the rendering canvas.
	 * @param outY              Y coordinate<p> Y coordinate, in pixels, of the rendered image of the layer
	 *                          from the top/left corner of the rendering canvas.
	 * @param outLayer          Layer<p> Image of the layer.
	 * @param outFailureCode    Failure code<p> Failure code of the function.
	 *                          If the function fails, the value equals one of the values
	 *                          defined in FailureCodeRenderGetLayer.
	 *                          Otherwise, the value equals FAILURE_CODE_HAS_SUCCEEDED.
	 * @return Returns true if the function succeeds, false if the
	 * function fails.
	 */
	public static boolean renderGetLayer(int inSlideHandle,
										 UpilBuffer inLayerIdentifier,
										 UpilInteger32 outX,
										 UpilInteger32 outY,
										 Image outLayer,
										 UpilInteger32 outFailureCode) {
		return fsdl_render_get_layer(inSlideHandle, inLayerIdentifier, outX, outY, outLayer, outFailureCode);
	}

	private static native boolean fsdl_render_get_layer(int inSlideHandle,
														UpilBuffer inLayerIdentifier,
														UpilInteger32 outX,
														UpilInteger32 outY,
														Image outLayer,
														UpilInteger32 outFailureCode);

	/**
	 * Library States
	 * <p>
	 * State of the library.
	 */
	public static class LibraryState {

		/**
		 * Undefined
		 * <p>
		 * The state of the library is undefined.
		 */
		public static final int UNDEFINED = 1010000;

		/**
		 * Not initialized
		 * <p>
		 * The library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 1010001;

		/**
		 * Initialization has failed
		 * <p>
		 * The initialization of the library has failed.
		 */
		public static final int INITIALIZATION_HAS_FAILED = 1010002;

		/**
		 * Initialized
		 * <p>
		 * The library is initialized.
		 */
		public static final int INITIALIZED = 1010003;

		/**
		 * Finalization has failed
		 * <p>
		 * The finalization of the library has failed.
		 */
		public static final int FINALIZATION_HAS_FAILED = 1010004;

		/**
		 * Finalized
		 * <p>
		 * The library is finalized.
		 */
		public static final int FINALIZED = 1010005;

	}

	/**
	 * Library initialization errors
	 * <p>
	 * Library initialization errors returned by the libraryGetState function.
	 */
	public static class LibraryInitializationError {

		/**
		 * Undefined
		 * <p>
		 * Library initialization error is undefined.
		 */
		public static final int UNDEFINED = 1020000;

		/**
		 * No error
		 * <p>
		 * No library initialization error occurred.
		 */
		public static final int NO_ERROR = 1020001;

		/**
		 * Invalid library version
		 * <p>
		 * Version of the library is invalid.
		 */
		public static final int INVALID_LIBRARY_VERSION = 1020002;

		/**
		 * Internal range begin
		 * <p>
		 * Start of the internal range of library initialization errors.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 1021000;

	}

	/**
	 * Library finalization errors
	 * <p>
	 * Library finalization errors returned by the libraryGetState function.
	 */
	public static class LibraryFinalizationError {

		/**
		 * Undefined
		 * <p>
		 * Library finalization error is undefined.
		 */
		public static final int UNDEFINED = 1030000;

		/**
		 * No error
		 * <p>
		 * No library finalization error occurred.
		 */
		public static final int NO_ERROR = 1030001;

		/**
		 * Internal range begin
		 * <p>
		 * Start of the internal range of library finalization errors.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 1031000;

	}

	/**
	 * String character encoding
	 * <p>
	 * String character encoding.
	 */
	public static class StringEncoding {

		/**
		 * UTF-8
		 * <p>
		 * UTF-8 character encoding without BOM (byte order mark).
		 */
		public static final int UTF8 = 2010001;

		/**
		 * UTF-8 BOM
		 * <p>
		 * UTF-8 character encoding with BOM (byte order mark).
		 */
		public static final int UTF8_BOM = 2010002;

		/**
		 * UTF-16E
		 * <p>
		 * UTF-16LE character encoding without BOM (byte order mark).
		 */
		public static final int UTF16LE = 2010003;

		/**
		 * UTF-16E BOM
		 * <p>
		 * UTF-16LE character encoding with BOM (byte order mark).
		 */
		public static final int UTF16LE_BOM = 2010004;

		/**
		 * UTF-16BE
		 * <p>
		 * UTF-16BE character encoding without BOM (byte order mark).
		 */
		public static final int UTF16BE = 2010005;

		/**
		 * UTF-16BE BOM
		 * <p>
		 * UTF-16BE character encoding with BOM (byte order mark).
		 */
		public static final int UTF16BE_BOM = 2010006;

	}

	/**
	 * Image formats
	 * <p>
	 * Image formats.
	 */
	public static class ImageFormat {

		/**
		 * Planes RGBA
		 * <p>
		 * The image content is made up of four component planes, in the
		 * following order: red, green, blue, and alpha. The red component
		 * plane contains the 8-bit red component of each pixel in the image,
		 * ordered from the top-left to the bottom-right of the image. The
		 * green, blue, and alpha component planes have the same structure.
		 */
		public static final int PLANES_RGBA = 2020001;

		/**
		 * Pixels RGBA
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * red, green, blue, and alpha. Image pixels are ordered from the
		 * top-left to the bottom-right of the image.
		 */
		public static final int PIXELS_RGBA = 2020002;

		/**
		 * Pixels ARGB
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * alpha, red, green, and blue. Image pixels are ordered from the
		 * top-left to the bottom-right of the image.
		 */
		public static final int PIXELS_ARGB = 2020003;

		/**
		 * Pixels BGRA
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * blue, green, red, and alpha. Image pixels are ordered from the
		 * top-left to the bottom-right of the image.
		 */
		public static final int PIXELS_BGRA = 2020004;

		/**
		 * Pixels ABGR
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * alpha, blue, green, and red. Image pixels are ordered from the
		 * top-left to the bottom-right of the image.
		 */
		public static final int PIXELS_ABGR = 2020005;

		/**
		 * Pixels RGBA pre
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * red, green, blue, and alpha. Image pixels are ordered from the
		 * top-left to the bottom-right of the image. The red, green, and
		 * blue components are premultiplied by the alpha component.
		 */
		public static final int PIXELS_RGBA_PRE = 2020006;

		/**
		 * Pixels ARGB pre
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * alpha, red, green, and blue. Image pixels are ordered from the
		 * top-left to the bottom-right of the image. The red, green, and
		 * blue components are premultiplied by the alpha component.
		 */
		public static final int PIXELS_ARGB_PRE = 2020007;

		/**
		 * Pixels BGRA pre
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * blue, green, red, and alpha. Image pixels are ordered from the
		 * top-left to the bottom-right of the image. The red, green, and
		 * blue components are premultiplied by the alpha component.
		 */
		public static final int PIXELS_BGRA_PRE = 2020008;

		/**
		 * Pixels ABGR pre
		 * <p>
		 * The image content is made up of image pixels, where each pixel
		 * is represented by four 8-bit components in the following order:
		 * alpha, blue, green, and red. Image pixels are ordered from the
		 * top-left to the bottom-right of the image. The red, green, and
		 * blue components are premultiplied by the alpha component.
		 */
		public static final int PIXELS_ABGR_PRE = 2020009;

		/**
		 * Encoded PNG
		 * <p>
		 * Image content is encoded using the PNG format
		 * [https://www.w3.org/TR/PNG/]. The PNG image type is Truecolour
		 * with alpha using a bit depth of 8. The PNG image contains the
		 * following chunks: IDRH, IDAT, and IEND.
		 */
		public static final int ENCODED_PNG = 2020010;

	}

	/**
	 * Mask format
	 * <p>
	 * Mask formats.
	 */
	public static class MaskFormat {

		/**
		 * Plane M
		 * <p>
		 * Image content is composed of the M (1-bit) plane.
		 * This format is not available yet.
		 */
		public static final int PLANE_M = 2030001;

		/**
		 * Encoded PNG
		 * <p>
		 * Mask content is encoded in PNG portable network graphics
		 * format.
		 */
		public static final int ENCODED_PNG = 2030002;

	}

	/**
	 * Configuration
	 * <p>
	 * Frogans slide handle configuration.
	 */
	public static class Configuration {

		/**
		 * String encoding
		 * <p>
		 * The character encoding used for strings; see StringEncoding.
		 */
		public int stringEncoding;

		/**
		 * Image format
		 * <p>
		 * The format used for images; see ImageFormat.
		 */
		public int imageFormat;

		/**
		 * Mask format
		 * <p>
		 * The format used for masks; see MaskFormat.
		 */
		public int maskFormat;

		/**
		 * Fonts file directory
		 * <p>
		 * Directory that contains the FSDL fonts file
		 * ("frogans.fsdl-fonts.dat").
		 */
		public UpilBuffer fontsFileDirectory;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * slideHandleCreate function.
	 */
	public static class FailureCodeSlideHandleCreate {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 204001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 204002;

		/**
		 * Invalid string encoding
		 * <p>
		 * Character encoding is invalid.
		 */
		public static final int INVALID_STRING_ENCODING = 204003;

		/**
		 * Invalid image format
		 * <p>
		 * Image format is invalid.
		 */
		public static final int INVALID_IMAGE_FORMAT = 204004;

		/**
		 * Invalid mask format
		 * <p>
		 * This failure code indicates that the mask format is invalid.
		 */
		public static final int INVALID_MASK_FORMAT = 204005;

		/**
		 * Invalid fonts file directory
		 * <p>
		 * This failure code indicates that FSDL fonts file directory is
		 * invalid.
		 */
		public static final int INVALID_FONTS_FILE_DIRECTORY = 204006;

		/**
		 * Fonts file not found
		 * <p>
		 * This failure code indicates that the FSDL fonts file is not
		 * found.
		 */
		public static final int FONTS_FILE_NOT_FOUND = 204007;

		/**
		 * Too many Frogans slides
		 * <p>
		 * This failure code indicates that there are too many created
		 * Frogans slide handles; See SLIDE_HANDLE_COUNT_MAX.
		 */
		public static final int TOO_MANY_SLIDES = 204008;

		/**
		 * Internal range begin
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 205000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * slideHandleDestroy function.
	 */
	public static class FailureCodeSlideHandleDestroy {

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 2051001;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 2051002;

		/**
		 * Internal range begin
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 2052000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * slideHandleClear function.
	 */
	public static class FailureCodeSlideHandleClear {

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 2061001;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 2061002;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 2062000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * slideHandleIs function.
	 */
	public static class FailureCodeSlideHandleIs {

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 2071001;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 2071002;

		/**
		 * Internal range begin
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 2072000;

	}

	/**
	 * Document encoding
	 * <p>
	 * Character encoding of FSDL documents.
	 */
	public static class DocumentEncoding {

		/**
		 * UTF-8
		 * <p>
		 * UTF-8 character encoding with optional BOM (byte order mark).
		 */
		public static final int UTF8 = 3010001;

		/**
		 * UTF-16
		 * <p>
		 * UTF-16 character encoding with optional BOM (byte order mark).
		 */
		public static final int UTF16 = 3010002;

	}

	/**
	 * FSDL version of document
	 * <p>
	 * FSDL specification version of the document.
	 */
	public static class DocumentFsdlVersion {

		/**
		 * FSDL 3.0
		 * <p>
		 * FSDL specification version 3.0.
		 */
		public static final int FSDL_3_0 = 3020001;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parsePerform function.
	 */
	public static class FailureCodeParsePerform {

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3031001;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3031002;

		/**
		 * Invalid document encoding
		 * <p>
		 * Document character encoding is invalid.
		 */
		public static final int INVALID_DOCUMENT_ENCODING = 3031003;

		/**
		 * Invalid FSDL version of document
		 * <p>
		 * FSDL version of the document is invalid.
		 */
		public static final int INVALID_DOCUMENT_FSDL_VERSION = 3031004;

		/**
		 * Document is empty
		 * <p>
		 * Document is empty.
		 */
		public static final int DOCUMENT_IS_EMPTY = 3031005;

		/**
		 * Document long
		 * <p>
		 * Document size, in bytes, exceeds DOCUMENT_BYTE_COUNT_MAX.
		 */
		public static final int DOCUMENT_LONG = 3031006;

		/**
		 * Document already parsed
		 * <p>
		 * Document has already been parsed successfully.
		 */
		public static final int DOCUMENT_ALREADY_PARSED = 3031007;

		/**
		 * Document encoding not UTF-8
		 * <p>
		 * Document character encoding is not UTF-8.
		 */
		public static final int DOCUMENT_ENCODING_NOT_UTF8 = 3031008;

		/**
		 * Document encoding not UTF-16
		 * <p>
		 * Document character encoding is not UTF-16.
		 */
		public static final int DOCUMENT_ENCODING_NOT_UTF16 = 3031009;

		/**
		 * XML error
		 * <p>
		 * An XML error occurred when parsing the document.
		 */
		public static final int XML_ERROR = 3031010;

		/**
		 * Validation error
		 * <p>
		 * Document is not a valid FSDL document.
		 */
		public static final int VALIDATION_ERROR = 3031011;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3032000;

	}

	/**
	 * XML error info
	 * <p>
	 * XML error information.
	 */
	public static class XmlErrorInfo {

		/**
		 * Message
		 * <p>
		 * XML error message.
		 */
		public UpilBuffer message;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetXmlErrorInfo function.
	 */
	public static class FailureCodeParseGetXmlErrorInfo {

		/**
		 * Null argiment
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3041001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3041002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3041003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3041004;

		/**
		 * Parse succeeded
		 * <p>
		 * FSDL document was parsed successfully.
		 */
		public static final int PARSE_SUCCEEDED = 3041005;

		/**
		 * No XML error
		 * <p>
		 * No XML error occurred.
		 */
		public static final int NO_XML_ERROR = 3041006;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3042000;

	}

	/**
	 * Validation error info
	 * <p>
	 * Validation error information.
	 */
	public static class ValidationErrorInfo {

		/**
		 * Message
		 * <p>
		 * Validation error message.
		 */
		public UpilBuffer message;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetValidationErrorInfo function.
	 */
	public static class FailureCodeParseGetValidationErrorInfo {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3051001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3051002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3051003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3051004;

		/**
		 * Parse succeeded
		 * <p>
		 * FSDL document was parsed successfully.
		 */
		public static final int PARSE_SUCCEEDED = 3051005;

		/**
		 * No validation error
		 * <p>
		 * No validation error occurred.
		 */
		public static final int NO_VALIDATION_ERROR = 3051006;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3052000;

	}

	/** @} */
	/* End of section: Parsing section */

	/**
	 * Auxiliary file holding section
	 * <p>
	 * This section covers the holding of the auxiliary files of a
	 * Frogans slide.
	 *
	 * @name Auxiliary file holding section
	 * @{
	 */

	/* Beginning of section: Auxiliary file holding section */

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetAuxiliaryFileCount function.
	 */
	public static class FailureCodeParseGetAuxiliaryFileCount {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3061001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3061002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3061003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3061004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3061005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3061006;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3062000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetAuxiliaryFileIdentifier function.
	 */
	public static class FailureCodeParseGetAuxiliaryFileIdentifier {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3071001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3071002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3071003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3071004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3071005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3071006;

		/**
		 * Invalid index
		 * <p>
		 * File index is invalid.
		 */
		public static final int INVALID_INDEX = 3071007;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3072000;

	}

	/**
	 * File nature
	 * <p>
	 * Nature of the file.
	 */
	public static class FileNature {

		/**
		 * Undefined
		 * <p>
		 * The nature of the file is undefined.
		 */
		public static final int UNDEFINED = 3080000;

		/**
		 * Static
		 * <p>
		 * Indicates that the file is a static file in the Frogans site
		 * root directory.
		 */
		public static final int STATIC = 3080001;

		/**
		 * Dynamic
		 * <p>
		 * Indicates that the file is a dynamic file in the Frogans site
		 * root directory.
		 */
		public static final int DYNAMIC = 3080002;

		/**
		 * Embedded
		 * <p>
		 * Indicates that the file is not a file in the Frogans
		 * site root directory but is embedded in the FSDL document.
		 * Files of that type cannot be retrieved by the
		 * parseGetAuxiliaryFileIdentifier function.
		 */
		public static final int EMBEDDED = 3080003;

	}

	/** @} */
	/* End of section: Auxiliary file holding section */

	/**
	 * Rendering section
	 * <p>
	 * This section covers the rendering of a Frogans slide.
	 *
	 * @name Rendering section
	 * @{
	 */

	/* Beginning of section: Rendering section */

	/**
	 * File info
	 * <p>
	 * Information about the file.
	 */
	public static class FileInfo {

		/**
		 * Name
		 * <p>
		 * The name of the file.
		 */
		public UpilBuffer name;

		/**
		 * Nature
		 * <p>
		 * Nature of the file.
		 */
		public int nature;

		/**
		 * Cache
		 * <p>
		 * Whether the file is added to the auxiliary file cache.
		 */
		public boolean cache;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetFileInfo function.
	 */
	public static class FailureCodeParseGetFileInfo {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3091001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3091002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3091003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3091004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3091005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3091006;

		/**
		 * Invalid identifier
		 * <p>
		 * File identifier is invalid.
		 */
		public static final int INVALID_IDENTIFIER = 3091007;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3092000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetResourceCount function.
	 */
	public static class FailureCodeParseGetResourceCount {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3101001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3101002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3101003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3101004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3101005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3101006;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3102000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetResourceIdentifier function.
	 */
	public static class FailureCodeParseGetResourceIdentifier {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3111001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3111002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3111003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3111004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3111005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3111006;

		/**
		 * Invalid index
		 * <p>
		 * Index of the prepared resource is invalid.
		 */
		public static final int INVALID_INDEX = 3111007;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3112000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetLayerCount function.
	 */
	public static class FailureCodeParseGetLayerCount {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3121001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3121002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3121003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3121004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3121005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3121006;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3122000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetLayerIdentifier function.
	 */
	public static class FailureCodeParseGetLayerIdentifier {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3131001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3131002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3131003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3131004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3131005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3131006;

		/**
		 * Invalid index
		 * <p>
		 * Index of the layer is invalid.
		 */
		public static final int INVALID_INDEX = 3131007;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3132000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetButtonCount function.
	 */
	public static class FailureCodeParseGetButtonCount {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3141001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3141002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3141003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3141004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3141005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3141006;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3142000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * parseGetButtonIdentifier function.
	 */
	public static class FailureCodeParseGetButtonIdentifier {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 3151001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 3151002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 3151003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 3151004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 3151005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 3151006;

		/**
		 * Invalid index
		 * <p>
		 * Index of the button is invalid.
		 */
		public static final int INVALID_INDEX = 3151007;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 3152000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * holdAuxiliaryFileContent function.
	 */
	public static class FailureCodeHoldAuxiliaryFileContent {

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 4011001;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 4011002;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 4011003;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 4011004;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 4011005;

		/**
		 * Invalid identifier
		 * <p>
		 * File identifier is invalid.
		 */
		public static final int INVALID_IDENTIFIER = 4011006;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 4012000;

	}

	/**
	 * Rendering mode
	 * <p>
	 * Mode for rendering the Frogans slide.
	 */
	public static class RenderMode {

		/**
		 * Rendering canvas
		 * <p>
		 * Mode used to render the rendering canvas, without access
		 * to individual prepared resources and layers.
		 */
		public static final int RENDERING_CANVAS = 5010001;

		/**
		 * Rendering canvas and layers
		 * <p>
		 * Mode used to render the rendering canvas, with access
		 * to individual prepared resources and layers.
		 */
		public static final int RENDERING_CANVAS_AND_LAYERS = 5010002;

		/**
		 * Rendering canvas and layers without constraints
		 * <p>
		 * Mode used to render the rendering canvas, with access
		 * to individual prepared resources and layers, without applying
		 * FSDL rendering constraints (not available yet).
		 */
		public static final int RENDERING_CANVAS_AND_LAYERS_NO_RC = 5010003;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * renderPerform function.
	 */
	public static class FailureCodeRenderPerform {

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 5021001;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 5021002;

		/**
		 * Invalid rendering mode
		 * <p>
		 * Rendering mode is not valid.
		 */
		public static final int INVALID_RENDER_MODE = 5021002;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 5021003;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 5021004;

		/**
		 * Frogans slide byte size too large
		 * <p>
		 * The size, in bytes, of the Frogans slide (the FSDL document
		 * size plus the total size of all loaded auxiliary files) is
		 * too large.
		 */
		public static final int SLIDE_BYTE_SIZE_TOO_LARGE = 5021005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 5021006;

		/**
		 * Rendering error
		 * <p>
		 * Rendering constraint error.
		 */
		public static final int RENDERING_ERROR = 5021007;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 5022000;

	}

	/**
	 * Image
	 * <p>
	 * Rendered image.
	 */
	public static class Image {

		/**
		 * Width
		 * <p>
		 * Width of the image, in pixels.
		 */
		public int width;

		/**
		 * Height
		 * <p>
		 * Height of the image, in pixels.
		 */
		public int height;

		/**
		 * Content
		 * <p>
		 * Content of the image in the format defined in
		 * ImageFormat in the Frogans slide handle configuration.
		 */
		public UpilBuffer content;

	}

	/**
	 * Rollover
	 * <p>
	 * A rendered rollover associated with a button.
	 */
	public static class Rollover {

		/**
		 * Image
		 * <p>
		 * Image of the rollover.
		 */
		public Image image;

		/**
		 * X coordinate
		 * <p>
		 * X coordinate, in pixels, of the rollover from the top/left
		 * corner of the Frogans slide.
		 */
		public int x;

		/**
		 * Y coordinate
		 * <p>
		 * Y coordinate, in pixels, of the rollover from the top/left
		 * corner of the Frogans slide.
		 */
		public int y;

	}

	/**
	 * Rollovers
	 * <p>
	 * Rendered rollovers associated with buttons.
	 */
	public static class Rollovers {
		public Rollover[] items;
	}

	/**
	 * Composition
	 * <p>
	 * Images, masks, and rollovers associated with the lead or
	 * vignette representation of the Frogans slide, or with a view
	 * of the Frogans slide.
	 */
	public static class Composition {

		/**
		 * Background image
		 * <p>
		 * Image of the background.
		 */
		public Image backgroundImage;

		/**
		 * Rollovers
		 * <p>
		 * Rollovers associated with buttons.
		 */
		public Rollovers rollovers;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * renderGetRenderingCanvas function.
	 */
	public static class FailureCodeRenderGetRenderingCanvas {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 5031001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 5031002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 5031003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 5031004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 5031005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 5031006;

		/**
		 * Not rendered
		 * <p>
		 * FSDL document is not rendered.
		 */
		public static final int NOT_RENDERED = 5031007;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 5032000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * renderGetPreparedResource function.
	 */
	public static class FailureCodeRenderGetPreparedResource {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 5041001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 5041002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 5041003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 5041004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 5041005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 5041006;

		/**
		 * Not rendered
		 * <p>
		 * FSDL document is not rendered.
		 */
		public static final int NOT_RENDERED = 5041007;

		/**
		 * Invalid rendering mode
		 * <p>
		 * Rendering mode is not valid.
		 */
		public static final int INVALID_RENDER_MODE = 5041008;

		/**
		 * Invalid identifier
		 * <p>
		 * Identifier of the prepared resource is not valid.
		 */
		public static final int INVALID_IDENTIFIER = 5041009;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 5042000;

	}

	/**
	 * Failure codes
	 * <p>
	 * Failure codes returned by the
	 * renderGetLayer function.
	 */
	public static class FailureCodeRenderGetLayer {

		/**
		 * Null argument
		 * <p>
		 * One of the arguments is null.
		 */
		public static final int NULL_ARGUMENT = 5051001;

		/**
		 * Not initialized
		 * <p>
		 * Library is not initialized.
		 */
		public static final int NOT_INITIALIZED = 5051002;

		/**
		 * Handle not recognized
		 * <p>
		 * Frogans slide handle is not recognized.
		 */
		public static final int NOT_RECOGNIZED_HANDLE = 5051003;

		/**
		 * Not parsed
		 * <p>
		 * FSDL document has not been parsed yet.
		 */
		public static final int NOT_PARSED = 5051004;

		/**
		 * Parse failed
		 * <p>
		 * Parsing of FSDL document failed.
		 */
		public static final int PARSE_FAILED = 5051005;

		/**
		 * Redirect
		 * <p>
		 * FSDL document is a FSDL redirection document, it cannot be
		 * rendered.
		 */
		public static final int REDIRECT = 5051006;

		/**
		 * Not rendered
		 * <p>
		 * FSDL document is not rendered.
		 */
		public static final int NOT_RENDERED = 5051007;

		/**
		 * Invalid rendering mode
		 * <p>
		 * Rendering mode is not valid.
		 */
		public static final int INVALID_RENDER_MODE = 5051008;

		/**
		 * Invalid identifier
		 * <p>
		 * Identifier of the prepared resource is not valid.
		 */
		public static final int INVALID_IDENTIFIER = 5051009;

		/**
		 * Begin internal range
		 * <p>
		 * Start of the internal range of failure codes.
		 */
		public static final int INTERNAL_RANGE_BEGIN = 5052000;

	}

	/** @} */
	/* End of section: Rendering section */

}
