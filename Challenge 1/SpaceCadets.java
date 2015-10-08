import java.net.*;
import java.io.*;
 
public class SpaceCadets {
 
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String emailId;
                try {
                        emailId = br.readLine();
                } catch (IOException ioe) {
                        System.err.println("There was an input error");
                        return;
                }
                String urlAddress = "http://www.ecs.soton.ac.uk/people/" + emailId;
                URL url = new URL(urlAddress);
                String searchedLine = null;
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String text = null;
                String searchedText = "</div></div><div class=\"vcard\"";
                while((text = reader.readLine()) != null){
                        if(text.contains(searchedText)){
                                break;
                        }
                }
                reader.close();
                if (text != null) {
                        text = text.substring(0, text.indexOf(searchedText));
                        text = text.substring(text.lastIndexOf(">") + 1, text.length());
                } else {
                        text = "Name not found. Make sure that the profile is public.";
                }
                System.out.println(text);
               
        }
 
}