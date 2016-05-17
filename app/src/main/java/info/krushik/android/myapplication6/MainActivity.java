package info.krushik.android.myapplication6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, Activity3.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(this, Activity4.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(this, Activity5.class);
                startActivity(intent4);
                break;
        }
    }
}
