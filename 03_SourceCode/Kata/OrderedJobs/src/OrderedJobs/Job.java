package OrderedJobs;

public class Job implements Comparable{
    private String name;
    private Job dependsOn;

    public Job(String name, Job dependsOn) {
        this.name = name;
        this.dependsOn = dependsOn;
    }

    public Job(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public Job getDependsOn() {
        return this.dependsOn;
    }

    public void setDependsOn(Job dependsOn) {
        this.dependsOn = dependsOn;
    }

    @Override
    public String toString() {
        return name;
    }

    public int checkDependency()
    {
        if(dependsOn != null)
        {
            return dependsOn.checkDependency() + 1;
        }
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        Integer test = this.checkDependency();
        return test.compareTo(((Job) o).checkDependency());
    }
}
