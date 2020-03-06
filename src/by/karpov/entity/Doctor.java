package by.karpov.entity;

import java.util.Objects;

public class Doctor extends Person {

    private int workExperience;
    private Specialty specialty;

    public Doctor() {

    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return workExperience == doctor.workExperience &&
                specialty == doctor.specialty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workExperience, specialty);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "workExperience=" + workExperience +
                ", specialty=" + specialty +
                '}';
    }

    public static class Builder {
        private Doctor newDoctor;

        public Builder() {
            newDoctor = new Doctor();
        }

        public Builder setId(Long id) {
            newDoctor.setId(id);
            return this;
        }

        public Builder setName(String name) {
            newDoctor.setName(name);
            return this;
        }

        public Builder setSurname(String surame) {
            newDoctor.setSurname(surame);
            return this;
        }

        public Builder setAddress(String address) {
            newDoctor.setAddress(address);
            return this;
        }

        public Builder setSex(Sex sex) {
            newDoctor.setSex(sex);
            return this;
        }

        public Builder setWorkExperience(int workExperience) {
            newDoctor.workExperience = workExperience;
            return this;
        }

        public Builder setSpecialty(Specialty specialty) {
            newDoctor.specialty = specialty;
            return this;
        }

        public Doctor build() {
            return newDoctor;
        }
    }
}
