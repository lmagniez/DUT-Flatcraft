#!/bin/bash

if [ ! -d "bin" ]; then
   mkdir bin
fi

find src -name *.java -print >files.tocompile

javac -encoding ISO-8859-1 -cp bin -d bin @files.tocompile 
cp -R src/textures bin
jar cmf manifest.mf flatcraft.jar -C bin .
