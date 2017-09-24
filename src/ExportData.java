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
	public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
	{
		for(CSVRecord record : parser)
		{
			String exports = record.get("Exports");
			
			if(exports.contains(exportItem1) && exports.contains(exportItem2))
			{
				String currentCountry = record.get("Country");
				System.out.println(currentCountry);
			}
		}
	}
	public void tester()
	{
		FileResource fr = new FileResource();
		
		CSVParser parser = fr.getCSVParser();
		String result = countryInfo(parser, "Peru");
		System.out.println(result);
		
		parser = fr.getCSVParser();
		listExportersTwoProducts(parser, "gold", "diamonds");
	}
	public static void main(String[] args)
	{
		ExportData e = new ExportData();
		e.tester();
	}
}