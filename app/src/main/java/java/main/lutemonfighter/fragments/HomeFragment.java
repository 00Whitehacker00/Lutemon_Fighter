package java.main.lutemonfighter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.main.lutemonfighter.Lutemon;
import java.main.lutemonfighter.LutemonStorage;
import java.main.lutemonfighter.HomeRecyclerViewAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.main.lutemonfighter.R;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>();

    private RecyclerView recyclerView;
    ArrayList<String> lutemonsToTrain = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.HomeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        HomeRecyclerViewAdapter adapter = new HomeRecyclerViewAdapter(getActivity(), LutemonStorage.getInstance().getListOfLutemons());
        recyclerView.setAdapter(adapter);

        Button trainButton = view.findViewById(R.id.buttonMoveTrain);
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the selected lutemons from the adapter
                selectedLutemons = adapter.getSelectedLutemons();

                if (selectedLutemons.size() > 0) {
                    // add the selected lutemons to the list of lutemons to train
                    for (Lutemon lutemon : selectedLutemons) {
                        lutemonsToTrain.add(lutemon.getName());
                    }

                    // TODO: start training activity with the lutemonsToTrain list
                } else {
                    Toast.makeText(getActivity(), "Please select at least one lutemon to train", Toast.LENGTH_SHORT).show();
                }
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