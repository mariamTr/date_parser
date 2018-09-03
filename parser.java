import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat; 
import java.text.DateFormat ; 
import java.util.Date;  
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class parser
{
  public static void main(String[] args)throws Exception
  {
  // set file path
  File file = new File("./text.txt");
  BufferedReader br = new BufferedReader(new FileReader(file));
  // initialize date list
  ArrayList<String> dateList = new ArrayList<String>();
  
  // reguler expression for dates in the form  month dd, yyyy
  String regex1= "(?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|Jun(?:e)?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)),?\\s{1}\\d{2},?\\s\\d{4}" ;
  // reguler  expression for dates in the form yyyy dd mm
  String regex2="\\d{4}\\s?\\D?\\d{2}\\s?\\D?\\d{2}";
  // reguler expression for dates with the format dd month yyyy
  String regex3= "\\d{2}\\s(?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|Jun(?:e)?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)),?\\s\\d{4}";
  // compile pattern
  Pattern pattern1 = Pattern.compile(regex1);
  Pattern pattern2 = Pattern.compile(regex2);
  Pattern pattern3 = Pattern.compile(regex3);
  // declare date formats
  SimpleDateFormat Format1 = new SimpleDateFormat("MMMM dd, yyyy" );
  SimpleDateFormat Format2 = new SimpleDateFormat("yyyy-M-dd");
  SimpleDateFormat Format3 = new SimpleDateFormat("dd MMMM yyyy" );
  SimpleDateFormat Format4 = new SimpleDateFormat("yyyy/MM/dd");

 



  String line , dateString ;
  Date date ; 

    while ((line = br.readLine()) != null){
      Matcher matcher1 = pattern1.matcher(line);
      Matcher matcher2 = pattern2.matcher(line);
      Matcher matcher3 = pattern3.matcher(line);
      while(matcher1.find()){
	int start= matcher1.start(0);
	int end = matcher1.end(0);
	dateString=line.substring(start,end);
	date = Format1.parse(dateString);
	dateList.add(Format4.format(date));
      }
      while(matcher2.find()){
	int start= matcher2.start(0);
	int end = matcher2.end(0);
	dateString=line.substring(start,end);
	date = Format2.parse(dateString);
	dateList.add(Format4.format(date));
      }
      while(matcher3.find()){
	int start= matcher3.start(0);
	int end = matcher3.end(0);
	dateString=line.substring(start,end);
	date = Format3.parse(dateString);
	dateList.add(Format4.format(date));
      }
    
    }
  
  Collections.sort(dateList);
  String str=dateList.get(0) ;
  String[] dateP=str.split("/") ;
  System.out.println(dateP[0]);
  dateList.remove(0);
  for(String s:dateList){
	String[] dates = s.split("/");
	if (dates[0].equals(dateP[0]) && dates[1].equals(dateP[1]) && dates[2].equals(dateP[2]) ){
		System.out.println(" ");
	}else if (dates[0].equals(dateP[0]) && dates[1].equals(dateP[1])){
		System.out.println("\n		" + dates[2] );
	}else if (dates[0].equals(dateP[0])){
		System.out.println("\n	" + dates[1]+ "\n		" + dates[2] );
	}else {
		System.out.println(dates[0] +"\n	" + dates[1]+ "\n		" + dates[2] );
	}
  dateP = s.split("/");

  }

  }
  
}
