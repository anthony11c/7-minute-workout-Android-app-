package hr.tvz.android.vjezbajsamnom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bmiactivity.*
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)

        setSupportActionBar(toolbar_bmi_activity)

        val actionbar = supportActionBar
        if(actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = "Izračunaj BMI"
        }
        toolbar_bmi_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        btnCalculateUnits.setOnClickListener {

            // The values are validated.
            if (validateMetricUnits()) {

                // The height value is converted to a float value and divided by 100 to convert it to meter.
                val heightValue: Float = etMetricUnitHeight.text.toString().toFloat() / 100

                // The weight value is converted to a float value
                val weightValue: Float = etMetricUnitWeight.text.toString().toFloat()

                // BMI value is calculated in METRIC UNITS using the height and weight value.
                val bmi = weightValue / (heightValue * heightValue)

                displayBMIResult(bmi)
            } else {
                Toast.makeText(this@BMIActivity, "Please enter valid values.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun validateMetricUnits(): Boolean {
        var isValid = true

        if (etMetricUnitWeight.text.toString().isEmpty()) {
            isValid = false
        } else if (etMetricUnitHeight.text.toString().isEmpty()) {
            isValid = false
        }

        return isValid
    }

    private fun displayBMIResult(bmi: Float) {

        val bmiLabel: String
        val bmiDescription: String

        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = resources.getString(R.string.bmi_label_underweight)
            bmiDescription = resources.getString(R.string.bmi_label_underweight_desc)
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0
        ) {
            bmiLabel = resources.getString(R.string.bmi_label_severly_underweight)
            bmiDescription = resources.getString(R.string.bmi_label_severly_underweight_desc)
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0
        ) {
            bmiLabel = resources.getString(R.string.bmi_label_slim)
            bmiDescription = resources.getString(R.string.bmi_label_slim_desc)
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0
        ) {
            bmiLabel = resources.getString(R.string.bmi_label_normal)
            bmiDescription = resources.getString(R.string.bmi_label_normal_desc)
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(
                bmi,
                30f
            ) <= 0
        ) {
            bmiLabel = resources.getString(R.string.bmi_label_overweight)
            bmiDescription = resources.getString(R.string.bmi_label_overweight_desc)
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0
        ) {
            bmiLabel = resources.getString(R.string.bmi_label_obese)
            bmiDescription = resources.getString(R.string.bmi_label_obese_desc)
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0
        ) {
            bmiLabel = resources.getString(R.string.bmi_label_obese)
            bmiDescription = resources.getString(R.string.bmi_label_obese_desc)
        } else {
            bmiLabel = resources.getString(R.string.bmi_label_obese)
            bmiDescription = resources.getString(R.string.bmi_label_obese_desc)
        }

        tvYourBMI.visibility = View.VISIBLE
        tvBMIValue.visibility = View.VISIBLE
        tvBMIType.visibility = View.VISIBLE
        tvBMIDescription.visibility = View.VISIBLE

        // This is used to round the result value to 2 decimal values after "."
        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()

        tvBMIValue.text = bmiValue // Value is set to TextView
        tvBMIType.text = bmiLabel // Label is set to TextView
        tvBMIDescription.text = bmiDescription // Description is set to TextView
    }
}