package ke.kiura.autocheck.ui.landing.cars

import androidx.recyclerview.widget.RecyclerView
import ke.kiura.autocheck.data.models.car.Car
import ke.kiura.autocheck.databinding.CarItemBinding

class CarListViewHolder(private val binding: CarItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(car: Car, listener:CarListAdapter.ClickListener ){
        binding.car = car
        itemView.setOnClickListener {
            listener.clicked(car)
        }
    }
}