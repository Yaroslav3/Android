package miracleit.com.aptodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import model.Todo;

/**
 * Created by Ярик on 10.01.2018.
 */

public class AddActivity extends AppCompatActivity {
    private Button buttonOk;
    private Button buttonCancal;
    private EditText editTextName;
    private EditText editTextId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        buttonOk = findViewById(R.id.btn_add);
        buttonCancal = findViewById(R.id.btn_cancel);
        editTextName = findViewById(R.id.txt_name);
        editTextId = findViewById(R.id.id_user);
        Realm.init(this);
    }

    public void choice(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
//                long id = getNextKey();
                Todo todo = new Todo();
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
//                todo.setId(id);
                todo.setName(editTextName.getText().toString());
                todo.setUserId(Long.valueOf(editTextId.getText().toString()));
                realm.insert(todo);
                realm.commitTransaction();
                Toast.makeText(this, "saved in todo", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ToDoActivity.class);
                startActivity(intent);
                break;
        }
    }


//    private long getNextKey() {
//        return ToDoActivity.realm.where(RealmModel.class).max("id").intValue() + 1;
//    }
}
