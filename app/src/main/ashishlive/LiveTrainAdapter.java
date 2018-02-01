package com.pushkarnayouth.mytraindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akmanwal on 02-Jan-18.
 */

public class LiveTrainAdapter extends RecyclerView.Adapter<LiveTrainAdapter.LiveTrainViewHolder> {

    private Context context;
    private List<Route> RouteItems;

    public LiveTrainAdapter(Context context, List<Route> routeItems) {
    this.context = context;
    this.RouteItems = routeItems;

    }

    @Override
    public LiveTrainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_livestatus_item,parent,false);
        return new LiveTrainViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(LiveTrainViewHolder holder, int position) {
        Route route=RouteItems.get(position);
        String stationName = route.getStation().getName();
        holder.outputStation.setText(stationName);

        String scheduledArrival = route.getScharr();
        holder.outputSchedule.setText(scheduledArrival);

        String outputActual = route.getActarrDate();
        holder.outputActual.setText(outputActual);

        Boolean isArrived;
        String outputArrived;
        if(route.getHasArrived())
        {
            outputArrived = "Yes";
        }
        else
        {
            outputArrived = "No";
        }
        holder.outputArrived.setText(outputArrived);

        Boolean isDeparted;
        String outputDeparted;
        if(route.getHasDeparted())
        {
            outputDeparted = "Yes";
        }
        else
        {
            outputDeparted = "No";
        }
        holder.outputDeparted.setText(outputDeparted);

       // Integer status = route.getLatemin();
       // holder.status.setText(status);


    }

    @Override
    public int getItemCount() {
        return RouteItems.size();
    }

    public class LiveTrainViewHolder extends RecyclerView.ViewHolder
    {
        TextView outputStation, outputSchedule, outputActual, outputArrived, outputDeparted,status,tv1,tv2,tv3,tv4,tv5;

        public LiveTrainViewHolder(View itemView) {
            super(itemView);

            outputStation=(TextView)itemView.findViewById(R.id.stationOutput);
            outputSchedule=(TextView)itemView.findViewById(R.id.outputSchedule);
            outputActual=(TextView)itemView.findViewById(R.id.outputActual);
            outputArrived=(TextView)itemView.findViewById(R.id.outputArrived);
            outputDeparted=(TextView)itemView.findViewById(R.id.outputDeparted);
           // status=(TextView)itemView.findViewById(R.id.status);

            tv1=(TextView)itemView.findViewById(R.id.tv1);
            tv2=(TextView)itemView.findViewById(R.id.tv2);
            tv3=(TextView)itemView.findViewById(R.id.tv3);
            tv4=(TextView)itemView.findViewById(R.id.tv4);
            tv5=(TextView)itemView.findViewById(R.id.tv5);


        }
    }
}