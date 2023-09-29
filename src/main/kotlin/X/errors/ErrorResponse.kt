package X.errors

import kotlinx.serialization.SerialName

data class ErrorResponse(
    @SerialName("message") val message: String
)
