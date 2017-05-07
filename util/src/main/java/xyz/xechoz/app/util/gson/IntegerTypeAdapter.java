package xyz.xechoz.app.util.gson;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

public class IntegerTypeAdapter extends NumberTypeAdapter<Integer> {
    public final static TypeAdapterFactory FACTORY = TypeAdapters.newFactory(int.class, Integer.class, new IntegerTypeAdapter());

    @Override
    protected Integer read(String value) {
        return Integer.parseInt(value);
    }
}
