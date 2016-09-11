import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class CircularBarn {

	private static int room;
	private static int[] roomCounts;

	public static int cowOverTheMoon(int initRoom) {
		int numOfDoors = 0;
		int totalRooms = 0;
		for (int i = initRoom; i < roomCounts.length; i++) {
			totalRooms = totalRooms + (roomCounts[i] * numOfDoors);
			numOfDoors++;
		}
		for (int i = 0; i < initRoom; i++) {
			totalRooms = totalRooms + (roomCounts[i] * numOfDoors);
			numOfDoors++;
		}
		return totalRooms;
	}

	public static void main(String[] args) throws IOException {
		PrintWriter writer = null;
		BufferedReader inputStream = null;
		LineNumberReader reader = null;
		try {
			String inputFile = "cbarn.in";
			inputStream = new BufferedReader(new FileReader(inputFile));
			writer = new PrintWriter("cbarn.out", "UTF-8");
			int randomNumero = 0;
			String currentline;
			int totalRoom = Integer.parseInt(inputStream.readLine());
			room = totalRoom;
			int[] input = new int[room];
			while ((currentline = inputStream.readLine()) != null) {
				input[randomNumero] = Integer.parseInt(currentline);
				randomNumero++;
			}
			roomCounts = input;
			int distance;
			int farthest;
			distance = farthest = cowOverTheMoon(0);
			for (int i = 1; i < totalRoom; i++) {
				distance = cowOverTheMoon(i);
				if (distance < farthest) {
					farthest = distance;
				}
			}
			writer.write(farthest + "");
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (writer != null) {
				writer.close();
			}
			if (reader != null) {
				reader.close();
			}
		}

	}
}
