package P1;

public enum TraineeErrorCode {

    FIRST_NAME_ERROR("WRONG FIRST NAME"),
    SECOND_NAME_ERROR("WRONG SECOND NAME"),
    RATING_ERROR("RATING IS OUT OF 1-5 BOUNDS");

    private String msg;

    TraineeErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
