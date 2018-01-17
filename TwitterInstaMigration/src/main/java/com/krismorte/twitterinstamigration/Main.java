/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krismorte.twitterinstamigration;

import com.alee.laf.WebLookAndFeel;
import com.krismorte.twitterinstamigration.view.MainScreen;
import javax.swing.SwingUtilities;

/**
 *
 * @author krisnamourtscf
 */
public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater ( new Runnable ()
        {
            public void run ()
            {
                // Install WebLaF as application L&F
                WebLookAndFeel.install ();

            }
        } );
        
        MainScreen tela = new MainScreen();
        tela.setVisible(true);
    }
    
}
