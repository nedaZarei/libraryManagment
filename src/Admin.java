public class Admin extends GeneralUser implements AddLibrary,AddCategory,AddStaff,AddStudent,AddManager,RemoveUser {

    public Admin(String id, String pass) {
        super(id, pass);
    }

    @Override
    public void addLibrary(Library library) {
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(library.getLibId())) {
                //if this library already exits in library array
                System.out.println("duplicate-id");
                return;
            }
        }
        Campus.getLibraries().add(library);
        System.out.println("success");
    }

    @Override
    public void addCategory(Category category) {

        for (int i = 0; i < Campus.getCategories().size(); i++) {
            if (Campus.getCategories().get(i).getCatId().equals(category.getCatId())) {
                System.out.println("duplicate-id");
                return;
            }
        }
        Campus.getCategories().add(category);
        System.out.println("success");
    }
    private static void adding_user(User user) {
        for (int i = 0; i < Campus.getUsers().size(); i++) {
            if (Campus.getUsers().get(i).getId().equals(user.getId())) {
                System.out.println("duplicate-id");
                return;
            }
        }
        Campus.getUsers().add(user);
        System.out.println("success");
    }

    @Override
    public void addStudent(Student student) {
        adding_user(student);
    }
    @Override
    public void addStaff(Staff staff) {
        adding_user(staff);
    }

    @Override
    public void addProfessor(Professor professor) {
       adding_user(professor);
    }

    @Override
    public void addManager(Manager manager, String lib_id) {
        for (int i = 0; i < Campus.getUsers().size(); i++) {
            if (Campus.getUsers().get(i).getId().equals(manager.getId())) {
                System.out.println("duplicate-id");
                return;
            }
        }
        for (int i = 0; i < Campus.getLibraries().size(); i++) {
            if (Campus.getLibraries().get(i).getLibId().equals(lib_id)) {
                Campus.getLibraries().get(i).getManagers().add(manager); //adding manager to a library he belongs to
                break;
            }
        }
        Campus.getUsers().add(manager);
        System.out.println("success");
    }
    @Override
    public void removeUser(String user_id){
        boolean user_is_borrowing = false;
        boolean user_has_penalty = false;
        for(int i=0; i<Campus.getLibraries().size(); i++){

            for(int k=0; k<Campus.getLibraries().get(i).getBorrowedBooks().size(); k++){

                if(Campus.getLibraries().get(i).getBorrowedBooks().get(k).getCostumer_id().equals(user_id)){
                    user_is_borrowing = true;
                    break;
                }
            }
            for(int k=0; k<Campus.getLibraries().get(i).getBorrowedTheses().size(); k++){
                if(Campus.getLibraries().get(i).getBorrowedTheses().get(k).getCostumer_id().equals(user_id)){
                    user_is_borrowing = true;
                    break;
                }
            }
            for(int k=0; k<Campus.getLibraries().get(i).getReturnedBooks().size(); k++){
                if(Campus.getLibraries().get(i).getReturnedBooks().get(k).getCostumer_id().equals(user_id)
                   &&(Campus.getLibraries().get(i).getReturnedBooks().get(k).getPenalty() != 0) ){
                    user_has_penalty = true;
                    break;
                }
            }
            for(int k=0; k<Campus.getLibraries().get(i).getReturnedTheses().size(); k++){
                if(Campus.getLibraries().get(i).getReturnedTheses().get(k).getCostumer_id().equals(user_id)
                        &&(Campus.getLibraries().get(i).getReturnedTheses().get(k).getPenalty() != 0) ){
                    user_has_penalty = true;
                    break;
                }
            }
        }
        if(user_is_borrowing || user_has_penalty){
            System.out.println("not-allowed");
            return;
        }
        else{
            for(int i=0; i<Campus.getUsers().size(); i++){
                if(Campus.getUsers().get(i).getId().equals(user_id)){
                    Campus.getUsers().remove(i);
                    break;
                }
            }
            System.out.println("success");
        }
    }
}
