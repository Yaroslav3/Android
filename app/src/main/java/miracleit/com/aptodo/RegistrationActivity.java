package miracleit.com.aptodo;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import model.User;

/**
 * Created by Ярик on 10.01.2018.
 */

public class RegistrationActivity extends AppCompatActivity {
    private Button btnRegistration;
    private EditText editTextLogin;
    private EditText editTextPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);
        btnRegistration = findViewById(R.id.btn_registration);
        editTextLogin = findViewById(R.id.txt_registration_loginAdd);
        editTextPassword = findViewById(R.id.txt_registration_passwordAdd);
        Realm.init(this);

    }
    public void registration(View view) {
        User user = new User();
        user.setName(editTextLogin.getText().toString());
        user.setPassword(editTextPassword.getText().toString());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insert(user);
        realm.commitTransaction();
        Toast.makeText(this, "registration", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
