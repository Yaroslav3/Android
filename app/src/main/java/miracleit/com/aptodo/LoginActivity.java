package miracleit.com.aptodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import model.User;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText txtEmail;
    private EditText txtPassword;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.long_main);
        btnLogin = findViewById(R.id.btn_Go);
        txtEmail = findViewById(R.id.email_email);
        txtPassword = findViewById(R.id.password);
        textView = findViewById(R.id.txt_registration);
        Realm.init(this);



        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> users  = realm.where(User.class).findAll();

        for (User elem : users){
            System.out.println(elem.getName());
        }

    }

    public void login(View view) {
        switch (view.getId()) {
            case R.id.btn_Go:
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                User user = realm.where(User.class).contains("name", txtEmail.getText().toString()).findFirst();
                realm.commitTransaction();


                if (user == null) {
                    Toast.makeText(this, "no user", Toast.LENGTH_LONG).show();
                    return;
                }
                if (txtPassword.getText().toString().equals(user.getPassword())) {
                    Intent intent = new Intent(getApplicationContext(), ToDoActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Password is wrong", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.txt_registration:
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
                break;
        }

    }
}

//        Realm.init(this);
//
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        User user = realm.createObject(User.class);
//        user.setName("Alex");
//        user.setPassword("alex");
//        realm.insert(user);
//        realm.commitTransaction();
//
//        RealmResults<User> users  = realm.where(User.class).findAll();
//
//        for (User elem : users){
//            System.out.println(elem);
//        }
