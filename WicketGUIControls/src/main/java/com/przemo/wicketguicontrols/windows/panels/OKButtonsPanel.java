/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.wicketguicontrols.windows.panels;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Przemo
 */
public abstract class OKButtonsPanel extends Panel {

    public OKButtonsPanel(String id, IModel<String> model) {
        super(id, model);
        add(new AjaxButton("okbutton", (IModel<String>) model) {}.add(new AjaxFormComponentUpdatingBehavior("click") {
            
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                okButtonAction(target);
            }
        }));
    }
    
    public abstract void okButtonAction(AjaxRequestTarget target);
    
}
