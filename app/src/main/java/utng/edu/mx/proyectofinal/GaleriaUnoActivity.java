package utng.edu.mx.proyectofinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GaleriaUnoActivity extends Activity implements View.OnClickListener {

    ImageView foto;
    TextView tv;
    int[] fotoId = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};
    String[] textos = {"UTNG", "UTNG", "UTNG", "UTNG", "UTNG", "UTNG"};
    int i = 0;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_uno);

        ImageButton anterior = (ImageButton) findViewById(R.id.button1);
        ImageButton siguiente = (ImageButton) findViewById(R.id.button2);
        anterior.setOnClickListener(this);
        siguiente.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.textView1);
        foto = (ImageView) findViewById(R.id.imageView1);
        total = fotoId.length;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if(id == R.id.button2) {
            i++;
            if(i == total){
                i = 0;
            }
        }

        if(id == R.id.button1) {
            i--;
            if(i == -1){
                i = total -1;
            }
        }
        foto.setImageResource(fotoId[i]);
        tv.setText(textos[i]);

    }

}
