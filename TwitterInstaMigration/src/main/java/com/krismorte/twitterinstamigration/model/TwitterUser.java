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

public class TwitterUser extends User {

    private TwitterAccount twitterAccount;

    public TwitterUser() {
    }

    public TwitterUser(TwitterAccount twitterAccount, twitter4j.User tUser) {
        this.twitterAccount = twitterAccount;
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

    /**
     * @return the twitterAccount
     */
    public TwitterAccount getTwitterAccount() {
        return twitterAccount;
    }

    /**
     * @param twitterAccount the twitterAccount to set
     */
    public void setTwitterAccount(TwitterAccount twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

}
