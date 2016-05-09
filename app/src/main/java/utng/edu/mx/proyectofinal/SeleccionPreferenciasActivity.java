package utng.edu.mx.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;


/**
 * Created by hectorjesus on 01/03/2016.
 */
public class SeleccionPreferenciasActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addPreferencesFromResource(R.xml.opciones_preferencia);
        Preference preference = (Preference)findPreference(getString(R.string.btn_regresar));
        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SeleccionPreferenciasActivity.this, SplashScreenActivity.class));
                finish();
                return false;
            }
        });
    }
}
