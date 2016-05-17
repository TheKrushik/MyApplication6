package info.krushik.android.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity3 extends AppCompatActivity {

    private final  static String KEY_NUMBER = "Number";
    private final  static String KEY_NAME= "Name";
    private final  static String KEY_AGE = "Age";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ArrayList<HashMap<String,String>> groups = new ArrayList<>();

        HashMap<String, String> group = new HashMap<>();
        group.put(KEY_NUMBER, "Number 1");
        groups.add(group);

        group = new HashMap<>();
        group.put(KEY_NUMBER, "Number 2");
        groups.add(group);

        group = new HashMap<>();
        group.put(KEY_NUMBER, "Number 3");
        groups.add(group);

        ArrayList<ArrayList<HashMap<String, String>>> children = new ArrayList<>();

        //Group1
        ArrayList<HashMap<String, String>> childs = new ArrayList<>();

        HashMap<String, String> child = new HashMap<>();
        child.put(KEY_NAME, "Ivan");
        child.put(KEY_AGE, "20");

        childs.add(child);
        children.add(childs);

        //Group 2
        childs = new ArrayList<>();

        child = new HashMap<>();
        child.put(KEY_NAME, "Petro");
        child.put(KEY_AGE, "21");

        childs.add(child);

        child = new HashMap<>();
        child.put(KEY_NAME, "Ann");
        child.put(KEY_AGE, "22");

        childs.add(child);

        children.add(childs);

        //Group 3
        childs = new ArrayList<>();
        children.add(childs);

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groups,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{KEY_NUMBER},
                new int[]{android.R.id.text1},
                children,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{KEY_NAME, KEY_AGE},
                new int[]{android.R.id.text1, android.R.id.text2});

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
