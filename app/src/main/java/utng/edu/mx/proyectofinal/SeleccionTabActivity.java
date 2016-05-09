package utng.edu.mx.proyectofinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.TextView;


public class SeleccionTabActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvTema;
    private TextView txvTemaContenido;
    private String contDelTem="";
    private MediaController mediaController;
    private Uri uri;
    private Bundle valoresRecibidosSec;
    private Bundle bundle;
    private Button btnTabInfoEvaluacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_tab_tema_layout);
        initComponents();
    }
    private void initComponents(){
        final TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        //Para el tab de informacion
        TabHost.TabSpec spec=tabHost.newTabSpec(getString(R.string.tab_informacon));
        spec.setContent(R.id.tab_informacion);
        spec.setIndicator(getString(R.string.tab_informacon), getResources().getDrawable(R.drawable.ic_info));
        tabHost.addTab(spec);
        //Para el tab de Video
        spec=tabHost.newTabSpec(getString(R.string.tab_video));
        spec.setContent(R.id.tab_video);
        spec.setIndicator(getString(R.string.tab_video), getResources().getDrawable(R.drawable.ic_video));
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);

        txvTema= (TextView) findViewById(R.id.txv_tema);
        txvTemaContenido= (TextView) findViewById(R.id.txv_tema_contenido);
        btnTabInfoEvaluacion=(Button)findViewById(R.id.btn_tab_info_evaluacion);

        btnTabInfoEvaluacion.setOnClickListener(this);

        valoresRecibidosSec = getIntent().getExtras();
        //txvTema.setText(valoresRecibidosSec.getString("temaElegido"));
        bundle=new Bundle();

        //Se almacenan los datos utilizables a un bundel
        bundle.putInt("moduloS",valoresRecibidosSec.getInt("modulo"));
        bundle.putInt("posicionTemaS",valoresRecibidosSec.getInt("posicionTema"));
        bundle.putString("temaElegidoS",valoresRecibidosSec.getString("temaElegido"));

        //Se Vincula el video
        final Button vdvVideo  = (Button) findViewById(R.id.vdv_video);

        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxx
        //Se inicializan los controles para el dieo
        mediaController = new MediaController(this);
        mediaController.setAnchorView(vdvVideo);

        switch (valoresRecibidosSec.getInt("modulo")){
            case 0:
                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0://Sobre ruby
                        contDelTem=getResources().getString(R.string.html_uno_sobre_ruby);
                        uri = Uri.parse("https://www.youtube.com/watch?v=CjmzDHMHxwU&list=PLE549A038CF82905F");
                        break;
                    case 1://Medio ambiente de configuración
                        contDelTem=getResources().getString(R.string.html_uno_medio_ambiente_configuracion);
                        uri = Uri.parse("https://www.youtube.com/watch?v=VTykmP-a2KY&index=2&list=PLE549A038CF82905F");
                        break;
                    case 2://Sintaxis
                        contDelTem=getResources().getString(R.string.html_uno_sintaxis);
                        uri = Uri.parse("https://www.youtube.com/watch?v=OtJEj7N9T6k&list=PLE549A038CF82905F&index=3");
                        break;
                    case 3://Palabras reservadas
                        contDelTem=getResources().getString(R.string.html_uno_palabras_reservadas);
                        uri = Uri.parse("https://www.youtube.com/watch?v=ssnkfbBbcuw&index=4&list=PLE549A038CF82905F");
                        break;
                    case 4://Variables
                        contDelTem=getResources().getString(R.string.html_uno_variables);
                        uri = Uri.parse("https://www.youtube.com/watch?v=ZrxcqbFYjiw&index=5&list=PLE549A038CF82905F");
                        break;
                    case 5://Operadores
                        contDelTem=getResources().getString(R.string.html_uno_operadores);
                        uri = Uri.parse("https://www.youtube.com/watch?v=vdqt8OZ-wYQ&index=6&list=PLE549A038CF82905F");
                        break;
                    case 6://Comentarios
                        contDelTem=getResources().getString(R.string.html_uno_comentarios);
                        uri = Uri.parse("https://www.youtube.com/watch?v=ep1SCWR6wD0&list=PLE549A038CF82905F&index=7");
                        break;
                    default:

                        break;
                }
                break;
            case 1:

                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        contDelTem=getResources().getString(R.string.html_dos_ciclos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=DSzqe4Rb5YY&index=8&list=PLE549A038CF82905F");
                        break;
                    case 1:
                        contDelTem=getResources().getString(R.string.html_dos_metodos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=hau_ZWsXg1M&index=9&list=PLE549A038CF82905F");
                        break;
                    case 2:
                        contDelTem=getResources().getString(R.string.html_dos_bloques);
                        uri = Uri.parse("https://www.youtube.com/watch?v=hLqKvB7tGWk&index=10&list=PLE549A038CF82905F");
                        break;
                    case 3:
                        contDelTem=getResources().getString(R.string.html_dos_modulos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=IyI2ZuOq_xQ&index=11&list=PLE549A038CF82905F");
                        break;
                    case 4:
                        contDelTem=getResources().getString(R.string.html_dos_mix);
                        uri = Uri.parse("https://www.youtube.com/watch?v=_C7Uj7O5o_Q&list=PLE549A038CF82905F&index=12");
                        break;
                    default:
                        break;
                }
                break;
            case 2:

                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        contDelTem=getResources().getString(R.string.html_tres_strings);
                        uri = Uri.parse("https://www.youtube.com/watch?v=VYXdpjCZojA&index=13&list=PLE549A038CF82905F");
                        break;
                    case 1:
                        contDelTem=getResources().getString(R.string.html_tres_arreglos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=6dE57aXaChg&list=PLE549A038CF82905F&index=14");
                        break;
                    case 2:
                        contDelTem=getResources().getString(R.string.html_tres_hashes);
                        uri = Uri.parse("https://www.youtube.com/watch?v=IvX0uGBzsyY&index=15&list=PLE549A038CF82905F");
                        break;
                    case 3:
                        contDelTem=getResources().getString(R.string.html_tres_fecha_hora);
                        uri = Uri.parse("https://www.youtube.com/watch?v=jLCehP6DCjo&list=PLE549A038CF82905F&index=16");
                        break;
                    default:

                        break;
                }
                break;
            case 3:

                switch (valoresRecibidosSec.getInt("posicionTema")){
                    case 0:
                        contDelTem=getResources().getString(R.string.html_cuatro_rangos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=WDn9iFFS-IY&index=17&list=PLE549A038CF82905F");
                        break;
                    case 1:
                        contDelTem=getResources().getString(R.string.html_cuatro_iteradores);
                        uri = Uri.parse("https://www.youtube.com/watch?v=Ycu5Re7bEUE&index=18&list=PLE549A038CF82905F");
                        break;
                    case 2:
                        contDelTem=getResources().getString(R.string.html_cuatro_directorios);
                        uri = Uri.parse("https://www.youtube.com/watch?v=0rS7nrbwgiA&index=19&list=PLE549A038CF82905F");
                        break;
                    case 3:
                        contDelTem=getResources().getString(R.string.html_cuatro_excepciones);
                        uri = Uri.parse("https://www.youtube.com/watch?v=CJiBqJ8qD1g&index=20&list=PLE549A038CF82905F");
                        break;
                    case 4:
                        contDelTem=getResources().getString(R.string.html_cuatro_orientado_objetos);
                        uri = Uri.parse("https://www.youtube.com/watch?v=asUqAIhgYTI&index=21&list=PLE549A038CF82905F");
                        break;
                    case 5:
                        contDelTem=getResources().getString(R.string.html_cuatro_expreciones_regulares);
                        uri = Uri.parse("https://www.youtube.com/watch?v=X8lwpXS36fw&list=PLE549A038CF82905F&index=22");
                        break;
                    default:

                        break;
                }
                break;
            default:

                break;
        }

        vdvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        txvTema.setText(valoresRecibidosSec.getString("nombreModulo")+": "+valoresRecibidosSec.getString("temaElegido"));
        CharSequence textoInterpretado = Html.fromHtml(contDelTem);
        txvTemaContenido.setText(textoInterpretado);

        //menda el mensaje de que pestaña fue oprimid
    }

    @Override
    public void onClick(View v) {

        byte posicionTmea= (byte) (valoresRecibidosSec.getInt("posicionTema")+1);//Se le aumenta uno ya que la posicion empiesa desde 0.
        byte pares= (byte) (posicionTmea%2);
        bundle.putBoolean("logeo",valoresRecibidosSec.getBoolean("logeo"));
        if (posicionTmea==3|posicionTmea==6){//EditText
            //3,6 ---> se le va arestar uno cunado se pase en el suich de los cuises
            startActivity(new Intent(this, CuestionarioEditTextActivity.class).putExtras(bundle));

        }else if (pares==0){//RadioButton

            startActivity(new Intent(this, CuestionarioRadioButtonActivity.class).putExtras(bundle));
            //2,4  ---> se le va arestar uno cunado se pase en el suich de los cuises

        }else {//Checkbox

            startActivity(new Intent(this, CuestionarioCheckBoxActivity.class).putExtras(bundle));
            //1,5,7 ---> se le va arestar uno cunado se pase en el suich de los cuises
        }
        finish();
    }
}