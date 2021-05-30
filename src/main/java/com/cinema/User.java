package com.cinema;

public class User {
	private static final long serialVersionUID = -1280037900360314186L;
    private String name;
    private String email;
    private String password;
    private String type;
    
    public User()
    {
        super();
    }
    public User(String name, String email,  String password, String type)
    {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    } 
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    
    @Override
    public String toString()
    {
        return "User [name=" + name + ", email=" + email + ", password=" + password +", type=" + type + "]";
    }
}
