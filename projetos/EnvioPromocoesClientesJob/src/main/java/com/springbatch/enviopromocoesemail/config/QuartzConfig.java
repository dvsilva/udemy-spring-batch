package com.springbatch.enviopromocoesemail.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.enviopromocoesemail.job.EnvioPromocoesClientesScheduleJob;

@Configuration
public class QuartzConfig {
	
	@Bean
	public JobDetail quartzJobDetail() {
		return JobBuilder
				.newJob(EnvioPromocoesClientesScheduleJob.class) // referencia o ScheduleJob que executa o job de forma agendada
				.storeDurably() // manter os dados das execucoes agendadas para que nao se perda
				.build();
	}

	// gatilho de execucao [o que dispara a execucao do job]
	@Bean
	public Trigger jobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = 
				SimpleScheduleBuilder.simpleSchedule() // agendador simples
				.withIntervalInSeconds(60) // executa o job a cada 60 segundos
				.withRepeatCount(2); // dispara o gatilho 2 + 1 -> dispara 3 vezes
		
		return TriggerBuilder.newTrigger()
				.forJob(quartzJobDetail()) // quem vai utilizar o trigger e o quartzJobDetail
				.withSchedule(scheduleBuilder).build();
	}
}
