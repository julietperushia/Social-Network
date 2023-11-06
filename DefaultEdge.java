public class DefaultEdge {
    
    private User source;
    private User target;

    public DefaultEdge(User source, User target) {
        this.source = source;
        this.target = target;
    }

    public User getSource() {
        return source;
    }

    public void setSource(User source) {
        this.source = source;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }
    
    

}
