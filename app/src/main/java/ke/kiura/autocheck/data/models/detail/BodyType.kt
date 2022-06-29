package ke.kiura.autocheck.data.models.detail

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BodyType(
    @SerializedName("id") var id: Int?,
    @SerializedName("name") var name: String?,
    @SerializedName("imageUrl") var imageUrl: String?
):Serializable