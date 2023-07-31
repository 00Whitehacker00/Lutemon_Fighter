package java.main.lutemonfighter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.main.lutemonfighter.Lutemon;
import java.main.lutemonfighter.LutemonStorage;
import java.main.lutemonfighter.FightTrainRecyclerViewAdapter;
import java.main.lutemonfighter.R;

import java.util.List;

public class TrainFragment extends Fragment {

    private RecyclerView recyclerView;
    private FightTrainRecyclerViewAdapter recyclerViewAdapter;
    private Button trainButton;
    private Button moveToFightButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);

        recyclerView = view.findViewById(R.id.RecyclerViewTrain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Lutemon> trainingLutemons = LutemonStorage.getInstance().getTrainingLutemons();
        recyclerViewAdapter = new FightTrainRecyclerViewAdapter(getActivity(), trainingLutemons);
        recyclerView.setAdapter(recyclerViewAdapter);

        trainButton = view.findViewById(R.id.buttonTrain);
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainLutemons();
            }
        });

        moveToFightButton = view.findViewById(R.id.buttonMoveToFightFromTrain);
        moveToFightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFightFragment();
            }
        });

        return view;
    }

    private void trainLutemons() {
        List<Lutemon> trainingLutemons = recyclerViewAdapter.getSelectedLutemons();
        for (Lutemon lutemon : trainingLutemons) {
            int experienceGained = 2; // You can adjust the experience gained as needed
            lutemon.setExperience(lutemon.getExperience() + experienceGained);

            // Increase attack based on experience
            int attackGained = lutemon.getExperience() / 2; // For example, gain 1 attack for every 2 experience points
            lutemon.setAttack(lutemon.getAttack() + attackGained);
        }

        recyclerViewAdapter.notifyDataSetChanged();
    }

    private void moveToFightFragment() {
        List<Lutemon> selectedLutemons = recyclerViewAdapter.getSelectedLutemons();
        for (Lutemon lutemon : selectedLutemons) {
            lutemon.setIsInTraining(false);
            LutemonStorage.getInstance().addFightingLutemon(lutemon);
        }
        LutemonStorage.getInstance().getTrainingLutemons().removeAll(selectedLutemons);

        // Add the surviving lutemons back to the list and the home view
        LutemonStorage.getInstance().getListOfLutemons().addAll(selectedLutemons);

        recyclerViewAdapter.notifyDataSetChanged();
    }
}
