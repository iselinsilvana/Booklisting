package com.example.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static public final String LOG_TAG  = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Book> books = QueryUtils.extractBooks();

        ListView bookListView = findViewById(R.id.list);

        BookAdapter adapter = new BookAdapter(this, books);
        bookListView.setAdapter(adapter);

    }
}
