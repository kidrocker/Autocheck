package ke.kiura.autocheck.ui.landing.cars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ke.kiura.autocheck.data.models.car.Car
import ke.kiura.autocheck.databinding.CarItemBinding
import ke.kiura.autocheck.ui.common.CarDiffCallback

class CarListAdapter(private val listener:ClickListener) : RecyclerView.Adapter<CarListViewHolder>() {

    private var cars = emptyList<Car>()
    private lateinit var binding: CarItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        binding = CarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        holder.bind(cars[position], listener)
    }

    override fun getItemCount() = cars.size

    fun updateCars(_cars: List<Car>) {
        val diffResult: DiffUtil.DiffResult =
            DiffUtil.calculateDiff(CarDiffCallback(_cars, cars))
        cars = _cars
        diffResult.dispatchUpdatesTo(this)
    }

    interface ClickListener{
        fun clicked(car: Car)
    }
}