package me.jagar.mindmappingandroidlibrary.Views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Item extends LinearLayout {

    Context context;
    TextView title;
    TextView content;
    boolean defaultStyle;
    ArrayList<Item> topChildItems = new ArrayList<>();
    ArrayList<Item> bottomChildItems = new ArrayList<>();
    ArrayList<Item> rightChildItems = new ArrayList<>();
    ArrayList<Item> leftChildItems = new ArrayList<>();
    HashMap<Connection, Integer> connections = new HashMap<>();
    HashMap<Item, Integer>  parents = new HashMap<>();

    public Item(Context context, String title, String content, boolean defaultStyle){
        super(context);
        this.context = context;
        this.defaultStyle = defaultStyle;
        this.setTitle(title);
        this.setContent(content);
        this.addTextViews();

        if (title == null)
            this.title.setVisibility(GONE);
        if (content == null)
            this.content.setVisibility(GONE);

    }

    public Item(Context context) {
        super(context);
        this.context = context;
    }

    public Item(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setTitle(String title){
        this.title = new TextView(context);
        this.getTitle().setText(title);
        this.getTitle().setTypeface(Typeface.DEFAULT_BOLD);
    }
    public void setContent(String content){
        this.content = new TextView(context);
        this.getContent().setText(content);
        this.getContent().setTypeface(Typeface.DEFAULT);
    }
    public void setBorder(int color, int size){
        GradientDrawable drawable = (GradientDrawable)this.getBackground();
        drawable.setStroke(size, color);
    }

    public void addTopChild(Item item){
        topChildItems.add(item);
    }
    public ArrayList<Item> getTopChildItems(){
        return topChildItems;
    }
    public Item getTopChildByIndex(int index){
        return topChildItems.get(index);
    }

    public void addBottomChild(Item item){
        bottomChildItems.add(item);
    }
    public ArrayList<Item> getBottomChildItems(){
        return bottomChildItems;
    }
    public Item getBottomChildByIndex(int index){
        return bottomChildItems.get(index);
    }

    public void addRightChild(Item item){
        rightChildItems.add(item);
    }
    public ArrayList<Item> getRightChildItems(){
        return rightChildItems;
    }
    public Item getRightChildByIndex(int index){
        return rightChildItems.get(index);
    }

    public void addLeftChild(Item item){
        leftChildItems.add(item);
    }
    public ArrayList<Item> getLeftChildItems(){
        return leftChildItems;
    }
    public Item getLeftChildByIndex(int index){
        return leftChildItems.get(index);
    }
    public TextView getTitle(){
        return this.title;
    }
    public TextView getContent(){
        return this.content;
    }

    private void addTextViews(){
        this.setOrientation(LinearLayout.VERTICAL);
        this.addView(title);
        this.addView(content);

        if (defaultStyle)
            setDefaultStyle();

    }

    //If the item default style is true
    private void setDefaultStyle(){
        GradientDrawable shape = new GradientDrawable();
        shape.setColor(Color.GRAY);
        shape.setCornerRadius(100);
        this.setBackground(shape);
        this.setBorder(Color.BLACK, 5);
        this.setGravity(Gravity.CENTER);
        this.title.setGravity(Gravity.CENTER);
        this.content.setGravity(Gravity.CENTER);

        this.setPadding(50, 20, 50, 20);

    }

    public void addParent(Item parent, int location){
        parents.put(parent, location);
    }

    public HashMap<Item, Integer> getParents(){
        return parents;
    }

    public void addConnection(Item parent, int location, ConnectionTextMessage connectionTextMessage){
        Connection connection = new Connection(this, parent, connectionTextMessage);
        connections.put(connection, location);
    }
    public HashMap<Connection, Integer> getAllConnections(){
        return connections;
    }

    public Connection getConnectionByParent(Item parent){
        if (connections.keySet().iterator().hasNext()){
            Connection con = connections.keySet().iterator().next();
            if (con.getParent() == parent)
                return con;
        }
        return null;
    }

}
