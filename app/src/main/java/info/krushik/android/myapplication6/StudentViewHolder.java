package info.krushik.android.myapplication6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextViewFirstName;
    public TextView mTextViewLastName;
    public TextView mTextViewAge;
    public View mRootView;

    public StudentViewHolder(View itemView) {
        super(itemView);

        mTextViewFirstName = (TextView) itemView.findViewById(R.id.textViewFirstName);
        mTextViewLastName = (TextView) itemView.findViewById(R.id.textViewLastName);
        mTextViewAge = (TextView) itemView.findViewById(R.id.textViewAge);
        mRootView = itemView.findViewById(R.id.rootViev);
    }
}
