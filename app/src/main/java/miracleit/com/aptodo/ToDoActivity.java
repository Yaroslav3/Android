package miracleit.com.aptodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import model.Todo;

/**
 * Created by Ярик on 09.01.2018.
 */


public class ToDoActivity extends AppCompatActivity {
    private ListView listTodo;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnUpdate;
    public static List<String> todoList = new LinkedList<>();
    private RealmResults<Todo> all;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity);
        listTodo = findViewById(R.id.txt_list);
        btnAdd = findViewById(R.id.btn_add);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_update);
        Realm.init(this);
        getAllFind();
        choiceClick();


    }

    public void choice(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void choiceClick() {
        listTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllFind() {
        todoList.clear();
        Realm realm = Realm.getDefaultInstance();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        listTodo.setAdapter(adapter);
        all = realm.where(Todo.class).findAll();
        for (Todo elem : all) {
            todoList.add(String.valueOf(elem));
        }
    }
}
