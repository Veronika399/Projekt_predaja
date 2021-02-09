package com.example.newproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

public class DrugiFragment extends Fragment {

    public DrugiFragment() {
        // Required empty public constructor
    }



    private static final String BUNDLE_MESSAGE="message";

    public static DrugiFragment newInstance(String message) {
        DrugiFragment drugifragment= new DrugiFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE,message);
        drugifragment.setArguments(args);
        return drugifragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TableLayout table = view.findViewById(R.id.table);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drugi, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}