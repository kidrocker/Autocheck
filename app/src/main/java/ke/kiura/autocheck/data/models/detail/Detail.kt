package ke.kiura.autocheck.data.models.detail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Detail(
    @SerializedName("id") var id: String?,
    @SerializedName("year") var year: Int?,
    @SerializedName("insured") var insured: Boolean?,
    @SerializedName("mileage") var mileage: Int?,
    @SerializedName("vin") var vin: String?,
    @SerializedName("marketplacePrice") var marketplacePrice: Int?,
    @SerializedName("marketplaceVisible") var marketplaceVisible: Boolean?,
    @SerializedName("marketplaceVisibleDate") var marketplaceVisibleDate: String?,
    @SerializedName("isFeatured") var isFeatured: Boolean?,
    @SerializedName("imageUrl") var imageUrl: String?,
    @SerializedName("model") var model: Model?,
    @SerializedName("state") var state: String?,
    @SerializedName("country") var country: String?,
    @SerializedName("ownerType") var ownerType: String?,
    @SerializedName("transmission") var transmission: String?,
    @SerializedName("bodyType") var bodyType: BodyType?,
    @SerializedName("city") var city: String?,
    @SerializedName("marketplaceOldPrice") var marketplaceOldPrice: Int?,
    @SerializedName("createdAt") var createdAt: String?,
    @SerializedName("updatedAt") var updatedAt: String?,
    @SerializedName("mileageUnit") var mileageUnit: String?,
    @SerializedName("hasWarranty") var hasWarranty: Boolean?,
    @SerializedName("hasFinancing") var hasFinancing: Boolean?,
    @SerializedName("interiorColor") var interiorColor: String?,
    @SerializedName("exteriorColor") var exteriorColor: String?,
    @SerializedName("engineType") var engineType: String?,
    @SerializedName("installment") var installment: Double?,
    @SerializedName("depositReceived") var depositReceived: Boolean?,
    @SerializedName("loanValue") var loanValue: Double?,
    @SerializedName("websiteUrl") var websiteUrl: String?,
    @SerializedName("sold") var sold: Boolean?,
    @SerializedName("hasThreeDImage") var hasThreeDImage: Boolean?,
    @SerializedName("carName") var carName: String?
) : Serializable
