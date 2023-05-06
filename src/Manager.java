import java.util.*;

public class Manager extends User implements AddBook,AddThesis,AddGanginehBook,AddSellingBook,RemoveResource{

    public Manager(String id, String passWord,String firstName,String lastName,String nationalId,Integer birthYear,String address){
        super(id,passWord,firstName,lastName,nationalId,birthYear,address);
    }
    private boolean is_duplicate_id(String resource_id,String lib_id){
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getResources().size(); k++){
                    if(Campus.getLibraries().get(i).getResources().get(k).getId().equals(resource_id)){
                        System.out.println("duplicate-id");
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
    @Override
    public void addBook(Book book, String lib_id){

        if(!is_duplicate_id(book.getId(), lib_id)){
            for(int i=0; i<Campus.getLibraries().size(); i++){
                if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                    Campus.getLibraries().get(i).getBooks().add(book);
                    Campus.getLibraries().get(i).getResources().add(book);
                    System.out.println("success");
                    break;
                }
            }
        }
    }
    @Override
    public void addThesis(Thesis thesis, String lib_id){
        if(!is_duplicate_id(thesis.getId(), lib_id)){
            for(int i=0; i<Campus.getLibraries().size(); i++){
                if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                    Campus.getLibraries().get(i).getTheses().add(thesis);
                    Campus.getLibraries().get(i).getResources().add(thesis);
                    System.out.println("success");
                    break;
                }
            }
        }
    }
    @Override
    public void addGanjinehBook(GanjinehBook ganjinehBook, String lib_id){
       if(!is_duplicate_id(ganjinehBook.getId(),lib_id)){
           for(int i=0; i<Campus.getLibraries().size(); i++){
               if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                   Campus.getLibraries().get(i).getGanjinehBooks().add(ganjinehBook);
                   Campus.getLibraries().get(i).getResources().add(ganjinehBook);
                   System.out.println("success");
                   break;
               }
           }
       }
    }
    @Override
    public void addSellingBook(SellingBook sellingBook, String lib_id){
        if(!is_duplicate_id(sellingBook.getId(), lib_id)){
            for(int i=0; i<Campus.getLibraries().size(); i++){
                if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                    Campus.getLibraries().get(i).getSellingBooks().add(sellingBook);
                    Campus.getLibraries().get(i).getResources().add(sellingBook);
                    System.out.println("success");
                    break;
                }
            }
        }
    }
    @Override
    public void removeResource(String resource_id, String lib_id) {
        boolean resource_is_found = false;
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){
                for(int k=0; k<Campus.getLibraries().get(i).getResources().size(); k++){
                    if(Campus.getLibraries().get(i).getResources().get(k).getId().equals(resource_id)){
                        resource_is_found = true;
                        break;
                    }
                }
            }
        }
        if(!resource_is_found){
            System.out.println("not-found");
            return;
        }
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(lib_id)) {

                for (int k = 0; k < Campus.getLibraries().get(i).getBorrowedResources().size(); k++) {
                    if (Campus.getLibraries().get(i).getBorrowedResources().get(k).getItem_id().equals(resource_id)) {
                        System.out.println("not-allowed");
                        return;
                    }
                }
                for (int s = 0; s < Campus.getLibraries().get(i).getResources().size(); s++) {
                    if (Campus.getLibraries().get(i).getResources().get(s).getId().equals(resource_id)) {

                        if(Campus.getLibraries().get(i).getResources().get(s) instanceof Book){
                            for(int k=0; k < Campus.getLibraries().get(i).getBooks().size(); k++){
                                if(Campus.getLibraries().get(i).getBooks().get(k).getId().equals(resource_id)){
                                    Campus.getLibraries().get(i).getBooks().remove(k);
                                    break;
                                }
                            }
                        }
                        else if(Campus.getLibraries().get(i).getResources().get(s) instanceof Thesis){
                            for(int k=0; k < Campus.getLibraries().get(i).getTheses().size(); k++){
                                if(Campus.getLibraries().get(i).getTheses().get(k).getId().equals(resource_id)){
                                    Campus.getLibraries().get(i).getTheses().remove(k);
                                    break;
                                }
                            }
                        }
                        else if(Campus.getLibraries().get(i).getResources().get(s) instanceof GanjinehBook){
                            for(int k=0; k < Campus.getLibraries().get(i).getGanjinehBooks().size(); k++){
                                if(Campus.getLibraries().get(i).getGanjinehBooks().get(k).getId().equals(resource_id)){
                                    Campus.getLibraries().get(i).getGanjinehBooks().remove(k);
                                    break;
                                }
                            }
                        }
                        else if(Campus.getLibraries().get(i).getResources().get(s) instanceof SellingBook){
                            for(int k=0; k < Campus.getLibraries().get(i).getSellingBooks().size(); k++){
                                if(Campus.getLibraries().get(i).getSellingBooks().get(k).getId().equals(resource_id)){
                                    Campus.getLibraries().get(i).getSellingBooks().remove(k);
                                    break;
                                }
                            }
                        }
                        Campus.getLibraries().get(i).getResources().remove(s);
                        break;
                    }
                }
                break;
            }
        }
        System.out.println("success");
    }
    static int book_count = 0, thesis_count= 0, ganjineh_count=0, selling_count=0;
    public void categoryReport(String cat_id, String lib_id){
        boolean is_null = false;
        if(cat_id.equals("null")){
            is_null = true;
        }
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getResources().size(); k++){

                    if(is_null && Campus.getLibraries().get(i).getResources().get(k).getCategory_id().equals("null")){
                        if((Campus.getLibraries().get(i).getResources().get(k) instanceof Book)
                                && !(Campus.getLibraries().get(i).getResources().get(k) instanceof SellingBook)){
                            book_count += ((Book) Campus.getLibraries().get(i).getResources().get(k)).getNumberOfCopies();
                        }
                        else if(Campus.getLibraries().get(i).getResources().get(k) instanceof Thesis){
                            thesis_count += 1;
                        }
                        else if(Campus.getLibraries().get(i).getResources().get(k) instanceof GanjinehBook){
                            ganjineh_count += 1;
                        }
                        else if(Campus.getLibraries().get(i).getResources().get(k) instanceof SellingBook){
                            selling_count += ((SellingBook) Campus.getLibraries().get(i).getResources().get(k)).getNumberOfCopies();
                        }
                    }
                    else if((!is_null) && (!Campus.getLibraries().get(i).getResources().get(k).getCategory_id().equals("null"))){

                        if((Campus.getLibraries().get(i).getResources().get(k) instanceof Book)
                                && !(Campus.getLibraries().get(i).getResources().get(k) instanceof SellingBook)){
                            Book book = (Book) Campus.getLibraries().get(i).getResources().get(k);

                                if(book.getCategory_id().equals(cat_id)){
                                    book_count += book.getNumberOfCopies();
                                }
                                count_for_lower_categories(cat_id,Campus.getLibraries().get(i));

                        }
                        else if(Campus.getLibraries().get(i).getResources().get(k) instanceof Thesis){
                            Thesis thesis = (Thesis) Campus.getLibraries().get(i).getResources().get(k);

                                if(thesis.getCategory_id().equals(cat_id)){
                                    thesis_count += 1;
                                }
                                count_for_lower_categories(cat_id,Campus.getLibraries().get(i));

                        }
                        else if(Campus.getLibraries().get(i).getResources().get(k) instanceof GanjinehBook){
                            GanjinehBook ganjinehBook = (GanjinehBook) Campus.getLibraries().get(i).getResources().get(k);

                                if(ganjinehBook.getCategory_id().equals(cat_id)){
                                    ganjineh_count += 1;
                                }
                                count_for_lower_categories(cat_id,Campus.getLibraries().get(i));

                        }
                        else if(Campus.getLibraries().get(i).getResources().get(k) instanceof SellingBook){
                            SellingBook sellingBook = (SellingBook)  Campus.getLibraries().get(i).getResources().get(k);

                                if(sellingBook.getCategory_id().equals(cat_id)){
                                    selling_count += sellingBook.getNumberOfCopies();
                                }
                                count_for_lower_categories(cat_id,Campus.getLibraries().get(i));
                        }

                    }
                }
                break;
            }
        }
        System.out.printf("%d %d %d %d\n",book_count,thesis_count,ganjineh_count,selling_count);
    }
    private static void count_for_lower_categories(String cat_id,Library library){
        //adding number of resources in lower categories of this category (if it has any)
        for(int j=0; j<Campus.getCategories().size(); j++){
            if(Campus.getCategories().get(j).getCatId().equals(cat_id)){
                if(Campus.getCategories().get(j).getLowerCategories().size() != 0 ){

                    for(int q=0; q<Campus.getCategories().get(j).getLowerCategories().size(); q++){

                        for(int p=0; p<library.getResources().size(); p++){
                            if(library.getResources().get(p).getCategory_id().equals(Campus.getCategories().get(j).getLowerCategories().get(q).getCatId())){

                                if((library.getResources().get(p) instanceof Book)
                                        && !(library.getResources().get(p) instanceof SellingBook)){
                                    book_count += ((Book) library.getResources().get(p)).getNumberOfCopies();
                                }
                                else if(library.getResources().get(p) instanceof Thesis){
                                    thesis_count += 1;
                                }
                                else if(library.getResources().get(p) instanceof GanjinehBook){
                                    ganjineh_count += 1;
                                }
                                else if(library.getResources().get(p) instanceof SellingBook){
                                    selling_count += ((SellingBook) library.getResources().get(p)).getNumberOfCopies();
                                }
                            }
                        }
                    }
                }
                break;
            }
        }
    }
    public void libraryReport(String lib_id){
        int book_count = 0,thesis_count=0,borrowed_book_count=0,borrowed_thesis_count=0,ganjineh_count=0,selling_count=0;
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getResources().size(); k++){

                    if(Campus.getLibraries().get(i).getResources().get(k) instanceof Book){
                        Book book = (Book) Campus.getLibraries().get(i).getResources().get(k);
                        book_count += book.getNumberOfCopies();
                    }
                    else if(Campus.getLibraries().get(i).getResources().get(k) instanceof Thesis){
                        thesis_count += 1;
                    }
                    else if(Campus.getLibraries().get(i).getResources().get(k) instanceof GanjinehBook){
                        ganjineh_count += 1;
                    }
                    else if(Campus.getLibraries().get(i).getResources().get(k) instanceof SellingBook){
                        SellingBook sellingBook = (SellingBook) Campus.getLibraries().get(i).getResources().get(k);
                        selling_count += sellingBook.getNumberOfCopies();
                    }
                }
                for(int k=0; k<Campus.getLibraries().get(i).getBorrowedResources().size(); k++){

                    if(Campus.getLibraries().get(i).getBorrowedResources().get(k) instanceof BorrowedBook){
                        borrowed_book_count += 1;
                    }
                    else if(Campus.getLibraries().get(i).getBorrowedResources().get(k) instanceof BorrowedThesis){
                        borrowed_thesis_count += 1;
                    }
                }
                break;
            }
        }
        System.out.printf("%d %d %d %d %d %d\n",book_count,thesis_count,borrowed_book_count,borrowed_thesis_count,ganjineh_count,selling_count);
    }
    public void reportPassedDeadline(String lib_id,String check_date,String check_time){
        LinkedHashSet<String> passed_deadline_items = new LinkedHashSet<>();//keeps the order of insertion but doesn't allow duplicates
        String user_id;
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getBorrowedResources().size(); k++){

                    if(Campus.getLibraries().get(i).getBorrowedResources().get(k) instanceof BorrowedBook){
                        BorrowedBook borrowedBook = (BorrowedBook) Campus.getLibraries().get(i).getBorrowedResources().get(k);
                        user_id = borrowedBook.getCostumer_id();

                        if(what_lib_user(user_id).equals("student")){
                            if(hour_diff(borrowedBook,check_date,check_time) > (10*24)){
                                passed_deadline_items.add(borrowedBook.getItem_id());
                            }
                        }
                        else if(what_lib_user(user_id).equals("staff")){
                            if(hour_diff(borrowedBook,check_date,check_time) > (14*24)){
                                passed_deadline_items.add(borrowedBook.getItem_id());
                            }
                        }
                    }
                    else if(Campus.getLibraries().get(i).getBorrowedResources().get(k) instanceof BorrowedThesis){
                        BorrowedThesis borrowedThesis = (BorrowedThesis) Campus.getLibraries().get(i).getBorrowedResources().get(k);
                        user_id = borrowedThesis.getCostumer_id();

                        if(what_lib_user(user_id).equals("student")){
                            if(hour_diff(borrowedThesis,check_date,check_time) > (7*24)){
                                passed_deadline_items.add(borrowedThesis.getItem_id());
                            }
                        }
                        else if(what_lib_user(user_id).equals("staff")){
                            if(hour_diff(borrowedThesis,check_date,check_time) > (10*24)){
                                passed_deadline_items.add(borrowedThesis.getItem_id());
                            }
                        }
                    }
                }
                break;
            }
        }
        if (passed_deadline_items.size() == 0){
            System.out.println("none");
            return;
        }
        Iterator<String> iterate = passed_deadline_items.iterator();
        while (iterate.hasNext()) {
            System.out.print(iterate.next());
            if (iterate.hasNext()) {
                System.out.print("|");
            }
        }
        System.out.print("\n");
    }
    private String what_lib_user(String user_id){
        for(int i=0; i<Campus.getLibraryUsers().size(); i++){
            if(Campus.getLibraryUsers().get(i).getId().equals(user_id)){
                if(Campus.getLibraryUsers().get(i) instanceof Student){
                    return "student";
                }
                else if(Campus.getLibraryUsers().get(i) instanceof Staff
                         || Campus.getLibraryUsers().get(i) instanceof Professor){
                    return "staff";
                }
            }
        }
        return "";
    }
    private int hour_diff(BorrowedResource borrowedResource,String check_date,String check_time){
        int day_difference = 0;
        int hour_difference = 0;
        String borrow_date = borrowedResource.getDate_of_borrowing();
        String borrow_time = borrowedResource.getTime_of_borrowing();
        int checking_time = time_in_minute(check_time);
        int borrowing_time = time_in_minute(borrow_time);
        int time_difference = time_difference_in_minute(borrow_time, check_time);
        int date_difference = date_difference_in_minute(borrow_date, check_date);

        if (borrow_time.equals(check_time)) {
            day_difference = date_difference / (24 * 60);
        } else {
            if (checking_time > borrowing_time) {
                day_difference = (time_difference + date_difference) / (24 * 60);
                hour_difference+=time_difference/60;

            } else if (checking_time < borrowing_time) {
                day_difference = (date_difference - time_difference) / (24 * 60);
                hour_difference-=time_difference/60;
            }
        }
        hour_difference += day_difference * 24;
        return hour_difference;
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
//    public void reportMostPopular(String lib_id){
//        ArrayList<String> book_ids = new ArrayList<>();
//        ArrayList<String> thesis_ids = new ArrayList<>();
//        ArrayList<String> book_periods = new ArrayList<>();
//        ArrayList<String> thesis_periods = new ArrayList<>();
//       int period_of_borrowing = 0;
//
//        for(int i=0; i<Logger.getBorrows().size(); i++){
//                String[] parts = Logger.getBorrows().get(i).split(" ");
//
//                if(parts[0].equals("SUCCESS") && parts[5].equals(lib_id)){
//
//                    for(int k=0;k<Campus.getLibraries().size(); k++){
//                        if(Campus.getLibraries().get(k).getLibId().equals(lib_id)){
//
//                            for(int p=0; p<Campus.getLibraries().get(k).getBorrowedResources().size(); p++){
//                                if(Campus.getLibraries().get(k).getBorrowedResources().get(p).getItem_id().equals(parts[4])){
//
//                                    if(Campus.getLibraries().get(k).getBorrowedResources().get(p) instanceof BorrowedBook){
//                                        book_ids.add(parts[4]);
//                                       period_of_borrowing = hour_difference(Campus.getLibraries().get(k).getBorrowedResources().get(p),Campus.getLibraries().get(k),parts[4]);
//                                        book_periods.add(parts[4]+" "+period_of_borrowing);
//                                    }
//                                    else if(Campus.getLibraries().get(k).getBorrowedResources().get(p) instanceof BorrowedThesis){
//                                       thesis_ids.add(parts[4]);
//                                        period_of_borrowing = hour_difference(Campus.getLibraries().get(k).getBorrowedResources().get(p),Campus.getLibraries().get(k),parts[4]);
//                                        thesis_periods.add(parts[4]+" "+period_of_borrowing);
//                                    }
//                                }
//                            }
//                            break;
//                        }
//                    }
//                }
//        }
//        int most_book_count = most_frequent_count(book_ids);
//        int most_thesis_count = most_frequent_count(thesis_ids);
//        String book_id = most_frequent_id(book_ids);
//        String thesis_id = most_frequent_id(thesis_ids);
//
//        for(int i=0;i<book_periods.size(); i++){
//            String[] parts1 = book_periods.get(i).split(" ");
//            String id = parts1[0];
//            int time = Integer.parseInt(parts1[1]);
//            for(int j=i+1; j<book_periods.size(); j++){
//                String[] parts2 = book_periods.get(i).split(" ");
//                if(id.equals(parts2[0])){
//                    if(time <  Integer.parseInt(parts2[1])){
//                        time =  Integer.parseInt(parts2[1]);
//                    }
//                }
//            }
//        }
//    }
//    private int hour_difference(BorrowedResource borrowedResource, Library library,String id){
//        String return_time="",return_date="";
//        int day_difference =0,hour_difference=0;
//        String borrow_date = borrowedResource.getDate_of_borrowing();
//        String borrow_time = borrowedResource.getTime_of_borrowing();
//
//        for(int f=0; f<library.getReturnedResources().size(); f++){
//            if(library.getReturnedResources().get(f).getId().equals(id)){
//                return_date = library.getReturnedResources().get(f).getDate();
//                return_time = library.getReturnedResources().get(f).getTime();
//                break;
//            }
//        }
//        int returning_time = time_in_minute(return_time);
//        int borrowing_time = time_in_minute(borrow_time);
//        int time_difference = time_difference_in_minute(borrow_time, return_time);
//        int date_difference = date_difference_in_minute(borrow_date, return_date);
//        if (borrow_time.equals(return_time)) {
//            day_difference = date_difference / (24 * 60);
//        } else {
//            if (returning_time > borrowing_time) {
//                day_difference = (time_difference + date_difference) / (24 * 60);
//                hour_difference+=time_difference/60;
//
//            } else if (returning_time < borrowing_time) {
//                day_difference = (date_difference - time_difference) / (24 * 60);
//                hour_difference-=time_difference/60;
//            }
//        }
//        hour_difference += day_difference * 24;
//        return hour_difference;
//    }
//    private int most_frequent_count(ArrayList<String> list){
//        int max_count = 1;
//        for(int i=0; i<list.size(); i++){
//            int count =1;
//            for(int j=i+1; j<list.size(); j++){
//                if(list.get(i).equals(list.get(j))){
//                    count++;
//                }
//                if(max_count < count){
//                    max_count = count;
//                }
//            }
//        }
//        return max_count;
//    }
//    private String most_frequent_id(ArrayList<String> list){
//        String most = list.get(0);
//        int count =0;
//        for(int i=0; i<list.size(); i++){
//            int cnt =0;
//            for(int j=i+1; j<list.size(); j++){
//                if(list.get(i).equals(list.get(j))){
//                    cnt++;
//                }
//            }
//            if(count < cnt){
//                most = list.get(i);
//                count = cnt;
//            }
//        }
//        return most;
//    }
//    public void reportSell(String lib_id){
//
//    }
}
