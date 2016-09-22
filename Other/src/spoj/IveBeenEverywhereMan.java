package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author namtran
 */
public class IveBeenEverywhereMan {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCases; i++) {
			int numberOfTrips = Integer.parseInt(reader.readLine());
			String trips = "";
			int citiesVisited = 0;
			for (int j = 0; j < numberOfTrips; j++) {
				String city = reader.readLine();
				if (!trips.contains(city)) {
					trips += city;
					citiesVisited++;
				}
			}
			System.out.println(citiesVisited);
		}

	}

}
