package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by abhicool on 10/6/2016.
 */
public class earthquakeadapter extends ArrayAdapter<earthquakelist> {

    private static final String LOCATION_SEPARATOR = " of ";
    public earthquakeadapter(Context context, int resource, List<earthquakelist> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitem=convertView;
        if(listitem==null)
        {
            listitem= LayoutInflater.from(getContext()).inflate(R.layout.earth_list, parent, false);
        }
         earthquakelist currentposition=getItem(position);
        TextView magnitude=(TextView)listitem.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(currentposition.getMmagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitude.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentposition.getMmagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);





        String originalLocation = currentposition.getMplace();
        String primaryLocation;
        String locationOffset;

        // Check whether the originalLocation string contains the " of " text
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            // Location offset should be "5km N " + " of " --> "5km N of"
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            // Primary location should be "Cairo, Egypt"
            primaryLocation = parts[1];
        } else {
            // Otherwise, there is no " of " text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            locationOffset = getContext().getString(R.string.near_the);
            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            primaryLocation = originalLocation;
        }

        TextView primarylocation=(TextView)listitem.findViewById(R.id.primary);
        primarylocation.setText(primaryLocation);
        TextView offsetlaoction=(TextView)listitem.findViewById(R.id.offsetplace);
        offsetlaoction.setText(locationOffset);
        Date dateObject = new Date(currentposition.getMdate());
        TextView date=(TextView)listitem.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        date.setText(formattedDate);
        TextView time=(TextView)listitem.findViewById(R.id.time);
        String formattedtime=formatTime(dateObject);
        time.setText(formattedtime);


        return listitem;


    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
