package com.example.android.testing.blueprint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class MeasureCanvas extends Canvas {
    private float width = 0;
    private float height = 0;

    public float getMeasuredWidth() {
        return width;
    }

    public float getMeasuredHeight() {
        return height;
    }

    @Override
    public void drawArc(@NonNull RectF oval, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint) {
        width = Math.max(width, oval.right + paint.getStrokeWidth());
        height = Math.max(height, oval.bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint) {
        width = Math.max(width, right + paint.getStrokeWidth());
        height = Math.max(height, bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, @NonNull Matrix matrix, @Nullable Paint paint) {
        width = Math.max(width, bitmap.getWidth());
        height = Math.max(height, bitmap.getHeight());
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, @Nullable Rect src, @NonNull Rect dst, @Nullable Paint paint) {
        width = Math.max(width, dst.right);
        height = Math.max(height, dst.bottom);
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, @Nullable Rect src, @NonNull RectF dst, @Nullable Paint paint) {
        width = Math.max(width, dst.right);
        height = Math.max(height, dst.bottom);
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, float left, float top, @Nullable Paint paint) {
        width = Math.max(width, bitmap.getWidth() + left);
        height = Math.max(height, bitmap.getHeight() + top);
    }

    @Override
    public void drawCircle(float cx, float cy, float radius, @NonNull Paint paint) {
        width = Math.max(width, cx + radius);
        height = Math.max(height, cy + radius);
    }

    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, @NonNull Paint paint) {
        width = Math.max(width, startX + paint.getStrokeWidth());
        width = Math.max(width, stopX + paint.getStrokeWidth());
        height = Math.max(height, startY + paint.getStrokeWidth());
        height = Math.max(height, stopY + paint.getStrokeWidth());
    }

    @Override
    public void drawLines(@NonNull float[] pts, @NonNull Paint paint) {
        int i = 0;
        while (i < pts.length) {
            drawLine(pts[i], pts[i + 1], pts[i + 2], pts[i + 3], paint);
            i = i + 4;
        }
    }

    @Override
    public void drawLines(@NonNull float[] pts, int offset, int count, @NonNull Paint paint) {
        int i = offset;
        while (i < offset + count) {
            drawLine(pts[i], pts[i + 1], pts[i + 2], pts[i + 3], paint);
            i = i + 4;
        }
    }

    @Override
    public void drawOval(@NonNull RectF oval, @NonNull Paint paint) {
        width = Math.max(width, oval.right + paint.getStrokeWidth());
        height = Math.max(height, oval.bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawOval(float left, float top, float right, float bottom, @NonNull Paint paint) {
        width = Math.max(width, right + paint.getStrokeWidth());
        height = Math.max(height, bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawPath(@NonNull Path path, @NonNull Paint paint) {
        final RectF bounds = new RectF();
        path.computeBounds(bounds, true);

        width = Math.max(width, bounds.right + paint.getStrokeWidth());
        height = Math.max(height, bounds.bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawPicture(@NonNull Picture picture) {
        width = Math.max(width, picture.getWidth());
        height = Math.max(height, picture.getHeight());
    }

    @Override
    public void drawPicture(@NonNull Picture picture, @NonNull Rect dst) {
        width = Math.max(width, dst.right);
        height = Math.max(height, dst.bottom);
    }

    @Override
    public void drawPicture(@NonNull Picture picture, @NonNull RectF dst) {
        width = Math.max(width, dst.right);
        height = Math.max(height, dst.bottom);
    }

    @Override
    public void drawPoint(float x, float y, @NonNull Paint paint) {
        width = Math.max(width, x + paint.getStrokeWidth());
        height = Math.max(height, y + paint.getStrokeWidth());
    }

    @Override
    public void drawPoints(@NonNull float[] pts, @NonNull Paint paint) {
        int i = 0;
        while (i < pts.length) {
            drawPoint(pts[i], pts[i + 1], paint);
            i = i + 2;
        }
    }

    @Override
    public void drawPoints(float[] pts, int offset, int count, @NonNull Paint paint) {
        int i = offset;
        while (i < offset + count) {
            drawPoint(pts[i], pts[i + 1], paint);
            i = i + 2;
        }
    }

    @Override
    public void drawRect(@NonNull Rect r, @NonNull Paint paint) {
        width = Math.max(width, r.right + paint.getStrokeWidth());
        height = Math.max(height, r.bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawRect(@NonNull RectF rect, @NonNull Paint paint) {
        width = Math.max(width, rect.right + paint.getStrokeWidth());
        height = Math.max(height, rect.bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawRect(float left, float top, float right, float bottom, @NonNull Paint paint) {
        width = Math.max(width, right + paint.getStrokeWidth());
        height = Math.max(height, bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawRoundRect(@NonNull RectF rect, float rx, float ry, @NonNull Paint paint) {
        width = Math.max(width, rect.right + paint.getStrokeWidth());
        height = Math.max(height, rect.bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, @NonNull Paint paint) {
        width = Math.max(width, right + paint.getStrokeWidth());
        height = Math.max(height, bottom + paint.getStrokeWidth());
    }

    @Override
    public void drawText(@NonNull String text, float x, float y, @NonNull Paint paint) {
        drawText(text, 0, text.length(), x, y, paint);
    }

    @Override
    public void drawText(@NonNull String text, int start, int end, float x, float y, @NonNull Paint paint) {
        final Rect bounds = new Rect();
        paint.getTextBounds(text, start, end, bounds);

        width = Math.max(width, bounds.right + x);
        height = Math.max(height, bounds.bottom + y);
    }

    @Override
    public void drawText(@NonNull char[] text, int index, int count, float x, float y, @NonNull Paint paint) {
        drawText(String.valueOf(text), index, count, x, y, paint);
    }

    @Override
    public void drawText(@NonNull CharSequence text, int start, int end, float x, float y, @NonNull Paint paint) {
        drawText(text.toString(), start, end, x, y, paint);
    }

    @Override
    public void drawBitmapMesh(@NonNull Bitmap bitmap, int meshWidth, int meshHeight, @NonNull float[] verts, int vertOffset, @Nullable int[] colors, int colorOffset, @Nullable Paint paint) {
       Log.e("Measure","Not supported");
        //Not supported
    }

    @Override
    public void drawTextOnPath(@NonNull String text, @NonNull Path path, float hOffset, float vOffset, @NonNull Paint paint) {
        Log.e("Measure","Not supported");
        //Not supported
    }

    @Override
    public void drawTextOnPath(@NonNull char[] text, int index, int count, @NonNull Path path, float hOffset, float vOffset, @NonNull Paint paint) {
        Log.e("Measure","Not supported");
        //Not supported
    }

    @Override
    public void drawTextRun(@NonNull char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, @NonNull Paint paint) {
        Log.e("Measure","Not supported");
        //Not supported
    }

    @Override
    public void drawTextRun(@NonNull CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, @NonNull Paint paint) {
        Log.e("Measure","Not supported");
        //Not supported
    }

    @Override
    public void drawVertices(@NonNull VertexMode mode, int vertexCount, @NonNull float[] verts, int vertOffset, @Nullable float[] texs, int texOffset, @Nullable int[] colors, int colorOffset, @Nullable short[] indices, int indexOffset, int indexCount, @NonNull Paint paint) {
        Log.e("Measure","Not supported");
        //Not supported
    }

    @Override
    public void drawPaint(@NonNull Paint paint) {
        //Not needed
    }

    @Override
    public void setDrawFilter(@Nullable DrawFilter filter) {
        //Not needed
    }

    @Override
    public void drawARGB(int a, int r, int g, int b) {
        //Not needed
    }

    @Override
    public void drawColor(int color) {
        //not needed
    }

    @Override
    public void drawColor(int color, @NonNull PorterDuff.Mode mode) {
        //not needed
    }

    @Override
    public void drawRGB(int r, int g, int b) {
        //not needed
    }
}
