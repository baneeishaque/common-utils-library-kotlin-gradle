package common.utils.library.utils

import common.utils.library.models.ChooseByIdResult
import common.utils.library.models.FailureWithoutExplanationBasedOnIsOkModel

object ChooseUtilsInteractive {

    @JvmStatic
    fun <T> chooseById(

        itemSpecification: String,
        apiCallFunction: () -> Result<T>,
        prefixForPrompt: String = "",
        isConsoleMode: Boolean,
        isDevelopmentMode: Boolean

    ): ChooseByIdResult<T> {

        while (true) {

            print("Enter $prefixForPrompt$itemSpecification ID or 0 to Back : ")

            val idInput: UInt? = ConsoleInputUtils.readlnOrNull()?.trim()?.toUIntOrNull()
            if (idInput == null) {

                println("Invalid $itemSpecification ID...")
                continue
            }
            if (idInput == 0u) {

                return ChooseByIdResult(

                    isOkWithData = FailureWithoutExplanationBasedOnIsOkModel()
                )
            }

            return ChooseByIdResult(

                isOkWithData = ApiUtilsInteractiveCommon.makeApiRequestWithOptionalRetries(

                    apiCallFunction = apiCallFunction,
                    isConsoleMode = isConsoleMode,
                    isDevelopmentMode = isDevelopmentMode
                ),
                id = idInput
            )
        }
    }
}
