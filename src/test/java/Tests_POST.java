import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ihar_Sakun
 */
public class Tests_POST {

    @Test
    public void test_1_post() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Ihar");
        map.put("job", "epam");
        System.out.println(map);
    }
}
