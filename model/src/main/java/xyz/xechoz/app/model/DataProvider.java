package xyz.xechoz.app.model;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xechoz.zheng on 2/24/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class DataProvider extends ContentProvider {
    private List<RouterProvider> providerList = new ArrayList<>();
    private EmptyProvider emptyProvider;

    @Override
    public boolean onCreate() {
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return matchProvider(uri).query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return matchProvider(uri).getType(uri);
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return matchProvider(uri).insert(uri, values);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return matchProvider(uri).delete(uri, selection, selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return matchProvider(uri).update(uri, values, selection, selectionArgs);
    }

    public void addProvider(RouterProvider provider) {
        if (!providerList.contains(provider)) {
            providerList.add(provider);
        }
    }

    public void removeProvider(RouterProvider provider) {
        providerList.remove(provider);
    }

    private RouterProvider matchProvider(Uri uri) {
        for (RouterProvider provider: providerList) {
            if (provider.match(uri)) {
                return provider;
            }
        }

        // no provider match this uri
        if (emptyProvider == null) {
            emptyProvider = new EmptyProvider();
        }

        return emptyProvider;
    }
}
