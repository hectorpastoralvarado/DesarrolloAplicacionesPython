package utng.edu.mx.proyectofinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import utng.edu.mx.proyectofinal.util.DBAdapter;


public class EjemploEmailActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnEnviarEmailHaora;
    private TextView txvMensaje;
    private DBAdapter dbAdapter;
    //----

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejemplo_email_layout);
        initComponents();
    }

    private void initComponents() {
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        txvMensaje=(TextView)findViewById(R.id.txv_mensaje);
        btnEnviarEmailHaora=(Button)findViewById(R.id.btn_enviar_email_haora);
        //Escuchadores

        String s1=getResources().getString(R.string.html_curso_concluido_parte_uno);
        String s2=getResources().getString(R.string.html_curso_concluido_parte_dos);
        String contDelTem=s1+FormLoginActivity.NOMBRE_USU_LOGEADO+s2;

        CharSequence textoInterpretado = Html.fromHtml(contDelTem);
        txvMensaje.setText(textoInterpretado);
        btnEnviarEmailHaora.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_enviar_email_haora:

                String para = FormLoginActivity.CORREO_USU_LOGEADO;

                 Intent email = new Intent(Intent.ACTION_SEND);


                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{para});
                //para agregar el certificado descomente la linea de abajo/////////////////////////////////////////////////////////////////////////
                email.putExtra(Intent.EXTRA_STREAM,Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.certificado));
                email.putExtra(Intent.EXTRA_SUBJECT,"Estatus del curso de: "+FormLoginActivity.NOMBRE_USU_LOGEADO);
                //agrege la linea de abajo para hacer la prueba del certificado ////////////////////////////////////////////////////////////////////7
                email.putExtra(Intent.EXTRA_TEXT, "");

                email.setType("image/png");
                startActivity(Intent.createChooser(email, getResources().getString(R.string.escoge_medio_preferencia)));

                break;
            default:
                Log.e("Switch", "onClick: No entro " );
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}