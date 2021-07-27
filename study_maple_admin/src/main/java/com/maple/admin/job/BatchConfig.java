package com.maple.admin.job;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.configuration.BatchConfigurationException;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.MapJobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public class BatchConfig implements BatchConfigurer{

	private PlatformTransactionManager transactionManager;
    private JobRepository jobRepository;
    private JobLauncher jobLauncher;
    private JobExplorer jobExplorer;
	
	@Override
	public JobRepository getJobRepository() throws Exception {
		// TODO Auto-generated method stub
		return jobRepository;
	}

	@Override
	public PlatformTransactionManager getTransactionManager() throws Exception {
		// TODO Auto-generated method stub
		return transactionManager;
	}

	@Override
	public JobLauncher getJobLauncher() throws Exception {
		// TODO Auto-generated method stub
		return jobLauncher;
	}

	@Override
	public JobExplorer getJobExplorer() throws Exception {
		// TODO Auto-generated method stub
		return jobExplorer;
	}
	
	//의존성 주입이 이루어진후 초기화를 수행하는 메소드이다.
    @PostConstruct
    public void initialize() {
        //transactionManager define
        if (this.transactionManager == null) {
            this.transactionManager = new ResourcelessTransactionManager();
        }
        try {
            //jobRepository define
            //MapJobRepositoryFactoryBean -> using non-persistent in-memory DAO implementations 
            MapJobRepositoryFactoryBean jobRepositoryFactoryBean =
                    new MapJobRepositoryFactoryBean(this.transactionManager);
            jobRepositoryFactoryBean.afterPropertiesSet();
            this.jobRepository = jobRepositoryFactoryBean.getObject();

            //jobExplorer define
            MapJobExplorerFactoryBean jobExplorerFactoryBean =
                    new MapJobExplorerFactoryBean(jobRepositoryFactoryBean);
            jobExplorerFactoryBean.afterPropertiesSet();
            this.jobExplorer = jobExplorerFactoryBean.getObject();

            //jobLauncher define
            SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
            jobLauncher.setJobRepository(jobRepository);
            jobLauncher.afterPropertiesSet();
            this.jobLauncher = jobLauncher;
        } catch (Exception e) {
            throw new BatchConfigurationException(e);
        }
    }

	
}
