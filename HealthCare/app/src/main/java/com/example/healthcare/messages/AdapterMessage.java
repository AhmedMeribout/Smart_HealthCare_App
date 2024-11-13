package com.example.healthcare.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare.R;

import java.util.ArrayList;

public class AdapterMessage extends RecyclerView.Adapter<AdapterMessage.ViewHolder> {
    private ArrayList<MesageModel> courseModalArrayList;
    private Context context;

    // creating a constructor for our variables.
    public AdapterMessage(ArrayList<MesageModel> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        MesageModel modal = courseModalArrayList.get(position);
        holder.doctorsname.setText(modal.getSpeech());
        holder.time.setText("Phone Number "+modal.getTime());
        holder.message.setText(modal.getResponse());
        holder.phone.setText("Time: "+modal.getDiagnose_id());
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView doctorsname, message, time,phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            doctorsname = itemView.findViewById(R.id.namedoctor);
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}
