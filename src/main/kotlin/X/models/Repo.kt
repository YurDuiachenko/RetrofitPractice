package X.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repo(

    @SerialName("id")
    var id: Int?,

    @SerialName("full_name")
    var full_name: String?,

    @SerialName("name")
    var name: String?,

    @SerialName("description")
    var description: String?,

    @SerialName("language")
    var language: String?
)
