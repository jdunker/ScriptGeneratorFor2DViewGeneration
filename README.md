# ScriptGeneratorFor2DViewGeneration
.  
The image generator works for a German version of Autocad. It’s a Java-program. You can specify the azimuth- and polar-angles with stepwidths, the radius of the view sphere and further settings in the ScriptGeneratorTester-File. In the ScriptGenerator-class a script file is generated (Renderer.scr) which can be loaded into Autocad with the autocad „script“-command in the Autocad-command line. The script can then be executed and all the image-files in the GeneratedImageFiles-Directory can then be generated. The process takes a few seconds only.
