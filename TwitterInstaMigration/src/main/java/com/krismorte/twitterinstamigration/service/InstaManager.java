/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.service;

import com.krismorte.twitterinstamigration.model.InstaAccount;
import com.krismorte.twitterinstamigration.model.InstaAccountAccess;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramDirectShareRequest;
import org.brunocvcunha.instagram4j.requests.InstagramDirectShareRequest.ShareType;
import org.brunocvcunha.instagram4j.requests.InstagramFollowRequest;
import org.brunocvcunha.instagram4j.requests.InstagramGetMediaCommentsRequest;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowersRequest;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowingRequest;
import org.brunocvcunha.instagram4j.requests.InstagramLikeRequest;
import org.brunocvcunha.instagram4j.requests.InstagramPostCommentRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramTagFeedRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUnfollowRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUploadPhotoRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetMediaCommentsResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;

/**
 *
 * @author c007329
 */
public class InstaManager {

    private Instagram4j instagram;

    public Instagram4j getInstagram() {
        return instagram;
    }

    public void connect(InstaAccount account) {
        instagram = (Instagram4j) account.getAccountAccess().getConnection();
    }

    public void connect(InstaAccountAccess account) {
        instagram = (Instagram4j) account.getConnection();
    }

    public InstagramUser extractUser() throws Exception {
        return instagram.sendRequest(new InstagramSearchUsernameRequest(instagram.getUsername())).getUser();
    }

    public InstagramUser getUser(String screenName) throws Exception {
        return instagram.sendRequest(new InstagramSearchUsernameRequest(screenName)).getUser();
    }

    public InstagramGetUserFollowersResult getFriends(long id, String cursor) throws Exception {
        return instagram.sendRequest(new InstagramGetUserFollowingRequest(id, cursor));

    }

    public InstagramGetUserFollowersResult getFollowers(long id, String cursor) throws Exception {
        return instagram.sendRequest(new InstagramGetUserFollowersRequest(id, cursor));

    }

    public void friendRequest(long id) throws Exception {
        instagram.sendRequest(new InstagramFollowRequest(id));
    }

    public void friendUnfollow(long id) throws Exception {
        instagram.sendRequest(new InstagramUnfollowRequest(id));
    }

    public InstagramFeedItem uploadImage(String imagePath, String text) throws Exception {
        return instagram.sendRequest(new InstagramUploadPhotoRequest(
                new File(imagePath),
                text)).getMedia();
    }

    public InstagramFeedResult getFeed(long id) throws Exception {
        return instagram.sendRequest(new InstagramUserFeedRequest(id));
    }

    public InstagramFeedResult getFeedByHashTag(String hashtag) throws Exception {
        return instagram.sendRequest(new InstagramTagFeedRequest(hashtag));
    }

    public void likeMedia(long mediaId) throws Exception {
        instagram.sendRequest(new InstagramLikeRequest(mediaId));
    }
    
    public void commentMedia(long mediaId,String text) throws Exception {
        instagram.sendRequest(new InstagramPostCommentRequest(mediaId, text));
    }

    public InstagramGetMediaCommentsResult getFeedComments(String mediaId, String maxCommentId) throws Exception {
        return instagram.sendRequest(new InstagramGetMediaCommentsRequest(mediaId, maxCommentId));
    }

    public void sendDirect(long profileId,String message) throws Exception{
        List<String> recipients = Arrays.asList(""+profileId);
        instagram.sendRequest(InstagramDirectShareRequest.builder(ShareType.MESSAGE, recipients).message(message).build());
    }
    
    /*public InstagramUser getUser(long id) throws Exception {
        return instagram.sendRequest(new InstagramSearchUsernameRequest().getUser();
    }
     */
 /*public IDs getFriendsIDs(long cursor) throws Exception {
        return twitter.getFriendsIDs(twitter.getScreenName(), cursor);
    }

    public IDs getFollowersIDs(long cursor) throws Exception {
        return twitter.getFollowersIDs(twitter.getScreenName(), cursor);
    }*/
}
