package ke.kiura.autocheck.ui.landing.brands

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ke.kiura.autocheck.data.models.brands.Make
import ke.kiura.autocheck.databinding.BrandItemBinding

class BrandListAdapter:RecyclerView.Adapter<BrandListViewHolder>() {

    private var brands = emptyList<Make>()
    private lateinit var binding: BrandItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandListViewHolder {
       binding = BrandItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return BrandListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandListViewHolder, position: Int) {
       holder.bind(brands[position])
    }

    override fun getItemCount()= brands.size

    fun updateBrands(_brands:List<Make>){
        brands = _brands
        notifyDataSetChanged()
    }
}