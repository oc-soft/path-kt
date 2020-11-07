package net.ocsoft.mswp.settings

import net.ocsoft.Color

/**
 * color scheme object
 */
class ColorScheme {
    
    /**
     * class instance
     */
    companion object {

        /**
         * convert color scheme object to less var string
         */
        @ExperimentalUnsignedTypes
        fun convertToLessVars(
            colorSchemeObj: net.ocsoft.mswp.ColorScheme): Map<String, String> {
            val less = colorScheme.less
            val keys = less.keys 
            val mapping = less.mapping
            val result = HashMap<String, String>()
            keys.forEach { key ->
                val replacementKeys = mapping[key] 
                var strValue: String? = null
                if (replacementKeys != null) {
                    var color: Color? = null
                    if ("environment" == replacementKeys[0]) {
                        val idx: Int = replacementKeys[1] as Int
                        val colorValues = colorSchemeObj.getEnvironment(idx) 
                        if (colorValues != null) {
                            color = Color(
                                Color.Value(colorValues[0]),
                                Color.Value(colorValues[1]),
                                Color.Value(colorValues[2]),
                                Color.Value(colorValues[3])) 
                        }
                        
                    }
                    if (color != null) {
                        strValue = color.toString()
                    }
                }
                if (strValue != null) {
                    result[key.toString()] = strValue
                }
            }
            return result
        }
    } 
}
// vi: se ts=4 sw=4 et: 