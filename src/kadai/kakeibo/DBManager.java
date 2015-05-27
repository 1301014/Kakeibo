package kadai.kakeibo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBManager extends SQLiteOpenHelper {
	
	SQLiteDatabase sdb = null;
	
	public DBManager(Context context){
		super(context,"kakeibodb.db",null,1);
		sdb = getReadableDatabase();
		

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ

		db.execSQL("create table kakeibo(" + "koumoku TEXT," + "kingaku INTEGER," + "kakeiboDay TEXT);");
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	public void insertKakeibo(String inKoumoku, Integer inKingaku, String inDay){
		
		try{
			//トランザクション開始
			sdb.beginTransaction();
			
			//挿入する内容を設定
			ContentValues cv = new ContentValues();
			cv.put("koumoku", inKoumoku);
			cv.put("kingaku", inKingaku);
			cv.put("kakeiboDay", inDay);
			
			//テーブルに挿入
			sdb.insert("kakeibo", "", cv);
			
			//トランザクション成功
			sdb.setTransactionSuccessful();
			
		}finally{
			//トランザクション終了
			sdb.endTransaction();
		}
		
		
		
		
	}
	//全件取得
	public Cursor getAllKakeibo(){
			
		Cursor cursor = null;
			
		//SQLを設定
		StringBuilder sql = new StringBuilder();  
		sql.append(" SELECT * FROM kakeibo;");  
			        
		//SQLを実行する       
		try{  
			cursor = sdb.rawQuery(sql.toString(), null);   
		}
		catch(Exception ex){
			Log.v("DBTEST", "InsertError:" + ex.getMessage());
		}
		
		return cursor;
	}

	
	
	}


