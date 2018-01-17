/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.model;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.params.ConnRoutePNames;
import org.brunocvcunha.instagram4j.Instagram4j;

/**
 *
 * @author krisnamourtscf
 */
public class InstaAccountAccess implements AccountAccess {

    private String userName;
    private String password;
    private Instagram4j instagram;

    public InstaAccountAccess() {
    }

    @Override
    public Object getConnection() {

        //System.setProperty("https.protocols", "TLSv1.1");
        if (instagram == null) {
            instagram = Instagram4j.builder().username(userName).password(password).build();
            instagram.setup();
            if (/*EngagementControll.chkProxy.isSelected()*/true) {
                HttpHost proxy = new HttpHost("172.31.3.254", 3128, "http");
                instagram.getClient().getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
                instagram.getClient().getParams().setIntParameter("http.connection.timeout", 600000);

                instagram.getClient().getCredentialsProvider().setCredentials(
                        new AuthScope("172.31.3.254", 3128),
                        new UsernamePasswordCredentials("camed\\krisnamourtscf", "025935@KM"));
            }
            try {
                instagram.login();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            if (!instagram.isLoggedIn()) {
                try {
                    instagram.login();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        return instagram;
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
