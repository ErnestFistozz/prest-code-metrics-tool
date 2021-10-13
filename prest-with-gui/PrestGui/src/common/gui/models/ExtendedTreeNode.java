/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.gui.models;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author handee
 */
public class ExtendedTreeNode extends DefaultMutableTreeNode{
    
    private boolean isProjectNode;
    private String projectPath;
    
    public ExtendedTreeNode() {
        super();
    }
    
    public ExtendedTreeNode(Object userObject) {
        super(userObject);
        this.projectPath = null;
        isProjectNode = false;
    }
    
    public ExtendedTreeNode(String projectPath, Object userObject,boolean isProjectNode) {
        super(userObject);
        this.projectPath = projectPath;
        this.isProjectNode = isProjectNode;
    }
    
    public ExtendedTreeNode(Object userObject, boolean allowsChildren) {
        super(userObject,allowsChildren);
        this.projectPath = null;
        isProjectNode = false;
    }

    public boolean isIsProjectNode() {
        return isProjectNode;
    }

    public void setIsProjectNode(boolean isProjectNode) {
        this.isProjectNode = isProjectNode;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

}
