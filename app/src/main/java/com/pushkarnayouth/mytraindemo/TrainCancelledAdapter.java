package com.pushkarnayouth.mytraindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Deepak on 1/3/2018.
 */

class TrainCancelledAdapter extends RecyclerView.Adapter<TrainCancelledAdapter.TrainCancelledViewHolder> {

    private Context context;
    private List<Train> CancelledItems;

    public TrainCancelledAdapter(Context context, List<Train> cancelledItems) {
        this.context = context;
        CancelledItems = cancelledItems;
    }

    @Override
    public TrainCancelledViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_cancelled_item, parent, false);
        return new TrainCancelledViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainCancelledViewHolder holder, int position) {

        Train train = CancelledItems.get(position);
        String TrainCode = train.getNumber();
        holder.traincode.setText("Train Code : " + TrainCode);
        String TrainName = train.getName();
        holder.trainname.setText("Train Name : " + TrainName);
        String StartTime = train.getStartTime();
        holder.starttime.setText("Start Time : " + StartTime);
        String DestinationStation = train.getDest().getName();
        holder.destinationstation.setText("Destination Station : " + DestinationStation);
        String SourceStation = train.getSource().getName();
        holder.sourcestation.setText("Source Station : " + SourceStation);

    }

    @Override
    public int getItemCount() {
        return CancelledItems.size();
    }

    public class TrainCancelledViewHolder extends RecyclerView.ViewHolder {

        TextView traincode, trainname, starttime, destinationstation, sourcestation;

        public TrainCancelledViewHolder(View itemView) {
            super(itemView);
            traincode = (TextView) itemView.findViewById(R.id.traincode);
            trainname = (TextView) itemView.findViewById(R.id.trainname);
            starttime = (TextView) itemView.findViewById(R.id.starttime);
            destinationstation = (TextView) itemView.findViewById(R.id.destinationstation);
            sourcestation = (TextView) itemView.findViewById(R.id.sourcestation);

        }
    }
}
