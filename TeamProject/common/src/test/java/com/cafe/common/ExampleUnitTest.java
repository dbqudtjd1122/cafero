package com.cafe.common;

import com.cafe.common.Model.ModelCafeinfo;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        ModelCafeinfo obj = new ModelCafeinfo("카페"); // cafebigtype
        List<ModelCafeinfo> list = new HttpCafeList().itemlist(obj, "like_count");

        assertNotNull(list);
        assertTrue( list.get(0).getLike_count() >= list.get(list.size()-1).getLike_count() );
    }
}