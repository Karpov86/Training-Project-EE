package by.karpov.entity;

import java.util.Objects;

public class Insurance {

    private Long id;
    private Person person;
    private String dateFrom;
    private String dateTo;

    public Insurance() {
    }

    public Insurance(Long id, Person person, String dateFrom, String dateTo) {
        this.id = id;
        this.person = person;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insurance insurance = (Insurance) o;
        return Objects.equals(id, insurance.id) &&
                Objects.equals(person, insurance.person) &&
                Objects.equals(dateFrom, insurance.dateFrom) &&
                Objects.equals(dateTo, insurance.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, dateFrom, dateTo);
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", person=" + person +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                '}';
    }

    public static class Builder {

        private Insurance newInsurance;

        public Builder() {
            newInsurance = new Insurance();
        }

        public Builder setId(Long id) {
            newInsurance.setId(id);
            return this;
        }

        public Builder setPerson(Person person) {
            newInsurance.setPerson(person);
            return this;
        }

        public Builder setDateFrom(String dateFrom) {
            newInsurance.setDateTo(dateFrom);
            return this;
        }

        public Builder setDateTo(String dateTo) {
            newInsurance.setDateTo(dateTo);
            return this;
        }

        public Insurance build() {
            return newInsurance;
        }
    }
}