package il.ac.shenkar.ex3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class TaskListBaseAdapter extends BaseAdapter {

	private String str = "TaskListBaseAdapter";
    
    private LayoutInflater l_inflater;
    private MySingleton m_single;
    Context context;

    public TaskListBaseAdapter(Context context) 
    {
        this.context = context;
        this.m_single = MySingleton.getInstance(context);
        this.l_inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() 
    {
        return m_single.getCount();
    }

    @Override
    public boolean isEmpty()
    {
        return m_single.isEmpty();
    }

    @Override
    public Task getItem(int i)
    {
        return m_single.getItem(i);
    }

    @Override
    public long getItemId(int i)
    {
        return getItem(i).getId();
    }

    @Override
    public boolean hasStableIds ()
    {
        return true;
    }

    private final View.OnClickListener doneTask = new View.OnClickListener()
    {
        @Override
        public void onClick(View view) 
        {
            int position = (Integer) view.getTag();
            Log.d(str,getItem(position).getDescription());
            m_single.removeTask(getItem(position));
            notifyDataSetChanged();
        }
    };

    static class ViewHolder 
    {
        TextView description;
        Button doneButton;
    }
    
    @Override
    public View getView (int position, View convertView, ViewGroup parent) 
    {
        ViewHolder holder;
        if (convertView==null)
        {
            convertView = this.l_inflater.inflate(R.layout.activity_task_list_base_adapter, null);
            holder = new ViewHolder();
            holder.description = (TextView) convertView.findViewById(R.id.task_description);
            holder.doneButton = (Button) convertView.findViewById(R.id.done_button);
            holder.doneButton.setOnClickListener(doneTask);
            convertView.setTag(holder);
        } 
        else 
        {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.description.setText(getItem(position).getDescription());
        holder.doneButton.setTag(position);
        return convertView;
    }
}
