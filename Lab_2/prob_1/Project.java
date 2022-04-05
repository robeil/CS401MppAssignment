package CS401MppAssignment.Lab_2.prob_1;

import java.util.List;

public class Project {

    private String projectId;
    private List<Feature> featureSet;
    private List<Release> releaseList;

    public Project(){

    }

    public Project(String projectId, List<Feature> featureSet, List<Release> releaseList) {
        this.projectId = projectId;
        this.featureSet = featureSet;
        this.releaseList = releaseList;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<Feature> getFeatureSet() {
        return featureSet;
    }

    public void setFeatureSet(List<Feature> featureSet) {
        this.featureSet = featureSet;
    }

    public List<Release> getReleaseList() {
        return releaseList;
    }

    public void setReleaseList(List<Release> releaseList) {
        this.releaseList = releaseList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", featureSet=" + featureSet +
                ", releaseList=" + releaseList +
                '}';
    }
}
