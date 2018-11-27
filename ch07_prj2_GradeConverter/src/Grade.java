public class Grade {

    private int number;
    private String letter;

    public Grade() {
        this.number = 0;
    }

    public Grade(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLetter(int numberGrade) {
        if (numberGrade >= 88) {
            letter = "A";
        } else if (numberGrade >= 80) {
            letter = "B";
        } else if (numberGrade >= 67) {
            letter = "C";
        } else if (numberGrade >= 60) {
            letter = "D";
        } else {
            letter = "F";
        }
        return letter;
    }

}
