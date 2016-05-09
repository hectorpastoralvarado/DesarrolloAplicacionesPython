package utng.edu.mx.proyectofinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

/**
 * Created by LuIs on 04/05/2016.
 */
public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PapelView papel = new PapelView(this);
        setContentView(papel);
    }

    private class PapelView extends View{

        public PapelView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);

            paint.setColor(Color.BLUE);
                            //HI, VI , Hf, V1
            canvas.drawRect(0, 50, 60, 250, paint);
            canvas.drawRect(0, 250, 280, 300, paint);

            paint.setColor(Color.GRAY);
            canvas.drawRect(150, 50, 220, 250, paint);
            canvas.drawRect(90, 50, 270, 100, paint);
            canvas.drawRect(350, 250, 420, 470 , paint);
            canvas.drawRect(270, 410, 420, 470 , paint);
            canvas.drawRect(220, 360, 280, 470 , paint);

            paint.setColor(Color.GREEN);
            canvas.drawRect(220, 80, 420, 130, paint);
            canvas.drawRect(360, 80, 420, 240, paint);
            canvas.drawRect(170, 80, 220, 240, paint);

            paint.setColor(Color.BLACK);
            canvas.drawRect(250, 250, 350, 260, paint);
            canvas.drawCircle(300, 170,19,paint);
            canvas.drawCircle(300, 257,7,paint);
            canvas.drawRect(240, 180, 360, 200, paint);
            canvas.drawRect(260, 170, 340, 180, paint);

            canvas.drawLine(250, 240, 350, 240, paint);
            canvas.drawLine(250, 240, 280, 180, paint);
            canvas.drawLine(320, 180, 350, 240, paint);

            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setAntiAlias(true);
            Path path =  new Path();

            path.moveTo(250, 240);
            path.lineTo(350, 240);
            path.lineTo(320, 180);
            path.lineTo(280,180);

            path.lineTo(250,240);
            path.close();

            canvas.drawPath(path, paint);





        }
    }

}
