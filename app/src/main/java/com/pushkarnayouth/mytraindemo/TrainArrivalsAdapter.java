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
 * Created by Deepak on 12/27/2017.
 */
public class TrainArrivalsAdapter extends RecyclerView.Adapter<TrainArrivalsAdapter.TrainArrivalsViewHolder> {

    private Context context;
    private List<Train> TrainItems;
    private TrainArrivals tArrivals;
    private String stationCode;

    public TrainArrivalsAdapter(Context context, TrainArrivals tArrivals, String stationCode) {
        this.context = context;
        this.tArrivals = tArrivals;
        this.stationCode = stationCode;
    }

    @Override
    public TrainArrivalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_arrivals_item, parent, false);
        return new TrainArrivalsViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(TrainArrivalsViewHolder holder, int position) {


                /*"name": "CDG-YPR BI WEEKLY EXPRESS",
                "actdep": "03:25",
                "scharr": "Source",
                "number": "22686",
                "delayarr": "RIGHT TIME",
                "actarr": "Source",
                "delaydep": "RIGHT TIME",
                "schdep": "03:25"*/


        //holder.stationCode.setText(stationCode);

        //holder.txtStation.setText(stationName);

        // Train train = TrainItems.get(position);
        List<Train> trains = tArrivals.getTrains();
        String trainName = trains.get(position).getName();
        holder.txtTrainName.setText(trainName);
        String actdep = trains.get(position).getActdep();
        holder.txtActdep.setText(actdep);
        String scharr = trains.get(position).getScharr();
        holder.txtScharr.setText(scharr);
        String trainNumber = trains.get(position).getNumber();
        holder.txtTrainNumber.setText(trainNumber);
        String delayarr = trains.get(position).getDelayarr();
        holder.txtDelayarr.setText(delayarr);
        String actarr = trains.get(position).getActarr();
        holder.txtActarr.setText(actarr);
        String delaydep = trains.get(position).getDelaydep();
        holder.txtDelaydep.setText(delaydep);
        String schdep = trains.get(position).getSchdep();
        holder.txtSchdep.setText(schdep);


    }

    @Override
    public int getItemCount() {
        return tArrivals.getTrains().size();
        // return TrainItems.size();
        //return 0;
    }


    public class TrainArrivalsViewHolder extends RecyclerView.ViewHolder {
        TextView txtStation;
        ImageView imgIcon;
        TextView stationCode;
        TextView txtTrainName;
        TextView txtActdep;
        TextView txtScharr;
        TextView txtTrainNumber;
        TextView txtDelayarr;
        TextView txtActarr;
        TextView txtDelaydep;
        TextView txtSchdep;

        public TrainArrivalsViewHolder(View itemView) {
            super(itemView);
            txtStation = (TextView) itemView.findViewById(R.id.txtStation);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            stationCode = (TextView) itemView.findViewById(R.id.stationCode);


            txtTrainName = (TextView) itemView.findViewById(R.id.txtTrainName);
            txtActdep = (TextView) itemView.findViewById(R.id.txtActdep);
            txtScharr = (TextView) itemView.findViewById(R.id.txtScharr);
            txtTrainNumber = (TextView) itemView.findViewById(R.id.txtTrainNumber);
            txtDelayarr = (TextView) itemView.findViewById(R.id.txtDelayarr);
            txtActarr = (TextView) itemView.findViewById(R.id.txtActarr);
            txtDelaydep = (TextView) itemView.findViewById(R.id.txtDelaydep);
            txtSchdep = (TextView) itemView.findViewById(R.id.txtSchdep);

        }
    }
}
