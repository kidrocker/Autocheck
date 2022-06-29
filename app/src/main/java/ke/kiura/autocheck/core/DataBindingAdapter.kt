package ke.kiura.autocheck.core

import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

@BindingAdapter("load", "error")
fun loadImage(view: ImageView, url: String?, error: Drawable) {
    Glide.with(view).load(url)
        .error(error)
        .into(view)
}

@BindingAdapter("text")
fun text(view: TextView, text: String?) {
    text?.let {
        view.text = it
    }
}

@BindingAdapter("striked")
fun formatStriked(textView: TextView, price: String?) {
    price?.let {
        textView.text = "${moneyFormat(price)}"
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}

@BindingAdapter("money")
fun formatMoney(textView: TextView, price: String?) {
    price?.let {
        textView.text = "${moneyFormat(price)}"
    }
}

@BindingAdapter("video")
fun intializeVideo(videoView: VideoView, url: String?)
{
    val uri = Uri.parse(url)
    videoView.setVideoURI(uri)
    val mediaController = MediaController(videoView.context)
    mediaController.setAnchorView(videoView)
    mediaController.setMediaPlayer(videoView)
    videoView.setMediaController(mediaController)
}

fun moneyFormat(value: String): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("Ksh")

    return format.format(value.toDouble().roundToInt())
}