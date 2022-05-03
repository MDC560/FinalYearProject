//countpackage com.example.finalproject
//
//import android.content.Context
//import android.hardware.Sensor
//import android.hardware.SensorEvent
//import android.hardware.SensorEventListener
//import android.hardware.SensorManager
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.ProgressBar
//import android.widget.TextView
//import android.widget.Toast
//import androidx.databinding.DataBindingUtil
//import com.example.finalproject.databinding.ActivityStepCounterBinding
//
//class StepCounterActivity : AppCompatActivity(), SensorEventListener {
//
//    lateinit var binding : ActivityStepCounterBinding
//    private var sensorManager: SensorManager? = null
//
//    private var running = false
//    private var totalStep = 0f
//    private var previousTotalSteps = 0f
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //setContentView(R.layout.activity_step_counter)
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_step_counter)
//
//        loadData()
//        resetSteps()
//        saveData()
//
//
//        sensorManager= getSystemService(Context.SENSOR_SERVICE) as SensorManager
//    }
//
//    override fun onResume(){
//        super.onResume()
//        running = true
//        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
//
//        if(stepSensor == null){
//            Toast.makeText(this, "No step sensor identified.", Toast.LENGTH_LONG).show()
//        }
//        else{
//            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
//        }
//    }
//
//    override fun onSensorChanged(event: SensorEvent?) {
//        if(running){
//            totalStep = event!!.values[0]
//            val currentSteps = totalStep.toInt() - previousTotalSteps.toInt()
//            binding.stepsTaken.text = ("$currentSteps")
//
//            binding.progress.apply {
//                setProgress(currentSteps.toFloat().toInt())
//            }
//
//        }
//    }
//
//    fun resetSteps(){
//        binding.stepsTaken.setOnClickListener {
//            Toast.makeText(this,"Long press to reset", Toast.LENGTH_LONG).show()
//        }
//        binding.stepsTaken.setOnLongClickListener {
//            previousTotalSteps = totalStep
//            binding.stepsTaken.text = 0.toString()
//            saveData()
//
//            true
//        }
//    }
//
//    private fun saveData(){
//        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putFloat("key1", previousTotalSteps)
//        editor.apply()
//    }
//
//    private fun loadData(){
//        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
//        val savedNumber = sharedPreferences.getFloat("key1", 0f)
//        Log.d("StepCounterActivity", "$savedNumber")
//        previousTotalSteps = savedNumber
//    }
//    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
//        TODO("Not yet implemented")
//    }
//}