package com.utssttbbandung.npm19552011182;

import android.os.Parcel;
import android.os.Parcelable;

public class Zodiak implements Parcelable {
    private String zodiak;
    private String brith;
    private String detail;
    private String image;

    // konstructor
    public Zodiak(String zodiak, String brith, String detail, String image) {
        this.zodiak = zodiak;
        this.brith = brith;
        this.detail = detail;
        this.image = image;
    }

    // implements Parcelable
    protected Zodiak(Parcel in) {
        zodiak = in.readString();
        brith = in.readString();
        detail = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(zodiak);
        dest.writeString(brith);
        dest.writeString(detail);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Zodiak> CREATOR = new Creator<Zodiak>() {
        @Override
        public Zodiak createFromParcel(Parcel in) {
            return new Zodiak(in);
        }

        @Override
        public Zodiak[] newArray(int size) {
            return new Zodiak[size];
        }
    };
    // Akhir implements Parcelable

    // setTer()
    public void setZodiak(String zodiak) {
        this.zodiak = zodiak;
    }

    public void setBrith(String brith) {
        this.brith = brith;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // getTer()
    public String getZodiak() {
        return zodiak;
    }

    public String getBrith() {
        return brith;
    }

    public String getDetail() {
        return detail;
    }

    public String getImage() {
        return image;
    }
}
