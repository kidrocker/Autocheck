package ke.kiura.autocheck.ui.common

import androidx.recyclerview.widget.DiffUtil
import ke.kiura.autocheck.data.models.car.Car

/**
 * Class compares existing and new lists allowing adapters to refresh faster
 * This is more important when you are loading large amounts of data into a list.
 */

class CarDiffCallback(
    private val newCars: List<Car>,
    private val oldCars: List<Car>
) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldCars.size
    }

    override fun getNewListSize(): Int {
        return newCars.size
    }

    /**
     * method leverages on the equals override on the data class
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldCars[oldItemPosition].id == newCars[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldCars[oldItemPosition] == newCars[newItemPosition]
    }
}