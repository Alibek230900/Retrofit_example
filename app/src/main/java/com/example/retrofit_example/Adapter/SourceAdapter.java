package com.example.retrofit_example.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_example.Activities.ListStackActivity;
import com.example.retrofit_example.Models.Source;
import com.example.retrofit_example.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.SourceViewHolder> {

    Context context;
    List<Source> sourceList;

    public SourceAdapter(Context context, List<Source> sourceList){

        this.context=context;
        this.sourceList=sourceList;
    }
    @NonNull
    @Override
    public SourceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.item_source,viewGroup,false);
        return new SourceViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SourceViewHolder sourceViewHolder, int i) {
        sourceViewHolder.textViewName.setText(sourceList.get(i).getName());
    }

    @Override
    public int getItemCount() {

        return sourceList.size();
    }

    public class SourceViewHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.source_image) CircleImageView circleImageView;
        @BindView(R.id.source_name) TextView textViewName;



        public SourceViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this,itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Source sourceItem=sourceList.get(getAdapterPosition());

                    Intent intent=new Intent(context, ListStackActivity.class);
                    intent.putExtra("sourceid",sourceItem.getId());
                    intent.putExtra(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity();
                }
            });
        }
    }
}
