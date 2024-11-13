package com.example.healthcare.pdf;

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

public class AdapterPdf extends RecyclerView.Adapter<AdapterPdf.ViewHolder>{
    private ArrayList<PdfModel> courseModalArrayList;
    private SelectPdfListener listener;
    private Context context;

    // creating a constructor for our variables.
    public AdapterPdf(ArrayList<PdfModel> courseModalArrayList, Context context,SelectPdfListener listener) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public AdapterPdf.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_item, parent, false);
        return new AdapterPdf.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPdf.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        PdfModel modal = courseModalArrayList.get(position);
        holder.speech.setText(modal.getSpeech());
        holder.time.setText(modal.getDiagnose_id());
        holder.response.setText(modal.getResponse());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPdfClicked(courseModalArrayList.get(position));
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
            speech = itemView.findViewById(R.id.name_pdf_doctor);
            response = itemView.findViewById(R.id.filename);
            time = itemView.findViewById(R.id.time_pdf);
            cardview = itemView.findViewById(R.id.pdf_item);
            //diagnose_id = itemView.findViewById(R.id.diagnose_id);
        }
    }
}
