package spring.mvc.mail;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class EmailService {
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	
	public boolean sendEmail(final Map<String, Object> model, String templateName) {
		
		boolean status = false;
		
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					
					
					MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMessage);
					
					msgHelper.setFrom(String.valueOf((model.get("from")) ));;
					msgHelper.setTo(String.valueOf(model.get("to")));
					msgHelper.setSubject(String.valueOf(model.get("subject")));
					msgHelper.setSentDate(new Date());
					
					List<String> bCCList = (List<String>) model.get("bccList");
					
					if (bCCList != null) {
						for (String bcc: bCCList) {
							msgHelper.addBcc(bcc);
						}
					}
					
					model.put("noArgs", new Object[]{});
					
					String text = VelocityEngineUtils.mergeTemplateIntoString(
							velocityEngine, templateName, 
							"UTF-8", model);
					
					msgHelper.setText(text, true);
					
				}
			};
			
			mailSender.send(preparator);
			status = true;
			return status;
			
		}catch (Exception e) {
			e.printStackTrace();
			return status;
		}
		
		
		
	}

}
