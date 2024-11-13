package com.example.healthcare.recent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare.R;

import java.util.ArrayList;

public class AdapterRecent extends RecyclerView.Adapter<AdapterRecent.ViewHolder> {

    // creating a variable for array list and context.
    private ArrayList<RecentModel> courseModalArrayList;
    private Context context;

    // creating a constructor for our variables.
    public AdapterRecent(ArrayList<RecentModel> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        RecentModel modal = courseModalArrayList.get(position);
        holder.speech.setText(modal.getSpeech());
        holder.time.setText("ID: "+modal.getTime());
        //holder.response.setText(modal.getResponse());
        holder.diagnose_id.setText("Time: "+modal.getDiagnose_id());
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView speech, response, time,diagnose_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            speech = itemView.findViewById(R.id.speech);
            response = itemView.findViewById(R.id.response);
            time = itemView.findViewById(R.id.time_diagnose);
            diagnose_id = itemView.findViewById(R.id.diagnose_id);
        }
    }
}