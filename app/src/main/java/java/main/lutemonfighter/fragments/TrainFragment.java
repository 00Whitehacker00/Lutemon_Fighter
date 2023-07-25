package java.main.lutemonfighter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.main.lutemonfighter.Lutemon;
import java.main.lutemonfighter.LutemonStorage;
import java.main.lutemonfighter.FightTrainRecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.main.lutemonfighter.R;

import java.util.List;

public class TrainFragment extends Fragment {

    private RecyclerView recyclerView;
    private FightTrainRecyclerViewAdapter recyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);

        recyclerView = view.findViewById(R.id.RecyclerViewTrain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Use the same adapter for Train and Fight fragments
        List<Lutemon> trainingLutemons = LutemonStorage.getInstance().getTrainingLutemons();
        recyclerViewAdapter = new FightTrainRecyclerViewAdapter(getActivity(), trainingLutemons);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        List<Lutemon> trainingLutemons = LutemonStorage.getInstance().getTrainingLutemons();
        recyclerViewAdapter = new FightTrainRecyclerViewAdapter(getActivity(), trainingLutemons);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
