package com.migibert.kheo.managed;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import io.dropwizard.lifecycle.Managed;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.migibert.kheo.jobs.GlobalConfigurationDiscoveryJob;

public class ManagedScheduler implements Managed {

	private Scheduler scheduler;
	private Logger logger = LoggerFactory.getLogger(ManagedScheduler.class);

	public ManagedScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public void start() throws Exception {
		scheduler.start();
	}

	@Override
	public void stop() throws Exception {
		scheduler.shutdown();
	}

	public void registerJob(String cronExpression) {
		JobDetail job = newJob(GlobalConfigurationDiscoveryJob.class).build();
		try {
			Trigger trigger = newTrigger().withSchedule(cronSchedule(cronExpression)).build();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public void scheduleDiscovery(String host, boolean firstDiscovery) {
	    JobDetail job = newJob(GlobalConfigurationDiscoveryJob.class).usingJobData("host", host).usingJobData("firstDiscovery", firstDiscovery).build();
        try {
            Trigger trigger = newTrigger().startNow().build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
	}

	public Scheduler getScheduler() {
		return scheduler;
	}
}
