package com.kobito.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.kobito.sample.map.MapFragment

class MainActivity : AppCompatActivity() {
    companion object {
        private const val ERROR_DIALOG_REQUEST = 9001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isServiceOK()) {
            initMap()
        }
    }

    private fun isServiceOK(): Boolean {
        val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)
        if (available == ConnectionResult.SUCCESS) {
            return true
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            val dialog = GoogleApiAvailability.getInstance().getErrorDialog(this, available, ERROR_DIALOG_REQUEST)
            dialog.show()
        } else {
            Toast.makeText(this, "cannot make map request", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    private fun initMap() {
        val mapFragment = MapFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, mapFragment)
            .commit()
    }
}
