package utng.edu.mx.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;

/**
 * Created by LuIs on 02/05/2016.
 */
public class IndexActivity extends Activity implements View.OnClickListener {
    private Button btnCarreras;
    private Button btnApirantes;
    private Button btnRegresar;
    private ImageButton imbVideoPromo;
    private ImageButton imbGaleria;

    private MediaController mediaController;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_utng_layout);
        btnCarreras = (Button)findViewById(R.id.btn_carreras);
        btnApirantes = (Button)findViewById(R.id.btn_aspirantes);
        btnRegresar = (Button)findViewById(R.id.btn_regresar);
        imbVideoPromo = (ImageButton)findViewById(R.id.imb_videopromo);
        btnRegresar.setOnClickListener(this);
        btnApirantes.setOnClickListener(this);
        btnCarreras.setOnClickListener(this);
        imbVideoPromo.setOnClickListener(this);

        imbGaleria = (ImageButton)findViewById(R.id.imb_galeria);
        imbGaleria.setOnClickListener(this);


        mediaController = new MediaController(this);
        mediaController.setAnchorView(imbVideoPromo);

}


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_aspirantes:
                startActivity(new Intent(IndexActivity.this, AspirantesUntgActivity.class));
                break;
            case R.id.btn_carreras:
                startActivity(new Intent(IndexActivity.this, CarrerasUtngActivity.class));
                break;
            case R.id.btn_regresar:
                startActivity(new Intent(IndexActivity.this, AboutActivity.class));
                finish();
                break;
            case R.id.imb_videopromo:
                uri = Uri.parse("https://youtu.be/pmEksO0F8Xw");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
                break;
            case R.id.imb_galeria:
                startActivity(new Intent(IndexActivity.this, MenuGaleriaActivity.class));
                break;

            default:
                break;

        }
    }
}
