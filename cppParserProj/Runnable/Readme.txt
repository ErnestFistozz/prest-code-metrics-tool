Run using:
java -jar CppParser.jar -parse <input file/directory> -out <output directory>

-includeStructs parameter can be added to allow parser to add structs with classes to the Class csv file

If output directory is not defined input directory will be used.
If directories contain spaces then they should be put in quotes.
----------------------------
Example
1. Download Ogre 1.8.1 from 
https://sourceforge.net/projects/ogre/files/ogre/1.8/1.8.1/ogre_src_v1-8-1.exe/download 
2. Extract it to a folder eg c:\Ogre 3d
3. Then run the parser from command line using:
java -jar CppParser.jar -parse "c:\Ogre 3d" -out "c:\Ogre 3d\outputs"