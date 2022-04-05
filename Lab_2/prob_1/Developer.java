package CS401MppAssignment.Lab_2.prob_1;

import java.util.List;

public class Developer {

    private List<Feature> assignFeature;
    private int developerId;

    public Developer(){

    }

    public Developer(List<Feature> assignFeature, int developerId) {
        this.assignFeature = assignFeature;
        this.developerId = developerId;
    }

    public List<Feature> getAssignFeature() {
        return assignFeature;
    }

    public void setAssignFeature(List<Feature> assignFeature) {
        this.assignFeature = assignFeature;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "assignFeature=" + assignFeature +
                ", developerId=" + developerId +
                '}';
    }
}
