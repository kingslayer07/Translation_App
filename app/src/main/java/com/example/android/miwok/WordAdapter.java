package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mImageResourceId;
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    public WordAdapter(Activity context, ArrayList<Word> words,int ResourceId) {




        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0,words);
        mImageResourceId=ResourceId;
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok);
        nameTextView.setText(currentWord.getMiwokTranslation());
        TextView nameeTextView = (TextView) listItemView.findViewById(R.id.eng);
        nameeTextView.setText(currentWord.getDefaultTranslation());
        ImageView image =(ImageView) listItemView.findViewById(R.id.imageView);
        image.setImageResource(currentWord.getImageResourceId());
        View textContainer=(View) listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mImageResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
