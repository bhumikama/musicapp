package com.ltts.musicplayer

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CustomAdapter(val context: Activity,val datalist:List<Data>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.my_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
      return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentInfo = datalist[position]

        val musicPlayer = MediaPlayer.create(context,currentInfo.preview.toUri())
        Picasso.get().load(currentInfo.album.cover).into(holder.musicImage)
        holder.musicTitle.text = currentInfo.title
        holder.playButton.setOnClickListener {
            musicPlayer.start()
        }

        holder.pauseButton.setOnClickListener {
            musicPlayer.stop()
        }

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val musicImage: ImageView
        val musicTitle : TextView
        val playButton : ImageButton
        val pauseButton : ImageButton

        init {
            musicImage= itemView.findViewById(R.id.showImage)
            musicTitle= itemView.findViewById(R.id.showTitle)
            playButton = itemView.findViewById(R.id.playButton)
            pauseButton = itemView.findViewById(R.id.pauseButton)
        }


    }
}