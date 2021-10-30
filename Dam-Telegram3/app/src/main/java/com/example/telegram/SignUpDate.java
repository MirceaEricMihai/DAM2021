package com.example.telegram;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpDate implements Parcelable {

    private String nume;
    private String prenume;
    private String numarTelefon;

    public SignUpDate(String nume, String prenume, String numarTelefon){
        this.nume = nume;
        this.prenume = prenume;
        this.numarTelefon = numarTelefon;
    }

    public SignUpDate(){

    }

    protected SignUpDate(Parcel in) {
        nume = in.readString();
        prenume = in.readString();
        numarTelefon = in.readString();
    }

    public static final Creator<SignUpDate> CREATOR = new Creator<SignUpDate>() {
        @Override
        public SignUpDate createFromParcel(Parcel in) {
            return new SignUpDate(in);
        }

        @Override
        public SignUpDate[] newArray(int size) {
            return new SignUpDate[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNumarTelefon() { return numarTelefon;}

    public void setNumarTelefon(String numarTelefon) {this.numarTelefon = numarTelefon;}

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("SignUpDate{");
        sb.append("nume=").append(nume).append('\'');
        sb.append("prenume=").append(prenume).append('\'');
        sb.append("numarTelefon=").append(numarTelefon).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(prenume);
        dest.writeString(numarTelefon);

    }
}
