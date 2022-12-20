package ru.mirea.lab10;

public class Student {
    public String Name,Surname,Profession;
    public int Kurs,Group,Scores;
    public Student(String Name,String Surname,String Profession,int Kurs,int Group,int Scores)
    {
        this.Group=Group;
        this.Kurs=Kurs;
        this.Name=Name;
        this.Profession=Profession;
        this.Surname=Surname;
        this.Scores=Scores;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setGroup(int group) {
        Group = group;
    }

    public void setKurs(int kurs) {
        Kurs = kurs;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public int getGroup() {
        return Group;
    }

    public int getKurs() {
        return Kurs;
    }

    public String getProfession() {
        return Profession;
    }

    public String getSurname() {
        return Surname;
    }

    public int getScores()
    {
        return Scores;
    }

    public void setScores(int scores)
    {
        Scores = scores;
    }

    @Override
    public String toString()
    {
        return getName()+" "+getSurname()+" "+getProfession()+" "+getKurs()+" "+getGroup()+" "+getScores();
    }
}

