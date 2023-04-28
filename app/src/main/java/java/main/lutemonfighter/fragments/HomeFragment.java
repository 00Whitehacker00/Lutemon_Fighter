package java.main.lutemonfighter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.main.lutemonfighter.LutemonListAdapter;
import java.main.lutemonfighter.LutemonStorage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.main.lutemonfighter.R;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private LutemonListAdapter lutemonListAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.lutemonListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        lutemonListAdapter = new LutemonListAdapter(getActivity(), LutemonStorage.getInstance().getListOfLutemons());
        recyclerView.setAdapter(lutemonListAdapter);

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