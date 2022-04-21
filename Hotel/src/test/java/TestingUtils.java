import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestingUtils {
    // check if a declared attribute matches certain type
    public static boolean atrrIs(Class c, String atrrName, String attType) {
        try {
            return c.getDeclaredField(atrrName).getType().getSimpleName().equalsIgnoreCase(attType);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isListAtrr(Class c, String atrrName) throws NoSuchFieldException {
        c.getDeclaredField(atrrName);
        return atrrIs(c, atrrName, "list");
    }

    public static boolean isA(Class a, Class b) {
        return a.getSuperclass().getSimpleName().equals(b.getSimpleName());
    }

    //Check class structure in terms of attributes,methods and data types
    public static void testClassStructure(Class c, int attributesCount, List<String> expectedAsListAttr){
        Assert.assertEquals(attributesCount, c.getDeclaredFields().length);
        Assert.assertEquals(2 * attributesCount,
                Stream.of(c.getDeclaredMethods()).filter(m -> m.getName().startsWith("set") | m.getName().startsWith("get"))
                        .count());
        if (expectedAsListAttr != null) {
            expectedAsListAttr.stream().forEach(attr ->
            {
                try {
                    Assert.assertTrue(isListAtrr(c, attr));
                } catch (NoSuchFieldException e) {
                    Assert.assertTrue(false);
                    e.printStackTrace();
                }
            });

        }
        Assert.assertTrue(Stream.of(c.getDeclaredMethods()).count() == attributesCount * 2);

    }
}
