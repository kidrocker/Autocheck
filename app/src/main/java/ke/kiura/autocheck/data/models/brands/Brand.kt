package ke.kiura.autocheck.data.models.brands

import com.google.gson.annotations.SerializedName
import ke.kiura.autocheck.data.models.Pagination

data class Brand(
    @SerializedName("makeList")
    var makeList: List<Make>,

    @SerializedName("pagination")
    var pagination: Pagination
)
