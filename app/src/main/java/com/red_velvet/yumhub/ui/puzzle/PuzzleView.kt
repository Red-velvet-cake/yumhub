package com.red_velvet.yumhub.ui.puzzle

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.CountDownTimer
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.red_velvet.yumhub.R
import java.util.Collections

class PuzzleView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val imagePaint = Paint().apply { isAntiAlias = true }
    private val images: MutableList<Bitmap> = mutableListOf()
    private var imagesCopy: List<Bitmap> = listOf()
    private var rows: Int = 0
    private var cols: Int = 0
    private val imageRect = Rect()
    private var selectedIndex: Int? = null
    private var correctOrder = mutableListOf<Int>()
    var onPuzzleSolvedListener: OnPuzzleSolvedListener? = null
    var onPuzzleFailedListener: OnPuzzleFailedListener? = null
    private var isPuzzleSolved = false
    private var countDownTimer: CountDownTimer? = null
    var timerTextView: TextView? = null

    fun setupPuzzle(rows: Int, cols: Int) {
        this.rows = rows
        this.cols = cols
        images.clear()
        correctOrder.clear()
        preparePuzzleImages()
        shuffleImages()
        startTimer()
        invalidate()
    }

    private fun preparePuzzleImages() {
        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.home)
        val chunkWidth = originalBitmap.width / cols
        val chunkHeight = originalBitmap.height / rows
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                val chunk = Bitmap.createBitmap(
                    originalBitmap,
                    j * chunkWidth,
                    i * chunkHeight,
                    chunkWidth,
                    chunkHeight
                )
                images.add(chunk)
                correctOrder.add(images.lastIndex)
            }
        }
        imagesCopy = images.toList()
    }
    private fun startTimer() {
        countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerTextView?.text = "${millisUntilFinished / 1000}"
                Log.d("startTimer", "onTick: $millisUntilFinished")
            } // 30 seconds
            override fun onFinish() {
                if (!isPuzzleSolved) {
                    onPuzzleFailedListener?.onPuzzleFailed()
                }
            }
        }
        countDownTimer?.start()
    }

    private fun shuffleImages() {
        val imagePositions = imagesCopy.withIndex().associateBy({ it.value }, { it.index })
        images.shuffle()
        correctOrder = images.map { imagePositions[it]!! }.toMutableList()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var index = 0
        val imageWidth = width / cols
        val imageHeight = height / rows
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                imageRect.set(
                    j * imageWidth,
                    i * imageHeight,
                    (j + 1) * imageWidth,
                    (i + 1) * imageHeight
                )
                canvas.drawBitmap(images[index], null, imageRect, imagePaint)
                index++
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val imageWidth = width / cols
            val imageHeight = height / rows
            val colTouched = (event.x / imageWidth).toInt()
            val rowTouched = (event.y / imageHeight).toInt()
            val indexTouched = rowTouched * cols + colTouched
            onImageTouched(indexTouched)
            return true
        }
        return super.onTouchEvent(event)
    }

    private fun onImageTouched(index: Int) {
        if (isPuzzleSolved) {
            invalidate()
            return
        }

        val previouslySelectedIndex = selectedIndex
        selectedIndex = if (previouslySelectedIndex == null) {
            index
        } else {
            swapImages(previouslySelectedIndex, index)
            null
        }
    }

    private fun swapImages(index1: Int, index2: Int) {
        if (isPuzzleSolved) return
        animate().alpha(0f).setDuration(100).withEndAction {
            Collections.swap(images, index1, index2)
            invalidate()
            animate().alpha(1f).setDuration(100).start()
            if (isSolved()) {
                isPuzzleSolved = true
                countDownTimer?.cancel() // stop the timer
                onPuzzleSolvedListener?.onPuzzleSolved()
            }
        }.start()
    }

    private fun isSolved(): Boolean {
        val result = images.indices.all { i ->
            val correctOrderIndex = correctOrder[i]
            val imageCopyIndex = imagesCopy.indexOf(images[correctOrderIndex])
            correctOrderIndex == imageCopyIndex
        }
        return result
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        countDownTimer?.cancel()
        timerTextView = null
    }

}

interface OnPuzzleSolvedListener {
    fun onPuzzleSolved()
}
interface OnPuzzleFailedListener {
    fun onPuzzleFailed()
}