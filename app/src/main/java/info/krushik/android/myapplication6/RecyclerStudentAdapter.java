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
        View view = inflater.inflate(mResource, null);

        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        final Student student = mStudents.get(position);

        holder.mTextViewFirstName.setText(student.FirstName);
        holder.mTextViewLastName.setText(student.LastName);
        holder.mTextViewAge.setText(String.valueOf(student.Age));

        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(student);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }



    private StudentListener mListener;

    public void  setStudentListener(StudentListener listener){
        mListener = listener;
    }

    public interface StudentListener {
        void onClick(Student student);
    }
}
