import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData {
	
	public String countryInfo(CSVParser parser, String country)
	{
		for(CSVRecord record : parser)
		{
			String currentCountry = record.get("Country");
			if(currentCountry.contains(country))
			{
				return country + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
			}
		}
		return "NOT FOUND";
	}
	public void tester()
	{
		FileResource fr = new FileResource();
		
		CSVParser parser = fr.getCSVParser();
		String result = countryInfo(parser, "Peru");
		System.out.println(result);
	}
	public static void main(String[] args)
	{
		ExportData e = new ExportData();
		e.tester();
	}
}