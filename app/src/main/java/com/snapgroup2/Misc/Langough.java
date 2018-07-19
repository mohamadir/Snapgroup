package com.snapgroup2.Misc;


import android.util.Log;
import android.view.View;
import java.util.ArrayList;

public class Langough {
    String origin,destination,text, langough_Code, description,id;

    public Langough(String title, String langough_Code, String description,String destination,String origin) {
        this.text = title;
        this.origin=origin;
        this.destination=destination;
        this.langough_Code = langough_Code;
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Langough(String id, String descritption, String text, String st)
    {
        this.text=text;
        this.id=id;
        this.description=descritption;

    }


    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLangough_Code() {
        return langough_Code;
    }

    public void setLangough_Code(String langough_Code) {
        this.langough_Code = langough_Code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static String DescriptionText(ArrayList<Langough> langoughsArray,String country_code)
    {
        String new_cnotry_code="";
        if (country_code.equals("iw"))
            new_cnotry_code="he";
        else
            new_cnotry_code=country_code;
        String string="";
        for (int j=0 ;j<langoughsArray.size();j++)
        {

            if (langoughsArray.get(j).langough_Code.equals(new_cnotry_code))
            {
                string= langoughsArray.get(j).description;
                break;
            }
        }
        Log.i("countryCode",new_cnotry_code);
        if (string.equals(""))
        {
            if (langoughsArray.size()>0)
                return langoughsArray.get(0).description;
            else
                return "";
        }
        else
            return  string;


    }
    public static String GetLOcale(ArrayList<Langough> langoughsArray,String country_code)
    {
        String new_cnotry_code="";
        if (country_code.equals("iw"))
            new_cnotry_code="he";
        else
            new_cnotry_code=country_code;
        String string="";
        for (int j=0 ;j<langoughsArray.size();j++)
        {

            if (langoughsArray.get(j).langough_Code.equals(new_cnotry_code))
            {
                string= langoughsArray.get(j).langough_Code;
                break;
            }
        }
        Log.i("countryCode",new_cnotry_code);
        if (string.equals(""))
        {
            if (langoughsArray.size()>0)
                return langoughsArray.get(0).langough_Code;
            else
                return "";
        }
        else
            return  string;


    }
    public static String GetDestnation(ArrayList<Langough> langoughsArray,String country_code)
    {
        String new_cnotry_code="";
        if (country_code.equals("iw"))
            new_cnotry_code="he";
        else
            new_cnotry_code=country_code;
        String string="";
        for (int j=0 ;j<langoughsArray.size();j++)
        {

            if (langoughsArray.get(j).langough_Code.equals(new_cnotry_code))
            {
                string= langoughsArray.get(j).destination;
                break;
            }
        }
        Log.i("countryCode",new_cnotry_code);
        if (string.equals(""))
        {
            if (langoughsArray.size()>0)
                return langoughsArray.get(0).destination;
            else
                return "";
        }
        else
            return  string;


    }
    public static String GetOrigin(ArrayList<Langough> langoughsArray,String country_code)
    {
        String new_cnotry_code="";
        if (country_code.equals("iw"))
            new_cnotry_code="he";
        else
            new_cnotry_code=country_code;
        String string="";
        for (int j=0 ;j<langoughsArray.size();j++)
        {

            if (langoughsArray.get(j).langough_Code.equals(new_cnotry_code))
            {
                string= langoughsArray.get(j).origin;
                break;
            }
        }
        Log.i("countryCode",new_cnotry_code);
        if (string.equals(""))
        {
            if (langoughsArray.size()>0)
                return langoughsArray.get(0).origin;
            else
                return "";
        }
        else
            return  string;


    }
    public static String CheckContryCode(ArrayList<Langough> langoughsArray,String country_code)
    {
        String new_cnotry_code="";
        if (country_code.equals("iw"))
            new_cnotry_code="he";
        else
            new_cnotry_code=country_code;
        Log.i("stringResult","hiooosh "+new_cnotry_code);

        String string="false";
        for (int j=0 ;j<langoughsArray.size();j++)
        {

            if (langoughsArray.get(j).getLangough_Code().equals(new_cnotry_code))
            {

                string= "true";
                break;
            }
        }
        Log.i("stringResult",string);
        return  string;


    }

    public static String GetTitle(ArrayList<Langough> langoughsArray,String country_code)
    {
        String new_cnotry_code="";
        if (country_code.equals("iw"))
            new_cnotry_code="he";
        else
            new_cnotry_code=country_code;
        String string="";
        for (int j=0 ;j<langoughsArray.size();j++)
        {

            if (langoughsArray.get(j).langough_Code.equals(new_cnotry_code))
            {
                string= langoughsArray.get(j).text;
                break;
            }
        }
        Log.i("countryCode",new_cnotry_code);
        if (string.equals(""))
        {
            if (langoughsArray.size()>0) {
                return langoughsArray.get(0).text;
            }
            else
                return "";
        }
        else
            return  string;


    }

}
