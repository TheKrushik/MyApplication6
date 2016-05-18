package info.krushik.android.myapplication6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        final ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            students.add(new Student("Ivan" + i, "Ivanov" + i, i + 20));
        }

        final RecyclerStudentAdapter adapter = new RecyclerStudentAdapter(
                this, R.layout.child_iten, students
        );

        RecyclerView view = (RecyclerView) findViewById(R.id.recyclerView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

// создаем объект кот. унаследован от нашего интрерфейса StudentListener и передаем этот объект в наш adapter
        adapter.setStudentListener(new RecyclerStudentAdapter.StudentListener() {//подписуемся на клик студента
            @Override
            public void onClick(Student student) {
                Toast.makeText(Activity5.this, student.FirstName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(Student student) {
                Toast.makeText(Activity5.this, student.LastName, Toast.LENGTH_SHORT).show();
            }
        });

// ItemTouchHelper - WoooW!!!
        ItemTouchHelper.SimpleCallback itemTouchCallback = //Направления перетягивания
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override//Жесты для удаления
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        final int toPos = target.getAdapterPosition();
                        Student student = students.get(fromPos);
                        students.remove(fromPos);
                        students.add(toPos, student);
                        adapter.notifyItemMoved(fromPos, toPos);
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int fromPos = viewHolder.getAdapterPosition();
                        students.remove(fromPos);
                        adapter.notifyItemRemoved(fromPos);
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(view);
    }
}
