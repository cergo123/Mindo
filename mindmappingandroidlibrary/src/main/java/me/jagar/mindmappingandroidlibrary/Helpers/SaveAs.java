package me.jagar.mindmappingandroidlibrary.Helpers;


import android.content.Intent;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import me.jagar.mindmappingandroidlibrary.Views.MindMappingView;

public class SaveAs {

    public static void saveAsImage(MindMappingView mindMappingView, String path){

        mindMappingView.setDrawingCacheEnabled(true);
        mindMappingView.buildDrawingCache();
        Bitmap bm = Bitmap.createBitmap(mindMappingView.getDrawingCache());
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
}
