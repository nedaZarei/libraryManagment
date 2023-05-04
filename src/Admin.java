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
        //if upper category is not null,
        // this category should be added to that upper category's list of lower categories
        if(!category.getUpperCategoryId().equals("null")){

            for(int i=0; i<Campus.getCategories().size(); i++){
                if(Campus.getCategories().get(i).getCatId().equals(category.getUpperCategoryId())){
                    Campus.getCategories().get(i).getLowerCategories().add(category);
                    break;
                }
            }
        }
        System.out.println("success");
    }
    private static boolean adding_user(User user) {
        for (int i = 0; i < Campus.getUsers().size(); i++) {
            if (Campus.getUsers().get(i).getId().equals(user.getId())) {
                System.out.println("duplicate-id");
                return false;
            }
        }
        Campus.getUsers().add(user);
        System.out.println("success");
        return true;
    }

    @Override
    public void addStudent(Student student) {
       if(adding_user(student)){
           Campus.getLibraryUsers().add(student);
       }

    }
    @Override
    public void addStaff(Staff staff) {
        if(adding_user(staff)){
            Campus.getLibraryUsers().add(staff);
        }
    }

    @Override
    public void addProfessor(Professor professor) {
       if(adding_user(professor)){
           Campus.getLibraryUsers().add(professor);
       }
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

            for(int k=0; k<Campus.getLibraries().get(i).getBorrowedResources().size(); k++){

                if(Campus.getLibraries().get(i).getReturnedResources().get(k).getCostumer_id().equals(user_id)){
                    user_is_borrowing = true;
                    break;
                }
            }

            for(int k=0; k<Campus.getLibraries().get(i).getReturnedResources().size(); k++){
                if(Campus.getLibraries().get(i).getReturnedResources().get(k).getCostumer_id().equals(user_id)
                   &&(Campus.getLibraries().get(i).getReturnedResources().get(k).getPenalty() != 0) ){
                    user_has_penalty = true;
                    break;
                }
            }
        }
        if(user_is_borrowing || user_has_penalty){
            System.out.println("not-allowed");
        }
        else{
            for(int i=0; i<Campus.getUsers().size(); i++){
                if(Campus.getUsers().get(i).getId().equals(user_id)){
                    Campus.getUsers().remove(i);

                    if(Campus.getUsers().get(i) instanceof Student
                       || Campus.getUsers().get(i) instanceof Staff
                         || Campus.getUsers().get(i) instanceof Professor){

                        for(int k=0; k<Campus.getLibraryUsers().size(); k++){
                            if(Campus.getLibraryUsers().get(k).getId().equals(user_id)){
                                Campus.getLibraryUsers().remove(k);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            System.out.println("success");
        }
    }
    public void report_penalties_sum(){
        int sum = 0;
        for(int i=0; i<Campus.getLibraries().size(); i++){

            for(int k=0; k<Campus.getLibraries().get(i).getReturnedResources().size(); k++){
                sum += Campus.getLibraries().get(i).getReturnedResources().get(k).getPenalty();
            }
        }
        System.out.println(sum);
    }
}
