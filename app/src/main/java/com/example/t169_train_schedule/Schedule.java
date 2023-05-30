package com.example.t169_train_schedule;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.t169_train_schedule.databinding.FragmentScheduleBinding;
import com.example.t169_train_schedule.databinding.FragmentSecondBinding;


public class Schedule extends Fragment  {
    private FragmentScheduleBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button but1 = view.findViewById(R.id.show_schedule);
        Spinner spinner1 =(Spinner)view.findViewById(R.id.source);
        Spinner spinner2 =(Spinner) view.findViewById(R.id.destination);

        binding.showSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Schedule.this)
                        .navigate(R.id.action_schedule_to_mainSchedule);
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.Stations,R.layout.dropdown);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
      //  spinner1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),R.array.Destinations,R.layout.dropdown);
        adapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        //spinner2.setOnItemSelectedListener(this);
    }

    }