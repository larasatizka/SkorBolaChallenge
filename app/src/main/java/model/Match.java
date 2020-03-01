package model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Match implements Parcelable{
    private String homeTeam;
    private Uri homeLogo;
    private String awayTeam;
    private Uri awayLogo;
    private ArrayList<String> homeScorer = new ArrayList<>();
    private int homeScore = 0;
    private ArrayList<String> awayScorer = new ArrayList<>();
    private int awayScore = 0;

    public void addHomeScore(String name){
        homeScorer.add(name);
        homeScore++;
    }

    public void addAwayScore(String name){
        awayScorer.add(name);
        awayScore++;
    }

    public String resultScore(){
        if(awayScore == homeScore){
            return "Draw";
        }else if(homeScore > awayScore){
            return homeTeam;
        }else if(awayScore > homeScore){
            return awayTeam;
        }else{
            return "Invalid";
        }
    }

    public String awayScorer(){
        String scorer = "";
        for(String as : awayScorer){
            scorer += as + "\n";
        }
        return scorer;
    }

    public String homeScorer(){
        String scorer = "";
        for(String hs : homeScorer){
            scorer += hs + "\n";
        }
        return scorer;
    }

    public Match(String homeTeam, Uri homeLogo, String awayTeam, Uri awayLogo, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.homeLogo = homeLogo;
        this.awayTeam = awayTeam;
        this.awayLogo = awayLogo;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Uri getHomeLogo() {
        return homeLogo;
    }

    public void setHomeLogo(Uri homeLogo) {
        this.homeLogo = homeLogo;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Uri getAwayLogo() {
        return awayLogo;
    }

    public void setAwayLogo(Uri awayLogo) {
        this.awayLogo = awayLogo;
    }

    public ArrayList<String> getHomeScorer() {
        return homeScorer;
    }

    public void setHomeScorer(ArrayList<String> homeScorer) {
        this.homeScorer = homeScorer;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public ArrayList<String> getAwayScorer() {
        return awayScorer;
    }

    public void setAwayScorer(ArrayList<String> awayScorer) {
        this.awayScorer = awayScorer;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.homeTeam);
        dest.writeParcelable(this.homeLogo, flags);
        dest.writeString(this.awayTeam);
        dest.writeParcelable(this.awayLogo, flags);
        dest.writeStringList(this.homeScorer);
        dest.writeInt(this.homeScore);
        dest.writeStringList(this.awayScorer);
        dest.writeInt(this.awayScore);
    }

    protected Match(Parcel in) {
        this.homeTeam = in.readString();
        this.homeLogo = in.readParcelable(Uri.class.getClassLoader());
        this.awayTeam = in.readString();
        this.awayLogo = in.readParcelable(Uri.class.getClassLoader());
        this.homeScorer = in.createStringArrayList();
        this.homeScore = in.readInt();
        this.awayScorer = in.createStringArrayList();
        this.awayScore = in.readInt();
    }

    public static final Creator<Match> CREATOR = new Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel source) {
            return new Match(source);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };
}
