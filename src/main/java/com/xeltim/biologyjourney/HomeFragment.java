package com.xeltim.biologyjourney;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        String[] data = {" Lesson 1 - The Cell", " Lesson 2 - Chemistry of Cells", " Lesson 3 - Cell Type",
                " Lesson 4 - Cell Membrane", " Lesson 5 - Cell Wall", " Lesson 6 - Plasmolysis Lab",
                " Lesson 7 - Cell Cytoplasm", " Lesson 8 - Nucleus", " Lesson 9 - Cell Cycle",
                " Lesson 10 - Mitosis", " Lesson 11 - Mitosis", " Lesson 12 - SOON"};

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, data);

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(adapter);


        return rootView;
    }
}
