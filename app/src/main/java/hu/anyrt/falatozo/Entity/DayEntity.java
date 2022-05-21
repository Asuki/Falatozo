package hu.anyrt.falatozo.Entity;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class DayEntity {
    @Id
    Long id;
    String day;
    String date;
    Integer weekNumber;
    Boolean isSelected;

    public DayEntity(Long id, String day, String date, Integer weekNumber, Boolean isSelected) {
        this.id = id;
        this.day = day;
        this.date = date;
        this.weekNumber = weekNumber;
        this.isSelected = isSelected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
