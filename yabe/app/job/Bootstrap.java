package job;

import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {

	@Override
	public void doJob() throws Exception {
		System.out.println("Bootstrap 启动任务");
	}
	
}
