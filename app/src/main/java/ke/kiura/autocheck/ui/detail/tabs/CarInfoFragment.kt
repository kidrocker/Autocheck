package ke.kiura.autocheck.ui.detail.tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ke.kiura.autocheck.R
import ke.kiura.autocheck.core.DefaultConfig.PARAM_DETAIL
import ke.kiura.autocheck.data.models.detail.Detail
import ke.kiura.autocheck.databinding.FragmentCarInfoBinding

class CarInfoFragment : Fragment() {
    private var detail: Detail? = null

    private lateinit var binding: FragmentCarInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_car_info, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(PARAM_DETAIL) }?.apply {
            detail = getSerializable(PARAM_DETAIL) as Detail
        }
        binding.detail = detail
    }

}