/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.model;

import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Scopes;
import twitter4j.Status;
import twitter4j.SymbolEntity;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;

/**
 *
 * @author krisnamourtscf
 */
public class Tweet implements Serializable {

    private Status status;
    @Resolvable(colName = "Text")
    private String text;
    @Resolvable(colName = "UserName")
    private String userName;

    public Tweet() {
    }

    public Tweet(Status status) {
        this.status = status;
        this.text = status.getText();
        this.userName = status.getUser().getName();
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
   
}
