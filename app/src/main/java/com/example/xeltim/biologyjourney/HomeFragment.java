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


    Content[] content = {new Content(new String[]{"https://i.imgur.com/tGbaZCY.jpg", "http://www.biology-questions-and-answers.com/images/Cell-Biology.jpg"}, " Lesson 1 - The Cell"), new Content(new String[]{"https://i.imgur.com/tGbaZCY.jpg"}, " Lesson 2 - Chemistry of Cells"),
            new Content(new String[]{"https://i.imgur.com/tGbaZCY.jpg"}, " Lesson 3 - Cell Type"), new Content(new String[]{"https://i.imgur.com/tGbaZCY.jpg"}, " Lesson 4 - Cell Membrane"),
            new Content(new String[]{"http://www.biology-questions-and-answers.com/images/Cell-Biology.jpg"}, " Lesson 5 - Cell Wall"), new Content(new String[]{""}, " Lesson 6 - Plasmolysis Lab"),
            new Content(new String[]{""}, " Lesson 7 - Cell Cytoplasm"), new Content(new String[]{""}, " Lesson 8 - Nucleus"),
            new Content(new String[]{""}, "  Lesson 9 - Cell Cycle"), new Content(new String[]{""}, " Lesson 10 - Mitosis"),
            new Content(new String[]{""}, " Lesson 11 - Meiosis"), new Content(new String[]{""}, " Lesson 12 - SOON")};

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
