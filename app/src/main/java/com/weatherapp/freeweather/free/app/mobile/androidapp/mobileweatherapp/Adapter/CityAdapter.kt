package com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Adapter

import android.content.Intent
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Activity.MainActivity
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Model.CityResponseApi
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Model.ForecastResponsApi
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.databinding.CityViewholderBinding
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.databinding.ForecastViewholderBinding
import java.text.SimpleDateFormat

class CityAdapter:RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    private lateinit var binding: CityViewholderBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        binding=CityViewholderBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        val binding=CityViewholderBinding.bind(holder.itemView)
        binding.citySearchTxt.text=differ.currentList[position].name

        binding.root.setOnClickListener{
            val intent= Intent(binding.root.context,MainActivity::class.java)
            intent.putExtra("lat",differ.currentList[position].lat)
            intent.putExtra("lon",differ.currentList[position].lon)
            intent.putExtra("name",differ.currentList[position].name)
            binding.root.context.startActivity(intent)
        }

    }


    inner class ViewHolder:RecyclerView.ViewHolder(binding.root)


    override fun getItemCount() = differ.currentList.size


    private val differCallback=object:DiffUtil.ItemCallback<CityResponseApi.CityResponseApiItem>(){
        override fun areItemsTheSame(
            oldItem: CityResponseApi.CityResponseApiItem,
            newItem: CityResponseApi.CityResponseApiItem
        ): Boolean {
            return  oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: CityResponseApi.CityResponseApiItem,
            newItem: CityResponseApi.CityResponseApiItem
        ): Boolean {
           return oldItem==newItem
        }

    }
    val differ=AsyncListDiffer(this, differCallback)
}