package mx.tecm.ladm_u2_prctica1_presentacindedademuertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View

    class Lienzo(p:MainActivity): View(p){
        var xToucht1 = 700f
        var yToucht1 = 1240f

        var xCatri=-50f
        var yCatri=1200f
        var incrementoX=10
        var trabajando=false;

        val mover = object : CountDownTimer(2000,100) {

            override fun onTick(p0: Long) {
                xCatri += incrementoX
                if (xCatri <= -100 || xCatri >= 1200) incrementoX *= -1
                invalidate()
            }

            override fun onFinish() {
                start()
            }
        }
            init {
                mover.start()
            }

        override fun onDraw(c: Canvas) {
            super.onDraw(c)
            val p = Paint()
            c.drawColor(Color.BLACK)

            p.setColor(Color.WHITE)
            c.drawCircle(540f,200f,100f,p)

            p.setColor(Color.BLACK)
            c.drawCircle(600f,200f,80f,p)

            p.setARGB(255,80,40,0)
            c.drawCircle(540f,2000f,1000f,p)

            val tumba2 = BitmapFactory.decodeResource(resources,R.drawable.tumba2)
            c.drawBitmap(tumba2, 220f,420f,p)

            val tumba1 = BitmapFactory.decodeResource(resources,R.drawable.tumba2)
            c.drawBitmap(tumba1, (xToucht1-tumba2.width/1.5f),(yToucht1-tumba2.height/8),p)

            p.setARGB(255,135,112,82)
            c.drawRect(78f,700f,200f,1200f,p)


            p.setARGB(255,5,150,60)
            c.drawCircle(130f,500f,300f,p)

            p.setARGB(255,135,112,82)
            c.drawRect(600f,1300f,700f,1600f,p)

            p.setARGB(255,5,150,60)
            c.drawCircle(650f,1300f,100f,p)

            val catrina = BitmapFactory.decodeResource(resources,R.drawable.catrina)
            c.drawBitmap(catrina, (xCatri-catrina.width),(yCatri-catrina.height),p)
        }

    }

