package com.tfg.virtualteca.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tfg.virtualteca.R;
import com.tfg.virtualteca.elements.Book;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    Context context;
    ArrayList<Book> books = new ArrayList<>();

    public BookAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // Comprobar cuales sobran
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater shown = LayoutInflater.from(context);
        View element = shown.inflate(R.layout.book, viewGroup, false);

        TextView title = element.findViewById(R.id.title);
        title.setText(books.get(i).getTitle());

        TextView author = element.findViewById(R.id.author);
        author.setText(books.get(i).getAuthor());

        TextView genre = element.findViewById(R.id.genre);
        genre.setText(books.get(i).getGenre());

        TextView editorial = element.findViewById(R.id.editorial);
        editorial.setText(books.get(i).getEditorial());

        TextView pbl_date = element.findViewById(R.id.pbl_date);
        pbl_date.setText(books.get(i).getPbl_date());

        TextView synopsis = element.findViewById(R.id.synopsis);
        synopsis.setText(books.get(i).getSynopsis());

        return element;
    }



}
