package com.example.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list, parent, false);
        }

        Book currentBook = getItem(position);

        TextView authorView = listItemView.findViewById(R.id.book_author);
        String currentAuthor = currentBook.getBookAuthors();
        authorView.setText( currentAuthor);

        TextView titleView = listItemView.findViewById(R.id.book_title);
        String currentTitle = currentBook.getBookTitle();
        titleView.setText(currentTitle);

        return listItemView;
    }
}
