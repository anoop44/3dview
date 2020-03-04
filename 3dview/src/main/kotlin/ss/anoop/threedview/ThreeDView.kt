package ss.anoop.threedview

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.View.MeasureSpec.EXACTLY
import android.view.View.MeasureSpec.getMode
import android.view.ViewGroup
import ss.anoop.threedview.internal.moveTo
import ss.anoop.threedview.internal.padding
import ss.anoop.threedview.internal.rLineTo
import java.lang.reflect.TypeVariable
import kotlin.math.abs

class ThreeDView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    private val defStyleRes: Int = 0
) : ViewGroup(
    context,
    attributeSet,
    defStyleRes
) {
    private val paint = Paint(ANTI_ALIAS_FLAG).apply {
        strokeWidth = 2f
        style = Paint.Style.STROKE
        color = Color.BLACK
    }

    private var _3dx = 10f

    private var _3dy = -10f

    private val path = Path()

    init {
        setWillNotDraw(false)
        attributeSet?.let(::initAttributes)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChild(
            getChildAt(0),
            widthMeasureSpec,
            heightMeasureSpec
        )
        val strokeHalf = paint.strokeWidth.div(2).toInt()
        val paddingHorizontal = abs(_3dx).toInt() + strokeHalf
        if (_3dx > 0) {
            padding(left = strokeHalf, right = paddingHorizontal)
        } else {
            padding(left = paddingHorizontal, right = strokeHalf)
        }

        val paddingVertical = abs(_3dy).toInt() + strokeHalf

        if (_3dy > 0) {
            padding(bottom = paddingVertical, top = strokeHalf)
        } else {
            padding(top = paddingVertical, bottom = strokeHalf)
        }

        val width = if (getMode(widthMeasureSpec) == EXACTLY) {
            getMode(widthMeasureSpec)
        } else {
            getChildAt(0).measuredWidth + paddingLeft + paddingRight
        }

        val height = if (getMode(heightMeasureSpec) == EXACTLY) {
            getMode(heightMeasureSpec)
        } else {
            getChildAt(0).measuredHeight + paddingTop + paddingBottom
        }

        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        getChildAt(0).layout(
            paddingLeft,
            paddingTop,
            paddingLeft + getChildAt(0).measuredWidth,
            paddingTop + getChildAt(0).measuredHeight
        )

        generate3dPath()
    }

    override fun dispatchDraw(canvas: Canvas) {
        val child = getChildAt(0)
        canvas.drawPath(path, paint)
        super.dispatchDraw(canvas)
        canvas.drawRect(
            child.left - 0f,
            child.top - 0f,
            child.right.toFloat(),
            child.bottom.toFloat(),
            paint
        )
    }

    private fun initAttributes(attributeSet: AttributeSet) {
        context.obtainStyledAttributes(
            attributeSet,
            R.styleable.ThreeDView,
            0,
            defStyleRes
        ).run {
            _3dx = getDimensionPixelSize(R.styleable.ThreeDView_x, 1).toFloat()
            _3dy = getDimension(R.styleable.ThreeDView_y, _3dy)
            paint.strokeWidth = getDimension(R.styleable.ThreeDView_strokeWidth, paint.strokeWidth)
            paint.color = getColor(R.styleable.ThreeDView_strokeColor, paint.color)
            recycle()
        }
    }

    private fun generate3dPath() {
        val child = getChildAt(0)
        path.apply {
            moveTo(child.left, child.top)
            rLineTo(_3dx, _3dy)
            rLineTo(child.width, 0)
            rLineTo(-_3dx, -_3dy)
            rMoveTo(_3dx, _3dy)
            rLineTo(0, child.height)
            rLineTo(-_3dx, -_3dy)
            rMoveTo(_3dx, _3dy)
            rLineTo(-child.width, 0)
            rLineTo(-_3dx, -_3dy)
            rMoveTo(_3dx, _3dy)
            rLineTo(0, -child.height)
        }
    }
}