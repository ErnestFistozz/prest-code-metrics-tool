/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.actions;

import categorizer.core.Categorizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gürhan
 */
public class UseCategorizerAdapter implements ActionListener{
    
    private Categorizer categorizer;

    public UseCategorizerAdapter(Categorizer categorizer) {
        this.categorizer = categorizer;
    }

    public void actionPerformed(ActionEvent e) {
    }
    
    public Categorizer getCategorizer() {
        return categorizer;
    }

    public void setCategorizer(Categorizer categorizer) {
        this.categorizer = categorizer;
    }
    
    

}
