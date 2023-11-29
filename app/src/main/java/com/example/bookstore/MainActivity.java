package com.example.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bookstore.databinding.ActivityMainBinding;
import com.example.bookstore.ui.gbs.BookStoreActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Button btnNavToBookStore = binding.btnNavToBookStore;
        btnNavToBookStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "BookStore Button Clicked");
                Toast.makeText(getApplicationContext(), "BookStore button Clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), BookStoreActivity.class);
                //pass parameter
                intent.putExtra("dispatchFrom", "MainActivity_to_CourseActivity");
                v.getContext().startActivity(intent);
            }
        });
    }
}
