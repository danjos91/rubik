#!/bin/bash

# Run the Rubik's Cube application
# Usage: ./run.sh [arguments]
# Example: ./run.sh "F F D D L L"
# Example: ./run.sh -m "F F D D L L"

JAR_FILE="target/rubik.jar"

if [ ! -f "$JAR_FILE" ]; then
    echo "JAR file not found. Building project..."
    mvn clean package
fi

java -jar "$JAR_FILE" "$@"

