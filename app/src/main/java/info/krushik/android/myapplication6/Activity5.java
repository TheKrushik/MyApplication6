package info.krushik.android.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            students.add(new Student("Ivan" + i, "Ivanov" + i, i + 20));
        }

        RecyclerStudentAdapter adapter = new RecyclerStudentAdapter(
                this, R.layout.child_iten, students
        );

        RecyclerView view = (RecyclerView) findViewById(R.id.recyclerView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        adapter.setStudentListener(new RecyclerStudentAdapter.StudentListener() {
            @Override
            public void onClick(Student student) {
                Toast.makeText(MainActivity.this, st)
            }
        });


    }
}
