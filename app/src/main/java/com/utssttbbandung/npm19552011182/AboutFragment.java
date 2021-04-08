package com.utssttbbandung.npm19552011182;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((com.utssttbbandung.npm19552011182.MainActivity) getActivity()).setActionBarTitle("Tentang Saya");
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        return view;
    }
}