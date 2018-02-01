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
 * Created by Deepak on 12/25/2017.
 */
public class TrainRouteAdapter extends RecyclerView.Adapter<TrainRouteAdapter.TrainRouteViewHolder> {

    private Context context;
    private List<Route> RouteItems;
    private TrainRoute tRoute;

    //List<Route> routeItems,
    public TrainRouteAdapter(Context context, TrainRoute tRoute) {
        this.context = context;
        //RouteItems = routeItems;
        this.tRoute = tRoute;
    }
    /*public String[] data;
    public TrainRouteAdapter(List<Route> RouteItems)
    {
        this.RouteItems = RouteItems;
    }*/

    @Override
    public TrainRouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_route_item, parent, false);
        return new TrainRouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainRouteViewHolder holder, int position) {
        //String Station = data[position];
        //holder.txtStation.setText(Station);
        // scharr; schdep; halt; distance; day;

        //Route route = RouteItems.get(position);
        List<Route> route = tRoute.getRoute();
        String stationName = route.get(position).getStation().getName();
        holder.txtStation.setText(stationName);  // need to check here for since route type for station
        String stationCode = route.get(position).getStation().getCode();
        holder.stationCode.setText(stationCode);
        String scharr = route.get(position).getScharr();
        holder.scharr.setText(scharr);
        String schdep = route.get(position).getSchdep();
        holder.schdep.setText(schdep);
        String halt = route.get(position).getHalt().toString();
        holder.halt.setText(halt);
        String distance = route.get(position).getDistance().toString();
        holder.distance.setText(distance);
        String day = route.get(position).getDay().toString();
        holder.day.setText(day);

        Train train = tRoute.getTrain();
        String trainName = train.getName();
        holder.trainName.setText(trainName);
        String trainCode = train.getNumber();
        holder.trainCode.setText(trainCode);


    }

    @Override
    public int getItemCount() {
        return tRoute.getRoute().size();
        //return RouteItems.size();
        //return data.length;
    }

    public class TrainRouteViewHolder extends RecyclerView.ViewHolder {
        TextView txtStation;
        ImageView imgIcon;
        TextView stationCode;
        TextView scharr;
        TextView schdep;
        TextView halt;
        TextView distance;
        TextView day;
        TextView trainName;
        TextView trainCode;

        public TrainRouteViewHolder(View itemView) {
            super(itemView);
            txtStation = (TextView) itemView.findViewById(R.id.txtStation);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            stationCode = (TextView) itemView.findViewById(R.id.stationCode);
            scharr = (TextView) itemView.findViewById(R.id.scharr);
            schdep = (TextView) itemView.findViewById(R.id.schdep);
            halt = (TextView) itemView.findViewById(R.id.halt);
            distance = (TextView) itemView.findViewById(R.id.distance);
            day = (TextView) itemView.findViewById(R.id.day);
            trainName = (TextView) itemView.findViewById(R.id.trainName);
            trainCode = (TextView) itemView.findViewById(R.id.trainCode);

        }
    }
}
