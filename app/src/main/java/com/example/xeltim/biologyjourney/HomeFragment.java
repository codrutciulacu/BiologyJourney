package com.example.xeltim.biologyjourney;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
/*
"Lesson 1 - The Cell", " Lesson 2 - Chemistry of Cells", " Lesson 3 - Cell Type",
        " Lesson 4 - Cell Membrane", " Lesson 5 - Cell Wall", " Lesson 6 - Plasmolysis Lab",
        " Lesson 7 - Cell Cytoplasm", " Lesson 8 - Nucleus", " Lesson 9 - Cell Cycle",
        " Lesson 10 - Mitosis", " Lesson 11 - Meiosis", " Lesson 12 - SOON"

*/

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFragment extends Fragment {
    String[] s = {"http://samsung-wallpapers.com/uploads/allimg/130605/1-130605021247.jpg", "https://i.imgur.com/tGbaZCY.jpg"};

    Content[] content = {new Content(new String[]{"https://i.imgur.com/zADUO7e.png", "https://i.imgur.com/EGtXTwE.png"}, " Lesson 1 - The Cell"), new Content(s, " Lesson 2 - Chemistry of Cells"),
            new Content(s, " Lesson 3 - Cell Type"), new Content(s, " Lesson 4 - Cell Membrane"),
            new Content(s, " Lesson 5 - Cell Wall"), new Content(s, " Lesson 6 - Plasmolysis Lab"),
            new Content(s, " Lesson 7 - Cell Cytoplasm"), new Content(s, " Lesson 8 - Nucleus"),
            new Content(s, "  Lesson 9 - Cell Cycle"), new Content(s, " Lesson 10 - Mitosis"),
            new Content(s, " Lesson 11 - Meiosis"), new Content(s, " Lesson 12 - SOON")};

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        LessonsAdapter adapter = new LessonsAdapter(getActivity(), content);

        ListView listView = (ListView)root.findViewById(R.id.listview_forecast);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Item(i);
            }
        });

        return root;
    }

    protected void Item(int i){
        Intent intent = new Intent(getActivity(), Lesson.class);
        intent.putExtra("text", content[i].getTitle());
        intent.putExtra("url", content[i].getURL());
        startActivity(intent);
    }

}
