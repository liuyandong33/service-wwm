package build.dream.wwm.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZTreeNode {
    private String id;
    private String name;
    @JsonProperty(value = "pId")
    private String pId;
    private boolean open;

    public ZTreeNode() {

    }

    public ZTreeNode(String id, String name, String pId) {
        this.id = id;
        this.name = name;
        this.pId = pId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
