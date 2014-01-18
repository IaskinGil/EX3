package il.ac.shenkar.ex3;

public class Task 
{
    private String description;
    private Long id;

    public Task(Long id, String description) 
    {
        this.description = description;
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    
    public String getDescription() 
    {
        return description;
    }

    public String toString()
    {
        return getDescription();
    }  
}