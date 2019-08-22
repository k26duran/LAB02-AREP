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
                +"<head>"
                +"<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\"" 
                +"integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">" 
                +"</head>"
                + "<body>"
                + "<h2>Calculate mean and standard desviation</h2>"
                + "<form action=\"/results\">"
                + "  Enter the data with a space between them :<br>"
                + "  <br>"
                + "  <textarea class=\"form-control\" name=\"data\" placeholder=\"5 5 5\">5 5 5 </textarea>"
                + "  <br>"
                + "  <button class= \"btn btn-outline-primary\" type=\"submit\">Calculate</button>"
                + "</form>"
                +" <br>"
                + "<p><i>If you click the \"Calculate\" button, the form-data will be sent to a page called \"/results\".</i></p>"
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
        return " <h1>The mean is: "+ app.mean(list) + " and the standard desviation is: " +
               app.standardDesviation(list)+"</h1>";
    }
}
