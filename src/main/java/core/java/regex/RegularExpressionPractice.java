package core.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegularExpressionPractice {

    //    @Ignore
    @Test
    public void fetchTenantIdFromDn() {
	String dn = "CN%3Dmanju%40o1connect4.com%2COU%3Do1connect4%2COU%3DQANetworks%2CDC%3Doperativeone%2CDC%3Dcom";
	String ou = null;
	Pattern pattern = Pattern.compile("ou=(.*?),");
	Matcher matcher = pattern.matcher(dn.toLowerCase());

	if (matcher.find()) {
	    ou = matcher.group();
	}
	String result = ou.substring(3, ou.length() - 1);
	System.out.println(result);
    }
}
