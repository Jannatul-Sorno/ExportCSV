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
	public int numberOfExporters(CSVParser parser, String exportItem)
	{
		int count = 0;
		for(CSVRecord record : parser)
		{
			String exports = record.get("Exports");
			
			if(exports.contains(exportItem))
			{
				count++;
			}
		}
		return count;
	}
	public void bigExporters(CSVParser parser, String amount)
	{
		for(CSVRecord record : parser)
		{
			String value = record.get("Value (dollars)");
			
			if(value.length() > amount.length())
			{
				System.out.println(record.get("Country") + ": " + record.get("Value (dollars)") );
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
		
		parser = fr.getCSVParser();
		int count = numberOfExporters(parser, "gold");
		System.out.println(count);
		
		parser = fr.getCSVParser();
		bigExporters(parser, "$999,999,999");
	}
	public static void main(String[] args)
	{
		ExportData e = new ExportData();
		e.tester();
	}
}