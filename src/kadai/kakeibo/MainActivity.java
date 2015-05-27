package kadai.kakeibo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener{
	
	//DBを使うための道具入れ
	DBManager db = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//DBを使うための道具を生成する
		db = new DBManager(this);
		
		Button wbtn = (Button)findViewById(R.id.writebtn);
		wbtn.setOnClickListener(this);
		
		Button kakobtn = (Button)findViewById(R.id.kakobtn);
		kakobtn.setOnClickListener(this);
		
		Button dentakubtn2 = (Button)findViewById(R.id.dentakubtn2);
		dentakubtn2.setOnClickListener(this);
		
		Button kakeibobtn2 = (Button)findViewById(R.id.kakeibobtn2);
		kakeibobtn2.setOnClickListener(this);
		
		Button taimabtn2 = (Button)findViewById(R.id.taimabtn2);
		taimabtn2.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// アイテムを追加します
			adapter.add("食費");
	  		adapter.add("光熱費");
			adapter.add("水道費");
	  		adapter.add("家賃");	
	  		adapter.add("趣味・娯楽費");
	  		adapter.add("小遣い（配偶者）");	
	  		adapter.add("小遣い（子供）");
	  		adapter.add("小遣い（自分）");
	  		adapter.add("その他");
			Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
			Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
			Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
			Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
			Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
			// アダプターを設定します
			spinner1.setAdapter(adapter);
			spinner2.setAdapter(adapter);
			spinner3.setAdapter(adapter);
			spinner4.setAdapter(adapter);
			spinner5.setAdapter(adapter);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void insert(String a , String b , String c){
		if(!b.equals("")){
		int kingaku = Integer.valueOf(b);
		db.insertKakeibo(a,kingaku,c);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
		switch(v.getId()){
		
		case R.id.writebtn:
			Spinner sp1 = (Spinner)findViewById(R.id.spinner1);
			Spinner sp2 = (Spinner)findViewById(R.id.spinner2);
			Spinner sp3 = (Spinner)findViewById(R.id.spinner3);
			Spinner sp4 = (Spinner)findViewById(R.id.spinner4);
			Spinner sp5 = (Spinner)findViewById(R.id.spinner5);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf =
					new SimpleDateFormat("yyyy年MM月dd日");
			String strDate = sdf.format(cal.getTime());
			
			EditText et1 = (EditText)findViewById(R.id.txt1);
			EditText et2 = (EditText)findViewById(R.id.txt2);
			EditText et3 = (EditText)findViewById(R.id.txt3);
			EditText et4 = (EditText)findViewById(R.id.txt4);
			EditText et5 = (EditText)findViewById(R.id.txt5);
			
			insert((String)sp1.getSelectedItem(), (et1.getText().toString()) , strDate);
			insert((String)sp2.getSelectedItem(), (et2.getText().toString()) , strDate);
			insert((String)sp3.getSelectedItem(), (et3.getText().toString()) , strDate);
			insert((String)sp4.getSelectedItem(), (et4.getText().toString()) , strDate);
			insert((String)sp5.getSelectedItem(), (et5.getText().toString()) , strDate);
			break;
			
		case R.id.kakobtn:
			Intent intent = new Intent();
			intent.setClassName("kadai.kakeibo", "kadai.kakeibo.ViewActivity");
			startActivity(intent);
			break;
			
		case R.id.dentakubtn2:
			Intent intent2 = new Intent();
			intent2.setClassName("kadai.kakeibo", "kadai.kakeibo.MainActivityDentaku");
			startActivity(intent2);
			break;
			
		case R.id.taimabtn2:
			Intent intent3 = new Intent();
			intent3.setClassName("kadai.kakeibo", "kadai.kakeibo.ActivityTimer");
			startActivity(intent3);
			break;
			
			
		
			
			
			
			
		
	}
}
}
