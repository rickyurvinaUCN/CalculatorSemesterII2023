package com.example.calculator.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculator.R;
import com.example.calculator.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private EditText txt_num3, txt_num4;
    private TextView txt_res2;
    private Spinner sp_operations;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        txt_num3 = binding.txtNum3;
        txt_num4 = binding.txtNum4;
        txt_res2 = binding.txtRes2;
        sp_operations = binding.spOperations;

        String[] operations =
                {
                        "Sumar",
                        "Restar",
                        "Multiplicar",
                        "Dividir",
                };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_item, operations);
        sp_operations.setAdapter(adapter);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnCalc2.setOnClickListener((View v) -> {
            String selected = sp_operations.getSelectedItem().toString();
            switch (selected) {
                case "Sumar": {
                    sum();
                    break;
                }
                case "Restar": {
                    sub();
                    break;
                }
                case "Multiplicar": {
                    mul();
                    break;
                }
                case "Dividir": {
                    div();
                    break;
                }
            }
        });
    }

    public void sum() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        double sum = val1 + val2;
        String res = String.valueOf(sum);
        txt_res2.setText(res);
    }

    public void sub() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        double sub = val1 - val2;
        String res = String.valueOf(sub);
        txt_res2.setText(res);
    }

    public void mul() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        double mul = val1 * val2;
        String res = String.valueOf(mul);
        txt_res2.setText(res);
    }

    public void div() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        if (val2 != 0) {
            double sum = val1 / val2;
            String res = String.valueOf(sum);
            txt_res2.setText(res);

        } else {
            String message = "No es posible dividir para 0";
            Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}