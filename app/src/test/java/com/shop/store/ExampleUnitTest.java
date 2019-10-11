package com.shop.store;

import android.util.Log;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        Login login = new Login();
        HashMap<String, String> map = new HashMap<>();
        map.put("phone","13124720894");
        String sign = login.getSign(map);
        System.out.println(sign);

    }
}