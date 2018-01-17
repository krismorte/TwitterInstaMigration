/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.model;

import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;

/**
 *
 * @author c007329
 */
public class InstaAccount extends User {

    public InstaAccount() {
    }

    public InstaAccount(InstagramUser user) {
        super(user);
    }

    private AccountAccess accountAccess;
    
    
    
    /* @OneToOne(targetEntity = InstaAccountAccess.class, fetch = FetchType.EAGER)
    private AccountAccess accountAccess;

    @OneToMany(mappedBy = "instaAccount")
    private List<InstaAccountAccountInteresting> accountsInteresting;
    
    @OneToMany(mappedBy = "instaAccount")
    private List<InstaAccountWhite> accountsWhite;

    @OneToMany(mappedBy = "instaAccount")
    private Set<InstaAccountFriend> friends;
    @OneToMany(mappedBy = "instaAccount")
    private Set<InstaAccountFollower> followers;
    @OneToMany(mappedBy = "instaAccount")
    private Set<InstaAccountFriendRequest> friendsRequested;*/

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
