package com.pushkarnayouth.mytraindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class TrainRescheduleAdapter extends RecyclerView.Adapter<TrainRescheduleAdapter.TrainRescheduleViewHolder> {

    private Context context;
    private List<Train> RescheduleTrain;

    public TrainRescheduleAdapter(Context context, List<Train> rescheduleTrain) {
        this.context = context;
        RescheduleTrain = rescheduleTrain;
    }

    @Override
    public TrainRescheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_reschedule_item, parent, false);
        return new TrainRescheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainRescheduleViewHolder holder, int position) {
        Train train = RescheduleTrain.get(position);
        String Traincode = train.getNumber();
        holder.traincode.setText("Train Code : " + Traincode);
        String Trainname = train.getName();
        holder.trainname.setText("Train Name : " + Trainname);
        String Rescheduledate = train.getRescheduledDate();
        holder.rescheduledate.setText("Reschedule Date : " + Rescheduledate);
        String Rescheduletime = train.getRescheduledTime();
        holder.rescheduletime.setText("Reschedule Time : " + Rescheduletime);
        String Destinationstation = train.getToStation().getName();
        holder.destinationstation.setText("Destination Station : " + Destinationstation);
        String Sourcestation = train.getFromStation().getName();
        holder.sourcestation.setText("Source Station : " + Sourcestation);
        String Timedifference = train.getTimeDiff();
        holder.timedifference.setText("Time Difference : " + Timedifference);
    }

    @Override
    public int getItemCount() {
        return RescheduleTrain.size();
    }

    public class TrainRescheduleViewHolder extends RecyclerView.ViewHolder {

        TextView traincode, trainname, rescheduledate, rescheduletime, destinationstation, sourcestation, timedifference;

        public TrainRescheduleViewHolder(View itemView) {
            super(itemView);
            traincode = (TextView) itemView.findViewById(R.id.TrainCode);
            trainname = (TextView) itemView.findViewById(R.id.TrainName);
            rescheduledate = (TextView) itemView.findViewById(R.id.RescheduleDate);
            rescheduletime = (TextView) itemView.findViewById(R.id.RescheduleTime);
            destinationstation = (TextView) itemView.findViewById(R.id.DestinationStation);
            sourcestation = (TextView) itemView.findViewById(R.id.SourceStation);
            timedifference = (TextView) itemView.findViewById(R.id.TimeDifference);

        }
    }
}
