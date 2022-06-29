package ke.kiura.autocheck.ui.detail.tabs.media

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ke.kiura.autocheck.data.models.media.Media
import ke.kiura.autocheck.databinding.MediaListItemBinding

class MediaViewHolder(private val binding: MediaListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(media: Media) {
        binding.media = media

        val videoVisible = when (media.type == "video/mp4") {
            true -> View.VISIBLE
            false -> View.GONE
        }

        binding.playBtn.visibility = videoVisible

        binding.playBtn.setOnClickListener {

            binding.video.visibility = videoVisible // make videoview visible
            binding.image.visibility = View.GONE // hide image
            binding.video.start() //start video
            binding.playBtn.visibility = View.GONE  // hide play button
        }
    }
}