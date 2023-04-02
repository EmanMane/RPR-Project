package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * bean for tasks
 * @author Eman Alibalić
 */
public class Task implements Idable{

    private int id;
    private String title;
    private String content;
    private String forEmployee;

    public Task(String title) {
        this.title = title;
    }

    public Task() {}

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public String getForEmployee(){
        return forEmployee;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setForEmployee(String forEmployee){ this.forEmployee = forEmployee; }

    @Override
    public String toString(){
        return title;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, content, forEmployee);
    }
}