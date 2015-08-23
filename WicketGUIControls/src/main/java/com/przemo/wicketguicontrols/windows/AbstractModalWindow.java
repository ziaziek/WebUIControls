/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.wicketguicontrols.windows;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author Przemo
 */
public abstract class AbstractModalWindow extends ModalWindow {

    public AbstractModalWindow(String id, Panel contentPanel) {
        super(id);
        buildMe();     
    }

    private void buildMe(){
        ModalWindowContentPanel cp = new ModalWindowContentPanel("content", null);
        cp.add(setControlButtons());
        cp.add(setContentPanel());
        setContent(cp);
    }
    
    protected abstract Panel setControlButtons();

    protected abstract Panel setContentPanel();
    
}
