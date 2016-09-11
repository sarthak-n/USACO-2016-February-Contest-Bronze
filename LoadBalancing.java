import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class LoadBalancing {

	public static void main(String[] args) throws IOException {
		PrintWriter writer = null;
		BufferedReader inputStream = null;
		LineNumberReader reader = null;

		try {
			String inputFile = "balancing.in";
			inputStream = new BufferedReader(new FileReader(inputFile));
			writer = new PrintWriter("balancing.out", "UTF-8");
			reader = new LineNumberReader(new FileReader(new File(inputFile)));
			reader.skip(Long.MAX_VALUE);

			String[] input = new String[reader.getLineNumber() + 1];
			int randomNumero = 0;
			String currentline;
			String[] line = (inputStream.readLine().split(" "));

			int[][] spots = new int[Integer.parseInt(line[0])][2];
			int sumX = 0;
			int sumY = 0;
			while ((currentline = inputStream.readLine()) != null) {
				input[randomNumero] = currentline;
				String[] splitted = input[randomNumero].split(" ");
				spots[randomNumero][0] = Integer.parseInt(splitted[0]);
				spots[randomNumero][1] = Integer.parseInt(splitted[1]);
				sumX = sumX + spots[randomNumero][0];
				sumY = sumY + spots[randomNumero][1];

				randomNumero++;
			}

			int totalMax = 100;
			for (int xCoord = 2; xCoord < Integer.parseInt(line[0]); xCoord = xCoord + 2) {
				for (int yCoord = 2; yCoord < Integer.parseInt(line[0]); yCoord = yCoord + 2) {
					int quadrants[] = new int[4];
					int upperBound = 0;
					for (int i = 0; i < Integer.parseInt(line[0]); i++) {
						if (spots[i][0] > xCoord) {
							if (spots[i][1] > yCoord) {
								quadrants[0]++;
								if (quadrants[0] > upperBound) {
									upperBound = quadrants[0];
								}
							} else {
								quadrants[1]++;
								if (quadrants[1] > upperBound) {
									upperBound = quadrants[1];
								}
							}
						} else if (spots[i][0] < xCoord) {
							if (spots[i][1] < yCoord) {
								quadrants[2]++;
								if (quadrants[2] > upperBound) {
									upperBound = quadrants[2];
								}
							} else {
								quadrants[3]++;
								if (quadrants[3] > upperBound) {
									upperBound = quadrants[3];
								}
							}
						}
					}
					if (totalMax > upperBound) {
						totalMax = upperBound;
					}
				}
			}
			writer.write(totalMax + "");
		} finally {
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
