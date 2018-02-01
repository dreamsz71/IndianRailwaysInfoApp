package com.pushkarnayouth.mytraindemo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Deepak on 12/25/2017.
 */
public class IndianRailwayApi {

    private static final String MYAPIKEY = "f3zb4h0d7p";
    private static final String BASE_URL = "https://api.railwayapi.com/v2/";


    public static TrainRouteService trainRouteService = null;
    public static TrainArrivalsService trainArrivalsService = null;
    public static TrainPnrService trainPnrService = null;
    public static TrainCancelledService trainCancelledService = null;
    public static LiveTrainService liveTrainService = null;
    public static TrainBetweenStationService trainBetweenStationService = null;
    public static TrainRescheduleService trainRescheduleService = null;
    public static SeatAvailabilityService seatAvailabilityService = null;
    public static FareEstimationService fareEstimationService = null;


    public static TrainRouteService getTrainRouteService() {
        if (trainRouteService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            trainRouteService = retrofit.create(TrainRouteService.class);
        }
        return trainRouteService;
    }


    public static TrainArrivalsService getTrainArrivalsService() {
        if (trainArrivalsService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            trainArrivalsService = retrofit.create(TrainArrivalsService.class);
        }
        return trainArrivalsService;
    }

    public static TrainPnrService getTrainPnrService() {
        if (trainPnrService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            trainPnrService = retrofit.create(TrainPnrService.class);
        }
        return trainPnrService;
    }

    public static TrainCancelledService getTrainCancelledService() {
        if (trainCancelledService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            trainCancelledService = retrofit.create(TrainCancelledService.class);
        }
        return trainCancelledService;

    }

    public static LiveTrainService getLiveTrainService() {
        if (liveTrainService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            liveTrainService = retrofit.create(LiveTrainService.class);
        }
        return liveTrainService;

    }

    public static TrainBetweenStationService getBetweenStationService() {
        if (trainBetweenStationService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            trainBetweenStationService = retrofit.create(TrainBetweenStationService.class);
        }
        return trainBetweenStationService;

    }

    public static TrainRescheduleService getTrainRescheduleService() {
        if (trainRescheduleService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            trainRescheduleService = retrofit.create(TrainRescheduleService.class);
        }
        return trainRescheduleService;

    }

    public static SeatAvailabilityService getSeatAvailabilityService() {
        if (seatAvailabilityService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            seatAvailabilityService = retrofit.create(SeatAvailabilityService.class);
        }
        return seatAvailabilityService;
    }

    public static FareEstimationService getFareEstimationService() {
        if (fareEstimationService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            fareEstimationService = retrofit.create(FareEstimationService.class);
        }
        return fareEstimationService;
    }


    public interface SeatAvailabilityService {
        //https://api.railwayapi.com/v2/check-seat/train/<train number>/source/<stn code>/dest/<dest code>/date/<dd-mm-yyyy>/pref/<class code>/quota/<quota code>/apikey/<apikey>/
        //https://api.railwayapi.com/v2/check-seat/train/12001/source/BPL/dest/NDLS/date/16-07-2017/pref/CC/quota/GN/apikey/f3zb4h0d7p/
//https://api.railwayapi.com/v2/check-seat/train/12904/source/NZM/dest/KOTA/date/02-02-2018/pref/CC/quota/GN/apikey/f3zb4h0d7p/


        @GET("check-seat/train/{trainCode}/source/{sourceCode}/dest/{destCode}/date/{trainDate}/pref/{classCode}/quota/GN/apikey/" + MYAPIKEY)
        Call<SeatAvailability> getAvailability(@Path("trainCode") String trainCode, @Path("sourceCode") String sourceCode, @Path("destCode") String destCode, @Path("trainDate") String trainDate, @Path("classCode") String classCode);

    }

    public interface FareEstimationService {
        //http://api.railwayapi.com/v2/fare/train/12904/source/nzm/dest/kota/age/18/pref/SL/quota/PT/date/15-03-2018/apikey/f3zb4h0d7p/
        //https://api.railwayapi.com/v2/fare/train/12555/source/gkp/dest/ndls/age/18/pref/SL/quota/GN/date/15-03-2018/apikey/82s4hdhhyz/
        @GET("fare/train/{trainCode}/source/{sourceCode}/dest/{destCode}/age/{Age}/pref/{classCode}/quota/GN/date/{trainDate}/apikey/" + MYAPIKEY)
        Call<FareEstimation> getFare(@Path("trainCode") String trainCode, @Path("sourceCode") String sourceCode, @Path("destCode") String destCode,
                                     @Path("Age") String page, @Path("classCode") String trainClass, @Path("trainDate") String trainDate);
    }


    public interface TrainRouteService {

        // String BASE_URL = "https://simplifiedcoding.net/demos/";
        // curl "https://api.railwayapi.com/v2/route/train/12006/apikey/f3zb4h0d7p/"

        @GET("route/train/{trainCode}/apikey/" + MYAPIKEY)
        Call<TrainRoute> getRoute(@Path("trainCode") String trainCode);


    /*@GET("users/{name}/commits")
    Call<List<Commit>> getCommitsByName(@Path("name") String name)
    @GET("/AndroidPanel/OTPVerification/{otp}")
    void otp(@Path("otp") String otp,
             Callback<OTP> callback);*/

    }

    public interface TrainArrivalsService {
        //curl "https://api.railwayapi.com/v2/arrivals/station/cdg/hours/2/apikey/f3zb4h0d7p/"
        @GET("arrivals/station/{stationCode}/hours/{hours}/apikey/" + MYAPIKEY)
        Call<TrainArrivals> getArrivals(@Path("stationCode") String stationCode, @Path("hours") String hours);
    }


    public interface TrainPnrService {
        //curl "https://api.railwayapi.com/v2/pnr-status/pnr/<pnr no>/apikey/f3zb4h0d7p/"
        @GET("pnr-status/pnr/{pnrCode}/apikey/" + MYAPIKEY)
        Call<TrainPnr> getPnrStatusDetails(@Path("pnrCode") String pnrCode);
    }


    public interface TrainCancelledService {

        @GET("cancelled/date/{RequiredDate}/apikey/" + MYAPIKEY)
        Call<TrainCancelled> getCancelledTrains(@Path("RequiredDate") String RequiredDate);

    }

    public interface LiveTrainService {
        //https://api.railwayapi.com/v2/live/train/14545/date/03-01-2018/apikey/82s4hdhhyz/"

        @GET("live/train/{trainCode}/date/{trainDate}/apikey/" + MYAPIKEY + "/")
        Call<LiveTrain> getRoute(@Path("trainCode") String trainCode, @Path("trainDate") String trainDate);
    }

    public interface TrainBetweenStationService {


        //https://api.railwayapi.com/v2/between/source/gkp/dest/jat/date/24-06-2017/apikey/myapikey/

        @GET("between/source/{srccode}/dest/{destcode}/date/{journeydate}/apikey/" + MYAPIKEY)
        Call<TrainBetweenStation> getTrains(@Path("srccode") String srccode, @Path("destcode") String destcode, @Path("journeydate") String journeydate);

    }

    public interface TrainRescheduleService {

        // String BASE_URL = "https://simplifiedcoding.net/demos/";
        // curl "https://api.railwayapi.com/v2/route/train/12006/apikey/f3zb4h0d7p/"
        //curl "https://api.railwayapi.com/v2/rescheduled/date/22-01-2018/apikey/f3zb4h0d7p/"

        @GET("rescheduled/date/{rdate}/apikey/" + MYAPIKEY)
        Call<TrainReschedule> getTrains(@Path("rdate") String rdate);
    }
}
