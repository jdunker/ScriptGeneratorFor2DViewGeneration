import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ScriptGenerator {
private		double polarAngleStart; // start angle in degrees
private		double polarAngleStop; // final angle in degrees
private		double polarStepSize; // stepsize in degrees
private		double azimuthAngleStart; // start angle in degrees
private		double azimuthAngleStop; // final angle in degrees
private		double azimuthStepSize; // stepsize in degrees
private		double sphereRadius; // radius of sphere in mm
private 	double focalLength;  // focal length of camera
private 	String scriptFileName;	
private 	String objectName; // name of CAD object
	
	public ScriptGenerator(String scriptFileName, String objectName, double focalLength, double sphereRadius, double polarAngleStart, double polarAngleStop, double polarStepSize, double azimuthAngleStart, double azimuthAngleStop, double azimuthStepSize) {
		this.scriptFileName = scriptFileName;
		this.objectName = objectName;
		this.focalLength = focalLength;
		this.sphereRadius  = sphereRadius;
		this.polarAngleStart = polarAngleStart;
		this.polarAngleStop = polarAngleStop;
		this.polarStepSize = polarStepSize;
		this.azimuthAngleStart = azimuthAngleStart;
		this.azimuthAngleStop = azimuthAngleStop;
		this.azimuthStepSize = azimuthStepSize;
	}
	
	public void run() {
		double azimuthAngle, polarAngle;
		try {
			PrintWriter pw = new PrintWriter(scriptFileName);
			for(polarAngle = polarAngleStart; polarAngle <=polarAngleStop; polarAngle+=polarStepSize)
				for(azimuthAngle = azimuthAngleStart; azimuthAngle <= azimuthAngleStop; azimuthAngle+=azimuthStepSize)
					generateFileEntry(pw, polarAngle, azimuthAngle);			
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to open: " + scriptFileName);
			e.printStackTrace();
		}
			
	}
	
	
	public void generateFileEntry(PrintWriter pw, double polarAngle, double azimuthAngle) {
		double polarAngleInRad = Math.toRadians(polarAngle);
		double azimuthAngleInRad = Math.toRadians(azimuthAngle);
		double x = xFromSphereCoordinates(azimuthAngleInRad, polarAngleInRad);
		double y = yFromSphereCoordinates(azimuthAngleInRad, polarAngleInRad);
		double z = zFromSphereCoordinates(azimuthAngleInRad, polarAngleInRad);
		String filename = "c:\\temp\\CAD_"+ objectName + "_" + sphereRadius + "_" + azimuthAngle + "_" + polarAngle + ".jpeg";		
		pw.println("_camera");
		pw.println(""+x+","+y+","+z);
		pw.println("0,0,0");
		pw.println("B");
		pw.println(""+focalLength);
		pw.println("N");
		pw.println("Renderkamera");
		pw.println("A");
		pw.println("J");
		pw.println("-render");
		pw.println("mittel");
		pw.println("Renderfenster");
		pw.println("1280");
		pw.println("1024");
		pw.println("ja");
		pw.println(filename);		
	}
	
	public double xFromSphereCoordinates(double azimuthAngle, double polarAngle) {
		return sphereRadius * Math.sin(polarAngle)*Math.cos(azimuthAngle);
	}
	public double yFromSphereCoordinates(double azimuthAngle, double polarAngle) {
		return sphereRadius * Math.sin(polarAngle)*Math.sin(azimuthAngle);
	}
	public double zFromSphereCoordinates(double azimuthAngle, double polarAngle) {
		return sphereRadius * Math.cos(polarAngle);
	}

}
/*
 * Example-Entry for German Autocad
 * 
_camera
0.0,0.0,50.0
0,0,0
B
10.0
N
Renderkamera
A
J
-render
mittel
Renderfenster
1280
1024
ja
c:\temp\CAD_Zylinder_50.0_0.0_0.0.jpeg 
*/
