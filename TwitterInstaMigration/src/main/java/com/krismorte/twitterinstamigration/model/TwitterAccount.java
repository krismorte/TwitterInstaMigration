/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.model;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author krisnamourtscf
 */
public class TwitterAccount extends User {

    public TwitterAccount() {
    }

    public TwitterAccount(twitter4j.User tUser) {
        setProfileId(tUser.getId());
        setProfileName(tUser.getScreenName());
        setEmail(tUser.getEmail());
        setTotalFriends(new Long(tUser.getFriendsCount()));
        setTotalFollowers(new Long(tUser.getFollowersCount()));
        LocalDate date = tUser.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        setCreateAt(date);
        setDescription(tUser.getDescription());
        setLocation(tUser.getLocation());
        setTotalStatuses(new Long(tUser.getStatusesCount()));
    }

    private AccountAccess accountAccess;

    /**
     * @return the accountAccess
     */
    public AccountAccess getAccountAccess() {
        return accountAccess;
    }

    /**
     * @param accountAccess the accountAccess to set
     */
    public void setAccountAccess(AccountAccess accountAccess) {
        this.accountAccess = accountAccess;
    }

}
