package utng.edu.mx.proyectofinal;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utng.edu.mx.proyectofinal.util.DBAdapter;


public class CuestionarioEditTextActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtRespuesta;
    private Button btnComprobarEscrito;
    private TextView txvOracionParteUno,txvOracionParteDos;
    private String oracionUno,oracionDos;
    private Bundle valoresResividos;
    private DBAdapter dbAdapter;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario_edit_text_layout);
        initComponents();
    }

    private void initComponents() {
        dbAdapter=new DBAdapter(this);
        dbAdapter.open();
        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        edtRespuesta= (EditText) findViewById(R.id.edt_respuesta);
        btnComprobarEscrito= (Button) findViewById(R.id.btn_comprobar_escrito);

        txvOracionParteUno= (TextView) findViewById(R.id.txv_oracion_parte_uno);
        txvOracionParteDos= (TextView) findViewById(R.id.txv_oracion_parte_dos);


        valoresResividos=getIntent().getExtras();

        switch (valoresResividos.getInt("moduloS")){
            case 0://Modulo 1
                switch (valoresResividos.getInt("posicionTemaS")){
                    case 2://Sintaxis
                        oracionUno="Version de python mas reciente?";
                        oracionDos=".";
                        break;
                    case 5://Operadores
                        oracionUno="Fecha de creacion del lenguaje ? ";
                        oracionDos=".";
                        break;
                    default:
                        break;
                }
                break;
            case 1://Modulo 2
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 2://Bloques
                        oracionUno="Establece la variable mi_variable con el valor 10.";
                        oracionDos=".";
                    default:
                        break;
                }
                break;
            case 2://Modulo 3
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 2://Hashes
                        oracionUno="Establece la variable mi_bool con el valor verdadero. ";
                        oracionDos=".";
                        break;
                    default:
                        break;
                }
                break;
            case 3://Modulo 4
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 2://Directorios
                        oracionUno="Establece la variable mi_entero con el valor 7";
                        oracionDos=".";
                        break;
                    case 5://Expreciónes Regulares
                        oracionUno="Establece la variable mi_real con el valor 1.7";
                        oracionDos=".";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        edtRespuesta.setMaxWidth(120);



        txvOracionParteUno.setText(oracionUno);
        txvOracionParteDos.setText(oracionDos);
        btnComprobarEscrito.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        String respuesta = "Incorrecto";
       // String espacios="\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020";
        int idModul=dbAdapter.idPrimerModuloIns(FormLoginActivity.ID_USU_LOGEADO,"Modulo 1");
        switch (valoresResividos.getInt("moduloS")){
            case 0://Modulo 1
                switch (valoresResividos.getInt("posicionTemaS")){
                    case 2://Sintaxis
                        if (edtRespuesta.getText().toString().toLowerCase().equals("3.4.4")) {
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 1, 3);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(CuestionarioEditTextActivity.this, respuesta, Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case 5://Operadores
                        if (edtRespuesta.getText().toString().toLowerCase().equals("1991")) {
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 1, 6);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(CuestionarioEditTextActivity.this, respuesta, Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    default:
                        break;
                }
                break;
            case 1://Modulo 2
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 2://Bloques
                        if (edtRespuesta.getText().toString().toLowerCase().equals("mi_variable=10")) {
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 2, 3);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(CuestionarioEditTextActivity.this, respuesta, Toast.LENGTH_SHORT).show();
                        finish();
                    default:
                        break;
                }
                break;
            case 2://Modulo 3
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 2://Hashes
                        if (edtRespuesta.getText().toString().toLowerCase().equals("mi_bool=true")) {
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            dbAdapter.activarTema(idModul, 3, 3);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(CuestionarioEditTextActivity.this, respuesta, Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    default:
                        break;
                }
                break;
            case 3://Modulo 4
                switch (valoresResividos.getInt("posicionTemaS")) {
                    case 2://Directorios
                        if (edtRespuesta.getText().toString().toLowerCase().equals("mi_entero=7")) {
                            respuesta ="Correcto; Siguiente tema desbloqueado";
                            //int idModul=dbAdapter.idPrimerModuloIns(FormLoginActivity.ID_USU_LOGEADO,"Modulo 1");
                            dbAdapter.activarTema(idModul, 4, 3);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(CuestionarioEditTextActivity.this, respuesta, Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case 5://Expreciónes Regulares
                        if (edtRespuesta.getText().toString().toLowerCase().equals("mi_real=1.7")) {
                            respuesta ="Correcto; Examen del módulo desbloqueado";
                            dbAdapter.activarTema(idModul, 4, 6);
                        }else {
                            vibrator.vibrate(1000);
                        }
                        Toast.makeText(CuestionarioEditTextActivity.this, respuesta, Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }
}
