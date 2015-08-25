/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.wicketguicontrols.windows.panels;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author Przemo
 */
public class ModalWindowContentPanel extends Panel {

    private static final String CONTENT_PLACEHOLDER="content";
    private static final String BUTTONS_PLACEHOLDER ="buttons";
    
    private final Panel cp, bp;
    
    public ModalWindowContentPanel(String id, Panel contentPanel, Panel buttonsPanel) {
        super(id);
        this.cp=contentPanel;
        this.bp=buttonsPanel;
        add(new WebMarkupContainer(CONTENT_PLACEHOLDER).add(contentPanel));
        add(new WebMarkupContainer(BUTTONS_PLACEHOLDER).add(buttonsPanel));
        
    }
    
}
