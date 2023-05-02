import java.util.ArrayList;

abstract public class LibraryUser extends User {
    public LibraryUser(String id, String passWord, String firstName, String lastName, String nationalId, int birthYear, String address) {
        super(id, passWord, firstName, lastName, nationalId, birthYear, address);
    }

    public void borrow(String user_id, String lib_id, String resource_id, String date, String time) {
        int user_borrowing_count = 0;
        int resource_borrowed_count = 0;
        boolean is_book = false, is_thesis = false;
        int number = 0; //possible number of borrowing books or theses
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(lib_id)) {

                for (int k = 0; k < Campus.getLibraries().get(i).getBooks().size(); k++) {
                    if (Campus.getLibraries().get(i).getBooks().get(k).getId().equals(resource_id)) {
                        is_book = true;
                        break;
                    }
                }
                for (int k = 0; k < Campus.getLibraries().get(i).getTheses().size(); k++) {
                    if (Campus.getLibraries().get(i).getTheses().get(k).getId().equals(resource_id)) {
                        is_thesis = true;
                        break;
                    }
                }
                for (int k = 0; k < Campus.getLibraries().get(i).getBorrowedResources().size(); k++) {
                    if (Campus.getLibraries().get(i).getBorrowedResources().get(k).getCostumer_id().equals(user_id)) {
                        user_borrowing_count++;
                    }
                    if (Campus.getLibraries().get(i).getBorrowedResources().get(k).getItem_id().equals(resource_id)) {

                        if (Campus.getLibraries().get(i).getBorrowedResources().get(k).getCostumer_id().equals(user_id)) {
                            //this user has already borrowed this resource
                            System.out.println("not-allowed");
                            return;
                        }
                        resource_borrowed_count++;
                        if (Campus.getLibraries().get(i).getResources().get(k) instanceof Book) {
                            Book book = (Book) Campus.getLibraries().get(i).getResources().get(k);
                            number = book.getNumberOfCopies();
                        } else if (Campus.getLibraries().get(i).getResources().get(k) instanceof Thesis) {
                            number = 1;
                        }
                    }
                }
                for (int k = 0; k < Campus.getLibraries().get(i).getReturnedResources().size(); k++) {
                    if (Campus.getLibraries().get(i).getReturnedResources().get(k).getCostumer_id().equals(user_id)
                            && Campus.getLibraries().get(i).getReturnedResources().get(k).getPenalty() != 0) {
                        //this user did not return a resource on time
                        System.out.println("not-allowed");
                        return;
                    }
                }
                for (int k = 0; k < Campus.getLibraries().get(i).getGanjinehBooks().size(); k++) {
                    if (Campus.getLibraries().get(i).getGanjinehBooks().get(k).getId().equals(resource_id)) {
                        System.out.println("not-allowed");
                        return;
                    }
                }
                for (int k = 0; k < Campus.getLibraries().get(i).getSellingBooks().size(); k++) {
                    if (Campus.getLibraries().get(i).getSellingBooks().get(k).getId().equals(resource_id)) {
                        System.out.println("not-allowed");
                        return;
                    }
                }
                break;
            }
        }
        if (number == resource_borrowed_count) {
            System.out.println("not-allowed");
            return;
        }
        if (this instanceof Student) {
            if (user_borrowing_count == 3) {
                System.out.println("not-allowed");
                return;
            }
        } else if (this instanceof Staff) {
            if (user_borrowing_count == 5) {
                System.out.println("not-allowed");
                return;
            }
        }
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(lib_id)) {
                if(is_book){
                    BorrowedBook borrowedBook = new BorrowedBook(user_id,lib_id,resource_id,date,time);
                    Campus.getLibraries().get(i).getBorrowedResources().add(borrowedBook);
                    System.out.println("success");
                    return;
                }
                else if(is_thesis){
                    BorrowedThesis borrowedThesis = new BorrowedThesis(user_id,lib_id,resource_id,date,time);
                    Campus.getLibraries().get(i).getBorrowedResources().add(borrowedThesis);
                    System.out.println("success");
                    return;
                }
            }
            break;
        }
    }
    public void returnResource(String user_id, String lib_id, String resource_id, String return_date, String return_time){
        boolean has_borrowed = false;
        boolean is_student = false,is_staff = false;
       if(this instanceof Student){
           is_student = true;
       }
       else if(this instanceof Staff){
           is_staff = true;
       }
        int penalty = 0; // penalty money for late returning
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getBorrowedResources().size(); k++){
                    if(Campus.getLibraries().get(i).getBorrowedResources().get(k).getItem_id().equals(resource_id)
                        && Campus.getLibraries().get(i).getBorrowedResources().get(k).getCostumer_id().equals(user_id)){

                        has_borrowed = true;

                        if(Campus.getLibraries().get(i).getBorrowedResources().get(k) instanceof BorrowedBook){
                          penalty = calculate_penalty(Campus.getLibraries().get(i).getBorrowedResources().get(k),return_date,return_time,is_student,is_staff,10,14);
                          ReturnedBook returnedBook = new ReturnedBook(lib_id,resource_id,user_id,return_date,return_time,penalty);
                            Campus.getLibraries().get(i).getReturnedResources().add(returnedBook);
                        }
                        else if(Campus.getLibraries().get(i).getBorrowedResources().get(k) instanceof BorrowedThesis){
                            penalty = calculate_penalty(Campus.getLibraries().get(i).getBorrowedResources().get(k),return_date,return_time,is_student,is_staff,7,10);
                            ReturnedThesis returnedThesis = new ReturnedThesis(lib_id,resource_id,user_id,return_date,return_time,penalty);
                            Campus.getLibraries().get(i).getReturnedResources().add(returnedThesis);
                        }
                        // removing the returned recourse from borrowed resources
                        Campus.getLibraries().get(i).getBorrowedResources().remove(k);
                        break;
                    }
                }
                //for returning ganjineh book
                for(int k=0; k<Campus.getLibraries().get(i).getGanjinehBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getGanjinehBooks().get(k).getId().equals(resource_id)){
                        //removing it from ganjineh books that were being read
                        Campus.getLibraries().get(i).getReadGanjinehBooks().remove(Campus.getLibraries().get(i).getGanjinehBooks().get(k));
                        return;
                    }
                }
                break;
            }
        }
        if(!has_borrowed){
            System.out.println("not-found");
            return;
        }
        if(penalty != 0){
            System.out.println(penalty);
            return;
        }
        System.out.println("success");
    }
    private int calculate_penalty(BorrowedResource borrowedResource, String return_date, String return_time,boolean is_student,boolean is_staff,int std_num,int staff_num){
        int hour_difference = 0,day_difference =0;
        int penalty = 0; // penalty money for late returning
        int returning_time = time_in_minute(return_time);
        String borrow_date = borrowedResource.getDate_of_borrowing();
        String borrow_time = borrowedResource.getTime_of_borrowing();

        int borrowing_time = time_in_minute(borrow_time);
        int time_difference = time_difference_in_minute(borrow_time, return_time);
        int date_difference = date_difference_in_minute(borrow_date, return_date);

        if (borrow_time.equals(return_time)) {
            day_difference = date_difference / (24 * 60);
        } else {
            if (returning_time > borrowing_time) {
                day_difference = (time_difference + date_difference) / (24 * 60);
                hour_difference += time_difference / 60;
            } else if (returning_time < borrowing_time) {
                day_difference = (date_difference - time_difference) / (24 * 60);
                hour_difference -= time_difference / 60;
            }
        }
        hour_difference += day_difference * 24;

        if (is_student) {
            if (day_difference > std_num) {
                penalty += (hour_difference - 10 * 24) * 50;
            }
        } else if(is_staff) {
            if (day_difference > staff_num) {
                penalty += (hour_difference - 14 * 24) * 100;
            }
        }
        return penalty;
    }
    //////////////////////////////calculating time methods
    private int time_in_minute(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1])); // minutes since 00:00
    }

    private int date_in_minute(String date) {
        String[] d = date.split("-");
        return (Integer.parseInt(d[2]) * 24 * 60 + Integer.parseInt(d[1]) * 30 * 24 * 60 + Integer.parseInt(d[0]) * 365 * 30 * 24 * 60);
    }

    private int time_difference_in_minute(String time1, String time2) {
        int minutes1 = time_in_minute(time1);
        int minutes2 = time_in_minute(time2);
        return (minutes2 - minutes1);
    }

    private int date_difference_in_minute(String date1, String date2) {
        int minutes1 = date_in_minute(date1);
        int minutes2 = date_in_minute(date2);
        return (minutes2 - minutes1);
    }
    ////////////////////////////////////////////////////////
}
