package solution.programmers;

import java.util.*;
public class level2Test {

    static int basicTime;
    static int basicCost;
    static int per;
    static int perCost;

    static ArrayList<Record> carRecords = new ArrayList<>();
    static ArrayList<Integer> carNumberList = new ArrayList<>();

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] arr = solution(fees, records);

        for(int i = 0 ; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicCost = fees[1];
        per = fees[2];
        perCost = fees[3];

        for(int i = 0; i<records.length; i++){
            String[] arr = records[i].split(" ");
            String time = arr[0];
            String carNumber = arr[1];
            String flag = arr[2];

            int idx = carNumberList.indexOf(carNumber);

            if(idx==-1){
                if(flag.equals("IN")){
                    carRecords.add(new Record(carNumber, time, null));
                }else{
                    carRecords.add(new Record(carNumber, null, time));
                }
            }else{
                Record record = carRecords.get(idx);
                if(flag.equals("IN")){
                    record.inTime = time;
                }else{
                    record.outTime = time;
                }
            }
        }

        System.out.println(carRecords.size());

        Collections.sort( carRecords, (e1,e2)->{
            return Integer.parseInt(e1.carNumber)-Integer.parseInt(e2.carNumber);
        } );

        int[] answer = new int[carRecords.size()];

        for(int i = 0; i<carRecords.size(); i++){
            answer[i] = carRecords.get(i).getCost();
        }

        return answer;
    }

    static class Record{
        String carNumber;
        String inTime;
        String outTime;

        Record(String carNumber, String inTime, String outTime){
            this.carNumber = carNumber;
            this.inTime = inTime;
            this.outTime = outTime;
        }

        public int getCost(){
            if( outTime != null ){
                System.out.println(carNumber);
                System.out.println(inTime);
                System.out.println(outTime);
                String[] iTime = inTime.split(":");
                String[] oTime = outTime.split(":");

                int time = Integer.parseInt(oTime[0])*60+Integer.parseInt(oTime[1])
                        - (Integer.parseInt(iTime[0])*60+Integer.parseInt(iTime[1]));

                if(time < basicTime){
                    return basicCost;
                }
                return basicCost + (time/per)*perCost;
            }

            int endTime = 60*11+59;

            return basicCost + (endTime/per)*perCost;
        }
    }
}