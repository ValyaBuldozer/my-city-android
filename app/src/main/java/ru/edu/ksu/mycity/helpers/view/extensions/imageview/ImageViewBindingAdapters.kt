package ru.edu.ksu.mycity.helpers.view.extensions.imageview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import okhttp3.HttpUrl
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.domain.network.NetworkConfig

@BindingAdapter("image_url")
fun ImageView.imageUrl(imgUrl: String) {
    Picasso.get()
        .load(imgUrl)
        .placeholder(R.drawable.ic_route_placeholder)
        .error(R.drawable.ic_route_placeholder)
        .into(this)
}

@BindingAdapter(value = ["server_image_url", "placeholder"], requireAll = false)
fun ImageView.serverImageUrl(imgUrl: String?, placeholder: Int?) {

    val placeholderId = placeholder ?: R.drawable.item_placeholder

    if (imgUrl != null) {
        val url = HttpUrl.Builder()
            .scheme(NetworkConfig.SCHEME.value)
            .host(NetworkConfig.HOST.value)
            .port(NetworkConfig.PORT.value.toInt())
            .addPathSegment(imgUrl)
            .build()

        Picasso.get()
            .load(url.url().toString())
            .placeholder(placeholderId)
            .error(placeholderId)
            .into(this)
    } else {
        Picasso.get()
            .load(placeholderId)
            .into(this)
    }

}

@BindingAdapter("local_image_src")
fun ImageView.localImageSrc(drawableId: Int) {
    Picasso.get()
        .load(drawableId)
        .error(R.drawable.image_placeholder)
        .into(this)
}