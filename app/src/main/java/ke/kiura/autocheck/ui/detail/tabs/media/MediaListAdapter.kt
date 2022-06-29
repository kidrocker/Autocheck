package ke.kiura.autocheck.ui.detail.tabs.media

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ke.kiura.autocheck.data.models.media.Media
import ke.kiura.autocheck.data.models.media.MediaList
import ke.kiura.autocheck.databinding.MediaListItemBinding

class MediaListAdapter:RecyclerView.Adapter<MediaViewHolder>() {
    private var media = emptyList<Media>()

    private lateinit var binding: MediaListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        binding = MediaListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.bind(media[position])
    }

    override fun getItemCount()=media.size

    fun updateMedia(mediaList: MediaList){
        media = mediaList.carMediaList
        notifyDataSetChanged()
    }
}