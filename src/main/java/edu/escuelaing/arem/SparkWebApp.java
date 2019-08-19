package edu.escuelaing.arem;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
    
    
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculate mean and standard desviation</h2>"
                + "<form action=\"/results\">"
                + "  Enter the data with a space between them :<br>"
                + "  <br>"
                + "  <input type=\"text\" name=\"data\" value=\"5 5 5\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Calculate\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        App app=new App();
        LinkedList list = new LinkedList(); 
	String [] l=(req.queryParams("data")).split(" ");
	for (int i=0;i<l.length;i++){
            list.insert(list, Double.parseDouble(l[i]));
        }	
        return "The mean is: "+ app.mean(list) + " and the standard desviation is: " +
               app.standardDesviation(list);
    }
}
