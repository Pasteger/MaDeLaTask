package ru.pasteger.mdlt.MaDeLaTask.dto;

public class RequestOrganizationsListFilter {
    private String name;
    private String inn;
    private Boolean isActive;

    public RequestOrganizationsListFilter() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
