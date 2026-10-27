package com.example.weather_app

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.weather_app.databinding.ActivityMainBinding
import com.google.android.material.color.utilities.ViewingConditions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        fetchWeatherData("Solapur")
        searchCity()

        val searchView = binding.searchView
        searchView.queryHint = "Search For A City"
    }

    private fun searchCity() {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    fetchWeatherData(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun fetchWeatherData(cityName : String) {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/") // ✅ Added trailing slash
            .build()
            .create(APIinterface::class.java)

        val response = retrofit.getWeatherData(cityName, "cb9ef77754b519489b69ba5ec5da4d6a", "metric")

        response.enqueue(object : Callback<weather_App> {
            override fun onResponse(call: Call<weather_App>, response: Response<weather_App>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    val temperature = responseBody.main.temp.toString()
                    val humidity = responseBody.main.humidity
                    val windSpeed = responseBody.wind.speed
                    val sunRise = responseBody.sys.sunrise.toLong()
                    val sunSet = responseBody.sys.sunset.toLong()
                    val seaLevel = responseBody.main.pressure
                    val condition =responseBody.weather.firstOrNull()?.main?: "unknown"
                    val tempMax = responseBody.main.temp_max
                    val tempMin = responseBody.main.temp_min

                    //Log.d("TAG", temperature) // ✅ Corrected Log.d syntax

                    binding.temp.text = "$temperature °C"
                    binding.textViewsunny.text = condition
                    binding.max.text = "Max Temp : $tempMax °C"
                    binding.min.text = "Min Temp : $tempMin °C"
                    binding.humidity.text = "$humidity %"
                    binding.wind.text = "$windSpeed m/s"
                    binding.sunrise.text = "${time(sunRise)}sunRise"
                    binding.sunset.text = "${time(sunSet)}sunSet"
                    binding.sea.text = "$seaLevel hPa"
                    binding.conditions.text = condition
                    binding.day.text = dayName(System.currentTimeMillis())
                        binding.date.text = date()
                        binding.location.text = "$cityName"

                    changeImageAccordingToWeatherCondition(condition)
                }
            }

            override fun onFailure(call: Call<weather_App>, t: Throwable) {
                Log.e("TAG", "Error: ${t.message}") // ✅ Replaced TODO with error log
            }
        })
    }

    fun changeImageAccordingToWeatherCondition(conditions: String)
    {
        when (conditions) {
            "Clear Sky", "Sunny", "Clear" -> {
                binding.root.setBackgroundResource(R.drawable.sunny_background)
                binding.lottieAnimationView.setAnimation(R.raw.sun)
            }

            "party Clouds", "Clouds", "Overcast", "Mist", "Foggy" -> {
                binding.root.setBackgroundResource(R.drawable.colud_background)
                binding.lottieAnimationView.setAnimation(R.raw.cloud)
            }

            "Light Rain", "Drizzle", "Moderate Rain", "Showers", "Heavy Rain" -> {
                binding.root.setBackgroundResource(R.drawable.rain_background)
                binding.lottieAnimationView.setAnimation(R.raw.rain)
            }

            "Light Snow", "Moderate Snow", "Heavy Snow", "Blizzard" -> {
                binding.root.setBackgroundResource(R.drawable.rain_background)
                binding.lottieAnimationView.setAnimation(R.raw.rain)
            }
            else ->{
                binding.root.setBackgroundResource(R.drawable.sunny_background)
                binding.lottieAnimationView.setAnimation(R.raw.sun)
            }
        }
            binding.lottieAnimationView.playAnimation()
        }
    }
    private fun date() : String{
        val sdf = SimpleDateFormat("dd MMMM YYYY", Locale.getDefault())
        return  sdf.format(Date())
    }

    private  fun time(timestamp: Long) : String{
        val sdf = SimpleDateFormat("HH MM", Locale.getDefault())
        return  sdf.format(Date(timestamp * 1000))
    }
    fun dayName(timestamp: Long) : String{
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return  sdf.format(Date())
    }

