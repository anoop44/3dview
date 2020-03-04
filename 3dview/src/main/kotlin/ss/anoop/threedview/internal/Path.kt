package ss.anoop.threedview.internal

import android.graphics.Path


internal fun Path.moveTo(x: Int, y: Int){
    moveTo(x.toFloat(), y.toFloat())
}

internal fun Path.rLineTo(dx: Int, dy: Int){
    rLineTo(dx.toFloat(), dy.toFloat())
}