package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RegistroAmbev.db";

    private static final String SQL_CREATE_TABLE_USUARIO = "CREATE TABLE Usuario(" +
            "nomeUsuario TEXT PRIMARY KEY NOT NULL, nome TEXT NOT NULL, senha TEXT NOT NULL,"+
            "tipo TEXT NOT NULL)";

    private static final String SQL_CREATE_TABLE_VEICULO = "CREATE TABLE Veiculo(" +
            "placa TEXT PRIMARY KEY NOT NULL, marca TEXT, modelo TEXT, ano INTEGER)";

    private static final String SQL_CREATE_TABLE_MOTORISTA = "CREATE TABLE Motorista(" +
            "cnh TEXT PRIMARY KEY NOT NULL, nome TEXT)";

    private static final String SQL_CREATE_TABLE_PRODUTO = "CREATE TABLE Produto(" +
            "codigo TEXT PRIMARY KEY NOT NULL, codigoBarras TEXT NOT NULL, " +
             "descricao TEXT NOT NULL, paletizacao INTEGER NOT NULL)";

    private static final String SQL_CREATE_TABLE_CONTAGEM = "CREATE TABLE Contagem(" +
            "codigo TEXT PRIMARY KEY NOT NULL, horaInicio TEXT NOT NULL, " +
            "horaFim TEXT NOT NULL, notaFiscal INTEGER NOT NULL)";

    private static final String SQL_CREATE_TABLE_PRODUTOCONTAGEM = "CREATE TABLE ProdutoContagem(" +
            "codProduto TEXT NOT NULL, codContagem TEXT NOT NULL, qtdProduto INTEGER NOT NULL," +
            "qtdPalete INTEGER NOT NULL, PRIMARY KEY(codProduto,codContagem)," +
            "FOREIGN KEY(codProduto) REFERENCES Produto(codigo)," +
            "FOREIGN KEY(codContagem) REFERENCES Contagem(codigo))";

    private static final String SQL_CREATE_TABLE_REGISTRO = "CREATE TABLE Registro(" +
            "codigo TEXT PRIMARY KEY NOT NULL, dataRegistro TEXT NOT NULL, " +
            "hora TEXT NOT NULL, obs TEXT, tipo TEXT NOT NULL, " +
            "codUsuario TEXT NOT NULL, codContagem TEXT NOT NULL," +
            "codVeiculo TEXT NOT NULL, codMotorista TEXT NOT NULL," +
            "FOREIGN KEY(codUsuario) REFERENCES Usuario(nomeUsuario)," +
            "FOREIGN KEY(codContagem) REFERENCES Contagem(codigo)," +
            "FOREIGN KEY(codVeiculo) REFERENCES Veiculo(placa)," +
            "FOREIGN KEY(codMotorista) REFERENCES Motorista(cnh))";

    private static final String SQL_DELETE_TABLE_USUARIO= "DROP TABLE IF EXISTS Usuario";
    private static final String SQL_DELETE_TABLE_VEICULO= "DROP TABLE IF EXISTS Veiculo";
    private static final String SQL_DELETE_TABLE_MOTORISTA= "DROP TABLE IF EXISTS Motorista";
    private static final String SQL_DELETE_TABLE_PRODUTO= "DROP TABLE IF EXISTS Produto";
    private static final String SQL_DELETE_TABLE_CONTAGEM= "DROP TABLE IF EXISTS Contagem";
    private static final String SQL_DELETE_TABLE_PRODUTOCONTAGEM= "DROP TABLE IF EXISTS ProdutoContagem";
    private static final String SQL_DELETE_TABLE_REGISTRO= "DROP TABLE IF EXISTS Registro";

    public BancoDeDados(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_TABLE_USUARIO);
        db.execSQL(SQL_CREATE_TABLE_VEICULO);
        db.execSQL(SQL_CREATE_TABLE_MOTORISTA);
        db.execSQL(SQL_CREATE_TABLE_PRODUTO);
        db.execSQL(SQL_CREATE_TABLE_CONTAGEM);
        db.execSQL(SQL_CREATE_TABLE_PRODUTOCONTAGEM);
        db.execSQL(SQL_CREATE_TABLE_REGISTRO);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_TABLE_USUARIO);
        db.execSQL(SQL_DELETE_TABLE_VEICULO);
        db.execSQL(SQL_DELETE_TABLE_MOTORISTA);
        db.execSQL(SQL_DELETE_TABLE_PRODUTO);
        db.execSQL(SQL_DELETE_TABLE_CONTAGEM);
        db.execSQL(SQL_DELETE_TABLE_PRODUTOCONTAGEM);
        db.execSQL(SQL_DELETE_TABLE_REGISTRO);
        onCreate(db);
    }
}

