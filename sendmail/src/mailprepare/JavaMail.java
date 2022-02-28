package mailprepare;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import org.omg.CORBA.portable.OutputStream;

import com.sun.mail.util.MailConnectException;

public class JavaMail {
	public static void main(String[] args) throws Exception {
		
		Mailconfigure mailer = new Mailconfigure();
		mailer.emailNotify();

	}
	
}
