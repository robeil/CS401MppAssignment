package CS401MppAssignment.Univerisity_src_Previous_orig.main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface FunUtil {

    TriFunction<Integer,Integer,Integer,Integer> sumSquare=(x, y, z)->
            x*x+y*y+z*z;

    Function<Univ,List<Role>> getRoles= uni->
            Stream.of(uni).flatMap(u->u.getDepartments().stream())
                    .flatMap(d->d.getPersons().stream())
                    .flatMap(p->p.getRoles().stream())
            .collect(Collectors.toList());



    Function<Univ,List<Student>> getStudents=(uni)->
            getRoles.apply(uni).stream()
                    .filter(r->r instanceof Student)
                    .map(r->(Student)r)
                    .collect(Collectors.toList());

    Function<Univ,List<Instructor>> getInstructors=(uni)->
            getRoles.apply(uni).stream()
                    .filter(r->r instanceof Instructor)
                    .map(r->(Instructor)r)
                    .collect(Collectors.toList());

    Function<Univ, Optional<Instructor>> getBestInstructor= univ->
            getInstructors.apply(univ).stream()
            .sorted((i1,i2)->(int)(i2.getGrades().stream().count() - i1.getGrades().stream().count()))
            .findFirst();

    Predicate<Role> isStudent= r->r instanceof Student;

    Function<Student,Long> getTotalScore= stu->
            Stream.of(stu)
                    .flatMap(s->s.getGrades().stream())
            .filter(g->g.getLetter()==Letter.A || g.getLetter()==Letter.B)
            .mapToLong(g->g.getCourse().getCredit()).sum();

    BiFunction<Univ,Long,List<Student>> getGraduates=(univ, k)->
            getStudents.apply(univ).stream()
            .map(s->new Tuple<Student,Long>(s,getTotalScore.apply(s)))
            .filter(t->t.getValue()>=k)
            .sorted((t1,t2)->(int)(t2.getValue()-t1.getValue()))
            .map(t->t.getKey())
            .collect(Collectors.toList());


    BiFunction<Univ,Long,List<Student>> getGraduates2=(univ, k)->
            getStudents.apply(univ).stream()
            .filter(s->getTotalScore.apply(s)>=k)
            .sorted((s1,s2)->(int)(getTotalScore.apply(s2)-getTotalScore.apply(s1)))
            .collect(Collectors.toList());


    Function<Univ,List<Course>> getCourses=univ->
            getStudents.apply(univ).stream()
            .flatMap(s->s.getGrades().stream())
            .map(g->g.getCourse())
            .distinct()
            .collect(Collectors.toList());

    Function<Course,Long> getTotalEnrollments=c->Stream.of(c).flatMap(course->course.getGrades().stream()).count();
    Function<Course,Long> getTotalFailures=c->Stream.of(c).flatMap(course->course.getGrades().stream())
            .filter(g->!(g.getLetter()==Letter.A||g.getLetter()==Letter.B))
            .count();
    Function<Course,Double> getFailureRatio=c->getTotalEnrollments.apply(c)==0?0:1.0*(getTotalFailures.apply(c)/getTotalEnrollments.apply(c));


    BiFunction<Univ,Long,List<Course>> worstKCourses=(univ,k)->
            getCourses.apply(univ).stream()
            .sorted((c1,c2)->(int)(getFailureRatio.apply(c2)-getFailureRatio.apply(c1)))
            .limit(k)
            .collect(Collectors.toList());
}
