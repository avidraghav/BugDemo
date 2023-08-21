# Steps to reproduce the bug
1. Open the project in Android Studio. I used `Android Studio Electric Eel | 2022.1.1 Build #AI-221.6008.13.2211.9477386`. The bug is reproducable in newer versions too
2. Open MainActivity.kt in which `DemoLayout` is present whose pictographic arrangement is given at the end.
3. Run the project in any emulator or physical device.
2. Open the Layout Inspector to see the Recomposition counts
3. Start typing any text in the `OutlinedTextField`.
4. The recomposition counts of `OutlinedTextField` increases which is expected 
   but the recomposition counts of `Image` also increases which is neither expected and nor should it happen.
   To draw parallels, there is also a `Box` composable present in the same Row as Image but that doesn't recomposes too
   which is the main reason to reach to a conclusion that there is a bug in the Image Composable of the `androidx.compose.foundation` library

# Video showing recomposition counts


https://user-images.githubusercontent.com/49483235/222891367-44ae5db4-b8af-475f-8a34-561684066eb3.mov

# DemoLayout in MainActivity.kt
<img src="https://user-images.githubusercontent.com/49483235/222890115-e9df92d6-e84d-465e-9f5b-368c03d12400.png" width="600" height="600">
