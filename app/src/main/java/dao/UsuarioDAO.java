package dao;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteException;
        import android.util.Log;

        import java.util.ArrayList;
        import java.util.List;

        import database.RegAmbevOpenHelper;
        import model.Usuario;

public class UsuarioDAO {
    private SQLiteDatabase database;
    private String[] columns = {"codigo", "nome", "login", "tipo", "senha"};
    private RegAmbevOpenHelper sqliteOpenHelper;

    public UsuarioDAO(Context context) {
        sqliteOpenHelper = new RegAmbevOpenHelper(context);
    }

    public void open() throws SQLException{
        try{
            database = sqliteOpenHelper.getWritableDatabase();
            Log.e("dao","aberto");
        }catch (NullPointerException e){
            Log.e("dao","não abriu");
        }

    }

    public void close() {
        sqliteOpenHelper.close();
    }

    public Usuario create(String nome, String login, String adm, String senha){
        ContentValues values = new ContentValues();
        values.put(RegAmbevOpenHelper.COLUMN_NOME, nome);
        values.put("login", login);
        values.put("adm", adm);
        values.put("senha", senha);
        int insertCodigo = (int) database.insert(RegAmbevOpenHelper.TABLE_USUARIO, null, values);
        Log.i("getCodigo", "" + insertCodigo);
        Cursor cursor = database.query("Usuario",columns, "codigo = "+insertCodigo,null
        ,null,null,null);
        cursor.moveToFirst();
        Usuario newUsuario = new Usuario();
        newUsuario.setCodigo(cursor.getInt(0));
        newUsuario.setNome(cursor.getString(1));
        newUsuario.setLogin(cursor.getString(2));
        newUsuario.setAdm(cursor.getInt(3));
        newUsuario.setSenha(cursor.getString(4));
        cursor.close();
        return newUsuario;
    }

    public void delete(Usuario usuario){
        int id = usuario.getCodigo();
        database.delete(RegAmbevOpenHelper.TABLE_USUARIO, "codigo = "+ id, null);
    }

    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            Cursor cursor = database.query(RegAmbevOpenHelper.TABLE_USUARIO,
                    columns, null, null, null, null, RegAmbevOpenHelper.COLUMN_NOME);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(cursor.getInt(0));
                usuario.setNome(cursor.getString(1));
                usuario.setLogin(cursor.getString(2));
                usuario.setAdm(cursor.getInt(3));
                usuario.setSenha(cursor.getString(4));
                usuarios.add(usuario);
                cursor.moveToNext();
            }
            cursor.close();
        }catch (NullPointerException np){
            Log.e("dao Busca","database nulo");
        }
        return usuarios;
    }

    public Usuario getByLoginSenha(String login, String senha) {
        Usuario usuario = new Usuario();

        Cursor cursor = database.query("Usuario", columns, "login = '" + login + "' and senha = '"+ senha +"'",
                null, null, null, null);

        cursor.moveToFirst();
        usuario.setCodigo(cursor.getInt(0));
        usuario.setNome(cursor.getString(1));
        usuario.setLogin(cursor.getString(2));
        usuario.setAdm(cursor.getInt(3));
        usuario.setSenha(cursor.getString(4));
        cursor.close();
        return usuario;
    }

}
