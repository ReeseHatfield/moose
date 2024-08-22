#!/bin/bash

if [ $# -eq 0 ]
then
    echo "Please supply name file"
    exit 1
fi


SRC_DIR="src"
BIN_DIR="bin"

# clean old bin
rm -rf "$BIN_DIR"

mkdir -p "$BIN_DIR"

# Compile Java files
javac -d "$BIN_DIR" "$SRC_DIR"/**/*.java "$SRC_DIR"/*.java

java -cp "$BIN_DIR" Driver $1
