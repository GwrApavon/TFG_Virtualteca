package com.tfg.virtualteca.ui.loan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tfg.virtualteca.DBSettings.DataBaseBook;
import com.tfg.virtualteca.adapters.BookAdapter;
import com.tfg.virtualteca.add_element.Book_add;
import com.tfg.virtualteca.databinding.FragmentLoansBinding;

public class LoanFragment extends Fragment {

    private FragmentLoansBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoanViewModel loanViewModel =
                new ViewModelProvider(this).get(LoanViewModel.class);

        binding = FragmentLoansBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView bookList = binding.loanList;
        final Button b_add = binding.bAdd3;
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