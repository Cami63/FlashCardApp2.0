package com.example.flashcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.flashcard.models.FlashcardSetContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class RootScreenFragment extends Fragment implements View.OnClickListener {
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RootScreenFragment() {
    }

    private Button mButtonContinue;
    private Button mButtonSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.root_screen, container, false);

        mButtonContinue = ((Button) rootView.findViewById(R.id.root_screen_button_continue));
        mButtonSearch = ((Button) rootView.findViewById(R.id.root_screen_button_search));
        
        mButtonContinue.setText(R.string.app_continue_label);
        mButtonSearch.setText(R.string.app_search_label);

        mButtonContinue.setOnClickListener(this);
        mButtonSearch.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.root_screen_button_continue: {
                Context context = v.getContext();
                Intent intent = new Intent(context, ItemListActivity.class);
                context.startActivity(intent);
                break;
            }
    
            case R.id.root_screen_button_search: {
                // do something for button 2 click
                break;
            }
        }
    }
}