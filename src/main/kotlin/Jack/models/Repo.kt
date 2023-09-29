package Jack.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable

@JsonIgnoreProperties(ignoreUnknown = true)
//@Serializable
data class Repo(

//    @SerialName("id")
    @JsonProperty("id")
    var id: Int?,

//    @JsonProperty("node_id")
//    @Nullable
//    var node_id: String?,

//    @SerialName("full_name")
//    @JsonProperty("full_name")
//    @Nullable
//    var full_name: String?,

//    @SerialName("name")
    @JsonProperty("name")
    var name: String?,

//    @SerialName("description")
    @JsonProperty("description")
    var description: String?,

//    @SerialName("language")
    @JsonProperty("language")
    var language: String?
)
