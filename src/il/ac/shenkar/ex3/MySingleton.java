package il.ac.shenkar.ex3;

import android.content.Context;
import java.util.ArrayList;

public class MySingleton 
{
	private Long SIZE = (long)0;
    private static MySingleton instance = null;
    private ArrayList<Task> tasks;
    Context context;

    //private ctor. enforces singleton
    private MySingleton(Context context)
    {
        this.context = context;
        tasks = new ArrayList<Task>();
    }

    //public accessor for the class
    public synchronized static MySingleton getInstance(Context context)
    {
        if (instance==null)
            instance = new MySingleton(context);
        return instance;
    }

    //add new task
    public void pushTask(String description)
    {
        tasks.add(new Task(SIZE, description));
        SIZE++;
    }
    
    //remove any task
    public void removeTask(Task taskToRemove)
    {
        tasks.remove(taskToRemove);
    }

    public int getCount() 
    {
        return tasks.size();
    }

    public boolean isEmpty()
    {
        return tasks.isEmpty();
    }

    //get items from new to old
    public Task getItem(int i) 
    {
        return tasks.get(tasks.size()-i-1);
    }

    public void FillList()
    {
        pushTask("Get milk");
        pushTask("pickup the kids");
        pushTask("do homework");
    } 
}
