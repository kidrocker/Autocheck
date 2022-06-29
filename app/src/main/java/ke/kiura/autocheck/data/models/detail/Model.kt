package ke.kiura.autocheck.data.models.detail

import com.google.gson.annotations.SerializedName
import ke.kiura.autocheck.data.models.brands.Make
import java.io.Serializable

data class Model(
    @SerializedName("id") var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("imageUrl")
    var imageUrl: String?,
    @SerializedName("wheelType")
    var wheelType: String?,
    @SerializedName("make")
    var make: Make?,
    @SerializedName("popular")
    var popular: Boolean?

):Serializable