package OrderedJobs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class OrderedJobs {

    private List<Job> jobs = new LinkedList<Job>();

    public void registerJob(String jobName)
    {
        if(!jobs.contains(jobName)) {
            jobs.add(new Job(jobName));
        }
    }

    public void registerJob(String dependent,String independent)
    {
        Job job = new Job(independent);
        if(!jobs.contains(job))
        {
            jobs.add(job);
        }

        Job job2 = new Job(dependent,job);
        if(!jobs.contains(job2))
        {
            jobs.add(job2);
        }
    }

    public void sort()
    {
        char[] arr = jobs.toCharArray();
        Arrays.sort(arr);
        jobs = new String(arr);
    }

    public String getList()
    {
        return jobs;
    }
}
