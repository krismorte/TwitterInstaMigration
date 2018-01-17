/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.model;

import java.util.List;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;

/**
 *
 * @author c007329
 */
public class InstaUser extends User {

    public InstaUser() {
    }

    public InstaUser(InstagramUser instagramUser) {
        super(instagramUser);
    }

    public InstaUser(InstagramUserSummary instagramUser) {
        super(instagramUser);
    }

    /*@OneToMany(mappedBy = "instaUser")
    private List<InstaAccountFriend> friends;
    @OneToMany(mappedBy = "instaUser")
    private List<InstaAccountFollower> followers;*/
}
