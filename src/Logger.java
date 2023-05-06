import java.util.ArrayList;

public class Logger {
    private static ArrayList<String> borrows = new ArrayList<>();
    private static ArrayList<String> buys = new ArrayList<>();
    private Logger() {

    }
    public static void createObj(String result,String[] info){
        Logger logger = new Logger();
        switch (result) {
            case "NOT-FOUND":
                logger.not_found(info);
                break;
            case "INVALID-PASS":
                logger.invalid_pass(info);
                break;
            case "PERMISSION-DENIED":
                logger.permission_denied(info);
                break;
            case "NOT-ALLOWED":
                logger.not_allowed(info);
                break;
            case "DUPLICATE-ID":
                logger.duplicate_id(info);
            case "SUCCESS":
                logger.success(info);
                break;
        }

    }

    public static void setBorrows(ArrayList<String> borrows) {
        Logger.borrows = borrows;
    }

    public static void setBuys(ArrayList<String> buys) {
        Logger.buys = buys;
    }

    public static ArrayList<String> getBorrows() {
        return borrows;
    }
    public static ArrayList<String> getBuys() {
        return buys;
    }
    public void not_found(String[] info){
        switch (info[0]) {
            case "borrow":
                borrows.add("NOT-FOUND"+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]+" "+info[5]);
                break;
            case "buy" :
                buys.add("NOT-FOUND"+" "+info[1]+" "+info[2]+" "+info[3]);
                break;
        }
    }
    public void invalid_pass(String[] info){
        switch (info[0]) {
            case "borrow":
                borrows.add("INVALID-PASS"+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]+" "+info[5]);
                break;
            case "buy" :
                buys.add("INVALID-PASS"+" "+info[1]+" "+info[2]+" "+info[3]);
                break;
        }
    }
    public void permission_denied(String[] info){
        switch (info[0]) {
            case "borrow":
                borrows.add("PERMISSION-DENIED"+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]+" "+info[5]);
                break;
            case "buy" :
                buys.add("PERMISSION-DENIED"+" "+info[1]+" "+info[2]+" "+info[3]);
                break;
        }
    }
    public void not_allowed(String[] info){
        switch (info[0]) {
            case "borrow":
                borrows.add("NOT-ALLOWED"+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]+" "+info[5]);
                break;
            case "buy" :
                buys.add("NOT-ALLOWED"+" "+info[1]+" "+info[2]+" "+info[3]);
                break;
        }
    }
    public void duplicate_id(String[] info){
        switch (info[0]) {
            case "borrow":
                borrows.add("DUPLICATE-ID"+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]+" "+info[5]);
                break;
            case "buy" :
                buys.add("DUPLICATE-ID"+" "+info[1]+" "+info[2]+" "+info[3]);
                break;
        }
    }
    public void success(String[] info){
        switch (info[0]) {
            case "borrow":
                borrows.add("SUCCESS"+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]+" "+info[5]);
                break;
            case "buy" :
                buys.add("SUCCESS"+" "+info[1]+" "+info[2]+" "+info[3]);
                break;
        }
    }
}
