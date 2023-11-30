package X.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class New(

    @SerialName("id")
    var id: Long?,

    @SerialName("timestamp")
    var timestamp: Long?,

    @SerialName("title")
    var title: String?,

    @SerialName("domain")
    var domain: String?,

    @SerialName("country")
    var country: String?,

    @SerialName("traffic")
    var traffic: String?,

    @SerialName("countryName")
    var countryName: String?,

    @SerialName("regionName")
    var regionName: String?
)

