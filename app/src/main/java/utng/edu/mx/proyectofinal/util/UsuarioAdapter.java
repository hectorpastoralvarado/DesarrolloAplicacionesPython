package utng.edu.mx.proyectofinal.util;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import utng.edu.mx.proyectofinal.R;
import utng.edu.mx.proyectofinal.dao.DBHelper;

/**
 * Created by Juan Ramon Delgado Mendoza on 07/03/2016.
 * @author Juan Ramon Delgado Mendoza
 * @email mon-ra16@hotmail.com
 *
 */
public class UsuarioAdapter extends CursorAdapter {

    public UsuarioAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_usuario_db_layout,null,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txvNombre= (TextView)view.findViewById(R.id.txv_nombre_db);

        txvNombre.setText(
                cursor.getString(cursor.getColumnIndex(DBHelper.NAME))+" "+
                cursor.getString(cursor.getColumnIndex(DBHelper.MAIL))+" "+
                cursor.getString(cursor.getColumnIndex(DBHelper.PASSWORD)));

    }
}
