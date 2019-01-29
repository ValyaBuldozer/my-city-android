package ru.edu.ksu.mycity.helpers.view.extensions

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import ru.edu.ksu.mycity.R

@BindingAdapter("image_url")
fun ImageView.imageUrl(imgUrl: String) {
    Picasso.get()
        .load(imgUrl)
        .placeholder(R.drawable.ic_route_placeholder)
        .error(R.drawable.ic_route_placeholder)
        .into(this)
}