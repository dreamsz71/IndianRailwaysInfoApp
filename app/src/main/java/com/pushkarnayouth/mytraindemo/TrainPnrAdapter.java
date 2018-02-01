package com.pushkarnayouth.mytraindemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Deepak on 12/28/2017.
 */

public class TrainPnrAdapter extends RecyclerView.Adapter<TrainPnrAdapter.TrainPnrViewHolder> {

    private Context context;
    private TrainPnr trainPnrObject;
    private List<Passenger> passengerList;

    public TrainPnrAdapter(Context context, TrainPnr trainPnrObject) {
        this.context = context;
        this.trainPnrObject = trainPnrObject;
        //this.passengerList = passengerList;
    }

   /*public String[] data;
    public TrainRouteAdapter(List<Route> RouteItems)
    {
        this.RouteItems = RouteItems;
    }*/

    @Override
    public TrainPnrViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_pnr_item, parent, false);
        return new TrainPnrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainPnrViewHolder holder, int position) {

        String txtPnrCode = trainPnrObject.getPnr();
        holder.txtPnrCode.setText(txtPnrCode);  // need to check here for since route type for station

        String txtDoj = trainPnrObject.getDoj();
        holder.txtDoj.setText(txtDoj);

        int TotalPassengers = trainPnrObject.getTotalPassengers().intValue();

        String txtTotalPassengers = trainPnrObject.getTotalPassengers().toString();
        holder.txtTotalPassengers.setText(txtTotalPassengers);

        Boolean ChartPrepared = trainPnrObject.getChartPrepared();
        String txtChartPrepared;
        if (ChartPrepared == true) {
            txtChartPrepared = "Yes";
        } else {
            txtChartPrepared = "No";
        }
        holder.txtChartPrepared.setText(txtChartPrepared);
        String txtFromStation = trainPnrObject.getFromStation().getName();
        holder.txtFromStation.setText(txtFromStation);
        String txtToStation = trainPnrObject.getToStation().getName();
        holder.txtToStation.setText(txtToStation);

        String txtBoardingPoint = trainPnrObject.getBoardingPoint().getName();
        holder.txtBoardingPoint.setText(txtBoardingPoint);

        String txtReservationUpto = trainPnrObject.getReservationUpto().getName();
        holder.txtReservationUpto.setText(txtReservationUpto);


        String txtTrain = trainPnrObject.getTrain().getName();
        holder.txtTrain.setText(txtTrain);
        String txtTrainCode = trainPnrObject.getTrain().getNumber();
        holder.txtTrainCode.setText(txtTrainCode);
        String txtJourneyClass = trainPnrObject.getJourneyClass().getName();
        holder.txtJourneyClass.setText(txtJourneyClass);

        passengerList = trainPnrObject.getPassengers();
        TextView counterTextView, PassengerCurrentStatusTextView, PassengerBookingStatusTextView;
        String counterNo, PassengerCurrentStatusTextViewValue, PassengerBookingStatusTextViewValue;
        //TableRow row=(TableRow)findViewById(R.id.display_row);

        TableRow tr_head = new TableRow(this.context);
        tr_head.setId(10);
        tr_head.setBackgroundColor(Color.GRAY);
        tr_head.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        TextView label_counter = new TextView(this.context);
        label_counter.setId(20);
        label_counter.setText("S. No.");
        label_counter.setTextColor(Color.WHITE);
        label_counter.setPadding(5, 5, 5, 5);
        tr_head.addView(label_counter);// add the column to the table row here

        TextView label_currentStatus = new TextView(this.context);
        label_currentStatus.setId(20);
        label_currentStatus.setText("Current Status");
        label_currentStatus.setTextColor(Color.WHITE);
        label_currentStatus.setPadding(5, 5, 5, 5);
        tr_head.addView(label_currentStatus);// add the column to the table row here


        TextView label_bookingStatus = new TextView(this.context);
        label_bookingStatus.setId(20);
        label_bookingStatus.setText("Booking Status");
        label_bookingStatus.setTextColor(Color.WHITE);
        label_bookingStatus.setPadding(5, 5, 5, 5);
        tr_head.addView(label_bookingStatus);// add the column to the table row here

        holder.PassengerTableList.addView(tr_head);

        for (int i = 0; i < TotalPassengers; i++) {

            TableRow newRow = new TableRow(this.context);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
            newRow.setLayoutParams(lp);


            counterTextView = new TextView(this.context);
            counterNo = passengerList.get(i).getNo().toString();
            counterTextView.setText(counterNo + " ");
            counterTextView.setPadding(5, 5, 5, 5);

            PassengerCurrentStatusTextView = new TextView(this.context);
            PassengerCurrentStatusTextViewValue = passengerList.get(i).getCurrentStatus();
            PassengerCurrentStatusTextView.setText(PassengerCurrentStatusTextViewValue + " ");
            PassengerCurrentStatusTextView.setPadding(5, 5, 5, 5);

            PassengerBookingStatusTextView = new TextView(this.context);
            PassengerBookingStatusTextViewValue = passengerList.get(i).getBookingStatus();
            PassengerBookingStatusTextView.setText(PassengerBookingStatusTextViewValue + " ");
            PassengerBookingStatusTextView.setPadding(5, 5, 5, 5);


            //checkBox.setText("hello");
            //qty.setText("10");
            newRow.addView(counterTextView);
            newRow.addView(PassengerCurrentStatusTextView);
            newRow.addView(PassengerBookingStatusTextView);
            //row.addView(addBtn);
            holder.PassengerTableList.addView(newRow, i);

        }


        //String[][] PassengersArr = new String[TotalPassengers][2];
        //     for(int i=0; i<TotalPassengers;i++)
        //   {
        //  PassengersArr[i][0]=passengerList.get(i).getCurrentStatus();
        //PassengersArr[i][1]=passengerList.get(i).getBookingStatus();
        // }
        //String txtPassengerNo = passengerList.get(position).getNo().toString();               //.getNo().toString();
        //holder.txtPassengerNo.setText(txtPassengerNo);  // need to check here for since route type for station
        //String txtPassengerCurrentStatus = passengerList.get(position).getCurrentStatus();
        //holder.txtPassengerCurrentStatus.setText(txtPassengerCurrentStatus);
        // String txtPassengerBookingStatus = passengerList.get(position).getCurrentStatus();
        //holder.txtPassengerBookingStatus.setText(txtPassengerBookingStatus);
    }

    @Override

    public int getItemCount() {
        //return passengerList.size();   //add one more for fixed header row
        return 1;
        //return data.length;
    }

    public class TrainPnrViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtPnrCode;
        TextView txtDoj;
        TextView txtTotalPassengers;
        TextView txtChartPrepared;
        TextView txtToStation;
        TextView txtFromStation;
        TextView txtBoardingPoint;
        TextView txtReservationUpto;
        TextView txtTrain;
        TextView txtTrainCode;
        TextView txtJourneyClass;

        TableLayout PassengerTableList;
        TableRow row;

        TableLayout t1;


        public TrainPnrViewHolder(View itemView) {
            super(itemView);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            txtPnrCode = (TextView) itemView.findViewById(R.id.txtPnrCode);
            txtDoj = (TextView) itemView.findViewById(R.id.txtDoj);
            txtTotalPassengers = (TextView) itemView.findViewById(R.id.txtTotalPassengers);
            txtChartPrepared = (TextView) itemView.findViewById(R.id.txtChartPrepared);
            txtToStation = (TextView) itemView.findViewById(R.id.txtToStation);
            txtFromStation = (TextView) itemView.findViewById(R.id.txtFromStation);
            txtBoardingPoint = (TextView) itemView.findViewById(R.id.txtBoardingPoint);
            txtReservationUpto = (TextView) itemView.findViewById(R.id.txtReservationUpto);
            txtTrain = (TextView) itemView.findViewById(R.id.txtTrain);
            txtTrainCode = (TextView) itemView.findViewById(R.id.txtTrainCode);
            txtJourneyClass = (TextView) itemView.findViewById(R.id.txtJourneyClass);

            PassengerTableList = (TableLayout) itemView.findViewById(R.id.displayPassengers);
            // row=(TableRow) itemView.findViewById(R.id.display_row);

            //TableLayout tl = (TableLayout) itemView.findViewById(R.id.main_table);


            //txtPassengerNo = (TextView) itemView.findViewById(R.id.txtPassengerNo);
            //txtPassengerCurrentStatus = (TextView) itemView.findViewById(R.id.txtPassengerCurrentStatus);
            //txtPassengerBookingStatus = (TextView) itemView.findViewById(R.id.txtPassengerBookingStatus);
        }
    }
}

