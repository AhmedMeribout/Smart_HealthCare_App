package com.example.healthcare.doctors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare.R;

import java.util.ArrayList;

public class AdapterDoctor extends RecyclerView.Adapter<AdapterDoctor.ViewHolder> {
    private ArrayList<DoctorModel> courseModalArrayList;
    private SelectDoctorListener listener;
    private Context context;

    // creating a constructor for our variables.
    public AdapterDoctor(ArrayList<DoctorModel> courseModalArrayList, Context context,SelectDoctorListener listener) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public AdapterDoctor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item, parent, false);
        return new AdapterDoctor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDoctor.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        DoctorModel modal = courseModalArrayList.get(position);
        holder.speech.setText(modal.getTime());
        holder.time.setText(modal.getDiagnose_id());
        holder.response.setText(modal.getResponse());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDoctorClicked(courseModalArrayList.get(position));
            }
        });
        //holder.diagnose_id.setText("Time: "+modal.getDiagnose_id());
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView speech, response, time,diagnose_id;
        private CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            speech = itemView.findViewById(R.id.name);
            response = itemView.findViewById(R.id.speciality);
            time = itemView.findViewById(R.id.phone);
            cardview = itemView.findViewById(R.id.doctor_item);
            //diagnose_id = itemView.findViewById(R.id.diagnose_id);
        }
    }
}
