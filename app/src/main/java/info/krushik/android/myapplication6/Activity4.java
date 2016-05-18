package info.krushik.android.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        ArrayList<Group> groups = new ArrayList<>();

        Group group = new Group(
                "Number 1",
                new Student[]{
                        new Student("Ivan0" , "Ivanov0", 20),
                        new Student("Ivan1" , "Ivanov1", 21),
                        new Student("Ivan2" , "Ivanov2", 22)
                });
        groups.add(group);

        group = new Group(
                "Number 2",
                new Student[0]);
        groups.add(group);

        group = new Group(
                "Number 3",
                new Student[]{
                        new Student("Ivan3" , "Ivanov3", 23),
                        new Student("Ivan4" , "Ivanov4", 24)
                });
        groups.add(group);

        ExpandableStudentAdapter adapter = new ExpandableStudentAdapter(
                this, R.layout.group_item, R.layout.child_iten, groups
        );

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

//        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//
//            }
//        });


    }
}
