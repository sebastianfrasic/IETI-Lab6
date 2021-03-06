package edu.eci.ieti.lab6.entities;

import java.util.Date;
import java.util.Objects;

public class Task {

    private String description;
    private Responsible responsible;
    private String status;
    private Date dueDate;

    public Task(String description, Responsible responsible, String status, Date dueDate) {
        this.description = description;
        this.responsible = responsible;
        this.status = status;
        this.dueDate = dueDate;
    }

    public Task(String description, Responsible responsible, String status) {
        this.description = description;
        this.responsible = responsible;
        this.status = status;
    }

    public Task() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", responsible=" + responsible +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(description, task.description) &&
                Objects.equals(responsible, task.responsible) &&
                Objects.equals(status, task.status) &&
                Objects.equals(dueDate, task.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, responsible, status, dueDate);
    }
}
