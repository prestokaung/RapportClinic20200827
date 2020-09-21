package com.example.rapportclinic20200827.Adaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rapportclinic20200827.ProfileActivity;
import com.example.rapportclinic20200827.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> idlist, nameList, ageList, genderList, dateList;


    public CustomAdapter(Context context, ArrayList<String> idlist, ArrayList<String> nameList, ArrayList<String> ageList, ArrayList<String> genderList, ArrayList<String> dateList) {
        this.context = context;
        this.idlist = idlist;
        this.nameList = nameList;
        this.ageList = ageList;
        this.genderList = genderList;
        this.dateList = dateList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.all_patient_layout,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.name.setText(String.valueOf(nameList.get(position)));
        holder.date.setText(String.valueOf(dateList.get(position)));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("name",nameList.get(position));
                intent.putExtra("age",ageList.get(position));
                intent.putExtra("gender",genderList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name , date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.all_patient_name);
            date = itemView.findViewById(R.id.all_patient_date);
        }
    }


}
