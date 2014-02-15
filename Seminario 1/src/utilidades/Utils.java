package utilidades;

public class Utils {

	public static String extractPageNameFromURLString(String urlString){
        if (urlString==null) return null;
        int lastSlash = urlString.lastIndexOf("/");
        //if (lastSlash==-1) lastSlash = 0;
        String pageAndExtensions = urlString.substring(lastSlash+1);
        int lastQuestion = pageAndExtensions.lastIndexOf("?");
        if (lastQuestion==-1) lastQuestion = pageAndExtensions.length();
        String result = pageAndExtensions.substring(0,lastQuestion);
        return result;
    }
}
