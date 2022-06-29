package ke.kiura.autocheck.data.models.car

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("year") val year: Int?,
    @SerializedName("city") val city: String?,
    @SerializedName("state") val state: String,
    @SerializedName("hasWarranty") val hasWarranty: Boolean,
    @SerializedName("marketplacePrice") val marketplacePrice: Int?,
    @SerializedName("marketplaceOldPrice") val marketplaceOldPrice: Int?,
    @SerializedName("hasFinancing") val hasFinancing: Boolean?,
    @SerializedName("mileage") val mileage: Int?,
    @SerializedName("mileageUnit") val mileageUnit: String?,
    @SerializedName("installment") val installment: Double?,
    @SerializedName("depositReceived") val depositReceived: Boolean?,
    @SerializedName("loanValue") val loanValue: Double?,
    @SerializedName("websiteUrl") val websiteUrl: String?,
    @SerializedName("bodyTypeId") val bodyTypeId: String?,
    @SerializedName("sold") val sold: Boolean?,
    @SerializedName("hasThreeDImage") val hasThreeDImage: Boolean?,
    @SerializedName("transmission") val transmission: String?,
    @SerializedName("marketplaceVisibleDate") val marketplaceVisibleDate: String?
    // @SerializedName("stats"                  ) val stats                  : Stats,
)
