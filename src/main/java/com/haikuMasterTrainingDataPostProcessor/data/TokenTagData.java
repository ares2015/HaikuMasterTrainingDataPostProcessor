package com.haikuMasterTrainingDataPostProcessor.data;

/**
 * Created by Oliver on 2/3/2017.
 */
public class TokenTagData {

    private String token;

    private boolean isNoun;

    private boolean isVerb;

    private boolean isAdjective;

    private boolean isAdverb;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isNoun() {
        return isNoun;
    }

    public void setNoun(boolean noun) {
        isNoun = noun;
    }

    public boolean isVerb() {
        return isVerb;
    }

    public void setVerb(boolean verb) {
        isVerb = verb;
    }

    public boolean isAdjective() {
        return isAdjective;
    }

    public void setAdjective(boolean adjective) {
        isAdjective = adjective;
    }

    public boolean isAdverb() {
        return isAdverb;
    }

    public void setAdverb(boolean adverb) {
        isAdverb = adverb;
    }
}
