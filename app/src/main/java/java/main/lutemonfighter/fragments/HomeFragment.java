package java.main.lutemonfighter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.main.lutemonfighter.LutemonStorage;
import java.main.lutemonfighter.RecyclerViewAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.main.lutemonfighter.R;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.HomeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), LutemonStorage.getInstance().getListOfLutemons());
        recyclerView.setAdapter(adapter);

        Button trainButton = view.findViewById(R.id.buttonMoveTrain);
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button fightButton = view.findViewById(R.id.buttonMoveFight);
        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
}
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}

 */