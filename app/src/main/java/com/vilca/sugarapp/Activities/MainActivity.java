package com.vilca.sugarapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.orm.SugarRecord;
import com.vilca.sugarapp.Adapter.UserAdapter;
import com.vilca.sugarapp.Model.User;
import com.vilca.sugarapp.R;
import com.vilca.sugarapp.Repository.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersList = (RecyclerView) findViewById(R.id.user_list);
        usersList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to ReciclerView
        List<User> users = UserRepository.list();
        usersList.setAdapter(new UserAdapter(users));
    }
    public void callRegister(View view){
        startActivityForResult(new Intent(this,RegisterActivity.class),REGISTER_FORM_REQUEST);
        finish();
    }

}
