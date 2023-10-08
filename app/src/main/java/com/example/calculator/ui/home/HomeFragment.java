package com.example.calculator.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculator.databinding.FragmentHomeBinding;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private EditText numberOne;
    private EditText numberTwo;
    private TextView txtResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        numberOne = binding.numberOne;
        numberTwo = binding.numberTwo;
        txtResult = binding.txtResult;

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSum.setOnClickListener(v -> {
            sum();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void sum() {
        int num1 = Integer.parseInt(numberOne.getText().toString());
        int num2 = Integer.parseInt(numberTwo.getText().toString());
        int result = num1 + num2;
        txtResult.setText(String.valueOf(result));
    }
}