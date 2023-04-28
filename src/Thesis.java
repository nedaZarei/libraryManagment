public class Thesis extends Resource{
    private String professorName;
    private int defenceYear;

    public Thesis(String id, String title, String authorName, String category_id, String library_id, String professorName, int defenceYear) {
        super(id, title, authorName, category_id, library_id);
        this.professorName = professorName;
        this.defenceYear = defenceYear;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public int getDefenceYear() {
        return defenceYear;
    }

    public void setDefenceYear(int defenceYear) {
        this.defenceYear = defenceYear;
    }
}
