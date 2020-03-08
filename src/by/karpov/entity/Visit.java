package by.karpov.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Visit {
    private Long id;
    private LocalDate date;
    private Doctor doctor;
    private Patient patient;

    public Visit() {
    }

    public Visit(LocalDate date, Doctor doctor, Patient patient) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id) &&
                Objects.equals(date, visit.date) &&
                Objects.equals(doctor, visit.doctor) &&
                Objects.equals(patient, visit.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, doctor, patient);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date=" + date +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }

    public static class Builder {

        private Visit newVisit;

        public Builder() {
            newVisit = new Visit();
        }

        public Builder setId(Long id) {
            newVisit.setId(id);
            return this;
        }

        public Builder setDate(LocalDate date) {
            newVisit.setDate(date);
            return this;
        }

        public Builder setDoctor(Doctor doctor) {
            newVisit.setDoctor(doctor);
            return this;
        }

        public Builder setPatient(Patient patient) {
            newVisit.setPatient(patient);
            return this;
        }

        public Visit build() {
            return newVisit;
        }
    }
}
