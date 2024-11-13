package com.example.healthcare.diagnose;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.healthcare.R;

import java.util.ArrayList;

public class DiagnoseAdaptater extends RecyclerView.Adapter<DiagnoseAdaptater.ViewHolder>{
    private ArrayList<DiagnoseModel> courseModalArrayList;
    private DiagnoseListner listener;
    private Context context;

    // creating a constructor for our variables.
    public DiagnoseAdaptater(ArrayList<DiagnoseModel> courseModalArrayList, Context context,DiagnoseListner listener) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diagnose_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DiagnoseModel modal = courseModalArrayList.get(position);
        holder.speech.setText(modal.getTime());
        holder.time.setText(modal.getResponse());
        SharedPreferences address= context.getSharedPreferences("address",context.MODE_PRIVATE);
        String address_=address.getString("addressi","");



        Glide.with(holder.itemView.getContext()) // Pass the context of the view
                .load(address_+"icon/" +modal.getSpeech())
                .into(holder.icon);


        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDiagnoseClicked(courseModalArrayList.get(position));
            }
        });
    }



    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView speech,  time;
        private ImageView icon;
        private CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            speech = itemView.findViewById(R.id.illness);
            icon=itemView.findViewById(R.id.icond);
           //esponse = itemView.findViewById(R.id.speciality);
            time = itemView.findViewById(R.id.response);
            cardview = itemView.findViewById(R.id.diagnoselistitem);

            //diagnose_id = itemView.findViewById(R.id.diagnose_id);
        }
    }
}
