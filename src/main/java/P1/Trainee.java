package P1;

import java.io.Serializable;

public class Trainee implements Serializable {
    private String firstName;
    private String secondName;
    private int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainee trainee = (Trainee) o;

        if (getRating() != trainee.getRating()) return false;
        if (getFirstName() != null ? !getFirstName().equals(trainee.getFirstName()) : trainee.getFirstName() != null)
            return false;
        return getSecondName() != null ? getSecondName().equals(trainee.getSecondName()) : trainee.getSecondName() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + getRating();
        return result;
    }

    public Trainee(String firstName, String secondName, int rating) throws TraineeException {
        if (null == firstName || firstName.isEmpty()) {
            throw new TraineeException(TraineeErrorCode.FIRST_NAME_ERROR);
        }
        if (null == secondName || secondName.isEmpty()) {
            throw new TraineeException(TraineeErrorCode.SECOND_NAME_ERROR);
        }
        if (null == secondName || secondName.isEmpty()) {
            throw new TraineeException(TraineeErrorCode.SECOND_NAME_ERROR);
        }
        if (1 > rating || 5 < rating) {
            throw new TraineeException(TraineeErrorCode.RATING_ERROR);
        }
        this.firstName = firstName;
        this.secondName = secondName;
        this.rating = rating;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws TraineeException {
        if (null == firstName || firstName.isEmpty()) {
            throw new TraineeException(TraineeErrorCode.FIRST_NAME_ERROR);
        }
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) throws TraineeException {
        if (null == secondName || secondName.isEmpty()) {
            throw new TraineeException(TraineeErrorCode.SECOND_NAME_ERROR);
        }
        this.secondName = secondName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws TraineeException {
        if (1 > rating || 5 < rating) {
            throw new TraineeException(TraineeErrorCode.RATING_ERROR);
        }
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
