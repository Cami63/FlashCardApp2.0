package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;

import android.util.Log;

import android.view.ViewGroup;
import android.widget.Button;

import android.content.Intent;

import android.app.Activity;

import com.example.myapplication.api.APIConnector;
import com.example.myapplication.models.CardSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContinuePractice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<CardSet> sets = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_practice);
        RecyclerView firstRecycler = findViewById(R.id.previous_card_sets_recycler);
        CardSetRecyclerViewAdapter adapter1 = new CardSetRecyclerViewAdapter(this, sets);
        firstRecycler.setAdapter(adapter1);

        APIConnector.getSets(this.getBaseContext(), response -> {
            try {
                JSONObject jsonData = new JSONObject(response);
                JSONArray jsonSets = jsonData.getJSONArray("sets");
                for (int i = 0; i < jsonSets.length(); ++i) {
                    JSONArray jsonSet = jsonSets.getJSONArray(i);
                    sets.add(new CardSet(jsonSet.getInt(0), jsonSet.getString(1)));
                }
                adapter1.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static class CardSetRecyclerViewAdapter extends RecyclerView.Adapter<CardSetRecyclerViewAdapter.SetViewHolder> {
        private Activity mParentActivity;
        private List<CardSet> mItems;
        CardSetRecyclerViewAdapter(Activity activity, List<CardSet> items) {
            mParentActivity = activity;
            mItems = items;
        }

        @Override
        public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.set_view, parent, false);
            return new SetViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final SetViewHolder holder, int position) {
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
    }

}