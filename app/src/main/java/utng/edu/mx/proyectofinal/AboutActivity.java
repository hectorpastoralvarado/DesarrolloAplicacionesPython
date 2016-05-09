package utng.edu.mx.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by hectorjesus on 29/02/2016.
 */
public class AboutActivity extends Activity implements View.OnClickListener {
    private Button btnIdexUtng;
    private Button btnCanvas;
    private Button btnLinterna;
    private Button btnJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
        btnIdexUtng = (Button)findViewById(R.id.btn_untg_index);
        btnIdexUtng.setOnClickListener(this);
        btnCanvas = (Button)findViewById(R.id.btn_canvas);
        btnCanvas.setOnClickListener(this);
        btnLinterna = (Button)findViewById(R.id.btn_linterna);
        btnLinterna.setOnClickListener(this);
        btnJuego = (Button)findViewById(R.id.btn_memorama);
        btnJuego.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_untg_index:
                startActivity(new Intent(AboutActivity.this, IndexActivity.class));
                Toast.makeText(getApplicationContext(), "Promocion UTNG", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_canvas:
                startActivity(new Intent(AboutActivity.this, CanvasActivity.class));
                Toast.makeText(getApplicationContext(), "Canvas UTNG", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_linterna:
                startActivity(new Intent(AboutActivity.this, LinternaActivity.class));
                break;
            case R.id.btn_memorama:
                startActivity(new Intent(AboutActivity.this, juegos_main.class));
                break;

            default:
                break;
        }
    }
}
