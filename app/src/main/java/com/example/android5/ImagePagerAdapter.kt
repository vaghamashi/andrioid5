package com.example.android5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class ImagePagerAdapter(images: Array<Int>) : PagerAdapter(){

  var images = images

  override fun getCount(): Int {
      return images.size
  }

  override fun isViewFromObject(view: View, `object`: Any): Boolean {
      return view==`object`
  }

  @SuppressLint("MissingInflatedId")
  override fun instantiateItem(container: ViewGroup, position: Int): Any {
      var view = LayoutInflater.from(container.context).inflate(R.layout.images_item,container,false)

      var imageItem = view.findViewById<ImageView>(R.id.imagesItem)

      Glide.with(container.context).load(images.get(position)).into(imageItem)
      container.addView(view)
      return view
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
      container.removeView(`object` as View)
  }

}