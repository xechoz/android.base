package xyz.xechoz.app.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by xechoz.zheng on 2/24/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public interface RouterProvider {
    boolean match(Uri uri);
    Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder);

    String getType(@NonNull Uri uri);

    Uri insert(@NonNull Uri uri, @Nullable ContentValues values);

    int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs);

    int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs);
}
