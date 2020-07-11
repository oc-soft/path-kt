package gl
import kotlin.math.pow
import org.khronos.webgl.Uint8Array
import org.khronos.webgl.get


/**
 * handle open gl color data
 */
class ColorCodec {

    companion object {
        /**
         * decode float from color
         */
        fun decodeFloat(buffer: Uint8Array): Float? {
            var result: Float? = null 
             
            if (buffer.length > 3) {
                result = 0.0f
                for (idx in 0 until 4) {
                    var tmpVal = buffer[idx].toFloat() / 0xff.toFloat();
                    tmpVal /=  0xff.toFloat().pow(idx)
                    result += tmpVal 
                }
            }
            return result
        }

        /**
         * decode float value less than 1 from color
         */
        fun decodeFloatLess1(buffer: Uint8Array): Float? {
            var result: Float? = null 
            
            result = decodeFloat(buffer)
            if (result != null) {
                result /= 0xf.toFloat()
            }
            return result
        }
    }
}

// vi: se ts=4 sw=4 et: