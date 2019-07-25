<img src="https://img.shields.io/github/license/JagarYousef/Mindo.svg" />
<br>
This android library intends to apply a view for Mind Maps / Hierarchy views easily in Android.
<br><br>
<center><img src="https://user-images.githubusercontent.com/41321155/58798331-051c1700-860b-11e9-9359-7a2b21eea069.gif"></img></center>
## Features: 

- Create complicated items and connections easily
- Flexibility (Custom connections, distance, full control of shapes)
- Save the view directly as an image



## Installation:

**Step 1.** Add it in your root build.gradle at the end of repositories:

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```groovy
	dependencies {
	        implementation 'com.github.JagarYousef:Mindo:2.0.0'
	}
```



## Quick Usage Guide:

1. Create a MindMappingView in your xml layout: 

```xml
<me.jagar.mindmappingandroidlibrary.Views.MindMappingView
    android:id="@+id/mind_mapping_view"
    android:background="#C4B8B8"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
<!---You need to add background to display connections-->
```

2. After initialization in the activity you can use it to add the root (Central Item) and other items  in parent/item pairs.



- Adding the central item: 

```java
Item item = new Item(MainActivity.this, "Root", "This is an root item", true);
mindMappingView.addCentralItem(item, false); //I didn't want to make the root drag able
```



- An example of adding an item where its parent is the root item:

```java
Item child = new Item(MainActivity.this, "Child", "This is a child", true);
mindMappingView.addItem(child, item, 200, 10, ItemLocation.TOP, true, null); //It will be drag able but there will not be a text on the connection between the root and the child
```



- Adding `ConnectionTextMessage` (the text on the connection between the item and its root):

```java
ConnectionTextMessage connectionTextMessage = new ConnectionTextMessage(MainActivity.this);
connectionTextMessage.setText("This message will be displayed on the connection between Child and Root");
mindMappingView.addItem(child, item, 200, 10, ItemLocation.TOP, true, connectionTextMessage); //It will be drag able and there will be a text on the connection between the root and the child
```



- Adding a `CustomConnection` in the case where there is no root and child: 

```java
mindMappingView.addCustomConnection(child1, ItemLocation.BOTTOM, child2, ItemLocation.RIGHT, connectionTextMessage,  5,"#000000", 10, 15);
```



- You can save the view easily as an image using this function: 

```java
//Do not forget the permissions
SaveAs.saveAsImage(MindMappingView, PATH_WHERE_IMAGE_WILL_BE_SAVED);
```



- If you set the item as drag able, you need a different way to add `OnClikcListener` for this item: 

```java
mindMappingView.setOnItemClicked(new OnItemClicked() {
    @Override
    public void OnClick(Item item) {
        item.setPressed(true);
        if (item == child){
            Toast.makeText(MainActivity.this, "child is clicked", Toast.LENGTH_LONG)
                    .show();
        }
        else if (item == root){
            Toast.makeText(MainActivity.this, "root is clicked", Toast.LENGTH_LONG)
                    .show();
        }
    }
});
```



## Zooming:

From version 2.0.0 you are able to include the MindMappingView inside a ZoomLayout that comes with too many options of  zooming and scrolling, BUT it is highly recommended to keep the MindMappingView in a fixed size when using this feature,  like the example below: 
```xml
<?xml version="1.0" encoding="utf-8"?>
<me.jagar.mindmappingandroidlibrary.Zoom.ZoomLayout xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    tools:context=".MainActivity"
    android:layout_gravity="center"
    android:gravity="center"
    android:layout_height="match_parent"
    android:scrollbars="vertical|horizontal"
    app:transformation="centerInside"
    app:transformationGravity="auto"
    app:alignment="center"
    app:overScrollHorizontal="true"
    app:overScrollVertical="true"
    app:overPinchable="true"
    app:horizontalPanEnabled="true"
    app:verticalPanEnabled="true"
    app:zoomEnabled="true"
    app:flingEnabled="false"
    app:scrollEnabled="true"
    app:oneFingerScrollEnabled="false"
    app:twoFingersScrollEnabled="true"
    app:threeFingersScrollEnabled="true"
    app:minZoom="0.7"
    app:minZoomType="zoom"
    app:maxZoom="2.5"
    app:maxZoomType="zoom"
    app:animationDuration="280"
    app:hasClickableChildren="true">
        <me.jagar.mindmappingandroidlibrary.Views.MindMappingView
            android:layout_width="1000dp"
            android:background="#C4B8B8"
            android:id="@+id/mind_mapping_view"
            android:layout_height="1000dp" />
</me.jagar.mindmappingandroidlibrary.Zoom.ZoomLayout>
```
You can  control the zoom layout programmatically like below:
```java
zoomLayout.panTo(x, y, true); // Shorthand for zoomLayout.getEngine().panTo(x, y, true)
zoomLayout.panBy(deltaX, deltaY, true);
zoomLayout.zoomTo(zoom, true);
zoomLayout.zoomBy(factor, true);
zoomLayout.realZoomTo(realZoom, true);
zoomLayout.moveTo(zoom, x, y, true);
```

## Customization:

The view, its items and the connection texts are extended from other views so all its features can be applied except `OnClickListener` in dragged items: 

| View                  | Extends        |
|-----------------------|----------------|
| Item                  | LinearLayout   |
| MindMappingView       | RelativeLayout |
| ConnectionTextMessage | TextView       |
| Item's Title          | TextView       |
| Item's Content        | TextView       |



## License:

```
Copyright (C) 2019 Jagar Yousef

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
```
