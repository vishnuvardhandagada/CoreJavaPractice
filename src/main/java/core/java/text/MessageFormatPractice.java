package core.java.text;

import java.text.MessageFormat;
import java.util.Date;

import org.junit.Test;

public class MessageFormatPractice {

	@Test
	public void method1() {
		String message = "Time is: {0, time},  Date is: {0, date} , Number is {1}";
		MessageFormat messageFormat = new MessageFormat(message);
		String formattedMessage = messageFormat.format(new Object[] { new Date(), 10 });
		System.out.println("MessageFormatPractice -> method1() -> formattedMessage: " + formattedMessage);
	}
}
