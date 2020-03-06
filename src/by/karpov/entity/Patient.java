package by.karpov.entity;

import java.util.Objects;

public class Patient extends Person {

    private Insurance insurance;

    public Patient() {

    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(insurance, patient.insurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), insurance);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "insurance=" + insurance +
                '}';
    }

    public static class Builder {

        private Patient newPatient;

        public Builder() {
            newPatient = new Patient();
        }

        public Builder setId(Long id) {
            newPatient.setId(id);
            return this;
        }

        public Builder setName(String name) {
            newPatient.setName(name);
            return this;
        }

        public Builder setSurname(String surname) {
            newPatient.setSurname(surname);
            return this;
        }

        public Builder setAddress(String address) {
            newPatient.setAddress(address);
            return this;
        }

        public Builder setSex(Sex sex) {
            newPatient.setSex(sex);
            return this;
        }

        public Builder setInsurance(Insurance insurance) {
            newPatient.setInsurance(insurance);
            return this;
        }

        public Patient build() {
            return newPatient;
        }
    }
}
