package com.pushkarnayouth.mytraindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by akmanwal on 23-Jan-18.
 */

class SeatAvailabilityAdapter extends RecyclerView.Adapter<SeatAvailabilityAdapter.SeatAvailabilityViewHolder> {
    private Context context;
    private List<Train> train;
    private List<Availability> availabilities;
    private List<SeatAvailability> seatAvailabilityList;
    private SeatAvailability seatAvailability;

    public SeatAvailabilityAdapter(Context context, SeatAvailability seatAvailability) {
        this.context = context;
        this.seatAvailability = seatAvailability;
    }

    @Override
    public SeatAvailabilityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.seat_availability_item, parent, false);
        return new SeatAvailabilityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeatAvailabilityViewHolder holder, int position) {

        Train train = seatAvailability.getTrain();

        String trainName = train.getName();
        holder.txtTrain.setText(trainName);

        String trainNum = train.getNumber();
        holder.txtTrainNo.setText(trainNum);

        availabilities = seatAvailability.getAvailability();
        String date = availabilities.get(position).getDate();
        holder.txtDate.setText(date);

        String status = availabilities.get(position).getStatus();
        holder.txtStatus.setText(status);

        JourneyClass journeyClass = seatAvailability.getJourneyClass();
        String cls = journeyClass.getName();
        holder.txtClass.setText(cls);
    }

    @Override
    public int getItemCount() {

        return seatAvailability.getAvailability().size();
    }


    public class SeatAvailabilityViewHolder extends RecyclerView.ViewHolder {
        TextView txtTrain, txtTrainNo, txtClass, txtStatus, txtDate, tv1, tv2, tv3, tv4;


        public SeatAvailabilityViewHolder(View itemView) {
            super(itemView);
            txtTrain = (TextView) itemView.findViewById(R.id.trainName);
            txtTrainNo = (TextView) itemView.findViewById(R.id.trainNumber);
            txtDate = (TextView) itemView.findViewById(R.id.showDate);
            txtClass = (TextView) itemView.findViewById(R.id.showClass);
            txtStatus = (TextView) itemView.findViewById(R.id.showStatus);

            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            tv3 = (TextView) itemView.findViewById(R.id.tv3);
            tv4 = (TextView) itemView.findViewById(R.id.tv4);
        }
    }
}
