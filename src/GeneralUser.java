abstract public class GeneralUser {
    private String id;
    private String passWord;

    public GeneralUser(String id, String passWord) {
        this.id = id;
        this.passWord = passWord;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public void buy(String lib_id, String resource_id){
        if(this instanceof Manager){
            System.out.println("permission-denied");
            return;
        }
        boolean is_selling = false;
        int bought_count = 0, num=0;
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getSellingBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getSellingBooks().get(k).getId().equals(resource_id)){
                        is_selling = true;
                        num = Campus.getLibraries().get(i).getSellingBooks().get(k).getNumberOfCopies();
                        break;
                    }
                }
                for(int k=0; k<Campus.getLibraries().get(i).getBoughtBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getBoughtBooks().get(k).getId().equals(resource_id)){
                       bought_count ++;
                    }
                }
                break;
            }
        }
        if(!is_selling){
            System.out.println("not-allowed");
            return;
        }
        else if(bought_count == num){
            System.out.println("not-allowed");
            return;
        }
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getSellingBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getSellingBooks().get(k).getId().equals(resource_id)){

                        Campus.getLibraries().get(i).getBoughtBooks().add(Campus.getLibraries().get(i).getSellingBooks().get(k));
                        Campus.getLibraries().get(i).getSellingBooks().remove(k);
                        break;
                    }
                }
                break;
            }
        }
        System.out.println("success");
    }
    public void read(String user_id,String lib_id,String resource_id,String date,String time){
        if(!(this instanceof Professor)){
            System.out.println("permission-denied");
            return;
        }
        boolean is_ganjineh = false;
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getGanjinehBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getGanjinehBooks().get(k).getId().equals(resource_id)){
                        is_ganjineh = true;
                        break;
                    }
                }
                for(int k=0; k<Campus.getLibraries().get(i).getReadGanjinehBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getReadGanjinehBooks().get(k).getId().equals(resource_id)
                        && (Campus.getLibraries().get(i).getReadGanjinehBooks().get(k).getDateOfReading().equals(date)) ){
                        //someone is already reading this book that day
                        int thatTime = time_in_minute(Campus.getLibraries().get(i).getReadGanjinehBooks().get(k).getTimeOfReading());
                        int thisTime = time_in_minute(time);
                        if(Campus.getLibraries().get(i).getReadGanjinehBooks().get(k).getTimeOfReading().equals(time)
                            || ((thisTime>thatTime) && (thisTime<thatTime+120))
                             || ((thisTime<thatTime) && (thisTime+120>thatTime)) ){
                            //that person is still reading in the time (2-hour period) this person wants to read it
                            System.out.println("not-allowed");
                            return;
                        }
                        break;
                    }
                }
                break;
            }
        }
        if(!is_ganjineh){
            System.out.println("not-allowed");
            return;
        }
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getGanjinehBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getGanjinehBooks().get(k).getId().equals(resource_id)){

                        Campus.getLibraries().get(i).getGanjinehBooks().get(k).setDateOfReading(date);
                        Campus.getLibraries().get(i).getGanjinehBooks().get(k).setTimeOfReading(time);
                        Campus.getLibraries().get(i).getReadGanjinehBooks().add(Campus.getLibraries().get(i).getGanjinehBooks().get(k));
                        //then after 2 hours it should be removed from this list
                        break;
                    }
                }
                break;
            }
        }
        int returning_time = time_in_minute(time) + 120;
        String[] t = time.split(":");
        int hour = (returning_time - Integer.parseInt(t[1])) / 60;
        String return_time = hour + ":" + t[1];

        for(int i=0; i<Campus.getLibraryUsers().size(); i++){
            if(Campus.getLibraryUsers().get(i).getId().equals(user_id)){
                //returning it after 2 hours
                Campus.getLibraryUsers().get(i).returnResource(user_id,lib_id,resource_id,date,return_time);
                break;
            }
        }
        System.out.println("success");
    }
    private int time_in_minute(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1])); // minutes since 00:00
    }
}
