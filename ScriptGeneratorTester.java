import java.util.Scanner;

public class ScriptGeneratorTester {

	public static void main(String[] args) {
		
		double polarAngleStart = 0; // start angle in degrees
		double polarAngleStop = 180; // final angle in degrees
		double polarStepSize = 45; // stepsize in degrees
		double azimuthAngleStart = 0; // start angle in degrees
		double azimuthAngleStop = 320; // final angle in degrees
		double azimuthStepSize = 40; // stepsize in degrees
		double sphereRadius = 30; // radius of sphere in mm
		double focalLength = 40; // focal length of camera
		
		String scriptFileName = "c:\\temp\\Renderer.scr";
		String objectName = "Cylinder"; // name or description of CAD-Object
		
		new ScriptGenerator(scriptFileName, objectName, focalLength, sphereRadius, polarAngleStart, polarAngleStop, polarStepSize, azimuthAngleStart, azimuthAngleStop, azimuthStepSize).run();
		System.out.println("Wrote file: " + scriptFileName);

	}

}
