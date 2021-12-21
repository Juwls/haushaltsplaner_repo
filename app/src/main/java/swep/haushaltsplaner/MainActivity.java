package swep.haushaltsplaner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //test data
    Task task1 = new Task("Kochen", "Gemüseauflauf vorbereiten");

    public void addTaskToList(View view){
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);

        EditText TaskL = findViewById(R.id.TaskL);
        EditText TaskDesc = findViewById(R.id.TaskDesc);

        textView1.setText(TaskL.getText().toString());
        textView2.setText(TaskDesc.getText().toString());

    }




}