# Rubik's Cube Solver

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)
![Processing](https://img.shields.io/badge/Processing-3.5.4-lightgrey.svg)
![JOGL](https://img.shields.io/badge/JOGL-2.3.2-green.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## Description

A 3D Rubik's Cube solver application that visualizes the solving process in real-time. This project implements a complete solver algorithm that can solve any scrambled Rubik's cube configuration. The application features an interactive 3D visualization using Processing and JOGL, allowing you to watch the cube being solved step by step.

### Key Features

- **Complete Solver Algorithm**: Automatically solves any scrambled Rubik's cube
- **3D Visualization**: Real-time 3D rendering of the cube with interactive camera controls
- **Layer-by-Layer Solving**: Step-by-step solving process with visual feedback
- **Custom Numeration System**: Each minicube part has a specific numeration for precise tracking
- **Interactive Controls**: Manual cube manipulation and solver controls

## Vector's Faces Numeration

All minicube parts have specific numeration. The cube is represented as a vector with 54 faces (9 faces × 6 sides). Each face has a unique number:

### UP
```
0  1  2
7  x  3
6  5  4
```

### FRONT
```
 8  9 10
15  x 11
14 13 12
```

### RIGHT
```
16 17 18
23  x 19
22 21 20
```

### BACK
```
24 25 26
31  x 27
30 29 28
```

### LEFT
```
32 33 34
39  x 35
38 37 36
```

### DOWN
```
40 41 42
47  x 43
46 45 44
```

## Controls

### Solver Controls
- **1** - Run initial sequence
- **2** - Run solver (complete solution)
- **3** - Run solver first layer
- **4** - Run solver second layer
- **5** - Run solver third layer corners
- **6** - Run solver third layer cross
- **7** - Exit

### Manual Cube Rotation
- **UP**: `e` (clockwise), `r` (counter-clockwise)
- **FRONT**: `d` (clockwise), `f` (counter-clockwise)
- **RIGHT**: `g` (clockwise), `h` (counter-clockwise)
- **BACK**: `j` (clockwise), `k` (counter-clockwise)
- **DOWN**: `x` (clockwise), `c` (counter-clockwise)
- **LEFT**: `a` (clockwise), `s` (counter-clockwise)

## Demo

![Rubik's Cube Solver in Action](demo.gif)

*GIF showing the program solving a Rubik's cube in real-time*

## Building and Running

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Build

```bash
mvn clean package
```

### Run

```bash
./run.sh "F F D D L L"
```

Or with the move printing flag:

```bash
./run.sh -m "F F D D L L"
```

You can also run directly with Java:

```bash
java -jar target/rubik.jar "F F D D L L"
```

### Usage

The application accepts a sequence of moves as arguments:
- `F` - Front face clockwise
- `F'` - Front face counter-clockwise
- `F2` - Front face 180 degrees
- Similar notation for `U`, `D`, `L`, `R`, `B` faces

Example sequences:
- `"F F D D L L"` - Simple scramble
- `"R U R' U' R' F R F'"` - T-perm algorithm
- `-m "F F"` - Print vector cube moves

## Project Structure

```
rubik/
├── src/main/java/
│   ├── Main.java           # Entry point
│   ├── Cube.java           # 3D visualization and rendering
│   ├── Cubies.java          # Cube state management and solver
│   ├── Movements.java       # Move definitions
│   └── ...
├── src/main/resources/
│   ├── core.jar            # Processing core library
│   └── peasycam.jar        # PeasyCam camera control
├── pom.xml                 # Maven configuration
└── run.sh                  # Run script
```

## Technologies Used

- **Java 21**: Modern Java features and performance
- **Processing 3.5.4**: 3D graphics and visualization framework
- **JOGL 2.3.2**: Java bindings for OpenGL
- **PeasyCam**: Interactive camera controls for 3D scenes
- **Maven**: Build automation and dependency management

## License

This project is open source and available under the MIT License.

