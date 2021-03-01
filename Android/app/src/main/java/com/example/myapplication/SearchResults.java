package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.models.CardSet;

import java.util.List;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
    }
   /* public static class CardSetRecyclerViewAdapter extends RecyclerView.Adapter<CardSetRecyclerViewAdapter.SetViewHolder> {
        private Activity mParentActivity;
        private List<CardSet> mItems;
        CardSetRecyclerViewAdapter(Activity activity, List<CardSet> items) {
            mParentActivity = activity;
            mItems = items;
        }
        @NonNull
        @Override
        public ContinuePractice.CardSetRecyclerViewAdapter.SetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.set_view, parent, false);
            return new ContinuePractice.CardSetRecyclerViewAdapter.SetViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ContinuePractice.CardSetRecyclerViewAdapter.SetViewHolder holder, int position) {
            CardSet currentItem = mItems.get(position);
            holder.mButton.setText(currentItem.mName);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
        class SetViewHolder extends RecyclerView.ViewHolder {
            final Button mButton;
            SetViewHolder(View view) {
                super(view);
                mButton = (Button) view.findViewById(R.id.card_set);
            }
        }
    }*/
}