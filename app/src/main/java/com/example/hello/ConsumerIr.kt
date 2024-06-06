package com.example.hello

import android.content.Context
import android.hardware.ConsumerIrManager
import android.util.Log

class ConsumerIr {
    fun sendIRCommand(context: Context, frequency: Int, patternL: List<Int>) {
        val irManager = context.getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

        if (irManager.hasIrEmitter()) {
            Log.w("test", "il y'a un emetteur")
            val pattern: IntArray = patternL.toIntArray()
            irManager.transmit(frequency, pattern)
        }
    }
}