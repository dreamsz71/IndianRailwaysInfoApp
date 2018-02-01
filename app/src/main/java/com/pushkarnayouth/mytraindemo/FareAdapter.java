package com.pushkarnayouth.mytraindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akmanwal on 24-Jan-18.
 */

public class FareAdapter extends RecyclerView.Adapter<FareAdapter.FareViewHolder> {

    Context context;
    private List<Train> trains;
    private List<FareEstimation> fareEstimationList;
    private FareEstimation fareEstimation;
//    private List<Class> code;


    public FareAdapter(Context context, FareEstimation fareEstimation) {
        this.context = context;
        this.fareEstimation = fareEstimation;
    }


    @Override
    public FareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.fare_item, parent, false);
        return new FareViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FareViewHolder holder, int position) {

        Train train = fareEstimation.getTrain();

        String trainName = train.getName();
        holder.tname.setText(trainName);

        String trainNumber = train.getNumber();
        holder.tnumber.setText(trainNumber);


        String fromStation = fareEstimation.getFromStation().getName();
        holder.fstation.setText(fromStation);

        String toStation = fareEstimation.getToStation().getName();
        holder.tstation.setText(toStation);

        String journeyClass = fareEstimation.getJourneyClass().getName();
        holder.tclass.setText(journeyClass);

        String tFare = fareEstimation.getFare().toString();
        holder.tfare.setText("₹ " + tFare);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class FareViewHolder extends RecyclerView.ViewHolder {
        TextView tv5, tv6, tv7, tv8, tv9, tname, tnumber, fstation, tstation, tclass, tfare;

        public FareViewHolder(View itemView) {
            super(itemView);

            tv5 = (TextView) itemView.findViewById(R.id.tv5);
            tv6 = (TextView) itemView.findViewById(R.id.tv6);
            tv7 = (TextView) itemView.findViewById(R.id.tv7);
            tv8 = (TextView) itemView.findViewById(R.id.tv8);
            tv9 = (TextView) itemView.findViewById(R.id.tv9);

            tname = (TextView) itemView.findViewById(R.id.faretrainName);
            tnumber = (TextView) itemView.findViewById(R.id.faretrainNumber);
            fstation = (TextView) itemView.findViewById(R.id.fromStation);
            tstation = (TextView) itemView.findViewById(R.id.toStation);
            tclass = (TextView) itemView.findViewById(R.id.fareshowClass);
            tfare = (TextView) itemView.findViewById(R.id.showFare);
        }
    }
}
