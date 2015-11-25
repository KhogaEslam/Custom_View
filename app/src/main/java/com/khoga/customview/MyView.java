package com.khoga.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.text.AttributedCharacterIterator;

/**
 * Created by Portal1 on 25/11/2015.
 */
public class MyView extends View {

    private int squareCol, labelCol;
    private String squareText;
    private Paint squarePaint;

    public MyView(Context context, AttributeSet attr){
        super(context, attr);

        squarePaint = new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attr, R.styleable.MyView, 0, 0);

        try{
            squareText = a.getString(R.styleable.MyView_squareLabel);
            squareCol = a.getInteger(R.styleable.MyView_squareColor, 0);
            labelCol = a.getInteger(R.styleable.MyView_labelColor, 0);
        }
        finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setAntiAlias(true);

        squarePaint.setColor(squareCol);

        canvas.drawRect(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight(), squarePaint);

        squarePaint.setColor(labelCol);

        squarePaint.setTextAlign(Paint.Align.CENTER);
        squarePaint.setTextSize(50);

        canvas.drawText(squareText, this.getMeasuredWidth()/2, this.getMeasuredHeight()/2, squarePaint);
    }

    public int getSquareCol() {
        return squareCol;
    }

    public String getLabelText() {
        return squareText;
    }

    public int getLabelCol() {
        return labelCol;
    }

    public void setSquareCol(int newSquareCol) {
        squareCol = newSquareCol;
        invalidate();
        requestLayout();
    }

    public void setLabelText(String newSquareText) {
        squareText = newSquareText;
        invalidate();
        requestLayout();
    }

    public void setLabelCol(int newLabelCol) {
        labelCol = newLabelCol;
        invalidate();
        requestLayout();
    }
}
