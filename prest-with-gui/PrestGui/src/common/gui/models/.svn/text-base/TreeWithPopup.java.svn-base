package common.gui.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author handee
 */
public class TreeWithPopup extends JTree implements ActionListener{
    JPopupMenu rootPopupMenu;
    JPopupMenu projectPopupMenu;
    JMenuItem menuItem;
    
    TreeWithPopup(DefaultMutableTreeNode defaultMutableTreeNode) {
        super(defaultMutableTreeNode);
        // define the popup
//        popupMenu = new JPopupMenu();
//        menuItem = new JMenuItem("Insert a children");
//        menuItem.addActionListener(this);
//        menuItem.setActionCommand("insert");
//        popupMenu.add(menuItem);
//        menuItem = new JMenuItem("Remove this node");
//        menuItem.addActionListener(this);
//        menuItem.setActionCommand("remove");
//        popupMenu.add(menuItem);
//        popupMenu.setOpaque(true);
//        popupMenu.setLightWeightPopupEnabled(true);
        
        addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseReleased( MouseEvent e ) {
                if ( e.isPopupTrigger()) {
//                    popupMenu.show( (JComponent)e.getSource(), e.getX(), e.getY() );
                }
            }
        }
        );
        
    }
    public void actionPerformed(ActionEvent ae) {
        DefaultMutableTreeNode dmtn, node;
        
        TreePath path = this.getSelectionPath();
        dmtn = (DefaultMutableTreeNode) path.getLastPathComponent();
        
        if (ae.getActionCommand().equals("insert")) {
            node = new DefaultMutableTreeNode("children");
            dmtn.add(node);
            // thanks to Yong Zhang for the tip for refreshing the tree structure.
            ((DefaultTreeModel )this.getModel()).nodeStructureChanged((TreeNode)dmtn);
        }
        
        if (ae.getActionCommand().equals("remove")) {
            node = (DefaultMutableTreeNode)dmtn.getParent();
            // Bug fix by essam
            int nodeIndex=node.getIndex(dmtn); // declare an integer to hold the selected nodes index
            dmtn.removeAllChildren();          // remove any children of selected node
            node.remove(nodeIndex);            // remove the selected node, retain its siblings
            ((DefaultTreeModel )this.getModel()).nodeStructureChanged((TreeNode)dmtn);       }
    }

}