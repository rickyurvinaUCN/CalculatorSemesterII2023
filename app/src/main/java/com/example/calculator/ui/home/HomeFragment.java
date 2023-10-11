package com.example.calculator.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculator.databinding.FragmentHomeBinding;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private EditText txtNumber1, txtNumber2;
    private TextView txtResult;;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        txtNumber1 = binding.txtNum1;
        txtNumber2 = binding.txtNum2;
        txtResult = binding.txtResult;
        binding.btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum();
            }
        });

        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub();
            }
        });

        binding.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mul();
            }
        });

        binding.btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                div();
            }
        });

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

    private void sum() {
        int num1 = Integer.parseInt(txtNumber1.getText().toString());
        int num2 = Integer.parseInt(txtNumber2.getText().toString());
        int result = num1 + num2;
        txtResult.setText(String.valueOf(result));
    }

    public void sub() {
        int num1 = Integer.parseInt(txtNumber1.getText().toString());
        int num2 = Integer.parseInt(txtNumber2.getText().toString());
        int result = num1 - num2;
        txtResult.setText(String.valueOf(result));
    }

    public void mul() {
        int num1 = Integer.parseInt(txtNumber1.getText().toString());
        int num2 = Integer.parseInt(txtNumber2.getText().toString());
        int result = num1 * num2;
        txtResult.setText(String.valueOf(result));
    }

    public void div() {
        int num1 = Integer.parseInt(txtNumber1.getText().toString());
        int num2 = Integer.parseInt(txtNumber2.getText().toString());
        if (num2 != 0) {
            double sum = num1 / num2;
            String res = String.valueOf(sum);
            txtResult.setText(String.valueOf(res));
        } else {
            String message = "No es posible dividir para 0";
            Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}