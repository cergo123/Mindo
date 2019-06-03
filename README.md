This android library intends to apply a view for Mind Maps / Hierarchy views easily in Android.

<center><img src="https://user-images.githubusercontent.com/41321155/58769543-b3df3980-85b0-11e9-84d5-4815636677e5.png"></img></center>

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
	        implementation 'com.github.JagarYousef:Mindo:1.0.0'
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
