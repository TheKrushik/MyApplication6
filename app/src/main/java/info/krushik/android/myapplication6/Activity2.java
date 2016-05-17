package info.krushik.android.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String[] arr = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                arr);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }
}
