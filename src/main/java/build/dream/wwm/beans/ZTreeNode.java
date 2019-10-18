package build.dream.wwm.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZTreeNode {
    private String id;
    private String name;
    @JsonProperty(value = "pId")
    private String pid;
    private boolean open;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
