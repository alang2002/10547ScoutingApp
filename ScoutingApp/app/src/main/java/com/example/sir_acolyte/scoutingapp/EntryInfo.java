package com.example.sir_acolyte.scoutingapp;

public class EntryInfo {
    private int id;
    private String teamName;
    private int teamNumber;
    private int gameNumber;
    private String allianceColor;
    private int totalScore;
    private boolean landed;
    private boolean claimedDepot;
    private boolean parked;
    private boolean sampling;
    private int mineralDepot;
    private int mineralLander;
    private boolean hangedFromLander;
    private boolean parkedPartial;
    private boolean parkedFull;
    private String landedString;
    private String claimedString;
    private String parkedAutoString;
    private String sampledString;
    private String hangedString;
    private String parkedPartialString;
    private String parkedFullString;

    public EntryInfo() {}

    public EntryInfo(int id, String teamName, int teamNumber, int gameNumber, String allianceColor, int totalScore,
                     String landedString, String claimedString, String parkedAutoString, String sampledString, int mineralDepot,
                     int mineralLander, String hangedString, String parkedPartialString, String parkedFullString) {
        this.id = id;
        this.teamName = teamName;
        this.teamNumber = teamNumber;
        this.gameNumber = gameNumber;
        this.allianceColor = allianceColor;
        this.totalScore = totalScore;
        this.landedString = landedString;
        this.claimedString = claimedString;
        this.parkedAutoString = parkedAutoString;
        this.sampledString = sampledString;
        this.mineralDepot = mineralDepot;
        this.mineralLander = mineralLander;
        this.hangedString = hangedString;
        this.parkedPartialString = parkedPartialString;
        this.parkedFullString = parkedFullString;
    }

    public EntryInfo(int id, String teamName, int teamNumber, int gameNumber, String allianceColor, int totalScore,
                     boolean landed, boolean claimedDepot, boolean parked, boolean sampling,
                     int mineralDepot, int mineralLander, boolean hangedFromLander, boolean parkedPartial,
                     boolean parkedFull) {
        this.id = id;
        this.teamName = teamName;
        this.teamNumber = teamNumber;
        this.gameNumber = gameNumber;
        this.allianceColor = allianceColor;
        this.totalScore = totalScore;
        this.landed = landed;
        this.claimedDepot = claimedDepot;
        this.parked = parked;
        this.sampling = sampling;
        this.mineralDepot = mineralDepot;
        this.mineralLander = mineralLander;
        this.hangedFromLander = hangedFromLander;
        this.parkedPartial = parkedPartial;
        this.parkedFull = parkedFull;

        if (isLanded()) {
            landedString = "Yes";
        } else {
            landedString = "No";
        }
        if (isClaimedDepot()) {
            claimedString = "Yes";
        } else {
            claimedString = "No";
        }
        if (isParked()) {
            parkedAutoString = "Yes";
        } else {
            parkedAutoString = "No";
        }
        if (isSampling()) {
            sampledString = "Yes";
        } else {
            sampledString = "No";
        }
        if (isHangedFromLander()) {
            hangedString = "Yes";
        } else {
            hangedString = "No";
        }
        if (isParkedPartial()) {
            parkedPartialString = "Yes";
        } else {
            parkedPartialString = "No";
        }
        if (isParkedFull()) {
            parkedFullString = "Yes";
        } else {
            parkedFullString = "No";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLandedString() {
        return landedString;
    }

    public void setLandedString(String landedString) {
        this.landedString = landedString;
    }

    public String getClaimedString() {
        return claimedString;
    }

    public void setClaimedString(String claimedString) {
        this.claimedString = claimedString;
    }

    public String getParkedAutoString() {
        return parkedAutoString;
    }

    public void setParkedAutoString(String parkedAutoString) {
        this.parkedAutoString = parkedAutoString;
    }

    public String getSampledString() {
        return sampledString;
    }

    public void setSampledString(String sampledString) {
        this.sampledString = sampledString;
    }

    public String getHangedString() {
        return hangedString;
    }

    public void setHangedString(String hangedString) {
        this.hangedString = hangedString;
    }

    public String getParkedPartialString() {
        return parkedPartialString;
    }

    public void setParkedPartialString(String parkedPartialString) {
        this.parkedPartialString = parkedPartialString;
    }

    public String getParkedFullString() {
        return parkedFullString;
    }

    public void setParkedFullString(String parkedFullString) {
        this.parkedFullString = parkedFullString;
    }

    public String getAllianceColor() {
        return allianceColor;
    }

    public void setAllianceColor(String allianceColor) {
        this.allianceColor = allianceColor;
    }

    public boolean isLanded() {
        return landed;
    }

    public void setLanded(boolean landed) {
        this.landed = landed;
    }

    public boolean isClaimedDepot() {
        return claimedDepot;
    }

    public void setClaimedDepot(boolean claimedDepot) {
        this.claimedDepot = claimedDepot;
    }

    public boolean isParked() {
        return parked;
    }

    public void setParked(boolean parked) {
        this.parked = parked;
    }

    public boolean isSampling() {
        return sampling;
    }

    public void setSampling(boolean sampling) {
        this.sampling = sampling;
    }

    public int getMineralDepot() {
        return mineralDepot;
    }

    public void setMineralDepot(int mineralDepot) {
        this.mineralDepot = mineralDepot;
    }

    public int getMineralLander() {
        return mineralLander;
    }

    public void setMineralLander(int mineralLander) {
        this.mineralLander = mineralLander;
    }

    public boolean isHangedFromLander() {
        return hangedFromLander;
    }

    public void setHangedFromLander(boolean hangedFromLander) {
        this.hangedFromLander = hangedFromLander;
    }

    public boolean isParkedPartial() {
        return parkedPartial;
    }

    public void setParkedPartial(boolean parkedPartial) {
        this.parkedPartial = parkedPartial;
    }

    public boolean isParkedFull() {
        return parkedFull;
    }

    public void setParkedFull(boolean parkedFull) {
        this.parkedFull = parkedFull;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

}