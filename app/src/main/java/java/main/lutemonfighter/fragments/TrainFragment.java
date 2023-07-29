package java.main.lutemonfighter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.main.lutemonfighter.Lutemon;
import java.main.lutemonfighter.LutemonStorage;
import java.main.lutemonfighter.TrainRecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.main.lutemonfighter.R;
import java.util.ArrayList;

public class TrainFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>();
    private ArrayList<String> lutemonsToTrain = new ArrayList<>();

    public TrainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTrain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TrainRecyclerViewAdapter adapter = new TrainRecyclerViewAdapter(getActivity(), LutemonStorage.getInstance().getListOfLutemons());
        recyclerView.setAdapter(adapter);

        Button trainButton = view.findViewById(R.id.buttonTrain);
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Lutemon lutemon : selectedLutemons) {
                    lutemonsToTrain.add(lutemon.getName());
                }
            }
        });

        return view;
    }

    public ArrayList<String> getLutemonsToTrain() {
        return lutemonsToTrain;
    }

    public void addSelectedLutemon(Lutemon lutemon) {
        selectedLutemons.add(lutemon);
    }

    public void removeSelectedLutemon(Lutemon lutemon) {
        selectedLutemons.remove(lutemon);
    }
}
