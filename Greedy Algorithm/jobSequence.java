import java.util.*;

public class jobSequence {
    static class Job{
        int jobId;
        int deadline;
        int profit;

        Job(int jobId, int deadline, int profit){
            this.jobId=jobId;
            this.deadline=deadline;
            this.profit=profit;
        }
    }

    public static void main(String[] args) {
        int jobsinfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> j=new ArrayList<>();

        for(int i=0; i<jobsinfo.length; i++){
            j.add(new Job(i, jobsinfo[i][0], jobsinfo[i][1]));
        }

        Collections.sort(j, (a,b) -> b.profit-a.profit);

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;

        for(int i=0; i<j.size(); i++){
            if(j.get(i).deadline > time){
                seq.add(j.get(i).jobId);
                time++;
            }
        }

        for(int i=0; i<seq.size(); i++){
            System.out.print((char)(seq.get(i).intValue()+'a') + " ");
        }
    }
}
