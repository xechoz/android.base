package xyz.xechoz.app.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import xyz.xechoz.app.util.gson.LongTypeAdapter;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

@RunWith(MockitoJUnitRunner.class)
public class NumberAdapterTest {
    private String jsonString;

    @Before
    public void init() {
        HashMap<String, String> json = new HashMap<>();
        json.put("name", "a");
        json.put("aLong", " ");
        json.put("anInt", "123");
        json.put("aDouble", null);

        jsonString = new JSONObject(json).toString();
        System.out.println("json " + jsonString);
    }

    @Test
    public void emptyString2Number() {
        User user = new GsonBuilder()
                .registerTypeAdapter(Number.class, new LongTypeAdapter())
                .registerTypeHierarchyAdapter(Number.class, new LongTypeAdapter())
                .registerTypeAdapterFactory(new TypeAdapterFactory() {
                    @Override
                    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                        if (type.getRawType().getClass().isAssignableFrom(Number.class)
                                || Number.class.isAssignableFrom(type.getRawType().getClass())) {
                            return (TypeAdapter<T>) new LongTypeAdapter();
                        }

                        return null;
                    }
                })
                .create().fromJson(jsonString, User.class);

        Assert.assertEquals("long", 0, user.aLong);
        Assert.assertEquals("int", 123, user.anInt);
        Assert.assertEquals("double", user.aDouble, 0, 0.1d);
    }


    public class User {
        public User(String name, long aLong, int anInt, double aDouble) {
            this.name = name;
            this.aLong = aLong;
            this.anInt = anInt;
            this.aDouble = aDouble;
        }

        public String name;
        public long aLong;
        public int anInt;
        public double aDouble;
    }
}
