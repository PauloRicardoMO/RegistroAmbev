package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class RegAmbevOpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_USUARIO = "usuario";
    public static final String COLUMN_CODIGO = "codigo";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMAN_ADM = "adm";
    public static final String COLUMN_SENHA = "senha";


    public static final String DATABASE_NAME = "RegAmbev.db";
    public static final int DATABASE_VERSION = 1;

    private String sqlUsuario = "CREATE TABLE USUARIO ( codigo INTEGER PRIMARY KEY AUTOINCREMENT"
            + " nome TEXT NOT NULL, "
            + " login TEXT NOT NULL, "
            + " adm INTEGER NOT NULL, "
            + " senha TEXT NOT NULL);";

    //Database creation sql statement
    private static final String DATABASE_CREATE = "CREATE TABLE "
            + TABLE_USUARIO + " ( " + COLUMN_CODIGO
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOME
            + " TEXT NOT NULL, " + COLUMN_LOGIN
            + " TEXT NOT NULL, " + COLUMAN_ADM
            + " TEXT NOT NULL, " + COLUMN_SENHA
            + " TEXT NOT NULL);";


    private String sqlVeiculo = "CREATE TABLE VEICULO ( codigo INTEGER PRIMARY KEY AUTOINCREMENT"
            + " placa TEXT NOT NULL, "
            + " marca TEXT , "
            + " modelo TEXT , "
            + " ano INTEGER);";

    private String sqlMotorista = "CREATE TABLE MOTORISTA ( codigo INTEGER PRIMARY KEY AUTOINCREMENT"
            + " nome TEXT NOT NULL, "
            + " cnh TEXT NOT NULL);";

    private String sqlProduto = "CREATE TABLE PRODUTO ( codigo INTEGER PRIMARY KEY AUTOINCREMENT"
            + " codBarras TEXT NOT NULL, "
            + " descricao TEXT NOT NULL, "
            + " paletizacao REAL NOT NULL);";

    private String sqlItem = "CREATE TABLE ITEM ( codigo INTEGER PRIMARY KEY AUTOINCREMENT"
            + " qtdIndividual INTEGER NOT NULL, "
            + " qtdPaletes INTEGER NOT NULL, "
            + " codProduto INTEGER not null"
            + " codContagem INTEGER NOT NULL);";

    private String sqlContagem = "CREATE TABLE CONTAGEM ( codigo INTEGER PRIMARY KEY AUTOINCREMENT"
            + " horaInicio TEXT NOT NULL, "
            + " horaFim TEXT NOT NULL, "
            + " numNota INTEGER NOT NULL);";

    private String sqlRegistro = "CREATE TABLE REGISTRO ( codigo INTEGER PRIMARY KEY AUTOINCREMENT"
            + " data TEXT NOT NULL, "
            + " hora TEXT NOT NULL, "
            + " tipo TEXT NOT NULL, "
            + " codContagem INTEGER, "
            + " codVeiculo INTEGER not null, "
            + " codMotorista INTEGER not null, "
            + " obs TEXT);" ;

    public RegAmbevOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DATABASE_CREATE);
            db.execSQL(sqlMotorista);
            db.execSQL(sqlVeiculo);
            db.execSQL(sqlProduto);
            db.execSQL(sqlItem);
            db.execSQL(sqlContagem);
            db.execSQL(sqlRegistro);
            db.execSQL("Insert into USUARIO (nome,login,adm,senha) values ('master','admin',1,'123')");
            Log.e("banco", "deu bom");
        }catch(SQLiteException e){
            Log.e("banco", "deu ruim");

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
    }
}
