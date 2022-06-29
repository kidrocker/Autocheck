package ke.kiura.autocheck.data.models.media

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("type") var type: String? = null
)
