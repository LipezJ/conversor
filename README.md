# Conversor 💱
Set of classes that allow generating unit converters

### About
This project is mainly done to generate a unit converter mainly for currencies, but throughout the development of the code with the OOP paradigm I realized that I could generate a set of classes that allowed to create linear and non-linear unit converters. linear with few lines of code.

Also during the development of the project I created a command line tool to handle simple java projects, and I decided to make this project using my tool. **[jv☕](https://github.com/LipezJ/jv)**

### How to use
To use it you can download the .jar file found in the Bin folder inside the root directory, with it you can now run the program, it should be noted that you must have java installed to run it.

![image](https://lh3.googleusercontent.com/u/0/drive-viewer/AAOQEORGj0gSiHDeGYage2wy4iUvBeP3uwWUMBrbgi1XvVglepn7G3kc45jEiExB7a2ISR_L_HgraCJWqdLoqu1znJtr0nSsyA=w1366-h657)

### How it works
The program uses a package called "Base" which contains abstract classes that are utilized by two types of converters, linear and non-linear. The converters are separated into two classes to keep the code for the simpler converter as straightforward as possible, while the non-linear converter's code is slightly more complex since it doesn't have a unitary relation for each value. Instead, it has a function that transforms one unit to another.

Now that the program's base is established with the package of abstract classes, the converters' classes can be generated. Both converters have similar functions but differ in the data structure used to store the units and/or functions.

The data structure used in both classes resembles an adjacency matrix, where each node represents a unit and the edges' weights represent the rate of change, the value to make the change, or the function that acts.

Finally, in the utilities and interface package, the converters are imported, initialized, and the data provided is managed to enable clients to use the program.

The project will have a structure with:

![image](https://lh3.googleusercontent.com/u/0/drive-viewer/AAOQEOQT37-1keE_OgioKYWXuFzpjDFfMITmLdqbvVLumSHTPs-oVx-u-aGXTCdTI6m7lQ860RVEOLVIvxY7ZtcDRS2WqxPFCw=w1366-h657)
