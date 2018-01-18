/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration.model;

import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
import java.util.List;
import javax.swing.Icon;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;

/**
 *
 * @author krisnamourtscf
 */
public class Post implements Serializable {

    private final String TEXT_KEY = "text=";
    private InstagramFeedItem item;
    @Resolvable(colName = "Text")
    private String text;
    @Resolvable(colName = "UserName")
    private String userName;
    @Resolvable(colName = "Image")
    private Icon image;
    private List<String> arquivos;

    public Post() {
    }

    public Post(InstagramFeedItem item,List<String> arquivos) {
        this.item = item;
        this.text = extractText(item.toString());
        this.userName = item.getUser().getUsername();
        
    }

    private String extractText(String objectString) {
        int indIni = objectString.indexOf(TEXT_KEY) + TEXT_KEY.length();
        String textTmp = objectString.substring(indIni);
        System.out.println("" + textTmp);
        return textTmp.substring(0, textTmp.indexOf(","));
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
