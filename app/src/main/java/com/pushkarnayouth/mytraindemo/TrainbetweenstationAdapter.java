package com.pushkarnayouth.mytraindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ashwin on 1/4/2018.
 */

class TrainbetweenstationAdapter extends RecyclerView.Adapter<TrainbetweenstationAdapter.TrainbetweenstationViewHolder> {

    private Context context;
    private List<Train> trainbetweenstations;

    public TrainbetweenstationAdapter(Context context, List<Train> trainbetweenstations) {
        this.context = context;
        this.trainbetweenstations = trainbetweenstations;
    }

    @Override
    public TrainbetweenstationAdapter.TrainbetweenstationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_trainbetweenstation_item, parent, false);
        return new TrainbetweenstationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainbetweenstationAdapter.TrainbetweenstationViewHolder holder, int position) {
        Train train = trainbetweenstations.get(position);
        String trainname = train.getName();
        holder.trainname.setText("Train Name: " + trainname);
        String srcname = train.getFromStation().getName();
        holder.srcname.setText("Source: " + srcname);
        String destname = train.getToStation().getName();
        holder.destname.setText("Destination: " + destname);
        String srcdepttime = train.getSrcDepartureTime();
        holder.srcdepttime.setText("Source Departure Time: " + srcdepttime);
        String destarvtime = train.getDestArrivalTime();
        holder.destarvtime.setText("Destination Arival Time: " + destarvtime);
        String monday = train.getDays().get(0).getRuns();
        holder.mon.setText(monday);
        String tuesday = train.getDays().get(1).getRuns();
        holder.tue.setText(tuesday);
        String wednesday = train.getDays().get(2).getRuns();
        holder.wed.setText(wednesday);
        String thursday = train.getDays().get(3).getRuns();
        holder.thu.setText(thursday);
        String friday = train.getDays().get(4).getRuns();
        holder.fri.setText(friday);
        String saturday = train.getDays().get(5).getRuns();
        holder.sat.setText(saturday);
        String sunday = train.getDays().get(6).getRuns();
        holder.sun.setText(sunday);
    }

    @Override
    public int getItemCount() {
        return trainbetweenstations.size();
    }

    public class TrainbetweenstationViewHolder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView trainname, srcname, destname, srcdepttime, destarvtime, mon, tue, wed, thu, fri, sat, sun;
        TextView monday, tuesday, wednesday, thursday, friday, saturday, sunday;

        public TrainbetweenstationViewHolder(View itemView) {
            super(itemView);
            imgview = (ImageView) itemView.findViewById(R.id.imageView);
            trainname = (TextView) itemView.findViewById(R.id.trainname);
            srcname = (TextView) itemView.findViewById(R.id.Srcname);
            destname = (TextView) itemView.findViewById(R.id.Destname);
            srcdepttime = (TextView) itemView.findViewById(R.id.Src_depttime);
            destarvtime = (TextView) itemView.findViewById(R.id.Dest_arivaltime);
            mon = (TextView) itemView.findViewById(R.id.m);
            tue = (TextView) itemView.findViewById(R.id.t);
            wed = (TextView) itemView.findViewById(R.id.w);
            thu = (TextView) itemView.findViewById(R.id.th);
            fri = (TextView) itemView.findViewById(R.id.f);
            sat = (TextView) itemView.findViewById(R.id.sa);
            sun = (TextView) itemView.findViewById(R.id.su);
            monday = (TextView) itemView.findViewById(R.id.Monday);
            tuesday = (TextView) itemView.findViewById(R.id.Tuesday);
            wednesday = (TextView) itemView.findViewById(R.id.Wednesday);
            thursday = (TextView) itemView.findViewById(R.id.Thursday);
            friday = (TextView) itemView.findViewById(R.id.Friday);
            saturday = (TextView) itemView.findViewById(R.id.Saturday);
            sunday = (TextView) itemView.findViewById(R.id.Sunday);


        }
    }
}
