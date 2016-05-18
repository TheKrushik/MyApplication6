package info.krushik.android.myapplication6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerStudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Context mContext;
    private int mResource;
    private ArrayList<Student> mStudents;

    public RecyclerStudentAdapter(Context context,int resource, ArrayList<Student> students){
        mContext = context;
        mResource = resource;
        mStudents = students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
//        View view = inflater.inflate(mResource, null);//1й пар-р - ресурс, 2й - родитель его(а родителя нет)
        View view = inflater.inflate(mResource, parent, false); //2й пар-р можно передать в качестве родителя самого себя и будет по всей ширине
        // 3-й пар-р - при инфлейте, можно автоматически не просто получить эту view, но и вставить ее в парента, по дефолту он true

        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        final Student student = mStudents.get(position);

        holder.mTextViewFirstName.setText(student.FirstName);
        holder.mTextViewLastName.setText(student.LastName);
        holder.mTextViewAge.setText(String.valueOf(student.Age));

        holder.mRootView.setOnClickListener(new View.OnClickListener() {//навешуем клик
            @Override
            public void onClick(View v) {
                if (mListener != null) { //проверка что объект(студент) существует
                    mListener.onClick(student); //мы вызываем у него onClick
                }
            }
        });

        holder.mRootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mListener != null) { //проверка что объект(студент) существует
                    mListener.onLongClick(student); //мы вызываем у него onLongClick
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }


//делаем свой интерфейс
    private StudentListener mListener;//у нас есть переменная

    public void  setStudentListener(StudentListener listener){//кот. содержит в себе объект
        mListener = listener;
    }

    public interface StudentListener {//этот объект реализует этот интерфейс
        void onClick(Student student);
        void onLongClick(Student student);
    }
}
