
public class Manager extends User implements AddBook,AddThesis,AddGanginehBook,AddSellingBook,RemoveResource{

    public Manager(String id, String passWord,String firstName,String lastName,String nationalId,Integer birthYear,String address){
        super(id,passWord,firstName,lastName,nationalId,birthYear,address);
    }
    @Override
    public void addBook(Book book, String lib_id){
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getBooks().get(k).getId().equals(book.getId())){
                        System.out.println("duplicate-id");
                        return;
                    }
                }
                Campus.getLibraries().get(i).getBooks().add(book);
                System.out.println("success");
                break;
            }

        }
    }
    @Override
    public void addThesis(Thesis thesis, String lib_id){
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getTheses().size(); k++){
                    if(Campus.getLibraries().get(i).getTheses().get(k).getId().equals(thesis.getId())){
                        System.out.println("duplicate-id");
                        return;
                    }
                }
                Campus.getLibraries().get(i).getTheses().add(thesis);
                System.out.println("success");
                break;
            }
        }
    }
    @Override
    public void addGanjinehBook(GanjinehBook ganjinehBook, String lib_id){
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getGanjinehBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getGanjinehBooks().get(k).getId().equals(ganjinehBook.getId())){
                        System.out.println("duplicate-id");
                        return;
                    }
                }
                Campus.getLibraries().get(i).getGanjinehBooks().add(ganjinehBook);
                System.out.println("success");
                break;
            }
        }
    }
    @Override
    public void addSellingBook(SellingBook sellingBook, String lib_id){
        for(int i=0; i<Campus.getLibraries().size(); i++){
            if(Campus.getLibraries().get(i).getLibId().equals(lib_id)){

                for(int k=0; k<Campus.getLibraries().get(i).getSellingBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getSellingBooks().get(k).getId().equals(sellingBook.getId())){
                        System.out.println("duplicate-id");
                        return;
                    }
                }
                Campus.getLibraries().get(i).getSellingBooks().add(sellingBook);
                System.out.println("success");
                break;
            }
        }
    }
    @Override
    public void removeResource(String resource_id, String lib_id) {
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(lib_id)) {

                for (int k = 0; k < Campus.getLibraries().get(i).getBorrowedBooks().size(); k++) {
                    if (Campus.getLibraries().get(i).getBorrowedBooks().get(k).getItem_id().equals(resource_id)) {
                        System.out.println("not-allowed");
                        return;
                    }
                }
                for (int k = 0; k < Campus.getLibraries().get(i).getBorrowedTheses().size(); k++) {
                    if (Campus.getLibraries().get(i).getBorrowedTheses().get(k).getItem_id().equals(resource_id)) {
                        System.out.println("not-allowed");
                        return;
                    }
                }

                for(int k=0; k < Campus.getLibraries().get(i).getBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getBooks().get(k).getId().equals(resource_id)){
                       Campus.getLibraries().get(i).getBooks().remove(k);
                       return;
                    }
                }
                for(int k=0; k < Campus.getLibraries().get(i).getTheses().size(); k++){
                    if(Campus.getLibraries().get(i).getTheses().get(k).getId().equals(resource_id)){
                        Campus.getLibraries().get(i).getTheses().remove(k);
                        return;
                    }
                }
                for(int k=0; k < Campus.getLibraries().get(i).getGanjinehBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getGanjinehBooks().get(k).getId().equals(resource_id)){
                       Campus.getLibraries().get(i).getGanjinehBooks().remove(k);
                       return;
                    }
                }
                for(int k=0; k < Campus.getLibraries().get(i).getSellingBooks().size(); k++){
                    if(Campus.getLibraries().get(i).getSellingBooks().get(k).getId().equals(resource_id)){
                       Campus.getLibraries().get(i).getSellingBooks().remove(k);
                       return;
                    }
                }
                break;

            }
        }

    }

}
