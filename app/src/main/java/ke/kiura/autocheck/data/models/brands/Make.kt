package ke.kiura.autocheck.data.models.brands

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Make(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("imageUrl")
    var image: String
):Serializable