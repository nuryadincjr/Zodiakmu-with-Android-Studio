package com.utssttbbandung.npm19552011182;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewZodiak;
    private com.utssttbbandung.npm19552011182.RecyclerAdapterZodiak recyclerAdapterZodiak;
    private ArrayList<com.utssttbbandung.npm19552011182.Zodiak> zodiakArrayList;
    private String zodiak, brith,  detail, image;
    com.utssttbbandung.npm19552011182.Zodiak zo = new com.utssttbbandung.npm19552011182.Zodiak("","","","");

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewZodiak = view.findViewById(R.id.RVZodiak);
        ((com.utssttbbandung.npm19552011182.MainActivity) getActivity()).setActionBarTitle("Zodiakmu");
        getZodiak();
        recyclerAdapterZodiak = new com.utssttbbandung.npm19552011182.RecyclerAdapterZodiak(getContext(), zodiakArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewZodiak.setLayoutManager(layoutManager);
        recyclerViewZodiak.setAdapter(recyclerAdapterZodiak);

        recyclerAdapterZodiak.setItemClickListener((view1, position) -> {
            zodiak = zodiakArrayList.get(position).getZodiak();
            brith = zodiakArrayList.get(position).getBrith();
            detail = zodiakArrayList.get(position).getDetail();
            image = zodiakArrayList.get(position).getImage();

            zo.setZodiak(zodiak);
            zo.setBrith(brith);
            zo.setDetail(detail);
            zo.setImage(image);

            Intent intent = new Intent(getActivity(), com.utssttbbandung.npm19552011182.DetailActivity.class);
            intent.putExtra("ZODIAK", zo);
            startActivity(intent);
        });
        return view;
    }

    private void getZodiak() {
        if(zodiakArrayList==null) {
            Resources resources = getResources();
            String[] zodiskName = resources.getStringArray(R.array.zodiak_name);
            String[] zodiskBrith = resources.getStringArray(R.array.zodiak_birth);
            String[] zodiakDetail = resources.getStringArray(R.array.zodiak_detail);
            TypedArray zodiskImg = resources.obtainTypedArray(R.array.zodiak_image);

            zodiakArrayList = new ArrayList<com.utssttbbandung.npm19552011182.Zodiak>();
            for(int i=0; i<zodiskName.length; i++) {
                zodiakArrayList.add(new com.utssttbbandung.npm19552011182.Zodiak(zodiskName[i], zodiskBrith[i], zodiakDetail[i], String.valueOf(zodiskImg.getResourceId(i, -1))));
            }
        }
    }
}