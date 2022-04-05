package CS401MppAssignment.Lab_2.prob_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Feature f1 = new Feature();
        Feature f2 = new Feature();
        Feature f3 = new Feature();
        Feature f4 = new Feature();
        List<Feature> featureList = new ArrayList<Feature>(Arrays.asList(f1,f2));
        List<Feature> newFeatureList = new ArrayList<Feature>(Arrays.asList(f3,f4));

        Release r1 = new Release(LocalDate.of(2021,02,01),featureList);
        Release r2 = new Release(LocalDate.of(2022,03,05),featureList);
        List<Release> rlist = new ArrayList<>(Arrays.asList(r1,r2));

        Project project1 = new Project("MPP ID", featureList,rlist);
        Developer developer1 = new Developer(newFeatureList,25);


        System.out.println( project1.toString());
        System.out.println( developer1.toString());

    }
}
