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

import java.main.lutemonfighter.R;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeRecyclerViewAdapter recyclerViewAdapter;
    private Button trainButton;
    private Button fightButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.HomeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAdapter = new HomeRecyclerViewAdapter(getActivity(), LutemonStorage.getInstance().getListOfLutemons());
        recyclerView.setAdapter(recyclerViewAdapter);

        trainButton = view.findViewById(R.id.buttonMoveTrain);
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Lutemon> selectedLutemons = new ArrayList<>();               for (Lutemon lutemon : LutemonStorage.getInstance().getListOfLutemons()) {
                    if (lutemon.isSelected()) {
                        selectedLutemons.add(lutemon);
                    }
                }

                // Move the selected lutemons to the training view
                recyclerViewAdapter.moveToTraining(selectedLutemons);
            }
        });

        fightButton = view.findViewById(R.id.buttonMoveFight);
        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Lutemon> selectedLutemons = new ArrayList<>();
                for (Lutemon lutemon : LutemonStorage.getInstance().getListOfLutemons()) {
                    if (lutemon.isSelected()) {
                        selectedLutemons.add(lutemon);
                    }
                }

                // Move the selected lutemons to the fighting view
                recyclerViewAdapter.moveToFighting(selectedLutemons);
            }
        });

        return view;
    }
}



