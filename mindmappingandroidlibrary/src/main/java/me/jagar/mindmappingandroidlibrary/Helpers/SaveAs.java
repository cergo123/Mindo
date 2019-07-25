package me.jagar.mindmappingandroidlibrary.Helpers;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import me.jagar.mindmappingandroidlibrary.Views.MindMappingView;

public class SaveAs {

    public static void saveAsImage(MindMappingView mindMappingView, String path){

        mindMappingView.setDrawingCacheEnabled(true);
        mindMappingView.buildDrawingCache();
        Bitmap bm = null;
        if (mindMappingView.getDrawingCache() == null){
            bm = loadLargeBitmapFromView(mindMappingView);
        }else{
            bm = Bitmap.createBitmap(mindMappingView.getDrawingCache());
        }
        mindMappingView.setDrawingCacheEnabled(false); // clear drawing cache
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpg");

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        File f = new File(path);

        try {
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Bitmap loadLargeBitmapFromView(View v)
    {
        Bitmap b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }
}
