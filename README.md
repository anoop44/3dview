# 3dView 
[ ![Download](https://api.bintray.com/packages/anoop44/maven/awesome-textinput-layout/images/download.svg?version=1.0.0) ](https://bintray.com/anoop44/maven/awesome-textinput-layout/1.0.0/link) <a href="https://android-arsenal.com/api?level=16"><img alt="API" src="https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat"/></a>
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-3dView-green.svg?style=flat )]( https://android-arsenal.com/details/1/8050 )

A simple ViewGroup that adds 3d appearance to your view. It creates a [Cuboid](https://www.mathsisfun.com/geometry/cuboids-rectangular-prisms.html) shape and place the child in front
The 3d appearance can be configured to display on top right / top left / bottom right / bottom left. [Customization](https://github.com/anoop44/3dView#customization) section describes how to do that

### Demo
![Screenshot of 3dView demo](https://raw.githubusercontent.com/anoop44/3dView/master/art/3dview.png)



## Adding to project

### Gradle
Add below code to your **root** `build.gradle` file (if you have multiple modules and only one of them require `AwesomeNavigation`, add the `jcenter()` repository only in that module's `build.gradle`).
```gradle
allprojects {
    repositories {
        jcenter()
    }
}
```
And add the following dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
    implementation "ss.anoop:awesome-textinput-layout:${latest-version}"
}
```
`3dView` is added a the immediate parent of the view you want to decorate. Below is a simple example

## Usage
```xml
<ss.anoop.threedview.ThreeDView
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         app:x="5dp"
         app:y="-5dp">

         <!-- Your View Goes here --> />

    </ss.anoop.threedview.ThreeDView>
```
### Customization

Table below describes the properties available to customize the 3dView.


| Property Name          | Format    | Description |
|------------------------|-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| x                      | dimension | It horizontal 3d effect. Positive value will add the effect on right side and negative value will add it in the left side                           |
| y                      | dimension | It vertical 3d effect. Positive value will add the effect on bottom side and negative value will add it in the top side                           |
| strokeWidth            | dimension | Defines the width of border strokes|
| strokeColor            | dimension | Color of the stroke |


## Find this library useful? :heart:
Support it by joining __[stargazers](https://github.com/anoop44/3dView/stargazers)__ for this repository. :star:

# License
```
Copyright 2020 anoop44 (Anoop)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
