package common.utils.library.utils

object ConsoleInputUtils {

    @Volatile
    private var lineReader: (() -> String?)? = null

    @JvmStatic
    fun setLineReader(lineReader: (() -> String?)?) {

        this.lineReader = lineReader
    }

    @JvmStatic
    fun readln(): String = lineReader?.invoke() ?: kotlin.io.readln()

    @JvmStatic
    fun readlnOrNull(): String? = lineReader?.invoke() ?: kotlin.io.readlnOrNull()
}
