package com.example.xeltim.biologyjourney;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by CiulacuCodrut on 11/26/2017.
 */

public class LessonsAdapter extends ArrayAdapter<Content> {

    public LessonsAdapter(Context context, Content[] lessons){
        super(context, 0, lessons);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Content content = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);

        TextView text = (TextView)convertView.findViewById(R.id.list);
        text.setText(content.getTitle());

        return convertView;
    }
}
