package com.example.android.quakereport;

/**
 * Created by abhicool on 10/5/2016.
 */
public class earthquakelist {

   private double mmagnitude;
    private String mplace;
    private Long mdate;
    private String murl;

 public earthquakelist(double magnitude, String place, Long date, String url)
 {
     mmagnitude=magnitude;
     mplace=place;
     mdate=date;
     murl=url;

 }  public String getMurl()
    {
        return murl;
    }

    public double getMmagnitude() {
        return mmagnitude;
    }

    public Long getMdate() {
        return mdate;
    }

    public String getMplace() {
        return mplace;
    }
}

