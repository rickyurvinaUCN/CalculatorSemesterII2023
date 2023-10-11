package com.example.calculator.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculator.MainActivity2;
import com.example.calculator.R;
import com.example.calculator.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    private TextView txt_info;
    private ListView lv_peopleList1;

    private String names[] = {"Ingrid Medina", "Ricardo Urvina", "Liliana Cordova"};
    private String ages[] = {"26", "26", "55"};

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity2();
            }
        });

        txt_info = binding.txtInfo;
        lv_peopleList1 = binding.lvPeopleList1;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), R.layout.list_item, names);
        lv_peopleList1.setAdapter(adapter);

        lv_peopleList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt_info.setText("La edad de " + lv_peopleList1.getItemAtPosition(i) + " es:" + ages[i] + " años");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void toActivity2() {
        Intent next = new Intent(this.getContext(), MainActivity2.class);
        next.putExtra("info", txt_info.getText().toString());
        startActivity(next);
    }

}