package utng.edu.mx.proyectofinal.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import utng.edu.mx.proyectofinal.model.Usuario;


public interface UsuarioDAO {
    void agregar(Usuario usuario, SQLiteDatabase db);
    void modificar(Usuario usuario, SQLiteDatabase db);
    void eliminar(Usuario usuario, SQLiteDatabase db);
    Cursor listar(SQLiteDatabase db);
}
