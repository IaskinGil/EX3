package il.ac.shenkar.ex3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateTaskActivity extends Activity 
{
	private MySingleton m_single;

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        m_single = MySingleton.getInstance(this);
        final TextView description = (TextView) findViewById(R.id.enter_task);
        final Button newTaskButton = (Button) findViewById(R.id.create_button);
        newTaskButton.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
            	m_single.pushTask(description.getText().toString());
                finish();
            }
        });
    }
}
