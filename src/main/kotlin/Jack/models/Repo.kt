package Jack.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable

@JsonIgnoreProperties(ignoreUnknown = true)
data class Repo(

    @JsonProperty("id")
    var id: Int?,

    @JsonProperty("name")
    var name: String?,

    @JsonProperty("description")
    var description: String?,

    @JsonProperty("language")
    var language: String?
)
