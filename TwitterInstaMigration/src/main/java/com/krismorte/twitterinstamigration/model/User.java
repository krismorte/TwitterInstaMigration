/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.model;

import java.time.LocalDate;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;

/**
 *
 * @author c007329
 */
public class User {

    private String profileName;
    private String email;
    private String description;
    private LocalDate createAt;
    private String location;
    private Long profileId;
    private Long totalFriends;
    private Long totalFollowers;
    private Long totalStatuses;
    private String profileImage;
    private String profileImageUrl;
    private Boolean isBusiness;
    private Boolean isPrivate;
    private Boolean isVerified;

    public User() {
    }

    public User(InstagramUser user) {
        setProfileId(user.getPk());
        setProfileName(user.getUsername());
        setEmail(user.getPublic_email());
        setTotalFriends(new Long(user.getFollowing_count()));
        setTotalFollowers(new Long(user.getFollower_count()));
        setTotalStatuses(new Long(user.getMedia_count()));
        setProfileImageUrl(user.getProfile_pic_url());
        setVerified(user.is_verified);
        setBusines(user.is_business);
        setPrivate(user.is_private);
        if (user.getBiography() != null) {

            if (user.getBiography().length() > 500) {
                setDescription(user.getBiography().substring(0, 500).trim());
            } else {
                setDescription(user.getBiography().trim());
            }
        }
        //setCreateAt(date);
        if (user.getAddress_street() != null) {
            if (user.getAddress_street().length() > 500) {
                setLocation(user.getAddress_street().substring(0, 500).trim());
            } else {
                setLocation(user.getAddress_street().trim());
            }
        }

    }

    public User(InstagramUserSummary user) {
        setProfileId(user.getPk());
        setProfileName(user.getUsername());
        setProfileImageUrl(user.getProfile_pic_url());
        setVerified(user.is_verified);
        setPrivate(user.is_private);
    }

    /**
     * @return the profileName
     */
    public String getProfileName() {
        return profileName;
    }

    /**
     * @param profileName the profileName to set
     */
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the createAt
     */
    public LocalDate getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the profileId
     */
    public Long getProfileId() {
        return profileId;
    }

    /**
     * @param profileId the profileId to set
     */
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    /**
     * @return the totalFriends
     */
    public Long getTotalFriends() {
        return totalFriends;
    }

    /**
     * @param totalFriends the totalFriends to set
     */
    public void setTotalFriends(Long totalFriends) {
        this.totalFriends = totalFriends;
    }

    /**
     * @return the totalFollowers
     */
    public Long getTotalFollowers() {
        return totalFollowers;
    }

    /**
     * @param totalFollowers the totalFollowers to set
     */
    public void setTotalFollowers(Long totalFollowers) {
        this.totalFollowers = totalFollowers;
    }

    /**
     * @return the totalStatuses
     */
    public Long getTotalStatuses() {
        return totalStatuses;
    }

    /**
     * @param totalStatuses the totalStatuses to set
     */
    public void setTotalStatuses(Long totalStatuses) {
        this.totalStatuses = totalStatuses;
    }

    /**
     * @return the profileImage
     */
    public String getProfileImage() {
        return profileImage;
    }

    /**
     * @param profileImage the profileImage to set
     */
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * @return the profileImageUrl
     */
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     * @param profileImageUrl the profileImageUrl to set
     */
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    /**
     * @return the isBussinnes
     */
    public boolean isBusines() {
        return isBusiness;
    }

    /**
     * @param isBussinnes the isBussinnes to set
     */
    public void setBusines(boolean isBusines) {
        this.isBusiness = isBusines;
    }

    /**
     * @return the isPrivate
     */
    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * @param isPrivate the isPrivate to set
     */
    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    /**
     * @return the isVerified
     */
    public boolean isVerified() {
        return isVerified;
    }

    /**
     * @param isVerified the isVerified to set
     */
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    @Override
    public String toString() {
        return getProfileName();
    }

}
