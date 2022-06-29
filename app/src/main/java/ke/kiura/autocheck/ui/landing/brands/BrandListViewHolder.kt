package ke.kiura.autocheck.ui.landing.brands

import androidx.recyclerview.widget.RecyclerView
import ke.kiura.autocheck.data.models.brands.Make
import ke.kiura.autocheck.databinding.BrandItemBinding

class BrandListViewHolder(private val binding: BrandItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(make: Make) {
        binding.make = make
    }
}