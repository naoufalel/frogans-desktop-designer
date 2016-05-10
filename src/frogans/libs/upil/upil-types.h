/**
 * UPIL Basic Types For C
 *
 * @version		alpha0.15.1
 * @status		Alpha release
 *
 * @copyright	1999-2016 OP3FT
 *
 * @file
 */

#ifndef _upil_types_h
#define _upil_types_h

#ifdef  __cplusplus
extern "C" {
#endif

#define UPIL_LIBAPI extern

#if defined(_WIN32)
#define UPIL_CALL __cdecl
#else
#define UPIL_CALL
#endif

/**
 * @name boolean
 * @{
 */

typedef int upil_boolean;

#define UPIL_TRUE 						((upil_boolean)(1))
#define UPIL_FALSE 						((upil_boolean)(0))

#define UPIL_BOOLEAN_CLEAR(target)		{ (target) = UPIL_FALSE; }

/** @} */


/**
 * @name integer32
 * @{
 */

typedef int upil_integer32;

#define UPIL_INTEGER32_CLEAR(target)	{ (target) = 0; }

/** @} */


/**
 * @name buffer
 * @{
 */

#define UPIL_NULL ((void*)0)

typedef struct
{
	unsigned int size;		/**< number of bytes in buffer; equals 0 only if 'bytes' is UPIL_NULL */
	unsigned char *bytes;	/**< buffer bytes; equals UPIL_NULL only if 'size' is 0 */

} upil_buffer;

#define UPIL_BUFFER_CLEAR(target)	{ (target).size = 0; (target).bytes = UPIL_NULL; }
#define UPIL_BUFFER_CHECK(source)										\
(																		\
	(((source).size == 0) && ((source).bytes == UPIL_NULL)) ||			\
	(((source).size >  0) && ((source).bytes != UPIL_NULL))				\
)

/** @} */

#ifdef  __cplusplus
} /* extern "C" */
#endif

#endif /* _upil_types_h */
