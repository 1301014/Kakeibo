package kadai.kakeibo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ViewActivity extends Activity implements OnClickListener{
	
	DBManager db = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		db = new DBManager(this);
		refreshList();
		Button kakobtn = (Button)findViewById(R.id.kakikomibtn);
		kakobtn.setOnClickListener(this);
		Button dentakubtn = (Button)findViewById(R.id.dentakubtn2);
		dentakubtn.setOnClickListener(this);
		Button timerbtn = (Button)findViewById(R.id.taimabtn2);
		timerbtn.setOnClickListener(this);

	
	}
	
	/*public static String space(String str,int size){
		if(str == null) return null;
		
		//�}������X�y�[�X�̐����v�Z�iByte�T�C�Y�Ōv�Z�j
		int space = size - str.getBytes().length;
		if(space<=0) return str;
		
		//�X�y�[�X�̑}��
		StringBuffer sb = new StringBuffer(size);
		sb.append(str);
		for(int i=0; i<space; i++){
			sb.append(" ");
		}
		
	return sb.toString();
		
	} */
	
	//ListView�ɓ��L�̓��e��\������
		private void refreshList(){
			
			//DB����������
			Cursor c = db.getAllKakeibo();
			
			ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
			// �A�C�e����ǉ����܂�
			while (c.moveToNext()){ 
				
				/* String koumoku = space(c.getString(0),15);
				String kingaku = space(c.getString(1),10);
				String day = space(c.getString(2),22);
				
				String kekka = koumoku + kingaku + day;
				adapter.add(kekka); */
				
				String kingaku = c.getString(1) + "�~";
				String kekka = c.getString(0) + "�@" + kingaku + "�@" +  c.getString(2) ;
				adapter.add(kekka); 
				
				
			} 
			       
			ListView listView = (ListView)findViewById(R.id.listView1);
			// �A�_�v�^�[��ݒ肵�܂�
			listView.setAdapter(adapter);

		}

	@Override
	public void onClick(View v) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
		switch(v.getId()){
			case R.id.kakikomibtn:
				Intent intent2 = new Intent();
				intent2.setClassName("kadai.kakeibo", "kadai.kakeibo.MainActivity");
				startActivity(intent2);
				break;
				
			case R.id.dentakubtn2:
				Intent intent3 = new Intent();
				intent3.setClassName("kadai.kakeibo", "kadai.kakeibo.MainActivityDentaku");
				startActivity(intent3);
				break;
				
			case R.id.taimabtn2:
				Intent intent = new Intent();
				intent.setClassName("kadai.kakeibo", "kadai.kakeibo.ActivityTimer");
				startActivity(intent);
				break;
		
		
		
		}
		
	}


}
