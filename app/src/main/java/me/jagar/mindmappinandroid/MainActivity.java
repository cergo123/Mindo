package me.jagar.mindmappinandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import me.jagar.mindmappingandroidlibrary.Helpers.SaveAs;
import me.jagar.mindmappingandroidlibrary.Listeners.OnItemClicked;
import me.jagar.mindmappingandroidlibrary.Views.ConnectionTextMessage;
import me.jagar.mindmappingandroidlibrary.Views.Item;
import me.jagar.mindmappingandroidlibrary.Views.ItemLocation;
import me.jagar.mindmappingandroidlibrary.Views.MindMappingView;


public class MainActivity extends AppCompatActivity {

    private MindMappingView mindMappingView;
    private int ALL_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mindMappingView = findViewById(R.id.mind_mapping_view);

        Item item = new Item(MainActivity.this, "title", "content", true);
        final Item child = new Item(MainActivity.this, "child0", "child content0", true);
        final Item child2 = new Item(MainActivity.this, "child2", "child content2", true);
        Item child3 = new Item(MainActivity.this, "child3", "child content3", true);
        Item child4 = new Item(MainActivity.this, "child4", "child content4", true);
        final Item item1 = new Item(MainActivity.this, "Test Item", "Test", true);
        child.setBackgroundResource(R.drawable.fancy_bg);
        child.getTitle().setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        child.getContent().setTextColor(ContextCompat.getColor(MainActivity.this, R.color.yellow));

        mindMappingView.addCentralItem(item, false);

        ConnectionTextMessage connectionTextMessage = new ConnectionTextMessage(MainActivity.this);
        connectionTextMessage.setText("Msg0");
        connectionTextMessage.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
        connectionTextMessage.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        connectionTextMessage.setPadding(5,5,5, 5);

        ConnectionTextMessage connectionTextMessage2 = new ConnectionTextMessage(MainActivity.this);
        connectionTextMessage2.setText("Msg2");
        connectionTextMessage2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
        connectionTextMessage2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        connectionTextMessage2.setPadding(5,5,5, 5);

        ConnectionTextMessage connectionTextMessage3 = new ConnectionTextMessage(MainActivity.this);
        connectionTextMessage3.setText("Msg3");
        connectionTextMessage3.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
        connectionTextMessage3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        connectionTextMessage3.setPadding(5,5,5, 5);

        ConnectionTextMessage connectionTextMessage4 = new ConnectionTextMessage(MainActivity.this);
        connectionTextMessage4.setText("Msg4");
        connectionTextMessage4.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
        connectionTextMessage4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        connectionTextMessage4.setPadding(5,5,5, 5);

        ConnectionTextMessage test = new ConnectionTextMessage(MainActivity.this);
        test.setText("This is a very \n long text, and it could \n be even longer \nCheers");
        test.setBackgroundResource(R.drawable.txt_msg_bg);
        test.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.gray));

        mindMappingView.setConnectionWidth(3);
        mindMappingView.setConnectionCircRadius(5);
        mindMappingView.setConnectionArrowSize(40);




        mindMappingView.setOnItemClicked(new OnItemClicked() {
            @Override
            public void OnClick(Item item) {
                if (item == child){
                    item.setPressed(true);
                    Toast.makeText(MainActivity.this, "Child is clicked", Toast.LENGTH_LONG)
                            .show();
                }
                else if (item == item1){
                    item.setPressed(true);
                    Toast.makeText(MainActivity.this, "item1 is clicked", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        mindMappingView.addItem(child, item, 200, 10, ItemLocation.TOP, true, null);
        mindMappingView.addItem(child2, item, 200, 10, ItemLocation.LEFT, true, null);
        mindMappingView.addItem(child3, item, 200, 10, ItemLocation.RIGHT, true, null);
        mindMappingView.addItem(child4, item, 400, 10, ItemLocation.BOTTOM, true, null);
        mindMappingView.addItem(item1, child2, 400, 50, ItemLocation.BOTTOM, true, test);

        //mindMappingView.setConnectionColor("#");

        mindMappingView.addCustomConnection(child3, ItemLocation.BOTTOM, item1, ItemLocation.RIGHT, connectionTextMessage,  5,
                "#000000", 10, 15);

        ConnectionTextMessage ideaConnection = new ConnectionTextMessage(MainActivity.this);
        ideaConnection.setBackgroundResource(R.drawable.idea_bg);
        Drawable ideaLight = MainActivity.this.getDrawable(R.drawable.ic_lightbulb_outline_black_24dp);
        ideaConnection.setCompoundDrawablesWithIntrinsicBounds(ideaLight, null, null, null);
        ideaConnection.setGravity(Gravity.CENTER);
        ideaConnection.setText("Icon");
        Item leave1 = new Item(MainActivity.this, "This is leave 1", null, true);
        Item leave2 = new Item(MainActivity.this, "This is leave 2", null, true);
        Item leave3 = new Item(MainActivity.this, "This is leave 3", null, true);
        Item leave4 = new Item(MainActivity.this, "This is leave 4", null, true);
        Item leave5 = new Item(MainActivity.this, "This is leave 5", null, true);



        mindMappingView.addItem(leave1, child3, 200, 0, ItemLocation.RIGHT,  true, ideaConnection);
        mindMappingView.addItem(leave2, child3, 200, 0, ItemLocation.RIGHT,  true, null);
        mindMappingView.addItem(leave3, child3, 200, 0, ItemLocation.RIGHT,  true, null);
        mindMappingView.addItem(leave4, child3, 200, 0, ItemLocation.RIGHT,  true, null);
        mindMappingView.addItem(leave5, child3, 200, 0, ItemLocation.RIGHT,  true, null);


        Item leave6 = new Item(MainActivity.this, "This is leave 6", null, false);
        Item leave7 = new Item(MainActivity.this, "This is leave 7", null, false);
        Item leave8 = new Item(MainActivity.this, "This is leave 8", null, false);

        Drawable infoDrawable = MainActivity.this.getDrawable(R.drawable.ic_info_black_24dp);
        leave7.getTitle().setCompoundDrawablesWithIntrinsicBounds(null, infoDrawable, null, null);
        leave8.getTitle().setCompoundDrawablesWithIntrinsicBounds(null, infoDrawable, null, null);
        leave6.getTitle().setCompoundDrawablesWithIntrinsicBounds(null, infoDrawable, null, null);

        mindMappingView.addItem(leave6, child2, 200, 0, ItemLocation.LEFT,  true, null);
        mindMappingView.addItem(leave7, child2, 200, 0, ItemLocation.LEFT,  true, null);
        mindMappingView.addItem(leave8, child2, 200, 0, ItemLocation.LEFT,  true, null);


       mindMappingView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                checkPermissions();
                return false;
            }
        });



    }

    private void checkPermissions() {
        //Permissions we need
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        //Permissions that we will ask for
        ArrayList<String> needed_permissions = new ArrayList<>();

        //Check which is not granted yet
        for (String permission : permissions){
            if (ContextCompat.checkSelfPermission(MainActivity.this, permission) !=
                    PackageManager.PERMISSION_GRANTED){
                needed_permissions.add(permission);
            }
        }

        //Ask for multiple not granted permissions
        if(!needed_permissions.isEmpty())
            ActivityCompat.requestPermissions(MainActivity.this, needed_permissions.toArray(new String[needed_permissions.size()]), ALL_PERMISSIONS);
        else
            SaveAs.saveAsImage(mindMappingView, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +
                    "image.jpg");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ALL_PERMISSIONS){
            if ((grantResults.length > 0) &&
                    (grantResults[0]
                            + grantResults[1] == PackageManager.PERMISSION_GRANTED)){
                SaveAs.saveAsImage(mindMappingView, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +
                        "image.jpg");

            }else {
                Toast.makeText(MainActivity.this, "All permissions need to be granted", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
}
