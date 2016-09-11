import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class MilkPails {

	private static int goal;
	private static int secondSmallest;
	private static int smallest;

	public static int gotMilk(int xMax, int yMax) {
		int answer = 0;
		int maxAnswer = 0;
		for (int x = 0; x <= xMax; x++) {
			for (int y = 0; y <= yMax; y++) {
				answer = secondSmallest * y + smallest * x;
				if (answer > maxAnswer && answer <= goal) {
					maxAnswer = answer;
				}
			}
		}
		return maxAnswer;
	}

	public static void main(String[] args) throws IOException {
		PrintWriter writer = null;
		BufferedReader inputStream = null;
		LineNumberReader reader = null;
		try {
			String inputFile = "pails.in";
			inputStream = new BufferedReader(new FileReader(inputFile));
			writer = new PrintWriter("pails.out", "UTF-8");
			reader = new LineNumberReader(new FileReader(new File(inputFile)));
			reader.skip(Long.MAX_VALUE);

			String[] input = inputStream.readLine().split(" ");
			MilkPails.goal = Integer.parseInt(input[2]);
			MilkPails.secondSmallest = Integer.parseInt(input[1]);

			MilkPails.smallest = Integer.parseInt(input[0]);
			writer.write(new Integer(gotMilk(goal / smallest, goal
					/ secondSmallest)).toString());
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
