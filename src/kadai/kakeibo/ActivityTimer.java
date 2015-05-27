package kadai.kakeibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
  
public class ActivityTimer extends Activity implements OnClickListener{
    TextView timer;
    Button start,stop,dentaku,kakeibo,taima;
    MyCountDownTimer cdt;
    @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer); 
        timer = (TextView)findViewById(R.id.textView1);
        timer.setOnClickListener(this);
        start =(Button)findViewById(R.id.button1);
        start.setOnClickListener(this);
        stop =(Button)findViewById(R.id.button2);
        stop.setOnClickListener(this);
        dentaku =(Button)findViewById(R.id.button3);
        dentaku.setOnClickListener(this);
        kakeibo = (Button)findViewById(R.id.button4);
        kakeibo.setOnClickListener(this);
        taima = (Button)findViewById(R.id.button5);
        taima.setOnClickListener(this);
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			ArrayAdapter<String> adapter2 = 
					new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
				adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	  		adapter.add("0");
			adapter.add("1");
	  		adapter.add("2");
			adapter.add("3");
	  		adapter.add("4");	
	  		adapter.add("5");
	  		adapter.add("6");	
	  		adapter.add("7");
	  		adapter.add("8");
	  		adapter.add("9");
	  		
	  		for (int i = 0 ; i <60 ; i++){
	  			adapter2.add(String.valueOf(i));
	  		}
			Spinner minute = (Spinner) findViewById(R.id.minute);
			Spinner second = (Spinner) findViewById(R.id.second);
			minute.setAdapter(adapter);
			second.setAdapter(adapter2);
			
     
        //CountDownの初期値
        //final MyCountDownTimer cdt = new MyCountDownTimer(180000, 1000);
			
        
        dentaku.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        	Intent intent2 = new Intent();
			intent2.setClassName("kadai.kakeibo", "kadai.kakeibo.MainActivityDentaku");
			startActivity(intent2);
        	}
        });
        
        kakeibo.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        	Intent intent2 = new Intent();
			intent2.setClassName("kadai.kakeibo", "kadai.kakeibo.MainActivity");
			startActivity(intent2);
        	}
        });
        
          
     /*   start.setOnClickListener(new View.OnClickListener() {
        	
             
            public void onClick(View v) {
                // カウントダウン開始
            	Spinner minute = (Spinner) findViewById(R.id.minute);
    			Spinner second = (Spinner) findViewById(R.id.second);
            	String minute1 = (String)minute.getSelectedItem();
    			String second1 = (String)second.getSelectedItem();
    			int timer = Integer.valueOf(minute1)*60000 + Integer.valueOf(second1)*1000;
    			MyCountDownTimer cdt = new MyCountDownTimer(timer, 1000);
                cdt.start();
            }
        });
         
        stop.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                // カウントダウン中止
                cdt.cancel();
            }
        });  */
        
        
        
    }   
    
     
     
     
    public class MyCountDownTimer extends CountDownTimer{
 
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
      
        }
      
        @Override
        public void onFinish() {
            // カウントダウン完了後に呼ばれる
            timer.setText("0");
            Toast.makeText(getApplicationContext(), "終了", Toast.LENGTH_LONG).show();
        }
      
        @Override
        public void onTick(long millisUntilFinished) {
            // インターバル(countDownInterval)毎に呼ばれる
            timer.setText(Long.toString(millisUntilFinished/1000/60) + ":" + Long.toString(millisUntilFinished/1000%60));
        }
    }




	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
		switch(v.getId()){
		
		case R.id.button1:
			Spinner minute = (Spinner) findViewById(R.id.minute);
			Spinner second = (Spinner) findViewById(R.id.second);
        	String minute1 = (String)minute.getSelectedItem();
			String second1 = (String)second.getSelectedItem();
			int timer = Integer.valueOf(minute1)*60000 + Integer.valueOf(second1)*1000;
			cdt = new MyCountDownTimer(timer, 1000);
            cdt.start();
            break;
            
		case R.id.button2:
			cdt.cancel();
			break;
		}
		
	}
}

