package utng.edu.mx.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class TvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv_layout);
        WebView myWebView = (WebView) this.findViewById(R.id.web_radio);
        myWebView.loadUrl("http://tv-envivo.net/canal-de-las-estrellas-en-vivo-por-internet.html");
        Toast.makeText(getApplicationContext(),"Cargando...",Toast.LENGTH_SHORT ).show();
    }
}
