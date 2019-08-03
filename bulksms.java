import java.net.*;
import java.util.*;
import java.io.*;
class bulksms {
  public static void main(String[] args) {
try {
  // www.proovl.com API settings
String user = "***********";  // Proovl USER ID
String token = "**********"; // Proovl API token
String from = "***********";  // Proovl SMS number
String text = "***********";   // text message
 // Numbers, one per line 
String[] numbers = new String[] { 
  "445555555555", 
  "445555555555"
  };
for (String to : numbers) {
String charset = "UTF-8";
String query = String.format("http://www.proovl.com/api/send.php?user=%s&token=%s&from=%s&text=%s&to=%s", 
     URLEncoder.encode(user, charset), 
     URLEncoder.encode(token, charset),
     URLEncoder.encode(from, charset),
     URLEncoder.encode(text, charset),
     URLEncoder.encode(to, charset));
  URL url = new URL(query);
  HttpURLConnection dd = (HttpURLConnection)url.openConnection();
  BufferedReader reader = new BufferedReader(new InputStreamReader(dd.getInputStream()));
  System.out.println("Progress details: \033[0;32m" + dd.getResponseMessage() + "\033[0m");
  String output = reader.readLine();
  String[] parts = output.split(";");
 if (parts[0].equals("Error"))
        { 
          System.out.println("\033[0;31mError! Message not sent: " + to + " " + parts[1] + "\033[0m");
        }
 else {
           System.out.println("\033[0;32mMessage has been sent: " + to + " " + parts[1] + "\033[0m");      
 }
       dd.disconnect(); 
       }
      }
catch(Exception e){
       System.out.println(e);
    }
  }
}