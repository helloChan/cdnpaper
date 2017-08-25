package top.cdnpaper.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月22日 下午9:15:01
 * @description 邮件工具类
 */
public class MailUtils {

	/**
	 * 工具类不允许实例化
	 */
	private MailUtils() {

	}

	public static void sendMail(String account, String password, String toAccount, String subject, String content,
			String... filePaths) {
		Properties prop = new Properties();
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.163.com");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.ssl.socketFactory", sf);
			Session session = Session.getInstance(prop);

			Message message = createMail(session, account, StringUtils.isBlank(toAccount) ? account : toAccount,
					subject, content, filePaths);
			Transport tp = session.getTransport();
			tp.connect(account, password);
			tp.sendMessage(message, message.getAllRecipients());
			tp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Message createMail(Session session, String account, 
			String toAccount, String subject, String content,
			String[] filePaths) throws AddressException, MessagingException, UnsupportedEncodingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(account));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAccount));
		
		MimeMultipart mm = new MimeMultipart();

		//创建文本的bodypart
		MimeBodyPart text = new MimeBodyPart();
		text.setContent(content, "text/html;charset=UTF-8");
		
		//创建带附件的bodypart
		if(filePaths!=null && filePaths.length>0){
			for(String filePath : filePaths){
				MimeBodyPart attach = new MimeBodyPart();
				DataHandler dh = new DataHandler(new FileDataSource(filePath));
				attach.setDataHandler(dh);
				attach.setFileName(MimeUtility.encodeText(dh.getName())); //设置附件名
				mm.addBodyPart(attach);
			}
			//两个bodypart没有关系 mixed
			mm.setSubType("mixed");
		}
		
		mm.addBodyPart(text);
		
		message.setSubject(StringUtils.isBlank(subject)?"":subject);
		message.setContent(mm);
		message.saveChanges();
		return message;
	}
	
	public static void main(String[] args) {
		String account = "y1067762513@163.com";
		String password = "57ying";
		String toAccount = "1036539739@qq.com";
		String subject = "你好，欢迎来到cdnpaper";
		String content = "hello, 欢迎来到cdnpaper~";
		String[] filePaths = {"C:\\Users\\Administrator\\Desktop\\组件聚焦和跳转.txt"};
		sendMail(account, password, toAccount, subject, content, filePaths);
	}

}
