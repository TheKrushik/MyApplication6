package info.krushik.android.myapplication6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableStudentAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private int mGroupResourse;
    private int mChildResourse;
    private  ArrayList<Group> mGroups;
    private LayoutInflater mInflater;


    public ExpandableStudentAdapter(Context context, int groupResource, int childResource, ArrayList<Group> groups){
        mContext = context;
        mGroupResourse = groupResource;
        mChildResourse = childResource;
        mGroups = groups;

        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroups.get(groupPosition).Students.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups.get(groupPosition).Students[childPosition];
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(mGroupResourse, null);

        Group group = (Group) getGroup(groupPosition);

        ((TextView) view.findViewById(R.id.textViewNumber)).setText(group.Number);

        View indicator = view.findViewById(R.id.indicator);

        if(getChildrenCount(groupPosition)> 0) {
            if (isExpanded) {
                indicator.setBackgroundColor(mContext.getResources().getColor(R.color.red));
            } else {
                indicator.setBackgroundColor(mContext.getResources().getColor(R.color.green));
            }
        }


        return  view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(mChildResourse, null);

        Student student = (Student) getChild(groupPosition, childPosition);

        ((TextView) view.findViewById(R.id.textViewFirstName)).setText(student.FirstName);
        ((TextView) view.findViewById(R.id.textViewLastName)).setText(student.LastName);
        ((TextView) view.findViewById(R.id.textViewAge)).setText(String.valueOf(student.Age));

        return  view;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
