/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.util;

import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author Gürhan
 */
public class ComponentState {
    
    /**
     * This function updates the states (enabled/disabled) of the given
     * list of components according to the given boolean value.
     * @param componentList It is the list of components that will change state
     * @param state It is a boolean variable to set enabled or disabled the given
     * components
     */
    public static void setEnabledDisabled( List<JComponent> componentList, boolean state ) {
        if(componentList != null) {
            for( JComponent component : componentList ) {
                component.setEnabled(state);
            }
        }
    }

}
