package com.springbatch.enviopromocoesemail.writer;

import org.springframework.batch.item.mail.SimpleMailMessageItemWriter;
import org.springframework.batch.item.mail.builder.SimpleMailMessageItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

@Configuration
public class EnviarEmailProdutoClienteWriterConfig {

	@Bean
	public SimpleMailMessageItemWriter enviarEmailProdutoClienteWriter(MailSender mailSender) {
		return new SimpleMailMessageItemWriterBuilder().mailSender(mailSender).build();
	}
}
