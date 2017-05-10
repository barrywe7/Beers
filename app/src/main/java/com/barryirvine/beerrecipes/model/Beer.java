package com.barryirvine.beerrecipes.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Beer implements Parcelable {

    public static final Parcelable.Creator<Beer> CREATOR = new Parcelable.Creator<Beer>() {
        @Override
        public Beer createFromParcel(final Parcel source) {
            return new Beer(source);
        }

        @Override
        public Beer[] newArray(final int size) {
            return new Beer[size];
        }
    };
    private int id;
    private String name;
    private String tagline;
    private String firstBrewed;
    private String description;
    private String imageUrl;
    private double abv;
    private double ibu;
    private double targetFg;
    private double targetOg;
    private double ebc;
    private double srm;
    private double ph;
    private double attenuationLevel;
    //public Volume volume;
    //public Method method;
    //public Ingredients ingredients;
    private List<String> foodPairing;
    private String brewersTips;
    private String contributedBy;
    public Beer() {
    }

    protected Beer(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.tagline = in.readString();
        this.firstBrewed = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();
        this.abv = in.readDouble();
        this.ibu = in.readDouble();
        this.targetFg = in.readDouble();
        this.targetOg = in.readDouble();
        this.ebc = in.readDouble();
        this.srm = in.readDouble();
        this.ph = in.readDouble();
        this.attenuationLevel = in.readDouble();
        this.foodPairing = in.createStringArrayList();
        this.brewersTips = in.readString();
        this.contributedBy = in.readString();
    }

    public String getTagline() {
        return tagline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getAbv() {
        return abv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.tagline);
        dest.writeString(this.firstBrewed);
        dest.writeString(this.description);
        dest.writeString(this.imageUrl);
        dest.writeDouble(this.abv);
        dest.writeDouble(this.ibu);
        dest.writeDouble(this.targetFg);
        dest.writeDouble(this.targetOg);
        dest.writeDouble(this.ebc);
        dest.writeDouble(this.srm);
        dest.writeDouble(this.ph);
        dest.writeDouble(this.attenuationLevel);
        dest.writeStringList(this.foodPairing);
        dest.writeString(this.brewersTips);
        dest.writeString(this.contributedBy);
    }
}
