#!/bin/bash

# Run the Rubik's Cube application
# Usage: ./run.sh [arguments]
# Example: ./run.sh "F F D D L L"
# Example: ./run.sh -m "F F D D L L"

JAR_FILE="target/rubik.jar"
NATIVES_DIR="natives"

if [ ! -f "$JAR_FILE" ]; then
    echo "JAR file not found. Building project..."
    mvn clean package
fi

# Extract native libraries if they don't exist
if [ ! -d "$NATIVES_DIR/linux-amd64" ]; then
    echo "Extracting native libraries..."
    mkdir -p "$NATIVES_DIR"
    # Extract natives from JAR (they're stored as natives/linux-amd64/ in the JAR)
    cd "$NATIVES_DIR"
    jar -xf "../$JAR_FILE" natives/
    # Move from natives/natives/linux-amd64 to natives/linux-amd64
    if [ -d "natives/linux-amd64" ]; then
        mv natives/linux-amd64 .
        rm -rf natives
    fi
    cd ..
fi

# Set library path to include natives
export LD_LIBRARY_PATH="$PWD/$NATIVES_DIR/linux-amd64:$LD_LIBRARY_PATH"

# Run the application
java -Djava.library.path="$PWD/$NATIVES_DIR/linux-amd64" -jar "$JAR_FILE" "$@"

