package java.main.lutemonfighter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonListAdapterFragment extends Fragment {

    private RecyclerView recyclerView;
    private LutemonListAdapter lutemonListAdapter;

    public LutemonListAdapterFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.lutemonListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }

}

