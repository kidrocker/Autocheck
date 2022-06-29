package ke.kiura.autocheck.ui

import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

open class BaseFragment:Fragment() {

    /**
     * Use kotlin extensions to extend functionality
     * We extend progress bar as the visibility toggle is used on multiple places
     */
    fun ProgressBar.showProgress(state: Boolean) {
        visibility = when (state) {
            true -> View.VISIBLE
            false -> View.GONE
        }
    }


}