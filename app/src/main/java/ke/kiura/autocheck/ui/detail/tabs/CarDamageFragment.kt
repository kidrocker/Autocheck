package ke.kiura.autocheck.ui.detail.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ke.kiura.autocheck.R
import ke.kiura.autocheck.core.DefaultConfig.PARAM_DETAIL
import ke.kiura.autocheck.data.models.detail.Detail

class CarDamageFragment : Fragment() {
    private var detail: Detail? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_damage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(PARAM_DETAIL) }?.apply {
            detail = getSerializable(PARAM_DETAIL) as Detail
        }
    }
}