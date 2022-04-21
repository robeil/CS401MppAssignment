import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;


public class FunctionUtilTest {


    List<Hotel> hotels;
    List<Person> passengers;
    List<Person> employees;
    List<Person> persons;

    Hotel flamingo, bally, excalibur;
    Person john, mark, tony, adams, adamh, frank;
    Person johnStaff, markStaff, tonyStaff, adamsStaff, adamhStaff, frankStaff;


    @Before
    public void setUp() {
        //create hotels

        flamingo = TestFactory.createHotel("flamingo");
        bally = TestFactory.createHotel("bally");
        excalibur = TestFactory.createHotel("excalibur");

        hotels = Arrays.asList(flamingo, bally, excalibur);

        //create  passengeres
        john = TestFactory.createPassenger("john", "walker");
        mark = TestFactory.createPassenger("mark", "james");
        tony = TestFactory.createPassenger("tony", "nader");
        adams = TestFactory.createPassenger("adam", "smith");
        adamh = TestFactory.createPassenger("adam", "hawkin");
        frank = TestFactory.createPassenger("frank", "sinatra");

        //create Employees

        johnStaff = TestFactory.createEmployee("john", "walker");
        markStaff= TestFactory.createEmployee("mark", "james");
        tonyStaff = TestFactory.createEmployee("tony", "nader");
        adamsStaff = TestFactory.createEmployee("adam", "smith");
        adamhStaff = TestFactory.createEmployee("adam", "hawkin");
        frankStaff= TestFactory.createEmployee("frank", "sinatra");

       persons=new ArrayList<>();
       passengers=Arrays.asList(john, mark, tony, adams, adamh, frank);
       employees=Arrays.asList(johnStaff,markStaff,tonyStaff,adamsStaff,adamhStaff,frankStaff);
       persons.addAll(passengers);
       persons.addAll(employees);

    }


    @Test
    public void testUML1() {
        Assert.assertTrue(TestingUtils.isA(Employee.class,Role.class));
        Assert.assertTrue(TestingUtils.isA(Passenger.class,Role.class));
        Assert.assertTrue(Modifier.isAbstract(Role.class.getModifiers()));
    }
    @Test
    public void testUML2() {
        TestingUtils.testClassStructure(Passenger.class, 1, Arrays.asList("reservations"));
        TestingUtils.testClassStructure(Person.class, 3, Arrays.asList("roles"));
        TestingUtils.testClassStructure(Role.class, 1, Arrays.asList());
    }
    @Test
    public void testUML3() {
        TestingUtils.testClassStructure(Hotel.class, 3, Arrays.asList("reservations", "employees"));
        TestingUtils.testClassStructure(Employee.class, 1, Arrays.asList());
    }

    @Test
    public void testUML4_testAssociationClasses() throws NoSuchFieldException {
        Assert.assertFalse(TestingUtils.isListAtrr(Reservation.class, "passenger"));
        Assert.assertFalse(TestingUtils.isListAtrr(Reservation.class, "hotel"));
    }

    @Test
    public void testPersonsWithPrefix_1() {
        for (int i = 0; i < 5; i++) {
            Reservation r = TestFactory.createReservation(5l, 2019, true);
            TestFactory.assignReservation(adamh,flamingo, r);
            TestFactory.assignReservation(tony,bally, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(adams,bally, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(adamh,bally, r);
        }
        List<String> result = FunctionUtil.peopleWithFirstNameWhoReservedAtHotel.apply(persons, "adam","bally",2020);
        assertThat(result, contains("SMITH", "HAWKIN"));
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testPersonsWithPrefix_2() {
        for (int i = 0; i < 5; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(frank, flamingo, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2019, true);
            TestFactory.assignReservation(frank, flamingo, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(adamh,bally, r);
        }
        List<String> result = FunctionUtil.peopleWithFirstNameWhoReservedAtHotel.apply(persons, "frank","flamingo",2020);
        assertThat(result, contains("SINATRA"));
        Assert.assertEquals(1, result.size());
    }


    @Test
    public void testVIP_1() {
        List<Reservation> reservations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(john, flamingo, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(mark, flamingo, r);
        }
        for (int i = 0; i < 20; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, false);
            TestFactory.assignReservation(adamh, flamingo, r);
        }
        for (int i = 0; i < 20; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(adams, bally, r);
        }

        List<String> result = FunctionUtil.vipPersonsWhoStayedAtLeastKNights.apply(persons, "flamingo", 2020, 25L);
        Assert.assertEquals(2, result.size());
        assertThat(result, contains("mark", "john"));
    }

    @Test
    public void testVIP_2() {
        List<Reservation> reservations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(john, flamingo, r);
            TestFactory.assignReservation(john, bally, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(mark, flamingo, r);
        }
        for (int i = 0; i < 20; i++) {
            Reservation r = TestFactory.createReservation(5l, 2019, false);
            TestFactory.assignReservation(adamh, flamingo, r);
        }

        List<String> result = FunctionUtil.vipPersonsWhoStayedAtLeastKNights.apply(persons, "flamingo", 2020, 10L);
        Assert.assertEquals(1, result.size());
        assertThat(result, contains("mark"));
    }

    @Test
    public void testVIP_3() {
        List<Reservation> reservations = new ArrayList<>();
        for (Person p :passengers) {
            for (int i = 0; i < 5; i++) {
                Reservation r = TestFactory.createReservation(5l, 2020, true);
                TestFactory.assignReservation(p, bally, r);
            }

        }
        for (Person p :passengers) {
            for (int i = 0; i < 10; i++) {
                Reservation r = TestFactory.createReservation(5l, 2020, false);
                TestFactory.assignReservation(p, bally, r);
            }
        }
        List<String> result = FunctionUtil.vipPersonsWhoStayedAtLeastKNights.apply(persons, "bally", 2020, 30L);
        Assert.assertEquals(0, result.size());

    }

    @Test
    public void testVIP_4() {
        List<Reservation> reservations = new ArrayList<>();
        for (Person p :passengers) {
            for (int i = 0; i < 10; i++) {
                Reservation r = TestFactory.createReservation(5l, 2019, true);
                TestFactory.assignReservation(p, bally, r);
            }

        }
        for (int i = 0; i < 5; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(adamh, excalibur, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(mark, excalibur, r);
        }
        List<String> result = FunctionUtil.vipPersonsWhoStayedAtLeastKNights.apply(persons, "excalibur", 2020, 25L);
        Assert.assertEquals(2, result.size());
        assertThat(result, contains("mark", "adam"));

    }

    @Test
    public void testVIP_5() {
        for (Hotel h : hotels) {
            for (Person p :passengers) {
                for (int i = 0; i < 10; i++) {
                    Reservation r = TestFactory.createReservation(5l, 2020, false);
                    TestFactory.assignReservation(p, h, r);
                }

            }
        }

        for (int i = 0; i < 5; i++) {
            Reservation r = TestFactory.createReservation(5l, 2020, true);
            TestFactory.assignReservation(frank, bally, r);
        }
        List<String> result = FunctionUtil.vipPersonsWhoStayedAtLeastKNights.apply(persons, "bally", 2020, 1L);
        Assert.assertEquals(1, result.size());
        assertThat(result, contains("frank"));
    }
    @Test
    public void testVIP_6() {
        for (Hotel h : hotels) {
            for (Person p :passengers) {
                for (int i = 0; i < 10; i++) {
                    Reservation r = TestFactory.createReservation(5l, 2020, false);
                    TestFactory.assignReservation(p, h, r);
                }

            }
        }

        for (int i = 0; i < 5; i++) {
            Reservation r = TestFactory.createReservation(5l, 2019, true);
            TestFactory.assignReservation(frank, bally, r);
        }
        for (int i = 0; i < 10; i++) {
            Reservation r = TestFactory.createReservation(5l, 2019, true);
            TestFactory.assignReservation(tony, bally, r);
        }
        List<String> result = FunctionUtil.vipPersonsWhoStayedAtLeastKNights.apply(persons, "bally", 2019, 1L);
        Assert.assertEquals(2, result.size());
        assertThat(result, contains("tony","frank"));
    }
    @Test
    public void testVIP_7() {
        for (Hotel h : hotels) {
            for (Person p :passengers) {
                for (int i = 0; i < 10; i++) {
                    Reservation r = TestFactory.createReservation(5l, 2020, false);
                    TestFactory.assignReservation(p, h, r);
                }
            }
        }
        List<String> result = FunctionUtil.vipPersonsWhoStayedAtLeastKNights.apply(persons, "bally", 2019, 1L);
        Assert.assertEquals(0, result.size());
    }

    // repeated tests to balance grading
    @Test
    public void testVIP_8() {
        testVIP_1();
    }
    @Test
    public void testVIP_9() {
        testVIP_2();
    }
    @Test
    public void testVIP_10() {
        testVIP_3();
    }
    @Test
    public void testVIP_11() {
        testVIP_4();
    }
    @Test
    public void testVIP_12() {
        testVIP_5();
    }
    @Test
    public void testVIP_13() {
        testVIP_6();
    }
    @Test
    public void testVIP_14() {
        testVIP_7();
    }

}


