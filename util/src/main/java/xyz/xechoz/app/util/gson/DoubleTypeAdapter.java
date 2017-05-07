package xyz.xechoz.app.util.gson;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

@GsonAdapter(unbox = double.class, box = Double.class)
public class DoubleTypeAdapter extends NumberTypeAdapter<Double> {
    public final static TypeAdapterFactory FACTORY = TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter());

    @Override
    protected Double read(String value) {
        return Double.parseDouble(value);
    }
}
