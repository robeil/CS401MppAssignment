package CS401MppAssignment.Lab_2.prob_1;

import java.time.LocalDate;
import java.util.List;

public class Release {

    private LocalDate releaseDate;
    private List<Feature> features;

    public Release(){

    }

    public Release(LocalDate releaseDate, List<Feature> features) {
        this.releaseDate = releaseDate;
        this.features = features;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "Release{" +
                "releaseDate=" + releaseDate +
                ", features=" + features +
                '}';
    }
}
