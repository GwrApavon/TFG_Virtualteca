package com.tfg.virtualteca.ui.book;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tfg.virtualteca.DBSettings.DataBaseBook;
import com.tfg.virtualteca.R;
import com.tfg.virtualteca.adapters.BookAdapter;
import com.tfg.virtualteca.add_element.Book_add;
import com.tfg.virtualteca.databinding.FragmentBooksBinding;
import com.tfg.virtualteca.elements.Book;

public class BookFragment extends Fragment {

    private FragmentBooksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BookViewModel bookViewModel =
                new ViewModelProvider(this).get(BookViewModel.class);

        binding = FragmentBooksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView bookList = root.findViewById(R.id.book_list);
        Button b_add = root.findViewById(R.id.b_add);
        DataBaseBook dbb = new DataBaseBook(getContext());

        BookAdapter bAdapter = new BookAdapter(getContext(), dbb.bookList());
        bookList.setAdapter(bAdapter);

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Book_add.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}